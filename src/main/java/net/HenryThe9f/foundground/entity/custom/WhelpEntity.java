package net.HenryThe9f.foundground.entity.custom;

import net.HenryThe9f.foundground.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.jetbrains.annotations.Nullable;

public class WhelpEntity extends Animal {

    public boolean light = false;
    public WhelpEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1F);
    }

    @Override public float getWalkTargetValue(BlockPos pPos, LevelReader pLevel) {
        if((pLevel.getRawBrightness(pPos, 0) >= 12)){
            light = true;
            return -10000000f;

        } else {
            light = false;
            return -pLevel.getPathfindingCostFromLightLevels(pPos);
        }

    }


    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1));
        this.goalSelector.addGoal(2, new PanicGoal(this, 2));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1, Ingredient.of(Items.INK_SAC, Items.RED_MUSHROOM, Items.BROWN_MUSHROOM), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1));
        this.goalSelector.addGoal(5, new NoLightWanderGoal(this, 1));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));


        super.registerGoals();
    }

    public static AttributeSupplier.Builder createAttributes(){
return Animal.createLivingAttributes()
        .add(Attributes.MAX_HEALTH, 6D)
        .add(Attributes.MOVEMENT_SPEED, 0.25D)
        .add(Attributes.FOLLOW_RANGE, 24D);

    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return ModEntities.WHELP.get().create(serverLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        if(pStack.is(Items.INK_SAC) || pStack.is(Items.RED_MUSHROOM) || pStack.is(Items.BROWN_MUSHROOM)){
            return true;
        } else return false;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.DOLPHIN_AMBIENT;
    }

     class NoLightWanderGoal extends WaterAvoidingRandomStrollGoal {


        public NoLightWanderGoal(PathfinderMob pMob, double pSpeedModifier) {
            super(pMob, pSpeedModifier);
        }
        public boolean canContinueToUse() {
            if(light == true){
                return false;
            }

            return true;
        }
    }


    public void aiStep() {
        if (this.isAlive()) {
            if (this.getLightLevelDependentMagicValue() > 0.5) {
                this.setSecondsOnFire(2);
            }
                super.aiStep();
        }
    }


}
