package net.HenryThe9f.foundground.event;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.item.Moditems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

    @Mod.EventBusSubscriber(modid = Newfound_Underground.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public class ModForgeEvents {


        @SubscribeEvent
        public static void onLivingDamage(LivingDamageEvent event) {

            if (event.getEntity() instanceof Player pPlayer && pPlayer.getMainHandItem().getItem() == Moditems.CLIMBING_CLAWS.get()) {
                ItemStack MHstack = pPlayer.getMainHandItem();
                //pPlayer.sendSystemMessage(Component.literal( "debug!"));
                MHstack.shrink(1);
                ItemStack Nstack = new ItemStack(Moditems.BROKEN_CLIMBING_CLAWS.get(), 1);
               pPlayer.addItem(Nstack);
            }    if (event.getEntity() instanceof Player pPlayer && pPlayer.getOffhandItem().getItem() == Moditems.CLIMBING_CLAWS.get()) {
                ItemStack MHstack = pPlayer.getOffhandItem();
              //  pPlayer.sendSystemMessage(Component.literal( "debug2!"));
                MHstack.shrink(1);
                ItemStack Nstack = new ItemStack(Moditems.BROKEN_CLIMBING_CLAWS.get(), 1);
                pPlayer.setItemInHand(InteractionHand.OFF_HAND, Nstack);
            }
        }
}
