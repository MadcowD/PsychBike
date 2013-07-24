package com.punchline.microspace.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.punchline.javalib.BaseGame;
import com.punchline.microspace.entities.SpaceWorld;

public class GameplayScreen implements Screen {

	BaseGame game;
	SpaceWorld world;
	OrthographicCamera camera;
	
	public GameplayScreen(BaseGame game) {
		this.game = game;
		
		camera = new OrthographicCamera();
		resizeCamera();
		
		world = new SpaceWorld(game.getInput(), camera);
	}

	private void resizeCamera() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera.setToOrtho(false, w, h);
	}
	
	@Override
	public void render(float delta) {
		world.process();
	}

	@Override
	public void resize(int width, int height) {
		resizeCamera();
	}

	@Override
	public void show() { }

	@Override
	public void hide() { }

	@Override
	public void pause() { }

	@Override
	public void resume() { }

	@Override
	public void dispose() {
		world.dispose();
	}

}
