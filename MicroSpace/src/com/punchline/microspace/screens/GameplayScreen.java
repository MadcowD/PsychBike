package com.punchline.microspace.screens;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.Screen;
import com.punchline.microspace.entities.SpaceWorld;

public class GameplayScreen implements Screen {

	SpaceWorld world;
	
	public GameplayScreen(Camera camera) {
		world = new SpaceWorld(camera);
	}
	
	@Override
	public void render(float delta) {
		world.process();
	}

	@Override
	public void resize(int width, int height) { }

	@Override
	public void show() { }

	@Override
	public void hide() { }

	@Override
	public void pause() { }

	@Override
	public void resume() { }

	@Override
	public void dispose() {
		world.dispose();
	}

}
