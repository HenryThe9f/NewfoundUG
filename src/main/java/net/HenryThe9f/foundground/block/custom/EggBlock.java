package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.entity.custom.WhelpEntity;
import net.HenryThe9f.foundground.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITag;

import java.util.Random;

public class EggBlock extends Block {
    public EggBlock(Properties pProperties) {
        super(pProperties);
    }
    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
        super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience);
        RandomSource pRand = RandomSource.create();
        if (pLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, pStack) == 0) {

            EntityType<?> AmberMob = ForgeRegistries.ENTITY_TYPES.tags().getTag(ModTags.Entities.AMBER_EGG_MOBS).getRandomElement(pRand).orElseGet(()-> EntityType.CHICKEN);

            Entity $$2 = AmberMob.create(pLevel);
            $$2.moveTo((double) pPos.getX() + 0.5, (double) pPos.getY(), (double) pPos.getZ() + 0.5, 0.0F, 0.0F);
            pLevel.addFreshEntity($$2);
                }
        }
}
