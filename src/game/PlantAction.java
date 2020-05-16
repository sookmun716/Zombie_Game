package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class PlantAction extends Action{
	
	private Location location;

	public PlantAction(Location location) {
		this.location=location;
	}
	@Override
	public String execute(Actor actor, GameMap map) {
		map.at(location.x(), location.y()).setGround(new Crop());
		return actor +" planted a crop in"+location.x()+", "+location.y();
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
