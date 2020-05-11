package game;

import java.util.Random;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class Corpse extends Item{
	protected Random random = new Random();
	private String actor_name;
	private Actor actor;
	private int deadTurns=0;
	
	public Corpse(Actor actor) {
		super("dead "+ actor, '%', false);
		this.actor=actor;
		actor_name=super.name.split(" ")[1];
	}
	
	@Override
	public void tick(Location currentLocation) {
		deadTurns+=1;
		System.out.println(actor_name+" dead for "+deadTurns);
		//if deadTurns more than 5 and the corpse has a 25 percent chance to
		//rise up as a corpse
		if(deadTurns>=5 && random.nextInt(101)>=75 && actor instanceof Human ) {
			System.out.println(actor_name+ " has risen as a zombie!");
			currentLocation.addActor(new Zombie(actor_name));
			currentLocation.removeItem(this);
		}
		//guaranteed to rise from the dead if the dead turns reach 10
		else if(deadTurns==10 && actor instanceof Human ) {
			System.out.println(actor_name+ " has risen as a zombie!");
			currentLocation.addActor(new Zombie(actor_name));
			currentLocation.removeItem(this);
		}
		
	}
}
