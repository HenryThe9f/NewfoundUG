package net.HenryThe9f.foundground.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BurningFurBlock extends FallingBlock {
    public BurningFurBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        double $$4 = (double)pPos.getX() + 0.5;
        double $$5 = (double)pPos.getY() + 0.4;
        double $$6 = (double)pPos.getZ() + 0.5;
        pLevel.addParticle(ParticleTypes.SMOKE, $$4, $$5, $$6, 0.0, 0.0, 0.0);
        pLevel.addParticle(ParticleTypes.FLAME, $$4, $$5, $$6, 0.0, 0.0, 0.0);
    }
    public static final VoxelShape SHAPE = Block.box(6, 0, 6, 10, 4, 10);
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
