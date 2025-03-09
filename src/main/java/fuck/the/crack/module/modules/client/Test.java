package fuck.the.crack.module.modules.client;

import fuck.the.crack.module.Category;
import fuck.the.crack.module.Module;
import org.lwjgl.glfw.GLFW;

public class Test extends Module {
    public Test(){
        super("Test", Category.CLIENT);
        this.setKey(GLFW.GLFW_KEY_Y);
    }

    @Override
    public void onEnable() {
        mc.player.setPitch(0);
        mc.player.setYaw(0);
    }

    @Override
    public void onTick() {
        mc.player.setSprinting(true);
    }
}
