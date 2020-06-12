package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.WeaponItem;
/**
 * A subclass of Action that makes an actor fire at a target with a sniper rifle.
 * 
 * @author Tan Song Shun
 *
 */
public class SnipeAction extends Action{
	private Actor target;
	private WeaponItem sniper;
	private Random random=new Random();
	//number of rounds to achieve maximum concentration
	public static final int MAXIMUM_FOCUS=2;
	
	/**
	 * This is the constructor for the SnipeAction class.
	 * 
	 * @param sniper WeaponItem that represents a sniper rifle.
	 * @param target  Actor that is chosen as target. 
	 * 
	 */
	public SnipeAction(Actor target, WeaponItem sniper) {
		this.target=target;
		this.sniper=sniper;
	}
	
	/**
	 * This method overrides the execute method of Action, and is called to perform
	 * an action, in this case it will fire at the target, with the appropriate damage
	 * modifiers according to the requirements. A player cannot fire a sniper rifle it 
	 * he/she does not have sniper ammunition left.
	 * 
	 * @param actor The actor that is using the sniper rifle
	 * 
	 * @param map   The game map the actor is in.
	 * 
	 * @return a String that shows the actor had fired at a target with the sniper rifle.
	 **/
	@Override
	public String execute(Actor actor, GameMap map) {
		String result=null;
		if(actor.get_sniper_ammo()==0) {
			return actor+" has no sufficient sniper ammunition, sniper cannot be fired";
		}
		sniper.use_ammo(actor);
		int aim_turns=sniper.aim_turns();
		if(aim_turns==0) {
			if(random.nextInt(101)>=25) {
				target.hurt(sniper.ranged_damage());
				result=actor+" "+sniper.secondary_verb()+" "+target+ " for "+sniper.ranged_damage()+" damage";
				
			}
			else {
				result=actor+" misses "+target+"!";
			}
			
		}
		else if(aim_turns>0&&aim_turns<MAXIMUM_FOCUS) {
			if(random.nextInt(101)>=10) {
				int double_damage=sniper.ranged_damage()*2;
				target.hurt(double_damage);
				result=actor+" "+sniper.secondary_verb()+" "+target+ " for "+double_damage+" damage";
			}
			else {
				result=actor+" misses "+target+"!";
			}
		}
		else if(aim_turns>=MAXIMUM_FOCUS) {
			int max_damage=target.getHp();
			target.hurt(max_damage);
			result=actor+" "+sniper.secondary_verb()+" "+target+ " for "+max_damage+" damage";
			
		}

		result+=target.create_corpse(map);
		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" snipes "+target;
	}
	@Override
	public Boolean isSniperAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
