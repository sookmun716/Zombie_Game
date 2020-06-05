package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ChantBehaviour implements Behaviour{

	@Override
	public Action getAction(Actor actor, GameMap map) {
		if(actor.get_turn_count()==10 || actor.get_turn_count()==20 || actor.get_turn_count()==30) return new ChantAction();
		return null;
		
	}

}
