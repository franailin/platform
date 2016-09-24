package com.franailin.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.franailin.game.SuperPlatformer;

public class DesktopLauncher {
	public static int width = 1280;
	public static int height = 720;
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Super Platformer";
		config.width = width;
		config.height = height;
		new LwjglApplication(new SuperPlatformer(), config);
	}
}
