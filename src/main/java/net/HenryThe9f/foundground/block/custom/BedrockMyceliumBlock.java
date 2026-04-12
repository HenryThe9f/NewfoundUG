package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BedrockMyceliumBlock extends Block {
    public BedrockMyceliumBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos.below()).isFaceSturdy(pLevel, pPos.below(), Direction.UP);
    }
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (!pState.canSurvive(pLevel, pCurrentPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if(pEntity instanceof ItemEntity && ((ItemEntity) pEntity).getItem().getItem().getClass() == BlockItem.class && !((ItemEntity) pEntity).getItem().hasTag() && ((BlockItem) ((ItemEntity) pEntity).getItem().getItem()).getBlock().defaultBlockState().getFluidState().is(Fluids.EMPTY)){
            Block pBlock = ((BlockItem) ((ItemEntity) pEntity).getItem().getItem()).getBlock();
            if(pBlock.canSurvive(pBlock.defaultBlockState(), pLevel, pPos)) {
                ((ItemEntity) pEntity).getItem().setCount(((ItemEntity) pEntity).getItem().getCount() - 1);
                pEntity.moveTo(pPos.getX()+0.5, pPos.getY() + 1.5, pPos.getZ()+0.5);
                pLevel.setBlockAndUpdate(pPos, pBlock.defaultBlockState());
                for (int i = 0; i > -400; i--) {
                    if (pLevel.getBlockState((pPos.offset(0, i, 0))).is(ModBlocks.BEDROCK_MYCELIUM_ALTAR.get()) && pLevel.isEmptyBlock(pPos.above())){
                            pLevel.setBlockAndUpdate(pPos.above(), ModBlocks.BEDROCK_MYCELIUM.get().defaultBlockState());
                            break;
                    }
                    if (pLevel.isEmptyBlock(pPos.offset(0, i, 0))){
                        break;
                    }
                }
            }
        }
        super.entityInside(pState, pLevel, pPos, pEntity);
    }


    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
                return Block.box(0, 0, 0, 16, 1, 16);
    }
}
