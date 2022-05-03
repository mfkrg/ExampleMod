package net.mfkrg.examplemod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.mfkrg.examplemod.particle.ModParticles;
import net.mfkrg.examplemod.particle.custom.FireKatanaParticle;


public class ExampleClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.FIRE_KATANA_PARTICLE, FireKatanaParticle.Factory::new);
    }
}
