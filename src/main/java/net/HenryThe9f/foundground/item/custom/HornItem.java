package net.HenryThe9f.foundground.item.custom;

import net.HenryThe9f.foundground.item.Moditems;
import net.HenryThe9f.foundground.sound.ModSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class HornItem extends Item {
    int t = 0;

    public HornItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        toot(pPlayer,pLevel);
        t = 0;
        return ItemUtils.startUsingInstantly(pLevel, (Player)pPlayer, pUsedHand);
    }

    public int getUseDuration(ItemStack pStack) {
        return 1200;
    }


    public void toot(LivingEntity pLivingEntity, Level pLevel){
      //  pLevel.addParticle(ParticleTypes.NOTE, pLivingEntity.getX()+pLivingEntity.getLookAngle().x * 2, 1+pLivingEntity.getY()+pLivingEntity.getLookAngle().y * 2, pLivingEntity.getZ()+pLivingEntity.getLookAngle().z * 2, 0.0, 1.0, 0.0);
        pLevel.playSound((Player)null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), ModSounds.TERRACOTTA_HORN.get(), SoundSource.PLAYERS, 1F, (float) (pLivingEntity.getLookAngle().y)+1.25f);

     //   pLevel.playSound((Player)null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), SoundEvents.ARROW_HIT_PLAYER, SoundSource.PLAYERS, 0.5F, 1.0F);
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {

        if(t > 9){
            toot(pLivingEntity,pLevel);

            t = 0;
        } else {
            t++;
        }
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.TOOT_HORN;
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        return pStack;
    }

}
