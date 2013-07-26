package com.punchline.microspace.screens;

import com.badlogic.gdx.Gdx;
import com.punchline.javalib.BaseGame;
import com.punchline.javalib.states.screens.generic.MainMenuScreen;

public class MicroMainMenuScreen extends MainMenuScreen {
	
	/**
	 * Makes a MainMenuScreen.
	 * @param game The game.
	 * @param skinHandle A FileHandle pointing to the menu's skin.
	 * @param textureHandle A FileHandle pointing to the background texture.
	 */
	public MicroMainMenuScreen(BaseGame game) {
		super(game, Gdx.files.internal("data/Skin/uiskin.json"), "Micro Space", null);
	}
	
}
