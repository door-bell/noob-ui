package me.timbeck.mc.noobui.hud;

import lombok.RequiredArgsConstructor;
import me.timbeck.mc.noobui.NoobUi;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

@RequiredArgsConstructor
public class HudDataHelper implements IGameDataHelper {
    private final MinecraftClient mc;

    @Override
    public int getLatency() {
        if (mc.player == null || mc.getNetworkHandler() == null) {
            NoobUi.LOG.error("Error getting latency, player or network handler is null!");
            return 0;
        }
        // Player is guaranteed to be in the player list?
        PlayerListEntry entry = mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid());
        if (entry == null) {
            NoobUi.LOG.error("Player does not exist in PlayerList");
            return 0;
        }
        return entry.getLatency();
    }

    @Override
    public BlockPos getPosition() {
        if (mc.player == null) {
            return null;
        }
        return mc.player.getBlockPos();
    }

    public String getCompass() {
        if (mc.player == null) {
            return "";
        }
        Direction direction = mc.player.getHorizontalFacing();
        String sign = direction.getDirection() == Direction.AxisDirection.POSITIVE ? "+" : "-";
        return String.format("%s%s", sign, direction.getAxis().getName().toUpperCase());
    }
}
