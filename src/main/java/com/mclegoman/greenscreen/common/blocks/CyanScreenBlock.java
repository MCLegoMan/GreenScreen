package com.mclegoman.greenscreen.common.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class CyanScreenBlock extends AbstractScreenBlock {
	public static final MapCodec<CyanScreenBlock> codec = createCodec(CyanScreenBlock::new);
	public MapCodec<CyanScreenBlock> getCodec() {
		return codec;
	}
	public CyanScreenBlock(Settings settings) {
		super(settings);
	}
	public CyanScreenBlock(Settings settings, boolean glow) {
		super(settings, glow);
	}
	@Nullable @Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new CyanScreenBlockEntity(pos, state);
	}
}
