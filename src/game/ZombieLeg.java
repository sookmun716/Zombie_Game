package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

/**
 * A subclass of WeaponItem that represents ZombieLeg
 * Leg will be dropped by zombie and picked up by Zombie or Player.
 * It has damage of 25 and verb of "hits".
 * Dropped leg can be crafted into Zombie Mace by Player after Player picks up.
 * @author SookMun
 *
 */

public class ZombieLeg extends WeaponItem{
	CraftWeaponAction crafting_action= new CraftWeaponAction(this);
	public ZombieLeg() {
		super("zombie leg",'L',25,"hits");
		this.allowableActions.add(new CraftWeaponAction(this));
	}

	@Override
	public void tick(Location currentLocation) {
		if(this.getAllowableActions().contains(crafting_action)) {
			//remove crafting action if limb on ground
			this.allowableActions.remove(crafting_action);
		}
	}
	
	@Override
	public void tick(Location currentLocation, Actor actor) {
		this.allowableActions.add(crafting_action);
	}
	@Override
	public String craft(Actor actor) {
		actor.addItemToInventory(new ZombieMace());
		actor.removeItemFromInventory(this);
		return actor + "crafted a zombie mace";
	}


	@Override
	public String craftDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " crafts zombie mace";
	}


	@Override
	public Boolean isFood() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Boolean isWeapon() {
		return Boolean.TRUE;
	}
}