package com.alistair.grand_archive.item;

import com.alistair.grand_archive.Grand_archive;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

public class ModItems {
    // key/ledger used to teleport to the museum
    public static final Item MUSEUM_KEY = registerItem("museum_key", new MuseumKeyItem(new Item.Properties()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Grand_archive.MOD_ID, name), item);
    }

    public static void registerModItems() {

    }
}
