package net.HenryThe9f.foundground.block.custom;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;


public class ShroomiteLauncherSlabBlock extends SlabBlock {

    public ShroomiteLauncherSlabBlock(Properties pProperties) {
        super(pProperties);
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
            pEntity.setDeltaMovement(Math.signum($$1.x)*(Math.min(Math.abs($$1.x)*10, 2)), 0.5, (Math.signum($$1.z)*(Math.min(Math.abs($$1.z)*10, 2))));
            //note to self: this line right here. multiply the values in this line for funny stuff
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
}


