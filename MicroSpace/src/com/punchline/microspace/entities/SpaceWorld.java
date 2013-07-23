package com.punchline.microspace.entities;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.microspace.entities.systems.RotationSystem;
import com.punchline.microspace.entities.templates.ShipTemplate;

public class SpaceWorld extends EntityWorld {

	public SpaceWorld(Camera camera) {
		super(camera, Vector2.Zero, true);
		
		debugView.enabled = true; //TODO: Remember to disable this...
	}

	@Override
	protected void buildSystems() {
		systems.addSystem(new RotationSystem());
		
		
		super.buildSystems();
	}

	@Override
	protected void buildTemplates() {
		addTemplate("Ship", new ShipTemplate());
		
		super.buildTemplates();
	}

	@Override
	protected void buildEntities() {
	
		createEntity("Ship");
		
		super.buildEntities();
	}

	
	
}
