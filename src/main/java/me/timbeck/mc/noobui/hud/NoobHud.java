package me.timbeck.mc.noobui.hud;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.util.math.MatrixStack;

public class NoobHud {
    private final MinecraftClient minecraftClient;
    private final IHudRenderer hudRenderer;
    private final IGameDataHelper dataHelper;

    public NoobHud(MinecraftClient minecraftClient) {
        this.minecraftClient = minecraftClient;
        this.hudRenderer = new HudRenderer(minecraftClient);
        this.dataHelper = new HudDataHelper(minecraftClient);
    }

    public void draw(MatrixStack matrixStack) {
        hudRenderer.setMatrixStack(matrixStack);
        hudRenderer.drawCoordinates(dataHelper.getPosition());
        hudRenderer.drawCompass(dataHelper.getCompass());
        ServerInfo serverInfo = minecraftClient.getNetworkHandler().getServerInfo();
        if (serverInfo != null && !serverInfo.isLocal()) {
            hudRenderer.drawLatency(dataHelper.getLatency());
        }
    }
}
