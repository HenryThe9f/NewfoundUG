package net.HenryThe9f.foundground.entity.custom;

import net.HenryThe9f.foundground.entity.ModEntities;
import net.HenryThe9f.foundground.item.Moditems;
import net.HenryThe9f.foundground.sound.ModSounds;
import net.HenryThe9f.foundground.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RogerfishEntity extends AbstractFish {
    public static final ResourceLocation KILL_LOOT = new ResourceLocation("foundground","entities/rogerfish_bonemeal");


    public RogerfishEntity(EntityType<? extends AbstractFish> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        //  this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 12F, 0F, true);
        //   this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }


    public static boolean checkRogerfishSpawnRules(EntityType<? extends LivingEntity> pType, ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return pPos.getY() <= pLevel.getSeaLevel() - 33 && pLevel.getRawBrightness(pPos, 0) == 0 && pLevel.getBlockState(pPos).is(Blocks.WATER);
    }

    public MobType getMobType() {
        return MobType.UNDEAD;
    }





    @Override
    protected void registerGoals() {
       // this.goalSelector.addGoal(0, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.2000000476837158, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, AbstractSkeleton.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, false));

        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 1, 1));


        super.registerGoals();
    }

    @Override
    protected SoundEvent getFlopSound() {
        return ModSounds.ROGERFISH_FLOP.get();
    }

    public boolean hurt(DamageSource pSource, float pAmount) {
        Entity entity1;
            entity1 = pSource.getDirectEntity();
            if (entity1 instanceof AbstractArrow) {
                return false;
            }
        return super.hurt(pSource, pAmount);

    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.ROGERFISH_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ROGERFISH_DEATH.get();
    }

    protected void handleAirSupply(int pAirSupply) {
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 8D)
                .add(Attributes.ATTACK_DAMAGE, 5D)

                .add(Attributes.MOVEMENT_SPEED, 1.35D);

    }

    @Override
    public boolean killedEntity(ServerLevel pLevel, LivingEntity pEntity) {
       LootTable loottable = pLevel.getServer().getLootData().getLootTable(KILL_LOOT);
        LootParams lootparams = (new LootParams.Builder(pLevel)).withParameter(LootContextParams.ORIGIN, this.position()).withParameter(LootContextParams.THIS_ENTITY, this).create(LootContextParamSets.GIFT);
        List<ItemStack> list = loottable.getRandomItems(lootparams);
        for (ItemStack itemstack : list) {
            this.spawnAtLocation(itemstack, 0);
        }
        if (pEntity.getRandom().nextInt(1) == 0) {

            RogerfishEntity $$2 = (RogerfishEntity) ModEntities.ROGERFISH.get().create(pLevel);
            if ($$2 != null) {
                $$2.setPersistenceRequired();
                $$2.moveTo(this.position());
                pLevel.addFreshEntity($$2);
            }
        }
            return super.killedEntity(pLevel, pEntity);
    }

    public ItemStack getBucketItemStack() {
        return new ItemStack(Moditems.ROGERFISH_BUCKET.get());
    }

}
