package battle;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Cursor {

	private float x,y;
	private Image img;
	private boolean shown;
	private int selection;

	public Cursor(float x,float y){
		this.x=x;
		this.y=y;
		shown=false;
		selection=0;
		try {
			img=new Image ("img/pointer.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) {
		if(shown)
			arg2.drawImage(img, x, y+selection*720/4);
	}


	public void show(){
		shown=true;
	}

	public void hide(){
		shown=false;
	}

	public void keyPressed(int key, char c) {
		if(shown){
			switch(key){
			case Input.KEY_UP:
				if (selection<Battle.getEnemies().size()-1)
					selection++;
				else
					selection=0;
				break;
			case Input.KEY_DOWN:
				if (selection>0)
					selection--;
				else
					selection=Battle.getEnemies().size()-1;
				break;
			case Input.KEY_ENTER:
				Battle.getPlayer().setTarget(Battle.getEnemies().get(selection));
				Battle.getPlayer().setTemp();
				Battle.getPlayer().setAction(0);
				Battle.getPlayer().setUndone();
				Battle.setTurnDone();
				break;


			}
		}
	}
}
