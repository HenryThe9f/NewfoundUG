package net.HenryThe9f.foundground.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;

public class FragileBlock extends Block {
    public FragileBlock(Properties pProperties) {
        super(pProperties);
    }
/*
    public void fa(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {

        double Speed = (pEntity.getDeltaMovement().y);

        if (!pEntity.isSteppingCarefully() && pEntity instanceof Player) {
            pLevel.destroyBlock(pPos, false);

        }

    }
    */
public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
    if (!pLevel.isClientSide && pEntity instanceof Player) {

        pLevel.destroyBlock(pPos, false);
    }

    super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
}

    @Override
    public void updateEntityAfterFallOn(BlockGetter pLevel, Entity pEntity) {

        super.updateEntityAfterFallOn(pLevel, pEntity);
    }

//  public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);
  //  @Override
  //  public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
    //    return SHAPE;
  //  }
}
