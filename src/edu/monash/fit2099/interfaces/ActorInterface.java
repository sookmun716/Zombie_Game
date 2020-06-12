package edu.monash.fit2099.interfaces;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.GameMap;

/**
 * This interface provides the ability to add methods to Actor, without modifying code in the engine,
 * or downcasting references in the game.   
 */

public interface ActorInterface {
	/**
	 * Accessor of hitPoints 
	 * @return integer that represents the actor's current hit points
	 */
	public int getHp();
	/**
	 * Accessor of maxHitPoints 
	 * @return integer that represents the actor's maximum hit points
	 */
	public int getMaxHp();
	/**
	 * This method drop arm of zombie
	 * @param Arm integer that represent the number of arms of the zombie
	 */
	public void dropArm(int Arm);
	/**
	 This method drop leg of zombie
	 * @param Leg integer that represent the number of legs of the zombie
	 */
	public void dropLeg(int Leg);
	/**
	 *Getter for zombie Arm.
	 * @return number of arm(s) of the zombie
	 */
	public int getArm();
	/**
	 *Getter for zombie Leg.
	 * @return number of leg(s) of the zombie
	 */
	public int getLeg();
	/**
	 * Setter for the sniper_ammunition_count.
	 * @param count 
	 */
	public void set_sniper_ammo(int count);
	/**
	 * Getter for sniper_ammuntion_count.
	 * @return number of sniper rifle ammunition a player is carrying.
	 */
	public int get_sniper_ammo();
	/**
	 * Setter for the shotgun_ammunition_count.
	 * @param count 
	 */
	public void set_shotgun_ammo(int count);
	/**
	 * Getter for shotgun_ammuntion_count.
	 * @return number of shotgun ammunition a player is carrying.
	 */
	public int get_shotgun_ammo();
	/**
	 * This method returns the number of turns Mambo Marie had appeared on the map
	 * @return the number of turns Mambo Marie had appeared on the map
	 */
	public int get_turn_count();
	/**
	 * This method returns the last action performed by an actor
	 * @return the last action performed by an actor
	 */
	public Action get_lastAction();
	/**
	 * This method set the current health of an actor in this turn
	 */
	public void set_previous_health();
	/**
	 * This method determines whether an actor is damaged in the previous round,
	 * it is used to check concentration of a player when aiming with a sniper
	 * rifle
	 * @return true if player is damaged and false otherwise.
	 */
	public Boolean damaged();
	/**
	 * This method removes an actor and creates a corpse at the actor location when
	 * the actor is killed.
	 * @param map The GameMap the actor is currently in
	 * @return String that shows that an actor is killed or empty String if actor is not killed.
	 */
	public String create_corpse(GameMap map);
	/**
	 * This method returns the CHANT_ROUND constant
	 * @return CHANT_ROUND
	 */
	public int chant_round();
}
