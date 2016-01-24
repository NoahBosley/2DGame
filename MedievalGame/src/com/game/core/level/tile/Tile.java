package com.game.core.level.tile;

import com.game.render.Screen;
import com.game.render.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile ice = new IceTile(Sprite.ice);
	public static Tile crackedIce = new CrackedIceTile(Sprite.crackedIce);
	public static Tile openIce = new OpenIceTile(Sprite.openIce);
	public static Tile iceFloor = new IceFloorTile(Sprite.iceFloor);
	public static Tile iceWall = new IceWallTile(Sprite.iceWall);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static final int ICE = 0xFF00A5FF;
	public static final int CRACKED_ICE = 0xFF00FFFF;
	public static final int OPEN_ICE = 0xFF96FFFF;
	public static final int ICE_FLOOR = 0xFF619FA0;
	public static final int ICE_WALL = 0xFF8BE4E5;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
	}
	
	public boolean isSolid() {
		return false;
	}
	
}
