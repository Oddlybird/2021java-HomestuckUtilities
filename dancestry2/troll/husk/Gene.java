package troll.husk;
import java.util.Arrays;
import java.util.Random;

import troll.Troll;
import troll.fluff.*;
@SuppressWarnings("unused")

// This is basically just a collection of useful subroutines.

public class Gene {
public static String[] spectrum = {"RR", "Rr", "rr", "Rg", "RG", "Gr", "rg", "GG", "Gg", "gg", "Gb",
                     "GB", "Bg", "gb", "BB", "Bb", "bb", "Br", "RB", "Rb", "rb"};
public static String[] castes = {"maroon", "bronze", "gold", "lime", "crimson", "olive", "jade", 
                "teal", "cerulean", "blue", "indigo", "violet", "tyrian"};
public static String[] fae = {"fae", "unseleighe", "seleighe", "faewild", "pixie", "hobb", "dryad",
                "faevamp", "faeghoul", "kelpie", "selkie", "redcap", "sidhe", "ogre",
                "pookah", "frostgiant", "rusalka", "banshee", "elemental", "locus", "satyr" };
public static String[] bluefae = {"frostgiant", "sidhe", "pookah", "sidhe"};
public static String[] human = {"human"};
public static String[] carapacian = {"carapacian", "pawn", "rook", "bishop", "knight", "king", "queen"};
// New species/castes should be added to Blood.condensecaste, Stats(), and Troll.body.*.


	public Gene() {
            
		// TODO Auto-generated constructor stub
	}


	public static String Blend(String a, String b) {		
		// Make sure the first string is the shortest.
		if (a.length() > b.length()) {
			String temp = new String("");
			temp = a;
			a = b;
			b = temp;
			// This means that excess data will get chopped off.
		};

		// If you want to enable different rates of transmission
		// supply ar and br as parameters.  Skipping it for now.
		int ar = 9;  // rate of transmission a
		int br = 9;  // rate b
		Random rand = new Random();
		int art = 0;
		int brt = 0; // temporary values used inside the loop
		
		// Set up the char arrays we need
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		char[] C = new char[A.length];  // since A is the shortest...
		
		// Establish loop
		for (int i = 0; i<a.length();i++) {
			art = rand.nextInt(ar); // initialize temporary rates
			brt = rand.nextInt(br); // to value between 0 and rate
			
			// Set the C[i] to A by default, but B if B's rate is higher.
			C[i] = A[i];
			if (brt>art) {C[i] = B[i];};
			
			// If both values are numeric;
			if ((Character.isDigit(A[i]))&&(Character.isDigit(B[i]))) {
				// Useful methods : 
				// 					Character.getNumericValue(char)
				// 					String.valueOf(char)
				int alpha = Character.getNumericValue(A[i]);
				int beta  = Character.getNumericValue(B[i]);
				double gamma = 0;
				// average them (with some variation)
				gamma = (alpha + beta)/2;
				if (rand.nextBoolean()) {gamma = (gamma + alpha)/2;}; 
				if (rand.nextBoolean()) {gamma = (gamma + beta)/2;};
				if (rand.nextBoolean()) {gamma = (gamma + alpha)/2;}; 
				if (rand.nextBoolean()) {gamma = (gamma + beta)/2;};
				gamma = Math.round(gamma);
//				// Add some random variance
				int delta = rand.nextInt(3) - 1; // number between -1 and +1
				gamma = gamma + delta;
//				// restrict to single digit
				C[i] = Character.forDigit((int)gamma,  10);  // return gamma in base 10 as a char
			}; // end numeric

		}; // end for loop
		
		// convert char array to String
		String c = new String (C); 
		// return string
		return c;
	};
	
