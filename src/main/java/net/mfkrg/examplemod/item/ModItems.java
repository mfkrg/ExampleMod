package net.mfkrg.examplemod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.mfkrg.examplemod.ExampleMod;
import net.mfkrg.examplemod.item.custom.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class ModItems {

    public static final Item BLOOD_INGOT = registerItem("blood_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.EXAMPLE)));
    public static final Item COBALT_INGOT = registerItem("cobalt_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.EXAMPLE).fireproof()));
    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.EXAMPLE).fireproof()));
    public static final Item RAW_MYTHRIL = registerItem("raw_mythril",
            new Item(new FabricItemSettings().group(ModItemGroup.EXAMPLE).fireproof()));
    public static final Item RAW_COBALT = registerItem("raw_cobalt",
            new Item(new FabricItemSettings().group(ModItemGroup.EXAMPLE).fireproof()));

    //armor
    public static final Item MYTHRIL_HELMET = registerItem("mythril_helmet",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.EXAMPLE)));
    public static final Item MYTHRIL_CHESTPLATE = registerItem("mythril_chestplate",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.EXAMPLE)));
    public static final Item MYTHRIL_LEGGINS = registerItem("mythril_leggins",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.EXAMPLE)));
    public static final Item MYTHRIL_BOOTS = registerItem("mythril_boots",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.EXAMPLE)));


    public static final Item CAVE_DETECTOR = registerItem("cave_detector",
            new CaveDetector(new FabricItemSettings().group(ModItemGroup.EXAMPLE)));
    public static final Item MYTHRIL_STAFF = registerItem("mythril_staff",
            new MythrilStaff(new FabricItemSettings().group(ModItemGroup.EXAMPLE).maxDamage(3)));
    public static final Item FIRE_KATANA = registerItem("fire_katana",
            new FireKatana(ModToolMaterials.MYTHRIL, 10,15f,new FabricItemSettings().group(ModItemGroup.EXAMPLE).maxDamage(3000)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(ExampleMod.MOD_ID, name), item);
    }


    public static void registerModItems(){
        ExampleMod.LOGGER.info("Registering Mod Items for " + ExampleMod.MOD_ID);
    }

}
