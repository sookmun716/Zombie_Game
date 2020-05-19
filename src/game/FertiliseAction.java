package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
/**
 * A subclass of Action that represents an action to fertilise a crop.
 * 
 * @author Tan Song Shun
 *
 */
public class FertiliseAction extends Action {
	/**
	 * This method overrides the execute method of Action, and is called to perform
	 * an action, in this case it is used to fertilise a crop
	 * 
	 * @param actor The actor that is fertilising the crop.
	 * 
	 * @param map   The game map the actor is in.
	 * 
	 * @return a String that shows a crop had been fertilised.
	 **/
	@Override
	public String execute(Actor actor, GameMap map) {
		//change display character to represent a fertilised crop
		//fertilising crops by calling tick to increment ripeTurns
		map.locationOf(actor).getGround().fertilise();
		return actor+" fertilised crop at "+map.locationOf(actor).x()+
				", "+map.locationOf(actor).y();
		
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
