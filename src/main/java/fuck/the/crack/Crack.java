package fuck.the.crack;

import fuck.the.crack.manager.ModuleManager;
import fuck.the.crack.ui.clickGui.ClickGuiScreen;
import net.fabricmc.api.ModInitializer;

import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class Crack implements ModInitializer {

	public static final String MOD_ID = "crack";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	public static ModuleManager moduleManager;
	public static ClickGuiScreen clickGuiScreen;
	@Override
	public void onInitialize() {
		moduleManager=new ModuleManager();
		clickGuiScreen=new ClickGuiScreen();
	}


}