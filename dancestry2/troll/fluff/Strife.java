package troll.fluff;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
@SuppressWarnings("unused")

public class Strife {
	String[] all = {
			"bladeKind", "axeKind", "clawKind", "scytheKind", "knifeKind", "cleaverKind", "spearKind",
			"2x3dentKind", "whipKind", "hammerKind", "clubKind", "staffKind", "maceKind", "icepickKind",
			"bowKind", "needleKind", "projectileKind", "dartKind", "pistolKind", "rifleKind", "chainsawKind",
			"grenadeKind", "explosivesKind", "batKind", "ballKind", "fanKind", "diceKind", "yoyoKind", 
			"paddleKind", "gloveKind", "makeupKind", "umbrellaKind", "caneKind", "iceskateKind", "shoeKind",
			"coatKind", "ropeKind", "chainKind", "cordKind", "barbwireKind", "offcespplyKind", "tablelegKind",
			"bookKind", "statueKind", "trophyKind", "bustKind", "pizzactrKind", "puppetKind", "peprmillKind",
			"rollpinKind", "spoonKind", "spatulaKind", "forkKind", "ladleKind", "tongsKind", "peprspryKind",
			"aerosolKind", "fireextKind", "scissorKind", "sawKind", "chiselKind", "wrenchKind", "screwdriverKind",
			"crowbarKind", "pipeKind", "plierKind", "broomKind", "pokerKind", "shovelKind", "rakeKind", "vacuumKind",
			"mopKind", "plankKind", "golfclubKind", "hckystckKind", "bowlngpinKind", "woodwindKind", "brassKind",
			"guitarKind", "rockKind", "lampKind", "candlstckKind", "fncysntaKind", "fistKind",
			};
	// blunt, sharp, heavy, tool,
	String[] nerd = {"knifeKind", "hammerKind", "staffKind", "needleKind", "grenadeKind", "explosivesKind",
                        "fanKind", "diceKind", "yoyoKind", "gloveKind", "cordKind", "offcespplyKind", "bookKind", 
			"scissorKind", "wrenchKind", "screwdriverKind",	"crowbarKind", "pipeKind", "plierKind",
                        "pokerKind", "woodwindKind", "brassKind", "guitarKind", "lampKind", "candlstckKind",
                        "fncysntaKind",};
	String[] pun = {"axeKind", "bowKind", "staffKind", "needleKind", "batKind", "ballKind", "fanKind", "cordKind",
                        "offcespplyKind", "trophyKind", "bustKind", "aerosolKind", "pipeKind", "pokerKind", "brassKind",
                        "rockKind",};
	String[] melee = {
			"bladeKind", "axeKind", "clawKind", "scytheKind", "knifeKind", "cleaverKind", "spearKind",
			"2x3dentKind", "whipKind", "hammerKind", "clubKind", "staffKind", "maceKind", "icepickKind",
			"chainsawKind", "batKind", "fanKind", "caneKind", "fistKind"};
	String[] ranged = {"knifeKind", "bowKind", "needleKind", "projectileKind", "dartKind", "pistolKind", "rifleKind", 
			 "grenadeKind", "ballKind", "peprspryKind", "aerosolKind", "fireextKind", "rockKind"};
	String[] pole = {"scytheKind", "spearKind", "2x3dentKind", "staffKind", "broomKind", "shovelKind",
			"rakeKind", "mopKind",};
	String[] game = {
			"clubKind", "staffKind", "icepickKind", "projectileKind", "dartKind", "batKind", "ballKind", 
			"fanKind", "diceKind", "yoyoKind", "paddleKind", "gloveKind", "caneKind", "iceskateKind", 
			"ropeKind", "chainKind", "cordKind", "trophyKind", "puppetKind", "tongsKind", "pokerKind", 
			"golfclubKind", "hckystckKind", "bowlngpinKind", };
	String[] wearable = {"clawKind", "dartKind", "ballKind", "gloveKind", "makeupKind", "iceskateKind", "shoeKind",
			"coatKind", "chainKind", "bustKind", "brassKind", "lampKind", "fistKind"};
	String[] office = {"whipKind", "fanKind", "umbrellaKind", "caneKind", "shoeKind", "coatKind", "cordKind", 
			"offcespplyKind", "tablelegKind", "bookKind", "trophyKind", "bustKind", "peprspryKind",
			"aerosolKind", "fireextKind", "scissorKind", "screwdriverKind", "pipeKind", "plierKind", 
			"broomKind", "vacuumKind", "mopKind", "golfclubKind", "lampKind"};
	String[] chain = {"whipKind","chainsawKind","yoyoKind","ropeKind","chainKind","cordKind","barbwireKind"};
	String[] cook = {"cleaverKind","rollpinKind","spoonKind","spatulaKind","forkKind","paddleKind",
					 "ladleKind","tongsKind","peprmillKind","pizzactrKind","scissorKind"};
	String[] clean = {"aerosolKind","fireextKind","broomKind","rakeKind","vacuumKind","mopKind"};
	String[] music = {"clubKind","woodwindKind","brassKind","guitarKind","rockKind"};
	String[] furnish = {"fanKind","umbrellaKind","statueKind","trophyKind","bustKind","offcespplyKind","tablelegKind",
					 "fireextKind","pokerKind","lampKind","candlstckKind","fncysntaKind"};

