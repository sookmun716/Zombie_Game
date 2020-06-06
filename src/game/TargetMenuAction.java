package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;
import edu.monash.fit2099.engine.WeaponItem;

public class TargetMenuAction extends Action{
	private Menu menu=new Menu();
	private Display display=new Display();
	private Actions actions=new Actions();
	private WeaponItem sniper;
	
	public TargetMenuAction(WeaponItem weapon) {
		sniper=weapon;
	}
	@Override
	public Boolean isSniperAction() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		for (int y : map.getYRange()) {
			for (int x : map.getXRange()) {
				if(map.at(x, y).containsAnActor()) {
					Actor snipe_target=map.at(x, y).getActor();
					if(snipe_target.hasCapability(ZombieCapability.UNDEAD)) {
						actions.add(new ShootAimMenu(sniper,snipe_target));
					}
					
				}
			}
		}
		Action action=menu.showMenu(actor, actions, display);
		return action.execute(actor,map);
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" chooses target";
	}

}
