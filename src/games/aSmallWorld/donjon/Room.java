package games.aSmallWorld.donjon;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Room {


	//Variables
	private int height;
	private int width;//length et width correspondent au nombre de cases de longueur et de largeur.
	private int entry;//correspond aux nombres de tunnels d�bouchant sur la salle
	private int sizeMin;//borne sur la taille minimale de la salle
	private int lwMin; //borne sur la taille minimale de la longueur et de la largeur.


	//Constructeur
	public Room(int l, int w, int e){
		sizeMin=6;
		lwMin=2;
		this.height=l;
		this.width=w;
		this.entry=e;
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
	public int getEntry() {
		return entry;
	}
	public void setEntry(int entry) {
		this.entry = entry;
	}


	//render et update
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
	}
}
