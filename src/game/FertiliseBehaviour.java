package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class FertiliseBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		//Farmer can only fertilise unfertilised and unripe crops.
		if(map.locationOf(actor).getGround().getDisplayChar()!='^') {
			return null;
		}
		
		return new FertiliseAction();
	}

}
