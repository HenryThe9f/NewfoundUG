package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.entity.custom.SulphurSlimeDropEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class SlimeLayerBlock extends FallingBlock {
    public static final int MAX_HEIGHT = 4;
    public static final IntegerProperty LAYERS;
    public SlimeLayerBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(LAYERS, 1));

    }


    public static final VoxelShape ONES = Block.box(0, 0, 0, 16, 4, 16);
    public static final VoxelShape TWOS = Block.box(0, 0, 0, 16, 8, 16);

    public static final VoxelShape THREES = Block.box(0, 0, 0, 16, 12, 16);
    public static final VoxelShape FULL = Block.box(0, 0, 0, 16, 16, 16);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch (pState.getValue(LAYERS)){
            case 1:
                return ONES;
            case 2:
                return TWOS;
            case 3:
                return THREES;
        }
        return FULL;

    }
    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
        if (pEntity.isSuppressingBounce()) {
            super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
        } else {
            pEntity.causeFallDamage(pFallDistance, 0.0F, pLevel.damageSources().fall());
        }

    }

    public void updateEntityAfterFallOn(BlockGetter pLevel, Entity pEntity) {
        if (pEntity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(pLevel, pEntity);
        } else {
            this.bounceUp(pEntity);
        }

    }

    private void bounceUp(Entity pEntity) {
        Vec3 $$1 = pEntity.getDeltaMovement();
        if ($$1.y < 0.0) {
            double $$2 = pEntity instanceof LivingEntity ? 1.0 : 0.8;
            pEntity.setDeltaMovement($$1.x, -$$1.y * $$2, $$1.z);
        }

    }




    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        double $$4 = Math.abs(pEntity.getDeltaMovement().y);
        if ($$4 < 0.1 && !pEntity.isSteppingCarefully()) {
            double $$5 = 0.4 + $$4 * 0.2;
            pEntity.setDeltaMovement(pEntity.getDeltaMovement().multiply($$5, 1.0, $$5));
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
    static {
        LAYERS = BlockStateProperties.LAYERS;
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{LAYERS});
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState $$1 = pContext.getLevel().getBlockState(pContext.getClickedPos());
        if ($$1.is(this)) {
            int $$2 = (Integer)$$1.getValue(LAYERS);
            return (BlockState)$$1.setValue(LAYERS, Math.min(4, $$2 + 1));
        } else {
            return super.getStateForPlacement(pContext);
        }
    }


    public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
        int $$2 = (Integer)pState.getValue(LAYERS);
        if (pUseContext.getItemInHand().is(this.asItem()) && $$2 < 4) {
            if (pUseContext.replacingClickedOnBlock()) {
                return pUseContext.getClickedFace() == Direction.UP;
            } else {
                return true;
            }
        } else {
            return $$2 == 1;
        }
    }
}
