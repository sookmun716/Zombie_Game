package edu.monash.fit2099.interfaces;

/**
 * This interface provides the ability to add methods to Action, without modifying code in the engine,
 * or downcasting references in the game.   
 */
public interface ActionInterface {
	/**
	 * This method is used to determine whether an action performed by an actor
	 * is aiming or firing with a sniper rifle
	 * 
	 * @return true if the Action is aiming or firing with sniper rifle
	 */
	public Boolean isSniperAction();
}
