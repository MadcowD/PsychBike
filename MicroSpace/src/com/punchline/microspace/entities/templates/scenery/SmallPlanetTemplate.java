package com.punchline.microspace.entities.templates.scenery;

import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.EntityTemplate;
import com.punchline.javalib.entities.EntityWorld;

public class SmallPlanetTemplate implements EntityTemplate {

	@Override
	public Entity buildEntity(EntityWorld world, Object... args) {
		Entity e = new Entity("", "Scenery", "SmallPlanet");
		
		
		
		return e;
	}

}
