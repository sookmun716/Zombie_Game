package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.WeaponItem;

/**
 * A subclass of WeaponItem that represents an zombie club.
 * 
 * @author Tan Song Shun
 *
 */

public class ZombieClub extends WeaponItem {
	/**
	 * This is the constructor for the ZombieClub class, the super constructor is
	 * called to instantiate the object.
	 * 
	 */

	public ZombieClub() {
		super("zombie club", 'C', 30, "smacks");
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
		// TODO Auto-generated method stub
		return null;
	}
	
	public Boolean isWeapon() {
		return Boolean.TRUE;
	}

	@Override
	public void setTarget(Actor actor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Actor target() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_aim_turns(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int aim_turns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int ranged_damage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void use_ammo(Actor actor) {
		// TODO Auto-generated method stub
		
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
		return null;
	}
}
