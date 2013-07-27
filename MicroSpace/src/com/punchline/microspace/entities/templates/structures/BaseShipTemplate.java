/**
 * 
 */
package com.punchline.microspace.entities.templates.structures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.EntityTemplate;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.javalib.entities.components.generic.EntitySpawner;
import com.punchline.javalib.entities.components.generic.Health;
import com.punchline.javalib.entities.components.generic.Health.HealthEventCallback;
import com.punchline.javalib.entities.components.physical.Body;
import com.punchline.javalib.entities.components.render.Renderable;
import com.punchline.javalib.entities.components.render.Sprite;
import com.punchline.javalib.utils.BodyEditorLoader;
import com.punchline.javalib.utils.SoundManager;
import com.punchline.microspace.MicroGameOverInfo;
import com.punchline.microspace.entities.GenericHealth;

/**
 * @author William
 * @created Jul 26, 2013
 */
public class BaseShipTemplate implements EntityTemplate {
	
	private static final int HEALTH = 30;
	private static final float HORIZONTAL_OFFSET = 50f;
	
	private Texture shipTexture;
	private TextureRegion shipRegion;
	/**
	 * Builds the base ship template
	 */
	public BaseShipTemplate() {
		shipTexture = new Texture(Gdx.files.internal("data/Textures/structures/baseShip.png"));
		shipRegion = new TextureRegion(shipTexture, 0,0, 120, 127);
	}

	/** {@inheritDoc}
	 * @see com.punchline.javalib.entities.EntityTemplate#buildEntity(com.punchline.javalib.entities.Entity, com.punchline.javalib.entities.EntityWorld, java.lang.Object[])
	 */
	@Override
	public Entity buildEntity(Entity e, EntityWorld world, Object... args) {
		final String group = (String)args[0];
		e.init("", group, "Base"); //Builds the base ship with a team. (args[0])
		
		Vector2 position = (Vector2)args[1];
		
		
		//BODY
		BodyEditorLoader bloader = new BodyEditorLoader(Gdx.files.internal("data/Physics/physicsproj.json"));
		
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.StaticBody;
		bodyDef.position.set(position);
		
		FixtureDef fd = new FixtureDef();
		fd.density = 1;
		fd.friction = 0.5f;
		fd.restitution = 0f;
		
		Body b = e.addComponent(new Body(world, e, bodyDef));
		bloader.attachFixture(b.getBody(), "baseShip", fd, 120f);
		
		//SPRITE
		Sprite s = e.addComponent(Renderable.class, new Sprite(shipTexture, shipRegion));
		s.setOrigin(bloader.getOrigin("baseShip", 120f));
		
		
		//HEALTH
		
		Health health = new GenericHealth(e, world, HEALTH);
		health.render = true;
		health.onDeath = new HealthEventCallback() {

			@Override
			public void invoke(Entity owner, EntityWorld world) {
				SoundManager.playSound("explosion");
				
				//TODO make badass explosion
				
				String winningTeam = group.equals("leftTeam") ? "rightTeam" : "leftTeam";
				
				world.setGameOverInfo(new MicroGameOverInfo(winningTeam));
			}
			
		};
		
		e.addComponent(Health.class, health);

		e.addComponent(new EntitySpawner("Mook", false, 5, e.getGroup(), b.getPosition().cpy().add(new Vector2(offset, 0))));
		
		
		return e;
	}

}
