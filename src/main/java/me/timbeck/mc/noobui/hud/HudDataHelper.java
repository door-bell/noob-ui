package me.timbeck.mc.noobui.hud;

import lombok.RequiredArgsConstructor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

@RequiredArgsConstructor
public class HudDataHelper implements IGameDataHelper {
    private final MinecraftClient minecraftClient;

    @Override
    public int getLatency() {
        if (minecraftClient.player == null || minecraftClient.getNetworkHandler() == null) {
            return 0;
        }
        // Player is guaranteed to be in the player list?
        //noinspection DataFlowIssue
        return minecraftClient
                .getNetworkHandler()
                .getPlayerListEntry(minecraftClient.player.getUuid())
                .getLatency();
    }

    @Override
    public BlockPos getPosition() {
        if (minecraftClient.player == null) {
            return null;
        }
        return minecraftClient.player.getBlockPos();
    }
}
