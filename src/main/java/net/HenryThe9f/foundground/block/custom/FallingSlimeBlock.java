package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.entity.custom.SulphurSlimeDropEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FallingSlimeBlock extends SlimeBlock {
    public FallingSlimeBlock(Properties pProperties) {
        super(pProperties);
    }


    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 4, 16);
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
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
    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
        if (pLevel.isEmptyBlock(pPos.offset(0, -1, 0))) {
            pLevel.setBlockAndUpdate(pPos, Blocks.AIR.defaultBlockState());

            if (!pLevel.isClientSide()) {
                SulphurSlimeDropEntity $$2 = (SulphurSlimeDropEntity) ModEntities.SULPHUR_SLIME_DROP.get().create(pLevel);
                $$2.moveTo((double) pPos.getX() + 0.5, (double) pPos.getY(), (double) pPos.getZ() + 0.5, 0.0F, 0.0F);
                pLevel.addFreshEntity($$2);

            }
        }


        super.neighborChanged(pState, pLevel, pPos, pNeighborBlock, pNeighborPos, pMovedByPiston);
    }
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        double $$4 = Math.abs(pEntity.getDeltaMovement().y);
        if ($$4 < 0.1 && !pEntity.isSteppingCarefully()) {
            double $$5 = 0.4 + $$4 * 0.2;
            pEntity.setDeltaMovement(pEntity.getDeltaMovement().multiply($$5, 1.0, $$5));
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
