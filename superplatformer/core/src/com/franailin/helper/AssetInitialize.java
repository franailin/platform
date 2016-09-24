package com.franailin.helper;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class AssetInitialize 
{
	public static Sprite bg;
	
	public static void initializeAssets()
	{
		//background
		Texture background = new Texture(Gdx.files.internal("data/cloud_scene.png"));
		bg = new Sprite(background, background.getWidth(), background.getHeight());
	}
	
}
