package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;

public class FertiliseAction extends Action {
	@Override
	public String execute(Actor actor, GameMap map) {
		//fertilising crops
		for(int i=0;i<10;i++) {
			map.locationOf(actor).getGround().tick(map.locationOf(actor));
		}
		//change display character to represent a fertilised crop
		map.locationOf(actor).getGround().setDisplayChar('|');
		return actor+" fertilised crop at "+map.locationOf(actor).x()+
				map.locationOf(actor).y();
		
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
