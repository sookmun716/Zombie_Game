package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.WeaponItem;

/**
 * A subclass of Action that represents an action to craft a new weapon.
 * 
 * @author Tan Song Shun
 *
 */
public class CraftWeaponAction extends Action {
	private WeaponItem weapon;

	/**
	 * This is the constructor for the CraftWeaponAction class.
	 * 
	 * @param weapon Represents either a zombie arm or zombie leg
	 * 
	 */
	public CraftWeaponAction(WeaponItem weapon) {
		this.weapon = weapon;
	}

	/**
	 * This method overrides the execute method of Action, and is called to perform
	 * an action, in this case it is used to create new weapons
	 * 
	 * @param actor The actor that is holding the weapon
	 * 
	 * @param map   The game map the actor is in.
	 * 
	 * @return a String that shows the crafting had been carried out in the turn.
	 **/
	@Override
	public String execute(Actor actor, GameMap map) {
		return weapon.transform(actor);
	}

	/**
	 * This method overrides the menuDescription method, and displays the available
	 * crafting option for the player.
	 * 
	 * @param actor The actor that is holding the weapon
	 * 
	 * @return a String that shows the actor the actions that can be carried out.
	 **/
	@Override
	public String menuDescription(Actor actor) {
		return weapon.craftDescription(actor);
	}
}
