package troll.husk;
import troll.fluff.Desc;
import java.util.Random;
@SuppressWarnings("unused")

    // lists of fae subtypes and troll castes are in gene.hemospectrum
    // overall to-do lists are in troll.java

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
	// 3char: 123 number of pupations to go through : take average(round nearest).  average=9 means infinite, every 2 sweeps.
	// 2char: 11 adult legs/arms express on pupation 0, 1, 2, 3, or 4+
	// 2char: 11 middle limbs -> grubscars on pupation 0, 1, 2, 3, 4+
        // -----: also use this to control extra grub eyes / grub only features
	// 2char: 22 wings express on pupation 0, 1, 2, 3, or 4+
	// 2char: 11 tail expresses on pupation 0, 1, 2, 3, or 4+
	// 2char: 99 grubscar loss. If lose them before they express, skip having theme entirely.
	// 2char: 11 stance goes from quadruped (grub/feral) to biped(/wriggler) on pupation 0, 1, 2, 3, or 4+
	public String feralgene = "";
	// 2char: Ff - Feral override, 
	//      ---- FF allows all feral,
	//      ---- Ff: no stance, limbtypes express more weakly, full misc
	//      ---- fF: no stance, no wings, or no limbtypes, partial misc
	//      ---- ff forces all nonferal, including tail and misc
	// 2char: DdPp  limbtype leg digitigrade/plantigrade/other spectrum.  DD Dx xD dx xd px xp Px xP PP
	// 2char: Bb -  wingtype (Bb)butterfly/moth, (Aa)bird, (Ss)bat, (Dd)dragonfly,
	//			 (Ff)gossamer fins, (Ee)beetle, (Tt)Tentacles, other
	// 2char: PP -  misc: paw/hand/foot size PP(huge), Pp/pP(large), pp(normal). 
	// 2char: 33 -  misc: claw craziness, curvature + length.  average numbers, take floor. 3 is norm.
	// 2char: BB -  misc: body-covering materials (F/C/B)
	// -------: FF(fur), FC(Scale), FB(Feathers), CC(keratin/carapace/shell), CB(callous/skin plates), BB(bare)
        // 2char: tooth/jaw mutations.  Listed in order of dominance, N>F>B>T>S>R>G>K
        // -------: NN (normal), FF (fang), BB (barracuda), TT (tusk), SS (shark), RR (rodent incisors), GG (tongue barbs), KK (beak)
        // 2char - does eyeweirdness express?
	// --- (NN/NS/SN/NM/MN) nothing weird, (SS) single, (MM) many tiny eyes, (SM/MS) various sized eyes
        // 2char - where does eyeweirdness express?
	// --- containing N = normal, containing G = more eyes as grub than adult
	// --- (LL) left doubling, (RR) right doubling, (LR/RL) both doubling, GL/LG/RG/GR - doubling as grub
	// --- (N?, ?N, n?) nowhere weird. (anything not covered) nowhere weird.
	// --- (Fn) misc frontal  (Bn) misc back        (Tn) misc extremities     (Gn) nothing weird
	// --- (FH) misc facial,  (BH) back of head,    (TH) forehead		  (GH) grub-only spare head eyes
	// --- (Fh) palm,         (Bh) back of hand,    (Th) fingertips		  (Gh) tip-of-grubleg
	// --- (FC) chest/ribcage,(BC) misc torso+back, (TC) spine		  (GC) grub-torso
	// --- (FL) arms,         (BL) legs,            (TL) tail-if-present      (GL) back-of-grubleg
	// --- (FR) arms,         (BR) legs,            (TR) tail-if-present      (GR) back-of-grubleg
	// --- (FG) Grub front    (BG) grub rear        (TG) grubtail             (GG) no normal eyes after pupation
	// --- options in summary: 2char = (LRGNnFBT) + (LRGNn)
	public String tailgene = "";
	// 2char: Tt - tail level of expression TT(full) Tt(stunted) tT(stunted) tt (none)
	// 1char: #  - tail length in (TT)forearm-spans, (Tt)handspans or (tT)inches.
	// 1char: #  - tail width in fingerwidths
	// 2char: Rr - tail tip from horntip
	// 2char: Rr - tail type (bare, tufted, furred, mane, scale, club, clawed, spiked, horse, etc)
	public String skingene = "";
	// whether biolum is ACTIVE or not will depend on epigenetics -- psychic stat, seadweller control genes, etc.
        // ------ : redo skin patterning gene, synchronize with syndromes and pigment?
	// 4 char : Skin Patterning - Rr(rainbowdrinker, full skin) Pp(psychic eye glow) Nn Ee (none)
	//		            : sea varieties - Ss(larger spots) Tt(stripe) Bb(blotches) Ff(tiny freckle dots)
	// 2 char : Darkens with age Y/N?
	// 3 char : sun-resistance : Aa Aa Aa : 3 capitals mean yes, any lowercase means no.
	// 2 char : freckles.  FF Lots, Ff some, fF less, ff none.
	// 1 char : # - skin thickness / carapace toughness
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
        // ----------: move bioluminescence to skin gene or syndrome gene to centralize Glowing?
	// 2char: BB : cheekfin bioluminescence, BB voluntary, Bb bloodflow, bB constant, bb none.
        public String pigmentgene = "";
        // -- Options: Aa (albino colorless), Ll (leucistic white), Mm (melanism black) Gg (grey: GG = LM or ML)
        // --(contd) Ee (Erythrism red/orange), Xx (Xanthism yellow / lack of non-yellow), Bb (axanthism, lack of yellow)
        // --(contd) Cc (caste color) Ii (inverted caste color) Tt (earthtone)
        // -- lowercase = 1 pt, upper = 2 pt.  you need 3 points for a trait to express.
        // 2char: Hair Streaking - Pp (plain) Kk (streaking)
        // 4char: Hair - Aa Ll Mm Gg Ee Xx Bb Cc Ii Tt  (trolls MMMM, hum M/E/T, fae M/E/T/any)
        // 2char: blood - Aa Ll Mm Gg Ee Xx Bb Cc Ii Tt (trolls Cc/Ii, hum EE, fae EE/BB/any)
        // 4char: skin - Aa Ll Mm Gg Ee Xx Bb Cc Ii Tt
        // -- if multiple things express, either blend them or check skin patterning + second character of feral control gene
        // -- vitiligo and birthmarks come from here
        // 2char: lips / accent color : Aa Ll Mm Gg Ee Xx Bb Cc Ii Tt (trolls MC, hum TC, fae TE)
        // add: 2char horn - Aa Ll Mm Gg Ee Xx Bb Cc Ii Tt, trolls use EX, human TA, fae AT/any
        public String syndromegene = "";
        // need 2 letters of a gene for it to express usually - but Undying and Weak Spark stack with everything
        // 2char: undeath - N(nothing), V(vampire/Drinker), G(ghoul), Z(mindless zombie), 
        // ------ U(fae undying), W(weak spark)
        // 6char: supernatural - v(voodoo), e(eldritch), m(magic), n(null)
        // ------ p(physical psychic), o(oracular psychic), q(mental psychic)
        // 4char: substance allergy - N (none), I(iron), S(silver), G(gold), W(water), D (earth daylight) 
	public String sightgene = "";
	// 2char: Dd  Daylight sight, vs. eye damage taken from daylight 
	// 2char: Dd  How well see in the dark? (DD great, Dd/dD aight, dd badly) 
	// 2char: XX  (Xx) normal (Nn) nearsight, (Ff)farsight, (Aa)astigmatism 
	// ---------  1 capital or 2 lowercase = expressed.  2 capital = severe.  1 capital + same lowercase = strong.
	// 2char: Pp  Can you see polarization of light? PP yes, else no 
	// 2char: Mm  How well the vision tracks movement Mm/mM normal   
	// 2char:     color vision, dichromat, trichromat, tetrachromat, infravision, ultraviolet, etc.
	// ---  R = 2, extending into infravision. C = 2, c = 1, normal range.  
	// ---  U = 2, extending into ultraviolet. C = 2, c = 1, normal range. 
	// --- cc: dichromat.  Cc / cC, trichromat.  Rc = trichro infra, cU=trichro ultra.  CC/RC/CU/RU tetrachromat.
	// 8char:     "xfoldvision": "",      # Fancy bullshit vision senses
        // --- : number of times each letter occurs tells how strong it is.  all but P need 2+ to activate.
	// --- A=0,  B=1,  C=2,  D=3, E=4, F=5, G=6, H=7, I=8, J=9, K=10, M=20,
        // --- N=Radiation,        O=Auras,                P=Magicsight
	// --- Q=psychic residue,  R=life-sense,           S=Sharingan,                  T=??,
	// --- U=Electromagnetism, V=gravitational fields, W=eldritch horrorterror shit,
	// --- X=dnd darkvision,   Y=ShinySense,           Z=Aspect Affiliation


        //public String fertgene = "aaaa";
        // :: add FERTILITY gene
        // 2char: egglaying, live young, oviposition, other
        // 2char: mother grub only vs individual fertility vs wing or pupation dependant fertility
        // 2char: level of fertility : 0 (not) 1 (elf) 2 (wildfae) 3(human) 5+(Troll)
        // 2char: litter size (number, average them), ...
        // -- bulge Y/N, canDad
        // -- nook Y/N, canMom
        // -- testes internal/external,
        // -- sheath y/n
        // -- knots
        
        // :: add INTERNALS gene
        // -- organ doubling, mirroring, rearrangement, glitches/flaws, glandular/hormone/growth problems
        // -- osteoporosis, bone spurs, arthritis, bone Things
	
	
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
		feralgene = feral(blood);
                pigmentgene = pigment(blood);
                syndromegene = syndrome(blood);
                sightgene = sight(blood);
			
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
                // nontrolls
     		if (blood.startsWith("fae"))   {h=65;};
     		if (blood.startsWith("human")) {h=65;};
     		if (blood.startsWith("dryad")) {h=65;};

		// Mutation zone
		int delta = rand.nextInt(10);
		h = h + delta - 5;		
		if (sex=="M") {h = h + rand.nextInt(4)-1;};
		if (sex=="F") {h = h - rand.nextInt(4)-1;};
                
                // itty bitties
      		if (blood.startsWith("hobb"))  {h=8;};
     		if (blood.startsWith("pixie")) {h=8;};
		
                // Mutation zone2
		delta = rand.nextInt(2);
		h = h + delta - 1;		
		if (sex=="M") {h = h + rand.nextInt(2)-1;};
		if (sex=="F") {h = h - rand.nextInt(2)-1;};

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
		if (blood=="rand"||Gene.ishum(blood)||Gene.isfae(blood)) {
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
		if (blood.startsWith("blank")) {skin="NNNNnnYYaaaFF3";return skin;};
		if (blood=="truerand") {
			String[] a4 = {"B", "b", "R", "r", "P", "p", "N", "n", "E", "e", "S", "s", };
			String[] c2 = {"Y", "y", "N", "n"};
			String[] d3 = {"A", "a"};
			String[] e2 = {"F", "f"};
			String[] g1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			skin = Gene.randopt(a4, 4) + Gene.randopt(c2, 2) + Gene.randopt(d3, 3);
			skin = skin + Gene.randopt(e2, 2) + Gene.randopt(g1, 1);
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
		// 2 char : Darkens with age Y/N?
		// 3 char : sun-resistance : Aa Aa Aa : 3 capitals mean yes, any lowercase means no.
		// 2 char : freckles.  FF Lots, Ff some, fF less, ff none.
		// 1 char : # - skin thickness / carapace toughness.  3 normal, 5+ normal highblood
                
                if (Gene.isfae(blood)) {blood = "fae";};
                if (Gene.ishum(blood)) {blood = "human";};
                
		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
					"sea1", "sea2", "sea3", "sea4", "sea5", "sea6", "sea7", "sea8", "sea9", 
					"psychic1", "psychic2", "psychic3", "drinker", "nothing"};
			blood = options[rand.nextInt(options.length)];
			}
		if (blood=="truerand") {
			String[] a4 = {"B", "b", "R", "r", "P", "p", "N", "n", "E", "e", "S", "s", };
			String[] c2 = {"Y", "y", "N", "n"};
			String[] d3 = {"A", "a"};
			String[] e2 = {"F", "f"};
			String[] g1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			skin = Gene.randopt(a4, 4) + Gene.randopt(c2, 2) + Gene.randopt(d3, 3);
			skin = skin + Gene.randopt(e2, 2) + Gene.randopt(g1, 1);
			return skin;
		}				
		
		if (blood.startsWith("RR")) {skin="ppPpYyaaaff3";}; //Maroon
		if (blood.startsWith("Rr")) {skin="ppppyYaaaFF3";};
		if (blood.startsWith("rr")) {skin="ppppYyaaaff3";}; // Bronze
		if (blood.startsWith("Rg")) {skin="PpPpyYaaaFF3";};
		if (blood.startsWith("RG")) {skin="PPPPYyaAaff3";}; // Gold
		if (blood.startsWith("Gr")) {skin="pPpPyYaaaFF3";};
		if (blood.startsWith("rg")) {skin="pPPpYyaaAff3";}; // Lime
		if (blood.startsWith("GG")) {skin="NNnnyYaaaff3";}; // Olive
		if (blood.startsWith("Gg")) {skin="NrnRYyaaaFF3";};
		if (blood.startsWith("gg")) {skin="RRrryYAAAff3";}; // Jade
		if (blood.startsWith("Gb")) {skin="NnRrYyaAaFF3";};
		if (blood.startsWith("GB")) {skin="nnnnyYaaaff3";}; // Teal
		if (blood.startsWith("Bg")) {skin="NNNNYyaaAFF3";};
		if (blood.startsWith("gb")) {skin="enNEyYaaaff3";}; // Ceru
		if (blood.startsWith("BB")) {skin="neENYyaaaff4";}; // Bloo
		if (blood.startsWith("Bb")) {skin="sSsSyYAaaFF4";};		       // spots
		if (blood.startsWith("bb")) {skin="NNnNYyaaaff5";}; //Indigo
		if (blood.startsWith("Br")) {skin="SsSsyYaAaFF5";};
		if (blood.startsWith("RB")) {skin="sStTYyaaaff6";}; //Violet
		if (blood.startsWith("Rb")) {skin="TtTtyYAaaFF6";}; 	       // stripes
		if (blood.startsWith("rb")) {skin="FFffYyaaaff7";}; //Tyrian   // freckles
		
		if (blood=="sea1")      {skin="BBBBYYaaaFF4";};
		if (blood=="sea2")      {skin="bbbbYYaaaFf4";};
		if (blood=="sea3")      {skin="TTTTYYaaaff4";};
		if (blood=="sea4")      {skin="SSSSYYaaaFF4";};
		if (blood=="sea5")      {skin="ssssYYaaaFf4";};
		if (blood=="sea6")      {skin="ttttYYaaaff4";};
		if (blood=="sea7")      {skin="FFFFYYaaaFF4";};
		if (blood=="sea8")      {skin="FfFfYYaaaFf4";};
		if (blood=="sea9")      {skin="ffffYYaaaff4";};
		if (blood=="psychic1")  {skin="PPPPYYaaafF0";};
		if (blood=="psychic2")  {skin="ppPpYYaaaFF3";};
		if (blood=="psychic3")  {skin="ppPpYYaaaFF3";};
		if (blood=="drinker")   {skin="RRRRYYAAAff8";};
		if (blood=="nothing")   {skin="NNNNYYaaaff0";};
                // nontrolls
      		if (blood=="human")     {skin="TTTTNNAAAfF2";};
      		if (blood=="fae")       {skin="NNNNNNAAAfF2";};
                
                
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
                if (Gene.isfae(blood)&&!blood.equals("selkie")) {blood = "fae";};
                if (Gene.ishum(blood)) {blood = "human";};

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
                // nontroll
		if (blood.startsWith("human"))      {var="ssssbbggiiggiiggiissbbffAAAA";};
		if (blood.startsWith("fae"))        {var="ssssbbggiiggiiggiissbbffAAAA";};
		if (blood.startsWith("selkie"))     {var="sSsSbbggiiggiiggiiSSBBFFAAAA";};
                

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
		if (Gene.isfae(blood)) {blood = "fae";};
                if (Gene.ishum(blood)) {blood = "human";};

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
        // nontroll
	if (blood.startsWith("human"))      {var="ssffttffffnnEEcc35bb";};
	if (blood.startsWith("fae"))        {var="ssffttffffnnEEcc35bb";};
        
        
	return var;
}

	public String pupation(String blood) {
		Random rand = new Random();
		String var = new String("");
                if (blood.startsWith("blank")) {var = "123111122119911";return var;};
		if (blood=="truerand") {
			String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			var = Gene.randopt(num, 15);
			return var;}
		var = Gene.mutiBlend(pickpupation(blood), pickpupation(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickpupation("rand"));			
		return var;		
	}
	
	public String pickpupation(String blood) {
		Blood b = new Blood(blood);
 		Random rand = new Random();
		String var = new String();
		var = "123111122119911"; // default
		// pupation 0 = grub form, 1 = toddler form, 2+ = spares,
		// 3char: 123 number of pupations to go through : take average.  average=9 means infinite, every 2 sweeps.
		// 2char: 11 adult legs/arms express on pupation 0, 1, 2, 3, or 4+
		// 2char: 11 middle limbs -> grubscars on pupation 0, 1, 2, 3, 4+
		// 2char: 22 wings express on pupation 0, 1, 2, 3, or 4+
		// 2char: 11 tail expresses on pupation 0, 1, 2, 3, or 4+
                // 2char: 99 grubscars.
                // 2char: 11 stance goes from quadruped (grub/feral) to biped(/wriggler) on pupation 0, 1, 2, 3, or 4+
		if (Gene.isfae(blood)) {blood = "fae";};
                if (Gene.ishum(blood)) {blood = "human";};
                if (blood=="rand") {
			String[] options = {"R", "r", "G", "g", "B", "b", "R", "r", "G", "g", "B", "b",
					"singular", "singular", "singular", "singular", "singular", "singular", 
					"endless", "permgrub", "latewing", "latemid", "latetail", "grubleg"};
			blood = options[rand.nextInt(options.length)];
			// This is very biased towards either single or double pupation.  Intentionally.
		} // end rand
		if (blood=="truerand") {
			String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			var = Gene.randopt(num, 15);
			return var;}

		if (blood.startsWith("R")) {var="123111122119911";}; // Normal for all castes.
		if (blood.startsWith("r")) {var="222111122119911";}; // Normal for all castes.
		if (blood.startsWith("G")) {var="123111122118811";}; // Normal for all castes.
		if (blood.startsWith("g")) {var="222111122118811";}; // Normal for all castes.
		if (blood.startsWith("B")) {var="123111122117711";}; // Normal for all castes.
		if (blood.startsWith("b")) {var="222111122117711";}; // Normal for all castes.
		// overrides
		if (blood.startsWith("endless"))  {var="999111122119922";}; 
		if (blood.startsWith("singular")) {var="111111122119911";}; 
		if (blood.startsWith("permgrub")) {var="000111122119299";}; 
		if (blood.startsWith("latewing")) {var="111111155112211";}; 
		if (blood.startsWith("latemid"))  {var="321115522111111";}; 
		if (blood.startsWith("latetail")) {var="222111122559911";}; 
		if (blood.startsWith("grubleg"))  {var="321222211119955";}; 
                // nontroll
                if (blood.startsWith("human"))    {var="000000000000000";}; 
                if (blood.startsWith("fae"))      {var="000000000000000";}; 
		
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
                if (Gene.isfae(blood)) {blood = "fae";};
                if (Gene.ishum(blood)) {blood = "human";};
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
        // nontroll
	if (blood.startsWith("human")) {var="tt11aa";};
	if (blood.startsWith("fae"))   {var="tt11aa";};
        
	return var;
	}

	public String feral(String blood) {
		Random rand = new Random();
		String var = new String("");
		if (blood.startsWith("blank")) {var = "ffPPBBpp33BBNNNNGN";return var;};
		if (blood=="truerand") {
			String[] F2 = {"F", "f"};
			String[] D2 = {"D", "d", "P", "p"};
			String[] W2 = {"B", "b", "A", "a", "S", "s", "D", "d", "F", "f", "E", "e", "T", "t"}; 
			String[] P2 = {"P", "p"};
			String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                        String[] B2 = {"F", "f", "B", "b", "C", "c"};
                        String[] T2 = {"N", "F", "B", "T", "S", "R", "G", "K"};
			String[] N2 = {"N", "S", "M"};
			String[] L1 = {"L", "R", "G", "N", "F", "B", "T"};
			String[] R1 = {"L", "R", "G", "N"};
			var = Gene.randopt(F2, 2) + Gene.randopt(D2, 2);
			var = var + Gene.randopt(W2, 2) + Gene.randopt(P2, 2) + Gene.randopt(num, 2);	
                        var = var + Gene.randopt(B2, 2) + Gene.randopt(T2, 2);
                        var = var + Gene.randopt(N2, 2) + Gene.randopt(L1, 1) + Gene.randopt(R1, 1);
			return var;};
		var = Gene.mutiBlend(pickferal(blood), pickferal(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickferal("rand"));
		return var;
	}

	public String pickferal(String blood){
		Blood b = new Blood(blood);
 		Random rand = new Random();
 		String var = new String();
		var = "ffPPBBpp33BBNNNNGN";
	// 2char: Ff - Feral override, 
	// 		  ---- FF allows all feral,
	// 		  ---- Ff: no stance, limbtypes express more weakly, full misc
	// 		  ---- fF: no stance, wings, or limbtypes, partial misc
	// 		  ---- ff forces all nonferal, including tail
	// 2char: DdPp  limbtype leg digitigrade/plantigrade/other spectrum.  DD Dx xD dx xd px xp Px xP PP
	// 2char: Bb -  wingtype (Bb)butterfly/moth, (Aa)bird, (Ss)bat, (Dd)dragonfly,
	//					    (Ff)gossamer fins, (Ee)beetle, (Tt)Tentacles, other
	// 2char: PP -  misc: paw/hand/foot size PP(huge), Pp/pP(large), pp(normal). 
	// 2char: 33 -  misc: claw craziness, curvature + length.  average numbers, take floor. 3 is norm.
	// 2char: BB -  misc: body-covering materials (F/C/B)
	// -------: FF(fur), FC(Scale), FB(Feathers), CC(keratin/carapace/shell), CB(callous/skin plates), BB(bare)
        // 2char: tooth/jaw mutations.  Listed in order of dominance, N>F>B>T>S>R>G>K
        // -------: NN (normal), FF (fang), BB (barracuda), TT (tusk), SS (shark), RR (rodent incisors), GG (tongue barbs), KK (beak)
        // 2char - does eyeweirdness express?
	// --- (NN/NS/SN/NM/MN) nothing weird, (SS) single, (MM) many tiny eyes, (SM/MS) various sized eyes
        // 2char - where does eyeweirdness express?
	// --- containing N = normal, containing G = more eyes as grub than adult
	// --- (LL) left doubling, (RR) right doubling, (LR/RL) both doubling, GL/LG/RG/GR - doubling as grub
	// --- (N?, ?N) nowhere weird.
	// --- (FH) misc facial,  (BH) back of head,    (TH) forehead		  (GH) grub-only spare head eyes
	// --- (Fh) palm,         (Bh) back of hand,    (Th) fingertips		  (Gh) tip-of-grubleg
	// --- (FC) chest/ribcage,(BC) misc torso+back, (TC) spine		  (GC) grub-torso
	// --- (FL) arms,         (BL) legs,            (TL) tail-if-present      (GL) back-of-grubleg
	// --- (FR) arms,         (BR) legs,            (TR) tail-if-present      (GR) back-of-grubleg
	// --- (FG) Grub front    (BG) grub rear        (TG) grubtail             (GG) no normal eyes after pupation
	// --- options in summary: 2char = (LRGNFBT) + (LRGN)
                if (Gene.isfae(blood)) {blood = "fae";};
                if (Gene.ishum(blood)) {blood = "human";};
                if (blood=="fae") {
			String[] faeopt = {"fae", "fae1", "fae2"};
			blood = faeopt[rand.nextInt(faeopt.length)];
		} // end rand
                if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
					"feral0", "feral1", "feral2", "feral3", "feral4", 
					"feral5", "feral6", "feral7", "feral8", "feral9"};
			blood = options[rand.nextInt(options.length)];
		} // end rand
		if (blood=="truerand") {
			String[] F2 = {"F", "f"};
			String[] D2 = {"D", "d", "P", "p"};
			String[] W2 = {"B", "b", "A", "a", "S", "s", "D", "d", "F", "f", "E", "e", "T", "t"}; 
			String[] P2 = {"P", "p"};
			String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                        String[] B2 = {"F", "f", "B", "b", "C", "c"};
                        String[] T2 = {"N", "F", "B", "T", "S", "R", "G", "K"};
			String[] N2 = {"N", "S", "M"};
			String[] L1 = {"L", "R", "G", "N", "F", "B", "T"};
			String[] R1 = {"L", "R", "G", "N", "n"};
			var = Gene.randopt(F2, 2) + Gene.randopt(D2, 2);
			var = var + Gene.randopt(W2, 2) + Gene.randopt(P2, 2) + Gene.randopt(num, 2);	
                        var = var + Gene.randopt(B2, 2) + Gene.randopt(T2, 2);
                        var = var + Gene.randopt(N2, 2) + Gene.randopt(L1, 1) + Gene.randopt(R1, 1);
			return var;};
		// caste presets
	if (blood.startsWith("RR")) {var="ffPPBBpp11BBNNNNNH";}; // Maroon
	if (blood.startsWith("Rr")) {var="fFPPBBpp11BBRRNNTH";};
	if (blood.startsWith("rr")) {var="ffPPBBpp22BBNNNNNH";}; // Bronze
	if (blood.startsWith("Rg")) {var="fFPPBBpp22BBTTSNLN";};
	if (blood.startsWith("RG")) {var="ffPPBBpp33BBNFNSNH";}; // Gold
	if (blood.startsWith("Gr")) {var="ffPPBBpp33BBFBNNNR";};
	if (blood.startsWith("rg")) {var="ffPPBBpp33BBNNNNNH";}; // Lime
	if (blood.startsWith("GG")) {var="ffPPBBPp35BBNGNNNH";}; // Olive
	if (blood.startsWith("Gg")) {var="ffPPBBpP53BBGNNNBH";};
	if (blood.startsWith("gg")) {var="ffPPBBpp44BBFNNNNH";}; // Jade
	if (blood.startsWith("Gb")) {var="ffPPBBpp33BBNFNNFN";};
	if (blood.startsWith("GB")) {var="ffPPBBpp33BBNNNNNH";}; // Teal
	if (blood.startsWith("Bg")) {var="ffPPBBpp33BBFKNSNL";};
	if (blood.startsWith("gb")) {var="ffPPBBpp33BBNNSNLN";}; // Ceru
	if (blood.startsWith("BB")) {var="ffPPBBpp33BBNNNNNH";}; // Bloo
	if (blood.startsWith("Bb")) {var="ffPPBBpP33BFNNNNNR";};
	if (blood.startsWith("bb")) {var="ffPPBBPp44BBFFNNNH";}; //Indigo
	if (blood.startsWith("Br")) {var="FfPPBBpP65FFFTNNFh";};
	if (blood.startsWith("RB")) {var="ffPPBBpp44BBBBNNNH";}; //Violet
	if (blood.startsWith("Rb")) {var="fFPPBfpp56BBBSNNNC";};
	if (blood.startsWith("rb")) {var="ffPPBBpp44BBBBNNNH";}; //Tyrian

	// other presets
	if (blood.startsWith("feral1")) {var="FFDDAAPP88FBKKNSFn";};
	if (blood.startsWith("feral2")) {var="FFdDSSpP77FCGGSNBH";};
	if (blood.startsWith("feral3")) {var="FFDdBBPp66CFRRNMTh";};
	if (blood.startsWith("feral3")) {var="FFDDFFPp99CBSSMNGC";};
	if (blood.startsWith("feral4")) {var="FFDDDDpP77BCTTSSTL";};
	if (blood.startsWith("feral5")) {var="FFDDEEPP55FFBBMMBG";};
	if (blood.startsWith("feral6")) {var="ffppTTpp33ffFFSNLL";};
	if (blood.startsWith("feral7")) {var="ffppBFpp33bbGGNSRR";};
	if (blood.startsWith("feral8")) {var="ffppFBpp33ccRRMNGH";};
	if (blood.startsWith("feral9")) {var="ffppEBpp33BBSSNMTG";};
	if (blood.startsWith("feral0")) {var="ffppBEpp33CCTTSMTH";};
        // nontroll
	if (blood.startsWith("human"))  {var="ffPPAApp00BBNNNNNN";};
	if (blood.startsWith("fae"))    {var="ffPPAApp00BBNNNNNN";};
	if (blood.startsWith("fae1"))   {var="FfDDBBpp11BBFFNNNN";};
	if (blood.startsWith("fae2"))   {var="fFDDDDpp11BBFFNNNN";};
        
	return var;
	}

        public String pigment(String blood) {
		Random rand = new Random();
		String var = new String("PPMMMMCCGGGG");
                if (blood.startsWith("blank")) {var = "PPMMMMCCGGGG";return var;};
		if (blood=="truerand") {
                        String[] col = {"A", "a", "L", "l", "M", "m", "G", "g", "E", "e", "X", "x", "B", "b", "C", "c", "I", "i", "T", "t"};
			String[] streak = {"P", "p", "K", "k"};
                        var = Gene.randopt(streak, 2);
			var = var + Gene.randopt(col, 12);
			return var;}
		var = Gene.mutiBlend(pickpigment(blood), pickpigment(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickpigment("rand"));
		return var;		
	}
	
	public String pickpigment(String blood) {
		Blood b = new Blood(blood);
 		Random rand = new Random();
		String var = new String();
		var = "PPMMMMCCGGGG"; // default
        // -- Options: Aa (albino colorless), Ll (leucistic white), Mm (melanism black) Gg (grey: GG = LM or ML)
        // --(contd) Ee (Erythrism red/orange), Xx (Xanthism yellow / lack of non-yellow), Bb (axanthism, lack of yellow)
        // --(contd) Cc (caste color) Ii (inverted caste color) Tt (earthtone)
        // -- lowercase = 1 pt, upper = 2 pt.  you need 3 points for a trait to express.
        // 2char: Hair Streaking - Pp (plain) Kk (streaking)
        // 4char: Hair - Aa Ll Mm Gg Ee Xx Bb Cc Ii Tt
        // 2char: blood - Aa Ll Mm Gg Ee Xx Bb Cc Ii Tt
        // 4char: skin - Aa Ll Mm Gg Ee Xx Bb Cc Ii Tt
        // -- if multiple things express, either blend them or check skin patterning + second character of feral control gene
        // 2char: lips / accent color : Aa Ll Mm Gg Ee Xx Bb Cc Ii Tt
        // -- humans use TC, trolls MC, fae TE
		if (blood=="rand") {
			String[] options = {
                            "RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
                            "RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
                            "RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
                            "RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
                            "streak2", "albino2", "leucism2", "melanism2", "grey2", "erythrism2",
                            "xanthism2", "axanthism2", "caste2", "inverted2", "earthtone2", "pale",
                        };
			blood = options[rand.nextInt(options.length)];
		} // end rand
      		if (Gene.ishum(blood)) {
			String[] humopt = {"human", "humanred", "humanyel", "humanbla", "humanbla", "humanalb"};
			blood = humopt[rand.nextInt(humopt.length)];
		} // end human
      		if (Gene.isfae(blood)&&!blood.equals("fae")&&!blood.equals("faewild")&&!blood.equals("seleighe")&&!blood.equals("unseleighe")) {
			String[] faeopt = {"fae", "faewild", "seleighe", "unseleighe"};
			blood = faeopt[rand.nextInt(faeopt.length)];
		} // end fae
                        
		if (blood=="truerand") {
                        String[] col = {"A", "a", "L", "l", "M", "m", "G", "g", "E", "e", "X", "x", "B", "b", "C", "c", "I", "i", "T", "t"};
			String[] streak = {"P", "p", "K", "k"};
                        var = Gene.randopt(streak, 2);
			var = var + Gene.randopt(col, 12);
			return var;}

		// caste presets
            if (blood.startsWith("RR")) {var="PPMMMMCCGGCcMC";}; //Maroon
            if (blood.startsWith("Rr")) {var="pPeMMMCCGcCMMC";};
            if (blood.startsWith("rr")) {var="PPMMMMCCGGCcMC";}; // Bronze
            if (blood.startsWith("Rg")) {var="pPMeMMCCGcCMMC";};
            if (blood.startsWith("RG")) {var="PPMMMMCCGGCcMC";}; // Gold
            if (blood.startsWith("Gr")) {var="PpMlMMCCcGCmlM";};
            if (blood.startsWith("rg")) {var="PpLMIMCCGGCcMC";}; // Lime
            if (blood.startsWith("GG")) {var="PPMMMMCCGGCcMC";}; // Olive
            if (blood.startsWith("Gg")) {var="PpgMMMCCcGCcMc";};
            if (blood.startsWith("gg")) {var="PPMMMMCCGGCcMC";}; // Jade
            if (blood.startsWith("Gb")) {var="PpMLMMCCGcCcMc";};
            if (blood.startsWith("GB")) {var="PPMMMMCCGGCcMC";}; // Teal
            if (blood.startsWith("Bg")) {var="pPMMMMCCcGCcMM";};
            if (blood.startsWith("gb")) {var="PPMMMMCCGGCcMC";}; // Ceru
            if (blood.startsWith("BB")) {var="PpMMMMCCGGCcMC";}; // Bloo
            if (blood.startsWith("Bb")) {var="pPMCMMCCGcCccM";};
            if (blood.startsWith("bb")) {var="PPMMMMCCGGCcMC";}; //Indigo
            if (blood.startsWith("Br")) {var="PSMMMCCCcGCcMc";};
            if (blood.startsWith("RB")) {var="SSMMCMCCGGCcMC";}; //Violet
            if (blood.startsWith("Rb")) {var="SPCMMMCCGcCcCM";};
            if (blood.startsWith("rb")) {var="PpMMMCCCGGCcMC";}; //Tyrian
       
	// other presets that overwrite the previous
            // human
            if (blood.startsWith("human"))        {var="PPMTTEEETTTTTC";};
            if (blood.startsWith("humanred"))     {var="PPEEEEEETLTTTC";};
            if (blood.startsWith("humanyel"))     {var="PPXXXEEETTLTTC";};
            if (blood.startsWith("humanalb"))     {var="PPAAAAEEAAAATC";};
            if (blood.startsWith("humanbla"))     {var="PPMMMMEEMTTMTC";};
            // fae
            if (blood.startsWith("fae"))        {var="PPMTTXEEEXBGTE";};
            if (blood.startsWith("faewild"))    {var="PPXTTMEETTTTTE";};
            if (blood.startsWith("seleighe"))   {var="PPTTXXBBTLTLTE";};
            if (blood.startsWith("unseleighe")) {var="PPMMTTBBTMTMTE";};
            // troll
            if (blood.startsWith("streak2"))    {var="KKMMCCCCGGGCMM";};
            if (blood.startsWith("albino2"))    {var="PPAAAACCAAAAAA";};
            if (blood.startsWith("leucism2"))   {var="PPLLLLCCLLLLLL";};
            if (blood.startsWith("melanism2"))  {var="PPMMMMCCMMMMMM";};
            if (blood.startsWith("grey2"))      {var="PPGGGGCCGGGGGG";};
            if (blood.startsWith("erythrism2")) {var="PPEEEECCEEEEEE";};
            if (blood.startsWith("xanthism2"))  {var="PPXXXXCCXXXXXX";};
            if (blood.startsWith("axanthism2")) {var="PPBBBBCCBBBBBB";};
            if (blood.startsWith("caste2"))     {var="PPCCCCCCCCCCCC";};
            if (blood.startsWith("inverted2"))  {var="PPIIIICCIIIIII";};
            if (blood.startsWith("earthtone2")) {var="PPTTTTCCTTTTTT";};
            if (blood.startsWith("pale"))       {var="PPLLLLCCLMCCCM";};
		return var;
	}
       
        public String syndrome(String blood) {
		Random rand = new Random();
		String var = new String("");
                if (blood.startsWith("blank")) {var = "NNnnnnnnNNNN";return var;};
		if (blood=="truerand") {
                        String[] A2 = {"N", "V", "G", "Z", "U", "W"};
                        String[] B6 = {"v", "e", "m", "n", "p", "o", "q"};
                        String[] C4 = {"N", "N", "N", "N", "I", "S", "G", "W", "D"};
                        var = Gene.randopt(A2, 2);
			var = var + Gene.randopt(B6, 6);
			var = var + Gene.randopt(C4, 4);
			return var;}
		var = Gene.mutiBlend(picksyndrome(blood), picksyndrome(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), picksyndrome("rand"));
		return var;		
	}
	
	public String picksyndrome(String blood) {
		Blood b = new Blood(blood);
 		Random rand = new Random();
		String var = new String();
		var = "NNnnnnnnNNNN"; // default
                // need 2 letters of a gene for it to express
                // 2char: undeath - N(nothing), V(vampire/Drinker), G(ghoul), Z(mindless zombie), 
                // ------ U(fae undying), W(weak spark)
                // 6char: supernatural - v(voodoo), e(eldritch), m(magic), n(null)
                // ------ p(physical psychic), o(oracular psychic), q(mental psychic)
                // 4char: substance allergy - N (none), I(iron), S(silver), G(gold), W(water), D (daylight)
		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
                            "null", "eldritch", "psiphys", "psyment", "psysens", "voodoo", "magic", "rainbow"};
			blood = options[rand.nextInt(options.length)];
		} // end rand
		if (blood=="truerand") {
                        String[] A2 = {"N", "V", "G", "Z", "U", "W"};
                        String[] B6 = {"v", "e", "m", "n", "p", "o", "q"};
                        String[] C4 = {"N", "I", "S", "G", "W", "D"};
                        var = Gene.randopt(A2, 2);
			var = var + Gene.randopt(B6, 6);
			var = var + Gene.randopt(C4, 4);
			return var;}
                // end truerand
      		if (Gene.ishum(blood)) {
			String[] humopt = {
                            "null", "null", "null", "null", "null", "null", "null", "null", "null", 
                            "null", "null", "null", "null", "null", "null", "null", "null", "null", 
                            "vampire", "eldritch", "psiphys", "psyment", "psysens", "voodoo", "magic"};
			blood = humopt[rand.nextInt(humopt.length)];
		} // end human
      		if (Gene.isfae(blood)) {
			String[] faeopt = {
                            "fae", "faewild", "seleighe", "unseleighe", "faevamp", "faeghoul"};
			blood = faeopt[rand.nextInt(faeopt.length)];
		} // end fae

                
		// caste presets
            if (blood.startsWith("RR")) {var="NNppnnonNNNN";}; //Maroon
            if (blood.startsWith("Rr")) {var="NNpnoonnNNNN";};
            if (blood.startsWith("rr")) {var="NNnnnnqqNNNN";}; // Bronze
            if (blood.startsWith("Rg")) {var="NNnpononNNNN";};
            if (blood.startsWith("RG")) {var="NNppppppNNNN";}; // Gold
            if (blood.startsWith("Gr")) {var="NNpqpqpqNNNN";};
            if (blood.startsWith("rg")) {var="NNqqqqqqNNNN";}; // Lime
            if (blood.startsWith("GG")) {var="NNnnnnnnNNNN";}; // Olive
            if (blood.startsWith("Gg")) {var="VNonononNNNN";};
            if (blood.startsWith("gg")) {var="NVnnnnnnNNNN";}; // Jade
            if (blood.startsWith("Gb")) {var="VNnqnnonNNNN";};
            if (blood.startsWith("GB")) {var="NNnnnnnnNNNN";}; // Teal
            if (blood.startsWith("Bg")) {var="NNnqnnnnNNNN";};
            if (blood.startsWith("gb")) {var="NNnnnnqnNNNN";}; // Ceru
            if (blood.startsWith("BB")) {var="NNnnpnnnNNNN";}; // Bloo
            if (blood.startsWith("Bb")) {var="NGnvnvnvNNNN";};
            if (blood.startsWith("bb")) {var="NNvnvnvnNNNN";}; //Indigo
            if (blood.startsWith("Br")) {var="GNmvmvmvNNNN";};
            if (blood.startsWith("RB")) {var="NNnennenNNNN";}; //Violet
            if (blood.startsWith("Rb")) {var="NNenenneNNNN";};
            if (blood.startsWith("rb")) {var="NNneeeenNNNN";}; //Tyrian
            
	// other presets that overwrite the previous
            // human
            if (blood.startsWith("vampire")) {var="VVmmmqqqDDSS";}; // human vampire
            // fae
            if (blood.startsWith("fae"))        {var="UUnmnnmnIIII";}; // undying
            if (blood.startsWith("faevamp"))    {var="VWnmnnmnIIII";}; // weak spark vampire
            if (blood.startsWith("faeghoul"))   {var="GWnmnnmnIIII";}; // weak spark ghoul
            if (blood.startsWith("faewild"))    {var="NNnmnmnnIIII";}; // wild
            if (blood.startsWith("seleighe"))   {var="NNmnmnmeIIII";}; // seleighe
            if (blood.startsWith("unseleighe")) {var="NNemnmnmIIII";}; // unseleighe
            // troll 
            if (blood.startsWith("rainbow"))  {var="UVnnnnnnNNNN";}; // rainbowdrinker
            // misc
            if (blood.startsWith("null"))     {var="NNnnnnnnNNNN";}; // null
            if (blood.startsWith("eldritch")) {var="NNeeeeeeNNNN";}; // eldritch
            if (blood.startsWith("magic"))    {var="NNmmmmmmNNNN";}; // wizard
            if (blood.startsWith("psiphys"))  {var="NNppppppNNNN";}; // psychic1 : physical
            if (blood.startsWith("psiment"))  {var="NNqqqqqqNNNN";}; // psychic2 : mental
            if (blood.startsWith("psisens"))  {var="NNooooooNNNN";}; // psychic3 : sensory
            if (blood.startsWith("voodoo"))   {var="NNvvvvvvNNNN";}; // voodoo

		return var;
	}
 
	public String sight(String blood) {
		Random rand = new Random();
		String var = new String("ddDdXXPpMmCcAAAAAAAA");
		if (blood.startsWith("blank")) {return var;};
		if (blood=="truerand") {
			String[] Dd = {"D", "d"};
			String[] Xnfa = {"X", "n", "f", "a"};
			String[] Pp = {"P", "p"};
			String[] Mm = {"M", "m"};
			String[] RCU = {"C", "c", "R", "U"};
			String[] ABC = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
							"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
			var = Gene.randopt(Dd, 4) + Gene.randopt(Xnfa, 2) ;
			var = var + Gene.randopt(Pp, 2) + Gene.randopt(Mm, 2);			
			var = var + Gene.randopt(RCU, 2) + Gene.randopt(ABC, 8);
			return var;};
		var = Gene.mutiBlend(picksight(blood), picksight(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), picksight("rand"));			
		return var;		
	}

	public String picksight(String blood){
			Blood b = new Blood(blood);
	 		Random rand = new Random();
			String var = new String();
			var = "ddDdXXPpMmCcAAAAAAAA";
	// 2char: Dd  Daylight sight, vs. eye damage taken from daylight 
	// 2char: Dd  How well see in the dark? (DD great, Dd/dD aight, dd badly) 
	// 2char: XX  (Xx) normal (Nn) nearsight, (Ff)farsight, (Aa)astigmatism 
	// ---------  1 capital or 2 lowercase = expressed.  2 capital = severe.  1 capital + same lowercase = strong.
	// 2char: Pp  Can you see polarization of light? PP yes, else no 
	// 2char: Mm  How well the vision tracks movement Mm/mM normal   
	// 2char:     color vision, dichromat, trichromat, tetrachromat, infravision, ultraviolet, etc.
	// ---  R = 2, extending into infravision. C = 2, c = 1, normal range.  
	// ---  U = 2, extending into ultraviolet. C = 2, c = 1, normal range. 
	// --- cc: dichromat.  Cc / cC, trichromat.  Rc = trichro infra, cU=trichro ultra.  CC/RC/CU/RU tetrachromat.
	// 8char:     "xfoldvision": "",      # Fancy bullshit vision senses
        // --- : number of times each letter occurs tells how strong it is.  all but P need 2+ to activate.
	// --- A=0,  B=1,  C=2,  D=3, E=4, F=5, G=6, H=7, I=8, J=9, K=10, M=20,
        // --- N=Radiation,        O=Auras,                P=Magicsight
	// --- Q=psychic residue,  R=life-sense,           S=Sharingan,                  T=??,
	// --- U=Electromagnetism, V=gravitational fields, W=eldritch horrorterror shit,
	// --- X=dnd darkvision,   Y=ShinySense,           Z=Aspect Affiliation

		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
					"normal1", "normal2", "day", "nearsight", "farsight", "astigmatism", "infra+ultra",
					"BBB", "CCC", "DDD", "EEE", "FFF", "GGG", "HHH", "III", "JJJ", "KKK", "LLL", "MMM", 
					"NNN", "OOO", "PPP", "QQQ", "RRR", "SSS", "TTT", "UUU", "VVV", "WWW", "XXX", "YYY", "ZZZ",
					};
			blood = options[rand.nextInt(options.length)];
		} // end rand
		if (blood=="truerand") {
			String[] Dd = {"D", "d"};
			String[] Xnfa = {"X", "n", "f", "a"};
			String[] Pp = {"P", "p"};
			String[] Mm = {"M", "m"};
			String[] RCU = {"C", "c", "R", "U"};
			String[] ABC = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
							"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
			var = Gene.randopt(Dd, 4) + Gene.randopt(Xnfa, 2) ;
			var = var + Gene.randopt(Pp, 2) + Gene.randopt(Mm, 2);			
			var = var + Gene.randopt(RCU, 2) + Gene.randopt(ABC, 8);
			return var;};
               	if (blood=="human") {
			String[] opthum = {"normal1", "normal2", "day", "nearsight", "farsight", "astigmatism", "infra+ultra",
                        "human", "human", "norm1B", "norm2B", "mage", "nearsight2", "farsight2", "astigmatism2", "infra+ultra2"};
			blood = opthum[rand.nextInt(opthum.length)];
		} // end rand
               	if (blood=="fae") {
			String[] optfae = {"fae", "fae", "fae", "mage",};
			blood = optfae[rand.nextInt(optfae.length)];
		} // end rand

		// caste presets
	if (blood.startsWith("RR")) {var="ddDdxXpPMmCcAAAAAAQA";}; //Maroon
	if (blood.startsWith("Rr")) {var="ddDdxfpPmMCcQAAAAAAA";};
	if (blood.startsWith("rr")) {var="ddDdaXpPMmCcAAAAQAAA";}; // Bronze
	if (blood.startsWith("Rg")) {var="dddDnXpPMmCcAUQAAAAA";};
	if (blood.startsWith("RG")) {var="ddDdXxPpMmCcAUAAAAQA";}; // Gold
	if (blood.startsWith("Gr")) {var="ddDdfXpPMmCcAAAUAAAA";};
	if (blood.startsWith("rg")) {var="ddDdxXpPMmCcAAAAAUAA";}; // Lime
	if (blood.startsWith("GG")) {var="ddDdfXpPMmCcAAAOAAAA";}; // Olive
	if (blood.startsWith("Gg")) {var="dDdDXnpPMmCcAAAAAAAA";};
	if (blood.startsWith("gg")) {var="DDDDxXPpMmCcAAAAAAAA";}; // Jade
	if (blood.startsWith("Gb")) {var="DddDfXpPMmCcAAAAAAAA";};
	if (blood.startsWith("GB")) {var="ddDdnXPpMmCcAAAAAAAA";}; // Teal
	if (blood.startsWith("Bg")) {var="ddDdxnpPmMCcAAAAAAAA";};
	if (blood.startsWith("gb")) {var="ddDdnXpPMmCcAAAAAAAA";}; // Ceru
	if (blood.startsWith("BB")) {var="ddDdxXpPMmCcAAAAAAAA";}; // Bloo
	if (blood.startsWith("Bb")) {var="ddDdnxpPmMcCAAAAAAAA";};
	if (blood.startsWith("bb")) {var="ddDdXxpPMMCcAAAAAAAA";}; //Indigo
	if (blood.startsWith("Br")) {var="ddDdxfpPmMCcAAAAAAAA";};
	if (blood.startsWith("RB")) {var="ddDdXxpPMmCcAAAWAAAA";}; //Violet
	if (blood.startsWith("Rb")) {var="ddDdxapPmMCcAAAAAWAA";};
	if (blood.startsWith("rb")) {var="ddDdnxpPMmCcARAWAAAA";}; //Tyrian
	// other presets
	if (blood.startsWith("normal1"))     {var="ddDdXXpPMmCcAAAAAAAA";};
	if (blood.startsWith("normal2"))     {var="dddDxxPpmMcCAAAAAAAA";};
	if (blood.startsWith("day"))         {var="DDDdxXPpMmCcAAAAAAAA";};
	if (blood.startsWith("nearsight"))   {var="ddDdNNPpMmCcAAAAAAAA";};
	if (blood.startsWith("farsight"))    {var="ddDdFFPpMmCcAAAAAAAA";};
	if (blood.startsWith("astigmatism")) {var="ddDdAAPpMmCcAAAAAAAA";};
	if (blood.startsWith("infra+ultra")) {var="ddDdxXPpMmRUAAAAAAAA";};
	if (blood.startsWith("BBB")) {var="dddDxNPpmMCcBBBBBBBB";}; // 1fold
	if (blood.startsWith("CCC")) {var="ddDdaxPpMmCcCCCCCCCC";}; // 2fold
	if (blood.startsWith("DDD")) {var="dddDxAPpmMccDDDDDDDD";}; // 3fold
	if (blood.startsWith("EEE")) {var="ddDdFxPpMmCcEEEEEEEE";}; // 4fold
	if (blood.startsWith("FFF")) {var="dddDXxPpmMccFFFFFFFF";}; // 5fold
	if (blood.startsWith("GGG")) {var="ddDdxnPpMmCcGGGGGGGG";}; // 6fold
	if (blood.startsWith("HHH")) {var="dddDxFPpmMRcHHHHHHHH";}; // 7fold
	if (blood.startsWith("III")) {var="dddDxxPpmMCcIIIIIIII";}; // 8fold
	if (blood.startsWith("JJJ")) {var="ddDdfXPpMmCcJJJJJJJJ";}; // 9fold
	if (blood.startsWith("KKK")) {var="dddDxXPpmMcCKKKKKKKK";}; // 10fold
	if (blood.startsWith("LLL")) {var="ddDdaXPpMmCcLLLLLLLL";}; // 20fold
	if (blood.startsWith("MMM")) {var="dddDxXPpmMCcMMMMMMMM";}; // 30fold
	if (blood.startsWith("NNN")) {var="ddDdxnPpMmCcNNNNNNNN";}; // radiation
	if (blood.startsWith("OOO")) {var="dddDAXPpmMcUOOOOOOOO";}; // Auras
	if (blood.startsWith("PPP")) {var="dddDxfPpmMCcPPPPPPPP";}; // Magicsight (only need 1)
	if (blood.startsWith("QQQ")) {var="ddDdNXPpMmCcQQQQQQQQ";}; // Psychic Residue
	if (blood.startsWith("RRR")) {var="dddDxaPpmMCcRRRRRRRR";}; // Life-sense
	if (blood.startsWith("SSS")) {var="ddDdnXPpMmCcSSSSSSSS";}; // Sharingan
	if (blood.startsWith("TTT")) {var="dddDxxPpmMCcTTTTTTTT";}; // ??? mystery free space ???
	if (blood.startsWith("UUU")) {var="ddDdXfPpMmCcUUUUUUUU";}; // Electromagnetism
	if (blood.startsWith("VVV")) {var="dddDxXPpmMCcVVVVVVVV";}; // Gravitational fields
	if (blood.startsWith("WWW")) {var="dddDxaPpmMCcWWWWWWWW";}; // Eldritch horrorterror shit
	if (blood.startsWith("XXX")) {var="ddDDnXPpMmCcXXXXXXXX";}; // DnD Darkvision
	if (blood.startsWith("YYY")) {var="dddDXaPpmMCcYYYYYYYY";}; // Shinysense
	if (blood.startsWith("ZZZ")) {var="ddDdxfPpMmCcZZZZZZZZ";}; // Aspect Affiliation
        // nontroll 
	if (blood.startsWith("human"))        {var="DDddxxPpMmCcAAAAAAAA";};
	if (blood.startsWith("norm1B"))       {var="DDDdXXpPMmCcAAAAAAAA";};
	if (blood.startsWith("norm2B"))       {var="DDdDxxPpmMcCAAAOAAAA";};
	if (blood.startsWith("nearsight2"))   {var="DDDdnnPpMmCcAAAAAAOA";};
	if (blood.startsWith("farsight2"))    {var="DDDdffPpMmCcAAAAAAAA";};
	if (blood.startsWith("astigmatism2")) {var="DDDdaaPpMmCcAAAOAAAA";};
	if (blood.startsWith("infra+ultra2")) {var="DDDdXxPpMmRUAAAAAAAA";};
	if (blood.startsWith("fae"))          {var="DDddxxPpMmCcPPPAAAAA";};
	if (blood.startsWith("mage"))         {var="DDDdxXPpMmCcPQPPOPWP";};

        
	return var;
	}
        
        
        
        
        
        
