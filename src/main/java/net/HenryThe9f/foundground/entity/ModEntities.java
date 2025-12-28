package net.HenryThe9f.foundground.entity;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.entity.custom.GoldSporeEntity;
import net.HenryThe9f.foundground.entity.custom.WhelpEntity;
import net.HenryThe9f.foundground.entity.custom.WhelpTorchEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Newfound_Underground.MODID);
    public static final RegistryObject<EntityType<GoldSporeEntity>> GOLD_SPORE_PROJECTILE =
            ENTITY_TYPES.register("gold_spore", () -> EntityType.Builder.<GoldSporeEntity>of(GoldSporeEntity::new, MobCategory.MISC)
                    .sized(0.25f, 0.25f).build("goldspore"));

    public static final RegistryObject<EntityType<WhelpTorchEntity>> WHELP_TORCH_PROJECTILE =
            ENTITY_TYPES.register("whelp_torch", () -> EntityType.Builder.<WhelpTorchEntity>of(WhelpTorchEntity::new, MobCategory.MISC)
                    .sized(0.25f, 0.25f).build("whelptorch"));

    public static final RegistryObject<EntityType<WhelpEntity>> WHELP =
            ENTITY_TYPES.register("whelp", () -> EntityType.Builder.of(WhelpEntity::new, MobCategory.CREATURE)
                    .sized(0.45f, 0.45f).build("whelp"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}