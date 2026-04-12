package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DenseCoalBlock extends DropExperienceBlock {

    public DenseCoalBlock(Properties pProperties, IntProvider pXpRange) {
        super(pProperties, pXpRange);
    }

    @Override
    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
        super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience);
        if (pLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, pStack) == 0) {

            RandomSource pRand = RandomSource.create();
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    if (pLevel.getBlockState(pPos.offset(i, j, k)).is(Blocks.AIR) && pRand.nextInt(2) == 1) {
                        pLevel.setBlockAndUpdate(pPos.offset(i, j, k), ModBlocks.COAL_DUST.get().defaultBlockState());
                    }
                }
            }
            }
        }
    }
}
