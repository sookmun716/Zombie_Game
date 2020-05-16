package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.WeaponItem;

public class CraftWeaponAction extends Action{
	private WeaponItem weapon;
	
	public CraftWeaponAction(WeaponItem weapon) {
		this.weapon = weapon;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		
		if(weapon.getDisplayChar()=='A') {
			actor.addItemToInventory(new ZombieClub());
			actor.removeItemFromInventory(weapon);
			return actor+"crafted a zombie club";
		}
		else if(weapon.getDisplayChar()=='L') {
			actor.addItemToInventory(new ZombieMace());
			actor.removeItemFromInventory(weapon);
			return actor+"crafted a zombie mace";
		}
		else {
			return null;
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		if(weapon instanceof ZombieArm) {
			return actor+" crafts zombie club";
		}
		else if(weapon instanceof ZombieLeg) {
			return actor+" crafts zombie mace";
		}
		return null;
	}
}
