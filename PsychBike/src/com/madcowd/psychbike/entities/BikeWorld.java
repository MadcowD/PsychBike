package com.madcowd.psychbike.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.javalib.entities.systems.generic.TrackingCameraSystem;
import com.punchline.javalib.utils.Convert;

public class BikeWorld extends EntityWorld {
	
	public BikeWorld(InputMultiplexer input, Camera camera) {
		super(input, camera, new Vector2(0, -9.8f));
		((OrthographicCamera)camera).zoom = 0.01f;
	}

	@Override
	public void process() {
		super.process();
	}

	@Override
	public Rectangle getBounds() {
		return Convert.pixelsToMeters(
				new Rectangle(
					-Gdx.graphics.getWidth() * 2, 
					-Gdx.graphics.getHeight() / 2, 
					Gdx.graphics.getWidth() * 4, 
					Gdx.graphics.getHeight()));
	}

	@Override
	protected void positionCamera() { }
	
	@Override
	protected void buildSystems() {		
		super.buildSystems();
		
		//Input
		systems.addSystem(new TrackingCameraSystem("Player", camera, getBounds()));

	}

	@Override
	protected void buildTemplates() {
		super.buildTemplates();
		

	}

	@Override
	protected void buildEntities() {
		super.buildEntities();
	}

	@Override
	protected void buildSpriteSheet() {
		// TODO Auto-generated method stub
		
	}
	
}
