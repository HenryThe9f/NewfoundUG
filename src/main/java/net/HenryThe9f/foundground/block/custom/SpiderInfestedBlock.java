package net.HenryThe9f.foundground.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SpiderInfestedBlock extends Block {
    public SpiderInfestedBlock(Properties pProperties) {
        super(pProperties);
    }

    //copied from infested stone

    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
        super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience);
        if (pLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, pStack) == 0) {
            CaveSpider $$2 = (CaveSpider) EntityType.CAVE_SPIDER.create(pLevel);
            if ($$2 != null) {
                $$2.moveTo((double)pPos.getX() + 0.5, (double)pPos.getY(), (double)pPos.getZ() + 0.5, 0.0F, 0.0F);
                pLevel.addFreshEntity($$2);
                $$2.spawnAnim();
            }
        }

    }
}
