package fuck.the.crack.manager;

import fuck.the.crack.module.Module;

import java.util.ArrayList;

public class ModuleManager {

    private ArrayList<Module> modules;

    public ModuleManager(){
        addModules();
    }

    private void addModules(){
        //modules.add(new Test);
    }

    public ArrayList<Module> getModules() {
        return modules;
    }
    public ArrayList<Module> getEnabledModules(){
        ArrayList<Module> a = new ArrayList<>();
        for (Module module : getModules()){
            if (module.isToggled())a.add(module);
        }
        return a;
    }
    public Module getModuleByName(String name){
        for (Module module : getModules()){
            if (module.getName().equals(name))return module;
        }
        return null;
    }
}
