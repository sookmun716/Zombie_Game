package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class PlantAction extends Action{

	@Override
	public String execute(Actor actor, GameMap map) {
		map.locationOf(actor).setGround(new Crop());
		return actor +" planted a crop in the dirt";
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
