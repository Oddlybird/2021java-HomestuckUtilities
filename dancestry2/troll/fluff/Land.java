package troll.fluff;
//import java.util.Arrays;
import java.util.Random;
@SuppressWarnings("unused")

public class Land {
	String[] Landof = {"", ""};
	
	String[] genbiome =  {"", "", ""};
	String[] subbiomeA = {"", "", ""};
	String[] subbiomeB = {"", "", ""};
	String[] subbiomeC = {"", "", ""};
	
	
	public Land() {
		// take Stats and use those to bias this
		Landof[0] = getany();
		Landof[1] = getany();
		
		genbiome[0] = getterraine();
		genbiome[1] = getweather();
		genbiome[2] = getmood();

		subbiomeA[0] = getterraine();
		subbiomeB[0] = getterraine();
		subbiomeC[0] = getterraine();

		subbiomeA[1] = getany();
		subbiomeB[1] = getany();
		subbiomeC[1] = getany();

		subbiomeA[2] = getany();
		subbiomeB[2] = getany();
		subbiomeC[2] = getany();

	}

	// element.getflower
	// element.getalchemy
	// element.getpokemon
	// element.getmetal
	// element.getmaterial
	// element.getnoms
	// element.getgem
	// element.getplanescape
	// element.getperiodic

	

