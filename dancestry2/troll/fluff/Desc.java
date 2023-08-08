package troll.fluff;
import troll.husk.*;
import java.awt.Color;
@SuppressWarnings("unused")

public class Desc {
        String build = "";      // redo?
        String respirate = "";  // works well ? might be glitchy?
        String fins = "";       // works well ? might be glitchy?
        String rack = "";       // works okay, might be glitchy
        String pupation = "";   // works well.  add mutant grub eyes later
        String feral = "";      // works okay, might be glitchy.  includes mutant eyes
        String gender = "";     // works aight
        String pigment = "";    // in progress
        
        // - move descriptive functions from Eye to here
        // - New Segment: skin + pigment + syndrome
        // - new segment : vision + psychic, magic, and aspect potential

        // If you want to feed more data into the function,
        // remember to update both here and the place
        // in troll.Troll() where info is fed over here
        
	public Desc(troll.husk.Body body, troll.husk.Horns horns, troll.husk.Eye eyes, troll.fluff.Stats stats) {
            
            // Just the body section
            build = descbuild(body.buildgene);
            respirate = descrespirate(body.respiratorygene);
            fins = descfins(body.fingene);
            pupation = descpupate(body.pupation, body.feralgene, body.tailgene);
            feral = descferal(body.pupation, body.feralgene, body.tailgene);
            gender = descgender(body.fertgene, body.gender);
            pigment = descpigment(body, horns, eyes, stats);
            
            // horns 
            rack = deschorns(horns);

            // eyes
            /* stuff */

            // stats
            /* stuff */            
                        
        }
        
        // bits and bobs
        
	public static String infeet(int inches) {
		String height = new String("");
		int feet = 0;
		
		// Count the number of feet
		while (inches-11>0) {feet++; inches = inches - 12;}		
		height = feet + "ft " + inches + "in";		
		return height;
	}

	public static String colortostring(Color color) {
		String txt = "";
		
		txt = "(" + Integer.toString(color.getRed()) + ", ";
		txt = txt + Integer.toString(color.getGreen()) + ", ";
		txt = txt + Integer.toString(color.getBlue()) + ")";		
		return txt;
	}	
       
        // big chonks
	public static String descbuild(String code) {
		while (code.length()<6) {code=code+"5";};
		
		char[] a = code.toCharArray();
		
		int shoulder = Character.getNumericValue(a[0]);   // numbers between 0 and 9, averaging 3-5
		int waist    = Character.getNumericValue(a[1]);
		int hip      = Character.getNumericValue(a[2]);
		int chest    = Character.getNumericValue(a[3]);
		int butt     = Character.getNumericValue(a[4]);
		int bulk     = Character.getNumericValue(a[5]);
		
		String txt = new String("");
		
                // bulk
		if ((bulk>7)||(bulk<3)) {txt=txt+"very ";};
		if (bulk>6) {txt=txt+"broad ";};
		if (bulk<4) {txt=txt+"thin ";};
                
                txt = txt + "troll with ";
		// chest
                boolean cont = true;
		if (cont&&(chest<3))             {txt = txt+"flat-chested, ";  cont=false;};
		if (cont&&(chest<5))             {txt = txt+"small-chested, "; cont=false;};
		if (cont&&((chest>6)&&(butt<6))) {txt = txt+"large-chested, "; cont=false;};
		if (cont&&((chest>6)&&(butt>5))) {txt = txt+"curvaceous, ";    cont=false;};

                // bodyshape (apple, dorito, rectangle, hourglass, pear)
		boolean hasshoulder = false; if (shoulder>waist) {hasshoulder=true;};
		boolean haships = false;     if (hip>waist)      {haships=true;};
		boolean bottomheavy = false; if (hip>shoulder)   {bottomheavy=true;};
		
                cont = true;
                if ((cont)&&(!hasshoulder)&&(!haships)) {txt = txt + "broad-waisted build";     cont=false;};
		if ((cont)&&(!bottomheavy)&&(!haships)) {txt = txt + "dorito-shaped build";    cont=false;};
		if ((cont)&&(hasshoulder)&&(haships))   {txt = txt + "hourglass-shaped build"; cont=false;};
		if ((cont)&&(bottomheavy)&&(haships))   {txt = txt + "pear-shaped build";      cont=false;};
		if (cont)                               {txt = txt + "rectangular build";      cont=false;};
                
		return txt;
	}
		
