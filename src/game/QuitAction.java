package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class QuitAction extends Action {
	
	/**
	 * An action where player can choose in the menu. 
	 * Once the action is chose, it will end the game by removing player from the map.
	 * A description of player quit the game will be displayed.
	 * @param actor: the actor performing this action
	 * @param map: the map the actor is on.
	 * @return a description of what happened that can be displayed to the user.
	 * 
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		if(Player.class.isInstance(actor)) {
			map.removeActor(actor);
			return menuDescription(actor);
		}
		return null;
	}
	
	/**
	 * Return a descriptive string when player quits the game. 
	 * @param actor: the actor performing this action
	 * @return the text we put on the menu
	 */
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


