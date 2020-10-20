package games.aSmallWorld;

import java.io.File;
import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import games.aSmallWorld.character.enemies.Enemy;
import games.aSmallWorld.character.player.Player;
import games.aSmallWorld.donjon.Level;


public class World extends BasicGameState{

	public static int longueur = 1280;
	public static int hauteur = 720;

	private int ID;
	private static StateBasedGame game;
	private Enemy e;
	private Level l;

	public World(int ID) {
		this.ID = ID;
	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		game=arg1;
		int hauteur=12;
		int largeur=20;
		l = new Level(1, hauteur, largeur);
	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1){
		//Ici mettre tous les chargement d'image, creation de perso/decor et autre truc qui mettent du temps
	}


	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		l.render(arg0,arg1,arg2);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
	}

	public static void reset() {
	}

	public static Player getPlayer() {
		// TODO Auto-generated method stub
		return new Player();
	}
}
