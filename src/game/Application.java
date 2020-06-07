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
		World world = new World(new Display());

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
		GameMap gameMap = new GameMap(groundFactory, map );
		world.addGameMap(gameMap);
		
		Actor player = new Player("Player", '@', 100);
		world.addPlayer(player, gameMap.at(42, 15));
		
	    // Place some random humans
		String[] humans = {"Carlton", "May", "Vicente", "Andrea", "Wendy",
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
		
		//place a vehicle
		Vehicle train = new Vehicle("train",'T',false);
		train.addAction(new MoveActorAction(townMap.at(45, 10),"to the town!"));
		gameMap.at(45, 10).addItem(train);
		
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
		townMap.at(38, 4).addItem(new SniperRifle(townMap) );
		townMap.at(28,15).addItem(new SniperAmmunitionBox());
		townMap.at(38, 21).addItem(new Shotgun());
		townMap.at(49, 15).addItem(new ShotgunAmmunitionBox());
		
		//test code for crafting weapons
		//gameMap.at(42,15).addItem(new ZombieArm());
		//gameMap.at(42,15).addItem(new ZombieLeg());
		
		//test code for rising from the dead
		//gameMap.at(65, 12).addActor(new Zombie("Brain"));
		//gameMap.at(64, 12).addActor(new Human("Fool"));
		
		//test code for planting crops
		//gameMap.at(44, 15).addActor(new Farmer("George"));
		
		//test code for fertilising crop
	    //gameMap.at(44, 15).setGround(new Crop());;
		
		//test code for harvesting crop
		//Crop crop= new Crop();
		//crop.fertilise();
		//crop.fertilise();
		//test harvesting farmer harvesting crop
		//gameMap.at(44, 15).setGround(crop);
		//test harvesting for player
		//gameMap.at(42, 15).setGround(crop);
		
		//test code for eating food
		//test for npc eating food
		//gameMap.at(44, 15).getActor().hurt(15);
		//gameMap.at(44,  15).addItem(new Food());
		//test for player eating food
		//player.hurt(25);
		//player.addItemToInventory(new Food());
		
		//test code 
		world.run();
	}
}
