package character.enemies;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import world.World;

public class BattleEnemy {
	
	private int life;
	private int attack,defence,speed,power;
	private ArrayList<Image> img;
	private boolean animation;
	
	public void init(){
		img=World.getPlayer().getImgBattle();
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2){
		if(!animation)
			arg2.drawImage(img.get(0),arg0.getWidth()/4-img.get(0).getWidth()/2, arg0.getHeight()/2-img.get(0).getHeight()/2);
		
		
	}
	
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2){
		
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
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
