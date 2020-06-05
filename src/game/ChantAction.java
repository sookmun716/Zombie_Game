package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ChantAction extends Action{
	private Random random= new Random();
	@Override
	public String execute(Actor actor, GameMap map) {
		int zombie_count=0;
		int x;
		int y;
		while(zombie_count<5) {
			x=random.nextInt(map.getXRange().max());
			y=random.nextInt(map.getYRange().max());
			
			while(map.at(x, y).containsAnActor()) {
				x=random.nextInt(map.getXRange().max());
				y=random.nextInt(map.getYRange().max());
			}
			map.at(x, y).addActor(new Zombie("Mambo Zombie"));
			zombie_count+=1;
		}
		
		return actor+" performed a chanting action to spawn zombies!";
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
