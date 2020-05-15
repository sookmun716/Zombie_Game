package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class EatAction extends Action {
	private Item food;
	
	public EatAction(Item food) {
		this.food=food;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		actor.heal(25);
		actor.removeItemFromInventory(food);
		return actor+" eaten food";
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" eats food";
	}

}
