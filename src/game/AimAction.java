package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.WeaponItem;
/**
 * A subclass of Action that makes an actor aim at a target with a sniper rifle.
 * 
 * @author Tan Song Shun
 *
 */
public class AimAction extends Action{
	private Actor target;
	private WeaponItem sniper;
	
	/**
	 * This is the constructor for the AimAction class.
	 * 
	 * @param sniper WeaponItem that represents a sniper rifle.
	 * 
	 * @param target  Actor that is chosen as target. 
	 * 
	 */
	public AimAction(Actor target, WeaponItem sniper) {
		this.target=target;
		this.sniper=sniper;
	}
	
	/**
	 * This method overrides the execute method of Action, and is called to perform
	 * an action, in this case it will aim at the specified target. If the target 
	 * the player aimed at is different from the previous target, the concentration
	 * resets.
	 * 
	 * @param actor The actor that is using the sniper rifle
	 * 
	 * @param map   The game map the actor is in.
	 * 
	 * @return a String that shows the actor had aimed at a target with the sniper rifle.
	 **/
	@Override
	public String execute(Actor actor, GameMap map) {
		try {
			if(target==sniper.target()) {
				sniper.set_aim_turns((sniper.aim_turns()+1));
			}
			else {
				sniper.set_aim_turns(1);
				sniper.setTarget(target);
			}
			return actor+" aimed at "+ target+" for "+sniper.aim_turns()+" turn(s). ";
		}
		catch(NullPointerException e){
			return null;
		}
		
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor+" aims at "+target;
	}
	@Override
	public Boolean isSniperAction() {
		return null;
	}

	@Override
	public Boolean isEnd() {
		// TODO Auto-generated method stub
		return null;
	}

}
