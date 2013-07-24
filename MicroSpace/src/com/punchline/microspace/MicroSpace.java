package com.punchline.microspace;

import com.punchline.javalib.BaseGame;
import com.punchline.javalib.utils.Convert;
import com.punchline.microspace.screens.GameplayScreen;

public class MicroSpace extends BaseGame {
	
	@Override
	public void create() {
		Convert.init(8);
		
		title = "Micro Space";
		
		landscapeMode = true;
		
		super.create();
		
		setScreen(new GameplayScreen(this));
	}
	
	@Override
	protected void loadSounds() { }
	
}
