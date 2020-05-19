package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * A subclass of Behaviour that represents the planting of crops, has a 33
 * percent chance of returning a new PlantAction that plants a crop in the dirt
 * next to a farmer.
 * 
 * @author Tan Song Shun
 *
 */
public class PlantBehaviour implements Behaviour {
	private Random random = new Random();

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// 33 percent chance to plant a crop
		if (random.nextInt(101) < 67) {
			return null;
		}

		ArrayList<Action> actions = new ArrayList<Action>();
		// check adjacent locations for suitable planting spots.
		for (Exit exit : map.locationOf(actor).getExits()) {
			Location destination = exit.getDestination();
			try {
			if (destination.canActorEnter(actor) && destination.getGround().canPlant()) {
				actions.add(new PlantAction(exit.getDestination()));
			}
			}
			catch(NullPointerException e){
				continue;
			}
		}

		if (!actions.isEmpty()) {
			return actions.get(random.nextInt(actions.size()));
		} else {
			return null;
		}
	}

}
