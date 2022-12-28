package me.timbeck.mc.noobui.hud;

import net.minecraft.util.math.BlockPos;

public interface IGameDataHelper {
    int getLatency();

    BlockPos getPosition();

    String getCompass();
}
