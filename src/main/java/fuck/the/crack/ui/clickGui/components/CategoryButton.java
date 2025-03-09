package fuck.the.crack.ui.clickGui.components;

import fuck.the.crack.Crack;
import fuck.the.crack.module.Category;
import fuck.the.crack.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;
import java.util.ArrayList;


public class CategoryButton {

   public int x,y,width,height, offset;
   public Category category;
   public boolean open,dragging;

   public ArrayList<ModuleButton> moduleButtons = new ArrayList<>();

   public CategoryButton(Category category, int x, int y, int width, int height){
       this.x=x;
       this.y=y;
       this.width=width;
       this.height=height;
       this.category=category;
       open=true;
       dragging=false;
       offset=0;
       for (Module module : Crack.moduleManager.getModulesInCategory(category)){
           offset+=height;
           moduleButtons.add(new ModuleButton(this, module, offset));
       }
   }

    public  void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(x,y,x+width,y+height,new Color(200,130,255,180).getRGB());
        context.drawBorder(x,y,width,height, new Color(0,0,0,180).getRGB());
        context.drawCenteredTextWithShadow(MinecraftClient.getInstance().textRenderer, category.toString().toLowerCase(),x+(width/2), (y+(height/2))-3, -1);
        if (open){
            for (ModuleButton button : moduleButtons)button.render(context, mouseX, mouseY, delta);
        }
    }

    public void mouseClick(double mouseX, double mouseY, int button){
      if (isHovered(mouseX, mouseY))this.toggle();
      for (ModuleButton moduleButton : moduleButtons){
          moduleButton.mouseClick(mouseX, mouseY, button);
      }
    }
    public boolean isHovered(double mouseX, double mouseY){
       return mouseX>=x && mouseX<=(x+width) && mouseY>=y && mouseY<=(y+height);
    }

    public void toggle(){
        open=!open;
    }

}
