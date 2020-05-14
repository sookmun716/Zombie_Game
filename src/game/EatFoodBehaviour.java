package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class EatFoodBehaviour implements Behaviour{

	@Override
	public Action getAction(Actor actor, GameMap map) {
		for(Item item : map.locationOf(actor).getItems()) {
			//if location contains food humans can eat it
			if(item instanceof Food) {
				Food food=(Food) item;
				Human human= (Human) actor;
				//only eat food when human is hurt
				if(human.getMaxHp()==human.getHp()) {
					return null;
				}
				return new EatAction(food);
			}
		}
		return null;
			
	}

}
