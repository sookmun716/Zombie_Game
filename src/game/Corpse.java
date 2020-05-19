package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * A subclass of Item that represents an Corpse.
 * 
 * @author Tan Song Shun
 *
 */
public class Corpse extends PortableItem {
	protected Random random = new Random();
	private String actor_name;
	private Actor deadActor;
	private int deadTurns = 0;

	/**
	 * This is the constructor for the ZombieClub class.
	 * 
	 * @param actor Represent the actor that is killed
	 */
	public Corpse(Actor actor) {
		super("dead " + actor, '%');
		this.deadActor = actor;
		actor_name = this.name.split(" ")[1];
	}

	/**
	 * This method overrides the tick method from PortableItem class and is called in every
	 * turn, in this case it tracks the turns a Corpse is created and reanimate the
	 * corpse if the conditions are met.
	 * 
	 * @param currentLocation Location of the Corpse.
	 * 
	 **/

	@Override
	public void tick(Location currentLocation) {
		// if actor is human proceed with resurrection.
		if (deadActor.hasCapability(ZombieCapability.UNDEAD)) {
			return;
		}
		deadTurns += 1;
		System.out.println(deadActor+" dead for "+deadTurns+" turns.");
		//cannot resurrect if there is an actor standing on the location
		if(currentLocation.containsAnActor()) {
			return;
		}
		
		// if deadTurns more than 5, the corpse has a 25 percent chance to
		// rise up as a corpse
		if (deadTurns >= 5 && random.nextInt(101) >= 75) {
			System.out.println(actor_name + " has risen as a zombie!");
			currentLocation.addActor(new Zombie(actor_name));
			currentLocation.removeItem(this);
			
		}
		// guaranteed to rise from the dead if the dead turns reach 10
		else if (deadTurns >= 10) {
			System.out.println(actor_name + " has risen as a zombie!");
			currentLocation.addActor(new Zombie(actor_name));
			currentLocation.removeItem(this);
		}

	}
	
	@Override
	public void tick(Location currentLocation,Actor actor) {
		// if actor is human proceed with resurrection.
		if (deadActor.hasCapability(ZombieCapability.UNDEAD)) {
			return;
		}
		deadTurns += 1;
		System.out.println(deadActor+" dead for "+deadTurns+" turns.");
		ArrayList<Location> locations= new ArrayList<Location>();
		//check exits around actor carrying the corpse to get valid exits for zombie to rise up
		for (Exit exit : currentLocation.getExits()) {
			Location destination = exit.getDestination();
			if (destination.canActorEnter(actor)) {
				locations.add(destination);
			}
		}
		Location spawn_point;
		if (!locations.isEmpty()) {
			spawn_point=locations.get(random.nextInt(locations.size()));
		}
		//quit method if no available location for zombie to spawn
		else {
			return;
		}
		// if deadTurns more than 5, the corpse has a 25 percent chance to
		// rise up as a corpse
		if (deadTurns >= 5 && random.nextInt(101) >= 75) {
			System.out.println(actor_name + " has risen as a zombie!");
			spawn_point.addActor(new Zombie(actor_name));
			actor.removeItemFromInventory(this);;
					
		}
		// guaranteed to rise from the dead if the dead turns reach 10
		else if (deadTurns == 10) {
			System.out.println(actor_name + " has risen as a zombie!");
			spawn_point.addActor(new Zombie(actor_name));
			actor.removeItemFromInventory(this);;
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

	@Override
	public Boolean isFood() {
		// TODO Auto-generated method stub
		return null;
	}
}
