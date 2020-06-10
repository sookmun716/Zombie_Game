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
		boolean humanExist = false;
		boolean zombieExist = false;
		for(Actor actor : actorLocations) {
			if(humanExist && zombieExist) {
				break;
			}
			if(!actor.hasCapability(ZombieCapability.PLAYER)) {
				if(actor.hasCapability(ZombieCapability.ALIVE)) {
					humanExist = true;
				}
			}
			else if(actor.hasCapability(ZombieCapability.UNDEAD)) {
				zombieExist = true;
			}
			
		}
		if(!zombieExist) {
			Message = "Player won! Zombie and MamboMarie have been wiped out.";
			return false;
		}
		
		else if(actorLocations.contains(player)) {
			if (humanExist) {
				return true;
			}
			else{
				Message = "Game Over! All human dead.";
				return false;
			}
			
		}
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