	public static String descrespirate(String code) {
		String txt = new String("");
		String control  = code.substring(0,4);
		String bladders = code.substring(4,6);
		String gilleyes = code.substring(6,10);
		String gillneck = code.substring(10,14);
		String gillribs = code.substring(14,18);
		String water = code.substring(18,24);
		String air = code.substring(24);
		boolean cont = true;
		boolean skiptodone = false;
		                  
		// new segment.  Bladders.
                cont=true;
                txt = txt + Gene.permute(bladders, "B", "b", "many air bladders, ", "several air bladders, ", "one air bladder, ", "no air bladders, ");
		// new segment.  gills.
                cont=true;
		String gill1 = "";
		gill1 = Gene.permute(gilleyes.substring(0,2), "G", "g", "full ", "partial ", "partial ", "no ");
		gill1 = gill1 + Gene.permute(gilleyes.substring(2,4), "i", "e", "", "", "", "external ");
		String gill2 = "";
		gill2 = Gene.permute(gillneck.substring(0,2), "G", "g", "full ", "partial ", "partial ", "no ");
		gill2 = gill2 + Gene.permute(gillneck.substring(2,4), "i", "e", "", "", "", "external ");
		String gill3 = "";
		gill3 = Gene.permute(gillribs.substring(0,2), "G", "g", "full ", "partial ", "partial ", "no ");
		gill3 = gill3 + Gene.permute(gillribs.substring(2,4), "i", "e", "", "", "", "external ");
                // missing gill section
                if ((gill1.startsWith("no"))&&(gill2.startsWith("no"))&&(gill3.startsWith("no"))) {
			txt = txt + "entirely lacks gills, "; cont=false;}
		if (!(gill1.startsWith("no"))&&(gill2.startsWith("no"))&&(gill3.startsWith("no"))) {
			txt = txt + "only " + gill1 + "eye gills, "; cont=false;}
		if ((gill1.startsWith("no"))&&!(gill2.startsWith("no"))&&(gill3.startsWith("no"))) {
			txt = txt + "only " + gill2 + "neck gills, "; cont=false;}
		if ((gill1.startsWith("no"))&&(gill2.startsWith("no"))&&!(gill3.startsWith("no"))) {
			txt = txt + "only " + gill3 + "rib gills, "; cont=false;}
                // expressed gill section
		if (cont==true) {txt = txt + gill1 + "eye gills, ";};
		if (cont==true) {txt = txt + gill2 + "neck gills, ";};
		if (cont==true) {txt = txt + gill3 + "rib gills, ";};
                
		// new segment.  Breathing.
		cont = true;
		txt = txt + "breathes ";
		txt = txt + Gene.permute(water.substring(0,2), "S", "s", "saltwater, ", "salt, ", "salt, ", "");
		txt = txt + Gene.permute(water.substring(2,4), "B", "b", "brackwater, ", "brack, ", "brack, ", "");
		txt = txt + Gene.permute(water.substring(4,6), "F", "f", "freshwater, ", "fresh, ", "fresh, ", "");
			
                int numtot = 0;
		String temp = Gene.permute(air.substring(0,2), "A", "a", "2", "1", "1", "0");
                if (temp.equals("2")) {numtot=numtot+2;};
                if (temp.equals("1")) {numtot=numtot+1;};
		temp = Gene.permute(air.substring(2,4), "A", "a", "2", "1", "1", "0");
                if (temp.equals("2")) {numtot=numtot+2;};
                if (temp.equals("1")) {numtot=numtot+1;};
                                               
                if (numtot>1)  {txt = txt + "air";}; //AAAa, AAaa
                if (numtot==1) {txt = txt + "some air";}; //Aaaa
                if (numtot==0) {txt = txt + "no air";}; //aaaa
			
		// Control + Severe Asthma zone.
		cont = true;
                
                int numsea = Gene.counthas(control, 'S');
		if (numsea==4) {txt="normal sea respiration";};
		if (numsea==0) {txt="normal land respiration";};
                if (txt.equals("no air bladders, entirely lacks gills, breathes air")) {txt = "normal land respiration";};
                if (txt.equals("no air bladders, entirely lacks gills, breathes some air")) {txt = "asthmatic land respiration";};
                if (txt.equals("no air bladders, entirely lacks gills, breathes no air")) {txt = "nonviable land-dweller";};
		return txt;
	}

	public static String descfins(String code) {
		String txt = new String("");
		String control  = code.substring(0,2); // 2
		String fingers  = code.substring(2,4); // 2
		String toes  = code.substring(4,6); // 2
		String limbs  = code.substring(6,8); // 2
           	String body  = code.substring(8,10); // 2
                String nictate  = code.substring(10,12); // 2
                String ears  = code.substring(12,14); // 2
                String cheeks  = code.substring(14,16); // 2
                String tines  = code.substring(16,17); // 1
                String size  = code.substring(17,18); // 1
                String biolum  = code.substring(18); // 2
                boolean cont = true;
		boolean skiptodone = false;
                
                // Control Overrides
                if (control.equals("SS")) {txt="normal seadweller fins, webs, and biolum"; skiptodone=true;};
                if (control.equals("ss")) {txt="no fins, webbing, or biolum"; skiptodone=true;};
                
		// Webbing
		cont = true;
		while ((!skiptodone)&&(cont)) {
                    String f = Gene.permute(fingers, "F", "f", "fully ", "partially ", "partially ", "un");
                    String t = Gene.permute(toes, "T", "t", "fully ", "partially ", "partially ", "un");
                    if (f.equals(t)) {txt = txt + f + "webbed fingers and toes, "; cont=false;};
                    if (cont) {txt = txt + f + "webbed fingers and " + t + "webbed toes, ";cont=false;};
                    cont=false;};

		// dorsal fins
		cont = true;
		while ((!skiptodone)&&(cont)) {
                    String l = Gene.permute(limbs, "F", "f", "fully ", "partially ", "partially ", "un");
                    String b = Gene.permute(body,  "F", "f", "fully ", "partially ", "partially ", "un");
                    if (l.equals(b)) {txt = txt + l + "finned limbs and body, "; cont=false;};
                    if (cont) {txt = txt + l + "finned limbs and " + b + "finned body, "; cont=false;};
                    cont=false;};
                                   
		// nictate
		cont = true;
		while ((!skiptodone)&&(cont)) {
			if (cont&&(nictate.equals("NN"))) {txt = txt + "nictating membranes, "; cont=false;};
			if (cont&&(nictate.equals("nn"))) {txt = txt + "no nictating membranes, "; cont=false;};
			if (cont) {txt = txt + "unopenable hard clear protective membranes under the eyelid, "; cont=false;};
			cont=false;};

		// Ear/cheek
		cont = true;
		while ((!skiptodone)&&(cont)) {
			String e = Gene.permute(ears, "E", "e", "full", "partial", "partial", "no");
			String c = Gene.permute(cheeks, "C", "c", "full", "partial", "partial", "no");
                        // quantify ears
                        txt = txt + e + " ears ";
                        if (e.equals("partial")&&!(c.equals("no"))) {txt = txt + "fused with ";};
                        if (e.equals("partial")&&(c.equals("no")))  {txt = txt + "and ";};
                        if (!(e.equals("partial"))) {txt = txt + "and ";};
                        // are there fins?
                        if (c.equals("no")) {txt = txt + "no cheekfins";};
                        if (!(c.equals("no"))) {
                            txt = txt + tines + "-tined ";
                            
                            if (size.equals("0")) {txt=txt + "miniscule ";};
                            if (size.equals("1")) {txt=txt + "tiny ";};
                            if (size.equals("2")) {txt=txt + "small ";};
                            if (size.equals("3")) {txt=txt + "small ";};
                            if (size.equals("7")) {txt=txt + "big ";};
                            if (size.equals("8")) {txt=txt + "very large ";};
                            if (size.equals("9")) {txt=txt + "massive ";};
                            
                            txt = txt + "cheekfins";
                            if (biolum.equals("BB")) {txt = txt + " with voluntary biolum";};
                            if (biolum.equals("Bb")) {txt = txt + " with bloodflow-based biolum";};
                            if (biolum.equals("bB")) {txt = txt + " with constant biolum";};
                            if (biolum.equals("bb")) {txt = txt + " with no biolum";};
                        };
                       
			cont=false;};
                                                                                       
		return txt;
	}

