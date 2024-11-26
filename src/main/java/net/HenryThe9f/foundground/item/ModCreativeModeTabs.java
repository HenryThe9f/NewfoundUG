package net.HenryThe9f.foundground.item;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Newfound_Underground.MODID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.DEEP_MUSHROOM.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModBlocks.STONE_MYCELIUM.get());
                        pOutput.accept(ModBlocks.DEEP_MYCELIUM.get());
                        pOutput.accept(ModBlocks.CAVE_MUSHROOM_CAP .get());
                        pOutput.accept(ModBlocks.DEEP_MUSHROOM_CAP.get());
                        pOutput.accept(ModBlocks.PALE_MUSHROOM_CAP .get());
                        pOutput.accept(ModBlocks.CYAN_MUSHROOM_CAP.get());
                        pOutput.accept(ModBlocks.CAVE_STEM .get());
                        pOutput.accept(ModBlocks.STRIPPED_CAVE_STEM .get());
                        pOutput.accept(ModBlocks.CAVE_HYPHAE .get());
                        pOutput.accept(ModBlocks.STRIPPED_CAVE_HYPHAE .get());
                        pOutput.accept(ModBlocks.MUSHROOM_PLANKS .get());
                        pOutput.accept(ModBlocks.MUSHROOM_SLAB .get());
                        pOutput.accept(ModBlocks.MUSHROOM_STAIRS .get());
                        pOutput.accept(ModBlocks.MUSHROOM_FENCE .get());
                        pOutput.accept(ModBlocks.MUSHROOM_FENCE_GATE .get());
                        pOutput.accept(ModBlocks.MUSHROOM_BUTTON .get());
                        pOutput.accept(ModBlocks.MUSHROOM_PRESSURE_PLATE .get());
                        pOutput.accept(ModBlocks.MUSHROOM_DOOR .get());
                        pOutput.accept(ModBlocks.MUSHROOM_TRAPDOOR .get());
                        pOutput.accept(ModBlocks.CAVE_MUSHROOM .get());
                        pOutput.accept(ModBlocks.DEEP_MUSHROOM .get());
                        pOutput.accept(ModBlocks.PALE_MUSHROOM .get());
                        pOutput.accept(ModBlocks.CYAN_MUSHROOM .get());
                        pOutput.accept(ModBlocks.TALL_CAVE_MUSHROOM .get());
                        pOutput.accept(ModBlocks.TALL_DEEP_MUSHROOM .get());
                        pOutput.accept(ModBlocks.TALL_PALE_MUSHROOM .get());
                        pOutput.accept(ModBlocks.TALL_CYAN_MUSHROOM .get());
                        pOutput.accept(ModBlocks.LEAD_MUSHROOM .get());
                        pOutput.accept(ModBlocks.GOLD_MUSHROOM .get());
                        pOutput.accept(ModBlocks.GOLD_LAUNCHER.get());
                        pOutput.accept(ModBlocks.SHROOMITE_LAUNCHER .get());
                        pOutput.accept(ModBlocks.SMORGASBOARDS.get());
                        pOutput.accept(ModBlocks.SMORGLASS .get());
                        pOutput.accept(ModBlocks.SMORGLASS_PANE .get());
                        pOutput.accept(ModBlocks.SMORG_SLAB .get());
                        pOutput.accept(ModBlocks.SMORG_STAIRS .get());
                        pOutput.accept(ModBlocks.SMORG_WALL .get());
                        pOutput.accept(ModBlocks.SMORG_BUTTON .get());
                        pOutput.accept(ModBlocks.SMORG_PRESSURE_PLATE .get());
                        pOutput.accept(Moditems.GOLD_SPORES .get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}