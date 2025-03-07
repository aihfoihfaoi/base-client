package fuck.the.crack.simpleEvent;

import fuck.the.crack.Crack;
import fuck.the.crack.module.Module;
import org.lwjgl.glfw.GLFW;

public class KeyPressEvent {
   public static KeyPressEvent INSTANCE = new KeyPressEvent();

    public void onKeyPressed(int key, int action){
        for (Module module : Crack.moduleManager.getModules()){
            if (action==GLFW.GLFW_PRESS){
                if (key==module.getKey())module.toggle();
            }
        }
    }
}
