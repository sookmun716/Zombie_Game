package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ChantBehaviour implements Behaviour{

	@Override
	public Action getAction(Actor actor, GameMap map) {
		//chant every 10 rounds 
		if(actor.get_turn_count()%actor.chant_round()==0) return new ChantAction();
		return null;
		
	}

}
