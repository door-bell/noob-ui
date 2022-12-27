package me.timbeck.mc.noobui.hud;

import net.minecraft.util.math.BlockPos;


public interface IHudRenderer {
    void drawLatency(int latency);
    void drawCoordinates(BlockPos position);
}
