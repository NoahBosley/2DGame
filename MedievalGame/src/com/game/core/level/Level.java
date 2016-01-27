package com.game.core.level;

import java.util.ArrayList;
import java.util.List;

import com.game.core.entity.Entity;
import com.game.core.entity.particle.Particle;
import com.game.core.entity.projectile.Projectile;
import com.game.core.entity.spawner.Spawner;
import com.game.core.level.tile.Tile;
import com.game.render.Screen;

public class Level {
	
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private List<Particle> particles = new ArrayList<Particle>();
	
	public static Level spawnLevel = new SpawnLevel("start_level.png");
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}
	
	protected void generateLevel() {	
	}

	protected void loadLevel(String path) {
	}
	
	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).update();
		}
	}
	
	public List<Projectile> getProjectiles() {
		return projectiles;
	}
	
	private void time() {
	}
	
	public boolean tileCollision(double x, double y, double xa, double ya, int size) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			double xt = (((int) x + (int) xa) + c % 2 * size / 2 - 5) / 16;
			double yt = (((int) y + (int) ya) + c / 2 * size / 2 + 5) / 16;
			if (getTile((int) xt, (int) yt).isSolid()) solid = true;
		}
		return solid;
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).render(screen);
		}
	}
	
	public void add(Entity e) {
		e.init(this);
		if (e instanceof Particle)  {			
			particles.add((Particle) e);
		} else if (e instanceof Projectile) {
			projectiles.add((Projectile) e);			
		} else {
			entities.add(e); 
		}
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if(tiles[x + y * width] == Tile.ICE) return Tile.ice;
		if(tiles[x + y * width] == Tile.OPEN_ICE) return Tile.openIce;
		if(tiles[x + y * width] == Tile.CRACKED_ICE) return Tile.crackedIce;
		if(tiles[x + y * width] == Tile.ICE_FLOOR) return Tile.iceFloor;
		if(tiles[x + y * width] == Tile.ICE_WALL) return Tile.iceWall;
		return Tile.voidTile;
	}
	
}
