package battle;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Battle extends BasicGameState{

	public static int ID=2;
	private StateBasedGame game;
	private BattlePlayer player;
	private ArrayList<BattleEnnemy> enemies;
	
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		game=arg1;
	}
	
	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		player.render(arg0, arg1, arg2);
		for(BattleEnemy e:enemies)
			e.render(arg0, arg1, arg2);
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

}
