package net.HenryThe9f.foundground;

import com.mojang.logging.LogUtils;
import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.entity.ModBlockEntities;
import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.entity.client.WhelpRenderer;
import net.HenryThe9f.foundground.entity.custom.GoldSporeEntity;
import net.HenryThe9f.foundground.item.ModCreativeModeTabs;
import net.HenryThe9f.foundground.item.Moditems;
import net.HenryThe9f.foundground.worldgen.biome.ModTerrablender;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

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
        ModTerrablender.registerBiomes();
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

        DispenserBlock.registerBehavior(Moditems.GOLD_SPORES.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new GoldSporeEntity(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
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
            EntityRenderers.register(ModEntities.WHELP.get(), WhelpRenderer::new);

        }
    }
}
