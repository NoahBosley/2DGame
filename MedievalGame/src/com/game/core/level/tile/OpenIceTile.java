package com.game.core.level.tile;

import com.game.render.Screen;
import com.game.render.Sprite;

public class OpenIceTile extends Tile {

	public OpenIceTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

}
