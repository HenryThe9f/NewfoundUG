package net.HenryThe9f.foundground.item.custom;
import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.entity.custom.GnomeEntity;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.gameevent.GameEvent;

public class GnomeItem extends Item {
    public GnomeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
       if(pContext.getLevel().isEmptyBlock( pContext.getClickedPos().relative(pContext.getClickedFace()))){

           GnomeEntity GnomeSpawn = ModEntities.GNOME.get().create(pContext.getLevel());
           GnomeSpawn.moveTo(pContext.getClickedPos().relative(pContext.getClickedFace()).getCenter().x, pContext.getClickedPos().relative(pContext.getClickedFace()).getCenter().y-0.5, pContext.getClickedPos().relative(pContext.getClickedFace()).getCenter().z, 0.0f, 0.0f);
           GnomeSpawn.lookAt(pContext.getPlayer(), 360, 0);


           if(!pContext.getLevel().isClientSide) {
              pContext.getLevel().addFreshEntity(GnomeSpawn);
              GnomeSpawn.gameEvent(GameEvent.ENTITY_PLACE, pContext.getPlayer());
              pContext.getItemInHand().shrink(1);
          GnomeSpawn.syncRotToFacing();
           }

       }

        return super.useOn(pContext);
    }
}