	public static String mutiBlend(String a, String b, String m) {
		// only continue until any argument runs out of length.
		int lengthofloop = a.length();
		if (b.length()<lengthofloop) {lengthofloop=b.length();};
		if (m.length()<lengthofloop) {lengthofloop=m.length();};
		// This means that excess data will get chopped off.

		int ar = 50;  // rate of transmission a
		int br = 50;  // rate b
		int mr = 20;  // rate c, the mutation source
		Random rand = new Random();
		int art = 0;
		int brt = 0; // temporary values used inside the loop
		int mrt = 0;
		
		// Set up the char arrays we need
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		char[] M = m.toCharArray();
		char[] C = new char[lengthofloop];
		
		// Establish loop
		for (int i = 0; i<lengthofloop;i++) {
			art = rand.nextInt(ar); // initialize temporary rates
			brt = rand.nextInt(br); // to value between 0 and rate
			mrt = rand.nextInt(mr); // this one is v unlikely to win
			
			// Set the C[i] to A by default, but B if B's rate is higher.
			C[i] = A[i];
			if (brt>art) {C[i] = B[i];};
			if ((mrt>art)&&(mrt>brt)) {C[i] = M[i];}; // and mutate if that is highest
			// If both values are numeric;
			if ((Character.isDigit(A[i]))&&(Character.isDigit(B[i]))) {
				// Useful methods : 
				// 					Character.getNumericValue(char)
				// 					String.valueOf(char)
				int alpha = Character.getNumericValue(A[i]);
				int beta  = Character.getNumericValue(B[i]);
				int delta  = Character.getNumericValue(M[i]);
				double gamma = 0;
				// average them
				gamma = (alpha + beta)/2;
				if (rand.nextBoolean()) {gamma = (gamma + delta)/2;};
				if (rand.nextBoolean()) {gamma = (gamma + alpha)/2;}; 
				if (rand.nextBoolean()) {gamma = (gamma + beta)/2;};
				if (rand.nextBoolean()) {gamma = (gamma + delta)/2;};
				if (rand.nextBoolean()) {gamma = (gamma + alpha)/2;}; 
				if (rand.nextBoolean()) {gamma = (gamma + beta)/2;};
				gamma = Math.round(gamma);
//				// restrict to single digit
				C[i] = Character.forDigit((int)gamma,  10);  // return gamma in base 10 as a char
			}; // end numeric
		}; // end for loop

		// convert char array to String
		String c = new String (C); 
		// return string
		return c;
	};

	public static String mutiBlend2(String a, String b, String m, int ar, int br, int mr) {		
		// only continue until any argument runs out of length.
		int lengthofloop = a.length();
		if (b.length()<lengthofloop) {lengthofloop=b.length();};
		if (m.length()<lengthofloop) {lengthofloop=m.length();};
		// This means that excess data will get chopped off.

		Random rand = new Random();
		int art = 0;
		int brt = 0; // temporary values used inside the loop
		int mrt = 0;
		
		// Set up the char arrays we need
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		char[] M = m.toCharArray();
		char[] C = new char[lengthofloop];
		
		// Establish loop
		for (int i = 0; i<lengthofloop;i++) {
			art = rand.nextInt(ar); // initialize temporary rates
			brt = rand.nextInt(br); // to value between 0 and rate
			mrt = rand.nextInt(mr); // this one is v unlikely to win
			
			// Set the C[i] to A by default, but B if B's rate is higher.
			C[i] = A[i];
			if (brt>art) {C[i] = B[i];};
			if ((mrt>art)&&(mrt>brt)) {C[i] = M[i];}; // and mutate if that is highest
			// If both values are numeric;
			if ((Character.isDigit(A[i]))&&(Character.isDigit(B[i]))) {
				// Useful methods : 
				// 					Character.getNumericValue(char)
				// 					String.valueOf(char)
				int alpha = Character.getNumericValue(A[i]);
				int beta  = Character.getNumericValue(B[i]);
				int delta  = Character.getNumericValue(M[i]);
				double gamma = 0;
				// average them
				gamma = (alpha + beta)/2;
				if (rand.nextBoolean()) {gamma = (gamma + delta)/2;};
				if (rand.nextBoolean()) {gamma = (gamma + alpha)/2;}; 
				if (rand.nextBoolean()) {gamma = (gamma + beta)/2;};
				if (rand.nextBoolean()) {gamma = (gamma + delta)/2;};
				if (rand.nextBoolean()) {gamma = (gamma + alpha)/2;}; 
				if (rand.nextBoolean()) {gamma = (gamma + beta)/2;};
				gamma = Math.round(gamma);
//				// restrict to single digit
				C[i] = Character.forDigit((int)gamma,  10);  // return gamma in base 10 as a char
			}; // end numeric
		}; // end for loop
		
		// convert char array to String
		String c = new String (C); 
		// return string
		return c;
	};

