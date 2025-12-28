package net.HenryThe9f.foundground.event;


import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.entity.client.MobModelLayers;
import net.HenryThe9f.foundground.entity.client.WhelpModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Newfound_Underground.MODID, bus= Mod.EventBusSubscriber.Bus.MOD, value= Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(MobModelLayers.WHELP_LAYER, WhelpModel::createBodyLayer);
    }

}
