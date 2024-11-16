package net.HenryThe9f.foundground.item;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Newfound_Underground.MODID);





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

