package net.HenryThe9f.foundground.mixin;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RangedBowAttackGoal.class)
public class SkeletonPunchMixin {
@Shadow private Mob mob;
@Shadow private int attackIntervalMin;
@Shadow private int attackTime;
    @Inject(method = "canContinueToUse", at = @At("HEAD"), cancellable = true)
  public void canContinueToUse(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(!(this.mob.getLastHurtByMob() instanceof Player));
    }
   /* public boolean canUse() {
        return this.mob.getTarget() == null ? false : this.isHoldingBow();
    }

    protected boolean isHoldingBow() {
        return this.mob.isHolding((is) -> {
            return is.getItem() instanceof BowItem;
        });
    }
}
    @Overwrite
    public boolean canContinueToUse() {
        return this.mob.getLastHurtByMob() == null && (this.canUse() || !this.mob.getNavigation().isDone()) && this.isHoldingBow();
      }

    public boolean canUse() {
        return this.mob.getTarget() == null ? false : this.isHoldingBow();
    }

    protected boolean isHoldingBow() {
        return this.mob.isHolding((is) -> {
            return is.getItem() instanceof BowItem;
        });

*/
}




