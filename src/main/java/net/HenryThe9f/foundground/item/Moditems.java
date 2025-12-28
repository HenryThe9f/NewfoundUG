package net.HenryThe9f.foundground.item;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.item.custom.GoldSporeItem;
import net.HenryThe9f.foundground.item.custom.IcePickItem;
import net.HenryThe9f.foundground.item.custom.WhelpTorchItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Newfound_Underground.MODID);

    public static final RegistryObject<Item> GOLD_SPORES = ITEMS.register("gold_spores", ()->new GoldSporeItem(new Item.Properties()));

    public static final RegistryObject<Item> WHELP_TORCH = ITEMS.register("whelp_torch", ()->new WhelpTorchItem(new Item.Properties()));

    public static final RegistryObject<Item> ICE_PICK = ITEMS.register("ice_pick", ()->new IcePickItem(new Item.Properties()));

    public static final RegistryObject<Item> WHELP_SPAWN_EGG = ITEMS.register("whelp_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WHELP, 0x8c6c72, 0xf9bbc1, new Item.Properties()));

    public static final RegistryObject<Item> BLINDING_STEW = ITEMS.register("blinding_stew", ()->new BowlFoodItem(new Item.Properties().food(ModFoods.BLINDING_STEW)));

    public static final RegistryObject<Item> RAW_WHELP = ITEMS.register("raw_whelp", ()->new Item(new Item.Properties().food(ModFoods.RAW_WHELP)));

    public static final RegistryObject<Item> COOKED_WHELP = ITEMS.register("cooked_whelp", ()->new Item(new Item.Properties().food(ModFoods.COOKED_WHELP)));

    public static final RegistryObject<Item> RAW_IRON_ROSE_ITEM = ITEMS.register("raw_iron_rose_item", ()->new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

