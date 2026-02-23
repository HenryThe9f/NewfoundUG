package net.HenryThe9f.foundground.block.custom;


import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.item.Moditems;
import net.HenryThe9f.foundground.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Arrays;
import java.util.Collections;

//the block this forum needed
public class GasBlock extends Block {
    public GasBlock(Properties pProperties) {
        super(pProperties);
    }
    Integer[] offsetx = new Integer[] {-1, 0, 1};
    Integer[] offsetz = new Integer[] {-1, 0, 1};

    public int SPEED = 10;

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        pLevel.scheduleTick(pPos, this, SPEED);
        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRand){
         if(pLevel.isEmptyBlock(pPos.above())){
            pLevel.setBlockAndUpdate(pPos.above(), this.defaultBlockState());
            pLevel.setBlockAndUpdate(pPos, Blocks.AIR.defaultBlockState());
        } else if (pLevel.getBlockState(pPos.above()).is(ModTags.Blocks.IGNITES_GAS)) {
            gasexplode(pLevel, pPos);
        } else{
            Collections.shuffle(Arrays.asList(offsetx));
            Collections.shuffle(Arrays.asList(offsetz));
            horizontalspreader(pLevel, pPos, pRand);

        }
}
public void horizontalspreader(ServerLevel pLevel, BlockPos pPos, RandomSource pRand) {


    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (pLevel.getBlockState(pPos.offset(offsetx[i], 0, offsetz[j])).is(ModTags.Blocks.IGNITES_GAS)) {
                gasexplode(pLevel, pPos);
                return;
            }
            if (pLevel.isEmptyBlock(pPos.offset(offsetx[i], 0, offsetz[j])) && pLevel.isEmptyBlock(pPos.offset(offsetx[i], 1, offsetz[j]))) {
                pLevel.setBlockAndUpdate(pPos.offset(offsetx[i], 1, offsetz[j]), this.defaultBlockState());
                pLevel.setBlockAndUpdate(pPos, Blocks.AIR.defaultBlockState());
                pLevel.scheduleTick(pPos.offset(offsetx[i], 1, offsetz[j]), this, SPEED);
                return;
            }
        }
    }
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (pLevel.isEmptyBlock(pPos.offset(offsetx[i], 0, offsetz[j]))) {
                pLevel.setBlockAndUpdate(pPos.offset(offsetx[i], 0, offsetz[j]), this.defaultBlockState());
                pLevel.setBlockAndUpdate(pPos, Blocks.AIR.defaultBlockState());
                if(pLevel.getBlockState(pPos.offset(offsetx[i], 0, offsetz[j]))==(ModBlocks.SULPHUR_DUST.get().defaultBlockState()) && pRand.nextInt(20) == 1){
                    if(pLevel.getBlockState(pPos.offset(offsetx[i], 1, offsetz[j])).is(ModTags.Blocks.SULPHUR_CRYSTALIZER)){
                        pLevel.setBlockAndUpdate(pPos.offset(offsetx[i], 0, offsetz[j]), ModBlocks.SULPHUR_CLUSTER.get().defaultBlockState());
                        return;
                    } else {
                        pLevel.setBlockAndUpdate(pPos.offset(offsetx[i], 0, offsetz[j]), Blocks.AIR.defaultBlockState());
                    }
                }
                pLevel.scheduleTick(pPos.offset(offsetx[i], 0, offsetz[j]), this, SPEED);
                return;

            }
        }
    }
    if(pLevel.getBlockState(pPos)==(ModBlocks.SULPHUR_DUST.get().defaultBlockState())){
            pLevel.setBlockAndUpdate(pPos, Blocks.AIR.defaultBlockState());

    }
}


    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if( pContext.isHoldingItem(Items.GLASS_BOTTLE)){
            return Shapes.block();

        } else {
            return Shapes.box(0, 0, 0, 0.001, 0.001, 0.001);
        }
    }

    @Override
    public void destroy(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
        super.destroy(pLevel, pPos, pState);
    }

    public void gasexplode(ServerLevel pLevel, BlockPos pPos){
        float explosionpower = 2;
        for(int i = -3; i < 4; i++){
            for(int j = -3; j < 4; j++){
                for(int k = -3; k < 4; k++) {
                    if (pLevel.getBlockState(pPos.offset(i, j, k))== this.defaultBlockState()){
                       // pLevel.setBlockAndUpdate(pPos.offset(i, j, k), Blocks.AIR.defaultBlockState());
                        explosionpower = Math.min(explosionpower+0.4F, 20);
                    }
                }
            }
        }//fix dmg source

        pLevel.explode(null, pPos.getX(), pPos.getY(), pPos.getZ(), explosionpower, true, Level.ExplosionInteraction.BLOCK);
        pLevel.setBlockAndUpdate(pPos, Blocks.AIR.defaultBlockState());

    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        Item item = itemstack.getItem();
        if(itemstack.is(Items.GLASS_BOTTLE)){

            ItemStack itemstack1 = new ItemStack(this.asItem());


            pLevel.setBlockAndUpdate(pPos, Blocks.AIR.defaultBlockState());
            if (!pPlayer.isCreative()) {
                itemstack.shrink(1);
            }


            if (itemstack.isEmpty()) {
                pPlayer.setItemInHand(pHand, itemstack1);
            } else if (!pPlayer.addItem(itemstack1)) {
                pPlayer.drop(itemstack1, false);
            }

            pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.BOTTLE_FILL_DRAGONBREATH, SoundSource.PLAYERS, 0.5F, 1F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));

            pPlayer.awardStat(Stats.ITEM_USED.get(item));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }else {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        }
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        pLevel.scheduleTick(pPos, this, SPEED);
        super.onPlace(pState, pLevel, pPos, pOldState, pMovedByPiston);
    }
}

