package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;

public class ShotgunAmmunitionBox extends PortableItem{
	public ShotgunAmmunitionBox() {
		super("Shotgun Ammunition Box", 'b');
	}
	
	@Override
	public void tick(Location currentLocation, Actor actor) {
		actor.add_shotgun_ammo(5);
		actor.removeItemFromInventory(this);
	}

}
