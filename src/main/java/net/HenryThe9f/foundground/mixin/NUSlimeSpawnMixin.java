package net.HenryThe9f.foundground.mixin;


import net.HenryThe9f.foundground.worldgen.biome.ModBiomes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.world.entity.Mob.checkMobSpawnRules;

@Mixin(Slime.class)
public class NUSlimeSpawnMixin {


    @Inject(method = "checkSlimeSpawnRules", at = @At("HEAD"), cancellable = true)
    private static void checkSlimeSpawnRules(EntityType<Slime> pSlime, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom, CallbackInfoReturnable<Boolean> cir) {
        if (pLevel.getDifficulty() != Difficulty.PEACEFUL && pLevel.getLightLevelDependentMagicValue(pPos) == 0 && pLevel.getBiome(pPos).is(ModBiomes.SULPHUR_SLIME_CAVES)) {

            cir.setReturnValue(checkMobSpawnRules(pSlime, pLevel, pSpawnType, pPos, pRandom));

        }
    }
    }
