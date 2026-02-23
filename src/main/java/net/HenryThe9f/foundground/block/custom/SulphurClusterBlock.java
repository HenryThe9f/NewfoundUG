package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SulphurClusterBlock extends WorkingDirectionalBlock implements SimpleWaterloggedBlock {
    public SulphurClusterBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState) this.stateDefinition.any()).setValue(FACING, Direction.DOWN)).setValue(WATERLOGGED, false));


    }
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction $$4 = (Direction)pState.getValue(FACING);
        switch ($$4) {
            case NORTH:
                return Block.box(2, 2, 11, 14, 14, 16);
            case SOUTH:
                return Block.box(2, 2, 0, 14, 14, 5);
            case EAST:
                return Block.box(0, 2, 2, 5, 14, 14);
            case WEST:
                return Block.box(11, 2, 2, 16, 14, 14);
            case DOWN:
                return Block.box(2, 11, 2, 14, 16, 14);
            case UP:
            default:
                return Block.box(2, 0, 2, 14, 5, 14);
        }
    }
    private static final BooleanProperty WATERLOGGED;

    public static final DirectionProperty FACING;
    @Override
    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
        super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience);
        if (pLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, pStack) == 0) {
            RandomSource pRand = RandomSource.create();
            if(pRand.nextInt(3) == 1){
                pLevel.setBlockAndUpdate(pPos, ModBlocks.SULPHUR_DUST.get().defaultBlockState());
            }
        }
    }
    public FluidState getFluidState(BlockState p_153360_) {
        return (Boolean)p_153360_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_153360_);
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{WATERLOGGED, FACING});
    }
    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;

        FACING = BlockStateProperties.FACING;

    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Direction $$3 = (Direction)pState.getValue(FACING);
        BlockPos $$4 = pPos.relative($$3.getOpposite());
        return pLevel.getBlockState($$4).isFaceSturdy(pLevel, $$4, $$3);
    }

    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if ((Boolean)pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }


        return pDirection == ((Direction)pState.getValue(FACING)).getOpposite() && !pState.canSurvive(pLevel, pPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
        if(!pState.canSurvive(pLevel, pPos)){
            RandomSource pRand = RandomSource.create();
            if(pRand.nextInt(3) == 1){
                pLevel.setBlockAndUpdate(pPos, ModBlocks.SULPHUR_DUST.get().defaultBlockState());
            }
        }
        super.neighborChanged(pState, pLevel, pPos, pNeighborBlock, pNeighborPos, pMovedByPiston);
    }
}
