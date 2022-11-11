package troll.husk;
import troll.fluff.Desc;
import java.util.Random;
@SuppressWarnings("unused")

// feral overrides: 
// -- weird pupils/eyes


public class Body {
	public int heightinches = 0;
	public String height = "";
	//public String build = ""; // description
	public String buildgene = ""; 
	// char1: number between 0-9, shoulder width
	// char2: number between 0-9, waist width
	// char3: number between 0-9, hip width
	// char4: number between 0-9, breasts
	// char5: number between 0-9, butt
	// char5: number between 0-9, bulk
	public String sex = "N";
	public String gender = "?";
	public String pupation = "";
	// pupation 0 = grub form, 1 = toddler form, 2+ = spares,
	// 3char: 123 number of pupations to go through : take average.  average=9 means infinite, every 2 sweeps.
	// 2char: 11 adult legs/arms express on pupation 0, 1, 2, 3, or 4+
	// 2char: 11 middle limbs -> grubscars on pupation 0, 1, 2, 3, 4+
	// 2char: 22 wings express on pupation 0, 1, 2, 3, or 4+
	// 2char: 11 tail expresses on pupation 0, 1, 2, 3, or 4+
	public String limbgene = "";
	// 2char: Ff - Feral override, 
	// 		  ---- FF allows all feral,
	// 		  ---- Ff: no stance, limbtypes express more weakly
	// 		  ---- fF: no stance, wings, or limbtypes
	// 		  ---- ff forces all nonferal, including tail
	// 2char: DdPp  leg digitigrade/plantigrade/other spectrum.  DD Dx xD dx xd px xp Px xP PP
	// 2char: BbQq  stance biped vs quadruped
	// 2char: Bb - wingtype (Bb)butterfly/moth, (Aa)bird, (Ss)bat, (Dd)dragonfly,
	//					    (Ff)gossamer fins, (Ee)beetle, (Tt)Tentacles, other
	// 2char: PP - paw/hand/foot size PP(huge), Pp/pP(large), pp(normal). 
	// 2char: 33 - claw craziness, curvature + length.  average numbers, take floor. 3 is norm.
	public String tailgene = "";
	// 2char: Tt - tail level of expression TT(full) Tt(stunted) tT(stunted) tt (none)
	// 1char: #  - tail length in (TT)forearm-spans, (Tt)handspans or (tT)inches.
	// 1char: #  - tail width in fingerwidths
	// 2char: Rr - tail tip from horntip
	// 2char: Rr - tail type (bare, tufted, furred, mane, scale, club, clawed, spiked, horse, etc)
	public String skingene = "";
	// whether biolum is ACTIVE or not will depend on epigenetics -- psychic stat, seadweller control genes, etc.
	// 4 char : Bioluminescent Skin Patterning - Rr(rainbowdrinker) Pp(psychic) Nn Ee (none), + 
	//		  : sea - Ss(spots) Tt(stripe) Bb(blotches) Ff(freckles)
	// 2 char : body-covering materials (F/C/B)
	// -------: FF(fur), FC(Scale), FB(Feathers), CC(keratin/carapace/shell), CB(callous/skin plates), BB(bare)
	// 2 char : Darkens with age Y/N?
	// 3 char : sun-resistance : Aa Aa Aa : 3 capitals mean yes, any lowercase means no.
	// 2 char : freckles.  FF Lots, Ff some, fF less, ff none.
	// 2 char : grubscars.  Lose them after Ff first pupation, Ss second, Tthird, or Nn never.	
	//        : If lose them before they express, skip having theme entirely.
	// 1 char : # - skin thickness / carapace toughness
	//public String respiration = "";
	public String respiratorygene = "";
	// 4char:   Ss   - control.  SSSS = sea, ssss = land, Ss/sS = read from genes
	// 2char:   Bb   - air bladders.  BB many, Bb one, bb none.
	// 4char:  Ggii  - gilleyes.  GGfull, Gg half, gg none, I/E internal/external/both
	// 4char:  Ggii  - Gillneck.  GGfull, Gg half, gg none, I/E internal/external/both
	// 4char:  Ggii  - Gillribs.  GGfull, Gg half, gg none, I/E internal/external/both
	// 6char: SsBbFf - waterbreathing.  Ss salt, Bb brackish, Ff freshwater.
	// 4char:  aaaa  - airbreathing.  aaaa=no, anything else = yes +/- asthma
	public String fingene = "";
	// 2char: Ss : controls, SS sea Ss sS check and ss land
	// 2char: Ff : wfingers, FF full Ff/fF, ff no webbing.
	// 2char: Tt : wtoes, TT Tt/tT, tt no webbing.
	// 2char: Ff : dorsal fins on limbs, FF Ff fF ff none.
	// 2char: Ff : dorsal fins on body/tail, FF Ff fF ff none.
	// 2char: Nn : nictating membrane eyelids.  NN (lids), Nn nN (permanent transparent layer) nn normal land
	// 2char: Ee : ears. EE full, Ee / eE half, ee none.
	// 2char: CC : cheekfin.  CC, Cc/cC, cc.
	// 1char: 3  : cheekfin number of tines
	// 1char: 5  : cheekfin size, 5 = average seadweller. 
	// 2char: BB : cheekfin bioluminescence, BB voluntary, Bb bloodflow, bB constant, bb none.
	
	
	public Body(String blood) {
		// update it to have other arguments later
		Random rand = new Random();
		// Proportion a torso.
		buildgene = build(blood);   	// this happens to define sex
		// Specify height.
		heightinches = pickheight(blood, sex);
		height = Desc.infeet(heightinches);
		
		// for everybody
		respiratorygene = respiratory(blood);
		skingene = skin(blood);
		fingene = fin(blood);
		pupation = pupation(blood);
		tailgene = tail(blood);
		limbgene = limb(blood);
			
		// TODO Auto-generated constructor stub
	}

