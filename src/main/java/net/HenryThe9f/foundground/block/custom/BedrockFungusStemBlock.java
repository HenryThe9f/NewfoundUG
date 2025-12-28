package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class BedrockFungusStemBlock extends Block implements BonemealableBlock {
    public BedrockFungusStemBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }
    @Override public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRand) {
        if (pRand.nextInt(8) == 0) {
            this.Stemmaker(pState, pLevel, pPos, pRand);

        }
        super.randomTick(pState, pLevel, pPos, pRand);
    }
    public void Stemmaker(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRand) {
        if (pRand.nextInt(25) == 0){
            if(!pLevel.isClientSide && pLevel.isEmptyBlock(pPos.offset(0,1,0))) { //cap
                if (pPos.getY() >= 192) {
                    pLevel.setBlockAndUpdate(pPos.offset(0, 1, 0), ModBlocks.LAPIS_BEDROCK_FUNGUS_CAP.get().defaultBlockState());
                } else {
                    pLevel.setBlockAndUpdate(pPos.offset(0, 1, 0), ModBlocks.BEDROCK_FUNGUS_CAP.get().defaultBlockState());
                }
            }
        } else {
            if(!pLevel.isClientSide && pLevel.isEmptyBlock(pPos.offset(0,1,0))) { //stem
                pLevel.setBlockAndUpdate(pPos.offset(0, 1, 0), ModBlocks.BEDROCK_FUNGUS_STEM.get().defaultBlockState());
            }
        }

    }
    public boolean isValidBonemealTarget(LevelReader p_256534_, BlockPos p_256299_, BlockState p_255926_, boolean p_255711_) {
        return p_256534_.getBlockState(p_256299_.above()).isAir();
    } //copied from mangrove leaves

    public boolean isBonemealSuccess(Level p_221437_, RandomSource p_221438_, BlockPos p_221439_, BlockState p_221440_) {
        return true;
    }

    public void performBonemeal(ServerLevel pLevel, RandomSource pRand, BlockPos pPos, BlockState pState) {
        this.Stemmaker(pState, pLevel, pPos, pRand);
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState pState = super.getStateForPlacement(pContext);
        BlockPos pPos = pContext.getClickedPos();
        if (this.canSurvive(pState, pContext.getLevel(), pPos)) {
            return pState;
        }
            return null;
    }
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos pPosb = pPos.below();
        BlockState pStateb = pLevel.getBlockState(pPosb);
        if(pStateb.is(ModBlocks.BEDROCK_FUNGUS_STEM.get()) || pStateb.is(Blocks.BEDROCK)){
            return true;
        }
        else { return false;}
    }
    public BlockState updateShape(BlockState pState1, Direction pDirection, BlockState pState2, LevelAccessor pLevel, BlockPos pPos1, BlockPos pPos2) {
        if (!this.canSurvive(pState1, pLevel, pPos1)) {
            return Blocks.AIR.defaultBlockState();
        } else return super.updateShape(pState1, pDirection, pState2, pLevel, pPos1, pPos2);
    }
    public static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
