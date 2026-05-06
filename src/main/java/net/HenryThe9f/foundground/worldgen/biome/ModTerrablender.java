package net.HenryThe9f.foundground.worldgen.biome;

import net.HenryThe9f.foundground.worldgen.biome.surface.ModSurfaceRuleData;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import static net.HenryThe9f.foundground.Newfound_Underground.MODID;

public class ModTerrablender
{
    public static void registerBiomes(){
        Regions.register(new ModOverworldRegion(new ResourceLocation(MODID, "overworld"), 2));

     //   2-5 is the normal weight, gonna use a massive one for testing

    }

}
