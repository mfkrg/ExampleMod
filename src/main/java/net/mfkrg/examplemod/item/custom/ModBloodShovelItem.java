package net.mfkrg.examplemod.item.custom;

import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class ModBloodShovelItem extends ShovelItem {
    public ModBloodShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
