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
import world.World;

public class Enemy extends Entity{
	private int moveTimer = 75; 
	private Object nearestCase;
	private Level level;
	
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
			move();
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
		boolean result = true;
		ArrayList<Object> cases = new ArrayList<Object>();
		//Main steps of the algorithm (note that the steps can be done in one pass.)
		
		//First step : getting the cases
			//Each case within the rectangle formed by the two entities is a candidate
			// if the line cross the case, it goes into our list.
			// Line equation : lineY = (y-p.getY())*lineX/(x-p.getX()) + x 
			// For each x covered by the case, we check lineY. 
		for(Cell[] col : level.grid){
			System.out.println("new line");
			for(Cell c : col){
				System.out.print("|cell");
			}
			System.out.println("|");
		}
		//Second step : check if they obstruct the line of sight.
			// We also have to check which sides are in the way of the LoS : if there is a wall on one of those sides, we have to return false.
			
		//Third step : update the nearest case and return the result.
			// If the LoS is obstructed, the nearest case is the current case in order to stay in place?
		return result;
	}
	
	public void move() {
		// Check if the player is in direct view
		Player p = World.getPlayer();
		if(distToPlayer(p) <= 10 && isInView(p)){
			// Then move towards it
		}
		else {
			// Or do nothing
		}
	}
	
}
