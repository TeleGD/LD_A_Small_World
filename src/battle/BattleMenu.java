package battle;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import character.enemies.BattleEnemy;

public class BattleMenu {

	private static int selection;//1:fight  2:def  3:power  4:flee "grosso modo"
	private Cursor cursor;
	
	public BattleMenu(){
		cursor=new Cursor(1280*3/4-20,720/4);
	}
	
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		Battle.getPlayer().setAction(4);
		for (BattleEnemy e:Battle.getEnemies())
			e.setAction(0);
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) {
		arg2.setColor(Color.black);
		arg2.fillRect(0, arg0.getHeight()*2/3, arg0.getWidth()/4, arg0.getHeight()/3);
		arg2.setColor(Color.white);
		arg2.drawString("Attack", 50, arg0.getHeight()*2/3+10);
		arg2.drawString("Defend", 50, arg0.getHeight()*2/3+60);
		arg2.drawString("Power", 50, arg0.getHeight()*2/3+110);
		arg2.drawString("Flee", 50, arg0.getHeight()*2/3+160);
		arg2.drawString(">>>", 20, arg0.getHeight()*2/3+10+selection*50);
		cursor.render(arg0, arg1, arg2);
	}

	public void keyPressed(int key, char c) {
		switch(key){
		case Input.KEY_DOWN:
			if(selection<3)
				selection++;
			else
				selection=0;
			break;
		case Input.KEY_UP:
			if(selection>0)
				selection--;
			else
				selection=3;
			break;
		case Input.KEY_ENTER:
			execOption();
			Battle.setTurnDone();
			break;
		}

	}

	private void execOption(){
		Battle.chooseEnAction();
		switch (selection){
		case 0:
			
			cursor.show();
			Battle.getPlayer().setTarget(Battle.getEnemies().get(0));
			System.out.println("il ne manque plus qu'a choisir l'ennemi a attaquer");
			break;
		case 1:
			Battle.getPlayer().setAction(1);
			System.out.println("defendez vous");
			break;
		case 2:
			Battle.getPlayer().setAction(2);
			System.out.println("il faut choisir le pouvoir maintenant");
			break;
		case 3:
			Battle.getPlayer().setAction(3);
			System.out.println("coward");
			break;
		}
	}

	

}
