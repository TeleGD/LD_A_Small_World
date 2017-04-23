package character.player;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import character.Entity;

public class Player extends Entity{

	
	private ArrayList<Image> imgBattle;
	private int attack,defence,speed,power;
	
	public Player(){
		imgBattle=new ArrayList<Image>();
		try {
			imgBattle.add(new Image("img/Char_Battle/ennemy1droitestop.png").getScaledCopy(2));
			imgBattle.add(new Image("img/Char_Battle/ennemy1droitePD.png").getScaledCopy(2));
			imgBattle.add(new Image("img/Char_Battle/ennemy1droitePG.png").getScaledCopy(2));
			imgBattle.add(new Image("img/Char_Battle/ennemy1gauchestop.png").getScaledCopy(2));
			imgBattle.add(new Image("img/Char_Battle/ennemy1gauchePD.png").getScaledCopy(2));
			imgBattle.add(new Image("img/Char_Battle/ennemy1gauchePG.png").getScaledCopy(2));
		} catch (SlickException e) {
			System.out.println("Player images couldn't be loaded");
		}
		attack=10;
		defence=10;
		speed=10;
		power=5;
	}
	
	
	public ArrayList<Image> getImgBattle() {
		return imgBattle;
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
