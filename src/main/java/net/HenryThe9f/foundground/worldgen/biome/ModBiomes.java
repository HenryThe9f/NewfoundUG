package net.HenryThe9f.foundground.worldgen.biome;
import net.HenryThe9f.foundground.Newfound_Underground;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
public class ModBiomes {

    public static final ResourceKey<Biome> ROOTS_BIOME = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Newfound_Underground.MODID, "roots_biome")
            );
    public static final ResourceKey<Biome> SULPHUR_SLIME_CAVES = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Newfound_Underground.MODID, "sulphur_slime_caves")
    );
    public static final ResourceKey<Biome> BLACK_SEA = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Newfound_Underground.MODID, "black_sea")
    );
/*
    public static void bootstrap(BootstapContext<Biome> context){
        context.register(ROOTS_BIOME, rootsBiome(context));
    }

    private static Biome rootsBiome(BootstapContext<Biome> context){

    }
    */
}
