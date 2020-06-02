package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * A subclass of Action that represents an action to eat food.
 * 
 * @author Tan Song Shun
 *
 */
public class EatAction extends Action {
	private Item food;

	/**
	 * This is the constructor for the EatAction class.
	 * 
	 * @param food Item that represents a food.
	 * 
	 */
	public EatAction(Item food) {
		this.food = food;
	}

	/**
	 * This method overrides the execute method of Action, and is called to perform
	 * an action, in this case it is used to eat food to restore actor health.
	 * 
	 * @param actor The actor that is eating the food
	 * 
	 * @param map   The game map the actor is in.
	 * 
	 * @return a String that shows the actor had eaten food to regain heatlh
	 **/
	@Override
	public String execute(Actor actor, GameMap map) {
		int heal_amount;
		//assign heal amount to show how much hp has been healed
		if(actor.getMaxHp()-actor.getHp()>25) {
			heal_amount=25;
		}
		else {
			heal_amount=actor.getMaxHp()-actor.getHp();
		}
		actor.heal(25);
		actor.removeItemFromInventory(food);
		return actor + " eaten food and healed for "+heal_amount+" hit points. ";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " eats food";
	}

}
