package me.timbeck.mc.noobui;

import lombok.Getter;
import lombok.Setter;

public class KeybindStateRepository {
    private static KeybindStateRepository singleton;

    @Getter @Setter boolean nameTagKeyPressed;

    private KeybindStateRepository() {}

    public static KeybindStateRepository getInstance() {
        if (singleton == null) {
            singleton = new KeybindStateRepository();
        }
        return singleton;
    }
}