	public int pickheight(String blood, String sex) {
	// Default height if otherwise unspecified
		Random rand = new Random();
		int h = 72;
		if (blood.startsWith("blank")) {return h;};
		if (blood.startsWith("truerand")) {return rand.nextInt(72)+60;};
		// 5' = 60", 6' = 72", 7' = 84, 8' = 96, 9' = 108, 10' = 120, 11' = 132
		
		// apply caste modifiers
		if (blood.startsWith("RR")) {h=70;};
		if (blood.startsWith("Rr")) {h=76;};
		if (blood.startsWith("rr")) {h=80;};
		if (blood.startsWith("Rg")) {h=90;};
		if (blood.startsWith("RG")) {h=96;};
		if (blood.startsWith("Gr")) {h=94;};
		if (blood.startsWith("rg")) {h=90;};
		if (blood.startsWith("GG")) {h=90;};
		if (blood.startsWith("Gg")) {h=90;};
		if (blood.startsWith("gg")) {h=96;};
		if (blood.startsWith("Gb")) {h=93;};
		if (blood.startsWith("GB")) {h=90;};
		if (blood.startsWith("Bg")) {h=93;};
		if (blood.startsWith("gb")) {h=96;};
		if (blood.startsWith("BB")) {h=100;};
		if (blood.startsWith("Bb")) {h=110;};
		if (blood.startsWith("bb")) {h=120;};
		if (blood.startsWith("Br")) {h=100;};
		if (blood.startsWith("RB")) {h=96;};
		if (blood.startsWith("Rb")) {h=84;};
		if (blood.startsWith("rb")) {h=72;};
	
		// Mutation zone
		int delta = rand.nextInt(10);
		h = h + delta - 5;		
		if (sex=="M") {h = h + rand.nextInt(4)-1;};
		if (sex=="F") {h = h - rand.nextInt(4)-1;};

		return h;
	}
	
	public String build(String blood) {
		Blood b = new Blood(blood);
		Random rand = new Random();
		String bodyshape = new String("");
		bodyshape = "";
		if (blood.startsWith("blank"))    {bodyshape = "555555"; return bodyshape;};
		if (blood.startsWith("truerand")) {
			String[] opts = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			bodyshape = opts[rand.nextInt(opts.length)] + opts[rand.nextInt(opts.length)];
			bodyshape = bodyshape + opts[rand.nextInt(opts.length)] + opts[rand.nextInt(opts.length)];
			bodyshape = bodyshape + opts[rand.nextInt(opts.length)] + opts[rand.nextInt(opts.length)];
			sex = "N";
			if (rand.nextBoolean()) {sex="M";};
			if (rand.nextBoolean()) {sex="F";};
			return bodyshape;};
		bodyshape = Gene.mutiBlend(pickbuild(blood), pickbuild(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickbuild("rand"));	
		
		char[] a = bodyshape.toCharArray();
		// unpack bodyshape into bits
		int shoulder = a[0];   // numbers between 0 and 9, averaging 3-5
		int chest    = a[1];
		int waist    = a[2];
		int hip      = a[3];
		int butt     = a[4];
		int bulk     = a[5];
		
		int kinsey = rand.nextInt(6) - 3;
		
		// if tyrian and male, 90% -> female
		if ((b.huefromCode(blood)>314)&&(kinsey>0)&&(rand.nextInt(10)>1)) {kinsey = -1;};
		// if jade and male, 80% -> female
		if ((b.huefromCode(blood)>140)&&(b.huefromCode(blood)<170)&&(kinsey>0)&&(rand.nextInt(10)>2)) {kinsey = -1;};
		
		int masculine = 0;
		int feminine = 0;
		if (kinsey>0) {masculine = Math.abs(kinsey); sex="M";};
		if (kinsey<0) {feminine = Math.abs(kinsey);  sex="F";};

		while (masculine>0) {
			if (rand.nextInt(10)>6) {shoulder++;};
			if (rand.nextInt(10)>5) {hip--;};
			if (rand.nextInt(10)>2) {waist=hip;};
			if (rand.nextInt(10)>5) {butt--;};
			if (rand.nextInt(10)>5) {chest--;};
			if (rand.nextInt(10)>5) {bulk++;};
			masculine--;
			}
		while (feminine>0)  {
			if (rand.nextInt(10)>5) {shoulder--;};
			if (rand.nextInt(10)>4) {chest++;};
			if (rand.nextInt(10)>2) {waist--;};
			if (rand.nextInt(10)>5) {hip++;};
			if (rand.nextInt(10)>5) {butt++;};
			feminine--;}
		
		// TODO: make sure none of these numbers go negative or above 9
		
		// repack bodyshape
		a[0] = (char) shoulder;
		a[1] = (char) chest;
		a[2] = (char) waist;
		a[3] = (char) hip;
		a[4] = (char) butt;
		a[5] = (char) bulk;
		
		bodyshape = String.valueOf(a);

		return bodyshape;
	}
	
	public String pickbuild(String blood) {
		Random rand = new Random();
		String bodyshape = new String("");
		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
					"dorito", "pear", "hourglass", "apple", "twig", "big", "max", "mid", "min"};
			blood = options[rand.nextInt(options.length)];
		}
		if (blood.startsWith("truerand")) {
			String[] opts = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			bodyshape = opts[rand.nextInt(opts.length)] + opts[rand.nextInt(opts.length)];
			bodyshape = bodyshape + opts[rand.nextInt(opts.length)] + opts[rand.nextInt(opts.length)];
			bodyshape = bodyshape + opts[rand.nextInt(opts.length)] + opts[rand.nextInt(opts.length)];
			sex = "N";
			if (rand.nextBoolean()) {sex="M";};
			if (rand.nextBoolean()) {sex="F";};
			return bodyshape;};
		bodyshape = "";
		bodyshape = "534535";
	
