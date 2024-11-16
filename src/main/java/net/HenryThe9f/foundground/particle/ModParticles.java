package net.HenryThe9f.foundground.particle;
import net.HenryThe9f.foundground.Newfound_Underground;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Newfound_Underground.MODID);
    public static final RegistryObject<SimpleParticleType> BLUE_SPORES = register("blue_spores", false);


    private static RegistryObject<SimpleParticleType> register(String name, boolean overrideLimiter) {


        return PARTICLE_TYPES.register(name, () -> new SimpleParticleType(overrideLimiter));
  }
}