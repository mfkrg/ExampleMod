package net.mfkrg.examplemod.item.custom;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.stat.Stat;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class FireKatana extends SwordItem {
    public FireKatana(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings){
        super (toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        double tHp = target.getHealth();
        double lifeSteal = tHp / 4;
        double aHp = attacker.getHealth();
        double aHpAfterLifeSteal = aHp + lifeSteal;
        attacker.setHealth((float) aHpAfterLifeSteal);
        return super.postHit(stack, target, attacker);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Box box =new Box(user.getX() + 32, user.getY() + 32,user.getZ() + 32, user.getX() - 32, user.getY() - 32, user.getZ() - 32);
        List<LivingEntity> list = world.getNonSpectatingEntities(LivingEntity.class, box);
        for (LivingEntity entity : list){
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 400, 2));
        }
        user.getMainHandStack().damage(50, user, (player) -> user.sendToolBreakStatus(user.getActiveHand()));
        return super.use(world, user, hand);
    }
}
