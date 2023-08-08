package troll.husk;
import java.util.Random;
import java.awt.Color;
@SuppressWarnings("unused")

	// TODO : convert all apply-by-caste things to the format at the bottom of Gene
        // this is all for trolls and just trolls and not fae
	
public class Blood {
	// blood.code is 1-3 characters. And weirdly complex.
	public String code = "";
	public String caste = "";
	public int hue = 0;
	public String color = "";
	
	public Blood(String intxt) {
		if (intxt.equals("rand"))  {intxt = premadeBlood();};
		if (intxt.length()>3) {intxt = codefromcaste(intxt);};
		code = intxt;
		caste = castefromcode(code);
                caste = condensecaste(caste);
                
		Color chroma = new Color(0,0,0);
		chroma = colorfromcode(intxt);
		color = "(" + chroma.getRed() + ", " + chroma.getGreen() + ", " + chroma.getBlue() + ")";
		
		hue = (int) huefromCode(intxt);	
		
		// TODO Auto-generated constructor stub
	}
	
	public static String Getoneblood() {
            String[] trollpigment = {"R", "R", "R", "R", "R", "r", "r", "r", "r", "r",
                                     "G", "G", "G", "G", "g", "g", "g", "B", "B", "b"};
            String blood = Gene.randopt(trollpigment, 1);
            return blood;
	}
	
	public static String premadeBlood() {
            Random rand = new Random();
            int x = rand.nextInt(16); // numbers between 0 and 15
            String blood = Getoneblood() + Getoneblood();
            blood = bloodsort(blood);		
            if (x>12) {blood = blood + Getoneblood();};  // purposefully do not sort the last letter
            return blood;
	}
	
	public static String bloodsort(String inblood) {
		char[] blood = inblood.toCharArray();
		String sortedBlood = ""; 		// output 
                
                // Sort the main letters
		for (char b : blood) {if (b=='R') {sortedBlood=sortedBlood + "R";};}
		for (char b : blood) {if (b=='G') {sortedBlood=sortedBlood + "G";};}
		for (char b : blood) {if (b=='B') {sortedBlood=sortedBlood + "B";};}
		for (char b : blood) {if (b=='r') {sortedBlood=sortedBlood + "r";};}
		for (char b : blood) {if (b=='g') {sortedBlood=sortedBlood + "g";};}
		for (char b : blood) {if (b=='b') {sortedBlood=sortedBlood + "b";};}
                // fae
		for (char b : blood) {if (b=='F') {sortedBlood=sortedBlood + "F";};}
		for (char b : blood) {if (b=='f') {sortedBlood=sortedBlood + "f";};}
		for (char b : blood) {if (b=='A') {sortedBlood=sortedBlood + "A";};}
		for (char b : blood) {if (b=='a') {sortedBlood=sortedBlood + "a";};}
		for (char b : blood) {if (b=='E') {sortedBlood=sortedBlood + "E";};}
		for (char b : blood) {if (b=='e') {sortedBlood=sortedBlood + "e";};}
                // hum
		for (char b : blood) {if (b=='H') {sortedBlood=sortedBlood + "H";};}
		for (char b : blood) {if (b=='h') {sortedBlood=sortedBlood + "h";};}
		for (char b : blood) {if (b=='U') {sortedBlood=sortedBlood + "U";};}
		for (char b : blood) {if (b=='u') {sortedBlood=sortedBlood + "u";};}
		for (char b : blood) {if (b=='M') {sortedBlood=sortedBlood + "M";};}
		for (char b : blood) {if (b=='m') {sortedBlood=sortedBlood + "m";};}
                
                // Put the cruft to the end
                for (char b : blood) {
                    if ((b!='R')&&(b!='G')&&(b!='B')&&(b!='r')&&(b!='g')&&(b!='b')) {
                        if ((b!='F')&&(b!='f')&&(b!='A')&&(b!='a')&&(b!='E')&&(b!='e')) {
                            if ((b!='H')&&(b!='h')&&(b!='U')&&(b!='u')&&(b!='M')&&(b!='m')) {
                                 sortedBlood=sortedBlood + b;};};};};
                
		return sortedBlood;
	}

