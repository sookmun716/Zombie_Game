package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

public class BlastAction extends Action {
	private WeaponItem shotgun;
	private Exit exit;
	private Random random=new Random();
	public BlastAction(WeaponItem weapon,Exit exit) {
		shotgun=weapon;
		this.exit=exit;
	}
	@Override
	public Boolean isSniperAction() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * This method overrides the execute method of Action, and is called to perform
	 * an action, in this case this method will damage every actor in a given area depending
	 * on the direction to simulate the area of effect when firing a shotgun.
	 * 
	 * @param actor The actor that is firing the shotgun
	 * 
	 * @param map   The game map the actor is in.
	 * 
	 * @return a String that shows the actors that have been damaged by shotgun
	 **/
	@Override
	public String execute(Actor actor, GameMap map) {
		if(actor.get_shotgun_ammo()==0) {
			return actor+" has no sufficient shotgun ammunition, shotgun cannot be fired";
		}
		shotgun.use_ammo(actor);
		if(random.nextInt(101)<30) {
			return actor+" misses "+shotgun+" blast!";
		}
		String result="";
		result+=actor+" fires shotgun at "+exit.getName()+"!";
		Location destination = exit.getDestination();
		int x=destination.x();
		int y=destination.y();
		int num_range=0;
		
		//cardinal directions use a similar formula with minor differences
		if(exit.getName()=="North") {
			while(num_range<shotgun.range()) {
				for(int i=(x-num_range);i<(x+num_range+1);i++) {
					try {
						if(map.at(i,y-num_range).containsAnActor()) {
							Actor target= map.at(i,y-num_range).getActor();
							result+=new AttackAction(target,shotgun).execute(actor, map);
						}
					}
					catch(ArrayIndexOutOfBoundsException e){
						continue;
					}
				}
				num_range+=1;
			}
		}
		
		else if(exit.getName()=="South") {
			while(num_range<shotgun.range()) {
				for(int i=(x-num_range);i<(x+num_range+1);i++) {
					try {
						if(map.at(i,y+num_range).containsAnActor()) {
							Actor target= map.at(i,y+num_range).getActor();
							result+=new AttackAction(target,shotgun).execute(actor, map);
						}
					}
					catch(ArrayIndexOutOfBoundsException e){
						continue;
					}
				}
				num_range+=1;
			}
		}
		
		else if(exit.getName()=="East") {
			while(num_range<shotgun.range()) {
				for(int i=(y-num_range);i<(y+num_range+1);i++) {
					try {
						if(map.at(x+num_range,i).containsAnActor()) {
							Actor target= map.at(x+num_range,i).getActor();
							result+=new AttackAction(target,shotgun).execute(actor, map);
						}
					}
					catch(ArrayIndexOutOfBoundsException e){
						continue;
					}
				}
				num_range+=1;
			}
		}
		
		else if(exit.getName()=="West") {
			while(num_range<shotgun.range()) {
				for(int i=(y-num_range);i<(y+num_range+1);i++) {
					try {
						if(map.at(x-num_range,i).containsAnActor()) {
							Actor target= map.at(x-num_range,i).getActor();
							result+=new AttackAction(target,shotgun).execute(actor, map);
						}
					}
					catch(ArrayIndexOutOfBoundsException e){
						continue;
					}
				}
				num_range+=1;
			}
		}
		
		//intercardinal directions use a similar formula with minor differences
		else if(exit.getName()=="North-East") {
			x=map.locationOf(actor).x();
			y=map.locationOf(actor).y();
			while(num_range<=shotgun.range()) {
				for(int i=x;i<=x+shotgun.range();i++)  {
					try {
						//the other condition are to ensure that the player doesn't get hurt by shotgun
						if(map.at(i,y-num_range).containsAnActor()) {
							if(map.at(i,y-num_range).getActor()!=actor) {
								Actor target= map.at(i,y-num_range).getActor();
								result+=new AttackAction(target,shotgun).execute(actor, map);
							}
						}
					}
					catch(ArrayIndexOutOfBoundsException e){
						continue;
					}
				}
				num_range+=1;
			}
		}
		
		else if(exit.getName()=="South-East") {
			x=map.locationOf(actor).x();
			y=map.locationOf(actor).y();
			while(num_range<=shotgun.range()) {
				for(int i=x;i<=x+shotgun.range();i++)  {
					try {
						//the other condition are to ensure that the player doesn't get hurt by shotgun
						if(map.at(i,y+num_range).containsAnActor()) {
							if(map.at(i,y+num_range).getActor()!=actor) {
								Actor target= map.at(i,y+num_range).getActor();
								result+=new AttackAction(target,shotgun).execute(actor, map);
							}
						}
					}
					catch(ArrayIndexOutOfBoundsException e){
						continue;
					}
				}
				num_range+=1;
			}
		}
		
		else if(exit.getName()=="North-West") {
			x=map.locationOf(actor).x();
			y=map.locationOf(actor).y();
			while(num_range<=shotgun.range()) {
				for(int i=x;i>=x-shotgun.range();i--)  {
					try {
						//the other condition are to ensure that the player doesn't get hurt by shotgun
						if(map.at(i,y-num_range).containsAnActor()) {
							if(map.at(i,y-num_range).getActor()!=actor) {
								Actor target= map.at(i,y-num_range).getActor();
								result+=new AttackAction(target,shotgun).execute(actor, map);
							}
						}
					}
					catch(ArrayIndexOutOfBoundsException e){
						continue;
					}
				}
				num_range+=1;
			}
		}
		
		else if(exit.getName()=="South-West") {
			x=map.locationOf(actor).x();
			y=map.locationOf(actor).y();
			while(num_range<=shotgun.range()) {
				for(int i=x;i>=x-shotgun.range();i--)  {
					try {
						//the other condition are to ensure that the player doesn't get hurt by shotgun
						if(map.at(i,y+num_range).containsAnActor()) {
							if(map.at(i,y+num_range).getActor()!=actor) {
								Actor target= map.at(i,y+num_range).getActor();
								result+=new AttackAction(target,shotgun).execute(actor, map);
							}
						}
					}
					catch(ArrayIndexOutOfBoundsException e){
						continue;
					}
				}
				num_range+=1;
			}
		}
		return result;
	}
	
	
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" fires "+ shotgun+" at "+exit.getName();
	}
	@Override
	public Boolean isEnd() {
		// TODO Auto-generated method stub
		return null;
	}

}
