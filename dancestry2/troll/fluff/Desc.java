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

        // If you want to feed more data into the function,
        // remember to update both here and the place
        // in troll.Troll() where info is fed over here
        
	public Desc(troll.husk.Body body, troll.husk.Horns horns, troll.husk.Eye eyes, troll.fluff.Stats stats) {
            // Just the body section
            build = descbuild(body.buildgene);
            respirate = descrespirate(body.respiratorygene);
            fins = descfins(body.fingene);
            pupation = descpupate(body.pupation, body.feralgene, body.tailgene);
            
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
		int scar = Gene.avgnum(code.substring(11,13));    // 2, numbers
		int stance = Gene.avgnum(code.substring(13));             // 2, numbers
                // and the control genes out of the other two
                String control = "";
                boolean fer = false;  control = feralgene.substring(0,2);
                if (control.startsWith("F")) {fer = true;};
                boolean tai = false;  control =  tailgene.substring(0,2);
                if (!control.equals("tt")) {tai = true;};
                boolean scars = true;
                if (scar<=limbmiddle) {scars=false;};
                
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
                    if (cur==wing&&fer)   {temp = temp + "gain wings, ";};
                    if (cur==tail&&tai)   {temp = temp + "gain tail, ";};
                    if (cur==scar&&scars) {temp = temp + "lose grubscars, ";};
                    // if anything happened this pupation, add it to the list.
                    if (temp.length()>3) {txt = txt + temp;};
                    if (temp.equals("0: ")) {txt = txt + "hatch as grub, ";};
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
                    if (cur<limbmiddle)   {txt = txt + "lose middle limbs, ";};
                    if (cur<wing||!fer)   {txt = txt + "gain wings, ";};
                    if (cur<tail||!tai)   {txt = txt + "gain tail, ";};
                    if (cur<scar||!scars) {txt = txt + "lose grubscars, ";};
                    }
                txt = txt + ".....";
                txt = txt.replace(", .....", ".");
                txt = txt.replace(".....", ".");
                        
		return txt;
	}



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
