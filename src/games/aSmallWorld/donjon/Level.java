package games.aSmallWorld.donjon;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Level{


	//Variables
	private int id;
	public int height;
	public int width;//length et width correspondent au nombre de cases de hauteur et de largeur.
	public ArrayList<Room> rooms;
	public Cell grid[][];


	//Constructeur
	public Level(int id, int h, int w) throws SlickException{
		this.setId(id);
		this.height=h;
		this.width=w;
		this.grid=initLevel(h,w);
		this.rooms=roomGenerator(h,w,60);
	}


	//Permet de créer une matrice de Cell
	private Cell[][] initLevel(int h, int w) throws SlickException{
		Cell level[][] = new Cell[h][w];
		for(int i = 0; i<h; i++)//init row
			for(int j=0;j<w;j++) //init column
				level[i][j] = new Cell(i,j);
		return level;
	}


	//Permet de générer les salles avec une surface inférieure ou égale à une partie de la surface du niveau
	private ArrayList<Room> roomGenerator(int h,int w, int percent){
		int levelArea=Math.round(h*w*percent/100);	//nombres de cases du niveau occupables par des salles
		int roomArea=0; //compteur de cases occupées par des salles
		ArrayList<Room> rooms=new ArrayList<Room>();

		while(levelArea-9>roomArea){
			Random rand = new Random();
			int roomH = rand.nextInt(h - 3 + 1) + 3;
			int roomW= rand.nextInt(w-3+1)+3;

		}

		return rooms;
	}


	//Getters et Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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



	//render et update
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		for(int i = 0; i<grid.length; i++){//init ligne
			for(int j=0;j<grid[i].length;j++){ //init colonne
				grid[i][j].getSprite().draw(j*50,i*50,50,50);
			}
		}
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
	}



}