	public static Troll fuck(Troll a, Troll b) {
		// c is to be used as the mutation source
		// c is ALSO the place where final versions will be stored.
		Troll c = new Troll("rand");
		// name and trolltags are random and fine
                
                // do blood stuff
                Blood A = new Blood(a.body.blood); A.caste=a.body.caste;
                Blood B = new Blood(b.body.blood); B.caste=b.body.caste;
                Blood C = new Blood(c.body.blood); C.caste=c.body.caste;
		C = bloodfuck(A, B, C);
                // assign caste to keep track of heritage
                // always concatenate c first, so the parents' castes aren't misinterpreted as theirs
                c.body.caste=C.condensecaste(c.body.caste + b.body.caste + a.body.caste);
                
		c.stats = new Stats(c.body.caste);  // initialize caste default
		c.stats = statfuck(a.stats, b.stats, c.stats, c.body.blood);
		c.body = new Body(c.body.blood, c.body.caste); // initialize caste default
		c.body = bodyfuck(a.body, a.body.blood, b.body, b.body.blood, c.body, c.body.blood);
		c.horns = new Horns(c.body.blood);
		c.horns = hornfuck(a.horns, b.horns, c.horns, c.body.blood);
		c.eyes = new Eye(c.body.blood);
		c.eyes = eyefuck(a.eyes, b.eyes, c.eyes, c.body.blood);
		
		return c;
	}
	
	// fucking subroutines
	public static Blood bloodfuck(Blood a, Blood b, Blood c) {
	 	Random rand = new Random();
		char[] dona = a.code.toCharArray();
		char[] donb = b.code.toCharArray();
		char[] donc = c.code.toCharArray();
		String txt = "";
		// take one letter from each parent
		txt =  txt + Character.toString(dona[rand.nextInt(dona.length)]);
		txt =  txt + Character.toString(donb[rand.nextInt(donb.length)]);
		// and half the time, one letter from the mutation source
		if (rand.nextBoolean()) {txt = txt + Character.toString(donc[rand.nextInt(donc.length)]);};
		// sort it
		txt = c.bloodsort(txt);
		// fill in the blanks
		c.code = txt;
		c.caste = c.castefromcode(txt);
		c.hue = (int) Math.round(c.huefromCode(txt));
		c.color = Desc.colortostring(c.colorfromcode(txt));
		
		return c;
	}
	
	public static Stats statfuck(Stats a, Stats b, Stats c, String inblood) {
		Random rand = new Random();
                
                // Give these a single statfuck, because +/- 1 is a good amount for something with a max of 6.
		c.clout       = statfucker(a.clout, b.clout, c.clout);
		c.grit        = statfucker(a.grit, b.grit, c.grit);
		c.alacrity    = statfucker(a.alacrity, b.alacrity, c.alacrity);
		c.hunch       = statfucker(a.hunch, b.hunch, c.hunch);
		c.acumen      = statfucker(a.acumen, b.acumen, c.acumen);
		c.resolve     = statfucker(a.resolve, b.resolve, c.resolve);
		c.moxie       = statfucker(a.moxie, b.moxie, c.moxie);
		c.psyche      = statfucker(a.psyche, b.psyche, c.psyche);
		// statfuck these ones twice, so that they each get up to +/- 2, because their max is 10
		c.faith       = statfucker(a.faith, b.faith, c.faith);
		c.faith       = statfucker(a.faith, b.faith, c.faith);
		c.order       = statfucker(a.order, b.order, c.order);
		c.order       = statfucker(a.order, b.order, c.order);
		c.entropy     = statfucker(a.entropy, b.entropy, c.entropy);
		c.entropy     = statfucker(a.entropy, b.entropy, c.entropy);
		c.connection  = statfucker(a.connection, b.connection, c.connection);
		c.connection  = statfucker(a.connection, b.connection, c.connection);
		c.self        = statfucker(a.self, b.self, c.self);
		c.self        = statfucker(a.self, b.self, c.self);
		c.opportunity = statfucker(a.opportunity, b.opportunity, c.opportunity);
		c.opportunity = statfucker(a.opportunity, b.opportunity, c.opportunity);
		
		c.exploit = c.exploit();
		c.move = c.move();
		c.know = c.know();
		c.manip = c.manip();
		c.create = c.create();
		c.destroy = c.destroy();
		
                // pick a small number.  Trolls with a B/b get -1 psyche, trolls without an R/r get -1 psyche.
		int z = rand.nextInt(3);
		if ((z!=1)&&(!Gene.canhas(inblood, 'R'))) {c.psyche=c.psyche-1;};
		if ((z!=1)&&(Gene.canhas(inblood, 'B')))  {c.psyche=c.psyche-1;};

		c.aspect = c.getaspect();
		c.role = c.getrole3();
		
		return c;
	}

