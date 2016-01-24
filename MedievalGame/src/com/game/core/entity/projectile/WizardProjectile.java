package com.game.core.entity.projectile;

import com.game.render.Screen;
import com.game.render.Sprite;

public class WizardProjectile extends Projectile {

	public static final int FIRE_RATE = 12;
	
	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);

		range = random.nextInt(100) + 50;
		speed = 4;
		damage = 20;
		sprite = Sprite.darkMagic;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	public void update() {
		if (level.tileCollision(x, y, nx, ny, 7)) remove();
		move();
	}
	
	protected void move() {
		x += nx;
		y += ny;
		if (distance() > range) remove();
	}
	
	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return dist;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x - 10, (int) y + 2, this);
	}

}