	public static Color colorfromcode(String incode) {
		
		if ((incode=="blank")||(incode=="xx")) {return Color.lightGray;};

		// let's start with HSV.
		double hue = 0;
		double sat = 0.9;
		double val = 0.4;
		
		// set base hue according to first two letters
		// low
		if (incode.startsWith("RR")) {hue=0;};
		if (incode.startsWith("Rr")) {hue=15;};
		if (incode.startsWith("rr")) {hue=30;};
		if (incode.startsWith("Gr")) {hue=45;val=val+0.05;};
		if (incode.startsWith("RG")) {hue=60;val=val+0.1;};
		if (incode.startsWith("Rg")) {hue=75;val=val+0.05;};
		if (incode.startsWith("rg")) {hue=90;val=val+0.15;};
		// mid
		if (incode.startsWith("GG")) {hue=120;val=val+0.1;};
		if (incode.startsWith("Gg")) {hue=135;val=val+0.05;};
		if (incode.startsWith("gg")) {hue=150;};
		if (incode.startsWith("Gb")) {hue=165;};
		if (incode.startsWith("GB")) {hue=180;};
		if (incode.startsWith("Bg")) {hue=195;};
		if (incode.startsWith("gb")) {hue=210;val=val+0.05;};
		//high
		if (incode.startsWith("BB")) {hue=240;val=val+0.05;};
		if (incode.startsWith("Bb")) {hue=255;};
		if (incode.startsWith("bb")) {hue=270;val=val-0.05;};
		if (incode.startsWith("Br")) {hue=285;val=val-0.1;};
		if (incode.startsWith("RB")) {hue=300;val=val-0.1;};
		if (incode.startsWith("Rb")) {hue=315;};
		if (incode.startsWith("rb")) {hue=330;};

		// How to modify the hue
		String modifier = "";
		
		// pure hues are brighter, between are duller
                int numblood = 0;
                numblood = numblood + Gene.counthas(incode, 'R') + Gene.counthas(incode, 'r');
                numblood = numblood + Gene.counthas(incode, 'G') + Gene.counthas(incode, 'g');
                numblood = numblood + Gene.counthas(incode, 'B') + Gene.counthas(incode, 'b');
                
                // pure trolls
                if ((incode.length() == 2)&&(numblood == 2)) {modifier="pure";};
                // muddy trolls
		if ((incode.length() > 2)&&(numblood>2)) {
			
                // if there is an R:
		if (Gene.canhas(incode,'R')) {
			// If you have an R and a G, last letter effects color as so
			if (Gene.canhas(incode,'G')) {
				if (incode.charAt(2) == 'R') {modifier="bigless";};	
				if (incode.charAt(2) == 'r') {modifier="lilless";};	
				if (incode.charAt(2) == 'G') {modifier="bigplus";};	
				if (incode.charAt(2) == 'g') {modifier="lilplus";};	
				if (incode.charAt(2) == 'B') {modifier="bigmudd";};
				if (incode.charAt(2) == 'b') {modifier="lilmudd";};
			};
			// If you have an R and a B, last letter effects color as so		
			if (Gene.canhas(incode,'B')) {
				if (incode.charAt(2) == 'R') {modifier="bigplus";};	
				if (incode.charAt(2) == 'r') {modifier="lilplus";};	
				if (incode.charAt(2) == 'B') {modifier="bigless";};	
				if (incode.charAt(2) == 'b') {modifier="lilless";};	
				if (incode.charAt(2) == 'G') {modifier="bigmudd";};
				if (incode.charAt(2) == 'g') {modifier="lilmudd";};
			};
			// if it's pure R, no G or B
			if ((!Gene.canhas(incode,'G'))&&(!Gene.canhas(incode,'B'))) {
				if (incode.charAt(2) == 'G') {modifier="bigplus";};	
				if (incode.charAt(2) == 'g') {modifier="lilplus";};	
				if (incode.charAt(2) == 'B') {modifier="bigless";};	
				if (incode.charAt(2) == 'b') {modifier="lilless";};	
				if (incode.charAt(2) == 'R') {modifier="bigrec";}; // dark red
				if (incode.charAt(2) == 'r') {modifier="lilrec";};	
			};
                    }  // end "Has an R"
		// meanwhile, if there IS no R, 
		if (!Gene.canhas(incode,'R')) {
			// If you have a G and a B, last letter effects color as so
			if ((Gene.canhas(incode,'G'))&&(Gene.canhas(incode,'B'))) {
				if (incode.charAt(2) == 'G') {modifier="bigless";};	
				if (incode.charAt(2) == 'g') {modifier="lilless";};	
				if (incode.charAt(2) == 'B') {modifier="bigplus";};	
				if (incode.charAt(2) == 'b') {modifier="lilplus";};	
				if (incode.charAt(2) == 'R') {modifier="bigmudd";};
				if (incode.charAt(2) == 'r') {modifier="lilmudd";};
			};
			// If it's straight B, no G/R
			if ((Gene.canhas(incode,'B'))&&(!Gene.canhas(incode,'G'))) {
				if (incode.charAt(2) == 'R') {modifier="bigplus";};	
				if (incode.charAt(2) == 'r') {modifier="lilplus";};	
				if (incode.charAt(2) == 'G') {modifier="bigless";};	
				if (incode.charAt(2) == 'g') {modifier="lilless";};	
				if (incode.charAt(2) == 'B') {modifier="bigrec";}; // blue is dark
				if (incode.charAt(2) == 'b') {modifier="lilrec";};	
			};
			// if it's straight G, no R/B
			if ((Gene.canhas(incode,'G'))&&(!Gene.canhas(incode,'B'))) {
				if (incode.charAt(2) == 'B') {modifier="bigplus";};	
				if (incode.charAt(2) == 'b') {modifier="lilplus";};	
				if (incode.charAt(2) == 'R') {modifier="bigless";};	
				if (incode.charAt(2) == 'r') {modifier="lilless";};	
				if (incode.charAt(2) == 'G') {modifier="bigrec";}; // dark green
				if (incode.charAt(2) == 'g') {modifier="lilrec";};	
			};
                    }  // end "Has no R"
		} // end "has 3 letters"
		
		// Apply the modifiers
		if (modifier=="pure") {val=val+0.1;sat=sat+0.15;}; // Pure colors are bright
		if (modifier=="bigrec") {sat=sat+0.1;    val=val-0.15;}; // big recessive
		if (modifier=="lilrec") {sat=sat+0.05;   val=val-0.1;};	 // lil recessive
		if (modifier=="bigplus") {hue=hue+6;     val=val-0.1;};  
		if (modifier=="lilplus") {hue=hue+3;     val=val-0.05;};
		if (modifier=="bigless") {hue=hue-6;     val=val-0.1;};
		if (modifier=="lilless") {hue=hue-3;     val=val-0.05;};
		if (modifier=="bigmudd") {sat=sat-0.1;   val=val-0.15;};
		if (modifier=="lilmudd") {sat=sat-0.05;  val=val-0.1;};
		
                // Set degenerate bloods with 1 valid blood letter or less
                if (numblood<2) {
                    if (Gene.counthas(incode, 'R')>0) {hue=0;};
                    if (Gene.counthas(incode, 'r')>0) {hue=30;};
                    if (Gene.counthas(incode, 'G')>0) {hue=120;};
                    if (Gene.counthas(incode, 'g')>0) {hue=150;};
                    if (Gene.counthas(incode, 'B')>0) {hue=240;};
                    if (Gene.counthas(incode, 'b')>0) {hue=270;};                    
                    };
                // adjust blood hue for fae and humans
                if (Gene.counthas(incode, 'f')>0) {sat=sat-0.2; hue = avg(hue,0);}; // redfae
                if (Gene.counthas(incode, 'a')>0) {sat=sat-0.2; hue = avg(hue,0);}; // redfae
                if (Gene.counthas(incode, 'e')>0) {sat=sat-0.2; hue = avg(hue,0);}; // redfae
                if (Gene.counthas(incode, 'F')>0) {sat=sat-0.2; hue = avg(hue,240);}; // bluefae
                if (Gene.counthas(incode, 'A')>0) {sat=sat-0.2; hue = avg(hue,240);}; // bluefae
                if (Gene.counthas(incode, 'E')>0) {sat=sat-0.2; hue = avg(hue,240);}; // bluefae
                if (Gene.counthas(incode, 'h')>0) {sat=sat+0.2; hue = avg(hue,0); val=avg(val,0.5);};
                if (Gene.counthas(incode, 'u')>0) {sat=sat+0.2; hue = avg(hue,0); val=avg(val,0.5);};
                if (Gene.counthas(incode, 'm')>0) {sat=sat+0.2; hue = avg(hue,0); val=avg(val,0.5);};
                
                // color correction
		while (hue>360) {hue=hue-360;};
		while (hue<0)   {hue=hue+360;};
		if (sat<0) {sat=0;};
		if (sat>1) {sat=1;};
		if (val<0.15) {val=0.15;};
		if (val>0.9) {val=0.9;};
		
		float h = (float) (hue / 360);
		float s = (float) sat;
		float v = (float) val;
		
		// technically in RGB mode; numbers must stay within 0 - 255
		Color col = new Color(Color.HSBtoRGB(h,s,v)); 
		return col;
	}

