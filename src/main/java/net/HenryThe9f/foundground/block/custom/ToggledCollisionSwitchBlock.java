package net.HenryThe9f.foundground.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class ToggledCollisionSwitchBlock extends Block {
    Boolean POWERED;
    public ToggledCollisionSwitchBlock(Properties pProperties) {
        super(pProperties);
    }
}
