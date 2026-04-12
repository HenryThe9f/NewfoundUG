package net.HenryThe9f.foundground.block.custom;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class LavaBubbleBlock extends BubbleBlock{
    public LavaBubbleBlock(Properties pProperties) {
        super(pProperties);
    }
    public FluidState getFluidState(BlockState pState) {
        super.getFluidState(pState);
        return Fluids.LAVA.getSource(false);
    }
}
