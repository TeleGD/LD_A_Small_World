package games.aSmallWorld.donjon;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Cell {


	//Variables
	private int x;
	private int y;
	private Image sprite;
	private int cellType;

	//Constructeur
	public Cell(int x, int y) throws SlickException{
		this.x=x;
		this.y=y;
		this.sprite=new Image("images/aSmallWorld/Corridor/noWalls.png");
		this.setCellType(0);
	}


	//Getters et Setters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Image getSprite() {
		return sprite;
	}
	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}


	//render et update
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		//Affichage
		arg2.drawImage(sprite,0,0);
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
	}


	public int getCellType() {
		return cellType;
	}


	public void setCellType(int cellType) {
		this.cellType = cellType;
	}
}
