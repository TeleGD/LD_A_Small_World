package character;

import java.util.ArrayList;

import org.newdawn.slick.Image;

public abstract class Entity {
	protected ArrayList<Image> imgBattle;
	protected int attack,defence,speed,power;
	protected float x,y;
	
	public ArrayList<Image> getImgBattle() {
		return imgBattle;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
}
