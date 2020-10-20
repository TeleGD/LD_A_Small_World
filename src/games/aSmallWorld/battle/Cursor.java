package games.aSmallWorld.battle;

import java.util.ArrayList;

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
	private ArrayList<Float> pos;

	public Cursor(float x,float y){
		this.x=x;
		this.y=y;
		shown=false;
		selection=0;
		try {
			img=new Image ("images/aSmallWorld/pointer.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		pos = new ArrayList<Float>();

	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) {
		if(shown){
			arg2.drawImage(img, x, pos.get(selection));
		}
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
			case Input.KEY_DOWN:
				if (selection<pos.size()-1)
					selection++;
				else
					selection=0;
				break;
			case Input.KEY_UP:
				if (selection>0)
					selection--;
				else
					selection=pos.size()-1;
				break;
			case Input.KEY_ENTER:
				Battle.getPlayer().setTarget(Battle.getEnemies().get(this.selection));
				Battle.setTurnDone();
				shown=false;
				break;


			}
		}
	}

	public boolean isShown(){
		return shown;
	}

	public void setPos(ArrayList<Float> list){
		pos= list;
	}
}
