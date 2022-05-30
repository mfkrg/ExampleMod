package net.mfkrg.examplemod.entity.custom;

import net.mfkrg.examplemod.ExampleMod;
import net.mfkrg.examplemod.entity.client.WeakDemonModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WeakDemonRenderer extends GeoEntityRenderer<WeakDemonEntity> {
    public WeakDemonRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new WeakDemonModel());
    }

    @Override
    public Identifier getTextureLocation(WeakDemonEntity instance) {
        return new Identifier(ExampleMod.MOD_ID, "textures/entity/weak_demon/weak_demon.png");
    }
}
