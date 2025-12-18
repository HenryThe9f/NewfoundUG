package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;


public class ThornVineBlock extends Block implements SimpleWaterloggedBlock {
    private static final BooleanProperty WATERLOGGED;

    public static final BooleanProperty BOTTOM;

    public ThornVineBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState) this.stateDefinition.any()).setValue(BOTTOM, true)).setValue(WATERLOGGED, false));
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_153340_) {
        BlockState $$1 = super.getStateForPlacement(p_153340_);
        if ($$1 != null) {
            FluidState $$2 = p_153340_.getLevel().getFluidState(p_153340_.getClickedPos());
            return (BlockState)$$1.setValue(WATERLOGGED, $$2.getType() == Fluids.WATER);
        } else {
            return null;
        }
    }
    public FluidState getFluidState(BlockState p_153360_) {
        return (Boolean)p_153360_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_153360_);
    }
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        pEntity.hurt(pLevel.damageSources().cactus(), 2.0F);

    }
    public static final VoxelShape SHAPE = Block.box(1, 1, 1, 15, 15, 15);
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }



   public BlockState updateShape(BlockState pState1, Direction pDirection, BlockState pState2, LevelAccessor pLevel, BlockPos pPos1, BlockPos pPos2) {
       if (pDirection == Direction.UP && !this.canSurvive(pState1, pLevel, pPos1)) {
           return Blocks.AIR.defaultBlockState();
       } else {
           if ((Boolean)pState1.getValue(WATERLOGGED)) {
               pLevel.scheduleTick(pPos1, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
           }
           pState2 = pLevel.getBlockState(pPos1.below());
           if (pState2.isFaceSturdy(pLevel, pPos1.below(), Direction.UP) || pState2.is(ModBlocks.THORN_VINES.get())) {
               pLevel.setBlock(pPos1, pState1.setValue(BOTTOM, false), 2);
           } else {
               pLevel.setBlock(pPos1, pState1.setValue(BOTTOM, true), 2);
           }

           return super.updateShape(pState1, pDirection, pState2, pLevel, pPos1, pPos2);
       }
   }

   // public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving, LevelReader levelReader) {
       // BlockState blockstate = pLevel.getBlockState(pPos.below());
       // if (blockstate.isFaceSturdy(levelReader, pPos.below(), Direction.UP)) {
        //    pLevel.setBlock(pPos, pState.setValue(BOTTOM, true), 2);
      //  } else {
       //     pLevel.setBlock(pPos, pState.setValue(BOTTOM, false), 2);
      //  }

  //  }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos $$3 = pPos.above();
        BlockState $$4 = pLevel.getBlockState($$3);
        if($$4.is(ModBlocks.THORN_VINES.get())){
            return true;
                }
        else { return $$4.isFaceSturdy(pLevel, $$3, Direction.DOWN);}
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{WATERLOGGED, BOTTOM});
    }
    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;

        BOTTOM = BlockStateProperties.BOTTOM;

    }
}
