package com.mclegoman.greenscreen.client;

import com.mclegoman.greenscreen.client.blocks.GreenScreenRenderer;
import com.mclegoman.greenscreen.common.GreenScreen;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormats;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class GreenScreenClient implements ClientModInitializer {
	public static RenderLayer greenScreenRenderLayer = RenderLayer.of("greenscreen", VertexFormats.POSITION, VertexFormat.DrawMode.QUADS, 256, false, false, RenderLayer.MultiPhaseParameters.builder().shader(RenderLayer.END_PORTAL_SHADER).texture(RenderPhase.Textures.create().add(Identifier.of("greenscreen", "textures/block/greenscreen.png"), false, false).add(Identifier.of("greenscreen", "textures/block/greenscreen.png"), false, false).build()).build(false));
	public static RenderLayer cyanScreenRenderLayer = RenderLayer.of("cyanscreen", VertexFormats.POSITION, VertexFormat.DrawMode.QUADS, 256, false, false, RenderLayer.MultiPhaseParameters.builder().shader(RenderLayer.END_PORTAL_SHADER).texture(RenderPhase.Textures.create().add(Identifier.of("greenscreen", "textures/block/cyanscreen.png"), false, false).add(Identifier.of("greenscreen", "textures/block/cyanscreen.png"), false, false).build()).build(false));
	@Override
	public void onInitializeClient(ModContainer modContainer) {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
			content.addItem(GreenScreen.greenScreenBlockItem);
			content.addItem(GreenScreen.glowGreenScreenBlockItem);
		});
		BlockEntityRendererRegistry.register(GreenScreen.greenScreenBlockEntityType, (context) -> new GreenScreenRenderer(context, greenScreenRenderLayer));
		BlockEntityRendererRegistry.register(GreenScreen.cyanScreenBlockEntityType, (context) -> new GreenScreenRenderer(context, cyanScreenRenderLayer));
	}
}
