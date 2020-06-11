package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;

public class endGame extends World{

	private String Message;

	public endGame(Display display) {
		super(display);
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		if (player == null)
			throw new IllegalStateException();

		// initialize the last action map to nothing actions;
		for (Actor actor : actorLocations) {
			lastActionMap.put(actor, new DoNothingAction());
		}

		// This loop is basically the whole game
		while (stillRunning()) {
			GameMap playersMap = actorLocations.locationOf(player).map();
			playersMap.draw(display);

			// Process all the actors.
			for (Actor actor : actorLocations) {
				if (stillRunning())
					processActorTurn(actor);
			}

			// Tick over all the maps. For the map stuff.
			for (GameMap gameMap : gameMaps) {
				gameMap.tick();
			}

		}
		display.println(endGameMessage());
	}
	
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
