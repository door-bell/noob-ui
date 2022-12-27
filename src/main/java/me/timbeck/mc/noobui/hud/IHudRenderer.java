package me.timbeck.mc.noobui.hud;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;

public interface IHudRenderer {
    void setMatrixStack(MatrixStack matrixStack);

    void drawLatency(int latency);

    void drawCoordinates(BlockPos position);
}
