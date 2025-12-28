package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class CyanStoneBlock extends Block {
    public CyanStoneBlock(Properties pProperties) {
        super(pProperties);
    }
    public void animateTick(BlockState p_221789_, Level p_221790_, BlockPos p_221791_, RandomSource p_221792_) {
        super.animateTick(p_221789_, p_221790_, p_221791_, p_221792_);
        if (p_221792_.nextInt(10) == 0) {
            p_221790_.addParticle(ParticleTypes.DOLPHIN, (double)p_221791_.getX() + p_221792_.nextDouble(), (double)p_221791_.getY() + p_221792_.nextDouble(), (double)p_221791_.getZ() + p_221792_.nextDouble(), 0.0, 0.0, 0.0);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }
    @Override public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(10) == 0) {
            for(int i = 0; i < 200; i++){
                if(pLevel.isEmptyBlock(pPos.offset(0, i, 0))&& !pLevel.canSeeSky(pPos.offset(0, i, 0))){
                    BlockState pState2 = pLevel.getBlockState((pPos.offset(0, i-1, 0)));
                    if(pState2.isFaceSturdy(pLevel, pPos.offset(0, i-1, 0), Direction.UP) == true) {
                        pLevel.setBlockAndUpdate(pPos.offset(0, i, 0), ModBlocks.CYAN_MUSHROOM.get().defaultBlockState());
                    }
                    break;
                }
                if(pLevel.getBlockState((pPos.offset(0, i, 0))).is(ModBlocks.CYAN_MUSHROOM.get())){
                    break;
                }
            }
        }
        super.randomTick(pState, pLevel, pPos, pRandom);
    }


}