// The blank ones to copy-paste when adding new genes

	public String trait(String blood) {
		Random rand = new Random();
		String var = new String("");
                if (blood.startsWith("blank")) {var = "AA11";return var;};
		if (blood=="truerand") {
                        String[] A2 = {"A", "a"};
			String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                        var = Gene.randopt(A2, 2);
			var = var + Gene.randopt(num, 2);
			return var;}
		var = Gene.mutiBlend(picktrait(blood), picktrait(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), picktrait("rand"));
		return var;		
	}
	
	public String picktrait(String blood) {
		Blood b = new Blood(blood);
 		Random rand = new Random();
		String var = new String();
		var = "AA11"; // default
                // documentation about the gene goes here
                // 2char: A2 - A a, meaning
                // 2char: N2 - 0123456789, meaning
		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
                            "preset0", "preset1", "preset2", "preset3", "preset4"};
			blood = options[rand.nextInt(options.length)];
		} // end rand
		if (blood=="truerand") {
                 	String[] f2 = {"F", "f", "S", "s", "T", "t", "N", "n"};
			String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			var = Gene.randopt(num, 11);
			var = var + Gene.randopt(f2, 2);
			return var;}
                // end truerand
      		if (blood=="human") {
			String[] humopt = {"human", "human1", "human2", "human3"};
			blood = humopt[rand.nextInt(humopt.length)];
		} // end human
      		if (blood=="fae") {
			String[] faeopt = {"fae", "faewild", "seleighe", "unseleighe"};
			blood = faeopt[rand.nextInt(faeopt.length)];
		} // end fae
                
		// caste presets
            if (blood.startsWith("RR")) {var="";}; //Maroon
            if (blood.startsWith("Rr")) {var="";};
            if (blood.startsWith("rr")) {var="";}; // Bronze
            if (blood.startsWith("Rg")) {var="";};
            if (blood.startsWith("RG")) {var="";}; // Gold
            if (blood.startsWith("Gr")) {var="";};
            if (blood.startsWith("rg")) {var="";}; // Lime
            if (blood.startsWith("GG")) {var="";}; // Olive
            if (blood.startsWith("Gg")) {var="";};
            if (blood.startsWith("gg")) {var="";}; // Jade
            if (blood.startsWith("Gb")) {var="";};
            if (blood.startsWith("GB")) {var="";}; // Teal
            if (blood.startsWith("Bg")) {var="";};
            if (blood.startsWith("gb")) {var="";}; // Ceru
            if (blood.startsWith("BB")) {var="";}; // Bloo
            if (blood.startsWith("Bb")) {var="";};
            if (blood.startsWith("bb")) {var="";}; //Indigo
            if (blood.startsWith("Br")) {var="";};
            if (blood.startsWith("RB")) {var="";}; //Violet
            if (blood.startsWith("Rb")) {var="";};
            if (blood.startsWith("rb")) {var="";}; //Tyrian

	// other presets that overwrite the previous
            // human
            if (blood.startsWith("human"))  {var="";};
            if (blood.startsWith("human1")) {var="";};
            if (blood.startsWith("human2")) {var="";};
            if (blood.startsWith("human3")) {var="";};
            // fae
            if (blood.startsWith("fae"))        {var="";};
            if (blood.startsWith("faewild"))    {var="";};
            if (blood.startsWith("seleighe"))   {var="";};
            if (blood.startsWith("unseleighe")) {var="";};
            // troll
            if (blood.startsWith("preset0")) {var="";};
            if (blood.startsWith("preset1")) {var="";};
            if (blood.startsWith("preset2")) {var="";};
            if (blood.startsWith("preset3")) {var="";};
            if (blood.startsWith("preset4")) {var="";};

		return var;
	}

        
}