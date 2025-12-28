package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.entity.custom.WhelpEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class FrozenWhelpBlock extends Block {
    public FrozenWhelpBlock(Properties pProperties) {
        super(pProperties);
    }

    //copied from infested stone

    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
        super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience);
        if (pLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, pStack) == 0) {
            for(int i=0; i<3; i++) {
                WhelpEntity $$2 = (WhelpEntity) ModEntities.WHELP.get().create(pLevel);
            if ($$2 != null) {
                    $$2.moveTo((double) pPos.getX() + 0.5, (double) pPos.getY(), (double) pPos.getZ() + 0.5, 0.0F, 0.0F);
                    pLevel.addFreshEntity($$2);
                    $$2.spawnAnim();
                }

            }
        }

    }
   @Override public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {

        super.tick(pState, pLevel, pPos, pRandom);
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(25) == 0) {
            pLevel.playLocalSound((double) pPos.getX() + 0.5, (double) pPos.getY() + 0.5, (double) pPos.getZ() + 0.5, SoundEvents.AMBIENT_CAVE.get(), SoundSource.BLOCKS, 0.5F, pRandom.nextFloat() * 0.4F + 0.8F, false);
            Vec3 $$3 = Vec3.atBottomCenterOf(pPos).add(0.0, 1.2000000476837158, 0.0);
            pLevel.addParticle(ParticleTypes.NOTE, $$3.x(), $$3.y(), $$3.z(), 0.0, 1.0, 0.0);
        }
    }
}
