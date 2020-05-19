package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * A subclass of Behaviour that represents the fertilising of crops, will return
 * a new HarvestAction if a farmer is standing on or next to a ripe crop, if
 * there are multiple ripe crops available for harvest, a random crop will be
 * chosen to be harvested.
 * 
 * @author Tan Song Shun
 *
 */
public class HarvestBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Harvest crop when standing on a ripe crop
		try {
		if (map.locationOf(actor).getGround().isRipe()) {
			return new HarvestAction(map.locationOf(actor));
		}
		}
		//ignore exception and continue because it just indicates the ground is not a 
		//crop
		catch(NullPointerException e) {
			
		}

		ArrayList<Action> actions = new ArrayList<Action>();
		// Harvest crop next to farmer
		actions = checkCrop(actor, map, actions);
		Random random = new Random();
		if (!actions.isEmpty()) {
			return actions.get(random.nextInt(actions.size()));
		}
		return null;
	}

	/**
	 * This method checks for the available ripe crops to be harvested and returns
	 * an ArrayList of Action so that getAction can choose from the available
	 * HarvestAction
	 * 
	 * @param actor   The actor that is harvesting the crop.
	 * 
	 * @param map     The game map the actor is in.
	 * 
	 * @param actions An ArrayList of Action that stores the HarvestAction.
	 * 
	 * @return actions An ArrayList that represents the HarvestAction that can be
	 *         carried out
	 **/
	public ArrayList<Action> checkCrop(Actor actor, GameMap map, ArrayList<Action> actions) {
		// check ripe crops available for harvest next to farmer
		for (Exit exit : map.locationOf(actor).getExits()) {
			Location destination = exit.getDestination();
			try {
			if (destination.getGround().isRipe()) {
				actions.add(new HarvestAction(destination));
			}
			}
			catch(NullPointerException e) {
				continue;
			}
		}
		return actions;
	}
}
