package com.game.core.entity;

import java.util.Random;

import com.game.core.level.Level;
import com.game.render.Screen;

public abstract class Entity {

	public int x, y;
	public boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public void init(Level level) {
		this.level = level;
	}
	
}
