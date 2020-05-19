package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * A subclass of Behaviour that represents the fertilising of crops, will return
 * a new FertiliseAction if a farmer is standing on an unfertilised and unripe
 * crop.
 * 
 * @author Tan Song Shun
 *
 */
public class FertiliseBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// Farmer can only fertilise unfertilised and unripe crops.
		try {
			if (!map.locationOf(actor).getGround().isFertilised()) {
				return new FertiliseAction();
			}
		}
		catch(NullPointerException e) {
			
		}

		return null;
	}

}
