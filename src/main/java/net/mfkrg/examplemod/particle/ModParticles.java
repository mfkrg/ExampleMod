package net.mfkrg.examplemod.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.mfkrg.examplemod.ExampleMod;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticles{
    public static final DefaultParticleType FIRE_KATANA_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles(){
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(ExampleMod.MOD_ID, "fire_katana_particle"),
                FIRE_KATANA_PARTICLE);
    }
}
