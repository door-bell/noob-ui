package me.timbeck.mc.noobui;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoobUi implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOG = LoggerFactory.getLogger("noobui");

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        KeyBinding nameTagBinding =
                KeyBindingHelper.registerKeyBinding(
                        new KeyBinding(
                                "key.noobui.nametaghelp",
                                InputUtil.Type.KEYSYM,
                                GLFW.GLFW_KEY_M,
                                "category.noobui.nametag"));
        ClientTickEvents.END_CLIENT_TICK.register(
                client -> {
                    KeybindStateRepository.getInstance()
                            .setNameTagKeyPressed(nameTagBinding.isPressed());
                });
    }
}
