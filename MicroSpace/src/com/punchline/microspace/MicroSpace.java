package com.punchline.microspace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.punchline.javalib.BaseGame;
import com.punchline.javalib.states.screens.generic.SplashScreen;
import com.punchline.javalib.utils.Convert;
import com.punchline.javalib.utils.SoundManager;
import com.punchline.microspace.screens.MicroMainMenuScreen;
import com.punchline.microspace.screens.MicroSettingsScreen;

public class MicroSpace extends BaseGame {
	
	public MicroSpace() {
		super();	
	}
	
	@Override
	public void create() {
		Convert.init(1);
		
		title = "Micro Space";
		
		landscapeMode = true;
		
		cursorTexture = new Texture(Gdx.files.internal("data/Textures/cursor.png"));
		
		//make screens
		splash = new SplashScreen(this, Gdx.files.internal("data/Textures/splash.png"), 1.25f, 4f, 1.25f);
		mainMenu = new MicroMainMenuScreen(this);
		settings = new MicroSettingsScreen(this);
		
		super.create();
	}
	
	@Override
	protected void loadSounds() { 
		Preferences pref = Gdx.app.getPreferences("settings");
		
		float soundVol = pref.getBoolean("Sound", true) ? 1f : 0f;
		float musicVol = pref.getBoolean("Music", true) ? 1f : 0f;
		
		SoundManager.setSoundVolume(soundVol);
		SoundManager.setMusicVolume(musicVol);
	}
	
}
