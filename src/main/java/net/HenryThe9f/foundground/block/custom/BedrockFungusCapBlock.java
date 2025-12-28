package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

import static java.lang.Math.abs;

public class BedrockFungusCapBlock extends Block {
    public BedrockFungusCapBlock(Properties pProperties) {
        super(pProperties);
    }

    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
        for(int i = 0; i >= -abs(pPos.getY()-pLevel.getMinBuildHeight()); i--){
            if(!pLevel.getBlockState(pPos.offset(0, i-1, 0)).is(ModBlocks.BEDROCK_FUNGUS_STEM.get())) {
break;
            }
                if (!pLevel.getBlockState(pPos.offset(0, i, 0)).is(Blocks.BEDROCK)) {
                    pLevel.setBlockAndUpdate(pPos.offset(0, i, 0), Blocks.AIR.defaultBlockState());
                    popResource(pLevel, pPos.offset(0, i, 0), new ItemStack(ModBlocks.BEDROCK_FUNGUS_STEM.get()));

            }
        }

        super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience);
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
}
