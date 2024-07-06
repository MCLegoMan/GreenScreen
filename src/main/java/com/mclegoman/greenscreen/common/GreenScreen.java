package com.mclegoman.greenscreen.common;

import com.mclegoman.greenscreen.common.blocks.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class GreenScreen implements ModInitializer {
	public static Block greenScreenBlock = new GreenScreenBlock(Block.Settings.create());
	public static Block glowGreenScreenBlock = new GreenScreenBlock(Block.Settings.create(), true);
	public static Item greenScreenBlockItem = new BlockItem(greenScreenBlock, new Item.Settings());
	public static Item glowGreenScreenBlockItem = new BlockItem(glowGreenScreenBlock, new Item.Settings());

	public static Block cyanScreenBlock = new CyanScreenBlock(Block.Settings.create());
	public static Block glowCyanScreenBlock = new CyanScreenBlock(Block.Settings.create(), true);
	public static Item cyanScreenBlockItem = new BlockItem(cyanScreenBlock, new Item.Settings());
	public static Item glowCyanScreenBlockItem = new BlockItem(glowCyanScreenBlock, new Item.Settings());

	public static final BlockEntityType greenScreenBlockEntityType = Registry.register(
			Registries.BLOCK_ENTITY_TYPE,
			Identifier.of("greenscreen", "greenscreen"),
			FabricBlockEntityTypeBuilder.create(GreenScreenBlockEntity::new, GreenScreen.greenScreenBlock, GreenScreen.glowGreenScreenBlock).build());

	public static final BlockEntityType cyanScreenBlockEntityType = Registry.register(
			Registries.BLOCK_ENTITY_TYPE,
			Identifier.of("greenscreen", "cyanscreen"),
			FabricBlockEntityTypeBuilder.create(CyanScreenBlockEntity::new, GreenScreen.cyanScreenBlock, GreenScreen.glowCyanScreenBlock).build());

	@Override
	public void onInitialize(ModContainer modContainer) {
		Registry.register(Registries.BLOCK, Identifier.of("greenscreen", "greenscreen"), greenScreenBlock);
		Registry.register(Registries.BLOCK, Identifier.of("greenscreen", "glow_greenscreen"), glowGreenScreenBlock);
		Registry.register(Registries.ITEM, Identifier.of("greenscreen", "greenscreen"), greenScreenBlockItem);
		Registry.register(Registries.ITEM, Identifier.of("greenscreen", "glow_greenscreen"), glowGreenScreenBlockItem);

		Registry.register(Registries.BLOCK, Identifier.of("greenscreen", "cyanscreen"), cyanScreenBlock);
		Registry.register(Registries.BLOCK, Identifier.of("greenscreen", "glow_cyanscreen"), glowCyanScreenBlock);
		Registry.register(Registries.ITEM, Identifier.of("greenscreen", "cyanscreen"), cyanScreenBlockItem);
		Registry.register(Registries.ITEM, Identifier.of("greenscreen", "glow_cyanscreen"), glowCyanScreenBlockItem);
	}
}
