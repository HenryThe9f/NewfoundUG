package net.HenryThe9f.foundground.entity.client;// Made with Blockbench 5.0.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.HenryThe9f.foundground.entity.animations.ModAnimationsDefinitions;
import net.HenryThe9f.foundground.entity.custom.WhelpEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class WhelpModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "whelp"), "main");
	private final ModelPart whelp;
	private final ModelPart body;
	private final ModelPart fur;
	private final ModelPart head;
	private final ModelPart tail;

	public WhelpModel(ModelPart root) {
		this.whelp = root.getChild("whelp");
		this.body = this.whelp.getChild("body");
		this.fur = this.body.getChild("fur");
		this.head = this.body.getChild("head");
		this.tail = this.whelp.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition whelp = partdefinition.addOrReplaceChild("whelp", CubeListBuilder.create(), PartPose.offset(1.0F, 24.0F, 4.0F));

		PartDefinition body = whelp.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition fur = body.addOrReplaceChild("fur", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -8.0F, 6.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(14, 14).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, -9.0F));

		PartDefinition tail = whelp.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -0.5F, 1.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	this.root().getAllParts().forEach(ModelPart::resetPose);
	this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
	this.animateWalk(ModAnimationsDefinitions.WHELP_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
	}
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		whelp.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return whelp;
	}
}