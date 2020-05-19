package game;

import edu.monash.fit2099.engine.Actor;
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
}
