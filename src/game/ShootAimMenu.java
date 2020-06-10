package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;
import edu.monash.fit2099.engine.WeaponItem;

public class ShootAimMenu extends Action {
	private Menu menu=new Menu();
	private Display display=new Display();
	private Actions actions=new Actions();
	private WeaponItem sniper;
	private Actor target;
	public ShootAimMenu(WeaponItem weapon, Actor target) {
		sniper=weapon;
		this.target=target;
		actions.add(new AimAction(target,sniper));
		actions.add(new SnipeAction(target,sniper));
	}
	@Override
	public Boolean isSniperAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		
		Action action=menu.showMenu(actor, actions, display);
		return action.execute(actor,map);
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" targets "+ target+" with "+sniper;
	}

}
