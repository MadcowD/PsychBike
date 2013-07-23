package com.punchline.microspace.entities.templates.scenery;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.EntityTemplate;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.javalib.entities.components.render.Animation;
import com.punchline.javalib.entities.components.render.Renderable;

public class BigPlanetTemplate implements EntityTemplate {

	private static Random rand = new Random();
	
	private static final int SHEET_COLUMNS = 6;
	private static final int SHEET_ROWS = 2;
	private static final int FRAMES = 11;
	private static final int FRAMES_WIDTH = 236;
	private static final int FRAMES_HEIGHT = 78;
	
	private Texture sheetTexture;
	private TextureRegion framesRegion;
	
	public BigPlanetTemplate() {
		sheetTexture = new Texture(Gdx.files.internal("data/BigPlanets.png"));
		framesRegion = new TextureRegion(sheetTexture, FRAMES_WIDTH, FRAMES_HEIGHT);
	}
	
	/**
	 * Makes a Big Planet entity.
	 * @param args args[0] = Vector2 position.
	 */
	@Override
	public Entity buildEntity(EntityWorld world, Object... args) {
		
		Entity e = new Entity("", "Scenery", "BigPlanet");
		
		//Retrieve args
		Vector2 position = (Vector2)args[0];
		
		Renderable sprite = new Animation(sheetTexture, framesRegion, SHEET_COLUMNS, SHEET_ROWS, 1f) {
			public int frame = rand.nextInt(FRAMES + 1);
			
			public void draw(SpriteBatch spriteBatch, float deltaSeconds) {
				super.setStateTime(frame);
				super.draw(spriteBatch, 0);
			}
		};
		
		sprite.setPosition(position);
		
		e.addComponent(Renderable.class, sprite);
		
		return e;
		
	}
	
}
