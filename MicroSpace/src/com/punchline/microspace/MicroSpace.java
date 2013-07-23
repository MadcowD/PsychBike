package com.punchline.microspace;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.punchline.javalib.utils.SoundManager;
import com.punchline.javalib.utils.Convert;
import com.punchline.microspace.screens.GameplayScreen;

public class MicroSpace extends Game {
	
	@Override
	public void create() {
		Convert.init(8);
		
		Gdx.graphics.setTitle("Micro Space");
		Gdx.graphics.setDisplayMode(800, 400, false);
		
		setScreen(new GameplayScreen(this));
	}
	
	

	/**
	 * {@inheritDoc}
	 * Disposes of the previous screen.
	 */
	@Override
	public void setScreen(Screen screen) {
		Screen oldScreen = getScreen();
		super.setScreen(screen);
		oldScreen.dispose();
	}

	@Override
	public void dispose() {
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
		getScreen().resize(width, height); 
	}

	@Override
	public void pause() { }

	@Override
	public void resume() { }
	
}
