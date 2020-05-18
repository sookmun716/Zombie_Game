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
		
		if (target.isConscious()) {
			if(target.hasCapability(ZombieCapability.UNDEAD)) {
				if(Math.random()<0.25) {
					if(target.getArm()!=0 || target.getLeg()!=0) {
						if(Math.random()<0.5) {
							target.dropArm(1);
							map.locationOf(target).addItem(new ZombieArm());
							result += System.lineSeparator() + target + " drops an Arm.";
						}
						else {
							target.dropLeg(1);
							map.locationOf(target).addItem(new ZombieLeg());
							result += System.lineSeparator() + target + " drops a Leg.";
						}
					}
					else if (target.getArm()!=0 && target.getLeg()==0) {
						target.dropArm(1);
						map.locationOf(target).addItem(new ZombieArm());
						result += System.lineSeparator() + target + " drops an Arm.";
					}
					else if (target.getLeg()!=0 && target.getArm()==0) {
						target.dropLeg(1);
						map.locationOf(target).addItem(new ZombieLeg());
						result += System.lineSeparator() + target + " drops a Leg.";
					}
				}
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
