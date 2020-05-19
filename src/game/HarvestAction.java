package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * A subclass of Action that represents an action to Harvest a crop. Crop will
 * be replaced with dirt and depending whether the person harvesting the crop,
 * the crop will either be placed on the ground or added into the inventory
 * 
 * @author Tan Song Shun
 *
 */
public class HarvestAction extends Action {

	private Location location;

	/**
	 * This is the constructor for the HarvestAction class.
	 * 
	 * @param location Location that represents the location which has a ripe crop.
	 * 
	 */
	public HarvestAction(Location location) {
		this.location = location;
	}

	/**
	 * This method overrides the execute method of Action, and is called to perform
	 * an action, in this case it is used to harvest a crop.
	 * 
	 * @param actor The actor that is fertilising the crop.
	 * 
	 * @param map   The game map the actor is in.
	 * 
	 * @return a String that shows a crop had been fertilised.
	 **/
	@Override
	public String execute(Actor actor, GameMap map) {
		// replace Crop with Dirt
		map.at(location.x(), location.y()).setGround(new Dirt());
		// If actor is farmer harvest and place on ground
		if (actor.getDisplayChar() == 'F') {
			map.at(location.x(), location.y()).addItem(new Food());
		}
		// If actor is player add food to inventory
		else if (actor instanceof Player) {
			actor.addItemToInventory(new Food());
		} else {
			return null;
		}

		return actor + " harvested a crop at " + location.x() + ", " + location.y();
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " harvests crop at " + location.x() + ", " + location.y();
	}

}
