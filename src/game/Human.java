package game;

import java.util.ArrayList;
import java.util.Arrays;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * Class representing an ordinary human.
 * 
 * 
 * @author ram
 *
 */
public class Human extends ZombieActor {
	//EatFoodBehaviour has priority to ensure humans eat food when they are hurt
	protected ArrayList<Behaviour> behaviour = new ArrayList<Behaviour>(
			Arrays.asList(new EatFoodBehaviour(),new WanderBehaviour())); 
	
	//number of ammunition currently carried by a human/player
	private int shotgun_ammo=0;
	private int sniper_ammo=0;

	/**
	 * The default constructor creates default Humans
	 * 
	 * @param name the human's display name
	 */
	public Human(String name) {
		super(name, 'H', 50, ZombieCapability.ALIVE);
	}
	
	/**
	 * The protected constructor can be used to create subtypes
	 * of Human, such as the Player
	 * 
	 * @param name the human's display name
	 * @param displayChar character that will represent the Human in the map 
	 * @param hitPoints amount of damage that the Human can take before it dies
	 */
	protected Human(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints, ZombieCapability.ALIVE);
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// FIXME humans are pretty dumb, maybe they should at least run away from zombies?
		for (Behaviour behaviour : behaviour) {
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

	@Override
	public void dropArm(int Arm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropLeg(int Leg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getArm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLeg() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_shotgun_ammo() {
		return shotgun_ammo;
	}
	
	@Override
	public int get_sniper_ammo() {
		return sniper_ammo;
	}
	
	@Override
	public void set_shotgun_ammo(int count) {
		shotgun_ammo=count;
	}
	
	@Override
	public void set_sniper_ammo(int count) {
		sniper_ammo=count;
	}

	@Override
	public int get_turn_count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Action get_lastAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_previous_health() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean damaged() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String create_corpse(GameMap map) {
		 if (!this.isConscious()) {
				Corpse corpse = new Corpse(this);
				map.locationOf(this).addItem(corpse);
				
				Actions dropActions = new Actions();
				for (Item item : this.getInventory())
					dropActions.add(item.getDropAction());
				for (Action drop : dropActions)		
					drop.execute(this, map);
				map.removeActor(this);	
				
				return System.lineSeparator() + this + " is killed.";
		}
		 return "";
			
	}

	@Override
	public int chant_round() {
		// TODO Auto-generated method stub
		return 0;
	}

}
