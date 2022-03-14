package net.mfkrg.examplemod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.mfkrg.examplemod.ExampleMod;
import net.mfkrg.examplemod.block.custom.HealingBlock;
import net.mfkrg.examplemod.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block MYTHRIL_ORE = registerBlock("mythril_ore",
            new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(10f).luminance(10)), ModItemGroup.EXAMPLE);
    public static final Block BLOOD_ORE = registerBlock("blood_ore",
            new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(7f)), ModItemGroup.EXAMPLE);
    public static final Block COBALT_ORE = registerBlock("cobalt_ore",
            new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(7f)), ModItemGroup.EXAMPLE);

    //CUSTOM BLOCKS
    public static final Block HEALING_BLOCK = registerBlock("healing_block",
            new HealingBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(7f)), ModItemGroup.EXAMPLE);



    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(ExampleMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(ExampleMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }


    public static void registerModBlocks(){
        ExampleMod.LOGGER.info("Registering mod blocks for" + ExampleMod.MOD_ID);
    }

}
