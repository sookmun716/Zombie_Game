package game;

import edu.monash.fit2099.engine.WeaponItem;

public class ZombieArm extends WeaponItem{
	
	public ZombieArm() {
		super("zombie arm",'A',20,"hits");
		this.allowableActions.add(new CraftWeaponAction(this));
	}
}
