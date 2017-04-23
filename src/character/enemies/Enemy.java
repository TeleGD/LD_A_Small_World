package character.enemies;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import character.Entity;
import character.player.Player;
import donjon.Cell;
import donjon.Level;
import main.Main;
import world.World;

public class Enemy extends Entity{

	private ArrayList<Image> imgBattle;
	private int moveTimer = 75; 
	private float targetX,targetY;
	private Level level;
	private boolean fightFlag;
	private ArrayList<BattleEnemy> group; 
	
	
	public Enemy(){
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
		fightFlag = false;
	}
	
	public ArrayList<Image> getImgBattle() {
		return imgBattle;
	}

		
	
	public Enemy(Level l){
		imgBattle=new ArrayList<Image>();
		try {
			imgBattle.add(new Image("img/Char_Battle/ennemy1droitestop.png"));
			imgBattle.add(new Image("img/Char_Battle/ennemy1droitePD.png"));
			imgBattle.add(new Image("img/Char_Battle/ennemy1droitePG.png"));
			imgBattle.add(new Image("img/Char_Battle/ennemy1gauchestop.png"));
			imgBattle.add(new Image("img/Char_Battle/ennemy1gauchePD.png"));
			imgBattle.add(new Image("img/Char_Battle/ennemy1gauchePG.png"));
		} catch (SlickException e) {
			System.out.println("Enemy images couldn't be loaded");
		}
		level = l;
		fightFlag = false;
	}
	
	//Please use this one.
	public Enemy(Level l,float x, float y, BattleEnemy e1, BattleEnemy e2, BattleEnemy e3){
		imgBattle=new ArrayList<Image>();
		try {
			imgBattle.add(new Image("img/Char_Battle/ennemy1droitestop.png"));
			imgBattle.add(new Image("img/Char_Battle/ennemy1droitePD.png"));
			imgBattle.add(new Image("img/Char_Battle/ennemy1droitePG.png"));
			imgBattle.add(new Image("img/Char_Battle/ennemy1gauchestop.png"));
			imgBattle.add(new Image("img/Char_Battle/ennemy1gauchePD.png"));
			imgBattle.add(new Image("img/Char_Battle/ennemy1gauchePG.png"));
		} catch (SlickException e) {
			System.out.println("Enemy images couldn't be loaded");
		}
		level = l;
		this.x = x;
		this.y = y;
		fightFlag = false;
		group = new ArrayList<BattleEnemy>();
		group.add(e1);
		group.add(e2);
		group.add(e3);
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		arg2.setColor(Color.magenta);
		arg2.fillRect((float)x,(float) y, (float)50, (float)50);

	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		moveTimer = moveTimer - arg2;
		if(moveTimer <=0){
			moveTimer = 75;
			//this.getCell();
			move(arg2);
			if(fightFlag) arg1.enterState(2);
		}
	}

	public float distToPlayer(Player p){
		float dx,dy;
		dx = x - p.getX();
		dy = y - p.getY();
		return (float) Math.sqrt(dx*dx + dy*dy);
	}
	