		// Androgynous feminine with slight curves

		if (blood.startsWith("RR")) {bodyshape = "434433";}; //Maroon
		if (blood.startsWith("Rr")) {bodyshape = "534433";};
		if (blood.startsWith("rr")) {bodyshape = "634333";}; // Bronze
		if (blood.startsWith("Rg")) {bodyshape = "534433";};
		if (blood.startsWith("RG")) {bodyshape = "434332";}; // Gold
		if (blood.startsWith("Gr")) {bodyshape = "434432";};
		if (blood.startsWith("rg")) {bodyshape = "534433";}; // Lime
		if (blood.startsWith("GG")) {bodyshape = "634535";}; // Olive
		if (blood.startsWith("Gg")) {bodyshape = "644535";};
		if (blood.startsWith("gg")) {bodyshape = "653533";}; // Jade
		if (blood.startsWith("Gb")) {bodyshape = "544533";};
		if (blood.startsWith("GB")) {bodyshape = "534533";}; // Teal
		if (blood.startsWith("Bg")) {bodyshape = "534533";};
		if (blood.startsWith("gb")) {bodyshape = "534634";}; // Ceru
		if (blood.startsWith("BB")) {bodyshape = "634636";}; // Bloo
		if (blood.startsWith("Bb")) {bodyshape = "734636";};
		if (blood.startsWith("bb")) {bodyshape = "834535";}; //Indigo
		if (blood.startsWith("Br")) {bodyshape = "734635";};
		if (blood.startsWith("RB")) {bodyshape = "634735";}; //Violet
		if (blood.startsWith("Rb")) {bodyshape = "544835";};
		if (blood.startsWith("rb")) {bodyshape = "453635";}; //Tyrian

		// Some extra bodyshapes for variety's sake
		if (blood==("dorito"))    {bodyshape = "974435";};
		if (blood==("pear"))      {bodyshape = "345785";};
		if (blood==("hourglass")) {bodyshape = "674674";};
		if (blood==("apple"))     {bodyshape = "357876";};
		if (blood==("twig"))      {bodyshape = "333333";};
		if (blood==("big"))       {bodyshape = "757757";};
		if (blood==("max"))       {bodyshape = "999999";};
		if (blood==("mid"))       {bodyshape = "555555";};
		if (blood==("min"))       {bodyshape = "000000";};

