package edu.monash.fit2099.demo.mars;

import java.util.*;

import game.Behaviour;
import edu.monash.fit2099.engine.*;


public class Bug extends Actor {

	private Random rand = new Random();
	public List<Behaviour> actionFactories = new ArrayList<Behaviour>();

	public Bug() {
		super("Feature", 'x', 1);
	}
	
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		for (Behaviour factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		return actions.get(rand.nextInt(actions.size()));
	}

	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions list = super.getAllowableActions(otherActor, direction, map);
		list.add(new KickAction(this));
		return list;
	}

	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(1, "stings");
	}

	@Override
	public int getHp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxHp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void dropArm(int Arm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropLeg(int Leg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getArm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLeg() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void set_sniper_ammo(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get_sniper_ammo() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int get_shotgun_ammo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void set_shotgun_ammo(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get_turn_count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Action get_lastAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_previous_health() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean damaged() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String create_corpse(GameMap map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int chant_round() {
		// TODO Auto-generated method stub
		return 0;
	}
}
