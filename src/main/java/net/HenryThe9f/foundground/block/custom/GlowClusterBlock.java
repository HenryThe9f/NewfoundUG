package net.HenryThe9f.foundground.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class GlowClusterBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED;

    public GlowClusterBlock(Properties pProperties) {

        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));

    }

    public void animateTick(BlockState p_221789_, Level p_221790_, BlockPos p_221791_, RandomSource p_221792_) {
        super.animateTick(p_221789_, p_221790_, p_221791_, p_221792_);
        if (p_221792_.nextInt(1) == 0) {
            p_221790_.addParticle(ParticleTypes.INSTANT_EFFECT, (double)p_221791_.getX() + p_221792_.nextDouble(), (double)p_221791_.getY() + p_221792_.nextDouble(), (double)p_221791_.getZ() + p_221792_.nextDouble(), 0.0, 0.0, 0.0);
        }

    }
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        FluidState $$1 = pContext.getLevel().getFluidState(pContext.getClickedPos());
        boolean $$2 = $$1.getType() == Fluids.WATER;
        return (BlockState)super.getStateForPlacement(pContext).setValue(WATERLOGGED, $$2);
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if ((Boolean)pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{WATERLOGGED});
    }

    public FluidState getFluidState(BlockState pState) {
        return (Boolean)pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }
    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }
}

