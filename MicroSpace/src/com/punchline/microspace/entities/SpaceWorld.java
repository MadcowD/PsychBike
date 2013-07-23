package com.punchline.microspace.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.microspace.entities.templates.scenery.BigPlanetTemplate;
import com.punchline.microspace.entities.templates.scenery.BigStarTemplate;
import com.punchline.microspace.entities.templates.scenery.SmallPlanetTemplate;
import com.punchline.microspace.entities.templates.scenery.SmallStarTemplate;
import com.punchline.microspace.entities.templates.scenery.StarFieldTemplate;

public class SpaceWorld extends EntityWorld {

	public SpaceWorld(Camera camera) {
		super(camera, Vector2.Zero, true);
		
		debugView.enabled = true;
		debugView.visible = true; //TODO: Remember to disable this...
	}

	
	
	@Override
	public void process() {
		super.process();
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(
				-Gdx.graphics.getWidth(), 
				-Gdx.graphics.getHeight() / 2, 
				Gdx.graphics.getWidth() * 2, 
				Gdx.graphics.getHeight());
	}

	@Override
	protected void positionCamera() {
		camera.position.set(new Vector3(0, 0, 0));
	}
	
	@Override
	protected void buildSystems() {		
		super.buildSystems();
	}

	@Override
	protected void buildTemplates() {
		super.buildTemplates();
		
		//Scenery
		addTemplate("BigPlanet", new BigPlanetTemplate());
		addTemplate("SmallPlanet", new SmallPlanetTemplate());
		addTemplate("BigStar", new BigStarTemplate());
		addTemplate("SmallStar", new SmallStarTemplate());
		addGroupTemplate("StarField", new StarFieldTemplate());
	}

	@Override
	protected void buildEntities() {
		super.buildEntities();
		
		createEntityGroup("StarField");
	}
	
}
