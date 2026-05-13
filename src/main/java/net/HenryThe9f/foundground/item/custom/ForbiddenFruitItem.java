package net.HenryThe9f.foundground.item.custom;

import net.HenryThe9f.foundground.util.ModTags;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class ForbiddenFruitItem extends Item {
    public ForbiddenFruitItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        if(pInteractionTarget.getType().is(ModTags.Entities.FORBIDDEN_FRUIT_EATERS)) {
            if (pInteractionTarget.level().isClientSide) {
                pInteractionTarget.level().addParticle((ParticleTypes.EXPLOSION_EMITTER), (double)pInteractionTarget.getX(), (double)pInteractionTarget.getY() + 1.1, (double)pInteractionTarget.getZ(), 0, 0, 0);
            }
            if (!pInteractionTarget.level().isClientSide) {
                RandomSource pRand = RandomSource.create();
                EntityType<?> AmberMob = ForgeRegistries.ENTITY_TYPES.tags().getTag(ModTags.Entities.AMBER_EGG_MOBS).getRandomElement(pRand).orElseGet(() -> EntityType.CHICKEN);
                Entity $$2 = AmberMob.create(pInteractionTarget.level());
                $$2.moveTo((double) pInteractionTarget.getX(), (double) pInteractionTarget.getY(), (double) pInteractionTarget.getZ(), 0.0F, 0.0F);
                pInteractionTarget.level().addFreshEntity($$2);
                pInteractionTarget.discard();
            }

        }
        return super.interactLivingEntity(pStack, pPlayer, pInteractionTarget, pUsedHand);
    }
}
