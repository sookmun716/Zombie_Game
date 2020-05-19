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
		//replace Crop with Dirt
		map.at(location.x(), location.y()).setGround(new Dirt());
		//If actor is farmer harvest and place on ground
		if(actor.getDisplayChar()=='F') {
			map.at(location.x(), location.y()).addItem(new Food());
		}
		//If actor is player add food to inventory
		else if(actor instanceof Player) {
			actor.addItemToInventory(new Food());
		}
		else {
			return null;
		}
		
		return actor+" harvested a crop at "+location.x()+", "+location.y();
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" harvests crop at " +location.x()+", "+location.y();
	}

}