	public static int statfucker(int a, int b, int c) {
            // if either of the first two is higher, add one.
            // if either of the first two is lower, subtract one.
            // maximum change of +/- 1 per statfuck
		if ((a>c)||(b>c)) {c++;};
		if ((a<c)||(b<c)) {c--;};
		return c;
	}
	
	public static Body bodyfuck(Body a, String blooda, Body b, String bloodb, Body c, String blood) {
		
		c.heightinches = statfucker(a.heightinches, b.heightinches, c.heightinches);
		c.heightinches = statfucker(a.heightinches, b.heightinches, c.heightinches);
		c.heightinches = statfucker(a.heightinches, b.heightinches, c.heightinches);
		c.heightinches = statfucker(a.heightinches, b.heightinches, c.heightinches);
		c.height = Desc.infeet(c.heightinches);

		//genezone, from "inherited" to "personal variation"
		c.feralgene = mutiBlend2(a.feralgene, b.feralgene, c.feralgene, 50, 50, 10);
		c.tailgene = mutiBlend2(a.tailgene, b.tailgene, c.tailgene, 50, 50, 10);
		c.pupation = mutiBlend2(a.pupation, b.pupation, c.pupation, 50, 50, 10);
		c.skingene = mutiBlend2(a.skingene, b.skingene, c.skingene, 50, 50, 20);
		c.buildgene = mutiBlend2(a.buildgene, b.buildgene, c.buildgene, 20, 20, 50);
		c.fingene = mutiBlend2(a.fingene, b.fingene, c.fingene, 15, 15, 50);
		c.respiratorygene = mutiBlend2(a.respiratorygene, b.respiratorygene, c.respiratorygene, 10, 10, 50);
		c.pigmentgene = mutiBlend2(a.pigmentgene, b.pigmentgene, c.pigmentgene, 50, 50, 10);
                c.syndromegene = mutiBlend2(a.syndromegene, b.syndromegene, c.syndromegene, 50, 50, 10);
                c.sightgene = mutiBlend2(a.sightgene, b.sightgene, c.sightgene, 50, 50, 10);
                
		return c;
	}
	
	public static Horns hornfuck(Horns a, Horns b, Horns c, String blood) {
		
		c.rgene.Anggene = mutiBlend2(a.rgene.Anggene, b.rgene.Anggene, c.rgene.Anggene,30,30,30);
		c.rgene.Tipgene = mutiBlend2(a.rgene.Tipgene, b.rgene.Tipgene, c.rgene.Tipgene,30,30,30);
		c.rgene.Dirgene = mutiBlend2(a.rgene.Dirgene, b.rgene.Dirgene, c.rgene.Dirgene,30,30,30);
		c.rgene.Placegene = mutiBlend2(a.rgene.Placegene, b.rgene.Placegene, c.rgene.Placegene,30,30,30);
		c.rgene.Radialgene = mutiBlend2(a.rgene.Radialgene, b.rgene.Radialgene, c.rgene.Radialgene,30,30,30);
		c.rgene.Curlengene = mutiBlend2(a.rgene.Curlengene, b.rgene.Curlengene, c.rgene.Curlengene,30,30,30);

		c.lgene.Anggene = mutiBlend2(a.lgene.Anggene, b.lgene.Anggene, c.lgene.Anggene,30,30,30);
		c.lgene.Tipgene = mutiBlend2(a.lgene.Tipgene, b.lgene.Tipgene, c.lgene.Tipgene,30,30,30);
		c.lgene.Dirgene = mutiBlend2(a.lgene.Dirgene, b.lgene.Dirgene, c.lgene.Dirgene,30,30,30);
		c.lgene.Placegene = mutiBlend2(a.lgene.Placegene, b.lgene.Placegene, c.lgene.Placegene,30,30,30);
		c.lgene.Radialgene = mutiBlend2(a.lgene.Radialgene, b.lgene.Radialgene, c.lgene.Radialgene,30,30,30);
		c.lgene.Curlengene = mutiBlend2(a.lgene.Curlengene, b.lgene.Curlengene, c.lgene.Curlengene,30,30,30);

		c.form = mutiBlend(a.form, b.form, c.form);

		c.horncalc(blood,  c.rgene,  c.lgene,  c.form);
		
		return c;
	}

