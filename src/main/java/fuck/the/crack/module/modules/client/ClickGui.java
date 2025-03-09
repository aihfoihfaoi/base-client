package fuck.the.crack.module.modules.client;

import fuck.the.crack.Crack;
import fuck.the.crack.module.Category;
import fuck.the.crack.module.Module;
import org.lwjgl.glfw.GLFW;


public class ClickGui extends Module {
    public ClickGui(){
        super("ClickGui", Category.CLIENT);
        this.setKey(GLFW.GLFW_KEY_B);
    }

    @Override
    public void onEnable() {
        mc.setScreen(Crack.clickGuiScreen);
    }

    @Override
    public void onDisable() {
        mc.setScreen(null);
    }
}
