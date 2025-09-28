package com.example.woolydungeons.item;

import com.example.woolydungeons.WoolyDungeons;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Holds all item registrations for the mod.  Items are registered
 * using a {@link DeferredRegister} which defers the actual
 * registration until the proper mod lifecycle stage.
 */
public class ModItems {
    /** The deferred register for all items in this mod. */
    public static final DeferredRegister<Item> REGISTER =
            DeferredRegister.create(ForgeRegistries.ITEMS, WoolyDungeons.MODID);

    /**
     * The Lime Keystone item used to teleport between the Overworld and
     * the Lime realm.  Its use logic is implemented in
     * {@link LimeKeystoneItem}.
     */
    public static final RegistryObject<Item> LIME_KEYSTONE = REGISTER.register(
            "lime_keystone",
            () -> new LimeKeystoneItem(new Item.Properties()
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)));

    /** Register this mod’s items on the supplied event bus. */
    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}