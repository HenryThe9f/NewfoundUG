package net.HenryThe9f.foundground.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class PetrifiedBlock extends Block {


    public PetrifiedBlock(Properties pProperties) {
        super(pProperties);




    }
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        this.tryAbsorbWater(pLevel, pPos, pState);
        super.neighborChanged(pState, pLevel, pPos, pBlock, pFromPos, pIsMoving);
    }
    protected void tryAbsorbWater(Level pLevel, BlockPos pPos, BlockState pState) {
        pState = pLevel.getBlockState(pPos.above());
        if (pState.is(Blocks.WATER)) {

            pLevel.setBlock(pPos, Blocks.JUNGLE_WOOD.defaultBlockState(), 2);
        }

    }
}