	public boolean isInView(Entity p){
		//We check the cases on the line between the two entities.
		float lineY,lineX,coeff;
		//Main steps of the algorithm (note that the steps can be done in one pass.)
		
		//First step : getting the cases
			//Each case within the rectangle formed by the two entities is a candidate
			// Line equation : lineY = (y-p.getY())*lineX/(x-p.getX()) + x 
			// For each x covered by the case, we check lineY. 
		//Second step : check if they obstruct the line of sight.
			// We also have to check which sides are in the way of the LoS : if there is a wall on one of those sides, we have to return false.
		//Third step : update the nearest case and return the result.
			// If the LoS is obstructed, the nearest case is the current case in order to stay in place?
		
		if(x == p.getX()){//Vertically aligned
			if(y <= p.getY()){//Going down
				coeff = 1;
			}else coeff = -1;//Going up
			
			for(Cell[] lin : level.grid){
				for(Cell c : lin){
					if(c.getX() >= x && c.getX() <= x+64 ){
						if(coeff > 0){
							//Current case
							if(c.getY() < y && c.getY() + 64 > y){
								if(c.getCellType() == 1 ||c.getCellType() == 3||c.getCellType() == 4||c.getCellType() == 5||c.getCellType() == 6||c.getCellType() == 8||c.getCellType() == 10) return false;
							}
							// Other cases
							if(c.getY() + 64 < p.getY() && c.getY() > y){
								if((c.getCellType() >=0 && c.getCellType() <= 8)|| c.getCellType() == 10 || c.getCellType() == 13) return false;
							}
							// Last (player) case
							if(c.getY() < p.getY() && c.getY()+64 > p.getY()){
								if(c.getCellType() == 0 ||c.getCellType() == 2||c.getCellType() == 5||c.getCellType() == 6||c.getCellType() == 7||c.getCellType() == 8||c.getCellType() == 13) return false;
							}
						}else {
							// Current case
							if(c.getY() < y && c.getY() + 64 > y){
								if(c.getCellType() == 0 ||c.getCellType() == 2||c.getCellType() == 5||c.getCellType() == 6||c.getCellType() == 7||c.getCellType() == 8||c.getCellType() == 13) return false;
							}
							// Other cases
							if(c.getY() > p.getY() && c.getY() < y){
								if((c.getCellType() >=0 && c.getCellType() <= 8)|| c.getCellType() == 10 || c.getCellType() == 13) return false;
							}
							// Last (player) case
							if(c.getY() < p.getY() && c.getY()+64 > p.getY()){
								if(c.getCellType() == 1 ||c.getCellType() == 3||c.getCellType() == 4||c.getCellType() == 5||c.getCellType() == 6||c.getCellType() == 8||c.getCellType() == 10) return false;
							}
						}
					}
				}
			}
		}else{
			coeff = (y-p.getY())/(x-p.getX());
			for(Cell[] lin : level.grid){
				for(Cell c : lin){
					for(lineX = c.getX(); lineX < c.getX()+64; lineX++){
						lineY = lineX*coeff + y;
						if(lineY>=c.getY() && lineY<=c.getY()+64) {
							if(c.getX()*coeff+y < c.getY() || (c.getX()+64)*coeff+y < c.getY()){
								//Up
								if(c.getCellType() == 0 ||c.getCellType() == 2||c.getCellType() == 5||c.getCellType() == 6||c.getCellType() == 7||c.getCellType() == 8||c.getCellType() == 13) return false;
							}
							if(c.getX()*coeff+y > c.getY()+64 || (c.getX()+64)*coeff+y > c.getY()+64){
								//Down
								if(c.getCellType() == 1 ||c.getCellType() == 3||c.getCellType() == 4||c.getCellType() == 5||c.getCellType() == 6||c.getCellType() == 8||c.getCellType() == 10) return false;
							}
							if(c.getX()*coeff+y > c.getY() && c.getX()*coeff+y < c.getY()+64){
								//Left
								if(c.getCellType() == 2 ||c.getCellType() == 3 ||c.getCellType() == 4||c.getCellType() == 5||c.getCellType() ==7||c.getCellType() ==11||c.getCellType() ==14)return false;
							}
							if((c.getX()+64)*coeff+y > c.getY() && (c.getX()+64)*coeff+y < c.getY()+64){
								//Right
								if(c.getCellType() ==0||c.getCellType() ==1||c.getCellType() ==4||c.getCellType() ==7||c.getCellType() ==8||c.getCellType() ==12||c.getCellType() ==14)return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
	
	public void move(int dt) {
		// Check if the player is in direct view
		Player p = World.getPlayer();
		if(isInView(p)){
			// Then move towards it
			targetX = p.getX();
			targetY = p.getY();
			x = x + ((x-targetX)/Math.abs(x-targetX))*dt*getSpeed();
			y = y + ((y-targetY)/Math.abs(y-targetY))*dt*getSpeed();
			if(distToPlayer(p) <= 10){
				//Enter combat
				fightFlag = true;
			}
		}
		else {
			// Or move towards the last known location
			x = x + ((x-targetX)/Math.abs(x-targetX))*dt*getSpeed();
			y = y + ((y-targetY)/Math.abs(y-targetY))*dt*getSpeed();
		}
	}
	
}
