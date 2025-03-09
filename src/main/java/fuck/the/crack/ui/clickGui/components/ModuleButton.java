package fuck.the.crack.ui.clickGui.components;

import fuck.the.crack.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.lwjgl.glfw.GLFW;

import java.awt.*;

public class ModuleButton {

    CategoryButton parent;
    Module module;
    int offset;

    public ModuleButton(CategoryButton parent, Module module, int offset){
        this.parent=parent;
        this.module=module;
        this.offset=offset;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta){
        context.fill(parent.x, parent.y+offset, parent.x+parent.width, parent.y+offset+ parent.height, module.isToggled() ? new Color(59, 60,100,225).getRGB() : new Color(59, 60,100,180).getRGB());
        context.drawCenteredTextWithShadow(MinecraftClient.getInstance().textRenderer,module.getName(), parent.x+(parent.width/2), (parent.y+offset+(parent.height/2))-3, -1);
    }
    public void mouseClick(double mouseX, double mouseY, int button){
        if (isHovered(mouseX, mouseY)){
            if (button == GLFW.GLFW_MOUSE_BUTTON_1)module.toggle();
            //else if(button == GLFW.GLFW_MOUSE_BUTTON_2)showSettings();
        }

    }
    public boolean isHovered(double mouseX, double mouseY){
        return mouseX>= parent.x && mouseX<=(parent.x+parent.width) && mouseY>=parent.y+offset && mouseY<=(parent.y+parent.height+offset);
    }
}
