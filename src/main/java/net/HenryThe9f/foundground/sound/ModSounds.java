package net.HenryThe9f.foundground.sound;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Newfound_Underground.MODID);

    public static final RegistryObject<SoundEvent> WHELP_IDLE = registerSoundEvents("whelp_idle");
    public static final RegistryObject<SoundEvent> WHELP_HURT = registerSoundEvents("whelp_hurt");
    public static final RegistryObject<SoundEvent> WHELP_DEATH = registerSoundEvents("whelp_death");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name){
        return SOUND_EVENTS.register(name, ()-> SoundEvent.createVariableRangeEvent(new ResourceLocation(Newfound_Underground.MODID, name)));
    }
public static void register(IEventBus eventBus) {
    SOUND_EVENTS.register(eventBus);

    }
}
