package game;

import java.util.Random;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * A subclass of Item that represents an Corpse.
 * 
 * @author Tan Song Shun
 *
 */
public class Corpse extends Item {
	protected Random random = new Random();
	private String actor_name;
	private Actor actor;
	private int deadTurns = 0;

	/**
	 * This is the constructor for the ZombieClub class.
	 * 
	 * @param actor Represent the actor that is killed
	 */
	public Corpse(Actor actor) {
		super("dead " + actor, '%', false);
		this.actor = actor;
		actor_name = this.name.split(" ")[1];
	}

	/**
	 * This method overrides the tick method from Item class and is called in every
	 * turn, in this case it tracks the turns a Corpse is created and reanimate the
	 * corpse if the conditions are met
	 * 
	 * @param currentLocation Location of the Corpse.
	 * 
	 **/

	@Override
	public void tick(Location currentLocation) {
		// if actor is human proceed with resurrection.
		if (actor.hasCapability(ZombieCapability.UNDEAD)) {
			return;
		}
		deadTurns += 1;
		// if deadTurns more than 5, the corpse has a 25 percent chance to
		// rise up as a corpse
		if (deadTurns >= 5 && random.nextInt(101) >= 75) {
			System.out.println(actor_name + " has risen as a zombie!");
			currentLocation.addActor(new Zombie(actor_name));
			currentLocation.removeItem(this);
		}
		// guaranteed to rise from the dead if the dead turns reach 10
		else if (deadTurns == 10) {
			System.out.println(actor_name + " has risen as a zombie!");
			currentLocation.addActor(new Zombie(actor_name));
			currentLocation.removeItem(this);
		}

	}
	
	@Override
	public String craft(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String craftDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}
}
