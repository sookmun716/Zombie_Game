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
	public void dropArm(int Arm);
	public void dropLeg(int Leg);
	public int getArm();
	public int getLeg();
	public void set_sniper_ammo(int count);
	public int get_sniper_ammo();
	public void set_shotgun_ammo(int count);
	public int get_shotgun_ammo();
	public int get_turn_count();
	public Action get_lastAction();
	public void set_previous_health();
	public Boolean damaged();
	public String isDead(GameMap map);
	
}
