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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CYAN_MUSHROOM.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModBlocks.PETRIFIED_ROOT.get());
                        pOutput.accept(ModBlocks.THORN_VINES.get());
                        pOutput.accept(ModBlocks.ROOT_IRON_ORE.get());
                        pOutput.accept(ModBlocks.RAW_IRON_ROSE.get());
                        pOutput.accept(Moditems.RAW_IRON_ROSE_ITEM.get());
                        pOutput.accept(ModBlocks.IRON_ROSE.get());
                        pOutput.accept(ModBlocks.FRAGILE_ROOTED_STONE.get());
                        pOutput.accept(ModBlocks.FRAGILE_ROOTED_DEEPSLATE.get());
                        pOutput.accept(ModBlocks.IRON_ROOTED_STONE.get());
                        pOutput.accept(ModBlocks.IRON_ROOTED_DEEPSLATE.get());
                        pOutput.accept(ModBlocks.IRON_ROOTED_NETHERRACK.get());
                        pOutput.accept(ModBlocks.IRON_ROOTED_END_STONE.get());
                        pOutput.accept(ModBlocks.WHELP_FUR.get());
                        pOutput.accept(ModBlocks.WHELP_FUR_CARPET.get());
                        pOutput.accept(Moditems.RAW_WHELP.get());
                        pOutput.accept(Moditems.COOKED_WHELP.get());
                        pOutput.accept(Moditems.WHELP_TORCH.get());
                        pOutput.accept(ModBlocks.BURNING_FUR.get());
                        pOutput.accept(Moditems.WHELP_SPAWN_EGG.get());
                        pOutput.accept(ModBlocks.JAPEBOX.get());

                        pOutput.accept(Moditems.GOLD_SPORES.get());
                        pOutput.accept(Moditems.BLINDING_STEW.get());
                        pOutput.accept(ModBlocks.BEDROCK_FUNGUS_STEM.get());
                        pOutput.accept(ModBlocks.BEDROCK_FUNGUS_CAP.get());
                        pOutput.accept(ModBlocks.LAPIS_BEDROCK_FUNGUS_CAP.get());

                        pOutput.accept(ModBlocks.CYANSTONE.get());
                        pOutput.accept(ModBlocks.CYAN_MUSHROOM.get());
                        pOutput.accept(ModBlocks.LAPIS_LANTERN.get());
                        pOutput.accept(ModBlocks.SMOOTH_LAPIS.get());
                        pOutput.accept(ModBlocks.SMOOTH_LAPIS_SLAB.get());
                        pOutput.accept(ModBlocks.SMOOTH_LAPIS_STAIRS.get());
                        pOutput.accept(ModBlocks.SMOOTH_LAPIS_WALL.get());
                        pOutput.accept(ModBlocks.CUT_LAPIS.get());
                        pOutput.accept(ModBlocks.CUT_LAPIS_SLAB.get());
                        pOutput.accept(ModBlocks.CUT_LAPIS_STAIRS.get());
                        pOutput.accept(ModBlocks.CUT_LAPIS_WALL.get());




                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}