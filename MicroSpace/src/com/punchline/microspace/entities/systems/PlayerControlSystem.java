package com.punchline.microspace.entities.systems;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.math.Vector2;
import com.punchline.javalib.entities.Entity;
import com.punchline.javalib.entities.components.physical.Body;
import com.punchline.javalib.entities.systems.InputSystem;

public class PlayerControlSystem extends InputSystem {

	private static final float SHOT_DELAY = 0.25f;
	private static final float PLAYER_SPEED = 70f;
	
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean movingUp = false;
	private boolean movingDown = false;
	
	private boolean shooting = false;
	
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

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return super.touchDown(screenX, screenY, pointer, button);
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return super.touchUp(screenX, screenY, pointer, button);
	}
	
	

}
