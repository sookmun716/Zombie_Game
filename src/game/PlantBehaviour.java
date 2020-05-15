package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class PlantBehaviour implements Behaviour {
	private Random random= new Random();
	@Override
	public Action getAction(Actor actor, GameMap map) {
		//33 percent chance to plant a crop
		if(random.nextInt(101)<67) {
			return null;
		}
		
		ArrayList<Action> actions = new ArrayList<Action>();
		
		for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)&& 
            	destination.getGround().getDisplayChar()=='.') {
            	actions.add(new PlantAction(exit.getDestination()));
            }
        }
		
		if (!actions.isEmpty()) {
			return actions.get(random.nextInt(actions.size()));
		}
		else {
			return null;
		}
	}

}
