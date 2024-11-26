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
        //blockWithItem();
        //blockWithItem(((HugeMushroomBlock) ModBlocks.DEEP_MUSHROOM_CAP.get()), blockTexture(ModBlocks.DEEP_MUSHROOM_CAP.get()));
        //SMORGASBOARD STUFF
        stairsBlock(((StairBlock) ModBlocks.SMORG_STAIRS.get()), blockTexture(ModBlocks.SMORGASBOARDS.get()));
        slabBlock(((SlabBlock) ModBlocks.SMORG_SLAB.get()), blockTexture(ModBlocks.SMORGASBOARDS.get()), blockTexture(ModBlocks.SMORGASBOARDS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.SMORG_BUTTON.get()), modLoc("block/smorg_button"));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.SMORG_PRESSURE_PLATE.get()), blockTexture(ModBlocks.SMORGASBOARDS.get()));
        wallBlock(((WallBlock) ModBlocks.SMORG_WALL.get()), blockTexture(ModBlocks.SMORGASBOARDS.get()));
        paneBlockWithRenderType(((IronBarsBlock) ModBlocks.SMORGLASS_PANE.get()), blockTexture(ModBlocks.SMORGLASS.get()), modLoc("block/smorglass_edge"), "cutout");
//WOOD
        blockWithItem(ModBlocks.MUSHROOM_PLANKS);
        doorBlockWithRenderType(((DoorBlock) ModBlocks.MUSHROOM_DOOR.get()), modLoc("block/mushroom_door_bottom"), modLoc("block/mushroom_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.MUSHROOM_TRAPDOOR.get()), modLoc("block/mushroom_trapdoor"), true, "cutout");
        stairsBlock(((StairBlock) ModBlocks.MUSHROOM_STAIRS.get()), blockTexture(ModBlocks.MUSHROOM_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.MUSHROOM_SLAB.get()), blockTexture(ModBlocks.MUSHROOM_PLANKS.get()), blockTexture(ModBlocks.MUSHROOM_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.MUSHROOM_BUTTON.get()), blockTexture(ModBlocks.MUSHROOM_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.MUSHROOM_PRESSURE_PLATE.get()), blockTexture(ModBlocks.MUSHROOM_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.MUSHROOM_FENCE.get()), blockTexture(ModBlocks.MUSHROOM_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.MUSHROOM_FENCE_GATE.get()), blockTexture(ModBlocks.MUSHROOM_PLANKS.get()));
//OTHER
        //blockWithItem(ModBlocks.GLOW_CLOUD);


    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