	public static Eye eyefuck(Eye a, Eye b, Eye c, String blood) {
		Eye d = new Eye("blank");
		
		d.lefteye  = mutiBlend2(a.lefteye,  b.lefteye,  c.lefteye,  50, 50, 20);
		d.righteye = mutiBlend2(a.righteye, b.righteye, c.righteye, 50, 50, 20);
		d.strayeye = mutiBlend2(a.strayeye, b.strayeye, c.strayeye, 50, 50, 20); 
				
		return d;
	}

	// misc
	public static boolean canhas(String instr, char letter) {
		// checks Just the first two letters of instr
		// to see if either of them is the given letter
		// case insensitive.  This is for blood work
		boolean flag = false;
		
		if (instr.length()>0) {  // if there is a first letter
			// ..and it's uppercase or lowercase [letter], flag=true.
			if ((instr.charAt(0) == Character.toUpperCase(letter)) || 
				(instr.charAt(0) == Character.toLowerCase(letter))) {flag = true;};
		};
		
		if (instr.length()>1) {  // if there is a second letter
			// ..and it's uppercase or lowercase [letter], flag=true.
			if ((instr.charAt(1) == Character.toUpperCase(letter)) || 
				(instr.charAt(1) == Character.toLowerCase(letter))) {flag = true;};
		};
		
		return flag;
	}
	
        public static int counthas(String instr, char letter) {
            int c = 0;
            for (int x = 0; x<instr.length(); x++) {
                if (instr.charAt(x)==letter) {c++;};};
            return c;
        }
        
        public static int counthas(String instr, char big, char lil) {
            int c = 0;
            for (int x = 0; x<instr.length(); x++) {
                if (instr.charAt(x)==big) {c++;c++;};};
            for (int x = 0; x<instr.length(); x++) {
                if (instr.charAt(x)==lil) {c++;};};
            return c;        
        };

        public static boolean listhas(String[] L, String code) {
            boolean flag = false;
            for (int i=0; i<=L.length-1;i++) {
                if (L[i].contains(code)) {flag=true;};
                if (code.contains(L[i]))   {flag=true;};
                };
            return flag;
        };
        
	public static String hemospectrum(String inblood, int direction) {
		// direction is an integer between -15ish and +15ish
		Random rand = new Random();
		String answer = "";
		int tempindex = 0;
		
                // humans, carapacians, and fae aren't hemospectrum'd
                if ((Arrays.asList(fae).contains(inblood))) {answer = fae[rand.nextInt(fae.length)]; return answer;}
                if ((Arrays.asList(human).contains(inblood))) {answer = human[rand.nextInt(human.length)]; return answer;}
                if ((Arrays.asList(carapacian).contains(inblood))) {answer = carapacian[rand.nextInt(carapacian.length)]; return answer;}
		// if we don't understand the value yet, pick a random one.
		if (answer.equals("")&&!(Arrays.asList(spectrum).contains(inblood)))
                    {inblood = spectrum[rand.nextInt(spectrum.length)];}	
		
		for (int i=0; i<=spectrum.length-1;i++) {
			if (spectrum[i]==inblood) {
				tempindex = i + direction;
				if (tempindex<0) {tempindex=tempindex+spectrum.length;};
				if (tempindex>spectrum.length-1) {tempindex=tempindex-spectrum.length;};
				answer = spectrum[tempindex];
				tempindex = 0;
			}; 
		}		
		return answer;
	}
	
