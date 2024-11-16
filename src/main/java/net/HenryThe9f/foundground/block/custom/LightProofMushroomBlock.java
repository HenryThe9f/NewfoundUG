package net.HenryThe9f.foundground.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Iterator;

public class LightProofMushroomBlock extends MushroomBlock {
    public LightProofMushroomBlock(Properties pProperties, ResourceKey<ConfiguredFeature<?, ?>> pFeature) {
        super(pProperties, pFeature);
    }
   @Override public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos blockpos = pPos.below();
        BlockState blockstate = pLevel.getBlockState(blockpos);
        if (blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return true;
        } else {
            return pLevel.getRawBrightness(pPos, 0) < 16 && blockstate.canSustainPlant(pLevel, blockpos, Direction.UP, this);
        }
    }
    public boolean canThrive(LevelReader pLevel, BlockPos pPos) {
        if (pLevel.getRawBrightness(pPos, 0) > 12) {
            return false;
        } else {
            return true;
        }
    }
    @Override public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(25) == 0) {
            int i = 5;
            boolean j = true;
            Iterator var7 = BlockPos.betweenClosed(pPos.offset(-4, -1, -4), pPos.offset(4, 1, 4)).iterator();

            while(var7.hasNext()) {
                BlockPos blockpos = (BlockPos)var7.next();
                if (pLevel.getBlockState(blockpos).is(this)) {
                    --i;
                    if (i <= 0) {
                        return;
                    }
                }
            }

            BlockPos blockpos1 = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(2) - pRandom.nextInt(2), pRandom.nextInt(3) - 1);

            for(int k = 0; k < 4; ++k) {
                if (pLevel.isEmptyBlock(blockpos1) && pState.canSurvive(pLevel, blockpos1)) {
                    pPos = blockpos1;
                }

                blockpos1 = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(2) - pRandom.nextInt(2), pRandom.nextInt(3) - 1);
            }

            if (pLevel.isEmptyBlock(blockpos1) && pState.canSurvive(pLevel, blockpos1) && canThrive(pLevel, blockpos1)) {
                pLevel.setBlock(blockpos1, pState, 2);
            }
        }

    }
}
