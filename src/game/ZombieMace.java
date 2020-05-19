package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponItem;
/**
 * A subclass of WeaponItem that represents an zombie mace.
 * 
 * @author Tan Song Shun
 *
 */
public class ZombieMace extends WeaponItem {
	/**
	 * This is the constructor for the ZombieMace class, the super constructor is
	 * called to instantiate the object.
	 * 
	 */
	public ZombieMace() {
		super("zombie mace",'M',35, "smashes" );
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
