package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockState;

public class OreangeOreBlock extends DropExperienceBlock {
    public OreangeOreBlock(Properties pProperties, IntProvider pXpRange) {
        super(pProperties, pXpRange);
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }
    @Override public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {

            int i = pRandom.nextInt(3);
            int j = pRandom.nextInt(3);
            int k = pRandom.nextInt(3);
            if(pLevel.getBlockState(pPos.offset(i-1, j-1, k-1)).is(Blocks.JUNGLE_WOOD) || pLevel.getBlockState(pPos.offset(i-1, j-1, k-1)).is(Blocks.JUNGLE_LOG)){
                if((pLevel.getBlockState(pPos.offset(i-1, j, k-1)).is(Blocks.SCULK))||(pLevel.getBlockState(pPos.offset(i-1, j, k-1)).is(Blocks.SCULK_VEIN))){
                    pLevel.setBlockAndUpdate(pPos.offset(i-1, j-1, k-1), ModBlocks.FORBIDDEN_FRUIT_ORE.get().defaultBlockState());
                }else {
                    pLevel.setBlockAndUpdate(pPos.offset(i-1, j-1, k-1), ModBlocks.AMBER_ORE.get().defaultBlockState());
                }
            }


    }


}
