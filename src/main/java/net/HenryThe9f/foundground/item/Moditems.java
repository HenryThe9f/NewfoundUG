package net.HenryThe9f.foundground.item;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.item.custom.GasBottleItem;
import net.HenryThe9f.foundground.item.custom.GoldSporeItem;
import net.HenryThe9f.foundground.item.custom.IcePickItem;
import net.HenryThe9f.foundground.item.custom.WhelpTorchItem;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> CLIMBING_CLAWS = ITEMS.register("climbing_claws", ()->new IcePickItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BROKEN_CLIMBING_CLAWS = ITEMS.register("broken_climbing_claws", ()->new Item(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> WHELP_SPAWN_EGG = ITEMS.register("whelp_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WHELP, 0x8c6c72, 0xf9bbc1, new Item.Properties()));

    public static final RegistryObject<Item> BLINDING_STEW = ITEMS.register("blinding_stew", ()->new BowlFoodItem(new Item.Properties().food(ModFoods.BLINDING_STEW)));

    public static final RegistryObject<Item> RAW_WHELP = ITEMS.register("raw_whelp", ()->new Item(new Item.Properties().food(ModFoods.RAW_WHELP)));

    public static final RegistryObject<Item> COOKED_WHELP = ITEMS.register("cooked_whelp", ()->new Item(new Item.Properties().food(ModFoods.COOKED_WHELP)));

    public static final RegistryObject<Item> RAW_IRON_ROSE_ITEM = ITEMS.register("raw_iron_rose_item", ()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> CAVE_SPIDER_INGOT = ITEMS.register("cave_spider_ingot", ()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> COAL_DUST_BOTTLE = ITEMS.register("coal_dust_bottle", ()->new GasBottleItem(ModBlocks.COAL_DUST.get(), new Item.Properties()));

    public static final RegistryObject<Item> EXTREMELY_RUDE_PICKAXE = ITEMS.register("extremely_crude_pickaxe", ()->new PickaxeItem(Tiers.WOOD, 0, 0, new Item.Properties()));

    public static final RegistryObject<Item> SULPHUR_DUST_BOTTLE = ITEMS.register("sulphur_dust_bottle", ()->new GasBottleItem(ModBlocks.SULPHUR_DUST.get(), new Item.Properties()));

    public static final RegistryObject<Item> SULPHUR_SLIMEBALL = ITEMS.register("sulphur_slimeball", ()->new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

