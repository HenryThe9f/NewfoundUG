package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;

public class PuncherBlock extends WorkingDirectionalBlock implements Fallable {
    public static final DirectionProperty FACING;

    public static final BooleanProperty POWERED;
    protected PuncherBlock(Properties p_52591_) {
        super(p_52591_);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.SOUTH).setValue(POWERED, false)));

    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        if(pMovedByPiston){
        pLevel.setBlock(pPos, pState.setValue(POWERED, Boolean.FALSE), 2);
    }
        pLevel.scheduleTick(pPos, this, 2);
        super.onPlace(pState, pLevel, pPos, pOldState, pMovedByPiston);
    }

    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
     pLevel.scheduleTick(pPos, this, 2);



    }
    protected void falling(FallingBlockEntity pEntity) {
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{FACING, POWERED});
    }
    static {
        POWERED = BlockStateProperties.POWERED;
        FACING =  BlockStateProperties.FACING;
    }
    public void punchblock(Level pLevel, BlockPos pPos, BlockState pState){

       // if(pState.getDestroySpeed(pLevel, pPos) >= 0 && pState.getDestroySpeed(pLevel, pPos) < 50 && !pState.hasBlockEntity()) {

      return;
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return (BlockState)((BlockState)this.defaultBlockState().setValue(FACING, pContext.getNearestLookingDirection().getOpposite())).setValue(POWERED, false);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        boolean powerflag = pLevel.hasNeighborSignal(pPos);
        BlockPos vPos = switch (pState.getValue(FACING)) {
            case UP -> pPos.offset(0, 1, 0);
            case DOWN -> pPos.offset(0, -1, 0);
            case NORTH -> pPos.offset(0, 0, -1);
            case SOUTH -> pPos.offset(0, 0, 1);
            case EAST -> pPos.offset(1, 0, 0);
            case WEST -> pPos.offset(-1, 0, 0);
        };
        BlockState vState = pLevel.getBlockState(vPos);
        if(pState.getValue(POWERED) == Boolean.FALSE && powerflag) {

            if(vState.getDestroySpeed(pLevel,vPos) >= 0 && vState.getDestroySpeed(pLevel,vPos) < 50 && !vState.hasBlockEntity() && (vState.getPistonPushReaction() != PushReaction.BLOCK || vState.is(ModTags.Blocks.PUNCHER_ADDITIONAL_WHITELIST))) {
                if(vState.getPistonPushReaction() == PushReaction.DESTROY){
                    pLevel.destroyBlock(vPos, Boolean.TRUE);
                } else {
                    int MaxDmg = (int)vState.getDestroySpeed(pLevel, vPos);
                    FallingBlockEntity $$5 = FallingBlockEntity.fall(pLevel, vPos, vState);
                    this.falling($$5);
                    $$5.moveTo($$5.position().x, $$5.position().y + 0.1, $$5.position().z);
                    $$5.setHurtsEntities(2.0F, MaxDmg*8);
                    pLevel.playSound((Player)null, pPos, SoundEvents.PLAYER_ATTACK_KNOCKBACK, SoundSource.BLOCKS, 0.5F, pLevel.random.nextFloat() * 0.25F + 0.6F);
                    pLevel.setBlockAndUpdate(vPos, ModBlocks.PUNCHER_FIST.get().defaultBlockState().setValue(FACING, pState.getValue(FACING)));
                    pLevel.setBlock(pPos, pState.setValue(POWERED, Boolean.TRUE), 2);
                }
            }
        }
        if(pState.getValue(POWERED) == Boolean.TRUE && !powerflag) {
            if(pLevel.getBlockState(vPos) == ModBlocks.PUNCHER_FIST.get().defaultBlockState().setValue(FACING, pState.getValue(FACING)).setValue(POWERED, Boolean.FALSE)){
                pLevel.setBlockAndUpdate(vPos, Blocks.AIR.defaultBlockState());
                pLevel.playSound((Player)null, pPos, SoundEvents.PISTON_CONTRACT, SoundSource.BLOCKS, 0.5F, pLevel.random.nextFloat() * 0.25F + 0.6F);

            }
            pLevel.setBlock(pPos, pState.setValue(POWERED, Boolean.FALSE), 2);
        }

        super.tick(pState, pLevel, pPos, pRandom);
    }
}


