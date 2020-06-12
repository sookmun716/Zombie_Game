package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;
/**
 * A subclass of PortableItem that represents a shotgun ammunition box.
 * 
 * @author Tan Song Shun
 *
 */
public class ShotgunAmmunitionBox extends PortableItem{
	private int ammo_count=5;
	public ShotgunAmmunitionBox() {
		super("Shotgun Ammunition Box", 'b');
	}
	
	/**
	 * If ammunition box is in inventory, remove the ammuniton box
	 * and add to the total shotgun ammunition the player is carrying.
	 */
	@Override
	public void tick(Location currentLocation, Actor actor) {
		int count=actor.get_shotgun_ammo()+ammo_count;
		actor.set_shotgun_ammo(count);
		actor.removeItemFromInventory(this);
	}

}