	public static String permute(String code, String A, String B, String Atxt, String ABtxt, String BAtxt, String Btxt) {
		String txt = new String("");
		if (code.equals(A+A)) {txt = Atxt;};
		if (code.equals(A+B)) {txt = ABtxt;};
		if (code.equals(B+A)) {txt = BAtxt;};
		if (code.equals(B+B)) {txt = Btxt;};
		return txt;
	}

	public static String permute3(String code, String A, String B, String C, 
			String AAtxt, String ABtxt, String BBtxt, String BCtxt, String CCtxt, String ACtxt) {
		String txt = new String("");
		
		if (code.equals(A+A)) {txt = AAtxt;};
		if ((code.equals(A+B))||(code.equals(B+A))) {txt = ABtxt;};
		if (code.equals(B+B)) {txt = BBtxt;};
		if ((code.equals(C+B))||(code.equals(B+C))) {txt = BCtxt;};
		if (code.equals(C+C)) {txt = CCtxt;};
		if ((code.equals(A+C))||(code.equals(C+A))) {txt = ACtxt;};

		return txt;
	}

	public static String permute4(String code, String A, String a, String b, String B, 
			String AAtxt, String Aatxt, String aatxt, String Abtxt, String abtxt, String ABtxt,
			String Batxt, String bbtxt, String Bbtxt, String BBtxt) {
		String txt = new String("");
		if (code.equals(A+A)) {txt = AAtxt;};
		if ((code.equals(A+a))||(code.equals(a+A))) {txt = Aatxt;};
		if (code.equals(a+a)) {txt = aatxt;};
		if ((code.equals(A+b))||(code.equals(b+A))) {txt = Abtxt;};
		if ((code.equals(a+b))||(code.equals(b+a))) {txt = abtxt;};
		if ((code.equals(A+B))||(code.equals(B+A))) {txt = ABtxt;};
		if ((code.equals(a+B))||(code.equals(B+a))) {txt = Batxt;};
		if (code.equals(b+b)) {txt = bbtxt;};
		if ((code.equals(b+B))||(code.equals(B+b))) {txt = Bbtxt;};
		if (code.equals(B+B)) {txt = BBtxt;};
		return txt;
	}
	
	public static String randopt(String[] inset, int num) {
		Random rand = new Random();
		String var = "";
		int i = 0;
		while (i<num) {
			var = var + inset[rand.nextInt(inset.length)];			
			i++;
		};
		return var;
	}
	
        public static boolean isfae(String incode) {
            boolean flag = false;
            if (Arrays.asList(fae).contains(incode)) {flag=true;};
            if (listhas(fae, incode)) {flag=true;};
            return flag;
        };

        public static boolean ishum(String incode) {
            boolean flag = false;
            if (Arrays.asList(human).contains(incode)) {flag=true;}; 
            if (listhas(human, incode)) {flag=true;};
            return flag;
        };

        public static boolean istroll(String incode) {
            boolean flag = false;
            if (Arrays.asList(spectrum).contains(incode))      {flag=true;};           
            if (Arrays.asList(castes).contains(incode))        {flag=true;};
            if (Blood.condensecaste(incode).contains("troll")) {flag=true;};
            return flag;
        };
        
        public static boolean iscarapacian(String incode) {
            boolean flag = false;
            if (Arrays.asList(carapacian).contains(incode))      {flag=true;};           
            if (listhas(carapacian, incode)) {flag=true;};
            return flag;
        };
                
        public static boolean isfertfem(String incode) {
            boolean flag = true;
            String sex = incode.substring(0,2);
            if (sex.startsWith("XY")) {flag=false;};  // No men
            if (sex.startsWith("V"))  {flag=false;};  // No bucks
            String puberty   = incode.substring(2,3);
            String fertility = incode.substring(3,4);
            if (puberty.startsWith("0")) {flag=false;}; // No Neoteny
            if (fertility.startsWith("0")) {flag=false;}; // No infertility
            String litter = incode.substring(5,9);
            if (litter.startsWith("0000")) {flag=false;}; // No infertility            
            return flag;
        };

