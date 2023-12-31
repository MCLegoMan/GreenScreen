package com.mclegoman.greenscreen.client.blocks;

import com.mclegoman.greenscreen.client.GreenScreenClient;
import com.mclegoman.greenscreen.common.blocks.GreenScreenBlockEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import org.joml.Matrix4f;

public class GreenScreenRenderer implements BlockEntityRenderer<GreenScreenBlockEntity> {
	public GreenScreenRenderer(BlockEntityRendererFactory.Context ctx) {
	}

	public void render(GreenScreenBlockEntity endPortalBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
		Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
		this.renderSides(endPortalBlockEntity, matrix4f, vertexConsumerProvider.getBuffer(GreenScreenClient.greenScreenRenderLayer));
	}

	private void renderSides(GreenScreenBlockEntity entity, Matrix4f matrix, VertexConsumer vertexConsumer) {
		this.renderSide(entity, matrix, vertexConsumer, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, Direction.SOUTH);
		this.renderSide(entity, matrix, vertexConsumer, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, Direction.NORTH);
		this.renderSide(entity, matrix, vertexConsumer, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, Direction.EAST);
		this.renderSide(entity, matrix, vertexConsumer, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, Direction.WEST);
		this.renderSide(entity, matrix, vertexConsumer, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, Direction.DOWN);
		this.renderSide(entity, matrix, vertexConsumer, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, Direction.UP);
	}

	private void renderSide(GreenScreenBlockEntity entity, Matrix4f model, VertexConsumer vertices, float x1, float x2, float y1, float y2, float z1, float z2, float z3, float z4, Direction side) {
		vertices.vertex(model, x1, y1, z1).next();
		vertices.vertex(model, x2, y1, z2).next();
		vertices.vertex(model, x2, y2, z3).next();
		vertices.vertex(model, x1, y2, z4).next();
	}
}
