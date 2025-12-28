package net.HenryThe9f.foundground.entity.custom;


import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.block.custom.GlowClusterBlock;
import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.item.Moditems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;


public class GoldSporeEntity extends ThrowableItemProjectile {


    public GoldSporeEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public GoldSporeEntity(Level pLevel) {
        super(ModEntities.GOLD_SPORE_PROJECTILE.get(), pLevel);
    }
    public GoldSporeEntity(Level pLevel, double pX, double pY, double pZ) {
        super(ModEntities.GOLD_SPORE_PROJECTILE.get(), pX, pY, pZ, pLevel);
    }

    public GoldSporeEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.GOLD_SPORE_PROJECTILE.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return Moditems.GOLD_SPORES.get();
    }


   // public void handleEntityEvent(byte pId) {
   //     if (pId == 3) {
   //         this.level().addParticle(ParticleTypes.FLASH, this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08);

    //    }
   // }
    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            this.level().addParticle(ParticleTypes.INSTANT_EFFECT, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        }

    }

    public boolean isCurrentlyGlowing() {
        Level pLevel = this.level();
        if (pLevel.getBlockState(this.blockPosition()).is(Blocks.AIR) || pLevel.getBlockState(this.blockPosition()).is(Blocks.CAVE_AIR)) {
            return true;
        } else {
            return false;
        }
    }


}

