package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;




public class CastleGateBlock extends Block {

    public static final BooleanProperty POWERED;
    public static final IntegerProperty LEVEL;
    public CastleGateBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(POWERED, false)).setValue(LEVEL, 1));

    }

    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {

        boolean flag = pLevel.hasNeighborSignal(pPos);

        if (flag != pState.getValue(POWERED) ||  pState.getValue(LEVEL) != pLevel.getBestNeighborSignal(pPos)) {


           if (flag) {

               // pLevel.setBlock(pPos, pState.setValue(LEVEL, pLevel.getBestNeighborSignal(pPos)), 2);
                pState = pState.setValue(LEVEL, pLevel.getBestNeighborSignal(pPos));
               for(int i = 0; i<15; i++) {
                   if (pLevel.getBlockState((pPos.offset(0, -Mth.clamp(i + 1, 1, 15), 0))).is(Blocks.IRON_BARS)) {
                       pLevel.setBlockAndUpdate(pPos.offset(0, -Mth.clamp(i + 1, 1, 15), 0), Blocks.AIR.defaultBlockState());
                   }
               }
                for(int i = 0; i < pState.getValue(LEVEL); i++) {
                    if (pLevel.isEmptyBlock(pPos.offset(0, -Mth.clamp(i+1, 1, 15), 0))){
                    pLevel.setBlockAndUpdate(pPos.offset(0, -Mth.clamp(i+1, 1, 15), 0), Blocks.IRON_BARS.defaultBlockState());}
                }
            } else if (!flag) {
                for(int i = 0; i<15; i++) {
                    if (pLevel.getBlockState((pPos.offset(0, -Mth.clamp(i+1, 1, 15), 0))).is(Blocks.IRON_BARS)){
                    pLevel.setBlockAndUpdate(pPos.offset(0, -Mth.clamp(i+1, 1, 15), 0), Blocks.AIR.defaultBlockState());}
                }
            }
            pLevel.setBlock(pPos, pState.setValue(POWERED, flag), 2);


        }

    }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{LEVEL, POWERED});
    }
    static {
        POWERED = BlockStateProperties.POWERED;
        LEVEL = BlockStateProperties.LEVEL;
    }

}