package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.HangingRootsBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RawIronRoseBlock extends HangingRootsBlock {
    public RawIronRoseBlock(Properties p_153337_) {
        super(p_153337_);
    }
    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
        super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience);
        this.CreateOre(pState, pLevel, pPos, pStack);


    }
    public void CreateOre(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack){
        RandomSource pRand = RandomSource.create();
        for(int i = -4; i<5; i++) {
            for (int j = -4; j < 5; j++) {
                for (int k = -4; k < 5; k++) {
                    if (pRand.nextInt(10) == 0 && pLevel.getBlockState((pPos.offset(i, j, k))).is(ModBlocks.PETRIFIED_ROOT.get())) {
                        pLevel.setBlockAndUpdate(pPos.offset(i, j, k), ModBlocks.ROOT_IRON_ORE.get().defaultBlockState());
                        pLevel.sendParticles(ParticleTypes.FLASH, (double)pPos.getX(), (double)pPos.getY(), (double)pPos.getZ(),1, 0.0, 0.0, 0.0, 0);
                    }
                }
            }
        }

    }

}
