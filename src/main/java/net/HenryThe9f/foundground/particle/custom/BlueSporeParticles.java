package net.HenryThe9f.foundground.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.TextureSheetParticle;

public class BlueSporeParticles extends TextureSheetParticle {
    protected BlueSporeParticles(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return null;
    }
}
