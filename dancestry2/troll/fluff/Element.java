package troll.fluff;
import java.util.Arrays;
import java.util.Random;
@SuppressWarnings("unused")


public class Element {
	Random rand = new Random();
	String[] subtype = {
                    // Most of the results should be
			"periodic", "classic", "planescape", "off", "wuxing", "misc", "pokemon",
			"periodic", "classic", "planescape", "off", "wuxing", "misc", "pokemon2",
			"noms", "material", "metal", "alchemy", "flower", "gem", 
			"noms", "material", "metal", "alchemy", "flower", "gem",
                    // but every so often, toss in some 
                        "planets", "majorarcana", "hexagrams", "covens", "spellschool", "domain"
        };
				
	public String getelement(String code) {
		String var = new String(code);
		var = subtype();  										// set it to a random option
		if (Arrays.asList(subtype).contains(code)) {var=code;}; // but if code is a valid one, use it
		
		if (var.equals("flower"))     {var=getflower();};
		if (var.equals("wuxing"))     {var=getwuxing();};
		if (var.equals("hexagrams"))  {var=gethexagram();};
		if (var.equals("alchemy"))    {var=getalchemy();};
		if (var.equals("planets"))    {var=getplanets();};
		if (var.equals("pokemon"))    {var=getpokemon();};		
		if (var.equals("pokemon2"))   {var=getpokemon2();};		
		if (var.equals("majorarcana")){var=getmajorarcana();};		
		if (var.equals("metal"))      {var=getmetal();};
		if (var.equals("material"))   {var=getmaterial();};
		if (var.equals("noms"))       {var=getnoms();};
		if (var.equals("off"))        {var=getoff();};
		if (var.equals("gem"))        {var=getgem();};
		if (var.equals("misc"))       {var=getmisc();};
		if (var.equals("planescape")) {var=getplanescape();};
		if (var.equals("classic"))    {var=getclassic();};
		if (var.equals("aristotle"))  {var=getaristotle();};
		if (var.equals("humour"))     {var=gethumour();};
		if (var.equals("periodic"))   {var=getperiodic();};
		if (var.equals("covens"))     {var=getcoven();};
		if (var.equals("spellschool")){var=getspellschool();};
		if (var.equals("domain"))     {var=getdomain();};
		// All done!
                
                var = var.toLowerCase();

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
                    "Yarrow", "Allium", "Amaranth", "Anemone", "Aster", "Azalea", 
                    "Baby's Breath", "Begonia", "Bellflower", "Bistort", "Bluet",
                    "Carnation", "Chrysanthemum", "Cornflower", "Cosmos", "Crocus",
                    "Daffodil", "Dahlia", "Daisy", "Dandelion", "Delphinium",
                    "Fairy-slipper", "Freesia", "Gardenia", "Goldenrod",
                    "Heather", "Hibiscus", "Hydrangea", "Iris", "Jacaranda",
                    "Lavender", "Lilac", "Lilly-of-the-valley", "Lily", "Mimosa",
                    "Narcissus", "Nightshade", "Orchid", "Peony", "Poinsettia",
                    "Poppy", "Rose", "Snapdragon", "Snowdrops", "Sunflower",
                    "Tulip", "Violet", "Wildflower", "Winter Cyclamen",
                    "Winter Scillia",                         
                };
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
                // main objects
		String[] set = {"sun", "mercury", "venus", "earth", "mars", 
		"jupiter", "saturn", "neptune", "uranus", "pluto",
                "other", "other", "other", "other"}; // multiple times to tweak how often it comes up
                // over 400km radius
		String[] set2 = {"ganymede", "titan", "callisto", "io", "luna", "europa",
                "triton", "eris", "haumea", "titania", "rhea", "oberon", "iapetus",
                "makemake", "gonggong", "charon", "umbriel", "ariel", "dione", 
                "quaoar", "tethys", "sedna", "ceres", "orcus", "salacia",
                "other", "other", "other", "other", "other", "other", "other"};
                // 200-399 km radius
                String[] set3 = {"varda", "ixion", "dysnomia", "varuna", "chaos", 
                "vesta", "pallas 2", "enceladus", "miranda", "dziewanna", "vanth",
                "hygeia", "proteus", "huya", "Gǃkúnǁʼhòmdímà", 
                "other", "other", "other", "other", "other", "other", "other"};
                // 100-299 km radius
                String[] set4 = {"mimas", "nereid", "interamnia", "ilmare", "europa", 
                "hi'laka", "davida", "actaea", "sylvia", "lemp", "eunomia", "hyperion",
                "euphrosyne", "chariklo", "juno", "hiisi", "hektor", "sila", 
                "altjira", "cybele", "nunam", "bamberga", "patientia", "psyche", 
                "ceto", "herculina", "thisbe", "doris", "chiron", "phoebe", "fortuna", 
                "camilla", "themis", "amphitrite", "egeria", "iris", 
                "other", "other", "other", "other", "other", "other", "other"};
                // 50-99 km radius
                String[] set5 = {"electra", "bienor", "hebe", "larissa", "ursula", 
                "eugenia", "hermione", "aurora", "daphne", "bertha", "janus", 
                "teharonhiawako", "aegle", "galatea", "phorcys", "palma", 
                "metis", "alauda", "hilda", "himalia", "namaka", "weywot", 
                "freia", "amalthea", "agamemnon", "elpis", "eleonara", "nemesis",
                "puck", "sycorax", "io", "minerva", "alexandra", "laetitia",
                "nemausa", "kalliope", "despina", "manwe", "pales", "parthenope", 
                "arethusa", "pulcova", "flora", "ino", "adeona", "irene", "melpomene", 
                "lamberta", "aglaja", "patroclus", "julia", "hesperia", "typhon", 
                "massalla", "portia", "emma", "paha", "lucina", "sawiskera",
                "achilles", "panopaea", "thule", "borasisi", "hestia", "leto",
                "undina", "bellona", "diana", "anchises", "bernardinelli-bernstein",
                "galatea", "deiphobus", "aneas", "kleopatra", "athamantis", "diomedes",
                "terpsichore", "epimetheus", "victoria", "circe", "leda", "odysseus", 
                "alcathous", "melete", "mnemosyne", "nestor", "harmonia", "euterpe", 
                "antilochus", "thorondor", "thalia", "erato", "astraea", "Leleākūhonua",
                "pabu", "eos", "aegina", "leukothea", "menoetius", "isis", "klotho",
                "trollus"};
                
