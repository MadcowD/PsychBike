package com.punchline.microspace;

import com.badlogic.gdx.Gdx;
import com.punchline.javalib.BaseGame;
import com.punchline.javalib.states.screens.SplashScreen;
import com.punchline.javalib.utils.Convert;
import com.punchline.microspace.screens.GameplayScreen;

public class MicroSpace extends BaseGame {
	
	@Override
	public void create() {
		Convert.init(8);
		
		title = "Micro Space";
		
		landscapeMode = true;
		
		super.create();
		
		setScreen(new SplashScreen(this, Gdx.files.internal("data/Textures/splash.png"), new GameplayScreen(this), 1.25f, 4f, 1.25f));
	}
	
	@Override
	protected void loadSounds() { }
	
}
