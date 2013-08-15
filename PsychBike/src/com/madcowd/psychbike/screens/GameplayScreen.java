package com.madcowd.psychbike.screens;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.madcowd.psychbike.entities.BikeWorld;
import com.punchline.javalib.BaseGame;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.javalib.states.InputScreen;
import com.punchline.javalib.utils.Display;

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
		
		camera = new OrthographicCamera(Display.getPreferredWidth(), Display.getPreferredHeight());
		//camera.setToOrtho(false, Display.getPreferredWidth(), Display.getPreferredHeight());
		
		world = new BikeWorld(game.getInput(), camera);
	}

	private void onPaused() {
		game.setScreen(new PauseMenuScreen(game, this), false);
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.ESCAPE || keycode == Keys.BACK) {
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
	public void resize(int width, int height) { }

	@Override
	public void show() { 
		world.resume();
		super.show();
	}

	@Override
	public void hide() {
		world.pause();
		super.hide();
	}

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
