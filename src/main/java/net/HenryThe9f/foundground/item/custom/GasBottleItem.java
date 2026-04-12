package net.HenryThe9f.foundground.item.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.item.Moditems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GasBottleItem extends BlockItem {
    public GasBottleItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }
    public InteractionResult useOn(UseOnContext pContext) {
        InteractionResult interactionresult = this.place(new BlockPlaceContext(pContext));
           Player pPlayer = pContext.getPlayer();
            InteractionHand pHand = pContext.getHand();
           ItemStack itemstack = pPlayer.getItemInHand(pHand);
            ItemStack itemstack1 = new ItemStack(Items.GLASS_BOTTLE);
            Level pLevel = pContext.getLevel();
            if (itemstack.isEmpty()) {
                pPlayer.setItemInHand(pHand, itemstack1);
            } else if (!pPlayer.addItem(itemstack1)) {
                pPlayer.drop(itemstack1, false);
            }
            pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.BOTTLE_FILL_DRAGONBREATH, SoundSource.NEUTRAL, 1.0F, 1.0F);

            InteractionResult interactionresult1 = this.use(pContext.getLevel(), pContext.getPlayer(), pContext.getHand()).getResult();

        return interactionresult;

    }







}
