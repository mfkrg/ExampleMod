package net.mfkrg.examplemod.item.custom;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class ModBloodPickaxeItem extends PickaxeItem {
    public ModBloodPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
