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
		if (inputblood.startsWith("RR")) {clout=clout-1;hunch=hunch+2;psyche=psyche+1;pts=pts+2;};
		if (inputblood.startsWith("Rr")) {clout=clout-1;hunch=hunch+1;moxie=moxie+1;psyche=psyche+2;pts=pts+2;};
		if (inputblood.startsWith("rr")) {clout=clout-1;moxie=moxie+2;psyche=psyche+1;pts=pts+2;};
		if (inputblood.startsWith("Rg")) {clout=clout-1;acumen=acumen+1;moxie=moxie+1;psyche=psyche+1;pts=pts+2;};
		if (inputblood.startsWith("RG")) {clout=clout-1;acumen=acumen+1;psyche=psyche+2;pts=pts+2;};
		if (inputblood.startsWith("Gr")) {clout=clout-1;acumen=acumen+1;psyche=psyche+2;pts=pts+2;};
		if (inputblood.startsWith("rg")) {clout=clout-1;grit=grit-1;psyche=psyche+3;pts=pts+2;};
		if (inputblood.startsWith("GG")) {alacrity=alacrity+1;hunch=hunch+1;pts=pts+2;};
		if (inputblood.startsWith("Gg")) {acumen=acumen+1;grit=grit+1;alacrity=alacrity+1;hunch=hunch+1;};
		if (inputblood.startsWith("gg")) {acumen=acumen+1;grit=grit+1;pts=pts+2;};
		if (inputblood.startsWith("Gb")) {acumen=acumen+2;grit=grit+1;moxie=moxie+1;pts=pts+1;};
		if (inputblood.startsWith("GB")) {acumen=acumen+1;moxie=moxie+1;pts=pts+2;};
		if (inputblood.startsWith("gb")) {hunch=hunch+1;moxie=moxie+1;pts=pts+2;};
		if (inputblood.startsWith("Bg")) {hunch=hunch+1;moxie=moxie+1;pts=pts+2;};
		if (inputblood.startsWith("BB")) {clout=clout+1;acumen=acumen+1;alacrity=alacrity-1;resolve=resolve+1;pts=pts+2;};
		if (inputblood.startsWith("Bb")) {clout=clout+1;grit=grit+1;resolve=resolve+1;moxie=moxie-1;pts=pts+2;};
		if (inputblood.startsWith("bb")) {clout=clout+1;acumen=acumen-1;grit=grit+1;resolve=resolve+1;pts=pts+2;};
		if (inputblood.startsWith("Br")) {clout=clout+1;grit=grit+1;resolve=resolve+1;moxie=moxie-1;psyche=psyche-1;pts=pts+2;};
		if (inputblood.startsWith("RB")) {clout=clout+1;grit=grit+1;resolve=resolve+1;psyche=psyche-2;pts=pts+2;};
		if (inputblood.startsWith("Rb")) {clout=clout+1;grit=grit+1;resolve=resolve+1;psyche=psyche-2;pts=pts+2;};
		if (inputblood.startsWith("rb")) {clout=clout+1;grit=grit+1;resolve=resolve+1;psyche=psyche-2;pts=pts+2;};
		
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
			pts=pts-1;
		
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
		}
		
		// TODO Auto-generated constructor stub
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
          // firstchunk
          if (caste.equals("Maroon"))   {txt = txt + "Ar";};
          if (caste.equals("Bronze"))   {txt = txt + "Taur";};
          if (caste.equals("Gold"))     {txt = txt + "Gem";};
          if (caste.equals("Lime"))     {txt = txt + "Can";};
          if (caste.equals("Olive"))    {txt = txt + "Le";};
          if (caste.equals("Jade"))     {txt = txt + "Vir";};
          if (caste.equals("Teal"))     {txt = txt + "Lib";};
          if (caste.equals("Cerulean")) {txt = txt + "Scor";};
          if (caste.equals("Blue"))     {txt = txt + "Sag";};
          if (caste.equals("Indigo"))   {txt = txt + "Capri";};
          if (caste.equals("Violet"))   {txt = txt + "Aqua";};
          if (caste.equals("Tyrian"))   {txt = txt + "Pi";};
          // second chunk
          if (moon.equals("Derse")) {
            if (aspect.equals("Time"))   {txt = txt + "ries";};
            if (aspect.equals("Life"))   {txt = txt + "sces";};
            if (aspect.equals("Hope"))   {txt = txt + "rius";};
            if (aspect.equals("Rage"))   {txt = txt + "iborn";};
            if (aspect.equals("Void"))   {txt = txt + "ittarius";};
            if (aspect.equals("Light"))  {txt = txt + "pia";};
            if (aspect.equals("Mind"))   {txt = txt + "za";};
            if (aspect.equals("Space"))  {txt = txt + "ga";};
            if (aspect.equals("Heart"))  {txt = txt + "o";};
            if (aspect.equals("Blood"))  {txt = txt + "cen";};
            if (aspect.equals("Doom"))   {txt = txt + "mini";};
            if (aspect.equals("Breath")) {txt = txt + "un";};
            }; // end derse
          if (moon.equals("Prospit")) {
            if (aspect.equals("Time"))   {txt = txt + "ist";};
            if (aspect.equals("Life"))   {txt = txt + "sci";};
            if (aspect.equals("Hope"))   {txt = txt + "nius";};
            if (aspect.equals("Rage"))   {txt = txt + "icorn";};
            if (aspect.equals("Void"))   {txt = txt + "ittanius";};
            if (aspect.equals("Light"))  {txt = txt + "pio";};
            if (aspect.equals("Mind"))   {txt = txt + "ra";};
            if (aspect.equals("Space"))  {txt = txt + "go";};
            if (aspect.equals("Heart"))  {txt = txt + "lo";};
            if (aspect.equals("Blood"))  {txt = txt + "cer";};
            if (aspect.equals("Doom"))   {txt = txt + "mino";};
            if (aspect.equals("Breath")) {txt = txt + "us";};
            }; // end prospit            
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

