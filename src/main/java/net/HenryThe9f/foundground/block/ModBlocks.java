package net.HenryThe9f.foundground.block;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.block.custom.*;
import net.HenryThe9f.foundground.item.Moditems;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeBrownMushroomFeature;
import net.minecraft.world.level.levelgen.feature.HugeRedMushroomFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Newfound_Underground.MODID);

    //HUGE MUSHROOM BLOCKS
    public static final RegistryObject<Block> DEEP_MUSHROOM_CAP = registerBlock("deep_mushroom_cap",
           ()-> new BouncyMushroomBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK).lightLevel(state -> 5)) {
            });
    public static final RegistryObject<Block> CAVE_MUSHROOM_CAP = registerBlock("cave_mushroom_cap",
            ()-> new BouncyMushroomBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)) {
            });

    public static final RegistryObject<Block> CYAN_MUSHROOM_CAP = registerBlock("cyan_mushroom_cap",
            ()-> new BouncyMushroomBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK).lightLevel(state -> 5)) {
            });
    public static final RegistryObject<Block> PALE_MUSHROOM_CAP = registerBlock("pale_mushroom_cap",
            ()-> new BouncyMushroomBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)) {
            });
    //STONE AND GROUND
    public static final RegistryObject<Block> STONE_MYCELIUM = registerBlock("stone_mycelium",
            ()-> new MyceliumBlock(BlockBehaviour.Properties.copy(Blocks.STONE)) {
            });
    public static final RegistryObject<Block> DEEP_MYCELIUM = registerBlock("deep_mycelium",
            ()-> new BlueMyceliumBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)) {
            });
    //"FUNCTIONAL"
    public static final RegistryObject<Block> GOLD_LAUNCHER = registerBlock("gold_launcher",
            ()-> new GoldLauncherSlabBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)) {
            });
    public static final RegistryObject<Block> SHROOMITE_LAUNCHER = registerBlock("shroomite_launcher",
            ()-> new ShroomiteLauncherSlabBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)) {
            });
    public static final RegistryObject<Block> SMORGASBOARDS = registerBlock("smorgasboards",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.CHISELED_BOOKSHELF)) {
            });
    public static final RegistryObject<Block> SMORGLASS = registerBlock("smorglass",
            ()-> new SmorglassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().explosionResistance(1200)) {
            });
    //PLANTS AND FUNGI
    public static final RegistryObject<Block> CAVE_MUSHROOM = registerBlock("cave_mushroom",
            ()-> new LightProofMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM), TreeFeatures.HUGE_RED_MUSHROOM) {
            });
    public static final RegistryObject<Block> DEEP_MUSHROOM = registerBlock("deep_mushroom",
            ()-> new LightProofMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM).lightLevel(state -> 5), TreeFeatures.HUGE_RED_MUSHROOM) {
            });
    public static final RegistryObject<Block> PALE_MUSHROOM = registerBlock("pale_mushroom",
            ()-> new LightProofMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM), TreeFeatures.HUGE_RED_MUSHROOM) {
            });
    public static final RegistryObject<Block> CYAN_MUSHROOM = registerBlock("cyan_mushroom",
            ()-> new LightProofMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM).lightLevel(state -> 5), TreeFeatures.HUGE_RED_MUSHROOM) {
            });
    public static final RegistryObject<Block> TALL_CAVE_MUSHROOM = registerBlock("tall_cave_mushroom",
            ()-> new TallMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM)) {
            });
    public static final RegistryObject<Block> TALL_DEEP_MUSHROOM = registerBlock("tall_deep_mushroom",
            ()-> new TallMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM).lightLevel(state -> 5)) {
            });
    public static final RegistryObject<Block> TALL_PALE_MUSHROOM = registerBlock("tall_pale_mushroom",
            ()-> new TallMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM)) {
            });
    public static final RegistryObject<Block> TALL_CYAN_MUSHROOM = registerBlock("tall_cyan_mushroom",
            ()-> new TallMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM).lightLevel(state -> 5)) {
            });
    public static final RegistryObject<Block> LEAD_MUSHROOM = registerBlock("lead_mushroom",
            ()-> new NoFeatureMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM), TreeFeatures.HUGE_RED_MUSHROOM) {
            });
    public static final RegistryObject<Block> GOLD_MUSHROOM = registerBlock("gold_mushroom",
            ()-> new NoFeatureMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM).lightLevel(state -> 5), TreeFeatures.HUGE_RED_MUSHROOM) {
            });
    //WOOD
   public static final RegistryObject<Block> CAVE_STEM = registerBlock("cave_stem",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_STEM)) {
            });
    public static final RegistryObject<Block> STRIPPED_CAVE_STEM = registerBlock("stripped_cave_stem",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_WARPED_STEM)) {
            });
    public static final RegistryObject<Block> CAVE_HYPHAE = registerBlock("cave_hyphae",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_HYPHAE)) {
            });
    public static final RegistryObject<Block> STRIPPED_CAVE_HYPHAE = registerBlock("stripped_cave_hyphae",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_WARPED_HYPHAE)) {
            });




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
