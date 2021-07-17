package troll.fluff;
import java.util.Arrays;
import java.util.Random;
@SuppressWarnings("unused")

public class Element {
	Random rand = new Random();
	String[] subtype = {
			"periodic", "classic", "planescape", "gem",
			"off", "noms", "material", "metal", "pokemon", 
			"planets", "alchemy", "wuxing", "flower"};
	// yin yang extended philosophical elements?  the i ching thing.
	//--------------------bagua, https://en.wikipedia.org/wiki/Bagua
	// tarot cards?
	// chess pieces? (incl extended)
	// misc:  vespene, oil, redstone, sky, void, sound
	
			
	public String getelement(String code) {
		String var = new String(code);
		var = subtype();  										// set it to a random option
		if (Arrays.asList(subtype).contains(code)) {var=code;}; // but if code is a valid one, use it
		
		if (var=="flower")     {var=getflower();};
		if (var=="wuxing")     {var=getwuxing();};
		if (var=="alchemy")    {var=getalchemy();};
		if (var=="planets")    {var=getplanets();};
		if (var=="pokemon")    {var=getpokemon();};		
		if (var=="metal")      {var=getmetal();};
		if (var=="material")   {var=getmaterial();};
		if (var=="noms")       {var=getnoms();};
		if (var=="off")        {var=getoff();};
		if (var=="gem")        {var=getgem();};
		if (var=="planescape") {var=getplanescape();};
		if (var=="classic")    {var=getclassic();};
		if (var=="aristotle")  {var=getaristotle();};
		if (var=="humour")     {var=gethumour();};
		if (var=="periodic")   {var=getperiodic();};
		// All done!

		return var;
	}

	public String subtype() {
		Random rand = new Random();
		String var = new String("");
		var = subtype[rand.nextInt(subtype.length)];
		return var;
	}

	// a public method that chooses a list of X unique options all from the same list
	// and purposefully chooses a list that is large enough to contain x.

	private String getflower() {
		String var = "";
		String[] set = {
				"Lily", "Allium", "Lilly-of-the-valley", "Aster", "Baby's Breath", "Orchid", "Carnation", "Chrysanthemum", 
				"Yarrow", "Cosmos", "Cornflower", "Daffodil", "Dahlia", "Daisy", "Freesia", "Gardenia", 
				"Goldenrod", "Heather", "Hydrangea", "Iris", "Lilac", "Lavender", "Mimosa", "Narcissus", 
				"Peony", "Poppy", "Rose", "Snapdragon", "Poinsettia", "Sunflower", "Tulip", };
		var=set[rand.nextInt(set.length)];
		var = var.toLowerCase();
		return var;
	}

	private String getalchemy() {
		String var = "";
		String[] set = {
				"oil of vitriol", "aqua fortis", "spirit of turpentine", "aqua regia", "aqua vitae", "blue vitriol", 
				"brimstone", "oil of antimony", "quicksilver", "caustic potash", "caustic soda", "nitre", 
				"saltpetre", "fool's gold", "green vitriol", "gum arabic", "quicklime", "lunar caustic", 
				"lye", "potash", "pearlash", "milk of sulfur", "natron", "oil of tartar", 
				"powder of algaroth", "red vitriol", "sal ammoniac", "butter of tin", "sugar of lead", "sweet vitriol", 
				"verdigris", "white vitriol"};
		var=set[rand.nextInt(set.length)];
		return var;
	}

	private String getwuxing() {
		String var = "";
		String[] off = {"fire", "water", "earth", "wood", "metal"};
		var=off[rand.nextInt(off.length)];
		return var;
	}

	private String getplanets() {
		String var = "";
		String[] set = {
				"sun", "moon", "mercury", "venus", "earth", "mars", "ceres",
				"jupiter", "saturn", "neptune", "uranus", "pluto"};
		var=set[rand.nextInt(set.length)];
		return var;
	}

	private String getpokemon() {
		String var = "";
		String[] set = {
				"normal", "fire", "water", "grass", "electric", "ice", "fighting", "poison",
				"ground", "flying", "psychic", "bug", "rock", "ghost", "dark", "dragon",
				"steel", "fairy"};
		var=set[rand.nextInt(set.length)];
		return var;
	}

	private String getmetal() {
		String var = "";
		String[] set = {
				"copper", "silver", "gold", "lead", "iron", "steel", "platinum", "chrome",
				"tungsten", "tin", "mercury"};
		var=set[rand.nextInt(set.length)];
		return var;
	}

	private String getmaterial() {
		String var = "";
		String[] set = {
				"concrete", "brick", "cement", "paper", "cotton", "silk", "polymer", "plastic",
				"ceramic", "stone", "sand", "adamantine", "mithril", "kevlar", "alloy", "bone",
				"ash", "burlap", "clay", "cobblestone", "loam", "leaves", "rubber", 
				"magma", "obsidian", "steel", "ebony", "ivory", "powder", "velvet", "crystal",
				"oil", "quartz", "rock", "wax", "glass", "graphite", "fur", "glue", "ink", 
				};
		var=set[rand.nextInt(set.length)];
		return var;
	}