	public static double huefromCode(String inblood) {
		Color col = new Color(0,0,0);
		col = colorfromcode(inblood);
		float[] hsb = new float[3];
		hsb = Color.RGBtoHSB(col.getRed(),col.getGreen(), col.getBlue(), null);
		double hue = (double) hsb[0] * 360;
		return hue;
	}
	
	public static String castefromhue(double hue) {
		String caste = new String();		
                int h = (int) hue;
                caste = Gene.colorfromhue(h, false);
                if (caste.equals("")) {caste = "CULL";};
		return caste;
	}
	
        public static String codefromcaste(String caste) {
            caste = caste.toLowerCase();
            String code = "";
            // purecaste
            if (caste.contains("maroon"))   {code = code + "RR";};
            if (caste.contains("bronze"))   {code = code + "rr";};
            if (caste.contains("gold"))     {code = code + "RG";};
            if (caste.contains("lime"))     {code = code + "rg";};
            if (caste.contains("crimson"))  {code = code + "rg";};
            if (caste.contains("olive"))    {code = code + "GG";};
            if (caste.contains("jade"))     {code = code + "gg";};
            if (caste.contains("teal"))     {code = code + "GB";};
            if (caste.contains("cerulean")) {code = code + "gb";};
            if (caste.contains("blue"))     {code = code + "BB";};
            if (caste.contains("indigo"))   {code = code + "bb";};
            if (caste.contains("violet"))   {code = code + "RB";};
            if (caste.contains("tyrian"))   {code = code + "rb";};
            // mixedcaste
            if (caste.contains("maroon/bronze")) {code = "Rr";};
            if (caste.contains("bronze/gold"))   {code = "Gr";};
            if (caste.contains("gold/lime"))     {code = "Rg";};
            if (caste.contains("lime/olive"))    {code = "rgg";};
            if (caste.contains("olive/jade"))    {code = "Gg";};
            if (caste.contains("jade/teal"))     {code = "Gb";};
            if (caste.contains("teal/cerulean")) {code = "Bg";};
            if (caste.contains("cerulean/blue")) {code = "Bgb";};
            if (caste.contains("blue/indigo"))   {code = "Bb";};
            if (caste.contains("indigo/violet")) {code = "Br";};
            if (caste.contains("violet/tyrian")) {code = "Rb";};
            if (caste.contains("tyrian/maroon")) {code = "rrb";};
            // humans & Carapacians & fae
            if (Gene.ishum(caste))           {code = code + "HUM";};
            if (Gene.iscarapacian(caste))    {code = code + "CCC";};
            // faetypes
            int blue = 0; String[] B = {"F", "A", "E"};
            int red = 0;  String[] r = {"f", "a", "e"};
            if (caste.contains("sidhe"))      {blue++; red++;};
            if (caste.contains("unseleighe")) {blue++; red++;};
            if (caste.contains("seleighe"))   {blue++; red++;};
            if (caste.contains("frostgiant")) {blue++;};
            if (caste.contains("pookah"))     {blue++; red++;};
            if (caste.contains("wild"))   {red++;};
            if (caste.contains("fae"))    {red++;};
            if (caste.contains("satyr"))  {red++;};
            if (caste.contains("hobb"))   {red++;};
            if (caste.contains("pixie"))  {red++;};
            if (caste.contains("dryad"))  {red++;};
            if (caste.contains("kelpie")) {red++;};
            if (caste.contains("selkie")) {red++;};
            if (caste.contains("redcap")) {red++;};
            if (caste.contains("ogre"))   {red++;};
            String temp = "";
            while (red>0)  {temp = temp + Gene.randopt(r, 2); red--;};
            while (blue>0) {temp = temp + Gene.randopt(B, 2); blue--;};
            temp = bloodsort(temp);
            while (temp.length()>3) {temp = temp.substring(0, 3);};
            code=code+temp;
            //endfae
            return code;
        };
        
