package net.mfkrg.examplemod.item.custom;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class ModBloodSwordItem extends SwordItem {
    public ModBloodSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}
