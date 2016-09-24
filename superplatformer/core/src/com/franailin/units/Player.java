package com.franailin.units;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.franailin.gamestate.GameWorld;
import com.franailin.helper.AssetInitialize;

public class Player extends Unit
{
	Sprite protForward;
	Sprite protBackward;
	GameWorld world;
	private static Texture playerFrontTexture;
	private static Texture playerBackwardTexture;
	int animationCount = 0;
	
	public boolean jump = false;
	boolean inAir = false;
	public State state;
	
	public enum State
	{
		ONPLATFORM, JUMPING, FALLING
	}
	
	static
	{
		playerFrontTexture = new Texture(Gdx.files.internal("data/prot_ba.png"));
		playerBackwardTexture = new Texture(Gdx.files.internal("data/prot_fo.png"));
	}
	
	public Player(float x, float y, float scaleX, float scaleY, GameWorld world)
	{
		super(x, y, playerFrontTexture.getWidth() * scaleX, playerFrontTexture.getHeight() * scaleY);
		this.world = world;
		protForward = new Sprite(playerFrontTexture, playerFrontTexture.getWidth(), playerFrontTexture.getHeight());
		animation.add(protForward);
		protBackward = new Sprite(playerBackwardTexture, playerBackwardTexture.getWidth(), playerBackwardTexture.getHeight());
		animation.add(protBackward);
		animation.add(protForward);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, -460);
		position = new Vector2(x, y);
		state = State.ONPLATFORM;
	}
	
	public void update(ArrayList<Platform> platforms, ArrayList<Enemy> enemies, float delta)
	{
		if (y + height < 0)
		{
			world.setGameOver();
			return;
		}
		
		switch (state)
		{
			case ONPLATFORM:
				velocity.y = 0;
				break;
			case JUMPING:
				velocity.add(acceleration.cpy().scl(delta));
				position.add(velocity.cpy().scl(delta));
				
				x = position.x;
				y = position.y;
				if (velocity.y <= 0)
				{
					state = State.FALLING;
				}
				break;
			case FALLING:
				velocity.add(acceleration.cpy().scl(delta));
				if (velocity.y < -500) {
		            velocity.y = -500;
		        }
				
				position.add(velocity.cpy().scl(delta));
				
				x = position.x;
				y = position.y;
				if (onPlatform(platforms))
				{
					state = State.ONPLATFORM;
				}
				break;
		}
	}
	
	public void render(SpriteBatch batcher)
	{
		batcher.draw(animation.get(animationCount), x, y, getWidth(), getHeight());
		if (animationCount == 0)
		{
			animationCount = 1;
		}
		else
		{
			animationCount = 0;
		}
		
	}
	
	public void renderPause(SpriteBatch batcher)
	{
		batcher.draw(animation.get(0), x, y, getWidth(), getHeight());
	}
	
	public boolean onPlatform(ArrayList<Platform> platforms)
	{
		for (int x = 0; x < platforms.size(); x++)
		{
			if (platforms.get(x).overlaps(this))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean hitEnemy(ArrayList<Enemy> enemies)
	{
		for (int x = 0; x < enemies.size(); x++)
		{
			if (enemies.get(x).overlaps(this))
			{
				return true;
			}
		}
		return false;
	}
	
	public void jumped(ArrayList<Platform> platforms)
	{
		if (State.ONPLATFORM == state)
		{
			velocity.y = 400;
			state = State.JUMPING;
		}
		
	}
}
