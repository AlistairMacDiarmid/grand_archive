package com.alistair.grand_archive;

import com.alistair.grand_archive.block.ModBlocks;
import com.alistair.grand_archive.block.entity.ModBlockEntities;
import com.alistair.grand_archive.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Grand_archive implements ModInitializer {
	public static final String MOD_ID = "grand_archive";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Grand Archive...");

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerModBlockEntities();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
