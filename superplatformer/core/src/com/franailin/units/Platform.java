package com.franailin.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.franailin.helper.AssetInitialize;

public class Platform extends Unit
{
	/**
	 * The Sprite of the platform
	 */
	public Sprite platform;
	/**
	 * The Texture of the platform
	 */
	public static Texture platformTexture;

	static
	{
		platformTexture = new Texture(Gdx.files.internal("data/Platform.png"));
	}
	/**
	 * Constructs a new platform at xy location with a certain width and height
	 * @param x x-coordinate
	 * @param y	y-coordinate
	 * @param width	width
	 * @param height height
	 */
	public Platform(float x, float y, float width, float height)
	{
		super(x, y, width, height);
		platform = new Sprite(platformTexture);
		animation.add(platform);
		position = new Vector2(x, y);
		velocity = new Vector2(-100, 0);
		acceleration = new Vector2(0, 0);
	}
	
	/**
	 * This will draw the platform at it's location while the game is running
	 * @param batcher	Required to draw
	 */
	public void render(SpriteBatch batcher)
	{
		batcher.draw(animation.get(0), x, y, getWidth(), getHeight());
	}
	
	/**
	 * This will draw the platform at it's location while the game is paused
	 * @param batcher	Required to draw
	 */
	public void renderPause(SpriteBatch batcher)
	{
		batcher.draw(animation.get(0), x, y, getWidth(), getHeight());
	}
	
	/**
	 * Updates position in world, and checks to see if it moves off screen.
	 * @return True if moves off left side of screen, false if not.
	 */
	public boolean updateAndRemoveIfTrue(float delta)
	{
		velocity.add(acceleration.cpy().scl(delta));
		position.add(velocity.cpy().scl(delta));
		x = position.x;
		y = position.y;
		return x + width < 0;
	}
}
