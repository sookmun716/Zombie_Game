package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;

public class SniperAmmunitionBox extends PortableItem{
	private int ammo_count=5;
	public SniperAmmunitionBox() {
		super("Sniper Ammunition Box", 'B');
	}
	
	@Override
	public void tick(Location currentLocation, Actor actor) {
		int count=actor.get_sniper_ammo()+ammo_count;
		actor.set_sniper_ammo(count);
		actor.removeItemFromInventory(this);
	}


}
