package net.HenryThe9f.foundground.entity.custom;


import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.item.Moditems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;


public class SulphurSlimeDropEntity extends ThrowableItemProjectile {


    public SulphurSlimeDropEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SulphurSlimeDropEntity(Level pLevel) {
        super(ModEntities.SULPHUR_SLIME_DROP.get(), pLevel);
    }
    public SulphurSlimeDropEntity(Level pLevel, double pX, double pY, double pZ) {
        super(ModEntities.SULPHUR_SLIME_DROP.get(), pX, pY, pZ, pLevel);
    }

    public SulphurSlimeDropEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.SULPHUR_SLIME_DROP.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return Moditems.SULPHUR_SLIMEBALL.get();
    }


   // public void handleEntityEvent(byte pId) {
   //     if (pId == 3) {
   //         this.level().addParticle(ParticleTypes.FLASH, this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08);

    //    }
   // }

    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            if(this.level().isEmptyBlock(this.getOnPos()))
            this.level().setBlockAndUpdate(this.getOnPos(), ModBlocks.SLIME_PUDDLE.get().defaultBlockState());

            this.discard();
        }

    }



}

