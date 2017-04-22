package character.player;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import world.World;

public class BattlePlayer{

	long temp;// used t change the image
	private int life;
	private int attack,defence,speed,power;
	private ArrayList<Image> img;
	private Image imgT0,imgT1;
	float x,y;
	public static enum Action {none,attack,defend,power,flee}
	private int action;//0:attack  1:defend   2:power  3:flee  4:none

	public BattlePlayer(GameContainer arg0){
		img=World.getPlayer().getImgBattle();
		System.out.println(img);
		x=arg0.getWidth()/4-img.get(0).getWidth()/2;
		y=arg0.getHeight()/2-img.get(0).getHeight()/2;
		imgT0=img.get(0);
		action=4;

	}




	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2){
		arg2.drawImage(imgT0,x, y);

	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2){
		switch(action){
		case 0:
			simpleAttack(arg2);
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
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

	public void simpleAttack(int delta){
		if(x<main.Main.longueur*3/4){
			x+=0.2*delta;
			if(System.currentTimeMillis()-temp>150){
				if((imgT0.equals(img.get(1)))||(imgT0.equals(img.get(2)))){
					imgT1=imgT0;
					imgT0=img.get(0);
				}else{
					if(imgT1.equals(img.get(1)))
						imgT0=img.get(2);
					else
						imgT0=img.get(1);
				}
				temp=System.currentTimeMillis();
			}
		}else {
			imgT1=imgT0;
			imgT0=img.get(0);
		}
	}


	public void setTemp(){
		temp=System.currentTimeMillis();
		imgT1=img.get(1);
	}

	public void setAction(int k){
		action=k;
	}
}
