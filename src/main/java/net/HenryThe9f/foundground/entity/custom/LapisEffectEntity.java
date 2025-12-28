package net.HenryThe9f.foundground.entity.custom;

import net.HenryThe9f.foundground.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

public class LapisEffectEntity extends BlockEntity {
    private static final int BLOCKS_CHECK_PER_TICK = 10;
private final AABB aabb = (new AABB(this.worldPosition)).inflate(15).expandTowards(0.0, 0.0, 0.0);
    public LapisEffectEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.LAPIS_EFFECT_BLOCKENTITY.get(), pPos, pBlockState);
    }

public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
    //debug pLevel.playSound((Player)null, pPos, SoundEvents.BEACON_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F);
    if (pLevel.getGameTime() % 80L == 0L) {
            applyEffects(pLevel, pPos);
    }

}

    private void applyEffects(Level pLevel, BlockPos pPos) {
        if (!pLevel.isClientSide) {
            //AABB aabb = (new AABB(pPos)).inflate(15).expandTowards(0.0, 0.0, 0.0);
            List<Player> list = pLevel.getEntitiesOfClass(Player.class, aabb);
            Iterator var11 = list.iterator();

            Player player1;
            while(var11.hasNext()) {
                player1 = (Player)var11.next();
                player1.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0, true, true));
            }
        }

    }
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        for(int $$4 = 0; $$4 < 3; ++$$4) {
            int $$5 = pRandom.nextInt(2) * 2 - 1;
            int $$6 = pRandom.nextInt(2) * 2 - 1;
            double $$7 = (double)pPos.getX() + 0.5 + 0.25 * (double)$$5;
            double $$8 = (double)((float)pPos.getY() + pRandom.nextFloat());
            double $$9 = (double)pPos.getZ() + 0.5 + 0.25 * (double)$$6;
            double $$10 = (double)(pRandom.nextFloat() * (float)$$5);
            double $$11 = ((double)pRandom.nextFloat() - 0.5) * 0.125;
            double $$12 = (double)(pRandom.nextFloat() * (float)$$6);
            pLevel.addParticle(ParticleTypes.PORTAL, $$7, $$8, $$9, $$10, $$11, $$12);
        }

    }
}
