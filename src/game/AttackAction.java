package game;

import java.util.Random;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;
import game.Zombie;

/**
 * Special Action for attacking other Actors.
 */
public class AttackAction extends Action {

	/**
	 * The Actor that is to be attacked
	 */
	protected Actor target;
	/**
	 * Random number generator
	 */
	protected Random rand = new Random();

	/**
	 * Constructor.
	 * 
	 * @param target the Actor to attack
	 */
	public AttackAction(Actor target) {
		this.target = target;
	}

	@Override
	public String execute(Actor actor, GameMap map) {

		Weapon weapon = actor.getWeapon();

		if (rand.nextBoolean()) {
			return actor + " misses " + target + ".";
		}

		int damage = weapon.damage();
		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
		target.hurt(damage);
		
		//dropArm and dropLeg to be in False, When Zombie has to drop then set it to True
		Boolean dropArm = Boolean.FALSE;
		Boolean dropLeg = Boolean.FALSE;
		
		//if target receive damage
		if (target.isConscious()) {
			//check if the target is Zombie
			if(target.hasCapability(ZombieCapability.UNDEAD)) {
				//25% of dropping limbs
				if(Math.random()<0.25) {
					//if zombie's arm and leg is not 0 , it can drop either arm or leg
					if(target.getArm()!=0 && target.getLeg()!=0) {
						//set 50% of dropping arm and leg if Zombie has both
						if(Math.random()<0.5) {
							dropArm = Boolean.TRUE;
						}
						else {
							dropLeg = Boolean.TRUE;
							}
					}
					//if zombie dropped both leg then it can only drop arm
					else if (target.getArm()!=0 && target.getLeg()==0) {
						dropArm = Boolean.TRUE;
					}
					//if zombie drop both arm it can only drop leg
					else if (target.getLeg()!=0 && target.getArm()==0) {
						dropLeg = Boolean.TRUE;
					}
				}
			}
			//check if zombie has drop it's arm
			if (dropArm == Boolean.TRUE) {
				target.dropArm(1);
				//add new ZombieArm at target's location
				map.locationOf(target).addItem(new ZombieArm());
				//check if zombie has dropped 2 arm
				if (target.getArm()==0){
					//if zombie has dropped 2 arms then drop item from it's inventory to the map
					Actions dropActions = new Actions();
					for (Item item : target.getInventory())
						dropActions.add(item.getDropAction());
					for (Action drop : dropActions)		
						drop.execute(target, map);
				}
				result += System.lineSeparator() + target + " drops an Arm.";
			}
			//check if zombie has drop it's leg
			else if (dropLeg == Boolean.TRUE) {
				target.dropLeg(1);
				//add new ZombieLeg at target's location
				map.locationOf(target).addItem(new ZombieLeg());
				result += System.lineSeparator() + target + " drops a Leg.";
			}
		}
		else if (!target.isConscious()) {
			Corpse corpse = new Corpse(target);
			map.locationOf(target).addItem(corpse);
			
			Actions dropActions = new Actions();
			for (Item item : target.getInventory())
				dropActions.add(item.getDropAction());
			for (Action drop : dropActions)		
				drop.execute(target, map);
			map.removeActor(target);	
			
			result += System.lineSeparator() + target + " is killed.";
		}
		
		return result;
	}
		

	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target;
	}
}
