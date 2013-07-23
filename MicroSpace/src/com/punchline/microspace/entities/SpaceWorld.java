package com.punchline.microspace.entities;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.microspace.entities.templates.scenery.BigPlanetTemplate;

public class SpaceWorld extends EntityWorld {

	public SpaceWorld(Camera camera) {
		super(camera, Vector2.Zero, true);
		
		debugView.enabled = true;
		debugView.visible = true; //TODO: Remember to disable this...
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
	}



	@Override
	protected void positionCamera() {
		camera.position.set(new Vector3(0, 0, 0));
	}
	
	@Override
	protected void buildSystems() {		
		super.buildSystems();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void buildTemplates() {
		super.buildTemplates();
		
		addTemplate("BigPlanet", new BigPlanetTemplate());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void buildEntities() {
		super.buildEntities();
		
		createEntity("BigPlanet", Vector2.Zero);
	}
	
}
