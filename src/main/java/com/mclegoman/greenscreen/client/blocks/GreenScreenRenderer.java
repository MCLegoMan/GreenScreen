package com.mclegoman.greenscreen.client.blocks;

import com.mclegoman.greenscreen.common.blocks.AbstractScreenBlockEntity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import org.joml.Matrix4f;

public class GreenScreenRenderer implements BlockEntityRenderer<AbstractScreenBlockEntity> {
	private RenderLayer renderLayer;
	public GreenScreenRenderer(BlockEntityRendererFactory.Context context, RenderLayer renderLayer) {
		this.renderLayer = renderLayer;
	}
	public void render(AbstractScreenBlockEntity screenBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
		Matrix4f matrix4f = matrixStack.peek().getModel();
		this.renderSides(matrix4f, vertexConsumerProvider.getBuffer(this.renderLayer));
	}
	private void renderSides(Matrix4f matrix, VertexConsumer vertexConsumer) {
		this.renderSide(matrix, vertexConsumer, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, Direction.SOUTH);
		this.renderSide(matrix, vertexConsumer, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, Direction.NORTH);
		this.renderSide(matrix, vertexConsumer, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, Direction.EAST);
		this.renderSide(matrix, vertexConsumer, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, Direction.WEST);
		this.renderSide(matrix, vertexConsumer, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, Direction.DOWN);
		this.renderSide(matrix, vertexConsumer, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, Direction.UP);
	}

	private void renderSide(Matrix4f model, VertexConsumer vertices, float x1, float x2, float y1, float y2, float z1, float z2, float z3, float z4, Direction side) {
		vertices.method_22918(model, x1, y1, z1);
		vertices.method_22918(model, x2, y1, z2);
		vertices.method_22918(model, x2, y2, z3);
		vertices.method_22918(model, x1, y2, z4);
	}
}