	public String getstrife(String specibus) {
 		Random rand = new Random();
		String var = new String("");
		var = fromkey(specibus);
		return var;
	}

	public String getstrifespecial(String[] hobby, Stats stats) {
 		Random rand = new Random();
		String var = new String("");
		String spec = new String("");

                if ((stats.create>12)&&(rand.nextBoolean()))   {spec="cook";};     // sylph/maid/muse
                if ((stats.create>12)&&(rand.nextBoolean()))   {spec="music";};    // sylph/maid/muse
		if ((stats.destroy>12)&&(rand.nextBoolean()))  {spec="ranged";};   // prince/bard/lord
		if ((stats.destroy>12)&&(rand.nextBoolean()))  {spec="melee";};    // prince/bard/lord
                if ((stats.manip>12)&&(rand.nextBoolean()))    {spec="game";};     // knight/page
                if ((stats.manip>12)&&(rand.nextBoolean()))    {spec="pun";};      // knight/page
		if ((stats.move>12)&&(rand.nextBoolean()))     {spec="wearable";}; // thief/rogue
		if ((stats.move>12)&&(rand.nextBoolean()))     {spec="chain";};    // thief/rogue
                if ((stats.exploit>12)&&(rand.nextBoolean()))  {spec="office";};   // witch/heir
                if ((stats.exploit>12)&&(rand.nextBoolean()))  {spec="furnish";};  // witch/heir
		if ((stats.know>12)&&(rand.nextBoolean()))     {spec="ranged";};   // seer/mage
		if ((stats.know>12)&&(rand.nextBoolean()))     {spec="pun";};      // seer/mage
		
		if ((likes(hobby, "cooking"))&&(rand.nextBoolean()))      {spec="cook";};
		if ((likes(hobby, "weaponry"))&&(rand.nextBoolean()))     {spec="melee";};
		if ((likes(hobby, "weaponry"))&&(rand.nextBoolean()))     {spec="melee";};
		if ((likes(hobby, "armor"))&&(rand.nextBoolean()))        {spec="wearable";};
		if ((likes(hobby, "fashion"))&&(rand.nextBoolean()))      {spec="wearable";};
		if ((likes(hobby, "games"))&&(rand.nextBoolean()))        {spec="game";};
		if ((likes(hobby, "sports"))&&(rand.nextBoolean()))       {spec="game";};
		if ((likes(hobby, "science"))&&(rand.nextBoolean()))      {spec="nerd";};
		if ((likes(hobby, "engineering"))&&(rand.nextBoolean()))  {spec="nerd";};
		if ((likes(hobby, "robotics"))&&(rand.nextBoolean()))     {spec="nerd";};
		if ((likes(hobby, "crafting"))&&(rand.nextBoolean()))     {spec="nerd";};
		if ((likes(hobby, "programming"))&&(rand.nextBoolean()))  {spec="nerd";};
		if ((likes(hobby, "literature"))&&(rand.nextBoolean()))   {spec="pun";};
		if ((likes(hobby, "knickknacks"))&&(rand.nextBoolean()))  {spec="furnish";};
		if ((likes(hobby, "life"))&&(rand.nextBoolean()))         {spec="cook";};
		if ((likes(hobby, "physicality"))&&(rand.nextBoolean()))  {spec="game";};
		if ((likes(hobby, "war"))&&(rand.nextBoolean()))          {spec="melee";};
		if ((likes(hobby, "frivolity"))&&(rand.nextBoolean()))    {spec="pun";};
		if ((likes(hobby, "chaos"))&&(rand.nextBoolean()))        {spec="pun";};
		if ((likes(hobby, "fungi"))&&(rand.nextBoolean()))        {spec="clean";};
		if ((likes(hobby, "costuming"))&&(rand.nextBoolean()))    {spec="wearable";};                
		if ((likes(hobby, "psychic"))&&(rand.nextBoolean()))      {spec="ranged";};
		
                if ((likes(hobby, "sewing"))&&(rand.nextBoolean())&&(rand.nextBoolean()))         {spec="needleKind";};
                if ((likes(hobby, "needlecraft"))&&(rand.nextBoolean())&&(rand.nextBoolean()))    {spec="needleKind";};                
		if ((likes(hobby, "grimdark arts"))&&(rand.nextBoolean())&&(rand.nextBoolean()))  {spec="needleKind";};
		if ((likes(hobby, "the esoteric"))&&(rand.nextBoolean())&&(rand.nextBoolean()))   {spec="needleKind";};
		if ((likes(hobby, "slight of hand"))&&(rand.nextBoolean())&&(rand.nextBoolean())) {spec="fistKind";};	
		if ((likes(hobby, "puppets"))&&(rand.nextBoolean())&&(rand.nextBoolean()))        {spec="puppetKind";};
                
                // nerd pun melee ranged pole game wearable office chain cook clean music furnish               
		var = fromkey(spec);

		return var;
	}
	
	public boolean likes(String[] hobbies, String key) {
		boolean answer = false;
		if (hobbies[0]==key) {answer=true;};
		if (hobbies[1]==key) {answer=true;};
		if (hobbies[2]==key) {answer=true;};		
		return answer;
	}


