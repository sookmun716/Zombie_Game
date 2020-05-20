package game;

import edu.monash.fit2099.engine.*;

/**
 * A class that figures out Zombie perform a MoveAction that will wander or follow human
 * If zombie dropped both leg it will not move and if zombie drop one leg it can only move
 * on the every second turn.
 */
public class MoveBehaviour implements Behaviour {
	
	public Action getAction(Actor actor, GameMap map) {
		int counter = 1;
		if (actor.getLeg()!=2) {
			if(actor.getLeg()==1) {
				if(counter==1) {
					counter+=1;
					return new MoveAction(map.locationOf(actor));
				}
			}	
			else{
				return new MoveAction(map.locationOf(actor));
			}
		}
		return null;
	}
}