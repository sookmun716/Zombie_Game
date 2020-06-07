package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

/**
 * Class representing the Player.
 */
public class Player extends Human {

	private Menu menu = new Menu();
	private int shotgun_ammo=0;
	private int sniper_ammo=0;
	private Action lastAction;
	private int previous_health;
	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}

	/**
	 * Method to check whether location of player and the adjacent locations have
	 * crop available for harvest, the available actions are added into actions so
	 * that player can perform an action to harvest crop. This method is required
	 * because player have to behaviour
	 * 
	 * @param actions Actions that represents the actions a player can take
	 * @param map GameMap the player is in
	 * @return The original Actions with the new added Action classes
	 */
	public Actions availableHarvest(Actions actions, GameMap map) {
		ArrayList<Action> availableCrops = new ArrayList<Action>();
		// check location adjacent to player for ripe crops
		availableCrops = new HarvestBehaviour().checkCrop(this, map, availableCrops);
		if (availableCrops.size() != 0) {
			for (Action harvest : availableCrops) {
				actions.add(harvest);
			}
		}
		// check player location for ripe crop
		if (map.locationOf(this).getGround().getDisplayChar() == '!') {
			actions.add(new HarvestAction(map.locationOf(this)));
		}

		return actions;
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		System.out.println(this.name+" shotgun ammunition count: "+shotgun_ammo);
		System.out.println(this.name+" sniper rifle ammunition count: "+sniper_ammo);
		actions = availableHarvest(actions, map);
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		set_previous_health();
		Action action_this_round=menu.showMenu(this, actions, display);
		this.lastAction=action_this_round;
		return action_this_round;
	}
	
	@Override
	public int get_shotgun_ammo() {
		return shotgun_ammo;
	}
	
	@Override
	public int get_sniper_ammo() {
		return sniper_ammo;
	}
	
	@Override
	public void set_shotgun_ammo(int count) {
		shotgun_ammo=count;
	}
	
	@Override
	public void set_sniper_ammo(int count) {
		sniper_ammo=count;
	}
	
	@Override 
	public Action get_lastAction() {
		return lastAction;
	}
	
	@Override
	public void set_previous_health() {
		previous_health=this.hitPoints;
	}

	@Override
	public Boolean damaged() {
		if (this.hitPoints!=previous_health) return true;
		return false;
	}

}
