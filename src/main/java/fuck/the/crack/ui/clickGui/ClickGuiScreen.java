package fuck.the.crack.ui.clickGui;

import fuck.the.crack.module.Category;
import fuck.the.crack.ui.clickGui.components.CategoryButton;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;

public class ClickGuiScreen extends Screen {
    int x = 20;
    private ArrayList<CategoryButton> categoryButtons = new ArrayList<>();
    public ClickGuiScreen(){
        super(Text.literal("CrackLover"));
        for (Category category : Category.values()){
            categoryButtons.add(new CategoryButton(category,x,20,80,13));
            x+=120;
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        for (CategoryButton categoryButton : categoryButtons){
            categoryButton.render(context, mouseX, mouseY, delta);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (CategoryButton categoryButton : categoryButtons){
            categoryButton.mouseClick(mouseX, mouseY, button);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

}