       	public static String deschorns(troll.husk.Horns horns) {
		String txt = new String("");
                // This involves HEAVY usage of description functions found in Horn and Horns
                // check which things match
                boolean matchMount = false;
                if (horns.rgene.mountpoint(horns.rgene.Placegene).equals(horns.lgene.mountpoint(horns.lgene.Placegene))) {matchMount = true;};
                boolean matchDir = false;
                if (horns.rgene.dirpoint(horns.rgene.Dirgene).equals(horns.lgene.dirpoint(horns.lgene.Dirgene))) {matchDir = true;};
                boolean matchCross = false;
                if (horns.rgene.crossection(horns.rgene.Radialgene).equals(horns.lgene.crossection(horns.lgene.Radialgene))) {matchCross = true;};
                boolean matchTip = false;
                if (horns.rgene.tipname(horns.rgene.Tipgene).equals(horns.lgene.tipname(horns.lgene.Tipgene))) {matchTip = true;};
                boolean matchLength = false;
                if (horns.rgene.handspans(horns.rgene.Curlengene).equals(horns.rgene.handspans(horns.rgene.Curlengene))) {matchLength = true;};
                boolean matchCurl = false;
                String lcurl = horns.lgene.curly(horns.lgene.Anggene, horns.lgene.Radialgene, horns.lgene.Curlengene);
                String rcurl = horns.rgene.curly(horns.rgene.Anggene, horns.rgene.Radialgene, horns.rgene.Curlengene);
                if (lcurl.equals(rcurl)) {matchCurl=true;};
                // Count the horns. 
                String numeracyRight = horns.numeracy(horns.form.substring(12,14));
		String numeracyLeft = horns.numeracy(horns.form.substring(14,16));
                // "doubled", "odd", "absent", "stunted" or "normal"
                int numdub = 2; // two by default
                if (numeracyRight.equals("doubled")) {numdub++;}; // double right
                if (numeracyLeft.equals("doubled")) {numdub++;};  // double left                
                boolean labsent = false; boolean rabsent = false;
                if (numeracyRight.equals("absent")) {numdub--; rabsent=true;}; // missing right
                if (numeracyLeft.equals("absent")) {numdub--; labsent=true;};  // missing left
                if (numeracyRight.equals("stunted")) {rabsent=true;}; // nub right
                if (numeracyLeft.equals("stunted")) {labsent=true;};  // nub left
                // Absent and stunted horns don't match anything.
                if (labsent||rabsent) {matchMount=false; matchDir=false; matchCross=false; matchTip=false; matchLength = false; matchCurl = false;};
                // figure the type
		String type = horns.htype(horns.form.substring(16,20));
                
                // declare the basics.               
                txt = numdub + " ";               
                // describe the parts that do match
                if (numdub>0&&matchLength) {txt = txt + horns.rgene.handspans(horns.rgene.Curlengene);};
                if (numdub>0&&matchCurl)   {txt = txt + rcurl;};
                if (!txt.endsWith(" ")) {txt = txt + " ";};
                txt = txt + type;
                if (numdub>0&&matchMount) {txt = txt + ", " + horns.rgene.mountpoint(horns.rgene.Placegene);};
                if (numdub>0&&matchDir)   {txt = txt + ", pointing " + horns.rgene.dirpoint(horns.rgene.Dirgene);};
                if (numdub>0&&matchCross) {txt = txt + ", " + horns.rgene.crossection(horns.rgene.Radialgene) + "-shaped base";};
                if (numdub>0&&matchTip)   {txt = txt + ", " + horns.rgene.tipname(horns.rgene.Tipgene) + "tips";};
                
                // end combined chunk.
                txt = txt + ".";
                if (txt.endsWith(" .")) {txt = txt.replace(" .", ".");};
                
               // If anything doesn't match, 
               if ((!matchDir)||(!matchMount)||(!matchCross)||(!matchTip)||(!matchLength)||(!matchCurl)||(!numeracyLeft.equals("normal"))||(!numeracyRight.equals("normal"))) {
                   txt = txt + "  The left horn is ";
                    // all the unique data about the left horn: dir length, curl, etc
                    if ((!numeracyLeft.equals("normal"))||(!numeracyRight.equals("normal"))) {txt = txt + numeracyLeft + ", "; };
                    if (txt.endsWith(", , ")) {txt = txt.replace(", , ", ", ");};
                    if (!labsent&&!matchLength) {txt = txt + horns.lgene.handspans(horns.lgene.Curlengene) + ", ";};
                    if (txt.endsWith(", , ")) {txt = txt.replace(", , ", ", ");};
                    if (!labsent&&!matchCurl)   {txt = txt + lcurl + ", ";};
                    if (txt.endsWith(", , ")) {txt = txt.replace(", , ", ", ");};
                    if (!labsent&&!matchMount)  {txt = txt + horns.lgene.mountpoint(horns.lgene.Placegene) + ", ";};
                    if (txt.endsWith(", , ")) {txt = txt.replace(", , ", ", ");};
                    if (!labsent&&!matchDir)    {txt = txt + "pointing " + horns.lgene.dirpoint(horns.lgene.Dirgene) + ", ";};
                    if (txt.endsWith(", , ")) {txt = txt.replace(", , ", ", ");};
                    if (!labsent&&!matchCross)  {txt = txt + horns.lgene.crossection(horns.lgene.Radialgene) + "-shaped base, ";};
                    if (txt.endsWith(", , ")) {txt = txt.replace(", , ", ", ");};
                    if (!labsent&&!matchTip)    {txt = txt + horns.lgene.tipname(horns.lgene.Tipgene) + "-tip, ";};
                    txt = txt + ".";
                    txt = txt.replace(", .", ".  ");
                    if (txt.endsWith("The left horn is normal.")) {txt = txt.replace("The left horn is normal.", "");};
                    txt = txt + "The right horn is ";
                    
                    // all the unique data about the right horn
                    if ((!numeracyLeft.equals("normal"))||(!numeracyRight.equals("normal"))) {txt = txt + numeracyRight + ", "; };
                    if (txt.endsWith(", , ")) {txt = txt.replace(", , ", ", ");};
                    if (!rabsent&&!matchLength) {txt = txt + horns.rgene.handspans(horns.rgene.Curlengene) + ", ";};
                    if (txt.endsWith(", , ")) {txt = txt.replace(", , ", ", ");};
                    if (!rabsent&&!matchCurl)   {txt = txt + lcurl + ", ";};
                    if (txt.endsWith(", , ")) {txt = txt.replace(", , ", ", ");};
                    if (!rabsent&&!matchMount)  {txt = txt + horns.rgene.mountpoint(horns.rgene.Placegene) + ", ";};
                    if (txt.endsWith(", , ")) {txt = txt.replace(", , ", ", ");};
                    if (!rabsent&&!matchDir)    {txt = txt + "pointing " + horns.rgene.dirpoint(horns.rgene.Dirgene) + ", ";};
                    if (txt.endsWith(", , ")) {txt = txt.replace(", , ", ", ");};
                    if (!rabsent&&!matchCross)  {txt = txt + horns.rgene.crossection(horns.rgene.Radialgene) + "-shaped base, ";};
                    if (txt.endsWith(", , ")) {txt = txt.replace(", , ", ", ");};
                    if (!rabsent&&!matchTip)    {txt = txt + horns.rgene.tipname(horns.rgene.Tipgene) + "-tip, ";};
                    txt = txt + ".";
                    txt = txt.replace(", .", ".");
                    if (txt.endsWith("The right horn is normal.")) {txt = txt.replace("The right horn is normal.", "");};

               };
                
		return txt;
	}

