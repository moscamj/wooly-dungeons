package com.example.woolydungeons;

import com.example.woolydungeons.item.ModItems;
import com.example.woolydungeons.world.WoolyDimensions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * The main mod class.  Forge will automatically discover this class
 * via the {@code @Mod} annotation whose value must match the
 * modId declared in mods.toml【15952368173086†L120-L122】.  All your
 * registrations should occur in the constructor using the mod event
 * bus.
 */
@Mod(WoolyDungeons.MODID)
public class WoolyDungeons {
    /** The mod id as declared in mods.toml. */
    public static final String MODID = "woolydungeons";

    public WoolyDungeons() {
        // Retrieve the mod event bus and register our content.
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register items and dimension types.  Dimension files are
        // loaded via JSON but still require a deferred register【15952368173086†L120-L122】.
        ModItems.REGISTER.register(modEventBus);

        // Register the setup callbacks.  Use lambdas to keep method
        // references succinct.
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        // Register ourselves on the Forge event bus for general game events.
        MinecraftForge.EVENT_BUS.register(this);
    }

    /** Perform common setup tasks (runs on both client and server). */
    private void commonSetup(final FMLCommonSetupEvent event) {
        // Nothing here yet.  Future integrations (e.g. networking) go here.
    }

    /** Perform client‑only setup tasks (runs only on the client). */
    private void clientSetup(final FMLClientSetupEvent event) {
        // No client‑only setup required for this simple teleport item.
    }
}