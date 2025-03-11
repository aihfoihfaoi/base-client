package fuck.the.crack.module;

public class Settings {

    private static double min, def, max, increment;
    private static int  i;
    private static boolean toggled;
    private static String defS, name, defM,newS;
    private static String[] strings;


    public  Settings(String name, boolean def){
        this.name=name;
        this.toggled=def;
    }
    public Settings(String name, double min, double def, double max, double increment){
        this.name=name;
        this.min=min;
        this.def=def;
        this.max=max;
        this.increment=increment;
    }
    public Settings(String name, String def, String newDef){
        this.name = name;
        this.defS=def;
        this.newS=newDef;
    }
    public Settings(String name, String def, String ... modes){
        this.name=name;
        this.defM=def;
        this.strings=modes;

        for(int c = 0; c < modes.length; c++) {
            if(modes[i].equalsIgnoreCase(defM)) {
                i = c;
                break;
            }
        }
    }

    public static String getName(){return name;}


    //Boolean setting
    public static boolean isToggled() {
        return toggled;
    }

    //Number setting
    public static double getDef(){return def;}
    public static double getMin(){return min;}
    public static double getMax() {return max;}
    public static double getIncrement(){return increment;}
    public void increment(boolean positive) {
        setValue(getDef() + (positive ? 1 : -1) * increment);
    }
    public void setValue(double value) {
        double precision = 1.0 / increment;
        this.def = Math.round(Math.max(min, Math.min(max, value)) * precision) / precision;
    }

    //Mode setting
    public static String getCurrentMode(){return strings[i];}
    public static String getDefMode(){return defM;}
    public String[] getModes() {return strings;}
    public static boolean isMode(String mode){return (mode.equals(getCurrentMode()));}
    public static int getI(){return i;}
    public static void setMode(String mode){
        for(int c = 0; c < strings.length; c++) {
        if(strings[c].equalsIgnoreCase(mode)) {
            i = c;
            break;
         }
        }
    }
    public static void setI(int index){i=index;}
    public void cycle(){
        if(i < strings.length - 1) {
            i++;
        } else {
            i = 0;
        }
    }


}
