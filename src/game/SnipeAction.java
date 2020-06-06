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
	
	public SnipeAction(Actor target, WeaponItem sniper) {
		this.target=target;
		this.sniper=sniper;
	}
	@Override
	public String execute(Actor actor, GameMap map) {
		String result=null;
		if(actor.get_sniper_ammo()==0) {
			return actor+" has no sufficient sniper ammunition, sniper cannot be fired";
		}
		
		if(sniper.get_aim_turns()==0) {
			if(random.nextInt(101)>=25) {
				target.hurt(sniper.getRangedDamage());
				result=actor+" "+" snipes "+target+ " for "+sniper.getRangedDamage()+" damage";
				
			}
			
		}
		else if(sniper.get_aim_turns()==1) {
			if(random.nextInt(101)>=10) {
				int double_damage=sniper.getRangedDamage()*2;
				target.hurt(double_damage);
				result=actor+" snipes "+ target+" for "+(double_damage)+" damage";
			}
		}
		else if(sniper.get_aim_turns()>=2) {
			int max_damage=target.getHp();
			target.hurt(max_damage);
			result=actor+" snipes "+target+ " for "+max_damage+" damage";
		}
		
		if (!target.isConscious()) {
			Corpse corpse = new Corpse(target);
			map.locationOf(target).addItem(corpse);
			
			Actions dropActions = new Actions();
			for (Item item : target.getInventory())
				dropActions.add(item.getDropAction());
			for (Action drop : dropActions)		
				drop.execute(target, map);
			map.removeActor(target);	
			
			result += System.lineSeparator() + target + " is killed.";
		}
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
