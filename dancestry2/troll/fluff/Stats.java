package troll.fluff;
import java.util.Random;
import troll.husk.Gene;
@SuppressWarnings("unused")

public class Stats {
	// physical
	public int clout = 0;
	public int grit = 0;
	public int alacrity = 0;
	//mental
	public int hunch = 0;
	public int acumen = 0;
	public int resolve = 0;
	//special
	public int moxie = 0;
	public int psyche = 0;
        public String moon = "";
	//secret1
	public int faith = 0;       // +rage -hope
	public int order = 0;       // +life -doom
	public int entropy = 0;     // +time -space
	public int connection = 0;  // +blood -breath
	public int self = 0;        // +mind -heart
	public int opportunity = 0; // +light -void
	// secret 2
	public int activity = 0;   // sum above between -60 (passive) and +60 (active)
	public int exploit = 0;    // sum absolute value of self+connection+faith           +knight/-page
	public int move = 0;       // sum absolute value of self+connection+entropy         +thief/-rogue
	public int know = 0;       // sum absolute value of opportunity+faith+order         +mage/-seer
	public int manip = 0;      // sum absolute value of opportunity+faith+connection    +witch/-heir
	public int create = 0;     // sum absolute value of entropy+order+opportunity       +maid/-sylph
	public int destroy = 0;    // sum absolute value of entropy+order+self              +prince/-bard
	// if create is greatest, create>15, activity<-25, then Muse.
        // if destroy is greatest, destroy>15, activity>25, then Lord.
        // if activity=0 and create-destroy = 0 = manip-know = move-exploit : waste
        
	int pts = 0;
	public String aspect = "";
	public String role = "";
	
	public Stats(String inputblood) {
		Random rand = new Random();
		if (inputblood=="") {inputblood="mm";};
		if (inputblood=="truerand") {inputblood="mm";};
		
		if (inputblood=="blank") {
			faith = 0; order = 0; entropy = 0; connection = 0; self = 0; opportunity = 0;			
			activity = 0; exploit = 0; move = 0; know = 0; manip = 0; create = 0; destroy = 0;
			clout = 3; acumen = 3; grit = 3; alacrity = 3; hunch = 3; resolve = 3; moxie = 3; psyche = 0;
			pts = 0;
			aspect = getaspect();
			role = getrole3();
			return;
			};
				
		// First, assign secret stats randomly.
		faith = rand.nextInt(20) - 10;		// +rage  -hope
		order = rand.nextInt(20) - 10;		// +life  -doom
		entropy = rand.nextInt(20) - 10;	// +time  -space
		connection = rand.nextInt(20) - 10;	// +blood -breath
		self = rand.nextInt(20) - 10;		// +mind  -heart
		opportunity = rand.nextInt(20) - 10;// +light -void
		// calculate derived values
		activity = activity();  // number between -60 and +60. + active, -passive.
		// Numbers between 0 and 30
		exploit = exploit();
		move = move();
		know = know();
		manip = manip();
		create = create();
		destroy = destroy();

		// assign primary stats randomly
		clout = rand.nextInt(3) + 2;
		acumen = rand.nextInt(3) + 2;
		grit = rand.nextInt(3) + 2;
		alacrity = rand.nextInt(3) + 2;
		hunch = rand.nextInt(3) + 2;
		resolve = rand.nextInt(3) + 2;
		moxie = rand.nextInt(3) + 2;
		psyche = rand.nextInt(3) + 0;
		pts = 2;
		
		// apply caste modifiers
		if (inputblood.startsWith("mm")) {pts=pts+4;};
		if (inputblood.startsWith("RR")) {clout--;    hunch++;  hunch++;    psyche++;  pts++; pts++;};
		if (inputblood.startsWith("Rr")) {clout--;    hunch++;  moxie++;    psyche++;  psyche++; pts++; pts++;};
		if (inputblood.startsWith("rr")) {clout--;    moxie++;  moxie++;    psyche++;  pts=pts+2;};
		if (inputblood.startsWith("Rg")) {clout--;    acumen++; moxie++;    psyche++;  psyche++; pts=pts+2;};
		if (inputblood.startsWith("RG")) {clout--;    acumen++; psyche++;   psyche++;  pts=pts+2;};
		if (inputblood.startsWith("Gr")) {clout--;    acumen++; psyche++;   psyche++;  pts=pts+2;};
		if (inputblood.startsWith("rg")) {clout--;    grit--;   psyche++;   psyche++;  psyche++; pts=pts+2;};
		if (inputblood.startsWith("GG")) {alacrity++; hunch++;  pts=pts+2;};
		if (inputblood.startsWith("Gg")) {acumen++;   grit++;   alacrity++; hunch++;};
		if (inputblood.startsWith("gg")) {acumen++;   grit++;   pts=pts+2;};
		if (inputblood.startsWith("Gb")) {acumen++;   acumen++; grit++;     moxie++;   pts=pts+1;};
		if (inputblood.startsWith("GB")) {acumen++;   moxie++;  pts=pts+2;};
		if (inputblood.startsWith("gb")) {hunch++;    moxie++;  pts=pts+2;};
		if (inputblood.startsWith("Bg")) {hunch++;    moxie++;  pts=pts+2;};
		if (inputblood.startsWith("BB")) {clout++;    acumen++; alacrity--; resolve++; pts=pts+2;};
		if (inputblood.startsWith("Bb")) {clout++;    grit++;   resolve++;  moxie--;   pts=pts+2;};
		if (inputblood.startsWith("bb")) {clout++;    acumen--; grit++;     resolve++; pts=pts+2;};
		if (inputblood.startsWith("Br")) {clout++;    grit++;   resolve++;  moxie--;   psyche--; pts=pts+2;};
		if (inputblood.startsWith("RB")) {clout++;    grit++;   resolve++;  psyche--;  psyche--; pts=pts+2;};
		if (inputblood.startsWith("Rb")) {clout++;    grit++;   resolve++;  psyche--;  psyche--; pts=pts+2;};
		if (inputblood.startsWith("rb")) {clout++;    grit++;   resolve++;  psyche--;  psyche--; pts=pts+2;};
                // non-troll options
                if (inputblood.equals("human")) {hunch++;  resolve++; psyche--;   pts=pts+3;};
                if (inputblood.equals("fae"))   {psyche++; psyche++;  psyche++;   grit--;};
                if (inputblood.equals("pixie")) {clout++;  psyche++;  alacrity++; alacrity++;};
                if (inputblood.equals("hobb"))  {clout++;  clout++;   pts++;      pts++;};
                if (inputblood.equals("dryad")) {psyche++; moxie++;   resolve++;  alacrity++;};
		
		while (pts>0) {
			int y = rand.nextInt(8);
			if (y==0) {clout++;};
			if (y==1) {acumen++;};
			if (y==2) {grit++;};
			if (y==3) {alacrity++;};
			if (y==4) {hunch++;};
			if (y==5) {resolve++;};
			if (y==6) {moxie++;};
			if (y==7) {psyche++;};
			pts=pts-1;}
		
		// Make marginal psychic powers less common
		// Trolls without red in their blood have weaker powers.
		// Trolls with blue in their blood are weakish.
		int z = rand.nextInt(3);
		if ((z!=1)&&(!Gene.canhas(inputblood, 'R'))) {psyche=psyche-1;};
		if ((z!=1)&&(Gene.canhas(inputblood, 'B'))) {psyche=psyche-1;};
			
		// use the above to assign the aspect and class
		aspect = getaspect();
		role = getrole3();
                // coinflip the moon
                moon = "Prospit"; if (rand.nextBoolean()) {moon="Derse";};
		if (rand.nextBoolean()&&rand.nextBoolean()&&rand.nextBoolean()) {
                    if (rand.nextBoolean()&&rand.nextBoolean()&&rand.nextBoolean()) {
                        if (rand.nextBoolean()&&rand.nextBoolean()&&rand.nextBoolean()) {moon="Both";};
                        };
                    };
	}
	
