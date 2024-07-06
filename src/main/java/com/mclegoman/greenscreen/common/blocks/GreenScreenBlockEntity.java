package com.mclegoman.greenscreen.common.blocks;

import com.mclegoman.greenscreen.common.GreenScreen;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class GreenScreenBlockEntity extends AbstractScreenBlockEntity {
	public GreenScreenBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(GreenScreen.greenScreenBlockEntityType, blockPos, blockState);
	}
}
