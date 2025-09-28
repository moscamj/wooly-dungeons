package com.example.woolydungeons.item;

import com.example.woolydungeons.world.WoolyDimensions;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;

/**
 * The Lime Keystone is a simple teleport item.  When used in the
 * Overworld it teleports the player to the Lime realm.  When used
 * inside the Lime realm it returns the player to the Overworld spawn
 * point.  This behaviour demonstrates how to obtain the server
 * instance, lookup a custom dimension by {@link ResourceKey} and
 * teleport a {@link ServerPlayer} to another dimension.
 */
public class LimeKeystoneItem extends Item {
    public LimeKeystoneItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            // Determine the destination dimension: toggle between the Lime
            // realm and the overworld.
            ResourceKey<Level> target = level.dimension() == WoolyDimensions.LIME_REALM_KEY
                    ? Level.OVERWORLD
                    : WoolyDimensions.LIME_REALM_KEY;

            // Obtain the destination level from the server.  Null means
            // the dimension is not loaded or not defined.
            ServerLevel destLevel = serverPlayer.server.getLevel(target);
            if (destLevel != null) {
                // Compute a safe teleport location.  For demonstration
                // purposes we teleport to X=0, Z=0 at the top of the
                // world plus a small offset.  A more robust mod would
                // check for safe ground around the player’s current
                // position or use a configured spawn point.
                int x = 0;
                int z = 0;
                // Determine the highest non‑air block at the target
                // coordinates.  Use MOTION_BLOCKING heightmap to avoid
                // leaves and tall grass.
                BlockPos heightPos = destLevel.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, new BlockPos(x, 0, z));
                double y = heightPos.getY() + 1;
                serverPlayer.teleportTo(destLevel, x + 0.5d, y, z + 0.5d, serverPlayer.getYRot(), serverPlayer.getXRot());
            }
            return InteractionResultHolder.success(player.getItemInHand(hand));
        }
        return super.use(level, player, hand);
    }
}