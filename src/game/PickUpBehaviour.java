package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;

/**
 * A subclass of Behaviour that represents picking up weapons for zombie. 
 * If there is any weapon at Zombie's location then it will pick it up.
 * @author SookMun
 *
 */
public class PickUpBehaviour implements Behaviour{

	@Override
	public Action getAction(Actor actor, GameMap map) {
		try {
		if(actor.hasCapability(ZombieCapability.UNDEAD)) {
			for(Item item : map.locationOf(actor).getItems()) {
				if(item.isWeapon()) {
					return new PickUpItemAction(item);
				}
			}
		}
		}
		catch(NullPointerException e) {
			}
		return null;
	}	
}