package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FistBlock extends WorkingDirectionalBlock{
    public static final DirectionProperty FACING;

    public static final BooleanProperty POWERED;
    protected FistBlock(Properties p_52591_) {
        super(p_52591_);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.SOUTH).setValue(POWERED, true)));

    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        pLevel.scheduleTick(pPos, this, 2);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if(pState.getValue(POWERED)){
            pLevel.setBlock(pPos, pState.setValue(POWERED, Boolean.FALSE), 2);

        }
        BlockPos vPos = switch (pState.getValue(FACING)) {
            case UP -> pPos.offset(0, -1, 0);
            case DOWN -> pPos.offset(0, 1, 0);
            case NORTH -> pPos.offset(0, 0, 1);
            case SOUTH -> pPos.offset(0, 0, -1);
            case EAST -> pPos.offset(-1, 0, 0);
            case WEST -> pPos.offset(1, 0, 0);
        };
        if(pLevel.getBlockState(vPos)!=(ModBlocks.PUNCHER.get().defaultBlockState().setValue(FACING, pState.getValue(FACING)).setValue(POWERED, Boolean.TRUE)) && pState.getValue(POWERED) == Boolean.FALSE){
            pLevel.destroyBlock(pPos, Boolean.FALSE);
        }
        super.tick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        super.entityInside(pState, pLevel, pPos, pEntity);
        if(pState.getValue(POWERED)) {
            switch (pState.getValue(FACING)) {
                case UP:
                    pEntity.push(0, 1, 0);
                    break;
                case DOWN:
                    pEntity.push(0, -1, 0);
                    break;
                case NORTH:
                    pEntity.push(0, 0.25, -1);
                    break;
                case SOUTH:
                    pEntity.push(0, 0.25, 1);
                    break;
                case EAST:
                    pEntity.push(1, 0.25, 0);
                    break;
                case WEST:
                    pEntity.push(-1, 0.25, 0);
                    break;
            }
        }
}

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{FACING, POWERED});
    }
    static {
        POWERED = BlockStateProperties.POWERED;
        FACING =  BlockStateProperties.FACING;
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        BlockPos vPos = switch (pState.getValue(FACING)) {
            case UP -> pPos.offset(0, -1, 0);
            case DOWN -> pPos.offset(0, 1, 0);
            case NORTH -> pPos.offset(0, 0, 1);
            case SOUTH -> pPos.offset(0, 0, -1);
            case EAST -> pPos.offset(-1, 0, 0);
            case WEST -> pPos.offset(1, 0, 0);
        };
    if(pLevel.getBlockState(vPos)!=(ModBlocks.PUNCHER.get().defaultBlockState().setValue(FACING, pState.getValue(FACING)).setValue(POWERED, Boolean.TRUE)) && pState.getValue(POWERED) == Boolean.FALSE){
            pLevel.destroyBlock(pPos, Boolean.FALSE);
        }
        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
            return Shapes.empty();

    }


}
