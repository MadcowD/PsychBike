package com.punchline.microspace.entities.templates.structures;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.EntityGroupTemplate;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.javalib.entities.components.physical.Body;

/**
 * Builds a base!
 * @author William
 * @created Jul 27, 2013
 */
public class BaseTemplate implements EntityGroupTemplate {

	public BaseTemplate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Entity> buildEntities(EntityWorld world, Object... args) {
		ArrayList<Entity> baseStructures = new ArrayList<Entity>();
		
		//ARGS
		String team = (String)args[0];
		int multiplier =0;
		if(team.equalsIgnoreCase("leftTeam"))
			multiplier = -1;
		else
			multiplier = 1;
		
		
		//BUILD BASE
		
		baseStructures.add(world.createEntity("BaseShip", team, new Vector2(700, 0).scl(multiplier)));
		
		//set up turrets
		baseStructures.add(world.createEntity("BaseTurret", team, new Vector2(570, -30).scl(multiplier))); 
		baseStructures.add(world.createEntity("BaseTurret", team, new Vector2(570, 30).scl(multiplier))); 
		baseStructures.add(world.createEntity("BaseTurret", team, new Vector2(510, -60).scl(multiplier))); 
		baseStructures.add(world.createEntity("BaseTurret", team, new Vector2(510, 60).scl(multiplier))); 
		baseStructures.add(world.createEntity("BaseTurret", team, new Vector2(510, -120).scl(multiplier))); 
		baseStructures.add(world.createEntity("BaseTurret", team, new Vector2(510, 120).scl(multiplier))); 
		
		//set up barracks
		baseStructures.add(world.createEntity("BaseBarracks", team, new Vector2(550, -90).scl(multiplier))); 
		baseStructures.add(world.createEntity("BaseBarracks", team, new Vector2(550, 90).scl(multiplier))); 
		
		//set up mining rigs
		baseStructures.add(world.createEntity("BaseMine", team, new Vector2(720, 110).scl(multiplier))); 
		baseStructures.add(world.createEntity("BaseMine", team, new Vector2(690, -110).scl(multiplier))); 
		
		for(Entity e : baseStructures){
			Body b = e.getComponent();
			b.setRotation(b.getRotation() + (float)(Math.PI/2f + multiplier*Math.PI/2f));
		}
		
		
		
		return baseStructures;
	}

}
