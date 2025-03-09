package fuck.the.crack.manager;

import fuck.the.crack.module.Category;
import fuck.the.crack.module.Module;
import fuck.the.crack.module.modules.client.ClickGui;
import fuck.the.crack.module.modules.client.Test;

import java.util.ArrayList;

public class ModuleManager {

    private ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager(){
        addModules();
    }

    private void addModules(){
        modules.add(new Test());
        modules.add(new ClickGui());
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

    public ArrayList<Module> getModulesInCategory(Category category){
        ArrayList<Module> a = new ArrayList<>();
        for (Module module : getModules()){
            if (module.getCategory().equals(category))a.add(module);
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
