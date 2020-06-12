package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;
import edu.monash.fit2099.engine.WeaponItem;
/**
 * A subclass of Action that displays a menu for the player to aim or fire at the selected target.
 * 
 * @author Tan Song Shun
 *
 */
public class SnipeAimMenuAction extends Action {
	private Menu menu=new Menu();
	private Display display=new Display();
	private Actions actions=new Actions();
	private WeaponItem sniper;
	private Actor target;
	/**
	 * This is the constructor for the SnipeAimMenuAction class.
	 * 
	 * @param weapon WeaponItem that represents a sniper rifle.
	 * @param target  Actor that is chosen as target. 
	 * 
	 */
	public SnipeAimMenuAction(WeaponItem weapon, Actor target) {
		sniper=weapon;
		this.target=target;
		actions.add(new AimAction(target,sniper));
		actions.add(new SnipeAction(target,sniper));
	}
	@Override
	public Boolean isSniperAction() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * This method overrides the execute method of Action, and is called to perform
	 * an action, in this case it will display a menu to aim or fire at the
	 * target selected in TargetMenuAction.
	 * 
	 * @param actor The actor that is using the sniper rifle
	 * 
	 * @param map   The game map the actor is in.
	 * 
	 * @return a String that shows the actor had aimed or fired with the sniper rifle.
	 **/
	@Override
	public String execute(Actor actor, GameMap map) {
		
		Action action=menu.showMenu(actor, actions, display);
		return action.execute(actor,map);
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" targets "+ target+" with "+sniper;
	}

}
