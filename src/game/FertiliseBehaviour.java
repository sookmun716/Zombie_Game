package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class FertiliseBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		//Cannot fertilise if not standing on crop
		if(!(map.locationOf(actor).getGround() instanceof Crop)) {
			return null;
		}
		Crop crop=(Crop)map.locationOf(actor).getGround();
		
		//conditions to determine if fertilisation is possible
		if(crop.isFertilised()|| crop.getripeTurns()>=20) {
			return null;
		}
		return new FertiliseAction(crop);
	}

}
