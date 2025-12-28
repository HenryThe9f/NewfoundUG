package net.HenryThe9f.foundground.item.custom;

//import net.henrythe9ph.loot_geodes.entity.custom.GeodeGrenadeEntity;
import net.HenryThe9f.foundground.entity.custom.GoldSporeEntity;
import net.HenryThe9f.foundground.entity.custom.WhelpTorchEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class WhelpTorchItem extends Item {


    public WhelpTorchItem(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack $$3 = pPlayer.getItemInHand(pHand);
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.EGG_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            WhelpTorchEntity $$4 = new WhelpTorchEntity(pLevel, pPlayer);
            $$4.setItem($$3);
            $$4.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 2F, 0.0F);
            pLevel.addFreshEntity($$4);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            $$3.shrink(1);
        }


        return InteractionResultHolder.sidedSuccess($$3, pLevel.isClientSide());
    }
}
