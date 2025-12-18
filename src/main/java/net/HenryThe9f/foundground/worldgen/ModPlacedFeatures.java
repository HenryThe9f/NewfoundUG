package net.HenryThe9f.foundground.worldgen;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

import static net.HenryThe9f.foundground.worldgen.ModConfiguredFeatures.registerKey;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> HUGE_CAVE_MUSHROOM_PLACED_KEY = registerKey("huge_cave_mushroom_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, HUGE_CAVE_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HUGE_CAVE_MUSHROOM),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2)));
    }
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Newfound_Underground.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

