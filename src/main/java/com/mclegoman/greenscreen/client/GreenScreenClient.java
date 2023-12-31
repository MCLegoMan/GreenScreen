package com.mclegoman.greenscreen.client;

import com.mclegoman.greenscreen.client.blocks.GreenScreenRenderer;
import com.mclegoman.greenscreen.common.GreenScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;

public class GreenScreenClient implements ClientModInitializer {
	public static RenderLayer greenScreenRenderLayer = RenderLayer.of("greenscreen", VertexFormats.POSITION, VertexFormat.DrawMode.QUADS, 256, false, false, RenderLayer.MultiPhaseParameters.builder().program(RenderLayer.END_GATEWAY_PROGRAM).texture(RenderPhase.Textures.create().add(new Identifier("greenscreen", "textures/block/greenscreen.png"), false, false).add(new Identifier("greenscreen", "textures/block/greenscreen.png"), false, false).build()).build(false));

	@Override
	public void onInitializeClient() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
			content.add(GreenScreen.greenScreenBlockItem);
		});
		BlockEntityRendererRegistry.register(GreenScreen.greenScreenBlockEntityType, GreenScreenRenderer::new);
	}
}
