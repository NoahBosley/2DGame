package com.game.core.level.tile;

import com.game.render.Screen;
import com.game.render.Sprite;

public class IceFloorTile extends Tile {

	public IceFloorTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

}
