package com.punchline.microspace.entities.systems;

import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.components.physical.Transform;
import com.punchline.javalib.entities.systems.TypeSystem;

public class MookSpawnSystem extends TypeSystem {

	private static final float SPAWN_DELAY = 1;
	
	private float elapsed = 0f;
	
	public MookSpawnSystem() {
		super("Base");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processEntities() {
		elapsed += deltaSeconds();
		
		super.processEntities();
		
		if (elapsed >= SPAWN_DELAY) elapsed = 0f;
	}

	@Override
	protected void process(Entity e) {
		
		if (elapsed >= SPAWN_DELAY) {
		
			Transform t = e.getComponent();
			
			world.createEntity("Mook", e.getGroup(), t.getPosition());
			
		}
	}

}
