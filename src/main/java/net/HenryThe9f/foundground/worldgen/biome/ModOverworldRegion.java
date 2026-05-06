package net.HenryThe9f.foundground.worldgen.biome;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region{
    public ModOverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
          // modifiedVanillaOverworldBuilder.replaceBiome(Biomes.LUSH_CAVES, ModBiomes.ROOTS_BIOME);
           // modifiedVanillaOverworldBuilder.replaceBiome(Biomes.DRIPSTONE_CAVES, ModBiomes.SULPHUR_SLIME_CAVES);
            VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
            new ParameterUtils.ParameterPointListBuilder()
                    .temperature(ParameterUtils.Temperature.FULL_RANGE)
                    .humidity(ParameterUtils.Humidity.DRY)
                    .continentalness(ParameterUtils.Continentalness.FULL_RANGE)
                    .erosion(ParameterUtils.Erosion.FULL_RANGE)
                    .depth(ParameterUtils.Depth.UNDERGROUND)
                    .weirdness(ParameterUtils.Weirdness.FULL_RANGE)
                    .build().forEach(point -> builder.add(point, ModBiomes.ROOTS_BIOME));
            new ParameterUtils.ParameterPointListBuilder()
                    .temperature(ParameterUtils.Temperature.ICY)
                    .humidity(ParameterUtils.Humidity.FULL_RANGE)
                    .continentalness(ParameterUtils.Continentalness.FULL_RANGE)
                    .erosion(ParameterUtils.Erosion.FULL_RANGE)
                    .depth(ParameterUtils.Depth.UNDERGROUND)
                    .weirdness(ParameterUtils.Weirdness.FULL_RANGE)
                    .build().forEach(point -> builder.add(point, ModBiomes.SULPHUR_SLIME_CAVES));
            new ParameterUtils.ParameterPointListBuilder()
                    .temperature(ParameterUtils.Temperature.HOT)
                    .humidity(ParameterUtils.Humidity.FULL_RANGE)
                    .continentalness(ParameterUtils.Continentalness.FULL_RANGE)
                    .erosion(ParameterUtils.Erosion.FULL_RANGE)
                    .depth(ParameterUtils.Depth.UNDERGROUND)
                    .weirdness(ParameterUtils.Weirdness.FULL_RANGE)
                    .build().forEach(point -> builder.add(point, ModBiomes.SULPHUR_SLIME_CAVES));
            /*new ParameterUtils.ParameterPointListBuilder()
                    .temperature(ParameterUtils.Temperature.FULL_RANGE)
                    .humidity(ParameterUtils.Humidity.WET)
                    .continentalness(ParameterUtils.Continentalness.FULL_RANGE)
                    .erosion(ParameterUtils.Erosion.EROSION_6)
                    .depth(Climate.Parameter.span(0.8F, 1.5F))
                    .weirdness(ParameterUtils.Weirdness.FULL_RANGE)
                    .build().forEach(point -> builder.add(point, ModBiomes.BLACK_SEA)); man i wish this biome didnt suck ass it was almost so cool*/
            // Add our points to the mapper
            builder.build().forEach(mapper::accept);


        });
    }
}
