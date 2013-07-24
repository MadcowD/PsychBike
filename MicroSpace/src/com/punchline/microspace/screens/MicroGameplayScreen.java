package com.punchline.microspace.screens;

import com.punchline.javalib.BaseGame;
import com.punchline.javalib.states.screens.GameplayScreen;
import com.punchline.microspace.entities.SpaceWorld;

public class MicroGameplayScreen extends GameplayScreen {

	public MicroGameplayScreen(BaseGame game) {
		super(game);
	}

	@Override
	protected void initializeWorld() {
		world = new SpaceWorld(game.getInput(), camera);
	}
	
}
