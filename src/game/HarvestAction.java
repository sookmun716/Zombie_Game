package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class HarvestAction extends Action {
	
	private Location location;

	public HarvestAction(Location location) {
		this.location=location;
	}
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		map.at(location.x(), location.y()).setGround(new Dirt());
		if(actor instanceof Farmer) {
			map.at(location.x(), location.y()).addItem(new Food());
		}
		else {
			actor.addItemToInventory(new Food());
		}
		return actor+" harvested a crop";
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" harvests crop";
	}

}
