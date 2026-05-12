package net.HenryThe9f.foundground.item;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Newfound_Underground.MODID);

    public static final RegistryObject<CreativeModeTab> FOUNDGROUND_TAB = CREATIVE_MODE_TABS.register("foundground_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.SULPHUR_SLIMEBALL.get()))
                    .title(Component.translatable("creativetab.foundground_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Moditems.EXTREMELY_CRUDE_PICKAXE.get());

                        pOutput.accept(ModBlocks.PETRIFIED_ROOT.get());
                        pOutput.accept(ModBlocks.THORN_VINES.get());
                        pOutput.accept(ModBlocks.ROOT_IRON_ORE.get());
                        pOutput.accept(ModBlocks.AMBER_ORE.get());
                        pOutput.accept(Moditems.OREANGE.get());
                        pOutput.accept(ModBlocks.FORBIDDEN_FRUIT_ORE.get());
                        pOutput.accept(Moditems.FORBIDDEN_FRUIT.get());
                        pOutput.accept(ModBlocks.RAW_IRON_ROSE.get());
                        pOutput.accept(ModBlocks.RAW_IRON_ROSE_BROKEN.get());
                        pOutput.accept(ModBlocks.IRON_ROSE.get());
                        pOutput.accept(ModBlocks.FRAGILE_ROOTED_STONE.get());
                        pOutput.accept(ModBlocks.FRAGILE_ROOTED_DEEPSLATE.get());
                        pOutput.accept(ModBlocks.IRON_ROOTED_STONE.get());
                        pOutput.accept(ModBlocks.IRON_ROOTED_DEEPSLATE.get());
                        pOutput.accept(ModBlocks.IRON_ROOTED_NETHERRACK.get());
                        pOutput.accept(ModBlocks.IRON_ROOTED_END_STONE.get());
                        pOutput.accept(Moditems.WHELP_FUR.get());
                        pOutput.accept(Moditems.WHELP_FUR_CARPET.get());
                        pOutput.accept(Moditems.RAW_WHELP.get());
                        pOutput.accept(Moditems.COOKED_WHELP.get());
                        pOutput.accept(Moditems.WHELP_TORCH.get());
                        pOutput.accept(ModBlocks.BURNING_FUR.get());
                        pOutput.accept(Moditems.GNOME_ITEM.get());
                       // pOutput.accept(Moditems.CLAY_HORN.get());
                        pOutput.accept(Moditems.TERRACOTTA_HORN.get());

                        pOutput.accept(ModBlocks.JAPEBOX.get());



                        pOutput.accept(Moditems.GOLD_SPORES.get());
                        pOutput.accept(Moditems.BLINDING_STEW.get());
                        pOutput.accept(ModBlocks.BEDROCK_FUNGUS_STEM.get());
                        pOutput.accept(ModBlocks.BEDROCK_FUNGUS_CAP.get());
                        pOutput.accept(ModBlocks.BEDROCK_MYCELIUM.get());
                        pOutput.accept(ModBlocks.FAKE_BEDROCK.get());
                        pOutput.accept(ModBlocks.BEDROCK_MYCELIUM_ALTAR.get());



                        pOutput.accept(ModBlocks.CYANSTONE.get());
                        pOutput.accept(ModBlocks.CYAN_MUSHROOM.get());
                        pOutput.accept(ModBlocks.CYAN_MUSHROOM_CAP.get());
                        pOutput.accept(Moditems.COAL_DUST_BOTTLE.get());
                        pOutput.accept(ModBlocks.DENSE_COAL_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_DENSE_COAL_ORE.get());

                        pOutput.accept(ModBlocks.LAPIS_LANTERN.get());
                        pOutput.accept(ModBlocks.SMOOTH_LAPIS.get());
                        pOutput.accept(ModBlocks.SMOOTH_LAPIS_SLAB.get());
                        pOutput.accept(ModBlocks.SMOOTH_LAPIS_STAIRS.get());
                        pOutput.accept(ModBlocks.SMOOTH_LAPIS_WALL.get());
                        pOutput.accept(ModBlocks.CUT_LAPIS.get());
                        pOutput.accept(ModBlocks.CUT_LAPIS_SLAB.get());
                        pOutput.accept(ModBlocks.CUT_LAPIS_STAIRS.get());
                        pOutput.accept(ModBlocks.CUT_LAPIS_WALL.get());
                        pOutput.accept(Moditems.CAVE_SPIDER_INGOT.get());

                        pOutput.accept(Blocks.CALCITE);
                        pOutput.accept(ModBlocks.CALCITE_SLAB.get());
                        pOutput.accept(ModBlocks.CALCITE_STAIRS.get());
                        pOutput.accept(ModBlocks.CALCITE_WALL.get());
                        pOutput.accept(ModBlocks.CALCITE_BRICKS.get());
                        pOutput.accept(ModBlocks.CALCITE_BRICK_SLAB.get());
                        pOutput.accept(ModBlocks.CALCITE_BRICK_STAIRS.get());
                        pOutput.accept(ModBlocks.CALCITE_BRICK_WALL.get());
                        pOutput.accept(ModBlocks.CALCITE_PILLAR.get());
                        pOutput.accept(ModBlocks.CHISELED_CALCITE.get());

                        pOutput.accept(Moditems.SULPHUR.get());
                        pOutput.accept(ModBlocks.SULPHUR_BLOCK.get());

                        pOutput.accept(ModBlocks.SULPHUR_BRICKS.get());
                        pOutput.accept(ModBlocks.SULPHUR_BRICK_SLAB.get());
                        pOutput.accept(ModBlocks.SULPHUR_BRICK_STAIRS.get());
                        pOutput.accept(ModBlocks.SULPHUR_BRICK_WALL.get());

                        pOutput.accept(Moditems.SULPHUR_DUST_BOTTLE.get());
                        pOutput.accept(ModBlocks.SULPHUROUS_CALCITE.get());
                        pOutput.accept(ModBlocks.SULPHUR_CRYSTAL.get());
                        pOutput.accept(ModBlocks.SULPHUR_CLUSTER.get());

                        pOutput.accept(Moditems.SULPHUR_SLIMEBALL.get());
                        pOutput.accept(ModBlocks.SULPHUR_SLIME_BLOCK.get());
                        pOutput.accept(ModBlocks.SULPHUR_SLIME_STRANDS.get());
                        pOutput.accept(ModBlocks.SLIME_PUDDLE.get());
                        pOutput.accept(ModBlocks.SULPHUROUS_CALCITE_GEYSER.get());
                        pOutput.accept(ModBlocks.CALCITE_GEYSER.get());

                        pOutput.accept(Moditems.RUBBER.get());
                        pOutput.accept(ModBlocks.RUBBER_BLOCK.get());

                        pOutput.accept(Moditems.CLIMBING_CLAWS.get());
                        pOutput.accept(Moditems.BROKEN_CLIMBING_CLAWS.get());

                        pOutput.accept(Moditems.LAPIS_STAMP.get());
                        pOutput.accept(ModBlocks.PUNCHER.get());


                        pOutput.accept(ModBlocks.SCUM.get());
                        pOutput.accept(ModBlocks.BUBBLE_BLOCK.get());
                        pOutput.accept(ModBlocks.LAVA_BUBBLE_BLOCK.get());

                        pOutput.accept(Moditems.ROGERFISH_BUCKET.get());
                        pOutput.accept(Moditems.ROGERFISH_SKULL.get());

                        pOutput.accept(ModBlocks.BONY_FARMLAND_HEAD.get());
                        pOutput.accept(ModBlocks.BONY_FARMLAND.get());

                        pOutput.accept(ModBlocks.CRACKED_BRICKS.get());
                        pOutput.accept(ModBlocks.CHISELED_BRICKS.get());

                        pOutput.accept(Moditems.WHELP_SPAWN_EGG.get());
                        pOutput.accept(Moditems.ROGERFISH_SPAWN_EGG.get());



                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}