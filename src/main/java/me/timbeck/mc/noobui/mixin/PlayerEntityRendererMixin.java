package me.timbeck.mc.noobui.mixin;

import me.timbeck.mc.noobui.KeybindStateRepository;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class PlayerEntityRendererMixin<T extends Entity> {

    MinecraftClient mc = MinecraftClient.getInstance();

    @Inject(method = "renderLabelIfPresent", at = @At(value = "TAIL"))
    protected void renderLabelIfPresent(
            T entity,
            Text text,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            CallbackInfo ci) {
        boolean nameListKeyIsPressed = KeybindStateRepository.getInstance().isNameTagKeyPressed();
        if ((entity instanceof HorseEntity || entity instanceof PlayerEntity)
                && nameListKeyIsPressed) {
            double distanceToCamera =
                    mc.getEntityRenderDispatcher().getSquaredDistanceToCamera(entity);
            if (distanceToCamera > 4096.0D || entity.isSneaky()) {
                return;
            }
            highlightNameTagOfEntity(entity, text, matrices, vertexConsumers);
        }
    }

    private void highlightNameTagOfEntity(
            T entity, Text text, MatrixStack matrices, VertexConsumerProvider vertexConsumers) {
        float f = entity.getHeight() + 0.5F;
        float xOffset = -mc.textRenderer.getWidth(text) / 2f;
        // This is not exactly the number of blocks from the entity, but it's close
        double blocksToCamera =
                mc.getEntityRenderDispatcher().getSquaredDistanceToCamera(entity) / 4;
        matrices.push();
        matrices.translate(0.0D, f, 0.0D);
        matrices.multiply(mc.getEntityRenderDispatcher().getRotation());
        matrices.scale(-0.025F, -0.025F, 0.025F);
        Matrix4f matrix4f = matrices.peek().getPositionMatrix();
        mc.textRenderer.draw(
                text,
                xOffset,
                0,
                0x00FF00,
                false,
                matrix4f,
                vertexConsumers,
                !entity.isSneaky(),
                0x0000000,
                13);
        mc.textRenderer.draw(
                String.format("%.1fm", blocksToCamera),
                xOffset,
                10,
                0x00FF00,
                false,
                matrix4f,
                vertexConsumers,
                !entity.isSneaky(),
                0x0000000,
                13);
        matrices.pop();
    }
}
