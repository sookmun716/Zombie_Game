package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.WeaponItem;

public class SnipeAction extends Action{
	private Actor target;
	private WeaponItem sniper;
	private Random random=new Random();
	public static final int MAXIMUM_FOCUS=2;
	public SnipeAction(Actor target, WeaponItem sniper) {
		this.target=target;
		this.sniper=sniper;
	}
	@Override
	public String execute(Actor actor, GameMap map) {
		sniper.use_ammo(actor);
		String result=null;
		if(actor.get_sniper_ammo()==0) {
			return actor+" has no sufficient sniper ammunition, sniper cannot be fired";
		}
		
		if(sniper.aim_turns()==0) {
			if(random.nextInt(101)>=25) {
				target.hurt(sniper.ranged_damage());
				try {
					result=actor+" "+sniper.secondary_verb()+" "+target+ " for "+sniper.ranged_damage()+" damage";
				}
				catch(NullPointerException e){
					System.out.println(sniper+" is not a sniper rifle.");
					System.exit(0);
				}
			}
			else {
				result=actor+" misses "+target+"!";
			}
			
		}
		else if(sniper.aim_turns()>0&&sniper.aim_turns()<MAXIMUM_FOCUS) {
			if(random.nextInt(101)>=10) {
				int double_damage=sniper.ranged_damage()*2;
				target.hurt(double_damage);
				try {
					result=actor+" "+sniper.secondary_verb()+" "+target+ " for "+double_damage+" damage";
				}
				catch(NullPointerException e){
					System.out.println(sniper+" is not a sniper rifle.");
					System.exit(0);
				}
			}
			else {
				result=actor+" misses "+target+"!";
			}
		}
		else if(sniper.aim_turns()>=MAXIMUM_FOCUS) {
			int max_damage=target.getHp();
			target.hurt(max_damage);
			try {
				result=actor+" "+sniper.secondary_verb()+" "+target+ " for "+max_damage+" damage";
			}
			catch(NullPointerException e){
				System.out.println(sniper+" is not a sniper rifle.");
				System.exit(0);
			}
		}
		
		result+=target.isDead(map);
		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" snipes "+target;
	}
	@Override
	public Boolean isSniperAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
