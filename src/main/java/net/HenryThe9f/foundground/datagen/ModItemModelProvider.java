package net.HenryThe9f.foundground.datagen;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Newfound_Underground.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        SimpleButtonItem(ModBlocks.SMORG_BUTTON, ModBlocks.SMORGASBOARDS);
        SimpleWallItem(ModBlocks.SMORG_WALL, ModBlocks.SMORGASBOARDS);

        SimpleBlockItem(ModBlocks.SMORG_STAIRS);
        SimpleBlockItem(ModBlocks.SMORG_SLAB);
        SimpleBlockItem(ModBlocks.SMORG_PRESSURE_PLATE);
        SimpleTrapdoorItem(ModBlocks.MUSHROOM_TRAPDOOR);
        SimpleFenceItem(ModBlocks.MUSHROOM_FENCE, ModBlocks.MUSHROOM_PLANKS);
        SimpleButtonItem(ModBlocks.MUSHROOM_BUTTON, ModBlocks.MUSHROOM_PLANKS);
        SimpleBlockItem(ModBlocks.MUSHROOM_FENCE_GATE);
        SimpleBlockItem(ModBlocks.MUSHROOM_SLAB);
        SimpleBlockItem(ModBlocks.MUSHROOM_STAIRS);
        SimpleBlockItem(ModBlocks.MUSHROOM_PRESSURE_PLATE);



    }
    private ItemModelBuilder SimpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Newfound_Underground.MODID, "item/" + item.getId().getPath()));
    }
    public void SimpleBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Newfound_Underground.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));

    }
    public void SimpleButtonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(Newfound_Underground.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void SimpleWallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Newfound_Underground.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void SimpleTrapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    public void SimpleFenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Newfound_Underground.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}