	public static String descpupate(String code, String feralgene, String tailgene) {
		String txt = new String("");
                // strip all the data out of the pupation gene
		int number = Gene.avgnum(code.substring(0,3));     // 3, numbers
		int limbadult = Gene.avgnum(code.substring(3,5));  // 2, numbers
		int limbmiddle = Gene.avgnum(code.substring(5,7)); // 2, numbers
		int wing = Gene.avgnum(code.substring(7,9));       // 2, numbers
		int tail = Gene.avgnum(code.substring(9,11));      // 2, numbers
		int scar = Gene.avgnum(code.substring(11,13));     // 2, numbers
		int stance = Gene.avgnum(code.substring(13));             // 2, numbers
                // and the control genes out of the other two
                String control = "";
                boolean fer = false;  control = feralgene.substring(0,2);
                if (control.startsWith("F")) {fer = true;};
                boolean tai = false;  control =  tailgene.substring(0,2);
                if (!control.equals("tt")) {tai = true;};
                boolean scars = true;
                if (scar<=limbmiddle) {scars=false;};
                // and also the weird eye shit
                boolean oddeye = false; boolean grubeye=false;  boolean strayplural=false;
                String eyecon =  feralgene.substring(14,16); // 2char = (NSM)+(NSM)
                String wheye =   feralgene.substring(16,18); // 2char = (LRGNnFBT) + (LRGNn)
                if (!eyecon.equals("NN")) {oddeye=true;};
                if (wheye.startsWith("N")||wheye.endsWith("N")) {oddeye=false;};
                if (oddeye) {if (wheye.startsWith("G")||wheye.endsWith("G"))  {grubeye=true;};};
                if (oddeye) {if (eyecon.startsWith("M")||eyecon.endsWith("M")){strayplural=true;};};

                // flags are set
                
		boolean cont = true;
		boolean skiptodone = false;
                

                int cur = 0;
		cont = true;
                String temp = "";
		while ((!skiptodone)&&(cont)) {
                    temp = cur + ": ";
                    if (cur==stance)      {temp = temp + "becomes bipedal, ";};
                    if (cur==limbadult)   {temp = temp + "limbs mature, ";};
                    if (cur==limbmiddle&&scars)  {temp = temp + "middle limbs to grubscars, ";};
                    if (cur==limbmiddle&&!scars) {temp = temp + "lose middle limbs, ";};
                    if (cur==limbmiddle) {
                        if (oddeye&&grubeye) {
                            temp = temp + "stray ";
                            if (!strayplural) {temp = temp + "eye disappears, ";};
                            if (strayplural)  {temp = temp + "eyes disappear, ";};
                            };};
                    if (cur==wing&&fer)   {temp = temp + "gain wings, ";};
                    if (cur==tail&&tai)   {temp = temp + "gain tail, ";};
                    if (cur==scar&&scars) {temp = temp + "lose grubscars, ";};
                    // if anything happened this pupation, add it to the list.
                    if (temp.length()>3) {txt = txt + temp;};
                    if (temp.equals("0: ")) {
                        txt = txt + "hatch as grub, ";
                        if (oddeye&&grubeye) {
                            // GRUBEYE SEGMENT BEGIN
                            txt = txt.replace("as grub, ", "with ");
                            txt = txt + desceye(eyecon, wheye);
                            txt = txt + ", ";
                            // GRUBEYE SEGMENT END
                            }; // end oddeye
                        }; // end0
                    // increment the counter
                    cur++;                                           
                    if (cur==number+1) {cont=false;};
                };//endwhile
                // Maturity
                    if (number<9)  {txt = txt + "mature ";
                        if (stance>number)  {txt = txt + "non-";};
                        txt = txt + "bipedal form reached.";};
                        if (number>=9) {txt = txt + "and pupations continue indefinitely.";}; 
                // Nevers
                if ((cur<stance)||(cur<limbadult)||(cur<limbmiddle)||(cur<wing)||!fer||(cur<tail)||!tai||cur<scar||!scars) {
                    txt = txt + "  Never ";
                    if (cur<stance)       {txt = txt + "becomes bipedal, ";};
                    if (cur<limbadult)    {txt = txt + "matures limbs, ";};
                    if (cur<limbmiddle)   {txt = txt + "lose middle limbs, ";
                             if (grubeye) {txt = txt + "lose stray eyes, ";};
                             };
                    if (cur<wing||!fer)   {txt = txt + "gain wings, ";};
                    if (cur<tail||!tai)   {txt = txt + "gain tail, ";};
                    if (cur<scar||!scars) {txt = txt + "lose grubscars, ";};
                    }
                txt = txt + ".....";
                txt = txt.replace(", .....", ".");
                txt = txt.replace(".....", ".");
                txt = txt.replace("..", ".");
                        
		return txt;
	}