		return bodyshape;
	}

	public String skin(String blood) {
		Random rand = new Random();
		String skin = new String("");
		if (blood.startsWith("blank")) {skin="NNNNnnYYaaaFFnn3";return skin;};
		if (blood=="truerand") {
			String[] a4 = {"B", "b", "R", "r", "P", "p", "N", "n", "E", "e", "S", "s", };
			String[] b2 = {"F", "C", "B"};
			String[] c2 = {"Y", "y", "N", "n"};
			String[] d3 = {"A", "a"};
			String[] e2 = {"F", "f"};
			String[] f2 = {"F", "f", "S", "s", "T", "t", "N", "n"};
			String[] g1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			skin = Gene.randopt(a4, 4) + Gene.randopt(b2, 2) + Gene.randopt(c2, 2) + Gene.randopt(d3, 3);
			skin = skin + Gene.randopt(e2, 2) + Gene.randopt(f2, 2) + Gene.randopt(g1, 1);
			return skin;
		}				
		skin = Gene.mutiBlend(pickskin(blood), pickskin(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickskin("rand"));	
		
		return skin;		
	}
	
	public String pickskin(String blood) {
		Random rand = new Random();
		String skin = "nnnnYYaaaffSS3";
		// whether biolum is ACTIVE or not will depend on epigenetics -- psychic stat, seadweller control genes, etc.
		// 4 char : Bioluminescence - Rr(rainbowdrinker) Pp(psychic) Nn Ee (none), + 
		//		  : sea - Ss(spots) Tt(stripe) Bb(blotches) Ff(freckles)
		// 2 char : body-covering materials (F/C/B)
		// -------: FF(fur), FC(Scale), FB(Feathers), CC(keratin/carapace/shell), CB(callous/skin plates), BB(bare)
		// 2 char : Darkens with age Y/N?
		// 3 char : sun-resistance : Aa Aa Aa : 3 capitals mean yes, any lowercase means no.
		// 2 char : freckles.  FF Lots, Ff some, fF less, ff none.
		// 2 char : grubscars.  Lose them after Ff first pupation, Ss second, Tthird, or Nn never.
		// 1 char : # - skin thickness / carapace toughness.  3 normal, 5+ normal highblood
		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
					"sea1", "sea2", "sea3", "sea4", "sea5", "sea6", "sea7", "sea8", "sea9", 
					"psychic1", "psychic2", "psychic3", "drinker", "first", "third",
					"never", "carapace1", "nothing"};
			blood = options[rand.nextInt(options.length)];
			}
		if (blood=="truerand") {
			String[] a4 = {"B", "b", "R", "r", "P", "p", "N", "n", "E", "e", "S", "s", };
			String[] b2 = {"F", "C", "B"};
			String[] c2 = {"Y", "y", "N", "n"};
			String[] d3 = {"A", "a"};
			String[] e2 = {"F", "f"};
			String[] f2 = {"F", "f", "S", "s", "T", "t", "N", "n"};
			String[] g1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			skin = Gene.randopt(a4, 4) + Gene.randopt(b2, 2) + Gene.randopt(c2, 2) + Gene.randopt(d3, 3);
			skin = skin + Gene.randopt(e2, 2) + Gene.randopt(f2, 2) + Gene.randopt(g1, 1);
			return skin;
		}				
		
		if (blood.startsWith("RR")) {skin="ppPpFFYyaaaffSS3";}; //Maroon
		if (blood.startsWith("Rr")) {skin="ppppFFyYaaaFFSS3";};
		if (blood.startsWith("rr")) {skin="ppppFFYyaaaffSS3";}; // Bronze
		if (blood.startsWith("Rg")) {skin="PpPpFFyYaaaFFSS3";};
		if (blood.startsWith("RG")) {skin="PPPPBFYyaAaffSS3";}; // Gold
		if (blood.startsWith("Gr")) {skin="pPpPFByYaaaFFSS3";};
		if (blood.startsWith("rg")) {skin="pPPpBFYyaaAffSS3";}; // Lime
		if (blood.startsWith("GG")) {skin="NNnnFFyYaaaffSS3";}; // Olive
		if (blood.startsWith("Gg")) {skin="NrnRBFYyaaaFFSS3";};
		if (blood.startsWith("gg")) {skin="RRrrBByYAAAffSS3";}; // Jade
		if (blood.startsWith("Gb")) {skin="NnRrBBYyaAaFFSS3";};
		if (blood.startsWith("GB")) {skin="nnnnBByYaaaffSS3";}; // Teal
		if (blood.startsWith("Bg")) {skin="NNNNBBYyaaAFFSS3";};
		if (blood.startsWith("gb")) {skin="enNECByYaaaffSS3";}; // Ceru
		if (blood.startsWith("BB")) {skin="neENBCYyaaaffSS4";}; // Bloo
		if (blood.startsWith("Bb")) {skin="sSsSCCyYAaaFFSS4";};		       // spots
		if (blood.startsWith("bb")) {skin="NNnNCCYyaaaffSS5";}; //Indigo
		if (blood.startsWith("Br")) {skin="SsSsFCyYaAaFFSS5";};
		if (blood.startsWith("RB")) {skin="sStTFCYyaaaffSS6";}; //Violet
		if (blood.startsWith("Rb")) {skin="TtTtFCyYAaaFFSS6";}; 	       // stripes
		if (blood.startsWith("rb")) {skin="FFffFCYyaaaffSS7";}; //Tyrian   // freckles
		
		if (blood=="sea1")      {skin="BBBBFCYYaaaFFSS4";};
		if (blood=="sea2")      {skin="bbbbFCYYaaaFfSS4";};
		if (blood=="sea3")      {skin="TTTTFCYYaaaffSS4";};
		if (blood=="sea4")      {skin="SSSSFCYYaaaFFSS4";};
		if (blood=="sea5")      {skin="ssssFCYYaaaFfSS4";};
		if (blood=="sea6")      {skin="ttttFCYYaaaffSS4";};
		if (blood=="sea7")      {skin="FFFFFCYYaaaFFSS4";};
		if (blood=="sea8")      {skin="FfFfFCYYaaaFfSS4";};
		if (blood=="sea9")      {skin="ffffFCYYaaaffSS4";};
		if (blood=="psychic1")  {skin="PPPPFFYYaaafFSS0";};
		if (blood=="psychic2")  {skin="ppPpFFYYaaaFFSS3";};
		if (blood=="psychic3")  {skin="ppPpFFYYaaaFFSS3";};
		if (blood=="drinker")   {skin="RRRRBBYYAAAffSS8";};
		if (blood=="first")     {skin="nnpnBBYYaaaFffF0";};
		if (blood=="third")     {skin="npnnBBYYaaafFTt5";};
		if (blood=="never")     {skin="nnnnBBYYaaafFNN9";};
		if (blood=="carapace1") {skin="NNNNCCYYaaaffSS9";};
		if (blood=="nothing")   {skin="NNNNBBYYaaaffSS0";};

		return skin;
	}
	
	public String respiratory(String blood) {
		Random rand = new Random();
		String var = new String("");
		if (blood.startsWith("blank")) {var = "ssssbbggiiggiiggiissbbffAAAA";return var;};
		if (blood=="truerand") {
			String[] Ss = {"S", "s"};
			String[] Bb = {"B", "b"};
			String[] Gg = {"G", "g"};
			String[] ie = {"i", "e"};
			String[] Ff = {"F", "f"};
			String[] Aa = {"A", "a"};
			var = Gene.randopt(Ss, 4) + Gene.randopt(Bb, 2) + Gene.randopt(Gg, 2) + Gene.randopt(ie, 2);
			var = var + Gene.randopt(Gg, 2) + Gene.randopt(ie, 2) + Gene.randopt(Gg, 2) + Gene.randopt(ie, 2);
			var = var + Gene.randopt(Ss, 2) + Gene.randopt(Bb, 2) + Gene.randopt(Ff, 2) + Gene.randopt(Aa, 4);
			return var;
		}				
		var = Gene.mutiBlend(pickrespiratory(blood), pickrespiratory(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickrespiratory("rand"));			
		return var;		
	}
	
	public String pickrespiratory(String blood) {
		Blood b = new Blood(blood);
 		Random rand = new Random();
		String var = new String();
		var = "ssssbbggiiggiiggiissbbffAAAA";
		// 4char:   Ss   - control.  SSSS = sea, ssss = land, Ss/sS = read from genes
		// 2char:   Bb   - air bladders.  BB many, Bb one, bb none.
		// 4char:  Ggii  - gilleyes.  GGfull, Gg half, gg none, I/E internal/external/both
		// 4char:  Ggii  - Gillneck.  GGfull, Gg half, gg none, I/E internal/external/both
		// 4char:  Ggii  - Gillribs.  GGfull, Gg half, gg none, I/E internal/external/both
		// 6char: SsBbFf - waterbreathing.  Ss salt, Bb brackish, Ff freshwater.
		// 4char:  aaaa  - airbreathing.  aaaa=no, anything else = yes +/- asthma
		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
				"land", "sea", "deepsea", "landsea", "sealand", "river", "nonviable","seahidden"};
			blood = options[rand.nextInt(options.length)];
			} // end rand
		if (blood=="truerand") {
			String[] Ss = {"S", "s"};
			String[] Bb = {"B", "b"};
			String[] Gg = {"G", "g"};
			String[] ie = {"i", "e"};
			String[] Ff = {"F", "f"};
			String[] Aa = {"A", "a"};
			var = Gene.randopt(Ss, 4) + Gene.randopt(Bb, 2) + Gene.randopt(Gg, 2) + Gene.randopt(ie, 2);
			var = var + Gene.randopt(Gg, 2) + Gene.randopt(ie, 2) + Gene.randopt(Gg, 2) + Gene.randopt(ie, 2);
			var = var + Gene.randopt(Ss, 2) + Gene.randopt(Bb, 2) + Gene.randopt(Ff, 2) + Gene.randopt(Aa, 4);
			return var;
		}				
		// caste presets
		if (blood.startsWith("RR")) {var="ssssbbggiiggiiggiissbbffAAAA";}; //Maroon
		if (blood.startsWith("Rr")) {var="ssssbbggiiggiiggiissbbffAAAA";};
		if (blood.startsWith("rr")) {var="ssssbbggiiggiiggiissbbffAAAA";}; // Bronze
		if (blood.startsWith("Rg")) {var="ssssbbggiiggiiggiissbbffAAAA";};
		if (blood.startsWith("RG")) {var="ssssbbggiiggiiggiissbbffAAAA";}; // Gold
		if (blood.startsWith("Gr")) {var="ssssbbggiiggiiggiissbbffAAAA";};
		if (blood.startsWith("rg")) {var="ssSsbbggiiggiiggiissbbffAAAA";}; // Lime
		if (blood.startsWith("GG")) {var="ssssbbggiiggiiggiissbbffAAAA";}; // Olive
		if (blood.startsWith("Gg")) {var="ssssbbggiiggiiggiissbbffAAAA";};
		if (blood.startsWith("gg")) {var="ssssbbggiiggiiggiissbbffAAAA";}; // Jade
		if (blood.startsWith("Gb")) {var="ssssbbggiiggiiggiissbbffAAAA";};
		if (blood.startsWith("GB")) {var="ssssbbggiiggiiggiissbbffAAAA";}; // Teal
		if (blood.startsWith("Bg")) {var="ssssbbggiiggiiggiissbbffAAAA";};
		if (blood.startsWith("gb")) {var="ssssbbggiiggiiggiissbbffAAAA";}; // Ceru
		if (blood.startsWith("BB")) {var="ssssbbggiiggiiggiissbbffAAAA";}; // Bloo
		if (blood.startsWith("Bb")) {var="sSssbbggiiggiiggiissbbffAAAA";};
		if (blood.startsWith("bb")) {var="SsSsbbggiiggiiggiissbbffAAAA";}; //Indigo
		if (blood.startsWith("Br")) {var="sSsSbBggiiGGiiggiiSsBbFfAaAA";};
		if (blood.startsWith("RB")) {var="SSSSBbggiiGGiiGGiiSSBBFFAAAa";}; //Violet
		if (blood.startsWith("Rb")) {var="SSSSBBGgiiGGiiGGiiSSbBfFaAaA";};
		if (blood.startsWith("rb")) {var="SSSSBBgGiiGGiiGGiiSSbbffAaAa";}; //Tyrian
		// other presets
		if (blood.startsWith("land"))      {var="ssssbbggiiggiiggiissbbffAAAA";};
		if (blood.startsWith("sea"))       {var="SSSSBbggiiGGiiGGiiSSBBFFAAAa";};
		if (blood.startsWith("deepsea"))   {var="SsSsBBGGeeGGeeGGeeSSbbffaaaa";};
		if (blood.startsWith("seahidden")) {var="SsSsbbggiiggiiGGiiSsBbFfAAAA";};
		if (blood.startsWith("river"))     {var="sSsSbbggiiGGiigGiissbbFFAAAA";};
		if (blood.startsWith("landsea"))   {var="ssssBbggiiGGiiGGiiSSBBFFAaAA";};
		if (blood.startsWith("sealand"))   {var="SSSSbbggiiggiiggiissbbffAAAA";};
		if (blood.startsWith("nonviable")) {var="SsSsBBGGeeggiiggiissbbffaaaa";};

		return var;
	}

	public String fin(String blood) {
		Random rand = new Random();
		String var = new String("");
		if (blood.startsWith("blank")) {var = "ssffttffffnnEEcc35bb";return var;};
		if (blood=="truerand") {
			String[] Ss = {"S", "s"};
			String[] Bb = {"B", "b"};
			String[] Tt = {"T", "t"};
			String[] Nn = {"N", "n"};
			String[] Ff = {"F", "f"};
			String[] Ee = {"E", "e"};
			String[] Cc = {"C", "c"};
			String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			var = Gene.randopt(Ss, 2) + Gene.randopt(Ff, 2) + Gene.randopt(Tt, 2);
			var = var + Gene.randopt(Ff, 2) + Gene.randopt(Ff, 2) + Gene.randopt(Nn, 2);			
			var = var + Gene.randopt(Ee, 2) + Gene.randopt(Cc, 2) + Gene.randopt(num, 2);
			var = var + Gene.randopt(Bb, 2);
			return var;
		}				

		var = Gene.mutiBlend(pickfin(blood), pickfin(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickfin("rand"));			
		return var;		
	}

	public String pickfin(String blood){
			Blood b = new Blood(blood);
	 		Random rand = new Random();
			String var = new String();
			var = "ssffttffffnnEEcc35bb";
			// 2char: Ss : controls, SS sea Ss sS check and ss land
			// 2char: Ff : wfingers, FF full Ff/fF, ff no webbing.
			// 2char: Tt : wtoes, TT Tt/tT, tt no webbing.
			// 2char: Ff : dorsal fins on limbs, FF Ff fF ff none.
			// 2char: Ff : dorsal fins on body/tail, FF Ff fF ff none.
			// 2char: Nn : nictating membrane eyelids.  NN (lids), Nn nN (permanent transparent layer) nn normal land
			// 2char: Ee : ears. EE full, Ee / eE half, ee none.
			// 2char: CC : cheekfin.  CC, Cc/cC, cc.
			// 1char: 3  : cheekfin number of tines
			// 1char: 5  : cheekfin size, 5 = average seadweller. 
			// 2char: BB : cheekfin bioluminescence, BB voluntary, Bb bloodflow, bB constant, bb none.
		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
					"land", "sea", "landsea", "sealand", "river", "deepsea", "seahidden", "webbed", "bodyfins"};
			blood = options[rand.nextInt(options.length)];
		} // end rand
		if (blood=="truerand") {
			String[] Ss = {"S", "s"};
			String[] Bb = {"B", "b"};
			String[] Tt = {"T", "t"};
			String[] Nn = {"N", "n"};
			String[] Ff = {"F", "f"};
			String[] Ee = {"E", "e"};
			String[] Cc = {"C", "c"};
			String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			var = Gene.randopt(Ss, 2) + Gene.randopt(Ff, 2) + Gene.randopt(Tt, 2);
			var = var + Gene.randopt(Ff, 2) + Gene.randopt(Ff, 2) + Gene.randopt(Nn, 2);			
			var = var + Gene.randopt(Ee, 2) + Gene.randopt(Cc, 2) + Gene.randopt(num, 2);
			var = var + Gene.randopt(Bb, 2);
			return var;
		}				

		// caste presets
		
	if (blood.startsWith("RR")) {var="ssffttffffnnEEcc35bb";}; //Maroon
	if (blood.startsWith("Rr")) {var="ssffttffffnnEEcc35bb";};
	if (blood.startsWith("rr")) {var="ssffttffffnnEEcc35bb";}; // Bronze
	if (blood.startsWith("Rg")) {var="ssffttffffNnEEcc35bb";};
	if (blood.startsWith("RG")) {var="ssffttffffNnEEcc35Bb";}; // Gold
	if (blood.startsWith("Gr")) {var="ssffttffffNnEEcc35bb";};
	if (blood.startsWith("rg")) {var="ssffttffffnnEEcc35bb";}; // Lime
	if (blood.startsWith("GG")) {var="ssffttffffnnEEcc35bb";}; // Olive
	if (blood.startsWith("Gg")) {var="ssffttffffnnEEcc35bb";};
	if (blood.startsWith("gg")) {var="ssffttffffnnEEcc35bB";}; // Jade
	if (blood.startsWith("Gb")) {var="ssffttffffnnEEcc35bb";};
	if (blood.startsWith("GB")) {var="ssffttffffnnEEcc35bb";}; // Teal
	if (blood.startsWith("Bg")) {var="ssffttffffnnEEcc35bb";};
	if (blood.startsWith("gb")) {var="ssffttffffnnEEcc35bb";}; // Ceru
	if (blood.startsWith("BB")) {var="ssffttffffnnEEcc35bb";}; // Bloo
	if (blood.startsWith("Bb")) {var="ssFfTtffffnnEECc31bb";};
	if (blood.startsWith("bb")) {var="SsfFtTffffnnEeCc32bb";}; //Indigo
	if (blood.startsWith("Br")) {var="sSFFTTffffnneEcC33bB";};
	if (blood.startsWith("RB")) {var="SSFFTTffffnneeCC35Bb";}; //Violet
	if (blood.startsWith("Rb")) {var="SSFFTTFfFfNneeCC47BB";};
	if (blood.startsWith("rb")) {var="SSFFTTFFffNNeeCC39BB";}; //Tyrian

	// other presets
	if (blood.startsWith("land"))      {var="ssffttffffnnEEcc35bb";};
	if (blood.startsWith("sea"))       {var="SSFFTTffffnneeCC35Bb";};
	if (blood.startsWith("deepsea"))   {var="SsFFTTFFFFNNeeCC69BB";};
	if (blood.startsWith("river"))     {var="SsFFTTffffnnEeCc33bb";};
	if (blood.startsWith("seahidden")) {var="SsffTtffffnnEEcc33BB";};
	if (blood.startsWith("landsea"))   {var="ssFFTTffffnneeCC35Bb";};
	if (blood.startsWith("sealand"))   {var="SSffttffffnnEEcc35bb";};
	if (blood.startsWith("webbed"))    {var="sSFFTTffffNNeeCC35bb";};
	if (blood.startsWith("bodyfins"))  {var="sSFFTTFFFFNNEEcc35bb";};

	return var;
}

	public String pupation(String blood) {
		Random rand = new Random();
		String var = new String("");
		if (blood.startsWith("blank")) {var = "12311112211";return var;};
		if (blood=="truerand") {
			String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			var = Gene.randopt(num, 11);
			return var;}
		var = Gene.mutiBlend(pickpupation(blood), pickpupation(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickpupation("rand"));			
		return var;		
	}
	
	public String pickpupation(String blood) {
		Blood b = new Blood(blood);
 		Random rand = new Random();
		String var = new String();
		var = "12311112211"; // default
		// pupation 0 = grub form, 1 = toddler form, 2+ = spares,
		// 3char: 123 number of pupations to go through : take average.  average=9 means infinite, every 2 sweeps.
		// 2char: 11 adult legs/arms express on pupation 0, 1, 2, 3, or 4+
		// 2char: 11 middle limbs -> grubscars on pupation 0, 1, 2, 3, 4+
		// 2char: 22 wings express on pupation 0, 1, 2, 3, or 4+
		// 2char: 11 tail expresses on pupation 0, 1, 2, 3, or 4+
		if (blood=="rand") {
			String[] options = {"R", "r", "G", "g", "B", "b", "R", "r", "G", "g", "B", "b",
					"singular", "singular", "singular", "singular", "singular", "singular", 
					"endless", "permgrub", "latewing", "latemid", "latetail", "grubleg"};
			blood = options[rand.nextInt(options.length)];
			// This is very biased towards either single or double pupation.  Intentionally.
		} // end rand
		if (blood=="truerand") {
			String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			var = Gene.randopt(num, 11);
			return var;}

		if (blood.startsWith("R")) {var="12311112211";}; // Normal for all castes.
		if (blood.startsWith("r")) {var="22211112211";}; // Normal for all castes.
		if (blood.startsWith("G")) {var="12311112211";}; // Normal for all castes.
		if (blood.startsWith("g")) {var="22211112211";}; // Normal for all castes.
		if (blood.startsWith("B")) {var="12311112211";}; // Normal for all castes.
		if (blood.startsWith("b")) {var="22211112211";}; // Normal for all castes.
		// overrides
		if (blood.startsWith("endless"))  {var="99911112211";}; 
		if (blood.startsWith("singular")) {var="11111112211";}; 
		if (blood.startsWith("permgrub")) {var="00011112211";}; 
		if (blood.startsWith("latewing")) {var="11111115511";}; 
		if (blood.startsWith("latemid"))  {var="32111552211";}; 
		if (blood.startsWith("latetail")) {var="22211112255";}; 
		if (blood.startsWith("grubleg"))  {var="32122221111";}; 
		
		return var;
	}

	public String tail(String blood) {
		Random rand = new Random();
		String var = new String("");
		if (blood.startsWith("blank")) {var = "tt01aa";return var;};
		if (blood=="truerand") {
			String[] Tt = {"T", "t"};
			String[] Aa = {"A", "a"};
			String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			var = Gene.randopt(Tt, 2) + Gene.randopt(num, 2) + Gene.randopt(Aa, 2);
			return var;}
		var = Gene.mutiBlend(picktail(blood), picktail(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), picktail("rand"));			
		return var;		
	}

	public String picktail(String blood){
		Blood b = new Blood(blood);
 		Random rand = new Random();
		String var = new String();
		var = "tt01aa";
		// 2char: Tt - tail level of expression TT(full) Tt(stunted) tT(stunted) tt (none)
		// 1char: #  - tail length in (TT)forearm-spans, (Tt)handspans or (tT)inches.
		// 1char: #  - tail width in fingerwidths
		// 2char: AA - tail type (bare, tufted, furred, mane, scale, club, clawed, spiked, etc)
		//           - AA full covering, Aa dense covering aA light covering aa bald
		//           - figure out what type it is from the skin gene's thingie

	if (blood=="rand") {
		String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
				"tail1", "tail2", "tail3", "tail4"};
		blood = options[rand.nextInt(options.length)];
	} // end rand
	if (blood=="truerand") {
		String[] Tt = {"T", "t"};
		String[] Aa = {"A", "a"};
		String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		var = Gene.randopt(Tt, 2) + Gene.randopt(num, 2) + Gene.randopt(Aa, 2);
		return var;}
	// caste presets
	if (blood.startsWith("RR")) {var="tt51aA";}; //Maroon
	if (blood.startsWith("Rr")) {var="tt41Aa";};
	if (blood.startsWith("rr")) {var="tt32Aa";}; // Bronze
	if (blood.startsWith("Rg")) {var="tt22aA";};
	if (blood.startsWith("RG")) {var="tt13aA";}; // Gold
	if (blood.startsWith("Gr")) {var="tt13Aa";};
	if (blood.startsWith("rg")) {var="tt14AA";}; // Lime
	if (blood.startsWith("GG")) {var="tt15AA";}; // Olive
	if (blood.startsWith("Gg")) {var="tt14Aa";};
	if (blood.startsWith("gg")) {var="tt24aa";}; // Jade
	if (blood.startsWith("Gb")) {var="tt34aa";};
	if (blood.startsWith("GB")) {var="tt44aa";}; // Teal
	if (blood.startsWith("Bg")) {var="tt44aa";};
	if (blood.startsWith("gb")) {var="tt44aa";}; // Ceru
	if (blood.startsWith("BB")) {var="tt55aA";}; // Bloo
	if (blood.startsWith("Bb")) {var="tt54aa";};
	if (blood.startsWith("bb")) {var="tt63Aa";}; //Indigo
	if (blood.startsWith("Br")) {var="tt74aa";};
	if (blood.startsWith("RB")) {var="tt86Aa";}; //Violet
	if (blood.startsWith("Rb")) {var="tt97aA";};
	if (blood.startsWith("rb")) {var="tt98AA";}; //Tyrian

	// other presets
	if (blood.startsWith("tail1")) {var="tT11aa";};
	if (blood.startsWith("tail2")) {var="Tt33Aa";};
	if (blood.startsWith("tail3")) {var="TT55aA";};
	if (blood.startsWith("tail4")) {var="TT99AA";};

	return var;
	}

	public String limb(String blood) {
		Random rand = new Random();
		String var = new String("");
		if (blood.startsWith("blank")) {var = "ffPPBBBBpp33";return var;};
		if (blood=="truerand") {
			String[] Ff = {"F", "f"};
			String[] Dp = {"D", "d", "P", "p"};
			String[] Bq = {"B", "b", "Q", "q"};
			String[] ww = {"B", "b", "A", "a", "S", "s", "D", "d", "F", "f", "E", "e", "T", "t"}; 
			String[] Pp = {"P", "p"};
			String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			var = Gene.randopt(Ff, 2) + Gene.randopt(Dp, 2) + Gene.randopt(Bq, 2);
			var = var + Gene.randopt(ww, 2) + Gene.randopt(Pp, 2) + Gene.randopt(num, 2);	
			return var;};
		var = Gene.mutiBlend(picklimb(blood), picklimb(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), picklimb("rand"));			
		return var;
	}

	public String picklimb(String blood){
		Blood b = new Blood(blood);
 		Random rand = new Random();
 		String var = new String();
		var = "ffPPBBBBpp33";
		// 2char: Ff - Feral override, 
		// 		  ---- FF allows all feral,
		// 		  ---- Ff: no stance, limbtypes express more weakly
		// 		  ---- fF: no stance, wings, or limbtypes
		// 		  ---- ff forces all nonferal, including tail
		// 2char: DdPp  leg digitigrade/plantigrade/other spectrum.  DD Dx xD dx xd px xp Px xP PP
		// 2char: BbQq  stance biped vs quadruped
		// 2char: Bb - wingtype (Bb)butterfly/moth, (Aa)bird, (Ss)bat, (Dd)dragonfly,
		//					    (Ff)gossamer fins, (Ee)beetle, (Tt)Tentacles, other
		// 2char: PP - paw/hand/foot size PP(huge), Pp/pP(large), pp(normal). 
		// 2char: 33 - claw craziness, curvature + length.  average numbers, take floor. 3 is norm.
		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
					"feral0", "feral1", "feral2", "feral3", "feral4", 
					"feral5", "feral6", "feral7", "feral8", "feral9"};
			blood = options[rand.nextInt(options.length)];
		} // end rand
		if (blood=="truerand") {
			String[] Ff = {"F", "f"};
			String[] Dp = {"D", "d", "P", "p"};
			String[] Bq = {"B", "b", "Q", "q"};
			String[] ww = {"B", "b", "A", "a", "S", "s", "D", "d", "F", "f", "E", "e", "T", "t"}; 
			String[] Pp = {"P", "p"};
			String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			var = Gene.randopt(Ff, 2) + Gene.randopt(Dp, 2) + Gene.randopt(Bq, 2);
			var = var + Gene.randopt(ww, 2) + Gene.randopt(Pp, 2) + Gene.randopt(num, 2);	
			return var;};
		// caste presets
	if (blood.startsWith("RR")) {var="ffPPBBBBpp11";}; //Maroon
	if (blood.startsWith("Rr")) {var="fFPPBBBBpp11";};
	if (blood.startsWith("rr")) {var="ffPPBBBBpp22";}; // Bronze
	if (blood.startsWith("Rg")) {var="fFPPBBBBpp22";};
	if (blood.startsWith("RG")) {var="ffPPBBBBpp33";}; // Gold
	if (blood.startsWith("Gr")) {var="ffPPBBBBpp33";};
	if (blood.startsWith("rg")) {var="ffPPBBBBpp33";}; // Lime
	if (blood.startsWith("GG")) {var="ffPPBBBBPp35";}; // Olive
	if (blood.startsWith("Gg")) {var="ffPPBBBBpP53";};
	if (blood.startsWith("gg")) {var="ffPPBBBBpp44";}; // Jade
	if (blood.startsWith("Gb")) {var="ffPPBBBBpp33";};
	if (blood.startsWith("GB")) {var="ffPPBBBBpp33";}; // Teal
	if (blood.startsWith("Bg")) {var="ffPPBBBBpp33";};
	if (blood.startsWith("gb")) {var="ffPPBBBBpp33";}; // Ceru
	if (blood.startsWith("BB")) {var="ffPPBBBBpp33";}; // Bloo
	if (blood.startsWith("Bb")) {var="ffPPBBBBpP33";};
	if (blood.startsWith("bb")) {var="ffPPBBBBPp44";}; //Indigo
	if (blood.startsWith("Br")) {var="FfPPBBBBpP65";};
	if (blood.startsWith("RB")) {var="ffPPBBBBpp44";}; //Violet
	if (blood.startsWith("Rb")) {var="fFPPBBBfpp56";};
	if (blood.startsWith("rb")) {var="ffPPBBBBpp44";}; //Tyrian

	// other presets
	if (blood.startsWith("feral1")) {var="FFDDBBAAPP88";};
	if (blood.startsWith("feral2")) {var="FFdDBBSSpP77";};
	if (blood.startsWith("feral3")) {var="FFDdBBBBPp66";};
	if (blood.startsWith("feral3")) {var="FFDDQqFFPp99";};
	if (blood.startsWith("feral4")) {var="FFDDqQDDpP77";};
	if (blood.startsWith("feral5")) {var="FFDDQQEEPP55";};
	if (blood.startsWith("feral6")) {var="ffppbbTTpp33";};
	if (blood.startsWith("feral7")) {var="ffppbbBFpp33";};
	if (blood.startsWith("feral8")) {var="ffppbbFBpp33";};
	if (blood.startsWith("feral9")) {var="ffppbbEBpp33";};
	if (blood.startsWith("feral0")) {var="ffppbbBEpp33";};

	return var;
	}


}