	private String getany() {
		Random rand = new Random();
		String var = "";
		String[] set = {
				"Atoll", "Canopy", "Canyons", "Caves", "Cliffs",
				"Brooks", "Clouds", "Coral", "Crossroads", "Forest",
				"Hedges", "Henge", "Hills", "Islands", "Jungle",
				"Labyrinth", "Lakes", "Marsh", "Meadow", "Mountains",
				"Oases", "Plains", "Prairie", "Precipice", "Rivers",
				"Savannah", "Shores", "Sky", "Steppe", "Swamp",
				"Tundra", "Wasteland", "Waterfalls", "Wilderness",
				"Art", "Books", "Cages", "Carpet", "Mirrors", "Maps", 
				"Ladders", "Lasers", "Magnets", "Nails", "Pipes", "Pistons", 
				"Platforms", "Portals", "Presents", "Prisms", "Ramps", "Springs", 
				"Stairs", "Spires", "Traps", "Treasure", "Walls", "Cubes", "Rust", 
				"Shrouds", "Song", "Spheres", "Spikes", "Windows", "Braille", 
				"Chemicals", "Circuitry", "Construction", "Electronics", 
				"Mist", "Fog", "Rain", "Rainbows", "Pollution", "Quakes", 
				"Rime", "Shade", "Snow", "Storm", "Thunder", "Twilight", 
				"Wind", "Dawn", "Gloom", "Glow", "Gust", "Hail", "Haze", 
				"Melody", "Night", "Pulse", "Rays", "Rhythm", "Rhyme", 
				"Rot", "Shadow", "Silence", "Blaze", "Autumn", "Spring",
				"Winter", "Summer", "Zephyr", "Drought", "Echo", "Irradiation",
				"Frost",
				"Abbeys", "Airports", "Banks", "Barns", "Bastilles", "Bridges", 
				"Bungalows", "Cafes", "Canteens", "Casinos", "Castles", "Cathedrals", 
				"Chapels", "Cinemas", "Clockwork", "Condos", "Conservatories", 
				"Cottages", "Datacenters", "Dungeons", "Duplexes", "Dwellings", 
				"Factories", "Farms", "Ferries", "Flats", "Fortifications", 
				"Freeholds", "Galleries", "Garages", "Gardens", "Geodesic Domes", 
				"Graves", "Greenhouses", "Harbors", "High-rises", "Hospitals", 
				"Hotels", "Huts", "Institutions", "Jails", "Libraries", "Lighthouses", 
				"Malls", "Manses", "Megastructures", "Motels", "Museums", "Offices", 
				"Orchards", "Outbuildings", "Paths", "Pavilions", "Penthouses", "Pools", 
				"Post Offices", "Power Stations", "Pubs", "Pumping Stations", "Pyramids", 
				"Quarry", "Railways", "Refineries", "Retailers", "Schools", "Shacks", 
				"Sheds", "Shelters", "Shops", "Shrines", "Stables", "Stadiums", "Stations", 
				"Subway", "Supermarkets", "Temples", "Tents", "Terminals", "Theatres", 
				"Towers", "Train Stations", "Troves", "Tunnel", "Venues", "Warehouses", 
				"Windmill", "Workplaces", "Yurts", "Ziggurats", 
				"Angels", "Butterflies", "Dolls", "Dragons", "Brains", "Ghosts", 
				"Fireflies", "Snakes", "Undead", "Griffons", "Beasts", "Wyverns", 
				"Unicorns", "Wolves", "Monsters", "Lusii", "Elementals", "Wisps",
				"Amusement", "Annoyance", "Apathy", "Blankness", "Surprise", "Terror", 
				"Beauty", "Ambiance", "Cacophony", "Charge", "Contrast", "Dance", 
				"Desolation", "Dismay", "Eldritch", "Elegance", "Fatigue", "Fear", 
				"Festivities", "Glamour", "Glitter", "Horror", "Insanity", "Insomnia", 
				"Intimidation", "Jolliness", "Juxtaposition", "Laughter", "Mirth", "Pluck", 
				"Rebirth", "Reflection", "Regret", "Repetition", "Reversal", "Stability",
				"Sadness", "Sorrow", "Shattering", "Slumber", "Solace", "Trance",
				"Tranquility", "Turmoil", "Ultraviolence", "Variety", "Wrath", "Zen",
				"Flow", 
				"Boil", "Age", "Advertisement", "Alternation", "Ascent", 
				"Backstabbing", "Buldge", "Change", "Contact", "Curses", 
				"Death", "Decor", "Depth", "Descent", "Diamond", 
				"Disease", "Dye", "Falsehood", "Fire", "Flame", 
				"Fortification", "Freefall", "Germs", "Gravity", "Hallucinations", 
				"Hats", "Heat", "Illusion", "Irrigation", "Jazz", 
				"Jokers", "Junk", "Karaoke", "Karate", "Knowledge", 
				"Law", "Laze", "Levitation", "Light", "Luck", 
				"Motion", "Noir", "Noise", "Odors", "Opposites", 
				"Presence", "Rip", "Scales", "Science", "Sentience", 
				"Silhouette", "Singe", "Sketch", "Skin", "Slate", 
				"Sluice", "Static", "Steam", "Strings", "Suction", 
				"Teeth", "Thought", "Tinsel", "Transit", "Travel", 
				"Turmoil", "Urns", "Vacuum", "Veil", "Vibration", 
				"War", "Warmth", "Water", "Womb", "Wood", 
				"Yarn", "Yore"			
				};
		int rare = rand.nextInt(16);
		var=set[rand.nextInt(set.length)];
		if (rare==1) {var=getnatural();};
		if (rare==2) {var=getartificial();};
		if (rare==3) {var=getweather();};
		if (rare==4) {var=getstructures();};
		if (rare==5) {var=getcritter();};
		if (rare==6) {var=getmood();};
		if (rare==7) {var=getmisc();};
		if (rare==8) {var=getterraine();};
		
		return var;
	}

	private String getterraine() {
		String var = new String("");
		Random rand = new Random();
		String[] set = {
				"Atoll", "Canopy", "Canyons", "Caves", "Cliffs",
				"Brooks", "Clouds", "Coral", "Crossroads", "Forest",
				"Hedges", "Henge", "Hills", "Islands", "Jungle",
				"Labyrinth", "Lakes", "Marsh", "Meadow", "Mountains",
				"Oases", "Plains", "Prairie", "Precipice", "Rivers",
				"Savannah", "Shores", "Sky", "Steppe", "Swamp",
				"Tundra", "Wasteland", "Waterfalls", "Wilderness",
				"getStructure", "Ocean", "Sea", 
				};
		var=set[rand.nextInt(set.length)];
		if (var=="getStructure") {var="Endless " + getstructures();};
		
		return var;
	}
	
