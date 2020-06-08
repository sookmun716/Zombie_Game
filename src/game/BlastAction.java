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

	@Override
	public String execute(Actor actor, GameMap map) {
		shotgun.use_ammo(actor);
		if(random.nextInt(101)<0) {
			return "\n"+actor+" misses "+shotgun+" blast!";
		}
		String result="";
		result+=actor+" fires shotgun at "+exit.getName()+"!";
		Location destination = exit.getDestination();
		int x=destination.x();
		int y=destination.y();
		int num_range=0;
	
		if(exit.getName()=="North") {
			while(num_range<shotgun.range()) {
				for(int i=(x-num_range);i<(x+num_range+1);i++) {
					try {
						if(map.at(i,y-num_range).containsAnActor()) {
							Location location=map.at(i,y-num_range);
							result=this.damageActor(location, map, actor, result);
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
							Location location=map.at(i,y+num_range);
							result=this.damageActor(location, map, actor, result);
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
							Location location=map.at(x+num_range,i);
							result=this.damageActor(location, map, actor, result);
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
							Location location=map.at(x-num_range,i);
							result=this.damageActor(location, map, actor, result);
						}
					}
					catch(ArrayIndexOutOfBoundsException e){
						continue;
					}
				}
				num_range+=1;
			}
		}
		
		else if(exit.getName()=="North-East") {
			x=map.locationOf(actor).x();
			y=map.locationOf(actor).y();
			while(num_range<=shotgun.range()) {
				for(int i=x;i<=x+shotgun.range();i++)  {
					try {
						//the other condition are to ensure that the player doesn't get hurt by shotgun
						if(map.at(i,y-num_range).containsAnActor()&&(i!=x||y!=y-num_range)) {
							Location location=map.at(i,y-num_range);
							result=this.damageActor(location, map, actor, result);
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
						if(map.at(i,y+num_range).containsAnActor()&&(i!=x||y!=y+num_range)) {
							Location location=map.at(i,y+num_range);
							result=this.damageActor(location, map, actor, result);
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
						if(map.at(i,y-num_range).containsAnActor()&&(i!=x||y!=y-num_range)) {
							Location location=map.at(i,y-num_range);
							result=this.damageActor(location, map, actor, result);
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
						if(map.at(i,y+num_range).containsAnActor()&&(i!=x||y!=y+num_range)) {
							Location location=map.at(i,y+num_range);
							result=this.damageActor(location, map, actor, result);
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
	
	public String damageActor(Location location, GameMap map, Actor actor, String result) {
		Actor target=location.getActor();
		target.hurt(shotgun.ranged_damage());
		result+="\n"+actor+" hurts "+ target+" for "+shotgun.ranged_damage()+" with a "+shotgun;
		result+=target.isDead(map);
		return result;
	}
	
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" fires "+ shotgun+" at "+exit.getName();
	}

}
