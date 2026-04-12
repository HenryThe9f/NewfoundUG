package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nullable;

import static java.lang.Math.pow;

public class ScumBlock extends BubbleBlock implements BonemealableBlock {
    public ScumBlock(Properties pProperties) {
        super(pProperties);
    }
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        super.entityInside(pState, pLevel, pPos, pEntity);
        if (pLevel instanceof ServerLevel && pEntity instanceof Player && pEntity.getBlockY()+pEntity.getBbHeight()/2 <= pPos.getY()+0.5) {
            LivingEntity $$4 = (LivingEntity)pEntity;
                $$4.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 80));
                pLevel.destroyBlock(new BlockPos(pPos), true, pEntity);
        }

    }




    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        for(int i = -2; i < 3; i++){
             for(int j = -2; j < 3; j++){
if(serverLevel.getBlockState(blockPos.offset(i, 0, j))==(Blocks.WATER.defaultBlockState()) && serverLevel.isEmptyBlock(blockPos.offset(i, 1, j)) && pow((j*j+i*i), 0.5)<2.1){
serverLevel.setBlockAndUpdate(blockPos.offset(i, 0, j), ModBlocks.SCUM.get().defaultBlockState());
              }
             }
        }
    }
}