 	private String getnatural() {
		Random rand = new Random();
		String var = "";
		String[] set = {
				"Bamboo", "Holly", "Dew", "Moss", "Fungi", "Grass", "Acid",
				"Cacti", "Chains", "Evergreens", "Flowers", "Holes", "Mushrooms", 
				"Pumpkins", "Spices", "Vines", "Fossils", "Stumps", "Bubbles",
				"Topiary", "Ice", "Sponge", "Thorns", "Hay", "Dirt", "Dust",
				"Silt", "Slime", "Vapor", "Waves", "Ore", "GetFlower", "GetMat"
				};
		var=set[rand.nextInt(set.length)];
		if (var=="GetFlower") {Element e = new Element(); var=e.getelement("flower");};
		if (var=="GetMat")    {Element e = new Element(); var=e.getelement("material");};
		return var;
	}
	
 	private String getartificial() {
		Random rand = new Random();
		String var = "";
		String[] set = {
				"Art", "Books", "Cages", "Carpet", "Mirrors", "Maps", 
				"Ladders", "Lasers", "Magnets", "Nails", "Pipes", "Pistons", 
				"Platforms", "Portals", "Presents", "Prisms", "Ramps", "Springs", 
				"Stairs", "Spires", "Traps", "Treasure", "Walls", "Cubes", "Rust", 
				"Shrouds", "Song", "Spheres", "Spikes", "Windows", "Braille", 
				"Chemicals", "Circuitry", "Construction", "Electronics", 
				};
		var=set[rand.nextInt(set.length)];
		return var;
	}
 	
 	private String getweather() {
		Random rand = new Random();
		String var = "";
		String[] set = {
				"Mist", "Fog", "Rain", "Rainbows", "Pollution", "Quakes", 
				"Rime", "Shade", "Snow", "Storm", "Thunder", "Twilight", 
				"Wind", "Dawn", "Gloom", "Glow", "Gust", "Hail", "Haze", 
				"Melody", "Night", "Pulse", "Rays", "Rhythm", "Rhyme", 
				"Rot", "Shadow", "Silence", "Blaze", "Autumn", "Spring",
				"Winter", "Summer", "Zephyr", "Drought", "Echo", "Irradiation",
				"Frost"
				};
		var=set[rand.nextInt(set.length)];
		return var;
	}

 	private String getstructures() {
		Random rand = new Random();
		String var = "";
		String[] set = {
				"Abbeys", "Airports", "Banks", "Barns", "Bastilles", "Bridges", 
				"Bungalows", "Cafes", "Canteens", "Casinos", "Castles", "Cathedrals", 
				"Chapels", "Cinemas", "Clockwork", "Condos", "Conservatories", 
				"Cottages", "Datacenters", "Dungeons", "Duplexes", "Dwellings", 
				"Factories", "Farms", "Ferries", "Flats", "Fortifications", 
				"Freeholds", "Galleries", "Garages", "Gardens", "Geodesic Domes", 
				"Graves", "Greenhouses", "Harbors", "High-rises", "Hospitals", 
				"Hotels", "Huts", "Institutions", "Jails", "Libraries", "Lighthouses", 
				"Malls", "Manses", "Megastructures", "Motels", "Museums", "Offices", 
				"Orchards", "Outbuildings", "Paths", "Pavilions", "Penthouses", "Pools", 
				"Post Offices", "Power Stations", "Pubs", "Pumping Stations", "Pyramids", 
				"Quarry", "Railways", "Refineries", "Retailers", "Schools", "Shacks", 
				"Sheds", "Shelters", "Shops", "Shrines", "Stables", "Stadiums", "Stations", 
				"Subway", "Supermarkets", "Temples", "Tents", "Terminals", "Theatres", 
				"Towers", "Train Stations", "Troves", "Tunnel", "Venues", "Warehouses", 
				"Windmill", "Workplaces", "Yurts", "Ziggurats", 
				};
		var=set[rand.nextInt(set.length)];
		return var;
	}
	
