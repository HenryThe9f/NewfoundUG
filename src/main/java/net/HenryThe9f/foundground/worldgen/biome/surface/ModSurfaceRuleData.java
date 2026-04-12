package net.HenryThe9f.foundground.worldgen.biome.surface;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

import java.util.function.Supplier;

public class ModSurfaceRuleData  {
    private static final SurfaceRules.RuleSource CALCITE_STRIP = makeStateRule(Blocks.CALCITE);
    private static final SurfaceRules.RuleSource SULPHUR_SLIME = makeStateRule(ModBlocks.SULPHUR_SLIME_BLOCK.get());

    private static final SurfaceRules.RuleSource EMPTY_SPACE = makeStateRule(Blocks.AIR);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);

    private static final SurfaceRules.RuleSource BEDROCKESQUE = makeStateRule(Blocks.BLACK_CONCRETE);



    public static SurfaceRules.RuleSource makeRules() {

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SULPHUR_SLIME_CAVES), (SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH,  -0.2,  -0.02), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), CALCITE_STRIP)))),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SULPHUR_SLIME_CAVES), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH,  0.02,  0.2), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), CALCITE_STRIP))),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SULPHUR_SLIME_CAVES), (SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH,  -0.2,  -0.02), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.CEILING), SULPHUR_SLIME)))),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SULPHUR_SLIME_CAVES), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH,  0.02,  0.2), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.CEILING), SULPHUR_SLIME)))


                        /*
                ),    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.BLACK_SEA),
                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("minecraft:bedrock_floor", VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(0)), BEDROCKESQUE))
                ),    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.BLACK_SEA),
                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("foundground:blackseaair", VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(10)), WATER))
                ),    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.BLACK_SEA),
                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("foundground:blackseaair", VerticalAnchor.aboveBottom(22), VerticalAnchor.aboveBottom(25)), EMPTY_SPACE))
                        */


                );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}