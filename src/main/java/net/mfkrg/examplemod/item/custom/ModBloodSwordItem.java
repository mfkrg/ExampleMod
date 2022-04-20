package net.mfkrg.examplemod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.TranslatableText;

public class ModBloodSwordItem extends SwordItem {
    public ModBloodSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    int hitCounter = 0;



    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        hitCounter = hitCounter + 1;
        float hp = attacker.getHealth();
        attacker.setHealth(hp + 2);
        if (hitCounter > 20) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 1));
            hitCounter = 0;
        }
        return super.postHit(stack, target, attacker);
    }
}
