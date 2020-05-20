package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;
import edu.monash.fit2099.engine.Weapon;

import java.util.ArrayList;

public class PickUpBehaviour implements Behaviour{
	
	ArrayList<Weapon> pickUpWeapon = new ArrayList<Weapon>();
	
	@Override
	public Action getAction(Actor actor, GameMap map) {
		if(actor.hasCapability(ZombieCapability.UNDEAD)) {
			for(Item item : map.locationOf(actor).getItems()) {
				if(item.getDisplayChar()==')'||item.getDisplayChar()=='A'||item.getDisplayChar()=='L'
											||item.getDisplayChar()=='M'||item.getDisplayChar()=='C') {
					return new PickUpItemAction(item);
				}
			}
		}
		return null;
	}	
}