package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class EatAction extends Action {
	private Food food;
	
	public EatAction(Food food) {
		this.food=food;
	}
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		actor.heal(food.healAmount());
		actor.removeItemFromInventory(food);
		return actor+" eaten food";
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" eats food";
	}

}
