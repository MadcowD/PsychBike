package com.punchline.microspace.entities.systems;

import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.components.BaseTransform;
import com.punchline.javalib.entities.systems.ComponentSystem;

public class RotationSystem extends ComponentSystem {

	@SuppressWarnings("unchecked")
	public RotationSystem() {
		super(BaseTransform.class);
	}

	@Override
	protected void onAdded(Entity e) {
		BaseTransform t = e.getComponent();
		
		t.setAngularVelocity(1f);
	}
	
	
	
}