        public static boolean isfertmasc(String incode) {
            boolean flag = true;
            String sex = incode.substring(0,2);
            if (sex.startsWith("XX")) {flag=false;};  // No women
            String puberty   = incode.substring(2,3);
            String fertility = incode.substring(3,4);
            if (puberty.startsWith("0")) {flag=false;}; // No Neoteny
            if (fertility.startsWith("0")) {flag=false;}; // No infertility
            String litter = incode.substring(5,9);
            if (litter.startsWith("0000")) {flag=false;}; // No infertility            
            return flag;
        };
         
        public static int littersize(String infert1, String infert2) {
            int var = 0; // number of children in the litter
            
            // Do we have at least one egg producer and sperm donor, on opposite people?
            boolean fertilepairing = false;
            if (isfertfem(infert1)&&isfertmasc(infert2)) {fertilepairing=true;};
            if (isfertfem(infert2)&&isfertmasc(infert1)) {fertilepairing=true;};
            if (!fertilepairing) {return 0;}; // If not, get out.
            
            // Fertility and Litter arrays
            char[] one = infert1.toCharArray();
            int F1 = Character.getNumericValue(one[3]);
            String[] L1 = {infert1.substring(5,6), infert1.substring(6,7),
                           infert1.substring(7,8), infert1.substring(8,9)};
            char[] two = infert2.toCharArray();
            int F2 = Character.getNumericValue(two[3]);
            String[] L2 = {infert2.substring(5,6), infert2.substring(6,7),
                           infert2.substring(7,8), infert2.substring(8,9)};
            
            // Sum F randomly-selected digits from the Litter Array
            int litter1 = digsum(randopt(L1, F1));
            int litter2 = digsum(randopt(L2, F2));
            
            var = litter1; // Assume L1 is smaller
            if (litter2<litter1) {var=litter2;}; // set to L2 if it's smaller
            return var; // return the smaller of the two numbers
        };
        
        public static int digsum(String incode) {
            char[] code = incode.toCharArray();
            int num = 0;
            for (int i=0; i<code.length;i++) {
                num = num + Character.getNumericValue(code[i]);
                };
        return num;
        };
        
        public static int avgnum(String incode) {
        char[] code = incode.toCharArray();
        int num = 0; // running total
        for (int i=0; i<code.length; i++) {
            num = num + Character.getNumericValue(code[i]);
            }
        num = Math.floorDivExact(num, code.length);
        return num;
        }