	public String getaspect() {
		// If faith is the strongest axis
		if ((Math.abs(faith) >= Math.abs(order))&&
		(Math.abs(faith) >= Math.abs(entropy))&&
		(Math.abs(faith) >= Math.abs(connection))&&
		(Math.abs(faith) >= Math.abs(self))&&
		(Math.abs(faith) >= Math.abs(opportunity))) {
			if (faith>0) {aspect="Rage";};
			if (faith<=0) {aspect="Hope";};
		};
		// If order is the strongest axis
		if ((Math.abs(order) >= Math.abs(faith))&&
		(Math.abs(order) >= Math.abs(entropy))&&
		(Math.abs(order) >= Math.abs(connection))&&
		(Math.abs(order) >= Math.abs(self))&&
		(Math.abs(order) >= Math.abs(opportunity))) {
			if (order>0) {aspect="Life";};
			if (order<=0) {aspect="Doom";};
		};

		// If connection is the strongest axis
		if ((Math.abs(connection) >= Math.abs(faith))&&
		(Math.abs(connection) >= Math.abs(order))&&
		(Math.abs(connection) >= Math.abs(entropy))&&
		(Math.abs(connection) >= Math.abs(self))&&
		(Math.abs(connection) >= Math.abs(opportunity))) {
			if (connection>0) {aspect="Blood";};
			if (connection<=0) {aspect="Breath";};
		};

		// If self is the strongest axis
		if ((Math.abs(self) >= Math.abs(faith))&&
		(Math.abs(self) >= Math.abs(order))&&
		(Math.abs(self) >= Math.abs(entropy))&&
		(Math.abs(self) >= Math.abs(connection))&&
		(Math.abs(self) >= Math.abs(opportunity))) {
			if (self>0) {aspect="Mind";};
			if (self<=0) {aspect="Heart";};
		};

		// If luck is the strongest axis
		if ((Math.abs(opportunity) >= Math.abs(faith))&&
		(Math.abs(opportunity) >= Math.abs(order))&&
		(Math.abs(opportunity) >= Math.abs(entropy))&&
		(Math.abs(opportunity) >= Math.abs(connection))&&
		(Math.abs(opportunity) >= Math.abs(self))) {
			if (opportunity>0) {aspect="Light";};
			if (opportunity<=0) {aspect="Void";};
		};

		// If entropy is the strongest axis
		if ((Math.abs(entropy) >= Math.abs(faith))&&
		(Math.abs(entropy) >= Math.abs(order))&&
		(Math.abs(entropy) >= Math.abs(connection))&&
		(Math.abs(entropy) >= Math.abs(self))&&
		(Math.abs(entropy) >= Math.abs(opportunity))) {
			if (entropy>0) {aspect="Time";};
			if (entropy<=0) {aspect="Space";};
		};
		return aspect;
	}

