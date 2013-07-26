package com.punchline.microspace.screens;

import com.badlogic.gdx.Gdx;
import com.punchline.javalib.BaseGame;
import com.punchline.javalib.states.screens.generic.SettingsScreen;

public class MicroSettingsScreen extends SettingsScreen {
	
	public MicroSettingsScreen(BaseGame game) {
		super(game, Gdx.files.internal("data/Skin/uiskin.json"), "Settings", null);
	}
	
}
