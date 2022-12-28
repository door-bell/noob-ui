package me.timbeck.mc.noobui.mixin;

import me.timbeck.mc.noobui.NoobUi;
import me.timbeck.mc.noobui.hud.NoobHud;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public class HudMixin {
    private NoobHud noobHud;

    @Inject(
            method =
                    "<init>(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/render/item/ItemRenderer;)V",
            at = @At(value = "RETURN"))
    protected void onInit(MinecraftClient client, ItemRenderer render, CallbackInfo ci) {
        NoobUi.LOG.info("Initializing NoobUi HUD");
        this.noobHud = new NoobHud(client);
    }

    @Inject(method = "render", at = @At("HEAD"))
    protected void onDraw(MatrixStack matrixStack, float esp, CallbackInfo ci) {
        this.noobHud.draw(matrixStack);
    }
}
