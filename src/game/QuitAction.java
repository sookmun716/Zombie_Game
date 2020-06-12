package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class QuitAction extends Action {
	
	@Override
	public String execute(Actor actor, GameMap map) {
		if(Player.class.isInstance(actor)) {
			map.removeActor(actor);
			return menuDescription(actor);
		}
		return null;
	}
	
	@Override
	public String menuDescription(Actor actor) {
		return actor + " quit the game!";
	}

	@Override
	public Boolean isSniperAction() {
		// TODO Auto-generated method stub
		return null;
	}
}


