package net.HenryThe9f.foundground.event;


import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.entity.client.MobModelLayers;
import net.HenryThe9f.foundground.entity.client.WhelpModel;
import net.HenryThe9f.foundground.entity.custom.WhelpEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Newfound_Underground.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
@SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.WHELP.get(), WhelpEntity.createAttributes().build());
    }

}
