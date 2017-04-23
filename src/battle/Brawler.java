package battle;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public interface Brawler {

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2);
	public int getSpeed();
	public int getDone();
	public void setDone(int i);
}
