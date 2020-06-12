package edu.monash.fit2099.demo.mars;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

/**
 * Class representing the Player.
 */
public class Player extends Actor {

	private Menu menu = new Menu();
	
	/**
	 * Constructor.
	 *
	 * @param name Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		return menu.showMenu(this, actions, display);
	}

	@Override
	public int getHp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxHp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void dropArm(int Arm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropLeg(int Leg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getArm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLeg() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void set_sniper_ammo(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get_sniper_ammo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_shotgun_ammo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void set_shotgun_ammo(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get_turn_count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Action get_lastAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_previous_health() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean damaged() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String create_corpse(GameMap map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int chant_round() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
