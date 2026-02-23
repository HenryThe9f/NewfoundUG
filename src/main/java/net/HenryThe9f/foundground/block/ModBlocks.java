package net.HenryThe9f.foundground.block;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.block.custom.*;
import net.HenryThe9f.foundground.item.Moditems;
import net.HenryThe9f.foundground.worldgen.ModConfiguredFeatures;
import net.HenryThe9f.foundground.worldgen.tree.CyanMushroomGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeBrownMushroomFeature;
import net.minecraft.world.level.levelgen.feature.HugeRedMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
public class ModBlocks {


    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Newfound_Underground.MODID);
    public static final RegistryObject<Block> THORN_VINES = registerBlock("thorn_vines",
            ()-> new ThornVineBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).requiresCorrectToolForDrops()) {
            });
    public static final RegistryObject<Block> PETRIFIED_ROOT = registerBlock("petrified_root",
            ()-> new PetrifiedBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_TERRACOTTA).requiresCorrectToolForDrops()) {
            });
    public static final RegistryObject<Block> FRAGILE_ROOTED_STONE = registerBlock("fragile_rooted_stone",
            ()-> new FragileBlock(BlockBehaviour.Properties.copy(Blocks.STONE)) {
            });
    public static final RegistryObject<Block> FRAGILE_ROOTED_DEEPSLATE = registerBlock("fragile_rooted_deepslate",
            ()-> new FragileBlock(BlockBehaviour.Properties.copy(Blocks.STONE)) {
            });
    public static final RegistryObject<Block> RAW_IRON_ROSE = registerBlock("raw_iron_rose",
            ()-> new RawIronRoseBlock(BlockBehaviour.Properties.copy(Blocks.POPPY)) {
            });
    public static final RegistryObject<Block> IRON_ROSE = registerBlock("iron_rose",
            ()-> new IronRoseBlock(BlockBehaviour.Properties.copy(Blocks.POPPY)) {
            });
    public static final RegistryObject<Block> ROOT_IRON_ORE = registerBlock("root_iron_ore",
            ()-> new SpiderInfestedBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()) {
            });

    public static final RegistryObject<Block> IRON_ROOTED_STONE = registerBlock("iron_rooted_stone",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(0)) {
            });
    public static final RegistryObject<Block> CYANSTONE = registerBlock("cyanstone",
            ()-> new CyanStoneBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).lightLevel(state -> 5)) {
            });

    public static final RegistryObject<Block> IRON_ROOTED_DEEPSLATE = registerBlock("iron_rooted_deepslate",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(0)) {
            });

    public static final RegistryObject<Block> IRON_ROOTED_NETHERRACK = registerBlock("iron_rooted_netherrack",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).strength(0)) {
            });

    public static final RegistryObject<Block> IRON_ROOTED_END_STONE = registerBlock("iron_rooted_end_stone",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).strength(0)) {
            });
    public static final RegistryObject<Block> BURNING_FUR = registerBlock("burning_fur",
            ()-> new BurningFurBlock(BlockBehaviour.Properties.copy(Blocks.TORCH).sound(SoundType.WOOL)) {
            });
    public static final RegistryObject<Block> JAPEBOX = registerBlock("japebox",
            ()-> new FrozenWhelpBlock(BlockBehaviour.Properties.copy(Blocks.JUKEBOX)) {
            });
    public static final RegistryObject<Block> LAPIS_LANTERN = registerBlock("lapis_lantern",
            ()-> new LapisEffectBlock(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.DEEPSLATE_BRICKS).noOcclusion()) {
            });
    public static final RegistryObject<Block> BEDROCK_FUNGUS_STEM = registerBlock("bedrock_fungus_stem",
            ()-> new BedrockFungusStemBlock(BlockBehaviour.Properties.copy(Blocks.MELON).noOcclusion().strength(7)) {
            });
    public static final RegistryObject<Block> BEDROCK_FUNGUS_CAP = registerBlock("bedrock_fungus_cap",
            ()-> new BedrockFungusCapBlock(BlockBehaviour.Properties.copy(Blocks.MELON)) {
            });
    public static final RegistryObject<Block> LAPIS_BEDROCK_FUNGUS_CAP = registerBlock("lapis_bedrock_fungus_cap",
            ()-> new BedrockFungusCapBlock(BlockBehaviour.Properties.copy(Blocks.MELON)) {
            });
    public static final RegistryObject<Block> WHELP_FUR = registerBlock("whelp_fur",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)) {  @Override
            public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return true;
            }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 50;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 50;
                }
            });
    public static final RegistryObject<Block> WHELP_FUR_CARPET = registerBlock("whelp_fur_carpet",
            ()-> new CarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)) {  @Override
            public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return true;
            }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 50;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 50;
                }
            });
    public static final RegistryObject<Block> SMOOTH_LAPIS = registerBlock("smooth_lapis",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK)) {
            });
    public static final RegistryObject<Block> CUT_LAPIS = registerBlock("cut_lapis",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK)) {
            });
    public static final RegistryObject<Block> SMOOTH_LAPIS_STAIRS = registerBlock("smooth_lapis_stairs",
            ()-> new StairBlock(() -> ModBlocks.SMOOTH_LAPIS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK)) {
            });
    public static final RegistryObject<Block> SMOOTH_LAPIS_SLAB = registerBlock("smooth_lapis_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK)) {
            });
    public static final RegistryObject<Block> SMOOTH_LAPIS_WALL = registerBlock("smooth_lapis_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK)) {
            });
    public static final RegistryObject<Block> CUT_LAPIS_STAIRS = registerBlock("cut_lapis_stairs",
            ()-> new StairBlock(() -> ModBlocks.CUT_LAPIS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK)) {
            });
    public static final RegistryObject<Block> CUT_LAPIS_SLAB = registerBlock("cut_lapis_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK)) {
            });
    public static final RegistryObject<Block> CUT_LAPIS_WALL = registerBlock("cut_lapis_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK)) {
            });

    public static final RegistryObject<Block> CYAN_MUSHROOM = registerBlock("cyan_mushroom",
            ()-> new LightProofMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM).lightLevel(state -> 5), ModConfiguredFeatures.HUGE_CYAN_MUSHROOM) {
            });
    public static final RegistryObject<Block> POTTED_CYAN_MUSHROOM = registerBlock("potted_cyan_mushroom",
            ()-> new FlowerPotBlock(()-> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.CYAN_MUSHROOM, BlockBehaviour.Properties.copy(Blocks.POTTED_RED_MUSHROOM)) {
            });

    public static final RegistryObject<Block> CYAN_MUSHROOM_CAP = registerBlock("cyan_mushroom_cap",
            ()-> new BouncyMushroomBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK).lightLevel(state -> 5)) {
            });
    public static final RegistryObject<Block> FAKE_BEDROCK = registerBlock("fake_bedrock",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)) {
            });

    public static final RegistryObject<Block> COAL_DUST = registerBlock("coal_dust",
            ()-> new GasBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_STAINED_GLASS).noOcclusion().noCollission().replaceable().sound(SoundType.EMPTY).strength(-1, 0)) {
            });

    public static final RegistryObject<Block> DENSE_COAL_ORE = registerBlock("dense_coal_ore",
            ()-> new DenseCoalBlock(BlockBehaviour.Properties.copy(Blocks.COAL_ORE)) {
            });

    public static final RegistryObject<Block> DEEPSLATE_DENSE_COAL_ORE = registerBlock("deepslate_dense_coal_ore",
            ()-> new DenseCoalBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_COAL_ORE)) {
            });

    public static final RegistryObject<Block> CALCITE_PILLAR = registerBlock("calcite_pillar",
            ()-> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)) {
            });

    public static final RegistryObject<Block> CHISELED_CALCITE = registerBlock("chiseled_calcite",
            ()-> new WorkingDirectionalBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)) {
            });

    public static final RegistryObject<Block> CALCITE_BRICKS = registerBlock("calcite_bricks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)) {
            });
    public static final RegistryObject<Block> CALCITE_BRICK_STAIRS = registerBlock("calcite_brick_stairs",
            ()-> new StairBlock(() -> ModBlocks.CALCITE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.CALCITE)) {
            });
    public static final RegistryObject<Block> CALCITE_BRICK_SLAB = registerBlock("calcite_brick_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)) {
            });
    public static final RegistryObject<Block> CALCITE_BRICK_WALL = registerBlock("calcite_brick_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)) {
            });
    public static final RegistryObject<Block> CALCITE_STAIRS = registerBlock("calcite_stairs",
            ()-> new StairBlock(() -> Blocks.CALCITE.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.CALCITE)) {
            });
    public static final RegistryObject<Block> CALCITE_SLAB = registerBlock("calcite_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)) {
            });
    public static final RegistryObject<Block> CALCITE_WALL = registerBlock("calcite_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)) {
            });

    public static final RegistryObject<Block> SULPHUR_CRYSTAL = registerBlock("sulphur_crystal",
            ()-> new SulphurBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_STAINED_GLASS)) {
            });

    public static final RegistryObject<Block> SULPHUROUS_CALCITE = registerBlock("sulphurous_calcite",
            ()-> new SulphurBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)) {
            });

    public static final RegistryObject<Block> SULPHUR_CLUSTER = registerBlock("sulphur_cluster",
            ()-> new SulphurClusterBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_STAINED_GLASS).noCollission().lightLevel(state -> 3)) {
            });

    public static final RegistryObject<Block> SULPHUR_DUST = registerBlock("sulphur_dust",
            ()-> new GasBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_STAINED_GLASS).noOcclusion().noCollission().replaceable().sound(SoundType.EMPTY).strength(-1, 0)) {
            });

    public static final RegistryObject<Block> SULPHUR_SLIME_BLOCK = registerBlock("sulphur_slime_block",
            ()-> new SlimeBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)) {
            });

    public static final RegistryObject<Block> SULPHUR_SLIME_STRANDS = registerBlock("sulphur_slime_strands",
            ()-> new DrippingSlimeBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK).noCollission()) {
            });

    public static final RegistryObject<Block> CALCITE_GEYSER = registerBlock("calcite_geyser",
            ()-> new GeyserBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)) {
            });

    public static final RegistryObject<Block> SULPHUROUS_CALCITE_GEYSER = registerBlock("sulphurous_calcite_geyser",
            ()-> new SulphurGeyserBlock(BlockBehaviour.Properties.copy(ModBlocks.SULPHUROUS_CALCITE.get())) {
            });

    public static final RegistryObject<Block> PUNCHER = registerBlock("puncher",
            ()-> new PuncherBlock(BlockBehaviour.Properties.copy(Blocks.DISPENSER)) {
            });

    public static final RegistryObject<Block> PUNCHER_FIST = registerBlock("puncher_fist",
            ()-> new FistBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK).noCollission().pushReaction(PushReaction.DESTROY)) {
            });

    public static final RegistryObject<Block> AMBER_EGG = registerBlock("amber_egg",
            ()-> new EggBlock(BlockBehaviour.Properties.copy(Blocks.HONEY_BLOCK)) {
            });

    public static final RegistryObject<Block> SLIME_PUDDLE = registerBlock("slime_puddle",
            ()-> new FallingSlimeBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)) {
            });

    public static final RegistryObject<Block> RUBBER_BLOCK = registerBlock("rubber_block",
            ()-> new SlimeBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_WOOL).friction(0.6F).speedFactor(1).jumpFactor(2)) {
            });

    public static final RegistryObject<Block> SULPHUR_BLOCK = registerBlock("sulphur_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK)) {
            });
    ///EVERYTHING BELOW HERE IS OLD










    /*public static final RegistryObject<Block> CASTLE_GATE = registerBlock("castle_gate",
            ()-> new CastleGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)) {
            });

    //HUGE MUSHROOM BLOCKS
    public static final RegistryObject<Block> DEEP_MUSHROOM_CAP = registerBlock("deep_mushroom_cap",
           ()-> new BouncyMushroomBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK).lightLevel(state -> 5)) {
            });
    public static final RegistryObject<Block> CAVE_MUSHROOM_CAP = registerBlock("cave_mushroom_cap",
            ()-> new BouncyMushroomBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)) {
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
            ()-> new ShroomiteLauncherSlabBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).strength(1, 1200)) {
            });
    public static final RegistryObject<Block> SMORGASBOARDS = registerBlock("smorgasboards",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.CHISELED_BOOKSHELF).strength(1, 1200)) {
            });
    public static final RegistryObject<Block> SMORGLASS = registerBlock("smorglass",
            ()-> new SmorglassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().explosionResistance(1200).strength(1, 1200)) {
            });
    public static final RegistryObject<Block> SMORGLASS_PANE = registerBlock("smorglass_pane",
            ()-> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE).noOcclusion().explosionResistance(1200).strength(1, 1200)) {
            });
    public static final RegistryObject<Block> SMORG_STAIRS = registerBlock("smorg_stairs",
            ()-> new StairBlock(() -> ModBlocks.SMORGASBOARDS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.CHISELED_BOOKSHELF).strength(1, 1200)) {
            });
    public static final RegistryObject<Block> SMORG_SLAB = registerBlock("smorg_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.CHISELED_BOOKSHELF).strength(1, 1200)) {
            });
    public static final RegistryObject<Block> SMORG_WALL = registerBlock("smorg_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.CHISELED_BOOKSHELF).strength(1, 1200)) {
            });
    public static final RegistryObject<Block> SMORG_BUTTON = registerBlock("smorg_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.CHISELED_BOOKSHELF).noCollission().strength(1, 1200),
                    BlockSetType.IRON, 2, true));
    public static final RegistryObject<Block> SMORG_PRESSURE_PLATE = registerBlock("smorg_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.CHISELED_BOOKSHELF).noCollission().strength(1, 1200),
                    BlockSetType.IRON));
    public static final RegistryObject<Block> GLOW_CLOUD = registerBlock("glow_cloud",
            ()-> new GlowClusterBlock(BlockBehaviour.Properties.copy(Blocks.COBWEB).lightLevel(state -> 14)) {
            });

    //PLANTS AND FUNGI
    public static final RegistryObject<Block> CAVE_MUSHROOM = registerBlock("cave_mushroom",
            ()-> new LightProofMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM), FeatureUtils.createKey("crimson_fungus")) {
            });
    public static final RegistryObject<Block> DEEP_MUSHROOM = registerBlock("deep_mushroom",
            ()-> new LightProofMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM).lightLevel(state -> 5), TreeFeatures.HUGE_RED_MUSHROOM) {
            });
    public static final RegistryObject<Block> PALE_MUSHROOM = registerBlock("pale_mushroom",
            ()-> new LightProofMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM), TreeFeatures.HUGE_RED_MUSHROOM) {
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
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_STEM).strength(4)) {
            });
    public static final RegistryObject<Block> STRIPPED_CAVE_STEM = registerBlock("stripped_cave_stem",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_WARPED_STEM)) {
            });
    public static final RegistryObject<Block> CAVE_HYPHAE = registerBlock("cave_hyphae",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_HYPHAE).strength(4)) {
            });
    public static final RegistryObject<Block> STRIPPED_CAVE_HYPHAE = registerBlock("stripped_cave_hyphae",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_WARPED_HYPHAE)) {
            });
    public static final RegistryObject<Block> MUSHROOM_DOOR = registerBlock("mushroom_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_DOOR).noOcclusion(), BlockSetType.WARPED));
    public static final RegistryObject<Block> MUSHROOM_TRAPDOOR = registerBlock("mushroom_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_TRAPDOOR).noOcclusion(), BlockSetType.WARPED));
    public static final RegistryObject<Block> MUSHROOM_BUTTON = registerBlock("mushroom_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_BUTTON).noCollission(),
                    BlockSetType.WARPED, 30, true));
    public static final RegistryObject<Block> MUSHROOM_PRESSURE_PLATE = registerBlock("mushroom_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.WARPED_PRESSURE_PLATE).noCollission(),
                    BlockSetType.WARPED));

    public static final RegistryObject<Block> MUSHROOM_PLANKS = registerBlock("mushroom_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 35;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> MUSHROOM_SLAB = registerBlock("mushroom_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_SLAB)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 35;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> MUSHROOM_STAIRS = registerBlock("mushroom_stairs",
            () -> new StairBlock(() -> ModBlocks.MUSHROOM_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.WARPED_STAIRS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 35;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> MUSHROOM_FENCE = registerBlock("mushroom_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 35;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> MUSHROOM_FENCE_GATE = registerBlock("mushroom_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 35;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }*/

          //  });


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
