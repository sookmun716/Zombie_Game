package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;

public class PickUpBehaviour implements Behaviour{

	@Override
	public Action getAction(Actor actor, GameMap map) {
		if(actor.hasCapability(ZombieCapability.UNDEAD)) {
			for(Item item : map.locationOf(actor).getItems()) {
				if(item.getDisplayChar()==')') {
					return new PickUpItemAction(item);
				}
			}
		}
		return null;
	}	
}