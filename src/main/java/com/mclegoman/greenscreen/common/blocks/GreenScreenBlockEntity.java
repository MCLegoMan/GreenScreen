package com.mclegoman.greenscreen.common.blocks;

import com.mclegoman.greenscreen.common.GreenScreen;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class GreenScreenBlockEntity extends BlockEntity {
	public GreenScreenBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(GreenScreen.greenScreenBlockEntityType, blockPos, blockState);
	}
}
