package com.franailin.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.franailin.screen.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;

public class SuperPlatformer extends Game {
	@Override
	public void create () {
		Gdx.app.log("SuperPlatformer", "Created");
		setScreen(new GameScreen(this));
	}
}
