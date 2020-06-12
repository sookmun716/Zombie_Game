package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;
/**
 * A subclass of WeaponItem that represents a sniper rifle.
 * 
 * @author Tan Song Shun
 *
 */
public class SniperRifle extends WeaponItem {
	private int aim_turns=0;
	private Actor target;
	private int ranged_damage=40;
	public static int MAXIMUM_FOCUS=2;
	public SniperRifle() {
		super("sniper rifle", 'S', 15, "clubs");
	}
	/**
	 * The tick method is used to determine whether the concentration of an actor
	 * holding the sniper rifle is broken. 
	 */
	@Override
	public void tick(Location currentLocation, Actor actor) {
		Display display=new Display();
		//concentration broken if taking damage
		try {
			if(aim_turns>=1&&actor.damaged()) {
				reset();
				display.println(actor+" concentration was broken due to receiving damage!");
			}
		}
		catch(NullPointerException e){
			return;
		}
		//concentration broken if taking other action
		try {
			if(aim_turns>=1&&actor.get_lastAction().isSniperAction());
		}
		catch(NullPointerException e){
			reset();
			display.println(actor+" concentration was broken due to taking an action other than aiming and firing.");
		}
		
		super.allowableActions.clear();
		super.allowableActions.add(new TargetMenuAction(this));
	}
	
	@Override
	public void tick(Location currentLocation) {
		super.allowableActions.clear();
		//broken concentration if sniper is dropped. 
		reset();
	}
	@Override
	public String craft(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String craftDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isFood() {
		return null;
	}

	@Override
	public Boolean isWeapon() {
		return true;
	}

	
	@Override
	public void setTarget(Actor actor) {
		target=actor;
	}
	
	@Override
	public Actor target() {
		return target;
	}
	
	@Override
	public void set_aim_turns(int count) {
		aim_turns=count;
	}
	
	@Override
	public int aim_turns() {
		return aim_turns;
	}
	
	@Override
	public void reset() {
		aim_turns=0;
		target=null;
	}

	@Override
	public int ranged_damage() {
		return ranged_damage;
	}

	@Override
	public void use_ammo(Actor actor) {
		if(actor.get_sniper_ammo()>0) {
			int count=actor.get_sniper_ammo()-1;
			actor.set_sniper_ammo(count);
		}
	}

	@Override
	public int range() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean isGun() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String secondary_verb() {
		// TODO Auto-generated method stub
		return "snipes";
	}
}