		var=set[rand.nextInt(set.length)];
                if (var=="other") {var=set2[rand.nextInt(set2.length)];};
                if (var=="other") {var=set3[rand.nextInt(set3.length)];};
                if (var=="other") {var=set4[rand.nextInt(set4.length)];};
                if (var=="other") {var=set5[rand.nextInt(set5.length)];};
                
                boolean commonobject = Arrays.asList(set).contains(var);
                if (!commonobject) {var = var + " (solar system object)";};
		return var;
	}

	private String getpokemon() {
		String var = "";
		String[] set = {
				"normal", "fire", "water", "grass", "electric", "ice", "fighting", "poison",
				"ground", "flying", "psychic", "bug", "rock", "ghost", "dark", "dragon",
				"steel", "fairy"};
		var=set[rand.nextInt(set.length)];
                var = var + " type";
		return var;
	}

       	private String getpokemon2() {
            // Allows double-typing, and assigns them loosely based on actual commonality
		String var = "";
                int x = rand.nextInt(0, 10161); 
                int t = 0; // running total
                t=t+700;   if (x>t) {var="Water";};
                t=t+440;   if (x>t) {var="Grass";};
                t=t+390;   if (x>t) {var="Psychic";};
                t=t+350;   if (x>t) {var="Fire";};
                t=t+330;   if (x>t) {var="Electric";};
                t=t+290;   if (x>t) {var="Fighting";};
                t=t+260;   if (x>t) {var="Normal/Flying";};
                t=t+200;   if (x>t) {var="Fairy";};
                t=t+190;   if (x>t) {var="Bug";};
                t=t+190;   if (x>t) {var="Ice";};
                t=t+170;   if (x>t) {var="Ground";};
                t=t+160;   if (x>t) {var="Poison";};
                t=t+160;   if (x>t) {var="Ghost";};
                t=t+140;   if (x>t) {var="Flying/Bug";};
                t=t+140;   if (x>t) {var="Poison/Grass";};
                t=t+140;   if (x>t) {var="Rock";};
                t=t+130;   if (x>t) {var="Dragon";};
                t=t+130;   if (x>t) {var="Dark";};
                t=t+120;   if (x>t) {var="Poison/Bug";};
                t=t+110;   if (x>t) {var="Rock/Water";};
                t=t+110;   if (x>t) {var="Steel";};
                t=t+90;    if (x>t) {var="Flying/Psychic";};
                t=t+90;    if (x>t) {var="Ground/Rock";};
                t=t+90;    if (x>t) {var="Ground/Water";};
                t=t+80;    if (x>t) {var="Flying/Water";};
                t=t+80;    if (x>t) {var="Steel/Psychic";};
                t=t+80;    if (x>t) {var="Psychic/Fairy";};
                t=t+70;    if (x>t) {var="Flying/Grass";};
                t=t+70;    if (x>t) {var="Poison/Dark";};
                t=t+70;    if (x>t) {var="Rock/Steel";};
                t=t+70;    if (x>t) {var="Ghost/Fire";};
                t=t+70;    if (x>t) {var="Water/Ice";};
                t=t+60;    if (x>t) {var="Normal/Psychic";};
                t=t+60;    if (x>t) {var="Fighting/Fire";};
                t=t+60;    if (x>t) {var="Flying/Fire";};
                t=t+60;    if (x>t) {var="Flying/Dragon";};
                t=t+60;    if (x>t) {var="Flying/Dark";};
                t=t+60;    if (x>t) {var="Poison/Water";};
                t=t+60;    if (x>t) {var="Ground/Ghost";};
                t=t+60;    if (x>t) {var="Ground/Dragon";};
                t=t+60;    if (x>t) {var="Rock/Bug";};
                t=t+60;    if (x>t) {var="Bug/Steel";};
                t=t+60;    if (x>t) {var="Bug/Grass";};
                t=t+60;    if (x>t) {var="Ghost/Grass";};
                t=t+60;    if (x>t) {var="Water/Dark";};
                t=t+50;    if (x>t) {var="Normal/Dark";};
                t=t+50;    if (x>t) {var="Normal/Fairy";};
                t=t+50;    if (x>t) {var="Fighting/Grass";};
                t=t+50;    if (x>t) {var="Flying/Electric";};
                t=t+50;    if (x>t) {var="Ground/Steel";};
                t=t+50;    if (x>t) {var="Rock/Fire";};
                t=t+50;    if (x>t) {var="Bug/Water";};
                t=t+50;    if (x>t) {var="Water/Psychic";};
                t=t+50;    if (x>t) {var="Grass/Dragon";};
                t=t+50;    if (x>t) {var="Grass/Fairy";};
                t=t+50;    if (x>t) {var="Psychic/Ice";};
                t=t+40;    if (x>t) {var="Normal/Fighting";};
                t=t+40;    if (x>t) {var="Fighting/Poison";};
                t=t+40;    if (x>t) {var="Fighting/Psychic";};
                t=t+40;    if (x>t) {var="Fighting/Dark";};
                t=t+40;    if (x>t) {var="Flying/Rock";};
                t=t+40;    if (x>t) {var="Bug/Fire";};
                t=t+40;    if (x>t) {var="Bug/Electric";};
                t=t+40;    if (x>t) {var="Ghost/Psychic";};
                t=t+40;    if (x>t) {var="Ghost/Dragon";};
                t=t+40;    if (x>t) {var="Steel/Electric";};
                t=t+40;    if (x>t) {var="Steel/Dragon";};
                t=t+40;    if (x>t) {var="Steel/Fairy";};
                t=t+40;    if (x>t) {var="Fire/Psychic";};
                t=t+40;    if (x>t) {var="Water/Fairy";};
                t=t+40;    if (x>t) {var="Grass/Psychic";};
                t=t+40;    if (x>t) {var="Grass/Dark";};
                t=t+40;    if (x>t) {var="Dragon/Dark";};
                t=t+30;    if (x>t) {var="Normal/Grass";};
                t=t+30;    if (x>t) {var="Fighting/Bug";};
                t=t+30;    if (x>t) {var="Fighting/Steel";};
                t=t+30;    if (x>t) {var="Fighting/Water";};
                t=t+30;    if (x>t) {var="Flying";};
                t=t+30;    if (x>t) {var="Flying/Poison";};
                t=t+30;    if (x>t) {var="Flying/Ground";};
                t=t+30;    if (x>t) {var="Flying/Ghost";};
                t=t+30;    if (x>t) {var="Flying/Steel";};
                t=t+30;    if (x>t) {var="Flying/Fairy";};
                t=t+30;    if (x>t) {var="Poison/Ground";};
                t=t+30;    if (x>t) {var="Poison/Ghost";};
                t=t+30;    if (x>t) {var="Poison/Dragon";};
                t=t+30;    if (x>t) {var="Ground/Fire";};
                t=t+30;    if (x>t) {var="Ground/Ice";};
                t=t+30;    if (x>t) {var="Ground/Dark";};
                t=t+30;    if (x>t) {var="Rock/Electric";};
                t=t+30;    if (x>t) {var="Ghost/Steel";};
                t=t+30;    if (x>t) {var="Ghost/Water";};
                t=t+30;    if (x>t) {var="Steel/Grass";};
                t=t+30;    if (x>t) {var="Steel/Ice";};
                t=t+30;    if (x>t) {var="Fire/Dragon";};
                t=t+30;    if (x>t) {var="Fire/Dark";};
                t=t+30;    if (x>t) {var="Water/Grass";};
                t=t+30;    if (x>t) {var="Water/Electric";};
                t=t+30;    if (x>t) {var="Water/Dragon";};
                t=t+30;    if (x>t) {var="Grass/Electric";};
                t=t+30;    if (x>t) {var="Electric/Dragon";};
                t=t+30;    if (x>t) {var="Psychic/Dragon";};
                t=t+30;    if (x>t) {var="Psychic/Dark";};
                t=t+30;    if (x>t) {var="Dark/Fairy";};
                t=t+20;    if (x>t) {var="Normal/Ground";};
                t=t+20;    if (x>t) {var="Normal/Ghost";};
                t=t+20;    if (x>t) {var="Normal/Fire";};
                t=t+20;    if (x>t) {var="Normal/Electric";};
                t=t+20;    if (x>t) {var="Normal/Dragon";};
                t=t+20;    if (x>t) {var="Fighting/Flying";};
                t=t+20;    if (x>t) {var="Fighting/Dragon";};
                t=t+20;    if (x>t) {var="Flying/Ice";};
                t=t+20;    if (x>t) {var="Poison/Fire";};
                t=t+20;    if (x>t) {var="Poison/Electric";};
                t=t+20;    if (x>t) {var="Poison/Psychic";};
                t=t+20;    if (x>t) {var="Ground/Bug";};
                t=t+20;    if (x>t) {var="Ground/Psychic";};
                t=t+20;    if (x>t) {var="Rock/Grass";};
                t=t+20;    if (x>t) {var="Rock/Psychic";};
                t=t+20;    if (x>t) {var="Rock/Ice";};
                t=t+20;    if (x>t) {var="Rock/Dragon";};
                t=t+20;    if (x>t) {var="Rock/Fairy";};
                t=t+20;    if (x>t) {var="Bug/Psychic";};
                t=t+20;    if (x>t) {var="Bug/Ice";};
                t=t+20;    if (x>t) {var="Bug/Fairy";};
                t=t+20;    if (x>t) {var="Ghost/Dark";};
                t=t+20;    if (x>t) {var="Steel/Dark";};
                t=t+20;    if (x>t) {var="Grass/Ice";};
                t=t+20;    if (x>t) {var="Electric/Ice";};
                t=t+20;    if (x>t) {var="Electric/Fairy";};
                t=t+20;    if (x>t) {var="Ice/Dark";};
                t=t+10;    if (x>t) {var="Normal/Poison";};
                t=t+10;    if (x>t) {var="Normal/Water";};
                t=t+10;    if (x>t) {var="Fighting/Rock";};
                t=t+10;    if (x>t) {var="Fighting/Ghost";};
                t=t+10;    if (x>t) {var="Fighting/Ice";};
                t=t+10;    if (x>t) {var="Poison/Rock";};
                t=t+10;    if (x>t) {var="Poison/Fairy";};
                t=t+10;    if (x>t) {var="Ground/Grass";};
                t=t+10;    if (x>t) {var="Ground/Electric";};
                t=t+10;    if (x>t) {var="Rock/Dark";};
                t=t+10;    if (x>t) {var="Bug/Ghost";};
                t=t+10;    if (x>t) {var="Ghost/electric";};
                t=t+10;    if (x>t) {var="Ghost/Ice";};
                t=t+10;    if (x>t) {var="Ghost/Fairy";};
                t=t+10;    if (x>t) {var="Steel/Fire";};
                t=t+10;    if (x>t) {var="Steel/Water";};
                t=t+10;    if (x>t) {var="Fire/Water";};
                t=t+10;    if (x>t) {var="Fire/Electric";};
                t=t+10;    if (x>t) {var="Fire/Ice";};
                t=t+10;    if (x>t) {var="Electric/Psychic";};
                t=t+10;    if (x>t) {var="Electric/Dark";};
                t=t+10;    if (x>t) {var="Ice/Dragon";};
                t=t+10;    if (x>t) {var="Ice/Fairy";};
                t=t+10;    if (x>t) {var="Dragon/Fairy";};
                t=t+2;     if (x>t) {var="Normal/Rock";};
                t=t+2;     if (x>t) {var="Normal/Bug";};
                t=t+2;     if (x>t) {var="Normal/Steel";};
                t=t+2;     if (x>t) {var="Normal/Ice";};
                t=t+2;     if (x>t) {var="Fighting/Ground";};
                t=t+2;     if (x>t) {var="Fighting/Electric";};
                t=t+2;     if (x>t) {var="Fighting/Fairy";};
                t=t+2;     if (x>t) {var="Poison/Steel";};
                t=t+2;     if (x>t) {var="Poison/Ice";};
                t=t+2;     if (x>t) {var="Ground/Fairy";};
                t=t+2;     if (x>t) {var="Rock/Ghost";};
                t=t+2;     if (x>t) {var="Bug/Dragon";};
                t=t+2;     if (x>t) {var="Bug/Dark";};
                t=t+2;     if (x>t) {var="Fire/Grass";};
                t=t+2;     if (x>t) {var="Fire/Fairy";};
                t=t+700;   if (x>t) {var="Normal";};
                var = var + " Type";
		return var;
	}

	private String getmetal() {
		String var = "";
		String[] set = {
				"copper", "silver", "gold", "lead", "iron", "steel", "platinum", "chrome",
				"tungsten", "tin", "mercury", "brass", "bronze", "neodymium", "electrum",
                                "titanium", "nickle", "zinc", };
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
				"cream of tartar", "almond", "water", "sweets", "tea"};
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

	private String getmajorarcana() {
		String var = "";
		String[] card = {
                    "The Fool", "The Magician", "The High Priestess", "The Empress", "The Emperor", "The Hierophant", 
                    "The Lovers", "The Chariot", "Justice", "The Hermit", "The Wheel Of Fortune", "Strength",
                    "The Hanged Man", "Death", "Temperance", "The Devil", "The Tower", "The Star", "The Moon", 
                    "The Sun", "Judgement", "The World"};
		var=card[rand.nextInt(card.length)];
		return var;
	}

      	// https://en.wikipedia.org/wiki/List_of_hexagrams_of_the_I_Ching
	private String gethexagram() {
		String var = "";
		String[] tile = {
                    "䷀ The Creative Heaven",
                    "䷁ The Receptive Earth",
                    "䷂ Difficulty at the Beginning",
                    "䷃ Youthful Folly",
                    "䷄ Waiting",
                    "䷅ Conflict",
                    "䷆ The Army",
                    "䷇ Holding Together",
                    "䷈ Small Taming",
                    "䷉ Treading",
                    "䷊ Greatness, Peace",
                    "䷋ Standstill",
                    "䷌ Fellowship",
                    "䷍ Great Possession",
                    "䷎ Modesty",
                    "䷏ Excess, Enthusiasm",
                    "䷐ Following",
                    "䷑ Work on the Decayed",
                    "䷒ The Forest, Approach",
                    "䷓ Contemplation",
                    "䷔ Biting Through",
                    "䷕ Grace",
                    "䷖ Splitting Apart",
                    "䷗ Return",
                    "䷘ Innocence",
                    "䷙ Great Taming",
                    "䷚ Swallowing",
                    "䷛ Great Preponderance",
                    "䷜ The Abysmal Water",
                    "䷝ The Clinging Fire",
                    "䷞ Influence",
                    "䷟ Duration",
                    "䷠ Retreat",
                    "䷡ Great Power",
                    "䷢ Progress",
                    "䷣ Darkening of the Light",
                    "䷤ The Family",
                    "䷥ Opposition",
                    "䷦ Obstruction",
                    "䷧ Deliverance",
                    "䷨ Decrease",
                    "䷩ Increase",
                    "䷪ Breakthrough",
                    "䷫ Coming to meet",
                    "䷬ Gathering Together",
                    "䷭ Pushing Upward",
                    "䷮ Oppression",
                    "䷯ The Well",
                    "䷰ Revolution",
                    "䷱ The Cauldron",
                    "䷲ The Arousing Thunder",
                    "䷳ The Still Mountain",
                    "䷴ Development",
                    "䷵ The Marrying Maiden",
                    "䷶ Abundance",
                    "䷷ The Wanderer",
                    "䷸ The Gentle Wind",
                    "䷹ The Joyous Lake",
                    "䷺ Dispersion",
                    "䷻ Limitation",
                    "䷼ Inner Truth",
                    "䷽ Small Preponderance",
                    "䷾ After Completion",
                    "䷿ Before Completion",
                };
		var=tile[rand.nextInt(tile.length)];
		return var;
	}

	private String getcoven() {
		String var = "";
		String[] set = {"Emperor's", "Abomination", "Bard", 
                    "Beast-keeping", "Construction", "Healing", "Illusion",
                    "Oracle", "Plant", "Potions", "Other"};
                String[] set2 = {"Artist", "Bakers", "Big Dog", "Carnivorous Plant",
                    "Cantrip", "Cat", "Chef's", "Cooking", "Debate", "Fashion",
                    "Flower", "History", "Incidental", "Meditation", "Menders",
                    "Oculus", "Pickup", "Pottery", "Prose", "Reaction", "Scrying",
                    "Small Cat", "Stylist", "Succulent", "Swag", "Tiniest Cat", 
                    "Wood", "Bad Girl", "Grumpy", "Rhyming"};
		var=set[rand.nextInt(set.length)];              
                if (var=="Other") {var=set2[rand.nextInt(set2.length)];};
                var = var + " Coven";
		return var;
        }

	private String getspellschool() {
		String var = "";
		String[] set = {"Abjuration", "Transmutation", "Conjuring", 
                "Divination", "Enchantment", "Evocation", "Illusion", 
                "Necromancy", "Universal", "Dunamancy", "Wild" };
		var=set[rand.nextInt(set.length)];
                var = var + " Spell School";
                if (var.equals("Wild Spell School")) {var="Wild Magic";};
		return var;
	}

	private String getdomain() {
		String var = "";
		String[] set = {"Air", "Animal", "Arcana", "Avarice", "Balance",
                "Bestial", "Blightbringer", "Cavern", "Celestial", "Change", 
                "Chaos", "Charity", "Charm", "Chastity", "Civilization", "Cold",
                "Community", "Corruption", "Craft", "Creation", "Darkness",
                "Death", "Demonic", "Destruction", "Diabolic", "Dream", "Drow", 
                "Dwarf", "Earth", "Elf", "Endurance", "Envy", "Evil", "Family", 
                "Fate", "Fey", "Fire", "Forge", "Freedom", "Generosity", "Glory",
                "Gluttony", "Gnome", "Good", "Grave", "Greed", "Halfling", 
                "Hatred", "Healing", "Herald", "Hope", "Humility", "Hunt", 
                "Illusion", "Joy", "Justice", "Knowledge", "Law", "Life", "Light", 
                "Love", "Luck", "Lust", "Madness", "Magic", "Mentalism", "Metal",
                "Mind", "Moon", "Nature", "Nobility", "Ocean", "Orc", "Order",
                "Pain", "Patience", "Peace", "Planning", "Plant", "Pleasure",
                "Poison", "Portal", "Pride", "Protection", "Radiance", "Renewal", 
                "Repose", "Retribution", "Rune", "Scalykind", "Sea", "Skill", 
                "Slime", "Sloth", "Spell", "Spider", "Storm", "Strength", "Strife", 
                "Suffering", "Sun", "Temperance", "Tempest", "Time", "Torment", 
                "Trade", "Travel", "Trickery", "Twilight", "Tyranny", "Undeath",
                "Vengeance", "War", "Watery Death", "Wilderness", "Winter",
                "Wrath", "Zeal"};
		var=set[rand.nextInt(set.length)];
                var = var + " Domain";
		return var;
	}        

	private String getmisc() {
		String var = "";
		String[] set = {
                    "Fire", "Water", "Earth", "Air", "Nature", "Death", "Light",
                    "Shadow", "Ice", "Lava", "Neon", "Wood", "Time", "Space", 
                    "Reality", "Mind", "Soul", "Snow", "Lightning", "Steam", 
                    "Smoke", "Sand", "Glass", "Gravity", "Cloud", "Metal", 
                    "Rubber", "Life", "Poison", "Moon", "Star", "Beast", 
                    "Color", "Sound", "Movement", "Strength", "Laser", "Paper", 
                    "Radiation", "Energy", "Magic", "Form", "Blood", "Clay", 
                    "Sky", "Mirror", "Spirit", "Force", "Holy", "Illusion", 
                    "Unholy", "Matter", "Comet", "Flesh", "Void", "Heart", 
                    "Arcane", "Acid", "Virus", "Balance", "Order", "Chaos", 
                    "Warding", "Dragon"
                };
		var=set[rand.nextInt(set.length)];
		return var;
	}
        
	private String gettemp() {
		String var = "";
		String[] set = {"",""};
		var=set[rand.nextInt(set.length)];
		return var;
	}

	// misc:  vespene, oil, redstone, sky, void, sound
        

        
}

