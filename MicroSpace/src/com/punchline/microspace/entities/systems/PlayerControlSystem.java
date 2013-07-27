package com.punchline.microspace.entities.systems;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
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
	private boolean shootingLeft = false;
	private boolean shootingRight = false;
	private boolean shootingUp = false;
	private boolean shootingDown = false;
	
	public PlayerControlSystem(InputMultiplexer input) {
		super(input);
	}

	@Override
	public boolean canProcess(Entity e) {
		return e.getType().equals("Player");
	}

	@Override
	protected void process(Entity e) {
		super.process(e);
	
		Body b = e.getComponent();
		
		
		elapsedShot += deltaSeconds();
		
		if (elapsedShot >= SHOT_DELAY) {	
			Vector2 velocity = new Vector2();
			
			if (shootingLeft) {
				velocity.x = -1f;
			} else if (shootingRight) {
				velocity.x = 1f;
			}
			
			if (shootingUp) {
				velocity.y = 1f;
			} else if (shootingDown) {
				velocity.y = -1f;
			}
			
			if (!velocity.equals(new Vector2())) {
				velocity.nor();
				velocity.scl(BULLET_SPEED);
				
				world.createEntity("Bullet", "red", b.getPosition(), velocity, e, BULLET_DAMAGE);
				elapsedShot = 0f;
			}
		}
		
		Vector2 velocity = new Vector2();
		
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
		
		if (keycode == Keys.LEFT) {
			shootingLeft = true;
			return true;
		}
		
		if (keycode == Keys.RIGHT) {
			shootingRight = true;
			return true;
		}
		
		if (keycode == Keys.UP) {
			shootingUp = true;
			return true;
		}
		
		if (keycode == Keys.DOWN) {
			shootingDown = true;
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
		
		if (keycode == Keys.LEFT) {
			shootingLeft = false;
			return true;
		}
		
		if (keycode == Keys.RIGHT) {
			shootingRight = false;
			return true;
		}
		
		if (keycode == Keys.UP) {
			shootingUp = false;
			return true;
		}
		
		if (keycode == Keys.DOWN) {
			shootingDown = false;
			return true;
		}
		
		return false;
	}

}
