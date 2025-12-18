package net.HenryThe9f.foundground.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class IcePickItem extends Item {
    public IcePickItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player pPlayer = pContext.getPlayer();

        pPlayer.setDeltaMovement(pPlayer.getLookAngle().multiply(1.05f, 1.05f, 1.05f));
        pPlayer.getCooldowns().addCooldown(this, 7);
        return InteractionResult.SUCCESS;
    }

}
