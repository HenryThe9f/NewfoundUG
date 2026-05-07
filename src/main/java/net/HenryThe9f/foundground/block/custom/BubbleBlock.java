package net.HenryThe9f.foundground.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class BubbleBlock extends HalfTransparentBlock{
    public BubbleBlock(Properties pProperties) {
        super(pProperties);
    }
    public FluidState getFluidState(BlockState pState) {
        super.getFluidState(pState);
        return Fluids.WATER.getSource(false);
    }



    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if(!pLevel.isClientSide) {
            ItemStack itemstack = new ItemStack(this.asItem());
            ItemEntity pEntity = new ItemEntity(pLevel, pPos.getCenter().x, pPos.getCenter().y, pPos.getCenter().z, itemstack);
            pLevel.addFreshEntity(pEntity);

        }
        pLevel.setBlockAndUpdate(pPos, Blocks.AIR.defaultBlockState());
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }


}
