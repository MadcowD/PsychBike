package com.punchline.microspace.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.javalib.entities.systems.generic.CameraMovementSystem;
import com.punchline.microspace.Worlds;
import com.punchline.microspace.entities.systems.AsteroidSpawnSystem;
import com.punchline.microspace.entities.systems.MookSpawnSystem;
import com.punchline.microspace.entities.systems.PlayerControlSystem;
import com.punchline.microspace.entities.templates.AsteroidTemplate;
import com.punchline.microspace.entities.templates.MookTemplate;
import com.punchline.microspace.entities.templates.projectiles.BulletTemplate;
import com.punchline.microspace.entities.templates.scenery.BigPlanetTemplate;
import com.punchline.microspace.entities.templates.scenery.BigStarTemplate;
import com.punchline.microspace.entities.templates.scenery.SmallPlanetTemplate;
import com.punchline.microspace.entities.templates.scenery.SmallStarTemplate;
import com.punchline.microspace.entities.templates.scenery.StarFieldTemplate;
import com.punchline.microspace.entities.templates.structures.BaseShipTemplate;

public class SpaceWorld extends EntityWorld {
	
	public SpaceWorld(InputMultiplexer input, Camera camera) {
		super(input, camera, new Vector2(0, 0), true);
		
		debugView.enabled = true;
		debugView.visible = true; //TODO: Remember to disable this...
		
		Worlds.worlds.add(this);
	}

	/**
	 * {@inheritDoc}
	 */
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
		
		//Input
		systems.addSystem(new CameraMovementSystem(input, camera, getBounds()));
		systems.addSystem(new PlayerControlSystem(input));
		
		//Spawning
		systems.addSystem(new AsteroidSpawnSystem());
		systems.addSystem(new MookSpawnSystem());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void buildTemplates() {
		super.buildTemplates();
		
		//Projectiles
		addTemplate("Bullet", new BulletTemplate());
		
		//Scenery
		addTemplate("BigPlanet", new BigPlanetTemplate());
		addTemplate("SmallPlanet", new SmallPlanetTemplate());
		addTemplate("BigStar", new BigStarTemplate());
		addTemplate("SmallStar", new SmallStarTemplate());
		addGroupTemplate("StarField", new StarFieldTemplate());
		
		
		//STRUCTURES
		addTemplate("BaseShip", new BaseShipTemplate());
		
		//Entities
		addTemplate("Player", new PlayerTemplate());
		addTemplate("Asteroid", new AsteroidTemplate());
		addTemplate("Mook", new MookTemplate());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void buildEntities() {
		super.buildEntities();
		createEntityGroup("StarField");	
		
		//BUILD BASES
		createEntity("BaseShip", "leftTeam", new Vector2(-700, 0));
		
		createEntity("Player", "leftTeam");
	}
	
}
