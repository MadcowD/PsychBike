/**
 * 
 */
package com.punchline.microspace.entities.templates.projectiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.EntityTemplate;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.javalib.entities.components.Bullet;
import com.punchline.javalib.entities.components.physical.Particle;
import com.punchline.javalib.entities.components.render.Sprite;
import com.punchline.javalib.utils.Convert;

/**
 * @author William
 * @created Jul 23, 2013
 */
public class BulletTemplate implements EntityTemplate {
	private Texture sheetTexture;
	private TextureRegion framesRegion;
	
	/** {@inheritDoc}
	 * @see com.punchline.javalib.entities.EntityTemplate#buildEntity(com.punchline.javalib.entities.Entity, com.punchline.javalib.entities.EntityWorld, java.lang.Object[])
	 */
	@SuppressWarnings("unused")
	@Override
	public Entity buildEntity(Entity e, EntityWorld world, Object... args) {
		e.init("", "Bullets", "Projectiles");
		
		//ARGS
		String type = (String)args[0];
		Vector2 position = (Vector2)args[1];
		
		Vector2 linearVelocity = (Vector2)args[2];
		float rotation = Convert.degreesToRadians(linearVelocity.angle());
		
		Entity firer = (Entity)args[3];
		float damage = (Float)args[4];
	
		
		//Particle
		Particle p = e.addComponent(new Particle(e, position, rotation));
		p.setLinearVelocity(linearVelocity);
		
		//bullet
		Bullet b = e.addComponent(new Bullet(firer, damage));
		
		
		
		//Sprite TODO: Write sprite code!
		Sprite s;
		if(type.equalsIgnoreCase("blue")){
			
		}
		else if(type.equalsIgnoreCase("red")){
			
		}
		
		return e;
	}

}
