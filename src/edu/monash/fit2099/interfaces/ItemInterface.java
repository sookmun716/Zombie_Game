package edu.monash.fit2099.interfaces;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
/**
 * This interface provides the ability to add methods to Item, without modifying code in the engine,
 * or downcasting references in the game.   
 */
public interface ItemInterface {
	/**
	 * Method that turns a weapon into another weapon
	 * @param actor actor that is holding the weapon
	 * @return a String that represents the action that had been carried out
	 */
	public String craft(Actor actor);
	
	/**
	 * Method that returns a description of the action that can be carried out
	 * @param actor actor that is holding the weapon
	 * @return a String that represents the action that can be carried out
	 */
	public String craftDescription(Actor actor);
	
	public Boolean isFood();
	
	/**
	 * Method that returns a Boolean to determine if the Item is a weapon.
	 * @return Boolean to determine if the Item is weapon
	 */
	public Boolean isWeapon();
	/**
	 * setter method for the target of a sniper rifle
	 * @param actor Actor that represents the target of a sniper rifle. 
	 */
	public void setTarget(Actor actor);
	/**
	 * getter method for the target of a sniper rifle
	 * @return Actor that represents the target of a sniper rifle.
	 */
	public Actor target();
	/**
	 * setter for the aim_turns instance variable that represents the number of
	 * turns spent aiming with a sniper rifle
	 * @param count integer to be passed as the number of turns spent aiming
	 */
	public void set_aim_turns(int count);
	/**
	 * getter method for aim_turns
	 * @return integer that represents number of turns spent aiming 
	 */
	public int aim_turns();
	/**
	 * This method resets the concentration and target of a sniper rifle,
	 * this method is called when concentration is broken.
	 */
	public void reset() ;
	/**
	 * This method returns the range damage of a gun
	 * @return integer that represents the damage of a gun when it is fired.
	 */
	public int ranged_damage();
	/**
	 * This method reduces ammunition count when a gun is fired.
	 * @param actor Actor that is firing the gun
	 */
	public void use_ammo(Actor actor);
	/**
	 * This method returns the range of a gun
	 * @return integer that represents the range of a gun
	 */
	public int range();
	/**
	 * This method will indicate whether an Item is a firearm
	 * @return true if Item is a firearm and false otherwise.
	 */
	public Boolean isGun();
	/**
	 * This method returns the verb when a gun is fired.
	 * @return String that represents the verb when a gun is fired.
	 */
	public String secondary_verb();
}