	// Calling them roles instead of classes so my IDE doesn't freak out
	public String getrole3() {
		String role = new String("");
		role = ""; // Make sure it's this
		
		if ((create>=destroy)&&(create>=know)&&(create>=manip)&&(create>=move)&&(create>=exploit)) {
			if (activity>=0)  {role="Maid";};
			if (activity<0)   {role="Sylph";};};
		if ((destroy>=create)&&(destroy>=know)&&(destroy>=manip)&&(destroy>=move)&&(destroy>=exploit)) {
			if (activity>=0)  {role="Prince";};
			if (activity<0)   {role="Bard";};};
		if ((know>=create)&&(know>=destroy)&&(know>=manip)&&(know>=move)&&(know>=exploit)) {
			if (activity>=0)  {role="Mage";};
			if (activity<0)   {role="Seer";};};
		if ((manip>=create)&&(manip>=destroy)&&(manip>=know)&&(manip>=move)&&(manip>=exploit)) {
			if (activity>=0)  {role="Witch";};
			if (activity<0)   {role="Heir";};};
		if ((move>=create)&&(move>=destroy)&&(move>=manip)&&(move>=know)&&(move>=exploit)) {
			if (activity>=0)  {role="Thief";};
			if (activity<0)   {role="Rogue";};};
		if ((exploit>=create)&&(exploit>=destroy)&&(exploit>=manip)&&(exploit>=move)&&(exploit>=know)) {
			if (activity>0)   {role="Knight";};
			if (activity<=0)  {role="Page";};};		
			
		// Lords, Muses, and Wastes have certain activity levels.
		if ((activity>25)&&(destroy>15)) {role="Lord";};  // active
		if ((activity<-25)&&(create>15)) {role="Muse";};  // passive
		boolean why = true;
		
		if (activity==0) {
			if (Math.abs(create-destroy)>1) {why=false;}; 
			if (Math.abs(manip-know)>1) 	{why=false;}; 
			if (Math.abs(move-exploit)>1) 	{why=false;}; 
			if (why) {role="Waste";};        // Awkward
			}

		return role;
	}
	
	
        public String zodiac(String blood, String moon, String aspect) {
          troll.husk.Blood bloodcaste = new troll.husk.Blood(blood); // initalize some blood
          String caste = bloodcaste.castefromcode(blood); // set caste string based on that
          boolean dual = false; String c2 = "";  // check for doubles
          if (caste.equals("Maroon/Bronze")) {dual=true; caste="Maroon";   c2 = "Bronze";};
          if (caste.equals("Bronze/Gold"))   {dual=true; caste="Bronze";   c2 = "Gold";};
          if (caste.equals("Gold/Lime"))     {dual=true; caste="Gold";     c2 = "Lime";};
          if (caste.equals("Lime/Olive"))    {dual=true; caste="Lime";     c2 = "Olive";};
          if (caste.equals("Olive/Jade"))    {dual=true; caste="Olive";    c2 = "Jade";};
          if (caste.equals("Jade/Teal"))     {dual=true; caste="Jade";     c2 = "Teal";};
          if (caste.equals("Teal/Cerulean")) {dual=true; caste="Teal";     c2 = "Cerulean";};
          if (caste.equals("Cerulean/Blue")) {dual=true; caste="Cerulean"; c2 = "Blue";};
          if (caste.equals("Blue/Indigo"))   {dual=true; caste="Blue";     c2 = "Indigo";};
          if (caste.equals("Indigo/Violet")) {dual=true; caste="Indigo";   c2 = "Violet";};
          if (caste.equals("Violet/Tyrian")) {dual=true; caste="Violet";   c2 = "Tyrian";};
          if (caste.equals("Tyrian/Maroon")) {dual=true; caste="Tyrian";   c2 = "Maroon";};
          // caste = done, if (dual) {c2=done}
          String txt = "";
          txt = internalzodiac(caste, moon, aspect);
          if (dual)  {txt = txt + "/" + internalzodiac(c2, moon, aspect);};          
          return txt;
        };
        
