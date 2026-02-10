package net.HenryThe9f.foundground.datagen;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Newfound_Underground.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        //blockWithItem(ModBlocks.THORN_VINES);
        blockWithItem(ModBlocks.PETRIFIED_ROOT);


        //yet more old stuff DO NOT RUN DATAGEN IT WILL FUCK YOUR SHIT UP
        //blockWithItem();
        //blockWithItem(((HugeMushroomBlock) ModBlocks.DEEP_MUSHROOM_CAP.get()), blockTexture(ModBlocks.DEEP_MUSHROOM_CAP.get()));
        //SMORGASBOARD STUFF

//OTHER
        //blockWithItem(ModBlocks.GLOW_CLOUD);


    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
