package net.HenryThe9f.foundground.block.custom;

import io.netty.util.Signal;
import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SignalGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class BedrockMyceliumAltarBlock extends Block {

    public BedrockMyceliumAltarBlock(Properties pProperties) {
        super(pProperties);

    }


    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        pLevel.scheduleTick(pPos, pState.getBlock(), 1);
        super.onPlace(pState, pLevel, pPos, pOldState, pMovedByPiston);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        for(int i = 0; i < 400; i++){
            if(pLevel.isEmptyBlock(pPos.offset(0, i, 0))){
                    pLevel.setBlockAndUpdate(pPos.offset(0, i, 0), ModBlocks.BEDROCK_MYCELIUM.get().defaultBlockState());
                break;
            }
            if(pLevel.getBlockState((pPos.offset(0, i, 0))).is(ModBlocks.BEDROCK_MYCELIUM.get())){
                break;
            }
        }
        super.tick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
        if(pLevel.hasNeighborSignal(pPos)){
            pLevel.scheduleTick(pPos, pState.getBlock(), 1);
        }
        super.neighborChanged(pState, pLevel, pPos, pNeighborBlock, pNeighborPos, pMovedByPiston);
    }
}
