package com.franailin.units;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Unit extends Rectangle 
{
	public ArrayList<Sprite> animation;
	Vector2 acceleration;
	Vector2 velocity;
	Vector2 position;
	
	public Unit(float x, float y, float width, float height)
	{
		super(x, y, width, height);
		animation = new ArrayList<Sprite>();
	}
}
