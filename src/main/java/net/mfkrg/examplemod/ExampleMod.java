package net.mfkrg.examplemod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.mfkrg.examplemod.block.ModBlocks;
import net.mfkrg.examplemod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "examplemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	//COBALT

	private static ConfiguredFeature<?, ?> OVERWORLD_ORES_COBALT_CONFIGURED_FEATURE = new ConfiguredFeature
			(Feature.ORE, new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					ModBlocks.COBALT_ORE.getDefaultState(),
					5));

	private static ConfiguredFeature<?, ?> OVERWORLD_ORES_DEEPSLATE_COBALT_CONFIGURED_FEATURE = new ConfiguredFeature
			(Feature.ORE, new OreFeatureConfig(
					OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
					ModBlocks.DEEPSLATE_COBALT_ORE.getDefaultState(),
					6));


	public static PlacedFeature OVERWORLD_COBALT_DEEPSLATE_ORE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(OVERWORLD_ORES_COBALT_CONFIGURED_FEATURE),
			Arrays.asList(
					CountPlacementModifier.of(15), // number of veins per chunk
					SquarePlacementModifier.of(), // spreading horizontally
					HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(40))
			));

	public static PlacedFeature OVERWORLD_COBALT_ORE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(OVERWORLD_ORES_DEEPSLATE_COBALT_CONFIGURED_FEATURE),
			Arrays.asList(
					CountPlacementModifier.of(15), // number of veins per chunk
					SquarePlacementModifier.of(), // spreading horizontally
					HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(40))
			));

	//BLOOD


	private static ConfiguredFeature<?, ?> OVERWORLD_ORES_BLOOD_CONFIGURED_FEATURE = new ConfiguredFeature
			(Feature.ORE, new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					ModBlocks.BLOOD_ORE.getDefaultState(),
					9));

	private static ConfiguredFeature<?, ?> OVERWORLD_ORES_DEEPSLATE_BLOOD_CONFIGURED_FEATURE = new ConfiguredFeature
			(Feature.ORE, new OreFeatureConfig(
					OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
					ModBlocks.DEEPSLATE_BLOOD_ORE.getDefaultState(),
					9));


	public static PlacedFeature OVERWORLD_BLOOD_DEEPSLATE_ORE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(OVERWORLD_ORES_BLOOD_CONFIGURED_FEATURE),
			Arrays.asList(
					CountPlacementModifier.of(20), // number of veins per chunk
					SquarePlacementModifier.of(), // spreading horizontally
					HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(50))
			));

	public static PlacedFeature OVERWORLD_BLOOD_ORE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(OVERWORLD_ORES_DEEPSLATE_BLOOD_CONFIGURED_FEATURE),
			Arrays.asList(
					CountPlacementModifier.of(20), // number of veins per chunk
					SquarePlacementModifier.of(), // spreading horizontally
					HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(50))
			));




	//MYTHRIL

	private static ConfiguredFeature<?, ?> OVERWORLD_ORES_MYTHRIL_CONFIGURED_FEATURE = new ConfiguredFeature
			(Feature.ORE, new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					ModBlocks.MYTHRIL_ORE.getDefaultState(),
					3));

	private static ConfiguredFeature<?, ?> OVERWORLD_ORES_DEEPSLATE_MYTHRIL_CONFIGURED_FEATURE = new ConfiguredFeature
			(Feature.ORE, new OreFeatureConfig(
					OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
					ModBlocks.DEEPSLATE_MYTHRIL_ORE.getDefaultState(),
					5));


	public static PlacedFeature OVERWORLD_MYTHRIL_DEEPSLATE_ORE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(OVERWORLD_ORES_MYTHRIL_CONFIGURED_FEATURE),
			Arrays.asList(
					CountPlacementModifier.of(10), // number of veins per chunk
					SquarePlacementModifier.of(), // spreading horizontally
					HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(10))
			));

	public static PlacedFeature OVERWORLD_MYTHRIL_ORE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(OVERWORLD_ORES_DEEPSLATE_MYTHRIL_CONFIGURED_FEATURE),
			Arrays.asList(
					CountPlacementModifier.of(10), // number of veins per chunk
					SquarePlacementModifier.of(), // spreading horizontally
					HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(10))
			));




	@Override
	public void onInitialize() {

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("tutorial", "overworld_cobalt_ore"), OVERWORLD_ORES_COBALT_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("tutorial", "overworld_cobalt_ore"),
				OVERWORLD_COBALT_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("tutorial", "overworld_cobalt_ore")));

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("tutorial1", "overworld_blood_ore"), OVERWORLD_ORES_BLOOD_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("tutorial1", "overworld_blood_ore"),
				OVERWORLD_BLOOD_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("tutorial1", "overworld_blood_ore")));

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("tutorial2", "overworld_mythril_ore"), OVERWORLD_ORES_MYTHRIL_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("tutorial2", "overworld_mythril_ore"),
				OVERWORLD_MYTHRIL_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("tutorial2", "overworld_mythril_ore")));


		//DEEPSLATE

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("tutorial11", "overworld_deepslates_cobalt_ore"), OVERWORLD_ORES_DEEPSLATE_COBALT_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("tutorial11", "overworld_deepslates_cobalt_ore"),
				OVERWORLD_COBALT_DEEPSLATE_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("tutorial11", "overworld_deepslates_cobalt_ore")));

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("tutorial22", "overworld_deepslates_blood_ore"), OVERWORLD_ORES_DEEPSLATE_BLOOD_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("tutorial22", "overworld_deepslates_blood_ore"),
				OVERWORLD_BLOOD_DEEPSLATE_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("tutorial22", "overworld_deepslates_blood_ore")));

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("tutorial33", "overworld_deepslates_mythril_ore"), OVERWORLD_ORES_DEEPSLATE_MYTHRIL_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("tutorial33", "overworld_deepslates_mythril_ore"),
				OVERWORLD_MYTHRIL_DEEPSLATE_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("tutorial33", "overworld_deepslates_mythril_ore")));




		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}
