package net.HenryThe9f.foundground.entity;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.entity.custom.LapisEffectEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Newfound_Underground.MODID);
    public static final RegistryObject<BlockEntityType<LapisEffectEntity>> LAPIS_EFFECT_BLOCKENTITY =
            BLOCK_ENTITIES.register("lapis_effect_blockentity", () ->
                    BlockEntityType.Builder.of(LapisEffectEntity::new,
                            ModBlocks.LAPIS_LANTERN.get()).build(null));
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}

