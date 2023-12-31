package com.mclegoman.greenscreen.common;

import com.mclegoman.greenscreen.common.blocks.GreenScreenBlock;
import com.mclegoman.greenscreen.common.blocks.GreenScreenBlockEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GreenScreen implements ModInitializer {
	public static Block greenScreenBlock = new GreenScreenBlock(FabricBlockSettings.create().breakInstantly());	public static final BlockEntityType greenScreenBlockEntityType = Registry.register(
			Registries.BLOCK_ENTITY_TYPE,
			new Identifier("greenscreen", "greenscreen"),
			FabricBlockEntityTypeBuilder.create(GreenScreenBlockEntity::new, GreenScreen.greenScreenBlock).build());
	public static Item greenScreenBlockItem = new BlockItem(greenScreenBlock, new FabricItemSettings());

	@Override
	public void onInitialize() {
		Registry.register(Registries.BLOCK, new Identifier("greenscreen", "greenscreen"), greenScreenBlock);
		Registry.register(Registries.ITEM, new Identifier("greenscreen", "greenscreen"), greenScreenBlockItem);
	}


}
