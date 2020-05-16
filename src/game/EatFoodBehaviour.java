package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class EatFoodBehaviour implements Behaviour{

	@Override
	public Action getAction(Actor actor, GameMap map) {
		//Undead cannot heal through food
		if(actor.hasCapability(ZombieCapability.UNDEAD)) return null;
		
		for(Item item : map.locationOf(actor).getItems()) {
			//if location contains food humans can eat it
			if(item.getDisplayChar()=='f') {
				//only eat food when human is hurt
				if(actor.getMaxHp()==actor.getHp()) {
					return null;
				}
				return new EatAction(item);
			}
		}
		return null;
			
	}

}
