package net.mfkrg.examplemod.item.custom;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class ModBloodAxeItem extends AxeItem {
    public ModBloodAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
