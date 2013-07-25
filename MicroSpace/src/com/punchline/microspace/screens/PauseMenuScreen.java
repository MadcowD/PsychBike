package com.punchline.microspace.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.punchline.javalib.BaseGame;
import com.punchline.javalib.states.screens.MenuScreen;

public class PauseMenuScreen extends MenuScreen {

	private GameplayScreen gameplayScreen;
	
	public PauseMenuScreen(BaseGame game, GameplayScreen gameplayScreen) {
		super(game, Gdx.files.internal("data/Skin/uiskin.json"), "Paused", null);
		
		this.gameplayScreen = gameplayScreen;
	}	

	@Override
	protected void initialize() {
		
		super.initialize();
		
		Button playButton = new TextButton("Resume", skin);
		Button quitButton = new TextButton("Back to Menu", skin);
		
		//TODO: Add buttons events.
		playButton.addListener(new ClickListener() {
			
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				onPlayGamePressed();
			}
			
		});
		
		quitButton.addListener(new ClickListener() {
			
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				onQuitPressed();
			}
			
		});
		
		window.add(playButton);
		window.row();
		window.add(quitButton);
		window.row();
		
	}

	/**
	 * Called when the Play Game button is pressed.
	 */
	private void onPlayGamePressed() {
		game.setScreen(gameplayScreen, false);
	}
	
	/**
	 * Called when the Quit button is pressed.
	 */
	private void onQuitPressed() {
		game.setScreen(new MainMenuScreen(game));
	}
	
}
