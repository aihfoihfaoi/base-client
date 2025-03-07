package fuck.the.crack.simpleEvent;

import fuck.the.crack.Crack;
import fuck.the.crack.module.Module;

public class OnTickEvent {

    public static OnTickEvent INSTANCE = new OnTickEvent();

    public void onTick(){
        for (Module module : Crack.moduleManager.getEnabledModules())
            if (module.nullCheck()==false)module.onTick();
    }
}
