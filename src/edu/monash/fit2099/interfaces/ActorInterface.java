package edu.monash.fit2099.interfaces;

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
}
