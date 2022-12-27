package me.timbeck.mc.noobui.hud;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;

public class HudRenderer implements IHudRenderer {
    private MatrixStack matrixStack;
    private final TextRenderer textRenderer;

    HudRenderer(MinecraftClient client) {
        this.textRenderer = client.textRenderer;
    }

    @Override
    public void setMatrixStack(MatrixStack matrixStack) {
        this.matrixStack = matrixStack;
    }

    @Override
    public void drawLatency(int latency) {
        this.textRenderer.drawWithShadow(
                this.matrixStack, String.format("%dms", latency), 1, 1 + getLineHeight(), 16777215);
    }

    @Override
    public void drawCoordinates(BlockPos position) {
        this.textRenderer.drawWithShadow(
                this.matrixStack,
                String.format("(%d, %d, %d)", position.getX(), position.getY(), position.getZ()),
                1,
                1,
                16777215);
    }

    private int getLineHeight() {
        return this.textRenderer.fontHeight + 1;
    }
}