	public static String castefromcode(String inblood) {
		String caste = inblood;
                // Assemble possibilities
                if (Gene.istroll(inblood)) {caste = caste + castefromhue(huefromCode(inblood));};
                if (Gene.ishum(inblood)) {caste = caste + " human ";};
                if (Gene.isfae(inblood)) {caste = caste + " fae ";};
                if (Gene.iscarapacian(inblood)) {caste = caste + " carapacian ";};
                // condense
                caste = condensecaste(caste);
		return caste;
	}
        
        public static double avg(double x, double y) {
        double z = (x+y)/2;
        return z;
        };

        public static String condensecaste(String L) {
            String var = "";
            boolean human=false;  boolean fae = false;   boolean troll=false;     boolean spirit=false;
            boolean sidhe=false;  boolean hobb=false;    boolean pixie=false;     boolean elemental=false;
            boolean dryad=false;  boolean kelpie=false;  boolean locus=false;     boolean carapacian=false;
            boolean selkie=false; boolean redcap=false;  boolean ogre=false;      boolean frostgiant=false;
            boolean pookah=false; boolean banshee=false; boolean rusalka=false;   boolean satyr=false;
            boolean faewild=false;boolean seleighe=false;boolean unseleighe=false;
            // misc types
            if (L.contains("human"))      {human=true;};
            if (L.contains("carapacian")) {carapacian=true;};
            // fae+spirit types
            if (L.contains("fae"))        {fae=true;};
            if (L.contains("wild"))       {faewild=true;};
            if (L.contains("unseleighe")) {fae=true; unseleighe=true;};
            if (L.contains("seleighe"))   {fae=true; seleighe=true;};
            if (L.contains("sidhe"))      {fae=true; sidhe=true;};
            if (L.contains("frostgiant")) {fae=true; frostgiant=true;};
            if (L.contains("hobb"))       {fae=true; hobb=true;};
            if (L.contains("pixie"))      {fae=true; pixie=true;};
            if (L.contains("dryad"))      {fae=true; dryad=true;};
            if (L.contains("kelpie"))     {fae=true; kelpie=true;};
            if (L.contains("selkie"))     {fae=true; selkie=true;};
            if (L.contains("redcap"))     {fae=true; redcap=true;};
            if (L.contains("ogre"))       {fae=true; ogre=true;};
            if (L.contains("pookah"))     {fae=true; pookah=true;}; 
            if (L.contains("banshee"))    {fae=true; spirit=true; banshee=true;}; 
            if (L.contains("banesidhe"))  {fae=true; spirit=true; banshee=true;}; 
            if (L.contains("rusalka"))    {fae=true; spirit=true; rusalka=true;}; 
            if (L.contains("elemental"))  {fae=true; spirit=true; elemental=true;}; 
            if (L.contains("locus"))        {spirit=true; locus=true;}; 
            if (L.contains("genius locii")) {spirit=true; locus=true;}; 
            if (L.contains("locii"))        {spirit=true; locus=true;}; 
            // trolls and casteshit
            if (L.startsWith("RR"))       {troll=true; var="maroon-";};
            if (L.startsWith("maroon"))   {troll=true; var="maroon-";};
            if (L.startsWith("burgundy")) {troll=true; var="maroon-";};
            if (L.startsWith("Rr"))       {troll=true; var="maroon/bronze-";};
            if (L.startsWith("rr"))       {troll=true; var="bronze-";};
            if (L.startsWith("bronze"))   {troll=true; var="bronze-";};
            if (L.startsWith("brown"))    {troll=true; var="bronze-";};
            if (L.startsWith("copper"))   {troll=true; var="bronze-";};
            if (L.startsWith("Gr"))       {troll=true; var="bronze/gold-";};
            if (L.startsWith("RG"))       {troll=true; var="gold-";};
            if (L.startsWith("gold"))     {troll=true; var="gold-";};
            if (L.startsWith("yellow"))   {troll=true; var="gold-";};
            if (L.startsWith("helm"))     {troll=true; var="gold-";};
            if (L.startsWith("Rg"))       {troll=true; var="gold/lime-";};
            if (L.startsWith("rg"))       {troll=true; var="lime-";};
            if (L.startsWith("lime"))     {troll=true; var="lime-";};
            if (L.startsWith("cull"))     {troll=true; var="off-color-";};
            if (L.startsWith("GG"))       {troll=true; var="olive-";};
            if (L.startsWith("olive"))    {troll=true; var="olive-";};
            if (L.startsWith("green"))    {troll=true; var="olive-";};
            if (L.startsWith("Gg"))       {troll=true; var="olive/jade-";};
            if (L.startsWith("gg"))       {troll=true; var="jade-";};
            if (L.startsWith("jade"))     {troll=true; var="jade-";};
            if (L.startsWith("Gb"))       {troll=true; var="jade/teal-";};
            if (L.startsWith("GB"))       {troll=true; var="teal-";};
            if (L.startsWith("teal"))     {troll=true; var="teal-";};
            if (L.startsWith("cyan"))     {troll=true; var="teal-";};
            if (L.startsWith("Bg"))       {troll=true; var="teal/cerulean-";};
            if (L.startsWith("bg"))       {troll=true; var="cerulean-";};
            if (L.startsWith("cerulean")) {troll=true; var="cerulean-";};
            if (L.startsWith("skyblue"))  {troll=true; var="cerulean-";};
            if (L.startsWith("BB"))       {troll=true; var="blue-";};
            if (L.startsWith("bloo"))     {troll=true; var="blue-";};
            if (L.startsWith("blue"))     {troll=true; var="blue-";};
            if (L.startsWith("navy"))     {troll=true; var="blue-";};
            if (L.startsWith("Bb"))       {troll=true; var="blue/indigo-";};
            if (L.startsWith("bb"))       {troll=true; var="indigo-";};
            if (L.startsWith("indigo"))   {troll=true; var="indigo-";};
            if (L.startsWith("clown"))    {troll=true; var="indigo-";};
            if (L.startsWith("Br"))       {troll=true; var="indigo/violet-";};
            if (L.startsWith("RB"))       {troll=true; var="violet-";};
            if (L.startsWith("purple"))   {troll=true; var="violet-";};
            if (L.startsWith("violet"))   {troll=true; var="violet-";};
            if (L.startsWith("fish"))     {troll=true; var="violet-";};
            if (L.startsWith("Rb"))       {troll=true; var="violet/tyrian-";};
            if (L.startsWith("rb"))       {troll=true; var="tyrian-";};
            if (L.startsWith("tyrian"))   {troll=true; var="tyrian-";};
            if (L.startsWith("fuschia"))  {troll=true; var="tyrian-";};
            // affiliations
            if (faewild) {var=var+"wild ";};
            if (seleighe&!unseleighe) {var=var+"seleighe ";};
            if (unseleighe&!seleighe) {var=var+"unseleighe ";};
            if (unseleighe&&seleighe) {var=var+"seleighe/unseleighe ";};
            
            // text string species time
            if (troll)      {var = var + "troll/";};
            if (human)      {var = var + "human/";};
            if (sidhe)      {var = var + "sidhe/";};
            if (hobb)       {var = var + "hobb/";};
            if (pixie)      {var = var + "pixie/";};
            if (elemental)  {var = var + "elemental/";};
            if (dryad)      {var = var + "dryad/";};
            if (kelpie)     {var = var + "kelpie/";};
            if (satyr)      {var = var + "satyr/";};
            if (locus)      {var = var + "locus/";};
            if (carapacian) {var = var + "carapacian/";};
            if (selkie)     {var = var + "selkie/";};
            if (redcap)     {var = var + "redcap/";};
            if (ogre)       {var = var + "ogre/";};
            if (frostgiant) {var = var + "frostgiant/";};
            if (pookah)     {var = var + "pookah/";};
            if (banshee)    {var = var + "banshee/";};
            if (rusalka)    {var = var + "rusalka/";};
            
            // trim that last slash if there is one
            if (var.endsWith("/")) {var=var.substring(0, var.length()-1);};
            
            // If string contains ZERO recognized text, spit it back out as-is
            if (var.equals("")) {var=L;};
            /* another way to check if all tests have been failed: 
            if (!human&&!fae&&!troll&&!spirit&&!carapacian) {};
            */
            return var;
        };
        
}
