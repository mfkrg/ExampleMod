package net.mfkrg.examplemod.item.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class MythrilStaff extends Item {
    public Entity entity;

    public MythrilStaff (Settings settings){
        super (settings);
    }



    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        float mobHealth = entity.getHealth();
        float pHealth =user.getHealth();
        float userHealthAfterUse = pHealth + mobHealth;
        user.setHealth(userHealthAfterUse);
        entity.kill();
        stack.damage(1, user, (player) -> user.sendToolBreakStatus(user.getActiveHand()));

        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {



        return super.use(world, user, hand);
    }
}
