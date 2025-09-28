package com.example.woolydungeons;

import com.example.woolydungeons.WoolyDungeons;
import com.example.woolydungeons.item.ModItems;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.item.CreativeModeTabs;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = WoolyDungeons.MODID)
public class ModTabs {
    @SubscribeEvent
    public static void onBuildTabs(BuildCreativeModeTabContentsEvent e) {
        if (e.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            e.accept(ModItems.LIME_KEYSTONE.get());
        }
    }
}