package net.HenryThe9f.foundground.block.custom;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.CaveFeatures;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.phys.BlockHitResult;

import static java.lang.Math.pow;

public class PetrifiedBlock extends Block implements BonemealableBlock {


    public PetrifiedBlock(Properties pProperties) {
        super(pProperties);
    }
    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return true;
    }

    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        for (int i = -3; i < 4; i++) {
            for (int j = -3; j < 4; j++) {
                for (int k = -3; k < 4; k++) {
if(pow((j*j+i*i+k*k), 0.5)<3.2){
if(pLevel.getBlockState(pPos.offset(i, j, k)) == ModBlocks.PETRIFIED_ROOT.get().defaultBlockState()){
    pLevel.setBlock(pPos.offset(i, j, k), Blocks.JUNGLE_WOOD.defaultBlockState(), 2);
}
    if(pLevel.getBlockState(pPos.offset(i, j, k)) == ModBlocks.ROOT_IRON_ORE.get().defaultBlockState()){
        pLevel.setBlock(pPos.offset(i, j, k), ModBlocks.AMBER_ORE.get().defaultBlockState(), 2);
    }


                    }
                }

            }
        }
    }


}
