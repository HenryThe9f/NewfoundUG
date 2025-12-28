package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.entity.ModBlockEntities;
import net.HenryThe9f.foundground.entity.custom.LapisEffectEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class LapisEffectBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    private static final BooleanProperty WATERLOGGED;

    protected LapisEffectBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((BlockState)((BlockState) this.stateDefinition.any()).setValue(WATERLOGGED, false));

    }


    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide()) {
            return null;
        }

        return createTickerHelper(pBlockEntityType, ModBlockEntities.LAPIS_EFFECT_BLOCKENTITY.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new LapisEffectEntity(blockPos, blockState);
    }

    public FluidState getFluidState(BlockState p_153360_) {
        return (Boolean)p_153360_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_153360_);
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{WATERLOGGED});
    }
    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;


    }
    public static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 13, 15);
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
