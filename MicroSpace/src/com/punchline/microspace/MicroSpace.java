package com.punchline.microspace;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.punchline.javalib.utils.SoundManager;
import com.punchline.javalib.utils.Convert;
import com.punchline.microspace.entities.SpaceWorld;
import com.punchline.microspace.screens.GameplayScreen;

public class MicroSpace extends Game {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	
	@Override
	public void create() {
		Convert.init(8);
		
		Gdx.graphics.setTitle("Micro Space");
		Gdx.graphics.setDisplayMode(800, 400, false);
		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
		
		batch = new SpriteBatch();
		
		setScreen(new GameplayScreen(camera));
	}

	@Override
	public void dispose() {
		batch.dispose();
		getScreen().dispose();
		SoundManager.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		getScreen().render(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
