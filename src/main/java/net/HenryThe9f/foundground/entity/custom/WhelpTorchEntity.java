package net.HenryThe9f.foundground.entity.custom;


import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.item.Moditems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;


public class WhelpTorchEntity extends ThrowableItemProjectile {


    public WhelpTorchEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public WhelpTorchEntity(Level pLevel) {
        super(ModEntities.WHELP_TORCH_PROJECTILE.get(), pLevel);
    }
    public WhelpTorchEntity(Level pLevel, double pX, double pY, double pZ) {
        super(ModEntities.WHELP_TORCH_PROJECTILE.get(), pX, pY, pZ, pLevel);
    }

    public WhelpTorchEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.WHELP_TORCH_PROJECTILE.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return Moditems.WHELP_TORCH.get();
    }


   // public void handleEntityEvent(byte pId) {
   //     if (pId == 3) {
   //         this.level().addParticle(ParticleTypes.FLASH, this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08);

    //    }
   // }
    int i = 5;
    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);

        }
        if (!this.level().isClientSide) {
            i = i + 1;
        if (this.level().isEmptyBlock(this.blockPosition()) && i > 4) {
            this.level().setBlockAndUpdate(this.blockPosition(), ModBlocks.BURNING_FUR.get().defaultBlockState());
            i = 0;
        }
    }
   }
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.discard();
        }

    }
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (!this.level().isClientSide) {
            Entity entity = pResult.getEntity();
            Entity entity1 = this.getOwner();
            int i = entity.getRemainingFireTicks();
            entity.setSecondsOnFire(5);

        }

    }
}