        public static String desceye(String control, String where) {
            String txt = "";
            boolean oddeye = false; boolean grubeye=false;
            boolean single = false; boolean multi=false;
            if (!control.startsWith("N")&&!control.endsWith("N")) {oddeye=true;};
            if (where.startsWith("N")||where.endsWith("N")) {oddeye=false;};
            if (oddeye) {if (where.startsWith("G")||where.endsWith("G")) {grubeye=true;};};
            if (oddeye) {if (control.startsWith("M")||control.endsWith("M")){multi=true;};};
            if (oddeye) {if (control.startsWith("S")||control.endsWith("S")){single=true;};};
            // number of eyes 
            if (!oddeye) {return "normally placed eyes";}; // escape if normal
            if (oddeye&&single&&!multi) {txt = txt + "a stray eye ";};
            if (oddeye&&single&&multi)  {txt = txt + "a variety of stray eyes ";};
            if (oddeye&&!single&&multi) {txt = txt + "several small eyes ";};
            // where the eyes go
            if (where.equals("LL")||where.equals("LG"))
                {txt = txt + "under the left one";};
            if (where.equals("RR")||where.equals("RG"))
                {txt = txt + "under the right one";};
            if (where.equals("RL")||where.equals("LR"))
                {txt = txt + "under both normal ones";};
            if (where.equals("FH")) {txt = txt + "on the face";};
            if (where.equals("BH")) {txt = txt + "on the back of the head";};
            if (where.equals("TH")) {txt = txt + "on the forehead";};
            if (where.equals("GH")) {txt = txt + "on the head";};
            if (where.equals("Fh")) {txt = txt + "on the palm";};
            if (where.equals("Bh")) {txt = txt + "on the back of the hand";};
            if (where.equals("Th")) {txt = txt + "on the fingertips";};
            if (where.equals("Gh")) {txt = txt + "at extremity tips";};
            if (where.equals("FC")) {txt = txt + "on their chest";};
            if (where.equals("BC")) {txt = txt + "on their back";};
            if (where.equals("TC")) {txt = txt + "on the spine";};
            if (where.equals("GC")) {txt = txt + "on the torso";};           
            if (where.equals("FL")||where.equals("FR")) {txt = txt + "on the arms";};
            if (where.equals("BL")||where.equals("BR")) {txt = txt + "on the legs";};
            if (where.equals("TL")||where.equals("TR")) {txt = txt + "on the tail (if present)";};
            if (where.equals("GL")||where.equals("GR")) {txt = txt + "on the limbs";};
            if (where.equals("FG")) {txt = txt + "on their front";};
            if (where.equals("BG")) {txt = txt + "on their back";};
            if (where.equals("TG")) {txt = txt + "towards the tail end";};
            if (where.equals("GG")) {txt = "normal eyes that disappear on adult pupation";};
            // add grubnote
            if (oddeye&&grubeye&&!where.equals("GG")) {txt = txt + " as a grub";};
            return txt;
        }
        
