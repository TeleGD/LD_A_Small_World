package character.player;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import battle.Battle;
import battle.Brawler;
import character.enemies.BattleEnemy;
import world.World;

public class BattlePlayer implements Brawler{

	long temp;// used t change the image
	private int life;
	private int attack,defence,speed,power;
	private ArrayList<Image> img;
	private Image imgT0,imgT1;
	float x,y;
	private int action;//0:attack  1:defend   2:power  3:flee  4:none
	private int done;//0: joueur pas arrive a distance  1:joueur a pas tape  2:joueur pas rentre
	private int maxPV;
	private int PV;
	private BattleEnemy target;
	private int XPwon;
	private int defAct;//Pour savoir si on est en mode defense


	public BattlePlayer(GameContainer arg0,Player p){
		img=World.getPlayer().getImgBattle();
		x=arg0.getWidth()/4-img.get(0).getWidth()/2;
		y=arg0.getHeight()/2-img.get(0).getHeight()/2;
		imgT0=img.get(0);
		action=4;
		attack=p.getAttack();
		defence=p.getDefence();
		speed=p.getSpeed();
		power=p.getPower();
		XPwon=0;
		maxPV=100;
		PV=47;defAct=1;
	}




	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2){
		arg2.drawImage(imgT0,x, y);
		arg2.setColor(Color.red);
		arg2.fillRect(arg0.getWidth()/4-img.get(0).getWidth()/2, arg0.getHeight()/2+10+img.get(0).getHeight()/2, 100, 10);
		arg2.setColor(Color.green);
		arg2.fillRect(arg0.getWidth()/4-img.get(0).getWidth()/2, arg0.getHeight()/2+10+img.get(0).getHeight()/2,100*PV/maxPV, 10);
		arg2.setColor(Color.black);
		if(defAct==2)
			arg2.drawString("en mode defense", 300, 600);
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2){
		System.out.println(action);
		switch(action){
		case 0:
			if(done==0)
				going(arg2);
			else if(done==2)
				returning(arg2);
			else if(done==1){
				System.out.println("animation de coup");
				target.looseHP((10*attack/target.getDefence())/target.getDef());
				done=2;
			}
			break;
		case 1:
			defAct=2;
			done=-1;
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
		if(x<main.Main.longueur*3/4-40){
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
			done=1;
		}
	}

	public void returning(int delta){
		if(x>main.Main.longueur/4-img.get(0).getWidth()/2){
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
			done=-1;
		}
	}


	public void setTemp(){
		temp=System.currentTimeMillis();
		imgT1=img.get(1);
	}

	public void setAction(int k){
		defAct=1;
		action=k;
		System.out.println("action mise: "+k);
	}

	public void setUndone(){
		done=0;
	}




	public BattleEnemy getTarget() {
		return target;
	}




	public void setTarget(BattleEnemy target) {
		this.target = target;
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


	public int getDef(){
		return defAct;
	}

	public void gainXP(int exp) {
		this.XPwon+=exp;
	}
}

