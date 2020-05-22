
package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * A subclass of Behaviour that represents the eating of food, only humans can
 * eat food and humans will only eat food when they are damaged.
 * 
 * @author Tan Song Shun
 *
 */
public class EatFoodBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Undead cannot heal through food
		if (actor.hasCapability(ZombieCapability.UNDEAD))
			return null;

		// loop through the items on the location to find out whether food is available
		for (Item item : map.locationOf(actor).getItems()) {
			// if location contains food humans can eat it
			try {
				if (item.isFood()) {
					// only eat food when human is hurt
					if (actor.getMaxHp() == actor.getHp()) {
						return null;
					}
					return new EatAction(item);
				}
			}
			// ignore exception because item is not food
			catch (NullPointerException e) {
				continue;
			}
		}
		return null;

	}

}
