package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class HarvestBehaviour implements Behaviour{

	@Override
	public Action getAction(Actor actor, GameMap map) {
		//Harvest crop when standing on a ripe crop
		if (map.locationOf(actor).getGround() instanceof Crop) {
			Crop crop=(Crop)map.locationOf(actor).getGround();
			if(crop.getripeTurns()>=20) {
				return new HarvestAction(map.locationOf(actor));
			}
			return null;
		}
		
		ArrayList<Action> actions = new ArrayList<Action>();
		//Harvest crop next to farmer
		for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.getGround() instanceof Crop){
            	Crop crop=(Crop) destination.getGround();
            	if(crop.getripeTurns()>=20) {
            		actions.add(new HarvestAction(destination));
            	}
            }
        }
		
		Random random= new Random(); 
		if (!actions.isEmpty()) {
			return actions.get(random.nextInt(actions.size()));
		}
		else {
			return null;
		}
	}

}
