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
	public void changeMap(GameMap map);
	public void setTarget(Actor actor);
	public Actor getTarget();
	public void set_aim_turns(int count);
	public int get_aim_turns();
	public void reset() ;
	public int getRangedDamage();
}
