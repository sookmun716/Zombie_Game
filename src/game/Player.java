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
	
	public Actions availableHarvest(Actions actions, GameMap map) {
		ArrayList<Action> availableCrops= new ArrayList<Action>();
		//check location adjacent to player for ripe crops
		availableCrops=new HarvestBehaviour().checkCrop(this, map, availableCrops);
		if(availableCrops.size()!=0) {
			for(Action harvest : availableCrops) {
				actions.add(harvest);
			}
		}
		//check player location for ripe crop
		if(map.locationOf(this).getGround().getDisplayChar()=='!'){
				actions.add(new HarvestAction(map.locationOf(this))) ;
		}
		
		return actions;
	}
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		actions=availableHarvest(actions,map);
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		return menu.showMenu(this, actions, display);
	}
	
}
