package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * A subclass of Action that represents an action to plant a crop in the dirt.
 * 
 * @author Tan Song Shun
 *
 */
public class PlantAction extends Action {

	private Location location;

	/**
	 * This is the constructor for the PlantAction class.
	 * 
	 * @param location Location that represents the chosen location to plant a crop.
	 * 
	 */
	public PlantAction(Location location) {
		this.location = location;
	}

	/**
	 * This method overrides the execute method of Action, and is called to perform
	 * an action, in this case it is used to plant a crop in the dirt.
	 * 
	 * @param actor The actor that is planting the crop
	 * 
	 * @param map   The game map the actor is in.
	 * 
	 * @return a String that shows the planting had been carried out.
	 **/
	@Override
	public String execute(Actor actor, GameMap map) {
		map.at(location.x(), location.y()).setGround(new Crop());
		return actor + " planted a crop in " + location.x() + ", " + location.y();
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isSniperAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isEnd() {
		// TODO Auto-generated method stub
		return null;
	}

}
