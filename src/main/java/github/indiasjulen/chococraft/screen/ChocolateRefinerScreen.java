package github.indiasjulen.chococraft.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import github.indiasjulen.chococraft.Chococraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class ChocolateRefinerScreen extends AbstractContainerScreen<ChocolateRefinerMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Chococraft.MOD_ID, "textures/gui/chocolate_refiner_gui.png");
    public ChocolateRefinerScreen(ChocolateRefinerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderWheel(pGuiGraphics, x, y);
        renderTimer(pGuiGraphics, x, y);
    }

    // CREDIT GOES TO: hadrus and their Alcocraft mod | https://github.com/hadrus/Alcocraft where this method has been taken from
    // and the renderTimer has takes inspiration from.
    public static int rawColorFromRGB(int red, int green, int blue) {
        int rgb = Math.max(Math.min(0xFF, red), 0);
        rgb = (rgb << 8) + Math.max(Math.min(0xFF, green), 0);
        rgb = (rgb << 8) + Math.max(Math.min(0xFF, blue), 0);
        return rgb;
    }

    private void renderTimer(GuiGraphics pGuiGraphics, int x, int y) {
        if (!menu.isCrafting()) {
            pGuiGraphics.drawString(this.font, "00:00", x + 94, y + 62, rawColorFromRGB(87, 87, 87), false);
        } else {
            int time = this.menu.getProgress()/20;
            int minutes = (int) (time / 60);
            int seconds = (int) (time % 60);

            String min = String.valueOf(minutes);
            if (minutes < 10) {
                min = "0" + min;
            }

            String sec =  String.valueOf(seconds);
            if (seconds < 10) {
                sec = "0" + sec;
            }

            pGuiGraphics.drawString(this.font, min + ":" + sec, x + 94, y + 62, rawColorFromRGB(87, 87, 87), false);
        }
    }

    private void renderWheel(GuiGraphics pGuiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            pGuiGraphics.pose().pushPose();
//            pGuiGraphics.pose().mulPose(new Quaternionf(0.0F, 0.71F, 0.0F, 0.0F));
//            pGuiGraphics.pose().scale(1.1F, 1.1F, 1.1F);

            pGuiGraphics.blit(TEXTURE, x + 100, y + 37, 176, 0, 13, 13);
            pGuiGraphics.pose().popPose();

        }
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}
