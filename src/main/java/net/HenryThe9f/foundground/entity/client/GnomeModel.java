package net.HenryThe9f.foundground.entity.client;// Made with Blockbench 5.0.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.HenryThe9f.foundground.entity.animations.ModAnimationsDefinitions;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class GnomeModel<T extends Entity> extends HierarchicalModel<T> {



		private final ModelPart gnome;
		private final ModelPart body;
		private final ModelPart nose;
		private final ModelPart feet;
		private final ModelPart left_foot;
		private final ModelPart right_foot;

	public GnomeModel(ModelPart root) {
			this.gnome = root.getChild("gnome");
			this.body = this.gnome.getChild("body");
			this.nose = this.body.getChild("nose");
			this.feet = this.gnome.getChild("feet");
			this.left_foot = this.feet.getChild("left foot");
			this.right_foot = this.feet.getChild("right foot");
		}

		public static LayerDefinition createBodyLayer() {
			MeshDefinition meshdefinition = new MeshDefinition();
			PartDefinition partdefinition = meshdefinition.getRoot();

			PartDefinition gnome = partdefinition.addOrReplaceChild("gnome", CubeListBuilder.create(), PartPose.offset(0.5F, 17.5F, -2.75F));

			PartDefinition body = gnome.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.25F, -13.25F, -5.0F, 14.0F, 16.0F, 14.0F, new CubeDeformation(0.0F))
					.texOffs(0, 30).addBox(-5.25F, -20.25F, -3.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.0F))
					.texOffs(40, 30).addBox(-3.25F, -25.25F, -1.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, 1.75F, 0.75F));

			PartDefinition nose = body.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(18, 47).addBox(-3.0F, -3.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.75F, -3.25F, -6.0F));

			PartDefinition feet = gnome.addOrReplaceChild("feet", CubeListBuilder.create(), PartPose.offset(-5.5F, 5.5F, 3.25F));

			PartDefinition left_foot = feet.addOrReplaceChild("left foot", CubeListBuilder.create().texOffs(40, 41).addBox(9.0F, -3.0F, -3.5F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

			PartDefinition right_foot = feet.addOrReplaceChild("right foot", CubeListBuilder.create().texOffs(0, 47).addBox(-3.0F, -3.0F, -3.5F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

			return LayerDefinition.create(meshdefinition, 64, 64);
		}

		@Override
		public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			this.root().getAllParts().forEach(ModelPart::resetPose);

			this.animateWalk(ModAnimationsDefinitions.GNOME_WALK, limbSwing, limbSwingAmount, 1f, 2.5f);

		}

		@Override
		public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
			gnome.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		}

	@Override
	public ModelPart root() {
		return gnome;
	}
	}