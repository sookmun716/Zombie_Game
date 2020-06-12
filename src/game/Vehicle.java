package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * A subclass of Item that represents vehicle. 
 * Player can use vehicle to move across maps. 
 * Vehicle is not a portableItem.
 * @author SookMun
 *
 */
public class Vehicle extends Item {

	/**
	 * This is the constructor for the Vehicle class, the super constructor is
	 * called to instantiate the object.
	 */
	public Vehicle() {
		super("train",'T',false);
		}

	public void addAction(Action newAction) {
		this.allowableActions.add(newAction);
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

	@Override
	public Boolean isWeapon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTarget(Actor actor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Actor target() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_aim_turns(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int aim_turns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int ranged_damage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void use_ammo(Actor actor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int range() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean isGun() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String secondary_verb() {
		// TODO Auto-generated method stub
		return null;
	}

}
