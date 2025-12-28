package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HangingRootsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.Tags;

import javax.annotation.Nullable;

import static java.lang.Math.*;

public class IronRoseBlock extends HangingRootsBlock {
    public static final IntegerProperty LEVEL;
    private static final BooleanProperty WATERLOGGED;

    public IronRoseBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState) this.stateDefinition.any()).setValue(LEVEL, 1)).setValue(WATERLOGGED, false));

    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_153340_) {
        BlockState $$1 = super.getStateForPlacement(p_153340_);
        if ($$1 != null) {
            FluidState $$2 = p_153340_.getLevel().getFluidState(p_153340_.getClickedPos());
            return (BlockState)$$1.setValue(WATERLOGGED, $$2.getType() == Fluids.WATER);
        } else {
            return null;
        }
    }
    public FluidState getFluidState(BlockState p_153360_) {
        return (Boolean)p_153360_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_153360_);
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        RandomSource pRand = RandomSource.create();
        if (!itemstack.is(Items.IRON_NUGGET)) {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        } else {
            this.Rootmaker(pState, pLevel, pPos, pRand);
            pLevel.setBlock(pPos, pState.setValue(LEVEL, Mth.clamp(pState.getValue(LEVEL)+1, 1,10)), 2);
            Item item = itemstack.getItem();
            if (!pPlayer.isCreative()) {
                    itemstack.shrink(1);

            }

            pPlayer.awardStat(Stats.ITEM_USED.get(item));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
    }


    public void Rootmaker(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRand) {
        for(int i = -pState.getValue(LEVEL); i <= pState.getValue(LEVEL); i++){
            for(int j = -pState.getValue(LEVEL); j <= pState.getValue(LEVEL); j++) {
                for(int k = -pState.getValue(LEVEL); k <= pState.getValue(LEVEL); k++) {
                    if (!pLevel.isClientSide && pRand.nextInt(6) == 0 && pLevel.getBlockState((pPos.offset(i, j, k))).is(Tags.Blocks.STONE) && sqrt(pow(i, 2)+pow(j, 2)+pow(k, 2)) <= pState.getValue(LEVEL)+1) {
                        pLevel.setBlockAndUpdate(pPos.offset(i, j, k), ModBlocks.PETRIFIED_ROOT.get().defaultBlockState());
                    }
                }
            }
        }

    }
    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }
   @Override public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(10) == 0) {
            this.Rootmaker(pState, pLevel, pPos, pRandom);

        }
        super.randomTick(pState, pLevel, pPos, pRandom);
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{WATERLOGGED, LEVEL});
    }
    static {
        LEVEL = BlockStateProperties.LEVEL;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;

    }
}
