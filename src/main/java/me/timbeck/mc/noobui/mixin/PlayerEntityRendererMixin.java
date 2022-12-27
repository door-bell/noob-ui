package me.timbeck.mc.noobui.mixin;

import me.timbeck.mc.noobui.KeybindStateRepository;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class PlayerEntityRendererMixin<T extends Entity> {

    @Inject(method = "renderLabelIfPresent", at = @At(value = "TAIL"))
    protected void renderLabelIfPresent(
            T entity,
            Text text,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            CallbackInfo ci) {
        boolean nameListKeyIsPressed = KeybindStateRepository.getInstance().isNameTagKeyPressed();
        if (entity instanceof HorseEntity && nameListKeyIsPressed) {
            // Highlight nametag
        }
    }
}
