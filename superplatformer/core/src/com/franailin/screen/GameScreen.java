package com.franailin.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.franailin.game.SuperPlatformer;
import com.franailin.gamestate.GameWorld;
import com.franailin.helper.AssetInitialize;
import com.franailin.helper.InputHandler;

public class GameScreen implements Screen  {

	SuperPlatformer sp;
	GameWorld world;
	OrthographicCamera camera;
	SpriteBatch batcher;
	InputHandler inputHandler;
	
	public GameScreen(SuperPlatformer sp)
	{
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batcher = new SpriteBatch();
		AssetInitialize.initializeAssets();
		batcher = new SpriteBatch();
		this.sp = sp;
		world = new GameWorld();
	    inputHandler = new InputHandler(world);
	    Gdx.input.setInputProcessor(inputHandler);
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world.update(delta);
		batcher.begin();
		batcher.draw(AssetInitialize.bg, 0, 0, AssetInitialize.bg.getWidth(),
				AssetInitialize.bg.getHeight());
		world.render(batcher);
		batcher.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
