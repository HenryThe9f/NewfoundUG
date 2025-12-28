package net.HenryThe9f.foundground.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.entity.custom.WhelpEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WhelpRenderer extends MobRenderer<WhelpEntity, WhelpModel<WhelpEntity>> {
    public WhelpRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new WhelpModel<>(pContext.bakeLayer(MobModelLayers.WHELP_LAYER)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(WhelpEntity whelpEntity) {
        return new ResourceLocation(Newfound_Underground.MODID, "textures/entity/whelp.png");
    }

    @Override
    public void render(WhelpEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()){
            pPoseStack.scale(0.5f, 0.5f, 0.5f);

        }


        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
