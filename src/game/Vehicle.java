package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class Vehicle extends Item {


	public Vehicle(String name, char displayChar, boolean portable) {
		super(name, displayChar, portable);
		}

	public void addAction(Action newAction) {
		this.allowableActions.add(newAction);
	}
	
	@Override
	public String craft(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String craftDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isFood() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isWeapon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeMap(GameMap map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTarget(Actor actor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Actor getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_aim_turns(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get_aim_turns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getRangedDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
