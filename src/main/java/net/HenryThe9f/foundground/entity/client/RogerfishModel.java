package net.HenryThe9f.foundground.entity.client;// Made with Blockbench 5.0.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.HenryThe9f.foundground.entity.animations.ModAnimationsDefinitions;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;

public class RogerfishModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart rogerfish;
	private final ModelPart body;
	private final ModelPart ribs;
	private final ModelPart spine;
	private final ModelPart tail;
	private final ModelPart head;

	public RogerfishModel(ModelPart root) {
		this.rogerfish = root.getChild("rogerfish");
		this.body = this.rogerfish.getChild("body");
		this.ribs = this.body.getChild("ribs");
		this.spine = this.body.getChild("spine");
		this.tail = this.body.getChild("tail");
		this.head = this.rogerfish.getChild("head");
	}



	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition rogerfish = partdefinition.addOrReplaceChild("rogerfish", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, -2.25F));

		PartDefinition body = rogerfish.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ribs = body.addOrReplaceChild("ribs", CubeListBuilder.create().texOffs(0, 18).addBox(1.0F, -6.0F, -3.0F, 0.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 1.0F, 1.25F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(0, 0).addBox(0.5F, -2.0F, -12.0F, 1.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 1.0F, 8.25F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(34, 0).addBox(0.0F, -4.0F, -2.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.25F));

		PartDefinition head = rogerfish.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -1.75F));

		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(22, 18).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		rogerfish.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		float $$6 = 1.0F;
		float $$7 = 1.0F;
		if (!pEntity.isInWater()) {
			$$6 = 1.3F;
			$$7 = 1.7F;
		}

		this.body.yRot = -$$6 * 0.25F * Mth.sin($$7 * 0.6F * pAgeInTicks);
		this.tail.yRot = (-$$6 * 0.25F * Mth.sin($$7 * 0.6F * pAgeInTicks))*2;

	}
	@Override
	public ModelPart root() {
		return rogerfish;
	}
}