	public static String descferal(String pupagene, String feralgene, String tailgene) {
		String txt = new String("");
                String control = "";
                // strip all the data out of the pupation gene
		int pupanumber = Gene.avgnum(pupagene.substring(0,3));     // 3, numbers
		int pupalimbadult = Gene.avgnum(pupagene.substring(3,5));  // 2, numbers
		int pupalimbmiddle = Gene.avgnum(pupagene.substring(5,7)); // 2, numbers
		int pupawing = Gene.avgnum(pupagene.substring(7,9));       // 2, numbers
		int pupatail = Gene.avgnum(pupagene.substring(9,11));      // 2, numbers
		int pupascar = Gene.avgnum(pupagene.substring(11,13));     // 2, numbers
		int pupastance = Gene.avgnum(pupagene.substring(13));             // 2, numbers
                boolean grubscars = true; boolean pwings = false; boolean ptail = false; boolean pstance = false;
                if (pupascar<=pupalimbmiddle) {grubscars=false;};
                if (pupawing<=pupanumber)     {pwings=true;};
                if (pupatail<=pupanumber)     {ptail=true;};
                if (pupastance<=pupanumber)   {pstance=true;};
                // and feral gene
                boolean feral = false; boolean fer1 = false; boolean fer2 = false; 
                control = feralgene.substring(0,2); // 2char = Ff
                if (control.startsWith("F")) {fer1 = true;};
                if (control.endsWith("F"))   {fer2 = true;};
                if (fer1||fer2)                    {feral  = true;};
                String ferstance = feralgene.substring(2,4); // 2char = DdPp
                String ferwing = feralgene.substring(4,6);   // 2char = BbAaSsDdFfEeTt
                String ferpaw = feralgene.substring(6,8);    // 2char = Pp
                int ferclaw = Gene.avgnum(feralgene.substring(8,10));  // 2char = ##
                String ferskin = feralgene.substring(10,12); // 2char = FCB
                String ferjaw = feralgene.substring(12,14);  // 2char = N>F>B>T>S>R>G>K
                boolean oddeye = false; boolean grubeye=false;  boolean strayplural=false;
                String eyecon =  feralgene.substring(14,16); // 2char = (NSM)+(NSM)
                String wheye =   feralgene.substring(16,18); // 2char = (LRGNnFBT) + (LRGNn)
                if (!eyecon.equals("NN")) {oddeye=true;};
                if (wheye.startsWith("N")||wheye.endsWith("N")) {oddeye=false;};
                if (oddeye) {if (wheye.startsWith("G")||wheye.endsWith("G"))  {grubeye=true;};};
                if (oddeye) {if (eyecon.startsWith("M")||eyecon.endsWith("M")){strayplural=true;};};
                // and tail gene
                boolean tail = false; 
                String tailcon =  tailgene.substring(0,2); // 2char, TT > Tt > tT > tt
                if (!tailcon.equals("tt")) {tail=true;};
                int tlen = Gene.avgnum(tailgene.substring(2, 3)); // 1char num
                int twid = Gene.avgnum(tailgene.substring(3, 4)); // 1char num
                // String tailtip = tailgene.substring(4,6); // 2char Aa (unfinished)
               
                // flags are set, ready the actual description process
                
                txt = desceye(eyecon, wheye) + ", ";
                if (txt.equals("normally placed eyes, ")) {txt = "";};
                
                // if no tail : no tail desc.  But, if tail ...
                if (tail&&ptail) {
                    txt = txt + "tail is " + tlen;
                    if (tailcon.equals("TT")) {txt = txt + " forearm-spans";};
                    if (tailcon.equals("Tt")) {txt = txt + " hand-spans";};
                    if (tailcon.equals("tT")) {txt = txt + " inches";};
                    txt = txt + " long, and " + twid + " fingerwidths wide, ";
                    };
                // if no feral, no feral desc.  But, if feral, ...
                if (feral) {
                    // digitigrade vs plantigrade
                    if (fer1&&fer2) {
                        boolean digitigrade = false;
                        boolean plantigrade = false;
                        if (Gene.canhas(ferwing, 'D')||Gene.canhas(ferwing, 'd')) {digitigrade=true;};
                        if (Gene.canhas(ferwing, 'P')||Gene.canhas(ferwing, 'p')) {plantigrade=true;};
                        if (digitigrade&&!plantigrade) {txt = txt + "digitigrade stance, ";};
                        // if (plantigrade&&!digitigrade) {txt = txt + "plantigrade stance, ";};
                        if (plantigrade&&digitigrade)  {txt = txt + "mixed planti/digitigrade stance, ";};
                        };
                    // if (!fer1||!fer2) {txt = txt + "plantigrade stance, ";};
                    // mani/pedi
                    if (ferpaw.equals("PP")) {txt = txt + "with large paws, ";};
                    if (ferclaw<3)           {txt = txt + "petite claws, ";};
                    if (ferclaw>5&&ferclaw<8) {txt = txt + "large claws, ";};
                    if (ferclaw>7)        {txt = txt + "monstrous claws, ";};
                    // wings
                    if (fer1&&pwings) {
                        String type1 = wingtype(ferwing.substring(0,1));
                        String type2 = wingtype(ferwing.substring(1,2));
                        if (type1.toLowerCase().equals(type2.toLowerCase()))  {txt = txt + type1 + " wings, ";};
                        if (!type1.toLowerCase().equals(type2.toLowerCase())) {txt = txt + type1 + "/" + type2 + " wings, ";};
                        };
                    // and the ones that have Strong(fer1/both) and Weak(just fer2) versions : skin and jaw
                    if (fer1) { // the strong version
                        if (!skincovering(ferskin).equals("bare")) {txt = txt + skincovering(ferskin) + " skin, ";};
                        if (!jawtype(ferjaw).equals("normal")) {
                            if (jawtype(ferjaw).equals("F")) {txt = txt + "massive fangs, ";};
                            if (jawtype(ferjaw).equals("B")) {txt = txt + "barracuda jaw, ";};
                            if (jawtype(ferjaw).equals("T")) {txt = txt + "tusks, ";};
                            if (jawtype(ferjaw).equals("S")) {txt = txt + "fierce shark teeth, ";};
                            if (jawtype(ferjaw).equals("R")) {txt = txt + "rodent incisors, ";};
                            if (jawtype(ferjaw).equals("G")) {txt = txt + "tongue barbs, ";};
                            if (jawtype(ferjaw).equals("K")) {txt = txt + "a beaked mouth, ";};
                            };
                    }; // end strong version
                    if (fer2&&!fer1) { // the weak version 
                        if (!skincovering(ferskin).equals("bare")) {txt = txt + "partially " + skincovering(ferskin) + " skin, ";};
                        if (!jawtype(ferjaw).equals("normal")) {
                            if (jawtype(ferjaw).equals("F")) {txt = txt + "fangs, ";};
                            if (jawtype(ferjaw).equals("B")) {txt = txt + "many pointed teeth, ";};
                            if (jawtype(ferjaw).equals("T")) {txt = txt + "small tusks, ";};
                            if (jawtype(ferjaw).equals("S")) {txt = txt + "sawlike teeth, ";};
                            if (jawtype(ferjaw).equals("R")) {txt = txt + "two large front teeth, ";};
                            if (jawtype(ferjaw).equals("G")) {txt = txt + "an abrasive tongue, ";};
                            if (jawtype(ferjaw).equals("K")) {txt = txt + "fused teeth-ridges, ";};                            
                            };// end jawtype
                        }; // end weak version
                }; // end feralblock
            // and something that doesn't depend on feral status at all.
            // if (grubscars) {txt = txt + "and grubscars";};
            if (txt.equals("")) {txt = "nonferal";};
            return txt;
	};

