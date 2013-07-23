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
import com.punchline.javalib.entities.components.physical.Particle;
import com.punchline.javalib.entities.components.physical.Transform;
import com.punchline.javalib.entities.components.render.Animation;
import com.punchline.javalib.entities.components.render.Renderable;

public class SmallPlanetTemplate implements EntityTemplate {

	private static Random rand = new Random();
	
	private static final int SHEET_COLUMNS = 6;
	private static final int SHEET_ROWS = 1;
	private static final int FRAMES = 6;
	private static final int FRAMES_WIDTH = 144;
	private static final int FRAMES_HEIGHT = 25;
	
	private Texture sheetTexture;
	private TextureRegion framesRegion;
	
	public SmallPlanetTemplate() {
		sheetTexture = new Texture(Gdx.files.internal("data/Textures/Scenery/SmallPlanets.png"));
		framesRegion = new TextureRegion(sheetTexture, FRAMES_WIDTH, FRAMES_HEIGHT);
	}
	
	/**
	 * Makes a SmallPlanet entity.
	 */
	@Override
	public Entity buildEntity(EntityWorld world, Object... args) {
		Entity e = new Entity("", "Scenery", "SmallPlanet");
		
		Vector2 position = (Vector2)args[0];
		
		Renderable sprite = new Animation(sheetTexture, framesRegion, SHEET_COLUMNS, SHEET_ROWS, 1f) {
			public int frame = rand.nextInt(FRAMES);
			
			public void draw(SpriteBatch spriteBatch, float deltaSeconds) {
				super.setStateTime(frame);
				super.draw(spriteBatch, 0);
			}
		};
		
		e.addComponent(Renderable.class, sprite);
		
		Transform t = new Particle(e, position, 0f);
		e.addComponent(t);
		
		return e;
	}

}