 	private String getcritter() {
		Random rand = new Random();
		Element e = new Element();
		String var = "";
		String[] set = {
				"Angels", "Butterflies", "Dolls", "Dragons", "Brains", "Ghosts", 
				"Fireflies", "Snakes", "Undead", "Griffons", "Beasts", "Wyverns", 
				"Unicorns", "Wolves", "Monsters", "Lusii", "Elementals", "Wisps"
				};
		var=set[rand.nextInt(set.length)];
		// Add Element?
		int rare = rand.nextInt(99);	boolean addelement = false;
		if (rare>80) {addelement=true;};
		if (var=="Elementals") {addelement=true;};
		if ((var=="Wisps")&&(rare>40)) {addelement=true;};

		rare = rand.nextInt(99);		boolean addsize = false;	String size = "";
		if (rare>95) {size = "Immense";   addsize = true;};
		if (rare>80) {size = "Giant";     addsize = true;};
		if (rare<20) {size = "Miniature"; addsize = true;};
		if (rare<5) {size = "Teeny Tiny"; addsize = true;};
		
		if (addelement) {var = e.getelement("") + " " + var;};
		if (addsize) {var = size + " " + var;};
		
		return var;
	}
 	
 	private String getmood() {
		Random rand = new Random();
		String var = "";
		String[] set = {
				"Amusement", "Annoyance", "Apathy", "Blankness", "Surprise", "Terror", 
				"Beauty", "Ambiance", "Cacophony", "Charge", "Contrast", "Dance", 
				"Desolation", "Dismay", "Eldritch", "Elegance", "Fatigue", "Fear", 
				"Festivities", "Glamour", "Glitter", "Horror", "Insanity", "Insomnia", 
				"Intimidation", "Jolliness", "Juxtaposition", "Laughter", "Mirth", "Pluck", 
				"Rebirth", "Reflection", "Regret", "Repetition", "Reversal", "Stability",
				"Sadness", "Sorrow", "Shattering", "Slumber", "Solace", "Trance",
				"Tranquility", "Turmoil", "Ultraviolence", "Variety", "Wrath", "Zen",
				"Flow", 
				};
		var=set[rand.nextInt(set.length)];
		return var;
	}

 	private String getmisc() {
 		// aka "misc"
		Random rand = new Random();
		String var = "";
		String[] set = {
				"Boil", "Age", "Advertisement", "Alternation", "Ascent", 
				"Backstabbing", "Buldge", "Change", "Contact", "Curses", 
				"Death", "Decor", "Depth", "Descent", "Diamond", 
				"Disease", "Dye", "Falsehood", "Fire", "Flame", 
				"Fortification", "Freefall", "Germs", "Gravity", "Hallucinations", 
				"Hats", "Heat", "Illusion", "Irrigation", "Jazz", 
				"Jokers", "Junk", "Karaoke", "Karate", "Knowledge", 
				"Law", "Laze", "Levitation", "Light", "Luck", 
				"Motion", "Noir", "Noise", "Odors", "Opposites", 
				"Presence", "Rip", "Scales", "Science", "Sentience", 
				"Silhouette", "Singe", "Sketch", "Skin", "Slate", 
				"Sluice", "Static", "Steam", "Strings", "Suction", 
				"Teeth", "Thought", "Tinsel", "Transit", "Travel", 
				"Turmoil", "Urns", "Vacuum", "Veil", "Vibration", 
				"War", "Warmth", "Water", "Womb", "Wood", 
				"Yarn", "Yore"				
				};
		var=set[rand.nextInt(set.length)];
		return var;
	}

 	
 	
 	
 	
 	
 	
 	
 	
 	
	
	
	
}



/*
 
 	
 	private String getword() {
		Random rand = new Random();
		String var = "";
		String[] set = {
				"", "", "", "", "", "", 
				"", "", "", "", "", "", 
				"", "", "", "", "", "", 
				"", "", "", "", "", "", 
				"", "", "", "", "", "", 
				"", "", "", "", "", ""
				};
		var=set[rand.nextInt(set.length)];
		return var;
	}

 
 */
