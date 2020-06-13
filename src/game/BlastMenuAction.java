package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Menu;
import edu.monash.fit2099.engine.WeaponItem;
/**
 * A subclass of Action that will bring up a submenu for choosing shotgun fire direction.
 * 
 * @author Tan Song Shun
 *
 */
public class BlastMenuAction extends Action {
	private Menu menu=new Menu();
	private Display display=new Display();
	private Actions actions=new Actions();
	private WeaponItem shotgun;
	
	/**
	 * This is the constructor for the BlastMenuAction class.
	 * @param weapon WeaponItem that represents a shotgun.
	 * 
	 */
	public BlastMenuAction(WeaponItem weapon) {
		shotgun=weapon;
	}
	
	@Override
	public Boolean isSniperAction() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * This method overrides the execute method of Action, and is called to perform
	 * an action, in this case it displays a menu to allow players to choose the direction 
	 * to fire a shotgun.
	 * 
	 * @param actor The actor that is firing the shotgun
	 * 
	 * @param map   The game map the actor is in.
	 * 
	 * @return a String that shows the actor had fired the shotgun.
	 **/
	@Override
	public String execute(Actor actor, GameMap map) {
		if(actor.get_shotgun_ammo()==0) {
			return actor+" has no "+shotgun+" ammunition left, "+shotgun+" cannot be fired.";
		}
		Location actor_location=map.locationOf(actor);
		for (Exit exit : actor_location.getExits()) {
			actions.add(new BlastAction(shotgun, exit));
		}
		Action action=menu.showMenu(actor, actions, display);
		return action.execute(actor,map);
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" fires shotgun";
	}

	@Override
	public Boolean isEnd() {
		// TODO Auto-generated method stub
		return null;
	}

}
