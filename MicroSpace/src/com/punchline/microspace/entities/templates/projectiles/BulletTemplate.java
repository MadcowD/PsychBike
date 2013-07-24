/**
 * 
 */
package com.punchline.microspace.entities.templates.projectiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.punchline.javalib.entities.ComponentManager;
import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.EntityTemplate;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.javalib.entities.components.Bullet;
import com.punchline.javalib.entities.components.Health;
import com.punchline.javalib.entities.components.physical.Collidable;
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
		

		//Bullet
		Bullet b = e.addComponent(new Bullet(firer, damage));
		
		//OnCollide
		Collidable col = e.addComponent(Collidable.class,
				new Collidable(){
					@Override
					public void onAdd(ComponentManager container) {
					}

					@Override
					public void onRemove(ComponentManager container) {	
					}

					@Override
					public float onCollide(Entity container, Entity victim) {
						Bullet b = container.getComponent();
						
						//If the bullet hits the firer, continue firing the bullet.
						if(victim == b.getFirer()) 
							return 1;
						
						else{
							//IF THE VICTIM HAS HEALTH! RAWR
							if(victim.hasComponent(Health.class))
							{
								Health h = victim.getComponent();
								h.setHealth(h.getHealth()-b.getDamage());
							}
							
							container.delete();
							//TERMINATE THE RAY CAST
							return 0;
						}
					}
			
		});
		
		
		
		//Sprite TODO: Write sprite code!
		Sprite s;
		if(type.equalsIgnoreCase("blue")){
			
		}
		else if(type.equalsIgnoreCase("red")){
			
		}
		
		return e;
	}

}
