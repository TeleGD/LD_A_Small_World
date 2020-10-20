package games.aSmallWorld.character;

import java.util.ArrayList;

import org.newdawn.slick.Image;

public abstract class Entity {
	protected ArrayList<Image> imgBattle;
	private int attack,defence,speed,power;
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

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
