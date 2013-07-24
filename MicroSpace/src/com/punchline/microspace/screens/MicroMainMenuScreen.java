package com.punchline.microspace.screens;

import com.badlogic.gdx.files.FileHandle;
import com.punchline.javalib.BaseGame;
import com.punchline.javalib.states.screens.MainMenuScreen;

public class MicroMainMenuScreen extends MainMenuScreen {

	public MicroMainMenuScreen(BaseGame game, FileHandle skinHandle) {
		super(game, skinHandle, "Micro Space", null);
	}

	@Override
	protected void onPlayGamePressed() {
		game.setScreen(new MicroGameplayScreen(game));
	}

	@Override
	protected void onSettingsPressed() {
		//TODO: Settings
	}

}
