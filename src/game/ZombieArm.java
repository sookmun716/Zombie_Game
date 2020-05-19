package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponItem;

public class ZombieArm extends WeaponItem{
	
	public ZombieArm() {
		super("zombie arm",'A',20,"hits");
		this.allowableActions.add(new CraftWeaponAction(this));
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
}
