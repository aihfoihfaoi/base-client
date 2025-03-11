package fuck.the.crack.module;

import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.Arrays;

public class Module {

    private String name, description;
    private Category category;
    private int key;
    private boolean toggled;
    private ArrayList<Settings> settings;


    public MinecraftClient mc = MinecraftClient.getInstance();

    public Module(String name, Category category){
        super();
        this.name=name;
        this.description="";
        this.category=category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public int getKey() {
        return key;
    }

    public boolean isToggled() {
        return toggled;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public void addSetting(Settings setting){settings.add(setting);}
    public void addSettings(Settings ...setting){settings.addAll(Arrays.asList(setting));}
    public ArrayList<Settings> getSettings(){return settings;}
    public Settings getSettingByName(String name){
        for (Settings set : settings) {
            if (set.getName().equals(name)) return set;
        }
        return null;
    }


    public void onEnable(){}
    public void onDisable(){}
    public void onTick(){}

    public void toggle(){
        toggled=!toggled;
        if (toggled)onEnable();
        else onDisable();
    }

    public boolean nullCheck(){return mc.player==null||mc.world==null;}
}
