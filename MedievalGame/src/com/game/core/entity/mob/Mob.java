package com.game.core.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.game.core.entity.Entity;
import com.game.core.entity.projectile.Projectile;
import com.game.core.entity.projectile.WizardProjectile;
import com.game.render.Screen;
import com.game.render.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int direction = 0;
	protected boolean moving = false;
	
	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		
		if (xa > 0) direction = 1;
		if (xa < 0) direction = 3;
		if (ya > 0) direction = 2;
		if (ya < 0) direction = 0;
		
		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}
	
	public void update() {
	}
	
	protected void shoot(int x, int y, double dir) {
		Projectile p = new WizardProjectile(x, y, dir);
		level.addProjectile(p);
	}
	
	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 14 - 8) >> 4;
			int yt = ((y + ya) + c / 2 * 12 - 3) >> 4;
			if (level.getTile(xt, yt).isSolid()) solid = true;
		}
		return solid;
	}
	
	public void render(Screen screen) {
	}
	
}
