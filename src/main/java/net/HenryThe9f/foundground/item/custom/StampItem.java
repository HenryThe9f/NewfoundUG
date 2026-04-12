package net.HenryThe9f.foundground.item.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.item.Moditems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.DOWN;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.UP;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.EAST;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.WEST;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.NORTH;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.SOUTH;
public class StampItem extends BlockItem {


    public StampItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public boolean doesSneakBypassUse(ItemStack stack, LevelReader level, BlockPos pos, Player player) {
        return false;
    }

@Override
    public InteractionResult useOn(UseOnContext pContext) {
    return this.place(new BlockPlaceContext(pContext));
}

    public InteractionResult place(BlockPlaceContext pContext) {
        for (int i = 0; i < 37; i++) {
            if (pContext.getPlayer().getInventory().getItem(i).is(Items.LAPIS_LAZULI)) {

                if (!this.getBlock().isEnabled(pContext.getLevel().enabledFeatures())) {
                    return InteractionResult.FAIL;
                } else if (!pContext.canPlace()) {
                    return InteractionResult.FAIL;
                } else {
                    BlockPlaceContext blockplacecontext = this.updatePlacementContext(pContext);
                    if (blockplacecontext == null) {
                        return InteractionResult.FAIL;
                    } else {
                        BlockState blockstate = this.getPlacementState(blockplacecontext);
                        if (blockstate == null) {
                            return InteractionResult.FAIL;
                        } else if (!this.placeBlock(blockplacecontext, blockstate)) {
                            return InteractionResult.FAIL;
                        } else {
                            BlockPos blockpos = blockplacecontext.getClickedPos();
                            Level level = blockplacecontext.getLevel();
                            Player player = blockplacecontext.getPlayer();
                            ItemStack itemstack = blockplacecontext.getItemInHand();
                            BlockState blockstate1 = level.getBlockState(blockpos);
                            if (blockstate1.is(blockstate.getBlock())) {
                                //  blockstate1 = this.updateBlockStateFromTag(blockpos, level, itemstack, blockstate1);
                                this.updateCustomBlockEntityTag(blockpos, level, player, itemstack, blockstate1);
                                blockstate1.getBlock().setPlacedBy(level, blockpos, blockstate1, player, itemstack);
                                if (player instanceof ServerPlayer) {
                                    CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) player, blockpos, itemstack);
                                }
                            }

                            SoundType soundtype = blockstate1.getSoundType(level, blockpos, pContext.getPlayer());
                            level.playSound(player, blockpos, this.getPlaceSound(blockstate1, level, blockpos, pContext.getPlayer()), SoundSource.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
                            level.gameEvent(GameEvent.BLOCK_PLACE, blockpos, GameEvent.Context.of(player, blockstate1));
                            pContext.getPlayer().getInventory().getItem(i).shrink(1);


                            return InteractionResult.sidedSuccess(level.isClientSide);
                        }
                    }
                }
            }
        }
        return InteractionResult.FAIL;

    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(pPlayer.isCrouching()){
            pPlayer.getCooldowns().addCooldown(this, 100);

            for(int i = -50; i < 51; i++){
                for(int j = -50; j < 51; j++){
                    for(int k = -50; k < 51; k++) {
                        if(pLevel.getBlockState(pPlayer.blockPosition().offset(i, j, k)).getBlock() == ModBlocks.LAPIS_RUNE.get()){
                            BlockPos pPos = pPlayer.blockPosition().offset(i, j, k);
                            BlockState pState = pLevel.getBlockState(pPos);
                            if(pState.getValue(DOWN) && pLevel.getBlockState(pPos.offset(0, -1, 0)).getDestroySpeed(pLevel, pPos.offset(0, -1, 0)) < 100&& pLevel.getBlockState(pPos.offset(0, -1, 0)).getDestroySpeed(pLevel, pPos.offset(0, -1, 0)) > -1){
                                pLevel.destroyBlock(pPos.offset(0, -1, 0), true);
                            }
                            if(pState.getValue(UP) && pLevel.getBlockState(pPos.offset(0, 1, 0)).getDestroySpeed(pLevel, pPos.offset(0, 1, 0)) < 100&& pLevel.getBlockState(pPos.offset(0, 1, 0)).getDestroySpeed(pLevel, pPos.offset(0, 1, 0)) > -1){
                                pLevel.destroyBlock(pPos.offset(0, 1, 0), true);
                            }
                            if(pState.getValue(EAST) && pLevel.getBlockState(pPos.offset(1, 0, 0)).getDestroySpeed(pLevel, pPos.offset(1, 0, 0)) < 100&& pLevel.getBlockState(pPos.offset(1, 0, 0)).getDestroySpeed(pLevel, pPos.offset(1, 0, 0)) > -1){
                                pLevel.destroyBlock(pPos.offset(1, 0, 0), true);
                            }
                            if(pState.getValue(SOUTH) && pLevel.getBlockState(pPos.offset(0, 0, 1)).getDestroySpeed(pLevel, pPos.offset(0, 0, 1)) < 100&& pLevel.getBlockState(pPos.offset(0, 0, 1)).getDestroySpeed(pLevel, pPos.offset(0, 0, 1)) > -1){
                                pLevel.destroyBlock(pPos.offset(0, 0, 1), true);
                            }
                            if(pState.getValue(WEST) && pLevel.getBlockState(pPos.offset(-1, 0, 0)).getDestroySpeed(pLevel, pPos.offset(-1, 0, 0)) < 100&& pLevel.getBlockState(pPos.offset(-1, 0, 0)).getDestroySpeed(pLevel, pPos.offset(-1, 0, 0)) > -1){
                                pLevel.destroyBlock(pPos.offset(-1, 0, 0), true);
                            }
                            if(pState.getValue(NORTH) && pLevel.getBlockState(pPos.offset(0, 0, -1)).getDestroySpeed(pLevel, pPos.offset(0, 0, -1)) < 100&& pLevel.getBlockState(pPos.offset(0, 0, -1)).getDestroySpeed(pLevel, pPos.offset(0, 0, -1)) > -1){
                                pLevel.destroyBlock(pPos.offset(0, 0, -1), true);
                            }

                        }


                        }
                    }
                }

        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
}
