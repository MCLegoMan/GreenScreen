package com.mclegoman.greenscreen.common.blocks;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractScreenBlock extends BlockWithEntity implements BlockEntityProvider {
	public AbstractScreenBlock(Settings settings) {
		super(settings.breakInstantly().luminance((blockState) -> 0));
	}
	public AbstractScreenBlock(Settings settings, boolean glow) {
		super(settings.breakInstantly().luminance((blockState) -> glow ? 15 : 0));
	}
	@Nullable @Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new GreenScreenBlockEntity(pos, state);
	}
}
