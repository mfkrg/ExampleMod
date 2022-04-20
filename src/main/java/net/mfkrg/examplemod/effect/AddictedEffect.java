package net.mfkrg.examplemod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

public class AddictedEffect extends StatusEffect {
    public AddictedEffect(StatusEffectCategory statusEffectCategory, int color){
        super(statusEffectCategory,color);
    }




    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}
