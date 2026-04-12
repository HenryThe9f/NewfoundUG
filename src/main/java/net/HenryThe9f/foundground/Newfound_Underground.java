package net.HenryThe9f.foundground;

import com.mojang.logging.LogUtils;
import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.entity.ModBlockEntities;
import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.entity.client.GnomeRenderer;
import net.HenryThe9f.foundground.entity.client.RogerfishRenderer;
import net.HenryThe9f.foundground.entity.client.WhelpRenderer;
import net.HenryThe9f.foundground.entity.custom.GoldSporeEntity;
import net.HenryThe9f.foundground.entity.custom.WhelpTorchEntity;
import net.HenryThe9f.foundground.item.ModCreativeModeTabs;
import net.HenryThe9f.foundground.item.Moditems;
import net.HenryThe9f.foundground.item.custom.GasBottleItem;
import net.HenryThe9f.foundground.sound.ModSounds;
import net.HenryThe9f.foundground.worldgen.biome.ModBiomes;
import net.HenryThe9f.foundground.worldgen.biome.surface.ModSurfaceRuleData;
import net.HenryThe9f.foundground.worldgen.biome.ModTerrablender;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.TntRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Newfound_Underground.MODID)
public class Newfound_Underground
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "foundground";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public Newfound_Underground()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);
        Moditems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModSounds.register(modEventBus);
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
       // ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ModTerrablender.registerBiomes();

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRuleData.makeRules());

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CYAN_MUSHROOM.getId(), ModBlocks.POTTED_CYAN_MUSHROOM);


        });
        BrewingRecipeRegistry.isValidIngredient(new ItemStack(Moditems.COAL_DUST_BOTTLE.get()));
        BrewingRecipeRegistry.isValidIngredient(new ItemStack(Moditems.SULPHUR_DUST_BOTTLE.get()));
        BrewingRecipeRegistry.isValidIngredient(new ItemStack(Moditems.SULPHUR.get()));


        BrewingRecipeRegistry.addRecipe(Ingredient.of(Items.GLASS_BOTTLE), Ingredient.of(Items.COAL), new ItemStack(Moditems.COAL_DUST_BOTTLE.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.of(Items.GLASS_BOTTLE), Ingredient.of(Moditems.SULPHUR.get()), new ItemStack(Moditems.SULPHUR_DUST_BOTTLE.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.of(Items.CHARCOAL), Ingredient.of(Moditems.SULPHUR.get()), new ItemStack(Items.GUNPOWDER));
        BrewingRecipeRegistry.addRecipe(Ingredient.of(Items.COPPER_INGOT), Ingredient.of(Moditems.SULPHUR.get()), new ItemStack(Items.REDSTONE));
        BrewingRecipeRegistry.addRecipe(Ingredient.of(Items.GLOW_BERRIES), Ingredient.of(Moditems.SULPHUR.get()), new ItemStack(Items.GLOWSTONE_DUST));




        DispenserBlock.registerBehavior(Moditems.COAL_DUST_BOTTLE.get(), new OptionalDispenseItemBehavior() {
            protected ItemStack execute(BlockSource pSource, ItemStack itemStack) {
                this.setSuccess(false);
                Direction $$3 = (Direction)pSource.getBlockState().getValue(DispenserBlock.FACING);
                BlockPos $$4 = pSource.getPos().relative($$3);
                Level pLevel = pSource.getLevel();

                if(pLevel.isEmptyBlock($$4) && !pLevel.isClientSide && pLevel.isEmptyBlock($$4.relative($$3))) {
                    pLevel.setBlockAndUpdate($$4, ModBlocks.COAL_DUST.get().defaultBlockState());
                    for(int j = 0; j<9; j++){
                        if(((DispenserBlockEntity) pSource.getEntity()).getItem(j).isEmpty()){
                            ((DispenserBlockEntity) pSource.getEntity()).addItem(new ItemStack(Items.GLASS_BOTTLE));
                            break;
                        } else if(((DispenserBlockEntity) pSource.getEntity()).getItem(j).is(Items.GLASS_BOTTLE) && ((DispenserBlockEntity) pSource.getEntity()).getItem(j).getCount() < 64){
                            ((DispenserBlockEntity) pSource.getEntity()).getItem(j).setCount(((DispenserBlockEntity) pSource.getEntity()).getItem(j).getCount()+1);
                            break;
                        } else if(j==8){
                            pLevel.addFreshEntity(new ItemEntity(pLevel, $$4.getX(), $$4.getY(), $$4.getZ(), new ItemStack(Items.GLASS_BOTTLE)));
                        }

                    }
                    ItemStack stackCopy = itemStack.copy();
                    stackCopy.shrink(1);
                    return stackCopy;
                }
                return itemStack;

            }
        });
        DispenserBlock.registerBehavior(Moditems.SULPHUR_DUST_BOTTLE.get(), new OptionalDispenseItemBehavior() {
            protected ItemStack execute(BlockSource pSource, ItemStack itemStack) {
                this.setSuccess(false);
                Direction $$3 = (Direction)pSource.getBlockState().getValue(DispenserBlock.FACING);
                BlockPos $$4 = pSource.getPos().relative($$3);
                Level pLevel = pSource.getLevel();

                if(pLevel.isEmptyBlock($$4) && !pLevel.isClientSide && pLevel.isEmptyBlock($$4.relative($$3))) {
                    pLevel.setBlockAndUpdate($$4, ModBlocks.SULPHUR_DUST.get().defaultBlockState());
                    for(int j = 0; j<9; j++){
                        if(((DispenserBlockEntity) pSource.getEntity()).getItem(j).isEmpty()){
                            ((DispenserBlockEntity) pSource.getEntity()).addItem(new ItemStack(Items.GLASS_BOTTLE));
                            break;
                        } else if(((DispenserBlockEntity) pSource.getEntity()).getItem(j).is(Items.GLASS_BOTTLE) && ((DispenserBlockEntity) pSource.getEntity()).getItem(j).getCount() < 64){
                            ((DispenserBlockEntity) pSource.getEntity()).getItem(j).setCount(((DispenserBlockEntity) pSource.getEntity()).getItem(j).getCount()+1);
                            break;
                        } else if(j==8){
                            pLevel.addFreshEntity(new ItemEntity(pLevel, $$4.getX(), $$4.getY(), $$4.getZ(), new ItemStack(Items.GLASS_BOTTLE)));
                        }

                    }
                    ItemStack stackCopy = itemStack.copy();
                    stackCopy.shrink(1);
                    return stackCopy;
                }
                return itemStack;

            }
        });
        DispenserBlock.registerBehavior(Moditems.GOLD_SPORES.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new GoldSporeEntity(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
                    p_123474_.setItem(p_123478_);
                });
            }
        });

        DispenserBlock.registerBehavior(Moditems.WHELP_TORCH.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new WhelpTorchEntity(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
                    p_123474_.setItem(p_123478_);
                });
            }
        });
    }

    // Add the example block item to the building block tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

   // @SubscribeEvent
    //public static void registerDimensionEffects(final RegisterDimensionSpecialEffectsEvent event) {
    //    event.register(Newfound_Underground.DIMENSION_EFFECTS, new DimensionSpecialEffects.NetherEffects());

   // }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
           // LOGGER.info("HELLO FROM CLIENT SETUP");
           // LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
            EntityRenderers.register(ModEntities.GOLD_SPORE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.WHELP_TORCH_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.SULPHUR_SLIME_DROP.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.WHELP.get(), WhelpRenderer::new);
            EntityRenderers.register(ModEntities.ROGERFISH.get(), RogerfishRenderer::new);
            EntityRenderers.register(ModEntities.GNOME.get(), GnomeRenderer::new);

        }
    }
}
