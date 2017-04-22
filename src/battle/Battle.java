package battle;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import character.enemies.BattleEnemy;
import character.player.BattlePlayer;

public class Battle extends BasicGameState{

	public static int ID=2;
	private StateBasedGame game;
	private BattlePlayer player;
	private ArrayList<BattleEnemy> enemies;
	private static boolean turnDone;//if the orders already have been given
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		game=arg1;
	}
	
	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		player=new BattlePlayer();
		enemies=new ArrayList<BattleEnemy>();
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		player.render(arg0, arg1, arg2);
		for(BattleEnemy e:enemies)
			e.render(arg0, arg1, arg2);
		if(!turnDone){
			BattleMenu.render(arg0,arg1,arg2);
		}
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		player.update(arg0, arg1, arg2);
		for(BattleEnemy e:enemies)
			e.update(arg0, arg1, arg2);
		
	}

	@Override
	public int getID() {
		return ID;
	}

	public static void setTurnDone(){
		turnDone=false;
	}
	
	public void keyPressed(int key, char c) {
		if(!turnDone){
			BattleMenu.keyPressed(key,c);
		}
	}
}
