package net.HenryThe9f.foundground.datagen;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Newfound_Underground.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //blockWithItem();
        //blockWithItem(((HugeMushroomBlock) ModBlocks.DEEP_MUSHROOM_CAP.get()), blockTexture(ModBlocks.DEEP_MUSHROOM_CAP.get()));

    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
