package com.punchline.microspace.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.punchline.javalib.BaseGame;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.javalib.states.InputScreen;
import com.punchline.microspace.entities.SpaceWorld;

/**
 * The screen where actual gameplay takes place.
 * @author Nathaniel
 * @created Jul 24, 2013
 */
public class GameplayScreen extends InputScreen {

	private EntityWorld world;
	private OrthographicCamera camera;
	
	/**
	 * Constructs a GameplayScreen.
	 * @param game The game that owns this screen.
	 */
	public GameplayScreen(BaseGame game) {
		super(game);
		
		camera = new OrthographicCamera();
		resizeCamera();
		
		world = new SpaceWorld(game.getInput(), camera);
	}
	
	private void resizeCamera() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera.setToOrtho(false, w, h);
	}

	private void onPaused() {
		game.setScreen(new PauseMenuScreen(game, this), false);
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.ESCAPE) {
			onPaused();
			return true;
		}
		
		return false;
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
	public void pause() { 
		onPaused();
	}

	@Override
	public void resume() { }

	@Override
	public void dispose() {
		world.dispose();
	}

}
