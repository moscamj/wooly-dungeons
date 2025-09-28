package com.example.woolydungeons.world;

import com.example.woolydungeons.WoolyDungeons;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

/**
 * Utility class holding the custom dimension keys.  Forge automatically
 * loads dimension and dimension type definitions from the datapack
 * directory (`data/<modid>/dimension/...`).  The keys defined here
 * allow server code to reference our dimension.
 */
public class WoolyDimensions {
    /** Resource key for the Lime realm (dimension). */
	public static final ResourceKey<Level> LIME_REALM_KEY =
        ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(WoolyDungeons.MODID, "lime_realm"));

    /** Resource key for the Lime realm’s dimension type. */
    public static final ResourceKey<DimensionType> LIME_TYPE =
        ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(WoolyDungeons.MODID, "lime_type"));

    // No registry code is needed here: dimension & type are data-driven via JSON.
    private WoolyDimensions() {}
}