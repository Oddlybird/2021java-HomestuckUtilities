package troll.fluff;
import troll.husk.*;
import java.awt.Color;
@SuppressWarnings("unused")

public class Desc {
        String build = "";
        String respirate = "";
        String fins = "";
    
	public Desc(troll.husk.Body body) {
            build = build(body.buildgene);
            respirate = respirate(body.respiratorygene);
            fins = fins(body.fingene);
        }       
        	
	public static String build(String code) {
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
	
	public static String respirate(String code) {
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
		cont = true;
		while ((!skiptodone)&&(cont)) {
                        txt = txt + Gene.permute(bladders, "B", "b", "many air bladders, ", "several air bladders, ", "one air bladder, ", "no air bladders, ");
                        cont=false;
                        };

		// new segment.  gills.
		cont = true;
		while ((!skiptodone)&&(cont)) {
			String gill1 = "";
			gill1 = Gene.permute(gilleyes.substring(0,2), "G", "g", "full ", "partial ", "partial ", "no ");
			gill1 = gill1 + Gene.permute(gilleyes.substring(2,4), "i", "e", "", "", "", "external ");
			
			String gill2 = "";
			gill2 = Gene.permute(gillneck.substring(0,2), "G", "g", "full ", "partial ", "partial ", "no ");
			gill2 = gill2 + Gene.permute(gillneck.substring(2,4), "i", "e", "", "", "", "external ");

			String gill3 = "";
			gill3 = Gene.permute(gillribs.substring(0,2), "G", "g", "full ", "partial ", "partial ", "no ");
			gill3 = gill3 + Gene.permute(gillribs.substring(2,4), "i", "e", "", "", "", "external ");
			
			if ((gill1.startsWith("no"))&&(gill2.startsWith("no"))&&(gill3.startsWith("no"))) {
				txt = txt + "entirely lacks gills, "; cont=false;}
			
			if (cont==true) {txt = txt + gill1 + "eye gills, ";};
			if (cont==true) {txt = txt + gill2 + "neck gills, ";};
			if (cont==true) {txt = txt + gill3 + "rib gills, ";};
			cont=false;
			};	
			
		// new segment.  Breathing.
		cont = true;
		while ((!skiptodone)&&(cont)) {
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
			cont=false;
			};			
			
		// Control + Severe Asthma zone.
		cont = true;
                int sumsea = 0;
                if (control.substring(0,0).equals("S")) {sumsea=sumsea+1;};
                if (control.substring(1,1).equals("S")) {sumsea=sumsea+1;};
                if (control.substring(2,2).equals("S")) {sumsea=sumsea+1;};
                if (control.substring(3,3).equals("S")) {sumsea=sumsea+1;};
                int sumair = 0;
                if (air.substring(0,0).equals("S")) {sumair=sumair+1;};
                if (air.substring(1,1).equals("S")) {sumair=sumair+1;};
                if (air.substring(2,2).equals("S")) {sumair=sumair+1;};
                if (air.substring(3,3).equals("S")) {sumair=sumair+1;};

		if (sumsea==4) {txt="normal sea respiration";};
		if (sumsea==0) {txt="normal land respiration";};
                
		return txt;
	}

	public static String fins(String code) {
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
