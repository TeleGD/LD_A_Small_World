package character.enemies;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import battle.Battle;
import battle.Brawler;


public class BattleEnemy implements Brawler{
	
	long temp;// used t change the image
	private int life;
	private int attack,defence,speed,power;
	private ArrayList<Image> img;
	private Image imgT0,imgT1;
	float x,y;
	private int action;//0:attack  1:defend   2:power  3:flee  4:none
	private int done;
	private int maxPV=40;
	private int PV=35;
	
	public BattleEnemy(GameContainer arg0,float y){
		img=new ArrayList<Image>();
		try {
			img.add(new Image("img/Char_Battle/6.png").getScaledCopy(2));
			img.add(new Image("img/Char_Battle/5.png").getScaledCopy(2));
			img.add(new Image("img/Char_Battle/4.png").getScaledCopy(2));
			img.add(new Image("img/Char_Battle/3.png").getScaledCopy(2));
			img.add(new Image("img/Char_Battle/1.png").getScaledCopy(2));
			img.add(new Image("img/Char_Battle/2.png").getScaledCopy(2));
		} catch (SlickException e) {
			System.out.println("Player images couldn't be loaded");
		}
		imgT0=img.get(3);
		imgT1=img.get(4);
		x=arg0.getWidth()*3/4+img.get(0).getWidth()/2;
		this.y=y;
		done=0;
		action=0;
		attack=5;
		defence=5;
		speed=7;
		power=0;
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2){
		arg2.drawImage(imgT0,x, y);
		arg2.setColor(Color.red);
		arg2.fillRect(arg0.getWidth()*3/4+img.get(0).getWidth()/2, y+imgT0.getHeight()+10, 100, 10);
		arg2.setColor(Color.green);
		arg2.fillRect(arg0.getWidth()*3/4+img.get(0).getWidth()/2, y+imgT0.getHeight()+10,100*PV/maxPV, 10);
	}
	
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2){
		System.out.println("est bien appelé");
		System.out.println("action = "+action);
		switch(action){
		case 0:
			if(done==0)
				going(arg2);
			else if(done==2)
				returning(arg2);
			else if(done==1){
				System.out.println("animation ennemie");
				Battle.getPlayer().looseHP(10*attack/Battle.getPlayer().getDefence());
				done=2;
			}
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
	
	
	public void going(int delta){
		if(x>main.Main.longueur/4+40){
			x-=0.2*delta;
			if(System.currentTimeMillis()-temp>150){
				if((imgT0.equals(img.get(4)))||(imgT0.equals(img.get(5)))){
					imgT1=imgT0;
					imgT0=img.get(3);
				}else{
					if(imgT1.equals(img.get(4)))
						imgT0=img.get(5);
					else
						imgT0=img.get(4);
				}
				temp=System.currentTimeMillis();
			}
		}else {
			imgT1=imgT0;
			imgT0=img.get(0);
			done=1;
		}
	}
	
	public void returning(int delta){
		if(x<main.Main.longueur*3/4+img.get(0).getWidth()/2){
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
			imgT0=img.get(3);
			done=-1;
		}
	}
	
	public void keyPressed(int key, char c) {
		if(key==Input.KEY_SPACE)
			action=0;
	}

	public void setAction(int i) {
		action=i;
	}
	
	public void looseHP(int i){
		PV-=i;
		if (PV<0)
			PV=0;
	}
	
	public int getDone(){
		return done;
	}

	public void setDone(int i) {
		done=i;
	}
}
