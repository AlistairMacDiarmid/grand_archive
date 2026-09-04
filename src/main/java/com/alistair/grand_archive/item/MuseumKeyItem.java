package com.alistair.grand_archive.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.Set;

public class MuseumKeyItem extends Item {
    public static final ResourceKey<Level> MUSEUM_WORLD_KEY = ResourceKey.create(
            Registries.DIMENSION,
            Identifier.fromNamespaceAndPath("grand_archive", "museum_world")
    );

    public MuseumKeyItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            if (player instanceof ServerPlayer serverPlayer && level.getServer() != null) {
                ServerLevel targetWorld = level.getServer().getLevel(MUSEUM_WORLD_KEY);
                if (targetWorld != null) {
                    serverPlayer.teleportTo(
                            targetWorld,
                            0.5,
                            64.0,
                            0.5,
                            Set.of(),
                            serverPlayer.getYRot(),
                            serverPlayer.getXRot(),
                            true
                    );

                    targetWorld.playSound(
                            null,
                            0.5,
                            64.0,
                            0.5,
                            SoundEvents.ENDERMAN_TELEPORT,
                            SoundSource.PLAYERS,
                            1.0f,
                            1.0f
                    );
                }
            }
        }

        return InteractionResult.SUCCESS;
    }
}