	private String getnoms() {
		String var = "";
		String[] noms = {
				"milk", "wheat", "alcohol", "coffee", "chocolate", "cookie", "sugar", "orange creamsicle",
				"pumpkin", "egg", "flour", "sodium bicarbonate", "vanilla", "deadly neurotoxin", "oil", "salt",
				"cream of tartar", "almond extract", "water", "sweets", "tea"};
		var=noms[rand.nextInt(noms.length)];
		return var;
	}

	private String getoff() {
		String var = "";
		String[] off = {"smoke", "sugar", "meat", "plastic", "metal"};
		var=off[rand.nextInt(off.length)];
		return var;
	}

	private String getgem() {
		String var = "";
		String[] geologic = {
				"adularia moonstone", "alexandrite", "almandine", "amazonite", "amber", "amethyst", "ametrine",
				"ammolite", "andesine", "apatite", "aquamarine", "azurite", "beryl", "biotite", "bloodstone", 
				"bort diamond", "bronzite", "calcite", "californite", "carnelian", "caulk", "chalcedony", "chalk",
				"chroite tourmaline", "chrome tourmaline", "chrysoberyl", "chrysocolla", "cinnabar", "citrine", 
				"coal", "coral", "corundum", "cryolite", "cubic zirconia", "cuprite", "cylonite spinel", "demantoid", 
				"dendritic agate", "diamond", "diopside", "dioptase", "dravite tourmaline", "druzy", "elbaite tourmaline",
				"emerald", "euclase","feldspar", "fire agate","fire opal","flint","fluorite", "fordite","garnet", "glass", 
				"golden beryl", "sea glass", "goshenite","graphite", "gypsum", "halite", "heliodor", "hematite", "hessonite", 
				"howlite", "indicolite tourmaline", "iolite","iris agate", "jacinth zircon", "jade", "jadeite", "jasper", "jet", 
				"kainite", "kunzite", "kyanite", "labradorite", "lace agate", "lapis","lazurite","leucite","listwanite mica", 
				"malachite", "malaia garnet","marble", "melanite", "mica", "microcline", "milky quartz", "moissanite", "moonstone", 
				"morganite","moss agate", "nacre","nephrite","obsidian", "olenite tourmaline", "onyx agate","onyx", 
				"opal", "orange topaz", "orthoclase","padparadscha sapphire","painite", "paraiba tourmaline", "pearl", 
				"periclase", "peridot","petrified wood", "pitersite", "prasiolite","prismatine", "purpurite", "pyrite",
				"pyromorphite","pyrope", "pyrrhotite", "quartz", "radiolarite","rainbow moonstone", "red beryl", "rhodolite", 
				"rhodonite", "rock crystal","rose quartz", "rossmanite tourmaline","rubellite tourmaline", "ruby", 
				"rust", "rutile", "sanidine","sapphire","sard", "sardonyx agate", "selenite", "serpentine", "shale", 
				"smoky quartz", "soapstone", "sodalite", "spessartine","spessartite", "spinel", "sugilite", "sulfur", 
				"sunstone","sylvite","taaffeite", "talc","tantalite", "tanzanite","thaumasite", "thulite", "tigers eye", 
				"topaz","topazolite","tourmaline","trapiche emerald", "tremolite", "tsavorite", "turquoise", "variscite", 
				"wavellite", "white opal", "zircon", "zoisite"};
		var=geologic[rand.nextInt(geologic.length)];
		return var;
	}
	
	private String getplanescape() {
		String var = "";
		String[] planescape = {
				"fire", "water", "earth", "air", "light", "dark", "mud", "ash",
				"dust", "lightning", "steam", "ice", "radiance", "clay", "salt", "chaos",
				"order", "death", "smoke", "magma", "ooze", "dust", "frost", "pumice",
				"fumes", "crystal", "obsidian", "spark", "mineral", "silt"};
		var=planescape[rand.nextInt(planescape.length)];
		return var;
	}
	
	private String getclassic() {
		String var = "";
		String[] classic = {
				"fire", "water", "air", "earth", "aether", "metal", "wood"};
		var=classic[rand.nextInt(classic.length)];
		return var;
	}

	private String getaristotle() {
		String var = "";
		String[] aristotle = {"hot", "wet", "cold", "dry"};
		var=aristotle[rand.nextInt(aristotle.length)];
		return var;
	}

	private String gethumour() {
		String var = "";
		String[] humour = {"sanguine humour", "choleric humour", "melancholic humour", "phlegmatic humour"};
		var=humour[rand.nextInt(humour.length)];
		return var;
	}

	private String getperiodic() {
		String var = "";
		String[] periodic = {
				"hydrogen", "helium", "lithium", "palladium", "boron", "carbon",  "nitrogen", "oxygen",
				"fluorine", "neon", "sodium", "magnesium", "aluminum", "silicon",  "phosphorus", "sulfur",
				"chlorine", "argon", "potassium", "calcium", "silver", "titanium",  "tin", "chromium",
				"antimony", "iron", "cobalt", "nickel", "copper", "zinc",  "iodine", "xenon",
				"arsenic", "neodmium", "bromine", "krypton", "tungsten", "iridium",  "yttrium", "zirconium",
				"platinum", "gold", "mercury", "lead", "bismuth", "radon", "radium", "uranium",
				"unnseptium", "ununoctium", "ununonium"};
		var=periodic[rand.nextInt(periodic.length)];
		return var;
	}
	
}

