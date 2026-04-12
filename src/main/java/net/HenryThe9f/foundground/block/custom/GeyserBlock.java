package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GeyserBlock extends Block implements SimpleWaterloggedBlock {
    private static final BooleanProperty WATERLOGGED;

    public static final BooleanProperty BOTTOM;
    public GeyserBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(BOTTOM, false).setValue(WATERLOGGED, false)));

    }

    public BlockState updateShape(BlockState pState1, Direction pDirection, BlockState pState2, LevelAccessor pLevel, BlockPos pPos1, BlockPos pPos2) {
            if ((Boolean)pState1.getValue(WATERLOGGED)) {
                pLevel.scheduleTick(pPos1, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
            }
            pState2 = pLevel.getBlockState(pPos1.above());
            if (pState2.is(ModBlocks.CALCITE_GEYSER.get())) {
                pLevel.setBlock(pPos1, pState1.setValue(BOTTOM, true), 2);
            } else {
                pLevel.setBlock(pPos1, pState1.setValue(BOTTOM, false), 2);
            }

            return super.updateShape(pState1, pDirection, pState2, pLevel, pPos1, pPos2);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{BOTTOM, WATERLOGGED});
    }
    static {
        BOTTOM = BlockStateProperties.BOTTOM;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }




    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
        if (pEntity.isSuppressingBounce()) {
            super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
        } else {
            pEntity.causeFallDamage(pFallDistance, 0.1F, pLevel.damageSources().fall());

        }

    }
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        RandomSource pRand = RandomSource.create();

        if (!pEntity.isSteppingCarefully()) {
            pEntity.setDeltaMovement(pEntity.getDeltaMovement().x, 1.5, pEntity.getDeltaMovement().z);
            if(pLevel.isClientSide){
                for(int i = 0; i <5; i++){
                    pLevel.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, ModBlocks.SULPHUR_SLIME_BLOCK.get().defaultBlockState()), (double)pPos.getX() + 0.5, (double)pPos.getY() + 1.1, (double)pPos.getZ() + 0.5, (pRand.nextDouble()-0.5)*2, (pRand.nextDouble())+5, (pRand.nextDouble()-0.5)*2);
                }
                pLevel.addParticle((ParticleTypes.EXPLOSION), (double)pPos.getX() + 0.5, (double)pPos.getY() + 1.1, (double)pPos.getZ() + 0.5, 0, 0, 0);
            }
            pLevel.playSound((Player)null, pPos, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.BLOCKS, 0.5F, pLevel.random.nextFloat() * 0.25F + 0.6F);

        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
    public static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }


    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRand) {
        super.animateTick(pState, pLevel, pPos, pRand);
        if (pRand.nextInt(10) == 0 && !pState.getValue(BOTTOM)) {
            pLevel.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, ModBlocks.SULPHUR_SLIME_BLOCK.get().defaultBlockState()), (double)pPos.getX() + 0.5, (double)pPos.getY() + 1.1, (double)pPos.getZ() + 0.5, (pRand.nextDouble()-0.5)*2, (pRand.nextDouble())*2, (pRand.nextDouble()-0.5)*2);
        }
    }
    public FluidState getFluidState(BlockState p_153360_) {
        return (Boolean)p_153360_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_153360_);
    }
}
