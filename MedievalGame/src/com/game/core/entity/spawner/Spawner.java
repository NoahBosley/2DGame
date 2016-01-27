package com.game.core.entity.spawner;

import com.game.core.entity.Entity;
import com.game.core.entity.particle.Particle;
import com.game.core.level.Level;

public class Spawner extends Entity {
	
	public enum Type {
		MOB, PARTICLE
	}
	
	private Type type;
	
	public Spawner(int x, int y, Type type, int amount, Level level) {
		init(level);
		this.x = x;
		this.y = y;
		this.type = type;
		for (int i = 0; i < amount; i++) {
			if (type == Type.PARTICLE) {
				level.add(new Particle(x, y, 50));
			}
		}
	}
	
}
