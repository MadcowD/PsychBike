package com.punchline.microspace.entities.systems;

import com.badlogic.gdx.math.Vector2;
import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.components.physical.Transform;
import com.punchline.javalib.entities.systems.TypeSystem;

public class MookSpawnSystem extends TypeSystem {

	private static final float SPAWN_DELAY = 5;
	private static final float BASE_OFFSET = 50f;
	
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
			
			Vector2 pos = t.getPosition();
			
			if (e.getGroup().equals("leftTeam")) {
				pos.x += BASE_OFFSET; 
			} else if (e.getGroup().equals("rightTeam")) {
				pos.x -= BASE_OFFSET;
			}
			
			world.createEntity("Mook", e.getGroup(), pos);
			
		}
	}

}
