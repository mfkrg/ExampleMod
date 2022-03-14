package net.mfkrg.examplemod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.mfkrg.examplemod.ExampleMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup EXAMPLE = FabricItemGroupBuilder.build(new Identifier(ExampleMod.MOD_ID, "example"),
            () -> new ItemStack(ModItems.BLOOD_INGOT));
}
