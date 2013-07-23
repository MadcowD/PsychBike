package com.punchline.microspace.entities;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.microspace.entities.templates.scenery.BigPlanetTemplate;

public class SpaceWorld extends EntityWorld {

	public SpaceWorld(Camera camera) {
		super(camera, Vector2.Zero, true);
		
		debugView.enabled = true; //TODO: Remember to disable this...
	}

	@Override
	protected void buildSystems() {		
		super.buildSystems();
	}

	@Override
	protected void buildTemplates() {
		super.buildTemplates();
		
		addTemplate("BigPlanet", new BigPlanetTemplate());
	}

	@Override
	protected void buildEntities() {
		super.buildEntities();
		
		createEntity("BigPlanet", new Vector2(50, 25));
	}
	
}
