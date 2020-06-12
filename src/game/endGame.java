package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.World;

/**
 * A subclass of World that represents the ending of game.
 * @author SookMun
 *
 */
public class endGame extends World{

	private String Message;

	/**
	 * constructor for the endGame class
	 * @param display the Display that will display this World.
	 */
	public endGame(Display display) {
		super(display);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Returns true if the game is still running.
	 * The game is considered to still be running if the player is still around.
	 * The game will end when all the human is dead or all zombie and mambo marie is dead. 
	 * @return true if the player is still on the map, false if the game ends
	 */
	@Override
	protected boolean stillRunning() {
		//create boolean to check if human and zombie still exist in the map.
		boolean humanExist = false;
		boolean zombieExist = false;
		for(Actor actor : actorLocations) {
			if(humanExist && zombieExist) {
				break;
			}
			//if actor is human and it's not player then human exists
			if(actor.hasCapability(ZombieCapability.ALIVE) && actor.getDisplayChar() != '@') {
				humanExist = true;
				}
			//if actor is zombie then zombie exists
			if(actor.hasCapability(ZombieCapability.UNDEAD)) {
				zombieExist = true;
			}
			
		}
		//return false when all zombie has been killed.
		if(zombieExist == false) {
			Message = "Player won! Zombie and MamboMarie have been wiped out.";
			return false;
		}
		
		//return false when all human is dead and return true if there are still human in the map
		else if(actorLocations.contains(player)) {
			if (humanExist == false) {
				Message = "Game Over! All human dead.";
				return false;
			}
			else{
				return true;
			}
			
		}
		//if player is dead then return false.
		else {
			Message = "Game Over! Player is dead.";
			return false;
		}
		
	}
	
	@Override
	protected String endGameMessage() {
		return Message;
	}
	
}
