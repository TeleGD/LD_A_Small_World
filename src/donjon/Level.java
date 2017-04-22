package donjon;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import world.World;

public class Level{
	
	
	//Variables
	private int id;
	private int height;
	private int width;//length et width correspondent au nombre de cases de hauteur et de largeur.
	private int rooms;
	public Cell grid[][];
	
	
	//Constructeur
	public Level(int id, int h, int w, int r) throws SlickException{
		this.id=id;
		this.height=h;
		this.width=w; 
		this.rooms=r;
		this.grid=initLevel(h,w);
	}
	
	
	//Permet de créer une matrice de Cell
	private Cell[][] initLevel(int h, int w) throws SlickException{
		Cell level[][] = new Cell[h][w];
		for(int i = 0; i<h; i++)//init row
			for(int j=0;j<w;j++) //init column
				level[i][j] = new Cell(i,j);
		return level;
	}
	
	
	//Getters et Setters
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	
	
	//render et update
	public static void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		Level a=new Level(1, 1, 7, 2);
		for(int i = 0; i<a.grid.length; i++){//init ligne
			for(int j=0;j<a.grid[i].length;j++){ //init colonne
				a.grid[i][j].getSprite().draw(j*100,i*100,100,100);
			}
		}
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
	}
}
