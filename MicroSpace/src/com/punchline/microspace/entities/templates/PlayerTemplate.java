package com.punchline.microspace.entities.templates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.Entity.EntityEventCallback;
import com.punchline.javalib.entities.EntityTemplate;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.javalib.entities.GenericCollisionEvents;
import com.punchline.javalib.entities.components.generic.Health;
import com.punchline.javalib.entities.components.physical.Body;
import com.punchline.javalib.entities.components.physical.Collidable;
import com.punchline.javalib.entities.components.render.Renderable;
import com.punchline.javalib.entities.components.render.Sprite;
import com.punchline.microspace.entities.GenericHealth;

public class PlayerTemplate implements EntityTemplate {

	private static final float BODY_RADIUS = 8f;
	private static final float PLAYER_POS_X = 600f;
	
	
	private Texture shipsTexture;
	private TextureRegion leftRegion;
	private TextureRegion rightRegion;
	
	public PlayerTemplate() {
		shipsTexture = new Texture(Gdx.files.internal("data/Textures/playerships.png"));
		
		leftRegion = new TextureRegion(shipsTexture, 0, 0, 16, 16);
		rightRegion = new TextureRegion(shipsTexture, 16, 0, 16, 16);
	}
	
	@Override
	public Entity buildEntity(Entity e, EntityWorld world, Object... args) {
		String group = (String)args[0];
		
		String tag = group.equals("leftTeam") ? "Player" : "";
		
		e.init(tag, group, "Player");
		
		Vector2 pos = new Vector2();
		Sprite s = new Sprite();
		
		BodyDef bd = new BodyDef();
		bd.type = BodyType.DynamicBody;
		
		CircleShape circle = new CircleShape();
		circle.setRadius(BODY_RADIUS);
		
		FixtureDef fd = new FixtureDef();
		fd.shape = circle;
		
		if (group.equals("leftTeam")) {
			pos.x = -PLAYER_POS_X;
			s = new Sprite(shipsTexture, leftRegion);
		} else if (group.equals("rightTeam")) {
			pos.x = PLAYER_POS_X;
			s = new Sprite(shipsTexture, rightRegion);
			bd.angle = (float)Math.PI;
		}
		
		bd.position.set(pos);
		
		Body b  = new Body(world, e, bd, fd);
		
		e.addComponent(Renderable.class, s);
		e.addComponent(b);
		
		Health h = new GenericHealth(e, world, 10f);
		
		e.addComponent(Health.class, h);
		e.addComponent(Collidable.class, GenericCollisionEvents.damageVictim());
		
		e.OnDelete = new EntityEventCallback(){
			EntityWorld world;
			public EntityEventCallback init(EntityWorld world){
				this.world = world;
				return this;
			}
			
			@Override
			public void invoke(Entity e) {
				world.createEntity("Player", e.getGroup());
			}
		}.init(world);
		
		return e;
	}

}
