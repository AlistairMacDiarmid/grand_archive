package com.alistair.grand_archive.block.entity;

import com.alistair.grand_archive.Grand_archive;
import com.alistair.grand_archive.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {
    public static final BlockEntityType<MuseumPedestalBlockEntity> MUSEUM_PEDESTAL_BLOCK_ENTITY = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Grand_archive.MOD_ID, "pedestal"),
            FabricBlockEntityTypeBuilder.create(MuseumPedestalBlockEntity::new, ModBlocks.PEDESTAL).build()
    );

    public static void registerModBlockEntities() {
    }
}
