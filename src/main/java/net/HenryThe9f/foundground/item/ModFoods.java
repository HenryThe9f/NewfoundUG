package net.HenryThe9f.foundground.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BLINDING_STEW = new FoodProperties.Builder().nutrition(6)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 1728000), 1f).build();
    public static final FoodProperties RAW_WHELP = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.6f).fast().build();
    public static final FoodProperties COOKED_WHELP = new FoodProperties.Builder().nutrition(4)
            .saturationMod(2f).fast().build();
}