	public String fromkey(String spec) {
		Random rand = new Random();
                
		String var = new String("");
		var = all[rand.nextInt(all.length)];
		if (spec=="wearable") {var = wearable[rand.nextInt(wearable.length)];};
		if (spec=="office")     {var = office[rand.nextInt(office.length)];};
		if (spec=="chain")       {var = chain[rand.nextInt(chain.length)];};
		if (spec=="cook")         {var = cook[rand.nextInt(cook.length)];};
		if (spec=="game")         {var = game[rand.nextInt(game.length)];};
		if (spec=="pole")         {var = pole[rand.nextInt(pole.length)];};
		if (spec=="clean")       {var = clean[rand.nextInt(clean.length)];};
		if (spec=="music")       {var = music[rand.nextInt(music.length)];};
		if (spec=="melee")       {var = melee[rand.nextInt(melee.length)];};
		if (spec=="ranged")     {var = ranged[rand.nextInt(ranged.length)];};
		if (spec=="furnish")   {var = furnish[rand.nextInt(furnish.length)];};
		if (spec=="pun")           {var = pun[rand.nextInt(pun.length)];};
		if (spec=="nerd")         {var = nerd[rand.nextInt(nerd.length)];};
                
                // and if it's just a -Kind, set it directly to that -Kind
                List allyall = Arrays.asList(all);
                if (allyall.contains(spec)) {var = spec;};
		return var;
	}
	
	
	public String getweapon(String Specibus) {
		Random rand = new Random();
		String var = new String("");
		// Thank you to Nadaya's mun, and the Re:surrection RP timeline OOC chat for their help brainstorming original source list

		String[] bladeKind = {
				"Bastard Sword", "Model Lightsaber", "Two-Handed Sword", 
				"Katana", "Short Sword", "Helicopter Blade", 
				"Roller Blades", "1/2 Scissors", "Bread Knife",
                                "Sandwich Skewer", "Ancient Blade", "Shitty Mall Sword", 
                                "Fantasy Sword (merchandise tie-in)", "Sharpened Sheetmetal Cutout",
                                "Wooden sword", "Bokken", "Rapier", "Claymore", "Letter Opener",
                                "X-acto Knife", "Boxcutter", "Machete", "Hooked Sword", "Saber", 
				};

		String[] pistolKind = {
				"Tattoo Gun", "Squirt Gun", "Nerf Gun", "Flare Gun", 
                                "Peashooter", "9mm", "Revolver", "357 Magnum",
				"Uzi", "Novelty Lighter",
				};

		String[] offcespplyKind = {
				"Staple Gun", 
				"Coffee Machine", 
				"Ruler", 
				"Scissors", 
				"3x5 cards", 
				"Paper Cutter", 
				"Pen Cap", 
				"Trash Can", 
				"Flowerpot", 
				"Calendar", 
				"Monitor", 
				"Drawer", 
				"Spinny Chair", 
				"Clock", 
				"Office Chair Base", 
				"Coffee Grinder", 
				"Stapler", 
				"Folded Paper Triangles"};

		String[] gloveKind = {
				"Boxing Gloves", 
				"Brass Knuckles", 
				"Silk Gloves", 
				"Latex Gloves", 
				"Gauntlets", 
				"Toe Socks", 
				"Mittens", 
				"Catcher's Mitt", 
				"Oven Mitts", 
				"Knitted Gloves"};

		String[] axeKind = {
				"Battle Axe", 
				"Hatchet", 
				"Bitchin' Guitar", 
				"Axe Body Spray", 
				"Tomahawk", 
				"Fire Axe", 
		};

		String[] fncysntaKind = {
				"Fancy Santa", 
				"Very Fancy Santa", 
				"VERY Fancy Santa", 
				"Santa Figurine", 
				"Christmas Ornament", 
				"Garden Gnome", 
                                "Novelty Mug",
		};

		String[] whipKind = {
				"Wiimote", 
				"1/2 Bow", 
				"Lasso", 
				"Whip", 
				"Bullwhip", 
				"Jump Rope", 
				"Steel Cable", 
				"Dog Leash", 
                                "Cord",
                                "Electrical Cable",
                                "Chainwhip",
                                "Long scarf", 
		};

		String[] hammerKind = {
				"Sledgehammer", 
				"War Hammer", 
				"Claw Hammer", 
				"Ballpeen Hammer", 
				"Meat Tenderizer", 
				"Smith's Hammer", 
				"Hammerhead Shark", 
				"MC Hammer Memorabilia", 
				"Mallet", 
				"Hammer", 
				"Rubber Mallet", 
				"Reflex Hammer", 
				"Peanut Brittle Hammer", 
                                "Bell clapper", 
		};

		String[] clubKind = {
				"Baseball Bat", 
				"Golf Club", 
				"Night Stick", 
				"Bowling Pin", 
				"Juggling Clubs", 
				"Hockey Stick", 
				"Large Stick", 
                                "Cards",
                                "Dance party lego set",
		};

		String[] clawKind = {
				"Wolverine Claws", 
				"Bagh Nakh", 
				"Fake Fingernails", 
                                "Demigauntlets", 
                                "Bare claws", 
                                "Claw & Fang Necklace", 
                                "Shed Megafauna Claw", 
		};

		String[] chainsawKind = {
				"Chainsword", 
				"Chainaxe", 
				"Chainstaff", 
				"Chainsaw", 
                                "Chainwhip (bladed)", 
		};

		String[] makeupKind = {
				"Eyeshadow Compact", 
				"Perfume", 
				"Facepaint", 
				"Mascara Stick", 
				"Eyelash Curler", 
				"Nail Polish", 
				"Hairspray", 
				"Lipstick", 
				"Comb", 
		};

		String[] umbrellaKind = {
				"Umbrella Sword", 
				"Personal Parasol", 
                                "Beach Parasol", 
				"Drink Accessory", 
				"Black Umbrella", 
                                "Travel Umbrella", 
                                "Doorman Umbrella",
                                "Bubble Umbrella", 
                                "Fashion Umbrella"
		};

		String[] scytheKind = {
				"Farming Scythe", 
				"Miniature Novelty Scythe", 
				"Sickle", 
				"Scythe", 
                                "Lawnmower",
		};

		String[] spearKind = {
				"Spear", 
				"Javelin", 
				"Hawaiian Sling", 
				"Spearmint Gum", 
				"Bohemian Earpsoon", 
				"Pike", 
				"Halberd", 
				"Large Silverware", 
				"Lance", 
				"Pointy Stick", 
                                "Boar Spear", 
                                "Wrought-Iron Fencepost",
		};

		String[] needleKind = {
				"Knitting Needles", 
				"Twig", 
				"Crochet Needle", 
				"Hypodermic Needle", 
				"Recordplayer Needle", 
				"Tattoo Gun", 
				"Shitty Wand", 
                                "Crochet Needle", 
                                "Sewing needle", 
                                "Needle Gun",
                                "Sewing Machine", 
                                "Conductor's Wand",
		};

		String[] bowKind = {
				"Short Bow", 
				"Compound Bow", 
                                "Recurve Bow", 
				"Cross Bow", 
				"Fancy Silk Bow", 
				"Long Bow", 
                                "Violin Bow", 
                                "Cello Bow", 
                                "Large Ribbon", 
		};

		String[] diceKind = {
				"Cup Of Six-siders", 
				"8 8-sided dice", 
				"20-sided Die", 
				"Brick of 6-sided dice", 
				"Lonely Ivory 12-sider", 
				"Golden Percentile Dice", 
				"Pop-o-Matic",
                                "Square Crate", 
		};

		String[] bitridentKind = {
				"Double Fork", 
				"Double Pitchfork", 
				"2x3Trident", 
                                "Fence Fragment", 
		};

		String[] guitarKind = {
				"Electric Guitar", 
				"12-string Guitar", 
				"Ukelele", 
				"Bitchin' Axe", 
				"Acoustic Guitar", 
		};

		String[] knifeKind = {
				"Pocket Knife", 
				"Dagger", 
				"Kukri", 
				"Sai", 
				"Throwing Knife", 
				"Dirk", 
				"Shiv", 
				"Bayonet", 
				"Butterfly Knife", 
				"Letter Opener", 
				"Palette Knife", 
				"Machete", 
				"Scalpel", 
				"X-acto Knife", 
				"Steak Knife", 
		};

		String[] grenadeKind = {
				"Smoke Grenades", 
				"Flash Grenades", 
				"Molotov Cocktails", 
				"Water Balloons", 
				"Glitter-filled Easter Eggs", 
				"Frag Grenades", 
                                "Foraging Toy", 
		};

		String[] staffKind = {
				"Bo Staff", 
				"Quarterstaff", 
				"Scepter", 
				"Pool Cue", 
                                "Sheetmusic", 
		};

		String[] rifleKind = {
				"Machine Gun", 
				"Shotgun", 
				"Sniper Rifle", 
				"Unconvincing Musket Replica", 
				"Harpoon Gun", 
				"Paintball Gun", 
		};

		String[] maceKind = {
				"Flail", 
				"Morning Star", 
				"Nunchucks", 
				"Scepter", 
				"Pepper Spray", 
				"Mace", 
		};

		String[] explosivesKind = {
				"Fireworks", 
				"Dynamite", 
				"C4", 
				"Claymores", 
				"Gunpowder Keg", 
				"Cherrybombs", 
				"Confetti Poppers", 
		};

		String[] projectileKind = {
				"Throwing Knives", 
				"Shuriken", 
				"Kunai", 
				"Pencils", 
				"Folded Paper Triangles", 
				"Darts", 
		};

		String[] wrenchKind = {
				"Pipe Wrench", 
				"Monkey Wrench", 
				"Socket Wrench", 
				"Hex Nut Wrench", 
				"Crescent Wrench", 
		};

		String[] screwdriverKind = {
				"Phillips Screwdriver", 
				"Electric Screwdriver", 
				"Sonic Screwdriver toy", 
				"Hex Nut Spanner", 
				"Flathead Screwdriver", 
		};

		String[] pizzactrKind = {
				"Rotary Fabric Shears", 
				"Strange Dremel Attatchment", 
				"Boxcutter", 
				"Laser-Guided Pizza Cutter", 
				"Rotary Knife", 
				"Pizza Cutter", 
                                "Rotary Sawblade", 
		};

		String[] batKind = {
				"Wooden Bat", 
				"Aluminum Bat", 
				"Vampire Bat", 
				"Board with a Nail in it", 
				"Plastic Bat", 
				"Scepter", 
				"Taxidermied Bat", 
		};

		String[] rollpinKind = {
				"Silicon-coated Rolling Pin", 
				"Glass Rolling Pin", 
				"Plastic Rolling Pin", 
				"Glass Bottle", 
				"Large Jar", 
				"Soupcan", 
				"Scepter", 
				"Wooden Table Leg", 
				"Wooden Rolling Pin", 
		};

		String[] yoyoKind = {
				"Pro-Quality Yoyo", 
				"Light-up Yoyo", 
				"Bobbin on a String", 
				"Stargate Commemorative Yoyo", 
				"Dale Earnheart Commemorative Yoyo", 
				"Shitty Yoyo", 
		};

		String[] scissorKind = {
				"Shepherd's Shears", 
				"Safety Scissors", 
				"Kitchen Scissors", 
				"Frighteningly Rusty Scissors", 
				"Gardening Shears", 
				"Scissors", 
		};

		String[] peprspryKind = {
				"Child-safe Pepper Spray", 
				"Minty Fresh Pepper Spray", 
				"Jalapeno Pepper Spray", 
				"Salt and Pepper Spray", 
				"Pepper Spray", 
				"1/2 Pepper Shaker",
		};

		String[] crowbarKind = {
				"Crooked Stick", 
				"Hockey Stick", 
				"Bent Metal Pipe", 
				"Bent Golf Club", 
				"Crowbar", 
		};

		String[] broomKind = {
				"Swiffer Sweeper", 
				"Broom", 
				"Pushbroom", 
                                "Crumb Sweeper", 
		};

		String[] pokerKind = {
				"Cast Iron Poker", 
				"Silver Gilt Poker", 
				"Filigreed Poker", 
				"Slightly Burnt Stick", 
				"Crowbar", 
				"Metal Pipe",
                                "Cards", 
		};

		String[] icepickKind = {
				"Ice Pick", 
				"Rock Hammer", 
				"Miner's Pick", 
		};

		String[] golfclubKind = {
				"Wedge", 
				"9-Iron", 
				"Driver", 
				"Putter", 
				"Long Stick",
                                "Clubhouse Lego Set",
		};

		String[] ropeKind = {
				"Climbing Rope", 
				"Frayed Hemp Rope", 
				"Silk Rope", 
                                "Nylon Rope", 
                                "Carbon-Fiber Rope", 
		};

		String[] shovelKind = {
				"Shovel", 
				"Foldable Camp Shovel", 
				"Large Spade", 
				"Garden Trowel", 
				"Mason's Spade", 
		};

		String[] spoonKind = {
				"Wooden Spoon", 
				"Silver Spoon", 
				"Stirring Spoon", 
				"Soup Spoon", 
				"Tea Spoon", 
                                "Large Scoop", 
                                "Absinthe Spoon", 
		};

		String[] statueKind = {
				"Anime Figurine", 
				"Wizard Statue", 
				"Fancy Santa", 
				"Dragon Figurine", 
				"Garden Gnome", 
				"Precious Moments Figurine", 
				"Marble Bust", 
                                "Amiibo", 
                                "Gargoyle", 
		};

		String[] spatulaKind = {
				"Shitty Dollarstore Spatula", 
				"Silicone Spatula", 
                                "Black Plastic Flippydoo", 
		};

		String[] lampKind = {
				"Lava Lamp", 
				"Lampshade", 
				"Electric Lamp", 
				"Antique Oil Lamp", 
                                "Headlamp", 
		};

		String[] ballKind = {
				"Soccer Ball", 
				"Baseball", 
				"Basketball", 
				"Bowling Ball", 
				"Ball Bearings", 
				"Watermelon", 
				"Formal Stationary", 
		};

		String[] rakeKind = {
				"Pitchfork", 
				"Hoe", 
				"Fine-tooth Rake", 
				"Wide-tooth Rake", 
				"Comb", 
		};

		String[] plankKind = {
				"Board with a Nail in it", 
				"Mahogany Board", 
				"Aged Oak Board", 
				"Teak Board", 
				"Marble Countertop", 
				"Board with a Face on it", 
                                "Motherboard", 
		};

		String[] forkKind = {
				"Salad Fork", 
				"Dinner Fork", 
				"Bent Fork", 
				"Two-tined Fork", 
                                "Tuning Fork", 
                                "Dowsing Rod", 
				"Trident", 
				"Pitchfork", 
		};

		String[] caneKind = {
				"Ivory Cane", 
				"Sword Cane", 
				"Teak Cane", 
				"Steel Cane", 
				"Walking Stick", 
				"1/2 Staff", 
				"Scepter", 
				"Tapdancing Cane", 
				"Cheerleader Baton", 
		};

		String[] chainKind = {
				"Thick Metal Chain", 
				"Jewelry Chain", 
				"Plastic Chain", 
				"Chain Letter", 
                                "Kusarigama", 
                                "Manriki", 
                                "Meteor Hammer", 
                                "Bolas", 
                                "Flail", 
                                "Nunchaku", 
		};

		String[] tablelegKind = {
				"Wooden Table Leg", 
				"Aluminum Table Leg", 
				"Incredibly Ornate Table Leg", 
				"Metal Chair Leg", 
				"Plastic Table Leg", 
				"Office Chair Base", 
		};

		String[] peprmillKind = {
				"Salt Shaker", 
				"Garlic Mill", 
				"Coffee Grinder", 
				"Electric Coffee Grinder", 
				"Mortar and Pestle", 
				"Peppermill", 
				"Dale Earnhardt Commemorative Peppermill", 
		};

		String[] hckystckKind = {
				"Hockey Stick", 
				"Large Crowbar", 
				"9-Iron", 
				"Casey Jones Commemorative Hockey Stick", 
		};

		String[] vacuumKind = {
				"Hand Vacuum", 
				"Standing Vacuum", 
				"Antique Vacuum", 
				"Vacuum Tube", 
		};

		String[] mopKind = {
				"Mop", 
				"Wig", 
				"Shitty Mop", 
		};

		String[] trophyKind = {
				"Bowling Trophy", 
				"Golfing Trophy", 
				"Treasured Memorabilia", 
		};

		String[] ladleKind = {
				"Soup Ladle", 
				"Shitty Soup Ladle", 
				"Archimedes Commemorative Soup Ladle", 
		};

		String[] cordKind = {
				"Extension Cord", 
				"Shoelace", 
				"Climbing Rope", 
				"Headphone Cord", 
				"Power Cord", 
				"TV Cord", 
		};

		String[] sawKind = {
				"Electric Saw", 
				"Handsaw", 
				"Serrated Knife", 
				"Horror DVD", 
				"Large Metal Saw", 
				"Bonesaw", 
		};

		String[] cleaverKind = {
				"Cleaver", 
				"Rusty Old Cleaver", 
				"Antique Chinese Cleaver", 
		};

		String[] iceskateKind = {
				"Shitty Iceskates", 
				"Iceskates", 
				"Rollerblades", 
		};

		String[] bookKind = {
				"Large Medical Tome", 
				"Unabridged Dictionary", 
				"Sassacre's Daunting Tome", 
				"Encyclopedia", 
				"Self-Help Pamphlet", 
				"Journal", 
		};

		String[] bustKind = {
				"Greek Muse Bust", 
				"Musician Bust", 
				"Disney Villain Bust", 
				"Scientist Bust", 
				"Historical Figure Bust", 
				"Narcissistic Bust", 
				"Marble Bust", 
				"Actor Bust", 
		};

		String[] pipeKind = {
				"PVC Pipe", 
				"Corncob Pipe", 
				"Lead Pipe", 
		};

		String[] tongsKind = {
				"Smith's Tongs", 
				"Pliers", 
				"Frightening Dentistry Tool", 
				"Salad Tongs", 
		};

		String[] fireextKind = {
				"Carbon Dioxide Extinguisher", 
				"Foam Extinguisher", 
				"Chemical Extinguisher", 
				"Bucket of Water", 
				"Bucket of Sand", 
                                "Fire Blanket", 
		};

		String[] bowlngpinKind = {
				"Bowling Pin", 
				"Juggling Club", 
		};

		String[] woodwindKind = {
				"Oboe", 
				"Piccolo", 
				"Clarinet", 
				"Pan Pipes", 
		};

		String[] candlstckKind = {
				"Candelabra", 
				"Wrought Iron Candlestick", 
				"Tealight Holder", 
				"Silver Candlestick", 
		};

		String[] paddleKind = {
				"Pastry Paddle", 
				"Boat Oar", 
				"1/2 Paddleball", 
				"Tennis Racket", 
				"Ping Pong Paddle", 
				"Mixing Spoon", 
		};

		String[] barbwireKind = {
				"Barbed Wire Circlet", 
				"Barbed Wire Whip", 
				"Barbed Wire Club", 
                                "Knotted Rope", 
                                "Beaded Rope",
		};

		String[] dartKind = {
				"Lawn Dart", 
				"Throwing Dart", 
				"Tranquilizer Dart", 
		};

		String[] marbleKind = {
				"Swirly Glass Marble", 
				"Clear Glass Marble", 
				"Shooter Marble", 
				"Colored Marble", 
				"Marble Countertop", 
				"Marble Bust", 
		};

		String[] chiselKind = {
				"Wood Chisel", 
				"Metal Chisel", 
				"Art Marker",
		};

		String[] aerosolKind = {
				"Bugspray", 
				"Pepperspray", 
				"Axe Body Spray", 
				"Canned Whip Cream", 
				"Cheez-Whiz", 
				"Hairspray", 
		};

		String[] shoeKind = {
				"Tapdancing Shoes", 
				"Steel-toed Shoes", 
				"Diving Flippers", 
				"Ballerina Slippers", 
				"Sneakers", 
				"Rollerblades", 
				"Toesocks", 
				"Animal Slippers", 
				"Hiking Boots", 
		};

		String[] puppetKind = {
				"Creepy Doll", 
				"Sock Puppet", 
				"Muppet", 
				"Smuppet", 
				"Ventriloquist's Dummy", 
		};

		String[] coatKind = {
				"Sweatshirt", 
				"Weighted Coat", 
				"Armored Coat", 
				"Jacket", 
		};

		String[] plierKind = {
				"Needle-nose Pliers", 
				"Roundtip Pliers", 
				"Wirecutters", 
		};

		String[] fanKind = {
				"Paper Fan", 
				"Electric Fan", 
				"Handheld Electric Fan", 
				"Steel Folding Fan", 
		};

		String[] brassKind = {
				"Brass Knuckles", 
				"Saxophone", 
				"Trumpet", 
				"Trombone", 
				"Tuba", 
				"Brass Sword", 
				"Brass Hammer", 
				"Bullet Casings",
		};

		String[] rockKind = {
				"Dwayne Johnson Action Figure", 
				"Stone", 
				"Rock", 
				"Boulder", 
				"Electric Guitar", 
				"Bitchin' Guitar", 
				"Pebble", 
		};

		String[] fistKind = {
				"Brass Knuckles", 
				"Class Ring", 
				"Gaudy Rings", 
				"Can-opener Ring", 
				"Gauntlets", 
				"Fingerless Gloves", 
				"Mittens", 
				"Boxing Gloves", 
                                "Bare hands",
                                "Toesocks", 
		};


		if (Specibus=="bladeKind")           {var = bladeKind[rand.nextInt(bladeKind.length)];};
		if (Specibus=="axeKind")               {var = axeKind[rand.nextInt(axeKind.length)];};
		if (Specibus=="clawKind")             {var = clawKind[rand.nextInt(clawKind.length)];};
		if (Specibus=="scytheKind")         {var = scytheKind[rand.nextInt(scytheKind.length)];};
		if (Specibus=="knifeKind")           {var = knifeKind[rand.nextInt(knifeKind.length)];};
		if (Specibus=="cleaverKind")       {var = cleaverKind[rand.nextInt(cleaverKind.length)];};
		if (Specibus=="spearKind")           {var = spearKind[rand.nextInt(spearKind.length)];};
		if (Specibus=="bitridentKind")   {var = bitridentKind[rand.nextInt(bitridentKind.length)];};
		if (Specibus=="whipKind")             {var = whipKind[rand.nextInt(whipKind.length)];};
		if (Specibus=="hammerKind")         {var = hammerKind[rand.nextInt(hammerKind.length)];};
		if (Specibus=="clubKind")             {var = clubKind[rand.nextInt(clubKind.length)];};
		if (Specibus=="staffKind")           {var = staffKind[rand.nextInt(staffKind.length)];};
		if (Specibus=="maceKind")             {var = maceKind[rand.nextInt(maceKind.length)];};
		if (Specibus=="icepickKind")       {var = icepickKind[rand.nextInt(icepickKind.length)];};
		if (Specibus=="bowKind")               {var = bowKind[rand.nextInt(bowKind.length)];};
		if (Specibus=="needleKind")         {var = needleKind[rand.nextInt(needleKind.length)];};
		if (Specibus=="projectileKind") {var = projectileKind[rand.nextInt(projectileKind.length)];};
		if (Specibus=="dartKind")             {var = dartKind[rand.nextInt(dartKind.length)];};
		if (Specibus=="pistolKind")         {var = pistolKind[rand.nextInt(pistolKind.length)];};
		if (Specibus=="rifleKind")           {var = rifleKind[rand.nextInt(rifleKind.length)];};
		if (Specibus=="chainsawKind")     {var = chainsawKind[rand.nextInt(chainsawKind.length)];};
		if (Specibus=="grenadeKind")       {var = grenadeKind[rand.nextInt(grenadeKind.length)];};
		if (Specibus=="explosivesKind") {var = explosivesKind[rand.nextInt(explosivesKind.length)];};
		if (Specibus=="batKind")               {var = batKind[rand.nextInt(batKind.length)];};
		if (Specibus=="ballKind")             {var = ballKind[rand.nextInt(ballKind.length)];};
		if (Specibus=="fanKind")               {var = fanKind[rand.nextInt(fanKind.length)];};
		if (Specibus=="diceKind")             {var = diceKind[rand.nextInt(diceKind.length)];};
		if (Specibus=="yoyoKind")             {var = yoyoKind[rand.nextInt(yoyoKind.length)];};
		if (Specibus=="paddleKind")         {var = paddleKind[rand.nextInt(paddleKind.length)];};
		if (Specibus=="gloveKind")           {var = gloveKind[rand.nextInt(gloveKind.length)];};
		if (Specibus=="makeupKind")         {var = makeupKind[rand.nextInt(makeupKind.length)];};
		if (Specibus=="umbrellaKind")     {var = umbrellaKind[rand.nextInt(umbrellaKind.length)];};
		if (Specibus=="caneKind")             {var = caneKind[rand.nextInt(caneKind.length)];};
		if (Specibus=="iceskateKind")     {var = iceskateKind[rand.nextInt(iceskateKind.length)];};
		if (Specibus=="shoeKind")             {var = shoeKind[rand.nextInt(shoeKind.length)];};
		if (Specibus=="coatKind")             {var = coatKind[rand.nextInt(coatKind.length)];};
		if (Specibus=="ropeKind")             {var = ropeKind[rand.nextInt(ropeKind.length)];};
		if (Specibus=="chainKind")           {var = chainKind[rand.nextInt(chainKind.length)];};
		if (Specibus=="cordKind")             {var = cordKind[rand.nextInt(cordKind.length)];};
		if (Specibus=="barbwireKind")     {var = barbwireKind[rand.nextInt(barbwireKind.length)];};
		if (Specibus=="offcespplyKind") {var = offcespplyKind[rand.nextInt(offcespplyKind.length)];};
		if (Specibus=="tablelegKind")     {var = tablelegKind[rand.nextInt(tablelegKind.length)];};
		if (Specibus=="bookKind")             {var = bookKind[rand.nextInt(bookKind.length)];};
		if (Specibus=="statueKind")         {var = statueKind[rand.nextInt(statueKind.length)];};
		if (Specibus=="trophyKind")         {var = trophyKind[rand.nextInt(trophyKind.length)];};
		if (Specibus=="bustKind")             {var = bustKind[rand.nextInt(bustKind.length)];};
		if (Specibus=="pizzactrKind")     {var = pizzactrKind[rand.nextInt(pizzactrKind.length)];};
		if (Specibus=="puppetKind")         {var = puppetKind[rand.nextInt(puppetKind.length)];};
		if (Specibus=="peprmillKind")     {var = peprmillKind[rand.nextInt(peprmillKind.length)];};
		if (Specibus=="rollpinKind")       {var = rollpinKind[rand.nextInt(rollpinKind.length)];};
		if (Specibus=="spoonKind")           {var = spoonKind[rand.nextInt(spoonKind.length)];};
		if (Specibus=="spatulaKind")       {var = spatulaKind[rand.nextInt(spatulaKind.length)];};
		if (Specibus=="forkKind")             {var = forkKind[rand.nextInt(forkKind.length)];};
		if (Specibus=="ladleKind")           {var = ladleKind[rand.nextInt(ladleKind.length)];};
		if (Specibus=="tongsKind")           {var = tongsKind[rand.nextInt(tongsKind.length)];};
		if (Specibus=="peprspryKind")     {var = peprspryKind[rand.nextInt(peprspryKind.length)];};
		if (Specibus=="aerosolKind")       {var = aerosolKind[rand.nextInt(aerosolKind.length)];};
		if (Specibus=="fireextKind")       {var = fireextKind[rand.nextInt(fireextKind.length)];};
		if (Specibus=="scissorKind")       {var = scissorKind[rand.nextInt(scissorKind.length)];};
		if (Specibus=="sawKind")               {var = sawKind[rand.nextInt(sawKind.length)];};
		if (Specibus=="chiselKind")         {var = chiselKind[rand.nextInt(chiselKind.length)];};
		if (Specibus=="wrenchKind")         {var = wrenchKind[rand.nextInt(wrenchKind.length)];};
		if (Specibus=="screwdriverKind") {var = screwdriverKind[rand.nextInt(screwdriverKind.length)];};
		if (Specibus=="crowbarKind")       {var = crowbarKind[rand.nextInt(crowbarKind.length)];};
		if (Specibus=="pipeKind")             {var = pipeKind[rand.nextInt(pipeKind.length)];};
		if (Specibus=="plierKind")           {var = plierKind[rand.nextInt(plierKind.length)];};
		if (Specibus=="broomKind")           {var = broomKind[rand.nextInt(broomKind.length)];};
		if (Specibus=="pokerKind")           {var = pokerKind[rand.nextInt(pokerKind.length)];};
		if (Specibus=="shovelKind")         {var = shovelKind[rand.nextInt(shovelKind.length)];};
		if (Specibus=="rakeKind")             {var = rakeKind[rand.nextInt(rakeKind.length)];};
		if (Specibus=="vacuumKind")         {var = vacuumKind[rand.nextInt(vacuumKind.length)];};
		if (Specibus=="mopKind")               {var = mopKind[rand.nextInt(mopKind.length)];};
		if (Specibus=="plankKind")           {var = plankKind[rand.nextInt(plankKind.length)];};
		if (Specibus=="golfclubKind")     {var = golfclubKind[rand.nextInt(golfclubKind.length)];};
		if (Specibus=="hckystckKind")     {var = hckystckKind[rand.nextInt(hckystckKind.length)];};
		if (Specibus=="bowlngpinKind")   {var = bowlngpinKind[rand.nextInt(bowlngpinKind.length)];};
		if (Specibus=="woodwindKind")     {var = woodwindKind[rand.nextInt(woodwindKind.length)];};
		if (Specibus=="brassKind")           {var = brassKind[rand.nextInt(brassKind.length)];};
		if (Specibus=="guitarKind")         {var = guitarKind[rand.nextInt(guitarKind.length)];};
		if (Specibus=="rockKind")             {var = rockKind[rand.nextInt(rockKind.length)];};
		if (Specibus=="lampKind")             {var = lampKind[rand.nextInt(lampKind.length)];};
		if (Specibus=="candlstckKind")   {var = candlstckKind[rand.nextInt(candlstckKind.length)];};
		if (Specibus=="fncysntaKind")     {var = fncysntaKind[rand.nextInt(fncysntaKind.length)];};
		if (Specibus=="fistKind")             {var = fistKind[rand.nextInt(fistKind.length)];};

		return var;
	}
	
	
	
	
	
	
}
