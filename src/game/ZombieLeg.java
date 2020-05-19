package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponItem;

public class ZombieLeg extends WeaponItem{
	
	public ZombieLeg() {
		super("zombie leg",'L',25,"hits");
		this.allowableActions.add(new CraftWeaponAction(this));
	}


	@Override
	public String transform(Actor actor) {
		actor.addItemToInventory(new ZombieMace());
		actor.removeItemFromInventory(this);
		return actor + "crafted a zombie mace";
	}


	@Override
	public String craftDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " crafts zombie mace";
	}
}