        private static String jawtype(String in) {
            String t = "normal";
            // Listed in reverse order of dominance, N>F>B>T>S>R>G>K
            if (Gene.canhas(in, 'K')) {t="K";};
            if (Gene.canhas(in, 'G')) {t="G";};
            if (Gene.canhas(in, 'R')) {t="R";};
            if (Gene.canhas(in, 'S')) {t="S";};
            if (Gene.canhas(in, 'T')) {t="T";};
            if (Gene.canhas(in, 'B')) {t="B";};
            if (Gene.canhas(in, 'F')) {t="F";};
            if (Gene.canhas(in, 'N')) {t="normal";};
            return t;
        };       
        
        private static String skincovering(String in) {
            String t = "bare";
            if (in.equals("FF")) {t="furred";};
            if (in.equals("FC")) {t="scaled";};
            if (in.equals("CF")) {t="scaled";};
            if (in.equals("FB")) {t="feathered";};
            if (in.equals("BF")) {t="feathered";};
            if (in.equals("CC")) {t="carapaced";};
            if (in.equals("CB")) {t="platelike calloused";};
            if (in.equals("BC")) {t="platelike calloused";};
            if (in.equals("BB")) {t="bare";};
            return t;
        };

        private static String wingtype(String in) {
            String t = "strange";
            if (in.equals("B")) {t="Butterfly";};
            if (in.equals("b")) {t="butterfly";};
            if (in.equals("A")) {t="Bird";};
            if (in.equals("a")) {t="bird";};
            if (in.equals("S")) {t="Bat";};
            if (in.equals("s")) {t="bat";};
            if (in.equals("D")) {t="Dragonfly";};
            if (in.equals("d")) {t="dragonfly";};
            if (in.equals("F")) {t="Gossamer Finlike";};
            if (in.equals("f")) {t="gossamer finlike";};
            if (in.equals("E")) {t="Beetle";};
            if (in.equals("e")) {t="beetle";};
            if (in.equals("T")) {t="Tentacle";};
            if (in.equals("t")) {t="tentacle";};           
            return t;
        };

