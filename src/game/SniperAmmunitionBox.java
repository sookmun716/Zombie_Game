package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;

public class SniperAmmunitionBox extends PortableItem{

	public SniperAmmunitionBox() {
		super("Sniper Ammunition Box", 'B');
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tick(Location currentLocation, Actor actor) {
		actor.add_sniper_ammo(5);
		actor.removeItemFromInventory(this);
	}


}
