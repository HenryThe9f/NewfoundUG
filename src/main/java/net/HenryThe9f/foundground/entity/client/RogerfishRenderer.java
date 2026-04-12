package net.HenryThe9f.foundground.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.entity.custom.RogerfishEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RogerfishRenderer extends MobRenderer<RogerfishEntity, RogerfishModel<RogerfishEntity>> {
    public RogerfishRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RogerfishModel<>(pContext.bakeLayer(MobModelLayers.ROGERFISH_LAYER)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(RogerfishEntity rogerfishEntity) {
        return new ResourceLocation(Newfound_Underground.MODID, "textures/entity/rogerfish.png");
    }

    @Override
    public void render(RogerfishEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()){
            pPoseStack.scale(0.5f, 0.5f, 0.5f);

        }


        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