        private static String descgender(String infert, String g) {
            String t = "";
            String sex = infert.substring(0,2);
            // What bits do they have
            boolean nook = true; boolean bulge = true;
            if (sex.startsWith("XY")) {nook=false;};
            if (sex.startsWith("XX")) {bulge=false;};
            // Do they work? 
            boolean nf = Gene.isfertfem(infert);
            boolean bf = Gene.isfertmasc(infert);
            // Is the person a mammal or visibly troll-esque
            boolean mammal = false;
            if ((sex.startsWith("X"))||sex.startsWith("W")) {mammal=true;};
            // Is their natively-passing sex opposite to their gender
            boolean trans = false;
            if ((sex.endsWith("Y"))&&(g.equals("F"))) {trans=true;};
            if ((sex.endsWith("X"))&&(g.equals("M"))) {trans=true;};
            // are they fertile
            boolean fertile = true; boolean livebirth = false;
            String puberty   = infert.substring(2,3);
            if (puberty.startsWith("0")) {fertile=false;}; // No Neoteny
            String fertility = infert.substring(3,4);
            if (fertility.startsWith("0")) {fertile=false;}; // No infertility
            String live = infert.substring(4,5); // Live or Egglaying
            if (live.startsWith("L")) {livebirth=true;};
            String litter = infert.substring(5,9);
            if (litter.startsWith("0000")) {fertile=false;}; // No infertility
            
            // prepare the text string
            // fertility
            if (fertile&&(Gene.digsum(puberty)+Gene.digsum(fertility)+Gene.digsum(litter)>5)) {t = "highly fertile ";};
            if (fertile&&(Gene.digsum(puberty)+Gene.digsum(fertility)+Gene.digsum(litter)==3)) {t = "barely-fertile ";};
            if (!fertile) {t = "infertile ";};
            // reproductive and anatomical type
            if (livebirth)  {t = t + "live-birth ";};
            if (!livebirth) {t = t + "egg-laying ";};           
            if (mammal)  {t = t + "mammal ";};
            if (!mammal) {t = t + "troll ";};
            // trans gender
            if (trans) {t = t + "trans-";};
            if (g.equals("F")) {t = t + "woman";};
            if (g.equals("M")) {t = t + "man";};
            if (g.equals("N")) {t = t + "person";};
            if (g.equals("?")) {t = t + "person";};
            // quirks 
            t = t + ", with ";
            if (puberty.startsWith("0")) {t = t + "neotany, ";};
            t = t + puberty + " puberties, ";
            // equipment
            if (nook) {t = t + "a nook, ";};
            if ((bulge)&&(mammal)) {t = t + "a phallus, ";};
            if ((bulge)&&(!mammal)) {t = t + "a bulge, ";};
            // functionality
            t = t + "who produces ";
            if (nf&&!bf) {t = t + "only ";};
            if (nf)      {t = t + "eggs";};
            if (nf&&bf)  {t = t + " and ";};
            if (bf&&!nf) {t = t + "only ";};
            if (bf)      {t = t + "semen";};
            if (!nf&&!bf) {t = t + "no gametes";};
            
            return t;
        };

        private static String descpigment(troll.husk.Body body, troll.husk.Horns horns, troll.husk.Eye eyes, troll.fluff.Stats stats) {
            String var = "";  // use body.blood, body.hue, or body.caste if needed
            // actual pigment gene
            // -- Options: Aa (albino colorless), Ll (leucistic white), Mm (melanism black) Gg (grey: GG = LM or ML)
            // --(contd) Ee (Erythrism red/orange), Xx (Xanthism yellow / lack of non-yellow), Bb (axanthism, lack of yellow)
            // --(contd) Cc (caste color) Ii (inverted caste color) Tt (earthtone)
            // -- lowercase = 1 pt, upper = 2 pt.  you need 3 points for a trait to express.
            String streak = body.pigmentgene.substring(0,2);
            // 2char: Hair Streaking - Pp (plain) Kk (streaking)
            String hair = body.pigmentgene.substring(2,6);
            // 4char: Hair - Aa Ll Mm Gg Ee Xx Bb Cc Ii Tt  (trolls MMMM, hum M/E/T, fae M/E/T/any)
            String blood = body.pigmentgene.substring(6,8);
            // 2char: blood - Aa Ll Mm Gg Ee Xx Bb Cc Ii Tt (trolls Cc/Ii, hum EE, fae EE/BB/any)
            boolean inverted = false; if (Gene.counthas(blood, 'I', 'i')>0) {inverted=true;};
            boolean chroma = false;   if (Gene.counthas(blood, 'C', 'c')>0) {chroma=true;};
            String bloodcol = "";
            String skinpig = body.pigmentgene.substring(8,12);
            // 4char: skin - Aa Ll Mm Gg Ee Xx Bb Cc Ii Tt
            // -- if multiple things express, either blend them or check skin patterning + second character of feral control gene
            // -- vitiligo and birthmarks come from here
            String accent = body.pigmentgene.substring(12,14);
            // 2char: lips / accent color : Aa Ll Mm Gg Ee Xx Bb Cc Ii Tt (trolls MC, hum TC, fae TE)
            
            // skin Stuff
            String skinpattern = body.skingene.substring(0,4); 
            // 4char - Rr(rainbowdrinker, full skin) Pp(psychic eye glow) Nn Ee (none)
            // sea varieties - Ss(larger spots) Tt(stripe) Bb(blotches) Ff(tiny freckle dots)
            String skinfreckle = body.skingene.substring(10,11); // FF Lots, Ff some, fF less, ff none.
            String skinthick = body.skingene.substring(11,12); // number 0-9, 3 = norm
            
            // syndrome Stuff
            String undeath = body.syndromegene.substring(0,2);
            // need 2 letters of a gene for it to express usually - but Undying and Weak Spark stack with everything
            // 2char: undeath - N(nothing), V(vampire/Drinker), G(ghoul), Z(mindless zombie), U(undying), W(weak spark)
            String powers = body.syndromegene.substring(2,8);           
            // 6char: supernatural - v(voodoo), e(eldritch), m(magic), n(null)
            // ------ p(physical psychic), o(oracular psychic), q(mental psychic)
            
            // eye stuff
            // placeholder : include this AFTER eye gets a full redo.  See husk.Eye

            return var;
            };
        
        // blank entry
	public static String blank(String code) {
		String txt = new String("");
		boolean cont = true;
		boolean skiptodone = false;

		// new segment.
		cont = true;
		while ((!skiptodone)&&(cont)) {
			//segment 1
			cont=false;};

		// new segment.
		cont = true;
		while ((!skiptodone)&&(cont)) {
			//segment 2
			cont=false;};

		return txt;
	}

}
