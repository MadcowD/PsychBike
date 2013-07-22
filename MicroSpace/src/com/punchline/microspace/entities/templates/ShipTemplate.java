package com.punchline.microspace.entities.templates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.EntityTemplate;
import com.punchline.javalib.entities.EntityWorld;
import com.punchline.javalib.entities.components.BaseTransform;
import com.punchline.javalib.entities.components.Body;
import com.punchline.javalib.entities.components.render.Animation;
import com.punchline.javalib.entities.components.render.Renderable;
import com.punchline.javalib.entities.components.render.Sprite;

public class ShipTemplate implements EntityTemplate {

	@Override
	public Entity buildEntity(EntityWorld world, Object... args) {
		Entity e = new Entity("", "Ships", "Ship");
		
		Renderable r = new Animation(new Texture(Gdx.files.internal("data/test.png")), 4, 1, 0.5f);
		e.addComponent(Renderable.class, r);
		
		BodyDef def = new BodyDef();
		def.type = BodyType.DynamicBody;
		def.position.set(new Vector2(20, 75));
		
		CircleShape circle = new CircleShape();
		circle.setRadius(6f);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;
		fixtureDef.density = 0.5f;
		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0.6f;
		
		e.addComponent(BaseTransform.class, new Body(world, e, def, fixtureDef));
		
		return e;
	}

}
