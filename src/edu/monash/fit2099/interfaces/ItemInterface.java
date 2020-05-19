package edu.monash.fit2099.interfaces;

import edu.monash.fit2099.engine.Actor;

/**
 * This interface provides the ability to add methods to Item, without modifying code in the engine,
 * or downcasting references in the game.   
 */
public interface ItemInterface {
	public String craft(Actor actor);
	public String craftDescription(Actor actor);
}
