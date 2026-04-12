package net.HenryThe9f.foundground.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.entity.custom.GnomeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GnomeRenderer extends MobRenderer<GnomeEntity, GnomeModel<GnomeEntity>> {
    public GnomeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GnomeModel<>(pContext.bakeLayer(MobModelLayers.GNOME_LAYER)), 0f);
    }

    @Override
    public ResourceLocation getTextureLocation(GnomeEntity gnomeEntity) {
        return new ResourceLocation(Newfound_Underground.MODID, "textures/entity/gnome.png");
    }

    @Override
    public void render(GnomeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {



        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
