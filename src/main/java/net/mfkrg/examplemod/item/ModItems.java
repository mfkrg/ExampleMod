package net.mfkrg.examplemod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.mfkrg.examplemod.ExampleMod;
import net.mfkrg.examplemod.item.custom.*;
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



    //tools BLOOD

    public static final Item BLOOD_AXE = registerItem("blood_axe",
            new ModBloodAxeItem(ModToolMaterials.BLOOD,8,2f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.UNCOMMON)));
    public static final Item BLOOD_PICKAXE = registerItem("blood_pickaxe",
            new ModBloodPickaxeItem(ModToolMaterials.BLOOD, 3,2f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.UNCOMMON)));
    public static final Item BLOOD_HOE = registerItem("blood_hoe",
            new ModBloodHoeItem(ModToolMaterials.BLOOD, 2,2f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.UNCOMMON)));
    public static final Item BLOOD_SWORD = registerItem("blood_sword",
            new ModBloodSwordItem(ModToolMaterials.BLOOD,6, 2f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.UNCOMMON)));
    public static final Item BLOOD_SHOVEL = registerItem("blood_shovel",
            new ModBloodSwordItem(ModToolMaterials.BLOOD,2, 1f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.UNCOMMON)));


    //tools MYTHRIL
    public static final Item MYTHRIL_AXE = registerItem("mythril_axe",
            new ModBloodAxeItem(ModToolMaterials.MYTHRIL,12,2f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.EPIC).fireproof()));
    public static final Item MYTHRIL_PICKAXE = registerItem("mythril_pickaxe",
            new ModBloodPickaxeItem(ModToolMaterials.MYTHRIL, 3,2f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.EPIC).fireproof()));
    public static final Item MYTHRIL_HOE = registerItem("mythril_hoe",
            new ModBloodHoeItem(ModToolMaterials.MYTHRIL, 2,2f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.EPIC).fireproof()));
    public static final Item MYTHRIL_SWORD = registerItem("mythril_sword",
            new ModBloodSwordItem(ModToolMaterials.MYTHRIL,10, 4f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.EPIC).fireproof()));
    public static final Item MYTHRIL_SHOVEL = registerItem("mythril_shovel",
            new ModBloodSwordItem(ModToolMaterials.MYTHRIL,2, 1f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.EPIC).fireproof()));

    //tools COBALT
    public static final Item COBALT_AXE = registerItem("cobalt_axe",
            new ModBloodAxeItem(ModToolMaterials.COBALT,9,2f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.RARE).fireproof()));
    public static final Item COBALT_PICKAXE = registerItem("cobalt_pickaxe",
            new ModBloodPickaxeItem(ModToolMaterials.COBALT, 3,2f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.RARE).fireproof()));
    public static final Item COBALT_HOE = registerItem("cobalt_hoe",
            new ModBloodHoeItem(ModToolMaterials.COBALT, 2,2f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.RARE).fireproof()));
    public static final Item COBALT_SWORD = registerItem("cobalt_sword",
            new ModBloodSwordItem(ModToolMaterials.COBALT,8, 3f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.RARE).fireproof()));
    public static final Item COBALT_SHOVEL = registerItem("cobalt_shovel",
            new ModBloodSwordItem(ModToolMaterials.COBALT,2, 1f, new FabricItemSettings().group(ModItemGroup.EXAMPLE).rarity(Rarity.RARE).fireproof()));




    public static final Item CAVE_DETECTOR = registerItem("cave_detector",
            new CaveDetector(new FabricItemSettings().group(ModItemGroup.EXAMPLE)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(ExampleMod.MOD_ID, name), item);
    }


    public static void registerModItems(){
        ExampleMod.LOGGER.info("Registering Mod Items for " + ExampleMod.MOD_ID);
    }

}
