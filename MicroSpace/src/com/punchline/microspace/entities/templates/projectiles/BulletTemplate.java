/**
 * 
 */
package com.punchline.microspace.entities.templates.projectiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.punchline.javalib.entities.ComponentManager;
import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.EntityTemplate;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.javalib.entities.components.generic.Bullet;
import com.punchline.javalib.entities.components.generic.Health;
import com.punchline.javalib.entities.components.physical.Collidable;
import com.punchline.javalib.entities.components.physical.Particle;
import com.punchline.javalib.entities.components.render.Renderable;
import com.punchline.javalib.entities.components.render.Sprite;
import com.punchline.javalib.utils.Convert;

/**
 * @author William
 * @created Jul 23, 2013
 */
public class BulletTemplate implements EntityTemplate {
	private Texture bulletTex;
	private TextureRegion[] bulletRect;
	
	/**
	 * Constructs the bullet template for use with bullets.
	 */
	public BulletTemplate(){
		bulletTex = new Texture(Gdx.files.internal("data/Textures/bulletSprites.png"));
		bulletRect = new TextureRegion[]{
			new TextureRegion(bulletTex, 0, -1, 2, 1), //Blue
			new TextureRegion(bulletTex, 0, -2, 2, 1), //Red
			new TextureRegion(bulletTex, 2, -2, 2, 1), //Yellow
			new TextureRegion(bulletTex, 2, -1, 2, 1), //Purple
			new TextureRegion(bulletTex, 0, 2, 4, 2)  //Big
		};
	}
	
	
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
							h.drain(b.getDamage());
						}
						
						container.delete();
						//TERMINATE THE RAY CAST
						return 0;
					}
				}
			});
		
		
		
		//Sprite TODO: Consider sprite pooling.
		if(type.equalsIgnoreCase("blue"))
			e.addComponent(Renderable.class, new Sprite(bulletTex, bulletRect[0]));
		else if(type.equalsIgnoreCase("red"))
			e.addComponent(Renderable.class, new Sprite(bulletTex, bulletRect[1]));
		else if(type.equalsIgnoreCase("yellow"))
			e.addComponent(Renderable.class, new Sprite(bulletTex, bulletRect[2]));
		else if(type.equalsIgnoreCase("purple"))
			e.addComponent(Renderable.class, new Sprite(bulletTex, bulletRect[3]));
		else if(type.equalsIgnoreCase("big"))
			e.addComponent(Renderable.class, new Sprite(bulletTex, bulletRect[4]));
		
		return e;
	}

}
