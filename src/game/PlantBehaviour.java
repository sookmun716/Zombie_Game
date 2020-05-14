package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class PlantBehaviour implements Behaviour {
	private Random random= new Random();;
	@Override
	public Action getAction(Actor actor, GameMap map) {
		//Cannot plant if ground is not dirt
		if(!(map.locationOf(actor).getGround() instanceof Dirt)) {
			return null;
		}
		
		//33 percent chance to plant a crop
		if(random.nextInt(101)<67) {
			return null;
		}
		return new PlantAction();
	}

}
