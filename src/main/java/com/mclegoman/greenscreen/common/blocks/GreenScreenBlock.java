package com.mclegoman.greenscreen.common.blocks;

import com.mojang.serialization.MapCodec;

public class GreenScreenBlock extends AbstractScreenBlock {
	public static final MapCodec<GreenScreenBlock> codec = createCodec(GreenScreenBlock::new);
	public MapCodec<GreenScreenBlock> getCodec() {
		return codec;
	}
	public GreenScreenBlock(Settings settings) {
		super(settings);
	}
	public GreenScreenBlock(Settings settings, boolean glow) {
		super(settings, glow);
	}
}
