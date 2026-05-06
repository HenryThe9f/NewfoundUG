package net.HenryThe9f.foundground.entity.custom;

import net.HenryThe9f.foundground.item.Moditems;
import net.HenryThe9f.foundground.sound.ModSounds;
import net.HenryThe9f.foundground.util.ModTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.network.protocol.game.ClientboundRotateHeadPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecartContainer;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.Nullable;

public class GnomeEntity extends PathfinderMob implements ContainerEntity{
    private NonNullList<ItemStack> itemStacks;

    public GnomeEntity(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.itemStacks = NonNullList.withSize(27, ItemStack.EMPTY);

    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new gnomeMarchGoal(this, 1, Ingredient.of(Moditems.TERRACOTTA_HORN.get()), false));
        super.registerGoals();
    }

    public class gnomeMarchGoal extends TemptGoal {
        private static final TargetingConditions TEMP_TARGETING = TargetingConditions.forNonCombat().range(10.0).ignoreLineOfSight();
        private final Ingredient items;
        private final TargetingConditions targetingConditions;

        public gnomeMarchGoal(PathfinderMob pMob, double pSpeedModifier, Ingredient pItems, boolean pCanScare) {
            super(pMob, pSpeedModifier, pItems, pCanScare);
            this.targetingConditions = TEMP_TARGETING.copy().selector(this::shouldFollow);
            this.items = pItems;
        }
        private boolean shouldFollow(LivingEntity p_148139_) {
            return this.items.test(p_148139_.getMainHandItem()) || this.items.test(p_148139_.getOffhandItem());
        }
        @Override
        public boolean canUse() {
                this.player = this.mob.level().getNearestPlayer(this.targetingConditions, this.mob);
                return (this.player != null && this.player.isUsingItem());
        }
    }



    @Override
    public boolean isPersistenceRequired() {
        return true;
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
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        this.addChestVehicleSaveData(pCompound);
    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.readChestVehicleSaveData(pCompound);
    }

    @Override public void addChestVehicleSaveData(CompoundTag pTag) {
            ContainerHelper.saveAllItems(pTag, this.getItemStacks());
    }


    @Override
    public void die(DamageSource pDamageSource) {
        this.chestVehicleDestroyed(pDamageSource, this.level(), this);
        super.die(pDamageSource);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.30D)
                .add(Attributes.FOLLOW_RANGE, 64D);
    }


    public void syncRotToFacing() {
        if (this.level().isClientSide) return;

        float yaw;

        yaw = this.getYRot();

        this.setYRot(yaw);
        this.setXRot(0f);
        this.yHeadRot = yaw;
        this.yHeadRotO = yaw;
        this.yBodyRot = yaw;

        ServerLevel server = (ServerLevel) this.level();
        byte yawByte = (byte)((int)(yaw * 256.0F / 360.0F));
        byte pitchByte = 0;

        server.getChunkSource().broadcast(this,
                new ClientboundRotateHeadPacket(this, yawByte));
        server.getChunkSource().broadcast(this,
                new ClientboundMoveEntityPacket.Rot(this.getId(), yawByte, pitchByte, this.onGround()));
    }

    @Override
    public void setLootTable(@Nullable ResourceLocation resourceLocation) {
        //   this.lootTable = pLootTable;
    }

    @Override
    public void setLootTableSeed(long l) {
        // this.lootTableSeed = pLootTableSeed;
    }

    @Override
    public NonNullList<ItemStack> getItemStacks() {
        return this.itemStacks;
    }

    @Override
    public void clearItemStacks() {
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    public ItemStack getItem(int pSlot) {
        return this.getChestVehicleItem(pSlot);
    }

    @Override
    public ItemStack removeItem(int pSlot, int pAmount) {
        return this.removeChestVehicleItem(pSlot, pAmount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int pSlot) {
        return this.removeChestVehicleItemNoUpdate(pSlot);
    }

    @Override
    public void setItem(int pSlot, ItemStack pStack) {
        this.setChestVehicleItem(pSlot, pStack);
    }

    @Override
    public void setChanged() {
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return this.isChestVehicleStillValid(pPlayer);
    }

    @Override
    public void clearContent() {
        this.clearChestVehicleContent();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        if (pPlayer.isSpectator()) {
            return null;
        } else {
            // this.unpackLootTable(pPlayerInventory.player);
            return ChestMenu.threeRows(pContainerId, pPlayerInventory, this);
        }
    }
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        InteractionResult $$2 = this.interactWithContainerVehicle(pPlayer);
        if ($$2.consumesAction()) {
            this.gameEvent(GameEvent.CONTAINER_OPEN, pPlayer);
            PiglinAi.angerNearbyPiglins(pPlayer, true);
        }

        return $$2;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.GNOME_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.GNOME_DEATH.get();
    }
    @Override
    public void unpackChestVehicleLootTable(@javax.annotation.Nullable Player pPlayer) {

    }
}