        public static String colorfromhue(int hue, Boolean inverted) {
            if (inverted) {hue=Math.floorMod(hue+180, 360);};
            String col = "";
            if ((  0<=hue)&&(hue< 14)) {col="maroon";};
            if (( 14<=hue)&&(hue< 25)) {col="maroon/bronze";};
            if (( 25<=hue)&&(hue< 37)) {col="bronze";};
            if (( 37<=hue)&&(hue< 48)) {col="bronze/gold";};
            if (( 48<=hue)&&(hue< 75)) {col="gold";};
            if (( 75<=hue)&&(hue< 88)) {col="gold/lime";};
            if (( 88<=hue)&&(hue<105)) {col="lime";};
            if ((105<=hue)&&(hue<118)) {col="lime/olive";};
            if ((118<=hue)&&(hue<135)) {col="olive";};
            if ((135<=hue)&&(hue<148)) {col="olive/jade";};
            if ((148<=hue)&&(hue<165)) {col="jade";};
            if ((165<=hue)&&(hue<178)) {col="jade/teal";};
            if ((178<=hue)&&(hue<195)) {col="teal";};
            if ((195<=hue)&&(hue<208)) {col="teal/cerulean";};
            if ((208<=hue)&&(hue<225)) {col="cerulean";};
            if ((225<=hue)&&(hue<238)) {col="cerulean/blue";};
            if ((238<=hue)&&(hue<255)) {col="blue";};
            if ((255<=hue)&&(hue<268)) {col="blue/indigo";};
            if ((268<=hue)&&(hue<285)) {col="indigo";};
            if ((285<=hue)&&(hue<298)) {col="indigo/violet";};
            if ((298<=hue)&&(hue<315)) {col="violet";};
            if ((315<=hue)&&(hue<328)) {col="violet/tyrian";};
            if ((328<=hue)&&(hue<345)) {col="tyrian";};
            if ((345<=hue)&&(hue<361)) {col="tyrian/maroon";};
            return col;
        };
        
//Dirgene = Gene.mutiBlend(pickdir(blood), pickdir(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickdir("rand"));
	
/*	
		Random rand = new Random();
if (blood=="rand") {
	String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
			"", "", "", "", "", "", "", "", ""};
	blood = options[rand.nextInt(options.length)];
}
*/
	
	
	/*
	public String function(String blood){

		Blood b = new Blood(blood);
 		Random rand = new Random();
		String variable = new String();
		variable = "";

	if (blood=="rand") {
		String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
				"", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", ""};
		blood = options[rand.nextInt(options.length)];
	} // end rand
	// caste presets
	if (blood.startsWith("RR")) {}; //Maroon
	if (blood.startsWith("Rr")) {};
	if (blood.startsWith("rr")) {}; // Bronze
	if (blood.startsWith("Rg")) {};
	if (blood.startsWith("RG")) {}; // Gold
	if (blood.startsWith("Gr")) {};
	if (blood.startsWith("rg")) {}; // Lime
	if (blood.startsWith("GG")) {}; // Olive
	if (blood.startsWith("Gg")) {};
	if (blood.startsWith("gg")) {}; // Jade
	if (blood.startsWith("Gb")) {};
	if (blood.startsWith("GB")) {}; // Teal
	if (blood.startsWith("Bg")) {};
	if (blood.startsWith("gb")) {}; // Ceru
	if (blood.startsWith("BB")) {}; // Bloo
	if (blood.startsWith("Bb")) {};
	if (blood.startsWith("bb")) {}; //Indigo
	if (blood.startsWith("Br")) {};
	if (blood.startsWith("RB")) {}; //Violet
	if (blood.startsWith("Rb")) {};
	if (blood.startsWith("rb")) {}; //Tyrian
	
	// other presets
	if (blood.startsWith("")) {};
	if (blood.startsWith("")) {};
	if (blood.startsWith("")) {};
	if (blood.startsWith("")) {};
	if (blood.startsWith("")) {};
	if (blood.startsWith("")) {};
	if (blood.startsWith("")) {};
	
	return variable;
	}
*/
	
/*	
  		String[] Aa = {"A", "a"};
		String[] Bb = {"B", "b"};
		String[] Cc = {"C", "c"};
		String[] Dd = {"D", "d"};
		String[] Ee = {"E", "e"};
		String[] Ff = {"F", "f"};
		String[] Gg = {"G", "g"};
		String[] Hh = {"G", "h"};
		String[] Ii = {"I", "i"};
		String[] Jj = {"J", "j"};
		String[] Kk = {"K", "k"};
		String[] Ll = {"L", "l"};
		String[] Mm = {"M", "m"};
		String[] Nn = {"N", "n"};
		String[] Oo = {"O", "o"};
		String[] Pp = {"P", "p"};
		String[] Qq = {"Q", "q"};
		String[] Rr = {"R", "r"};
		String[] Ss = {"S", "s"};
		String[] Tt = {"T", "t"};
		String[] Uu = {"U", "u"};
		String[] Vv = {"V", "v"};
		String[] Ww = {"W", "w"};
		String[] Xx = {"X", "x"};
		String[] Yy = {"Y", "y"};
		String[] Zz = {"Z", "z"};

		String[] ABC = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
						"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		String[] Xr = {"X", "x", "R", "r", "G", "g", "B", "b", "C", "c"};
		String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

	if (blood=="truerand") {
		String[] Xx = {};
		var = Gene.randopt(Xx, 2) + Gene.randopt(Xx, 2) + Gene.randopt(Xx, 2);
		var = var + Gene.randopt(Xx, 2) + Gene.randopt(Xx, 2) + Gene.randopt(Xx, 2);			
		return var;};
*/	
	
	
	
	
	
}
