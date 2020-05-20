package game;

import edu.monash.fit2099.engine.*;

public class MoveAction extends Action{
	protected Location moveToLocation;
	
	public MoveAction(Location moveLocation) {
		this.moveToLocation = moveLocation;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		map.moveActor(actor, this.moveToLocation);
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + "remains at it's location.";
	}
}
