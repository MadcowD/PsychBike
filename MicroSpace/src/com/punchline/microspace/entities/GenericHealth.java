package com.punchline.microspace.entities;

import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.javalib.entities.components.generic.Health;
import com.punchline.javalib.utils.SoundManager;

public class GenericHealth extends Health {

	public GenericHealth(Entity owner, EntityWorld world, float max) {
		super(owner, world, max);
		
		onDeath = new HealthEventCallback() {

			@Override
			public void invoke(Entity owner, EntityWorld world) {
				SoundManager.playSound("explosion");
				
				//TODO make explosion
			}
			
		};
		
		onDamage = new HealthEventCallback() {
			
			@Override
			public void invoke(Entity owner, EntityWorld world) {
				SoundManager.playSound("hit");
			}
			
		};
	}

	
	
}
