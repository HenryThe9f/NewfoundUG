package net.HenryThe9f.foundground.datagen;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Newfound_Underground.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
       this.tag(BlockTags.WALLS)
               .add(ModBlocks.SMORG_WALL.get());
        this.tag(BlockTags.FENCES)
                .add(ModBlocks.MUSHROOM_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.MUSHROOM_FENCE_GATE.get());


        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.CAVE_STEM.get(),
                        ModBlocks.STRIPPED_CAVE_HYPHAE.get(),
                        ModBlocks.STRIPPED_CAVE_STEM.get(),
                        ModBlocks.MUSHROOM_PLANKS.get(),
                        ModBlocks.MUSHROOM_STAIRS.get(),
                        ModBlocks.MUSHROOM_SLAB.get(),
                        ModBlocks.MUSHROOM_BUTTON.get(),
                        ModBlocks.MUSHROOM_PRESSURE_PLATE.get(),
                        ModBlocks.MUSHROOM_FENCE.get(),
                        ModBlocks.MUSHROOM_FENCE_GATE.get(),
                        ModBlocks.MUSHROOM_DOOR.get(),
                        ModBlocks.MUSHROOM_TRAPDOOR.get(),
                        ModBlocks.SMORGASBOARDS.get(),
                        ModBlocks.SMORG_SLAB.get(),
                        ModBlocks.SMORG_STAIRS.get(),
                        ModBlocks.SMORG_BUTTON.get(),
                        ModBlocks.SMORG_PRESSURE_PLATE.get(),
                        ModBlocks.SMORG_WALL.get(),
                        ModBlocks.DEEP_MUSHROOM_CAP.get(),
                        ModBlocks.CAVE_MUSHROOM_CAP.get(),
                        ModBlocks.PALE_MUSHROOM_CAP.get(),
                        ModBlocks.CYAN_MUSHROOM_CAP.get(),
                ModBlocks.CAVE_HYPHAE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.STONE_MYCELIUM.get(),
                        ModBlocks.DEEP_MYCELIUM.get(),
                        ModBlocks.SMORGASBOARDS.get(),
                        ModBlocks.SMORG_SLAB.get(),
                        ModBlocks.SMORG_STAIRS.get(),
                        ModBlocks.SMORG_BUTTON.get(),
                        ModBlocks.SMORG_PRESSURE_PLATE.get(),
                        ModBlocks.SMORGLASS.get(),
                        ModBlocks.SMORGLASS_PANE.get(),
                        ModBlocks.SMORG_WALL.get());

        this.tag(BlockTags.MUSHROOM_GROW_BLOCK)
                .add(ModBlocks.STONE_MYCELIUM.get(),
                ModBlocks.DEEP_MYCELIUM.get());



            //    .add(ModBlocks.EX_BLOCK.get().addTag(Tags.Blocks.ORES));

    }
}
