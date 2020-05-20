package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.IntrinsicWeapon;
import edu.monash.fit2099.engine.MoveActorAction;

/**
 * A Zombie.
 * 
 * This Zombie is pretty boring.  It needs to be made more interesting.
 * 
 * @author ram
 *
 */
public class Zombie extends ZombieActor {
	private int numArm = 2;
	private int numLeg = 2;
	
	private Behaviour[] behaviours = {
			new PickUpBehaviour(),
			new AttackBehaviour(ZombieCapability.ALIVE),
			new HuntBehaviour(Human.class, 10),
			new WanderBehaviour()
	};

	public Zombie(String name) {
		super(name, 'Z', 100, ZombieCapability.UNDEAD);
	}
	
	/**
	 * method for zombie to drop arm.
	 * If numArm == 0 where it already dropped 2 arms then it can't drop any as Zombie has only 2 arms.
	 */
	public void dropArm(int Arm) {
		if (numArm>0) {
			numArm -= Arm;
		}
	}
	
	/**
	 * method for zombie to drop leg.
	 * If numleg == 0 where it already dropped 2 legs then it can't drop any as Zombie has only 2 legs.
	 */
	public void dropLeg(int Leg) {
		if (numLeg>0) {
			numLeg -= Leg;
		}
	}
	
	/**
	 * method to return the number of arm of zombie.
	 */
	public int getArm() {
		return this.numArm;
	}
	
	/**
	 * method to return the number of leg of zombie.
	 */
	public int getLeg() {
		return this.numLeg;
	}

	@Override
	public IntrinsicWeapon getIntrinsicWeapon() {
		//set 30% probability for zombie bites
		if(Math.random()<0.3) {
			return getBite();
		}
		else {
			return new IntrinsicWeapon(15,"punches");
		}
	}
	/**
	 * Zombie can bite human with damage 20 , verb "bites".
	 * After Zombie bites, it heals 5 health point. 
	 */
	
	public IntrinsicWeapon getBite() {
		this.heal(5);
		return new IntrinsicWeapon(20, "bites");
	}
	
	/**
	 * Before Zombie attack, it has a 10% chance of shouting "BRAAAAAAAINS!" but this will not take an action.
	 * If a Zombie can attack, it will.  If not, it will chase any human within 10 spaces.  
	 * If no humans are close enough it will wander randomly.
	 * 
	 * @param actions list of possible Actions
	 * @param lastAction previous Action, if it was a multiturn action
	 * @param map the map where the current Zombie is
	 * @param display the Display where the Zombie's utterances will be displayed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		if (Math.random()<0.1) {
			System.out.println(this.name + " shout BRAAAAAAAINS!");
		}
		for (Behaviour behaviour : behaviours) {
			boolean hunt = HuntBehaviour.class.isInstance(behaviour);
			boolean wander = WanderBehaviour.class.isInstance(behaviour);
			
			if (hunt || wander) {
				if(this.numLeg==0) {
					continue;
				}
				else if (this.numLeg==1 && MoveActorAction.class.isInstance(lastAction)) {
					continue;
				}
			}
			Action action = behaviour.getAction(this, map);
			if (action != null)
				return action;
				
		}
		return new DoNothingAction();	
	}
	@Override
	public int getHp() {
		return this.hitPoints;
	}

	@Override
	public int getMaxHp() {
		return this.maxHitPoints;
	}
}