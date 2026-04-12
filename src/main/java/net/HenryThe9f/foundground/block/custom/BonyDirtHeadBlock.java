package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import static net.HenryThe9f.foundground.block.custom.BonyDirtBlock.LEVEL;

public class BonyDirtHeadBlock extends HorizontalDirectionalBlock {
    protected BonyDirtHeadBlock(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        RandomSource pRand = RandomSource.create();
        if (!itemstack.is(Items.BONE_MEAL)) {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        } else {
        InsertMeal(pState, pLevel, pPos);
            itemstack.shrink(1);
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof ItemEntity && ((ItemEntity) pEntity).getItem().is(Items.BONE_MEAL)){
            InsertMeal(pState, pLevel, pPos);
            ((ItemEntity) pEntity).getItem().setCount( ((ItemEntity) pEntity).getItem().getCount()-1);
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    public void InsertMeal(BlockState pState, Level pLevel, BlockPos pPos) {
        Direction pDirection = (Direction) pState.getValue(FACING);
        if (pLevel.getBlockState(pPos.relative(pDirection.getOpposite())).getBlock() == ModBlocks.BONY_FARMLAND.get()) {
            pLevel.setBlockAndUpdate(pPos.relative(pDirection.getOpposite()), pLevel.getBlockState(pPos.relative(pDirection.getOpposite())).setValue(LEVEL, 15));

            pLevel.scheduleTick(pPos.relative(pDirection.getOpposite()), pLevel.getBlockState(pPos.relative(pDirection.getOpposite())).getBlock(), 2);
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return (BlockState)this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction $$4 = (Direction)pState.getValue(FACING);
        switch ($$4) {
            case WEST:
                return  Shapes.join(Shapes.block(), Block.box(0, 8, 0, 8, 16, 16), BooleanOp.ONLY_FIRST);
            case NORTH:
                return Shapes.join(Shapes.block(), Block.box(0, 8, 0, 16, 16, 8), BooleanOp.ONLY_FIRST);
            case SOUTH:
                return Shapes.join(Shapes.block(), Block.box(0, 8, 8, 16, 16, 16), BooleanOp.ONLY_FIRST);

            case EAST:
            default:
                return Shapes.join(Shapes.block(), Block.box(8, 8, 0, 16, 16, 16), BooleanOp.ONLY_FIRST);


        }
    }
}
