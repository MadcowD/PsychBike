package com.punchline.microspace.entities.systems;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.components.physical.Body;
import com.punchline.javalib.entities.systems.InputSystem;

public class PlayerControlSystem extends InputSystem {

	private static final float SHOT_DELAY = 0.25f;
	private static final float PLAYER_SPEED = 70f;
	private static final float BULLET_SPEED = 200f;
	private static final float BULLET_DAMAGE = 1f;
	
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean movingUp = false;
	private boolean movingDown = false;
	
	private float elapsedShot = 0f;
	private Vector2 aim;
	
	public PlayerControlSystem(InputMultiplexer input) {
		super(input);
		aim = new Vector2();
	}

	@Override
	public boolean canProcess(Entity e) {
		return e.getType().equals("Player");
	}

	@Override
	protected void process(Entity e) {
		super.process(e);
	
		Body b = e.getComponent();
		
		Vector2 velocity = new Vector2();
		
		aim.x = Gdx.input.getX() -Gdx.graphics.getWidth()/2f + world.getCamera().position.x;
		aim.y= -Gdx.input.getY() +Gdx.graphics.getHeight()/2f + world.getCamera().position.y;
		
		Vector2 fireL = aim.cpy().sub(b.getPosition());
		
		if (movingLeft) {
			velocity.x = -1f;
		} else if (movingRight) {
			velocity.x = 1f;
		}
		
		if (movingUp) {
			velocity.y = 1f;
		} else if (movingDown) {
			velocity.y = -1f;
		} 
		
		velocity.nor();
		velocity.scl(PLAYER_SPEED);
		
		b.setLinearVelocity(velocity);
		
		if (!velocity.equals(Vector2.Zero))
			b.setRotation((float)Math.toRadians(velocity.angle()));
		else
			b.setRotation((float)Math.toRadians(fireL.angle()));
		
		elapsedShot += deltaSeconds();
		if(Gdx.input.isTouched()){
			b.setRotation((float)Math.toRadians(fireL.angle()));
			if (elapsedShot >= SHOT_DELAY) {	
				b.setRotation((float)Math.toRadians(fireL.angle()));
				fireL.angle();
				
				if (!fireL.equals(new Vector2())) {
					fireL.nor();
					fireL.scl(BULLET_SPEED);
					
					world.createEntity("Bullet", "red", b.getPosition(), fireL, e, BULLET_DAMAGE);
					elapsedShot = 0f;
				}
			}
		}
		
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.A) {
			movingLeft = true;
			return true;
		}
		
		if (keycode == Keys.W){
			movingUp = true;
			return true;
		}
		
		if (keycode == Keys.D){
			movingRight = true;
			return true;
		}
		
		if (keycode == Keys.S){
			movingDown = true;
			return true;
		}
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.A) {
			movingLeft = false;
			return true;
		}
		
		if (keycode == Keys.W){
			movingUp = false;
			return true;
		}
		
		if (keycode == Keys.D){
			movingRight = false;
			return true;
		}
		
		if (keycode == Keys.S){
			movingDown = false;
			return true;
		}
		
		return false;
	}
}
