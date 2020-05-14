package game;

import edu.monash.fit2099.engine.WeaponItem;

public class ZombieLeg extends WeaponItem{
	
	public ZombieLeg() {
		super("zombie leg",'L',25,"hits");
		this.allowableActions.add(new CraftWeaponAction(this));
	}
}