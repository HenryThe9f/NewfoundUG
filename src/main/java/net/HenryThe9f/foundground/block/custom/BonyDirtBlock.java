package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ForgeHooks;
import org.apache.logging.log4j.core.jmx.Server;

public class BonyDirtBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING;

    public static final IntegerProperty LEVEL;

    public BonyDirtBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.SOUTH)).setValue(LEVEL, 0));
    }
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return (BlockState)this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection());
    }


    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        Direction pDirection = (Direction)pState.getValue(FACING);
            if(pState.getValue(LEVEL) > 0){
                if(pLevel.getBlockState(pPos.relative(pDirection)) == ModBlocks.BONY_FARMLAND.get().defaultBlockState().setValue(FACING, pState.getValue(FACING)) && pRandom.nextInt(10) != 0) {

                pLevel.setBlockAndUpdate(pPos.relative(pDirection), pLevel.getBlockState(pPos.relative(pDirection)).setValue(LEVEL, (pState.getValue(LEVEL) - 1)));
            }
                doBonemeal(pLevel, pPos, pRandom);
                pLevel.setBlockAndUpdate(pPos, pState.setValue(LEVEL, 0));


        }
        pState.setValue(LEVEL, 0);
        pLevel.scheduleTick(pPos.relative(pDirection), pLevel.getBlockState(pPos.relative(pDirection)).getBlock(), 2);

        super.tick(pState, pLevel, pPos, pRandom);
    }

    public boolean canSustainPlant(BlockState pState, BlockGetter pGetter, BlockPos pPos, Direction pFacing, net.minecraftforge.common.IPlantable pPlantable) {
        return true;
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{LEVEL, FACING});
    }
    static {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        LEVEL = BlockStateProperties.LEVEL;
    }

    public void doBonemeal(ServerLevel pLevel, BlockPos pPos, RandomSource pRand) {
        if(pLevel.getBlockState(pPos.above()).getBlock() instanceof BonemealableBlock pPlant && ForgeHooks.onCropsGrowPre(pLevel, pPos.above(), pLevel.getBlockState(pPos.above()), true)){
            if(!(pLevel.getBlockState(pPos.above()).getBlock() instanceof SaplingBlock) &&  !(pLevel.getBlockState(pPos.above()).getBlock() instanceof AzaleaBlock)){
                pPlant.performBonemeal(pLevel, pRand, pPos.above(), pLevel.getBlockState(pPos.above()));
                pLevel.levelEvent(1505, pPos.above(), 0);
                ForgeHooks.onCropsGrowPost(pLevel, pPos.above(), pLevel.getBlockState(pPos.above()));

            }
        }

    }

}
