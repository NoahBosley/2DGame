package com.game.render;


public class Sprite {

	public final int SIZE;
	private int width, height;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	/** ORIGINAL SPRITES **/
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.evironmentSheet);
	
	/** ICE SPRITES **/
	public static Sprite ice = new Sprite(16, 0, 1, SpriteSheet.evironmentSheet);
	public static Sprite crackedIce = new Sprite(16, 1, 1, SpriteSheet.evironmentSheet);
	public static Sprite openIce = new Sprite(16, 2, 1, SpriteSheet.evironmentSheet);
	public static Sprite iceFloor = new Sprite(16, 4, 1, SpriteSheet.evironmentSheet);
	public static Sprite iceWall = new Sprite(16, 5, 1, SpriteSheet.evironmentSheet);
			
	public static Sprite voidSprite = new Sprite(16, 0x1B87E0);
	
	/** PROJECTILE SPRITES **/
	public static Sprite darkMagic = new Sprite(16, 0, 0, SpriteSheet.wizardProjectileSheet);
	
	/** PLAYER SPRITES **/
	public static Sprite player_forward = new Sprite(32, 0, 5, SpriteSheet.evironmentSheet);
	public static Sprite player_back = new Sprite(32, 2, 5, SpriteSheet.evironmentSheet);
	public static Sprite player_side = new Sprite(32, 1, 5, SpriteSheet.evironmentSheet);
	
	public static Sprite player_forward_1 = new Sprite(32, 0, 6, SpriteSheet.evironmentSheet);
	public static Sprite player_forward_2 = new Sprite(32, 0, 7, SpriteSheet.evironmentSheet);

	public static Sprite player_side_1 = new Sprite(32, 1, 6, SpriteSheet.evironmentSheet);
	public static Sprite player_side_2 = new Sprite(32, 1, 7, SpriteSheet.evironmentSheet);
	
	public static Sprite player_back_1 = new Sprite(32, 2, 6, SpriteSheet.evironmentSheet);
	public static Sprite player_back_2 = new Sprite(32, 2, 7, SpriteSheet.evironmentSheet);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int width, int height, int color) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColor(color);
	}
	
	public Sprite(int size, int color) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	private void setColor(int color) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = color;
		}
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
	
}