        public String internalzodiac(String caste, String moon, String aspect) {
            String txt = "";

          if (caste.equals("Maroon"))   {
            if (moon.equals("Derse")) {
              if (aspect.equals("Time"))   {txt="Aries, the Excavator";};
              if (aspect.equals("Life"))   {txt="Arsces, the Pilgrim";};
              if (aspect.equals("Hope"))   {txt="Arrius, the Visualizer";};
              if (aspect.equals("Rage"))   {txt="Ariborn, the Escapee";};
              if (aspect.equals("Void"))   {txt="Arittarius, the Astronaut";};
              if (aspect.equals("Light"))  {txt="Arpia, the Examiner";};
              if (aspect.equals("Mind"))   {txt="Arza, the Inevitable";};
              if (aspect.equals("Space"))  {txt="Arga, the Trailblazer";};
              if (aspect.equals("Heart"))  {txt="Aro, the Lost";};
              if (aspect.equals("Blood"))  {txt="Arcen, the Companion";};
              if (aspect.equals("Doom"))   {txt="Armini, the Reconciler";};
              if (aspect.equals("Breath")) {txt="Arun, the Impetuous";};
              }; // end derse
          if (moon.equals("Prospit")) {
              if (aspect.equals("Time"))   {txt="Arist, the Headstrong";};
              if (aspect.equals("Life"))   {txt="Arsci, the Medic";};
              if (aspect.equals("Hope"))   {txt="Arnius, the Heedless";};
              if (aspect.equals("Rage"))   {txt="Aricorn, the Runaway";};
              if (aspect.equals("Void"))   {txt="Arittanius, the Voyager";};
              if (aspect.equals("Light"))  {txt="Arpio, the Seeker";};
              if (aspect.equals("Mind"))   {txt="Arra, the Wayward";};
              if (aspect.equals("Space"))  {txt="Argo, the Zenith";};
              if (aspect.equals("Heart"))  {txt="Arlo, the Mirage";};
              if (aspect.equals("Blood"))  {txt="Arcer, the Officer";};
              if (aspect.equals("Doom"))   {txt="Armino, the Static";};
              if (aspect.equals("Breath")) {txt="Arus, the Wanderer";};
              }; // end prospit            
                }; // end maroon
          if (caste.equals("Bronze"))   {
            if (moon.equals("Derse")) {
            if (aspect.equals("Time"))   {txt="Tauries, the Unsatisfied";};
            if (aspect.equals("Life"))   {txt="Taursces, the Recovered";};
            if (aspect.equals("Hope"))   {txt="Taurrius, the Unmapped";};
            if (aspect.equals("Rage"))   {txt="Tauriborn, the Covetous";};
            if (aspect.equals("Void"))   {txt="Tauritarius, the Skydiver";};
            if (aspect.equals("Light"))  {txt="Taurpia, the Asthete";};
            if (aspect.equals("Mind"))   {txt="Taurza, the Revealer";};
            if (aspect.equals("Space"))  {txt="Taurga, the Guardian";};
            if (aspect.equals("Heart"))  {txt="Tauro, the Withdrawn";};
            if (aspect.equals("Blood"))  {txt="Taurcen, the Connected";};
            if (aspect.equals("Doom"))   {txt="Taurmini, the Hermit";};
            if (aspect.equals("Breath")) {txt="Taurun, the Liberated";};
            }; // end derse
          if (moon.equals("Prospit")) {
            if (aspect.equals("Time"))   {txt="Taurist, the Prosperous";};
            if (aspect.equals("Life"))   {txt="Taursci, the Convalescent";};
            if (aspect.equals("Hope"))   {txt="Taurnius, the Entrepeneur";};
            if (aspect.equals("Rage"))   {txt="Tauricorn, the Gratified";};
            if (aspect.equals("Void"))   {txt="Taurittanius, the Utopian";};
            if (aspect.equals("Light"))  {txt="Taurpio, the Student";};
            if (aspect.equals("Mind"))   {txt="Taurra, the Transient";};
            if (aspect.equals("Space"))  {txt="Taurgo, the Divine";};
            if (aspect.equals("Heart"))  {txt="Taurlo, the Extravegant";};
            if (aspect.equals("Blood"))  {txt="Taurcer, the Cherished";};
            if (aspect.equals("Doom"))   {txt="Taurmino, the Lonely";};
            if (aspect.equals("Breath")) {txt="Taurus, the Unfledged";};
            }; // end prospit            
                }; // end bronze
          if (caste.equals("Gold"))     {
            if (moon.equals("Derse")) {
            if (aspect.equals("Time"))   {txt="Gemries, the Savvy";};
            if (aspect.equals("Life"))   {txt="Gemsces, the Prudent";};
            if (aspect.equals("Hope"))   {txt="Gemrius, the Perceptive";};
            if (aspect.equals("Rage"))   {txt="Gemiborn, the Uproarious";};
            if (aspect.equals("Void"))   {txt="Gemittarius, the Sapient";};
            if (aspect.equals("Light"))  {txt="Gempia, the Perspicacious";};
            if (aspect.equals("Mind"))   {txt="Gemza, the Shrewd";};
            if (aspect.equals("Space"))  {txt="Gemga, the Ascetic";};
            if (aspect.equals("Heart"))  {txt="Gemo, the Wit";};
            if (aspect.equals("Blood"))  {txt="Gemcen, the Entertainer";};
            if (aspect.equals("Doom"))   {txt="Gemini, the Cynic";};
            if (aspect.equals("Breath")) {txt="Gemun, the Unbridled";};
            }; // end derse
          if (moon.equals("Prospit")) {
            if (aspect.equals("Time"))   {txt="Gemrist, the Streetwise";};
            if (aspect.equals("Life"))   {txt="Gemsci, the Temperer";};
            if (aspect.equals("Hope"))   {txt="Gemnius, the Canny";};
            if (aspect.equals("Rage"))   {txt="Gemicorn, the Anarchic";};
            if (aspect.equals("Void"))   {txt="Gemittanius, the Shipwright";};
            if (aspect.equals("Light"))  {txt="Gempio, the Concise";};
            if (aspect.equals("Mind"))   {txt="Gemra, the Pilot";};
            if (aspect.equals("Space"))  {txt="Gemgo, the Original";};
            if (aspect.equals("Heart"))  {txt="Gemlo, the Internal";};
            if (aspect.equals("Blood"))  {txt="Gemcer, the Intimate";};
            if (aspect.equals("Doom"))   {txt="Gemino, the Condemned";};
            if (aspect.equals("Breath")) {txt="Gemus, the Alert";};
            }; // end prospit            
                }; // end gold
          if (caste.equals("Lime"))     {
            if (moon.equals("Derse")) {
            if (aspect.equals("Time"))   {txt="Canries, the Scrapper";};
            if (aspect.equals("Life"))   {txt="Cansces, the Mover";};
            if (aspect.equals("Hope"))   {txt="Canrius, the Helper";};
            if (aspect.equals("Rage"))   {txt="Caniborn, the Tumultuous";};
            if (aspect.equals("Void"))   {txt="Canittarius, the Striking";};
            if (aspect.equals("Light"))  {txt="Canpia, the Informer";};
            if (aspect.equals("Mind"))   {txt="Canza, the Producer";};
            if (aspect.equals("Space"))  {txt="Canga, the Playwright";};
            if (aspect.equals("Heart"))  {txt="Cano, the Translucent";};
            if (aspect.equals("Blood"))  {txt="Cancen, the Nexus";};
            if (aspect.equals("Doom"))   {txt="Camini, the Commiserator";};
            if (aspect.equals("Breath")) {txt="Canun, the Vociferous";};
            }; // end derse
          if (moon.equals("Prospit")) {
            if (aspect.equals("Time"))   {txt="Canrist, the Vehement";};
            if (aspect.equals("Life"))   {txt="Cansci, the Reliever";};
            if (aspect.equals("Hope"))   {txt="Cannius, the Theatrical";};
            if (aspect.equals("Rage"))   {txt="Canicorn, the Storm";};
            if (aspect.equals("Void"))   {txt="Canittanius, the Romantic";};
            if (aspect.equals("Light"))  {txt="Canpio, the Effervescent";};
            if (aspect.equals("Mind"))   {txt="Canra, the Constrained";};
            if (aspect.equals("Space"))  {txt="Cango, the Opus";};
            if (aspect.equals("Heart"))  {txt="Canlo, the Thespian";};
            if (aspect.equals("Blood"))  {txt="Cancer, the Signless";};
            if (aspect.equals("Doom"))   {txt="Camino, the Consoler";};
            if (aspect.equals("Breath")) {txt="Canus, the Unbound";};
            }; // end prospit            
                }; // end lime
          if (caste.equals("Olive"))    {
            if (moon.equals("Derse")) {
            if (aspect.equals("Time"))   {txt="Leries, the Tenacious";};
            if (aspect.equals("Life"))   {txt="Lesces, the Instructor";};
            if (aspect.equals("Hope"))   {txt="Lerius, the Staunch";};
            if (aspect.equals("Rage"))   {txt="Leiborn, the Paradox";};
            if (aspect.equals("Void"))   {txt="Leittarius, the Ardent";};
            if (aspect.equals("Light"))  {txt="Lepia, the Synthesizer";};
            if (aspect.equals("Mind"))   {txt="Leza, the Pliant";};
            if (aspect.equals("Space"))  {txt="Lega, the Stoic";};
            if (aspect.equals("Heart"))  {txt="Leo, the Disciple";};
            if (aspect.equals("Blood"))  {txt="Lecen, the Provident";};
            if (aspect.equals("Doom"))   {txt="Lemini, the Trusted";};
            if (aspect.equals("Breath")) {txt="Leun, the Migrant";};
            }; // end derse
          if (moon.equals("Prospit")) {
            if (aspect.equals("Time"))   {txt="Lerist, the Advancer";};
            if (aspect.equals("Life"))   {txt="Lesci, the Polisher";};
            if (aspect.equals("Hope"))   {txt="Lenius, the Restless";};
            if (aspect.equals("Rage"))   {txt="Leicorn, the Unforgiving";};
            if (aspect.equals("Void"))   {txt="Leittanius, the Emphatic";};
            if (aspect.equals("Light"))  {txt="Lepio, the Fortunate";};
            if (aspect.equals("Mind"))   {txt="Lera, the Chameleon";};
            if (aspect.equals("Space"))  {txt="Lego, the Nomad";};
            if (aspect.equals("Heart"))  {txt="Lelo, the Steadfast";};
            if (aspect.equals("Blood"))  {txt="Lecer, the Loyalist";};
            if (aspect.equals("Doom"))   {txt="Lemino, the Sympathetic";};
            if (aspect.equals("Breath")) {txt="Leus, the Flexible";};
            }; // end prospit            
                }; // end olive
          if (caste.equals("Jade"))     {
            if (moon.equals("Derse")) {
            if (aspect.equals("Time"))   {txt="Viries, the Mother";};
            if (aspect.equals("Life"))   {txt="Virsces, the Roborant";};
            if (aspect.equals("Hope"))   {txt="Virrius, the Vindicated";};
            if (aspect.equals("Rage"))   {txt="Viriborn, the Stringent";};
            if (aspect.equals("Void"))   {txt="Virittarius, the Patient";};
            if (aspect.equals("Light"))  {txt="Virpia, the Perfectionist";};
            if (aspect.equals("Mind"))   {txt="Virza, the Puzzle";};
            if (aspect.equals("Space"))  {txt="Virga, the Pure";};
            if (aspect.equals("Heart"))  {txt="Viro, the Redemptive";};
            if (aspect.equals("Blood"))  {txt="Vircen, the Liable";};
            if (aspect.equals("Doom"))   {txt="Virmini, the Abiding";};
            if (aspect.equals("Breath")) {txt="Virun, the Eager";};
            }; // end derse
          if (moon.equals("Prospit")) {
            if (aspect.equals("Time"))   {txt="Virist, the Protector";};
            if (aspect.equals("Life"))   {txt="Virsci, the Alchemist";};
            if (aspect.equals("Hope"))   {txt="Virnius, the Fierce";};
            if (aspect.equals("Rage"))   {txt="Viricorn, the Lethal";};
            if (aspect.equals("Void"))   {txt="Virittanius, the Deliberate";};
            if (aspect.equals("Light"))  {txt="Virpio, the Hearth";};
            if (aspect.equals("Mind"))   {txt="Virra, the Sage";};
            if (aspect.equals("Space"))  {txt="Virgo, the Fruitful";};
            if (aspect.equals("Heart"))  {txt="Virlo, the Foundation";};
            if (aspect.equals("Blood"))  {txt="Vircer, the Accountable";};
            if (aspect.equals("Doom"))   {txt="Virmino, the Inexhaustible";};
            if (aspect.equals("Breath")) {txt="Virus, the Adaptable";};
            }; // end prospit            
                }; // end jade
          if (caste.equals("Teal"))     {
            if (moon.equals("Derse")) {
            if (aspect.equals("Time"))   {txt="Libries, the Executive";};
            if (aspect.equals("Life"))   {txt="Libsces, the Enhancer";};
            if (aspect.equals("Hope"))   {txt="Librius, the Seamstress";};
            if (aspect.equals("Rage"))   {txt="Libiborn, the Finale";};
            if (aspect.equals("Void"))   {txt="Libittarius, the Hidden";};
            if (aspect.equals("Light"))  {txt="Lipia, the Networker";};
            if (aspect.equals("Mind"))   {txt="Libza, the Acute";};
            if (aspect.equals("Space"))  {txt="Liga, the Dogged";};
            if (aspect.equals("Heart"))  {txt="Libo, the Militant";};
            if (aspect.equals("Blood"))  {txt="Licen, the Worshipper";};
            if (aspect.equals("Doom"))   {txt="Limini, the Abider";};
            if (aspect.equals("Breath")) {txt="Libun, the Escapist";};
            }; // end derse
          if (moon.equals("Prospit")) {
            if (aspect.equals("Time"))   {txt="Librist, the Guerilla";};
            if (aspect.equals("Life"))   {txt="Libsci, the Absolver";};
            if (aspect.equals("Hope"))   {txt="Libnius, the Certain";};
            if (aspect.equals("Rage"))   {txt="Libicorn, the Dismantler";};
            if (aspect.equals("Void"))   {txt="Libittanius, the Skeptic";};
            if (aspect.equals("Light"))  {txt="Lipio, the Initiate";};
            if (aspect.equals("Mind"))   {txt="Libra, the Watcher";};
            if (aspect.equals("Space"))  {txt="Ligo, the Circumscribed";};
            if (aspect.equals("Heart"))  {txt="Liblo, the Inescapable";};
            if (aspect.equals("Blood"))  {txt="Licer, the Charmer";};
            if (aspect.equals("Doom"))   {txt="Limino, the Endurer";};
            if (aspect.equals("Breath")) {txt="Libus, the Vibrant";};
            }; // end prospit            
                }; // end teal
          if (caste.equals("Cerulean")) {
            if (moon.equals("Derse")) {
            if (aspect.equals("Time"))   {txt="Scories, the Redeemer";};
            if (aspect.equals("Life"))   {txt="Scorsces, the Alleviator";};
            if (aspect.equals("Hope"))   {txt="Scorrius, the Cunning";};
            if (aspect.equals("Rage"))   {txt="Scoriborn, the Dangerous";};
            if (aspect.equals("Void"))   {txt="Scorittarius, the Doubtful";};
            if (aspect.equals("Light"))  {txt="Scorpia, the Emperor";};
            if (aspect.equals("Mind"))   {txt="Scorza, the Strategist";};
            if (aspect.equals("Space"))  {txt="Scorga, the Deviser";};
            if (aspect.equals("Heart"))  {txt="Scoro, the Wondrous";};
            if (aspect.equals("Blood"))  {txt="Scorcen, the Uniter";};
            if (aspect.equals("Doom"))   {txt="Scormini, the Martyr";};
            if (aspect.equals("Breath")) {txt="Scorun, the Insurgent";};
            }; // end derse
          if (moon.equals("Prospit")) {
            if (aspect.equals("Time"))   {txt="Scorist, the Mutineer";};
            if (aspect.equals("Life"))   {txt="Scorsci, the Fixer";};
            if (aspect.equals("Hope"))   {txt="Scornius, the Radical";};
            if (aspect.equals("Rage"))   {txt="Scoricorn, the Destructive";};
            if (aspect.equals("Void"))   {txt="Scorittanius, the Righteous";};
            if (aspect.equals("Light"))  {txt="Scorpio, the Conqueror";};
            if (aspect.equals("Mind"))   {txt="Scorra, the Impromptu";};
            if (aspect.equals("Space"))  {txt="Scorgo, the Crusader";};
            if (aspect.equals("Heart"))  {txt="Scorlo, the Devious";};
            if (aspect.equals("Blood"))  {txt="Scorcer, the Champion";};
            if (aspect.equals("Doom"))   {txt="Scormino, the Fatalistic";};
            if (aspect.equals("Breath")) {txt="Scorus, the Victorious";};
            }; // end prospit            
                }; // end ceru
          if (caste.equals("Blue"))     {
            if (moon.equals("Derse")) {
            if (aspect.equals("Time"))   {txt="Sagiries, the Revolutionary";};
            if (aspect.equals("Life"))   {txt="Sagisces, the Fervent";};
            if (aspect.equals("Hope"))   {txt="Sagirius, the Bardic";};
            if (aspect.equals("Rage"))   {txt="Sagiborn, the Rampant";};
            if (aspect.equals("Void"))   {txt="Sagittarius, the Engineer";};
            if (aspect.equals("Light"))  {txt="Sagipia, the Empirical";};
            if (aspect.equals("Mind"))   {txt="Sagiza, the Inventor";};
            if (aspect.equals("Space"))  {txt="Sagiga, the Builder";};
            if (aspect.equals("Heart"))  {txt="Sagio, the Ego";};
            if (aspect.equals("Blood"))  {txt="Sagicen, the Teacher";};
            if (aspect.equals("Doom"))   {txt="Sagimini, the Lurid";};
            if (aspect.equals("Breath")) {txt="Sagiun, the Journeyman";};
            }; // end derse
          if (moon.equals("Prospit")) {
            if (aspect.equals("Time"))   {txt="Sagirist, the Rebel";};
            if (aspect.equals("Life"))   {txt="Sagisci, the Genuine";};
            if (aspect.equals("Hope"))   {txt="Saginius, the Believer";};
            if (aspect.equals("Rage"))   {txt="Sagicorn, the Wild";};
            if (aspect.equals("Void"))   {txt="Sagittanius, the Nascent";};
            if (aspect.equals("Light"))  {txt="Sagipio, the Detective";};
            if (aspect.equals("Mind"))   {txt="Sagira, the Tenable";};
            if (aspect.equals("Space"))  {txt="Sagigo, the Creator";};
            if (aspect.equals("Heart"))  {txt="Sagilo, the Lofty";};
            if (aspect.equals("Blood"))  {txt="Sagicer, the Hostess";};
            if (aspect.equals("Doom"))   {txt="Sagimino, the Penitent";};
            if (aspect.equals("Breath")) {txt="Sagius, the Traveler";};
            }; // end prospit            
                }; // end blue
          if (caste.equals("Indigo"))   {
            if (moon.equals("Derse")) {
            if (aspect.equals("Time"))   {txt="Capries, the Bold";};
            if (aspect.equals("Life"))   {txt="Caprisces, the Uplifted";};
            if (aspect.equals("Hope"))   {txt="Capririus, the Contender";};
            if (aspect.equals("Rage"))   {txt="Capriborn, the Malignant";};
            if (aspect.equals("Void"))   {txt="Caprittarius, the Rift";};
            if (aspect.equals("Light"))  {txt="Capripia, the Brusque";};
            if (aspect.equals("Mind"))   {txt="Capriza, the Rigid";};
            if (aspect.equals("Space"))  {txt="Capriga, the Surveyor";};
            if (aspect.equals("Heart"))  {txt="Caprio, the Opaque";};
            if (aspect.equals("Blood"))  {txt="Capricen, the Taskmaster";};
            if (aspect.equals("Doom"))   {txt="Caprimini, the Perilous";};
            if (aspect.equals("Breath")) {txt="Capriun, the Cartographer";};
            }; // end derse
          if (moon.equals("Prospit")) {
            if (aspect.equals("Time"))   {txt="Caprist, the Audacious";};
            if (aspect.equals("Life"))   {txt="Caprisci, the Mendicant";};
            if (aspect.equals("Hope"))   {txt="Caprinius, the Credulous";};
            if (aspect.equals("Rage"))   {txt="Capricorn, the Capricious";};
            if (aspect.equals("Void"))   {txt="Caprittanius, the Brazen";};
            if (aspect.equals("Light"))  {txt="Capripio, the Risk-taker";};
            if (aspect.equals("Mind"))   {txt="Caprira, the Unwavering";};
            if (aspect.equals("Space"))  {txt="Caprigo, the Lacuna";};
            if (aspect.equals("Heart"))  {txt="Caprilo, the Multifaceted";};
            if (aspect.equals("Blood"))  {txt="Capricer, the Defender";};
            if (aspect.equals("Doom"))   {txt="Caprimino, the Enduring";};
            if (aspect.equals("Breath")) {txt="Caprius, the Climber";};
            }; // end prospit            
                }; // end indigo
          if (caste.equals("Violet"))   {
            if (moon.equals("Derse")) {
            if (aspect.equals("Time"))   {txt="Aquaries, the Heroic";};
            if (aspect.equals("Life"))   {txt="Aquasces, the Offbeat";};
            if (aspect.equals("Hope"))   {txt="Aquarius, the Zealous";};
            if (aspect.equals("Rage"))   {txt="Aquiborn, the Hedonist";};
            if (aspect.equals("Void"))   {txt="Aquittarius, the Enigma";};
            if (aspect.equals("Light"))  {txt="Aquapia, the Eccentric";};
            if (aspect.equals("Mind"))   {txt="Aquaza, the Politic";};
            if (aspect.equals("Space"))  {txt="Aquaga, the Campaigner";};
            if (aspect.equals("Heart"))  {txt="Aquo, the Obsessive";};
            if (aspect.equals("Blood"))  {txt="Aquacen, the Avant-garde";};
            if (aspect.equals("Doom"))   {txt="Aquamini, the Idiosyncratic";};
            if (aspect.equals("Breath")) {txt="Aquiun, the Spontaneous";};
            }; // end derse
          if (moon.equals("Prospit")) {
            if (aspect.equals("Time"))   {txt="Aquarist, the Renegade";};
            if (aspect.equals("Life"))   {txt="Aquasci, the Charitable";};
            if (aspect.equals("Hope"))   {txt="Aquanius, the Magician";};
            if (aspect.equals("Rage"))   {txt="Aquicorn, the Tempest";};
            if (aspect.equals("Void"))   {txt="Aquittanius, the Elegant";};
            if (aspect.equals("Light"))  {txt="Aquapio, the Maverick";};
            if (aspect.equals("Mind"))   {txt="Aquara, the Contrarian";};
            if (aspect.equals("Space"))  {txt="Aquago, the Esoteric";};
            if (aspect.equals("Heart"))  {txt="Aqualo, the Puppeteer";};
            if (aspect.equals("Blood"))  {txt="Aquacer, the Foretold";};
            if (aspect.equals("Doom"))   {txt="Aquamino, the Tilted";};
            if (aspect.equals("Breath")) {txt="Aquius, the Whimsical";};
            }; // end prospit            
                }; // end violet
          if (caste.equals("Tyrian"))   {
            if (moon.equals("Derse")) {
            if (aspect.equals("Time"))   {txt="Piries, the Dissenter";};
            if (aspect.equals("Life"))   {txt="Pisces, the Cleric";};
            if (aspect.equals("Hope"))   {txt="Pirius, the Storyteller";};
            if (aspect.equals("Rage"))   {txt="Piborn, the Albatross";};
            if (aspect.equals("Void"))   {txt="Pittarius, the Philosopher";};
            if (aspect.equals("Light"))  {txt="Pipia, the Inquiring";};
            if (aspect.equals("Mind"))   {txt="Piza, the Conjuror";};
            if (aspect.equals("Space"))  {txt="Piga, the Designer";};
            if (aspect.equals("Heart"))  {txt="Pio, the Pathfinder";};
            if (aspect.equals("Blood"))  {txt="Picen, the Compatriot";};
            if (aspect.equals("Doom"))   {txt="Pimini, the Adjuster";};
            if (aspect.equals("Breath")) {txt="Piun, the Unconfined";};
            }; // end derse
          if (moon.equals("Prospit")) {
            if (aspect.equals("Time"))   {txt="Pirist, the Apostate";};
            if (aspect.equals("Life"))   {txt="Pisci, the Druid";};
            if (aspect.equals("Hope"))   {txt="Pinius, the Sensational";};
            if (aspect.equals("Rage"))   {txt="Picorn, the Hurricane";};
            if (aspect.equals("Void"))   {txt="Pittanius, the Quixotic";};
            if (aspect.equals("Light"))  {txt="Pipio, the Searcher";};
            if (aspect.equals("Mind"))   {txt="Pira, the Visionary";};
            if (aspect.equals("Space"))  {txt="Pigo, the Artisan";};
            if (aspect.equals("Heart"))  {txt="Pilo, the Spirited";};
            if (aspect.equals("Blood"))  {txt="Picer, the Confidante";};
            if (aspect.equals("Doom"))   {txt="Pimino, the Empathetic";};
            if (aspect.equals("Breath")) {txt="Pius, the Free";};
            }; // end prospit            
                }; // end tyrian
            
            return txt;
        };
        
        
        
// calculated values section
	// number between -60(PASSIVE) and +60(active)
	public int activity() {int act = faith + order + connection + self + opportunity + entropy;	return act;}
	// Numbers between 0 and 30
	public int exploit() {int val = Math.abs(self) + Math.abs(connection) + Math.abs(faith);return val;}
	public int move() {int val = Math.abs(self) + Math.abs(connection) + Math.abs(entropy);return val;}
	public int know() {int val = Math.abs(opportunity) + Math.abs(faith) + Math.abs(order);return val;}
	public int manip() {int val = Math.abs(opportunity) + Math.abs(faith) + Math.abs(connection);return val;}
	public int create() {int val = Math.abs(entropy) + Math.abs(order) + Math.abs(opportunity);	return val;}
	public int destroy() {int val = Math.abs(entropy) + Math.abs(order) + Math.abs(self);	return val;}

	// Get individual aspect affiliation scores
	public int aspRage() {return faith;}
	public int aspHope() {return -1*faith;}
	public int aspLife() {return order;}
	public int aspDoom() {return -1*order;}
	public int aspBlood() {return connection;}
	public int aspBreath() {return -1*connection;}
	public int aspMind() {return self;}
	public int aspHeart() {return -1*self;}
	public int aspLight() {return opportunity;}
	public int aspVoid() {return -1*opportunity;}
	public int aspTime() {return entropy;}
	public int aspSpace() {return -1*entropy;}
	
	
}

