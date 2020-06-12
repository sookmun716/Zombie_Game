package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;
/**
 * A subclass of PortableItem that represents a sniper ammunition box.
 * 
 * @author Tan Song Shun
 *
 */
public class SniperAmmunitionBox extends PortableItem{
	//number of ammunition in a sniper ammunition box.
	private int ammo_count=5;
	
	public SniperAmmunitionBox() {
		super("Sniper Ammunition Box", 'B');
	}
	/**
	 * If ammunition box is in inventory, remove the ammuniton box
	 * and add to the total sniper ammunition the player is carrying.
	 */
	@Override
	public void tick(Location currentLocation, Actor actor) {
		int count=actor.get_sniper_ammo()+ammo_count;
		actor.set_sniper_ammo(count);
		actor.removeItemFromInventory(this);
	}


}
