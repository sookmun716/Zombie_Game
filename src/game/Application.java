package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.World;

/**
 * The main class for the zombie apocalypse game.
 *
 */
public class Application {

	public static void main(String[] args) {
		World world = new endGame(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Fence(), new Tree());
		
		List<String> map = Arrays.asList(
		"................................................................................",
		"................................................................................",
		"....................................##########..................................",
		"..........................###########........#####..............................",
		"............++...........##......................########.......................",
		"..............++++.......#..............................##......................",
		".............+++...+++...#...............................#......................",
		".........................##..............................##.....................",
		"..........................#...............................#.....................",
		".........................##...............................##....................",
		".........................#...............................##.....................",
		".........................###..............................##....................",
		"...........................####......................######.....................",
		"..............................#########.........####............................",
		"............+++.......................#.........#...............................",
		".............+++++....................#.........#...............................",
		"...............++........................................+++++..................",
		".............+++....................................++++++++....................",
		"............+++.......................................+++.......................",
		"................................................................................",
		".........................................................................++.....",
		"........................................................................++.++...",
		".........................................................................++++...",
		"..........................................................................++....",
		"................................................................................");
		ZombieMap gameMap = new ZombieMap(groundFactory, map );
		world.addGameMap(gameMap);
		
		Actor player = new Player("Player", '@', 100);
		player.addItemToInventory(new SniperRifle());
		player.addItemToInventory(new SniperAmmunitionBox());
		world.addPlayer(player, gameMap.at(42, 15));
		//gameMap.at(43, 15).addActor(new Zombie("Bum"));
		//cardinal directions
		
		/*
		 gameMap.at(43,15).addActor(new Zombie("Brrrr"));
		 gameMap.at(44,14).addActor(new Zombie("beww"));
		 gameMap.at(44,15).addActor(new Zombie("beww"));
		 gameMap.at(44,16).addActor(new Zombie("beww"));
		 gameMap.at(45,13).addActor(new Zombie("srrr"));
		 gameMap.at(45,14).addActor(new Zombie("Brrrr"));
		 gameMap.at(45,15).addActor(new Zombie("marrr"));
		 gameMap.at(45,16).addActor(new Zombie("beww"));
		 gameMap.at(45,17).addActor(new Zombie("srrr"));
	
	*/
		//intercardinal directions
		/*
		 * gameMap.at(41,15).addActor(new Zombie("grr")); 
		 * gameMap.at(40,15).addActor(new Zombie("harr")); 
		 * gameMap.at(39,15).addActor(new Zombie("Kiaa"));
		 * gameMap.at(42,14).addActor(new Zombie("Brrrr"));
		 * gameMap.at(41,14).addActor(new Zombie("marrr"));
		 * gameMap.at(40,14).addActor(new Zombie("beww"));
		 * gameMap.at(39,14).addActor(new Zombie("srrr"));
		 * gameMap.at(42,13).addActor(new Zombie("Brrrr"));
		 * gameMap.at(41,13).addActor(new Zombie("marrr"));
		 * gameMap.at(40,13).addActor(new Zombie("beww"));
		 * gameMap.at(39,13).addActor(new Zombie("srrr"));
		 * gameMap.at(42,12).addActor(new Zombie("Brrrr"));
		 * gameMap.at(41,12).addActor(new Zombie("marrr"));
		 * gameMap.at(40,12).addActor(new Zombie("beww"));
		 * gameMap.at(39,12).addActor(new Zombie("srrr"));
		 */
	    // Place some random humans
		String[] humans = {"Carlton","May", "Vicente", "Andrea", "Wendy",
			"Elina", "Winter", "Clem", "Jacob", "Jaquelyn"};
		int x, y;
		for (String name : humans) {
			do {
				x = (int) Math.floor(Math.random() * 20.0 + 30.0);
				y = (int) Math.floor(Math.random() * 7.0 + 5.0);
			} 
			while (gameMap.at(x, y).containsAnActor());
			gameMap.at(x,  y).addActor(new Human(name));	
		}
		
		// place a simple weapon
		gameMap.at(74, 20).addItem(new Plank());
		
		// FIXME: Add more zombies!
		gameMap.at(30, 20).addActor(new Zombie("Groan"));
		gameMap.at(30,  18).addActor(new Zombie("Boo"));
		gameMap.at(10,  4).addActor(new Zombie("Uuuurgh"));
		gameMap.at(50, 18).addActor(new Zombie("Mortalis"));
		gameMap.at(1, 10).addActor(new Zombie("Gaaaah"));
		gameMap.at(62, 12).addActor(new Zombie("Aaargh"));	
		
		
		FancyGroundFactory townFactory = new FancyGroundFactory(new Dirt(),new Fence());
		
		List<String> map2 = Arrays.asList(
		"................................................................................",
		"................................................................................",
		"................................................................................",
		"................................................................................",
		"................................................................................",
		"................................................................................",
		"...........................#......................#.............................",
		"..........................#........................#............................",
		".........................#..........................#...........................",
		"........................#............................#..........................",
		".......................#..............................#.........................",
		"......................#................................#........................",
		".....................#..................................#.......................",
		"....................#....................................#......................",
		"...................#......................................#.....................",
		"...................#########......................#########.....................",
		"...........................#......................#.............................",
		"...........................#......................#.............................",
		"...........................#......................#.............................",
		"...........................#......................#.............................",
		"...........................#......................#.............................",
		"...........................######............######.............................",
		"................................................................................",
		"................................................................................",
		"................................................................................",
		"................................................................................");
		
		GameMap townMap = new GameMap(townFactory, map2);
		world.addGameMap(townMap);
		
		//place a vehicle in gameMap
		Vehicle trainToTown = new Vehicle();
		trainToTown.addAction(new MoveActorAction(townMap.at(0,0),"to the town!"));
		gameMap.at(45, 10).addItem(trainToTown);
		
		//place zombie in townmap
		townMap.at(20, 20).addActor(new Zombie("Ching"));
		townMap.at(36,  18).addActor(new Zombie("Chong"));
		townMap.at(13,  4).addActor(new Zombie("Ling"));
		townMap.at(47, 18).addActor(new Zombie("Long"));
		townMap.at(25, 11).addActor(new Zombie("Ding"));
		townMap.at(62, 12).addActor(new Zombie("Dong"));	
		
		
		// Place human in townmap
		townMap.at(17, 3).addActor(new Human("Gusion"));
		townMap.at(41, 7).addActor(new Human("Eudora"));
		townMap.at(60, 6).addActor(new Human("Alucard"));
		townMap.at(25, 9).addActor(new Human("Guin"));
		townMap.at(43, 12).addActor(new Human("Lesley"));
		townMap.at(65, 18).addActor(new Human("Miya"));	
		townMap.at(40, 21).addActor(new Human("Popoh"));
		townMap.at(10, 15).addActor(new Human("Harley"));
		townMap.at(14, 9).addActor(new Human("Gord"));
		
		//Place weapons
		townMap.at(38, 4).addItem(new SniperRifle() );
		townMap.at(28,15).addItem(new SniperAmmunitionBox());
		townMap.at(38, 21).addItem(new Shotgun());
		townMap.at(49, 15).addItem(new ShotgunAmmunitionBox());
		
		//place a vehicle where player can move from townmap to gamemap
		Vehicle train = new Vehicle();
		train.addAction(new MoveActorAction(gameMap.at(0, 0),"to gameMap!"));
		townMap.at(45, 10).addItem(train);
		
		world.run();
	}
}
