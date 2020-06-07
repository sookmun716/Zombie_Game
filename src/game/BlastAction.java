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
		Location destination = exit.getDestination();
		int x=destination.x();
		int y=destination.y();
		int num_range;
	
		if(exit.getName()=="North") {
			num_range=0;
			while(num_range<3) {
				for(int i=(x-num_range);i<(x+num_range+1);i++) {
					try {
						if(map.at(i,y-num_range).containsAnActor()) {
							Actor target=map.at(i,y-num_range).getActor();
							target.hurt(shotgun.getRangedDamage());
							result+="\n"+actor+" hurts "+ target+" for "+shotgun.getRangedDamage()+" with a "+shotgun;
							result+=target.isDead(map);
						}
					}
					catch(ArrayIndexOutOfBoundsException e){
						
					}
				}
				num_range+=1;
			}
		}
		
		else if(exit.getName()=="South") {
			num_range=0;
			while(num_range<3) {
				for(int i=(x-num_range);i<(x+num_range+1);i++) {
					try {
						if(map.at(i,y+num_range).containsAnActor()) {
							Actor target=map.at(i,y+num_range).getActor();
							target.hurt(shotgun.getRangedDamage());
							result+="\n"+actor+" hurts "+ target+" for "+shotgun.getRangedDamage()+" with a "+shotgun;
							result+=target.isDead(map);
						}
					}
					catch(ArrayIndexOutOfBoundsException e){
						
					}
				}
				num_range+=1;
			}
		}
		
		else if(exit.getName()=="East") {
			num_range=0;
			while(num_range<3) {
				for(int i=(y-num_range);i<(y+num_range+1);i++) {
					try {
						if(map.at(x+num_range,i).containsAnActor()) {
							Actor target=map.at(x+num_range,i).getActor();
							target.hurt(shotgun.getRangedDamage());
							result+="\n"+actor+" hurts "+ target+" for "+shotgun.getRangedDamage()+" with a "+shotgun;
							result+=target.isDead(map);
						}
					}
					catch(ArrayIndexOutOfBoundsException e){
						
					}
				}
				num_range+=1;
			}
		}
		
		else if(exit.getName()=="West") {
			num_range=0;
			while(num_range<3) {
				for(int i=(y-num_range);i<(y+num_range+1);i++) {
					try {
						if(map.at(x-num_range,i).containsAnActor()) {
							Actor target=map.at(x-num_range,i).getActor();
							target.hurt(shotgun.getRangedDamage());
							result+="\n"+actor+" hurts "+ target+" for "+shotgun.getRangedDamage()+" with a "+shotgun;
							result+=target.isDead(map);
						}
					}
					catch(ArrayIndexOutOfBoundsException e){
						
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

}
