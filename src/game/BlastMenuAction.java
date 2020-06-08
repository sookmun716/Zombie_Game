package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Menu;
import edu.monash.fit2099.engine.WeaponItem;

public class BlastMenuAction extends Action {
	private Menu menu=new Menu();
	private Display display=new Display();
	private Actions actions=new Actions();
	private WeaponItem shotgun;
	
	public BlastMenuAction(WeaponItem weapon) {
		shotgun=weapon;
	}
	
	@Override
	public Boolean isSniperAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		if(actor.get_shotgun_ammo()==0) {
			return actor+" has no "+shotgun+" ammunition left, "+shotgun+" cannot be fired.";
		}
		Location actor_location=map.locationOf(actor);
		for (Exit exit : actor_location.getExits()) {
			actions.add(new BlastAction(shotgun, exit));
		}
		Action action=menu.showMenu(actor, actions, display);
		return action.execute(actor,map);
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" fires shotgun";
	}

}
