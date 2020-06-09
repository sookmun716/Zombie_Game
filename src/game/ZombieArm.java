package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

/**
 * A subclass of WeaponItem that represents ZombieArm Arm will be dropped by
 * zombie and picked up by Zombie or Player. It has damage of 20 and verb of
 * "hits". Dropped arm can be crafted into Zombie Club by Player after Player
 * picks up.
 * 
 * @author SookMun
 *
 */

public class ZombieArm extends WeaponItem {
	CraftWeaponAction crafting_action = new CraftWeaponAction(this);

	/**
	 * This is the constructor for the ZombieArm class, the super constructor is
	 * called to instantiate the object.
	 */
	public ZombieArm() {
		super("zombie arm", 'A', 200, "hits");
	}

	@Override
	public void tick(Location currentLocation) {
		if (this.getAllowableActions().contains(crafting_action)) {
			// remove crafting action if limb on ground
			this.allowableActions.remove(crafting_action);
		}
	}

	@Override
	public void tick(Location currentLocation, Actor actor) {
		this.allowableActions.remove(crafting_action);
		this.allowableActions.add(crafting_action);
	}

	@Override
	public String craft(Actor actor) {
		actor.addItemToInventory(new ZombieClub());
		actor.removeItemFromInventory(this);
		return actor + "crafted a zombie club";
	}

	@Override
	public String craftDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " crafts zombie club";
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
