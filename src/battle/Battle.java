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
	private static BattlePlayer player;
	private static ArrayList<BattleEnemy> enemies;
	private static boolean turnDone;//if the orders already have been given
	private static ArrayList<Brawler> brawlers;
	static int a;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		game=arg1;
	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		player=new BattlePlayer(arg0);
		enemies=new ArrayList<BattleEnemy>();
		enemies.add(new BattleEnemy(arg0,arg0.getHeight()/4-50 ));
		enemies.add(new BattleEnemy(arg0,arg0.getHeight()*2/4 -50));
		enemies.add(new BattleEnemy(arg0,arg0.getHeight()*3/4 -50));
		brawlers= new ArrayList<Brawler>();
		brawlers.add(player);
		for(BattleEnemy e:enemies)
			brawlers.add(e);
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
		if(!turnDone){
			BattleMenu.update(arg0,arg1,arg2);
		}else {
			if(a<brawlers.size()){
				brawlers.get(a).update(arg0, arg1, arg2);
				if(brawlers.get(a).getDone()==-1){
					a++;
				}
			}else{
				turnDone=false;
			}
		}
	}

	@Override
	public int getID() {
		return ID;
	}

	public static void setTurnDone(){
		turnDone=true;
		a=0;
		for (Brawler b:brawlers)
			b.setDone(0);
	}

	public static void setTurnUndone(){
		turnDone=false;
		a=0;
	}

	public void keyPressed(int key, char c) {
		if(!turnDone){
			BattleMenu.keyPressed(key,c);
		}
		for(BattleEnemy e:enemies)
			e.keyPressed(key, c);
	}

	public static BattlePlayer getPlayer(){
		return player;
	}

	public static ArrayList<BattleEnemy> getEnemies() {
		return enemies;
	}
}
