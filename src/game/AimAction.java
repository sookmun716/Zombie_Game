package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.WeaponItem;

public class AimAction extends Action{
	private Actor target;
	private WeaponItem sniper;
	public AimAction(Actor target, WeaponItem sniper) {
		this.target=target;
		this.sniper=sniper;
	}
	@Override
	public String execute(Actor actor, GameMap map) {
		try {
			if(target==sniper.getTarget()) {
				sniper.set_aim_turns((sniper.get_aim_turns()+1));
			}
			else {
				sniper.set_aim_turns(1);
				sniper.setTarget(target);
			}
			return actor+" aimed at "+ target+" for "+sniper.get_aim_turns()+" turn(s). ";
		}
		catch(NullPointerException e){
			return null;
		}
		
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor+" aims at "+target;
	}
	@Override
	public Boolean isSniperAction() {
		return true;
	}

}
