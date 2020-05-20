package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

public class ZombieArm extends WeaponItem {
	CraftWeaponAction crafting_action = new CraftWeaponAction(this);

	public ZombieArm() {
		super("zombie arm", 'A', 20, "hits");
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
}
