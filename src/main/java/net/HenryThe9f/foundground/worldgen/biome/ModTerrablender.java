package net.HenryThe9f.foundground.worldgen.biome;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender
{
    public static void registerBiomes(){
        Regions.register(new ModOverworldRegion(new ResourceLocation(Newfound_Underground.MODID, "overworld"), 5));
    }
}
