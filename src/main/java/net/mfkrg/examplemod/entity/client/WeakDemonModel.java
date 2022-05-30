package net.mfkrg.examplemod.entity.client;

import net.mfkrg.examplemod.ExampleMod;
import net.mfkrg.examplemod.entity.custom.WeakDemonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class WeakDemonModel extends AnimatedGeoModel<WeakDemonEntity>{
    @Override
    public Identifier getModelLocation(WeakDemonEntity object) {
        return new Identifier(ExampleMod.MOD_ID, "geo/weak_demon.geo.json");
    }

    @Override
    public Identifier getTextureLocation(WeakDemonEntity object) {
        return new Identifier(ExampleMod.MOD_ID, "textures/entity/weak_demon/weak_demon.png");
    }

    @Override
    public Identifier getAnimationFileLocation(WeakDemonEntity animatable) {
        return new Identifier(ExampleMod.MOD_ID, "animations/weak_demon.animation.json");
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void setLivingAnimations(WeakDemonEntity entity, Integer uniqueID, AnimationEvent customPredicate){
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData)  customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null){
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }

}
