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
	//secret1
	public int faith = 0;
	public int order = 0;
	public int entropy = 0;
	public int connection = 0;
	public int self = 0;
	public int opportunity = 0;
	// secret 2
	public int activity = 0;
	public int exploit = 0;
	public int move = 0;
	public int know = 0;
	public int manip = 0;
	public int create = 0;
	public int destroy = 0;
	
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
		if (inputblood.startsWith("Rb")) {clout=clout+1;grit=grit+1;resolve=resolve+1;psyche=psyche-4;pts=pts+2;};
		if (inputblood.startsWith("rb")) {clout=clout+1;grit=grit+1;resolve=resolve+1;psyche=psyche-6;pts=pts+2;};
		
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
	public String getrole() {
		String role = new String("");
		role = ""; // Make sure it's this
		// Let's do this with stat comparisons.
				
		// Assign them in this order, becoming gradually harder to manage
		if (exploit>9)  {if (activity>=0)  {role="Knight";};
		   				 if (activity<0)   {role="Page";};};
		if (move>15)    {if (activity>=2)  {role="Thief";};
						 if (activity<-2)  {role="Rogue";};};
		if (know>15)    {if (activity>=3)  {role="Mage";};
		                 if (activity<-3)  {role="Seer";};};
		if (manip>15)   {if (activity>=5)  {role="Witch";};
		   				 if (activity<-6)  {role="Heir";};};
		if (create>15)  {if (activity>=10) {role="Maid";};
				   		 if (activity<-12) {role="Sylph";};};
		if (destroy>15) {if (activity>=12) {role="Prince";};
						 if (activity<-15) {role="Bard";};};
		if (role=="") {
			if (activity>=30) 							  {role="Lord";};
			if (activity==0)                              {role="Waste";};
			if (activity<-30) 							  {role="Muse";};
			
			// Welcome to B-tier, where the standards are much lower.			
            if (create>=destroy) {if (activity>=1)  {role="Maid";};
		 						  if (activity<-1)  {role="Sylph";};};
		 	if (destroy>create)  {if (activity>=2)  {role="Prince";};
		 						  if (activity<-2)  {role="Bard";};};
									   
			if (know>=manip)    { if (activity>=1)  {role="Mage";};
            					  if (activity<-1)  {role="Seer";};};
            if (manip>know)     { if (activity>=1)  {role="Witch";};
            					  if (activity<-1)  {role="Heir";};};
            					        
            if (move<=exploit)  { if (activity>=1)  {role="Thief";};
            					  if (activity<1)   {role="Rogue";};};
			if (exploit>move)   { if (activity>=1)  {role="Knight";};
							      if (activity<0)   {role="Page";};};	
            					        
  			if ((activity>=20)&&(role=="")) {role="Lord";};
  			if ((activity<-20)&&(role=="")) {role="Muse";};
  			}

		if ((role=="")||(role=="Waste")) {
			// Welcome to C tier! 
			if ((clout<2)||(clout>4)) 		{role="Prince"; if (activity<0) {role="Bard";};};
			if ((moxie<2)||(moxie>4)) 		{role="Maid"; if (activity<0) 	{role="Sylph";};};
			if ((hunch<2)||(hunch>4)) 		{role="Witch"; if (activity<0) 	{role="Heir";};};
			if ((alacrity<2)||(alacrity>4)) {role="Thief"; if (activity<0) 	{role="Rogue";};};
			if ((acumen<2)||(acumen>4)) 	{role="Mage"; if (activity<0)	{role="Seer";};};
			if ((resolve<2)||(resolve>4)) 	{role="Knight"; if (activity<0) {role="Page";};};
  			}
		
		//if (role=="") {role="TEST";};
		
	
		String finalrole = new String(role);
		return finalrole;
	}

	// Calling them roles instead of classes so my IDE doesn't freak out
	public String getrole2() {
		String role = new String("");
		role = ""; // Make sure it's this
		// Let's do this with stat comparisons.
		int group1 = exploit + move;
		int group2 = know + manip;
		int group3 = create + destroy;

		// Create, Destroy: Maid, Sylph, Prince, Bard.
		if ((group3>=group1)&&(group3>=group2)) {
			if (create>=destroy) {
				if (activity>=0)  {role="Maid";};
				if (activity<0)   {role="Sylph";};};	
			if (create<destroy) {
				if (activity>=0)  {role="Prince";};
				if (activity<0)   {role="Bard";};};	
			};

		// Exploit, Relocate : Knight, Page, Thief, Rogue.
		if ((group1>=group2)&&(group1>=group3)) {
			if (exploit>move) {
				if (activity>=0)  {role="Knight";};
				if (activity<0)   {role="Page";};};	
			if (exploit<=move) {
				if (activity>=0)  {role="Thief";};
				if (activity<0)   {role="Rogue";};};	
			};
		
		// Know, Manipulate : Mage, Seer, Witch, Heir.
		if ((group2>=group1)&&(group2>=group3)) {
			if (know>=manip) {
				if (activity>=0)  {role="Mage";};
				if (activity<0)   {role="Seer";};};	
			if (know<manip) {
				if (activity>=0)  {role="Witch";};
				if (activity<0)   {role="Heir";};};	
			};
		
		// Override zone to add some variety
		Random rand = new Random();
		int rarerole = rand.nextInt(99);
		// Lords, Muses, and Wastes have certain activity levels.
		if (rarerole<2) {
			if (activity>30) {role="Lord";};  // active
			if (activity<-30) {role="Muse";}; // passive
			if (activity==0) {role="Waste";}; // Awkward
		};

		// If you have very high or low stats, that can adjust your class.
		if (rarerole>40) {
			if ((clout==1)||(clout>5))       {role="Prince";if (activity<0) {role="Bard";};};
			if ((grit==1)||(grit>5))         {role="Witch"; if (activity<0) {role="Heir";};};
			if ((alacrity==1)||(alacrity>6)) {role="Thief"; if (activity<0) {role="Rogue";};};
			if ((acumen==1)||(acumen>6))     {role="Mage";  if (activity<0) {role="Seer";};};
			if ((hunch==1)||(hunch>6))       {role="Mage";  if (activity<0) {role="Seer";};};
			if ((resolve==1)||(resolve>5))   {role="Knight";if (activity<0) {role="Page";};};
			if ((moxie==1)||(moxie>5))       {role="Maid";  if (activity<0) {role="Sylph";};};
		};
		
		// There are some other stats that can give you a class, less often...
		if ((rarerole>10)&&(rarerole<50)) {
			if ((resolve<3)&&(activity<0)) {role="Page";};
			if ((resolve>4)&&(activity>0)) {role="Prince";};
			if ((acumen+hunch>8)||(acumen+hunch<5)) {role="Mage";  if (activity<0) {role="Seer";};};
			if ((hunch+moxie>8)||(hunch+moxie<4))   {role="Witch"; if (activity<0) {role="Heir";};};
			if ((hunch+alacrity>8)||(hunch+alacrity<4)) {role="Thief";  if (activity<0) {role="Rogue";};};
		};
			
		String finalrole = new String(role);
		return finalrole;
	}

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

