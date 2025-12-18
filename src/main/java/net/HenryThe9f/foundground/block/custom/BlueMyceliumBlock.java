package net.HenryThe9f.foundground.block.custom;

//overriding results in both kinds of particle.

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.world.level.block.LiquidBlock.LEVEL;

public class BlueMyceliumBlock extends SpreadingSnowyDirtBlock {
    public BlueMyceliumBlock(BlockBehaviour.Properties p_54898_) {
        super(p_54898_);
    }

    public void animateTick(BlockState p_221789_, Level p_221790_, BlockPos p_221791_, RandomSource p_221792_) {
        super.animateTick(p_221789_, p_221790_, p_221791_, p_221792_);
        if (p_221792_.nextInt(10) == 0) {
            p_221790_.addParticle(ParticleTypes.DOLPHIN, (double)p_221791_.getX() + p_221792_.nextDouble(), (double)p_221791_.getY() + 1.1, (double)p_221791_.getZ() + p_221792_.nextDouble(), 0.0, 0.0, 0.0);
        }


    }
    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
        super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience);
        if (pLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, pStack) == 0) {
            pLevel.setBlockAndUpdate(pPos.offset(0, 0, 0), Blocks.LAVA.defaultBlockState().setValue(LEVEL, 7));
        }

    }
}
