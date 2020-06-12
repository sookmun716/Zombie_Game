package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;
import edu.monash.fit2099.engine.WeaponItem;
/**
 * A subclass of Action that displays a menu for the player to choose a target with sniper rifle.
 * 
 * @author Tan Song Shun
 *
 */
public class TargetMenuAction extends Action{
	private Menu menu=new Menu();
	private Display display=new Display();
	private Actions actions=new Actions();
	private WeaponItem sniper;
	
	/**
	 * This is the constructor for the TargetMenuAction class.
	 * 
	 * @param shotgun WeaponItem that represents a sniper rifle.
	 * 
	 */
	public TargetMenuAction(WeaponItem weapon) {
		sniper=weapon;
	}
	@Override
	public Boolean isSniperAction() {
		return true;
	}
	
	/**
	 * This method overrides the execute method of Action, and is called to perform
	 * an action, in this case it will display a menu to allow the player to select
	 * a target to aim or fire at with the sniper rifle.
	 * 
	 * @param actor The actor that is using the sniper rifle
	 * 
	 * @param map   The game map the actor is in.
	 * 
	 * @return a String that shows the actor had aimed or fired with the sniper rifle.
	 **/
	@Override
	public String execute(Actor actor, GameMap map) {
		for (int y : map.getYRange()) {
			for (int x : map.getXRange()) {
				if(map.at(x, y).containsAnActor()) {
					Actor snipe_target=map.at(x, y).getActor();
					if(snipe_target.hasCapability(ZombieCapability.UNDEAD)) {
						actions.add(new SnipeAimMenuAction(sniper,snipe_target));
					}
					
				}
			}
		}
		Action action=menu.showMenu(actor, actions, display);
		return action.execute(actor,map);
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor+" chooses target with sniper rifle";
	}

}
