package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.entity.custom.SulphurSlimeDropEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HangingRootsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DrippingSlimeBlock extends HangingRootsBlock {
    public DrippingSlimeBlock(Properties p_153337_) {
        super(p_153337_);
    }
    private static final BooleanProperty WATERLOGGED;


    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
        if(!pLevel.isClientSide() && pLevel.isEmptyBlock(pPos.offset(0, 1, 0))){
            SulphurSlimeDropEntity $$2 = (SulphurSlimeDropEntity) ModEntities.SULPHUR_SLIME_DROP.get().create(pLevel);
                $$2.moveTo((double) pPos.getX() + 0.5, (double) pPos.getY(), (double) pPos.getZ() + 0.5, 0.0F, 0.0F);
                pLevel.addFreshEntity($$2);

        }

        super.neighborChanged(pState, pLevel, pPos, pNeighborBlock, pNeighborPos, pMovedByPiston);
    }


    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }

}
