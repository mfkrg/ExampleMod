package net.mfkrg.examplemod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.mfkrg.examplemod.ExampleMod;
import net.mfkrg.examplemod.entity.custom.WeakDemonEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<WeakDemonEntity> WEAK_DEMON = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ExampleMod.MOD_ID, "weak_demon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WeakDemonEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f))
                    .build());
}
