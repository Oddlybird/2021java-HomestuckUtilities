package troll.husk;
import troll.fluff.Desc;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;
@SuppressWarnings("unused")

public class Eye {

        // redo Eye entirely, move components over into Body
    
        // move Eye control / strange eye expression/location to Feral gene
        // Move eye colors control to Pigment gene, remove RGB colors & handle that in Description
        // ------- Enable human/fae eye color genetics
        // move eye glow to syndrome
    
        // keep eye shapes, but move from individual eye to the Shared Eyes Gene
        // move pupil control to shared eyes gene : allow strangeness to exhibit on Left Right Stray or No eyes.
        // move pupilnum to shared eyes gene
        // move pupil shape to shared eyes gene
    
    /* human eye color draft: 
    Melanin Pigment <---> none
    Black, Brown, Hazel, Green, Dark Blue, Light Blue, Grey, Pink

    MMM Black,          MMm Brown,          MmM Hazel,      Mmm Green,
    mMM Dark Blue,	mMm Light Blue,     mmM Grey,       mmm Pink
    
    Troll eyes : blood-color vs inverted blood color (XXX vs xxx?) -- enables crimson/lime eyes for humans, and blue/orange fae
    RGB color modulation by position: (first = 150 pts, second = 75 pts, third = 31)
    */
    
	public String lefteye = "";  // The left eye.
	//2char: Ss control: Symmetry.  Blend cap eyes together, lowercase together, cap overwrites lower.
	// any eyes that do not end up used/placed are ignored when symmetrising
        // note to self : remove this.  Let eyes be different.
	//2char: PP control: multipupil?  PP =Y, else = N
	//2char: XX Solid color eye?  RrGgBb color components, Cc = caste/blood colored.  Xx = Normal pupil.
	//2char: AB Shape : almond, narrow, big round, boxy, sunken, other
	//---------- AA round,      Aa aA almond, aa narrow,
	//---------- BB sharp,      Bb bB boxy,   bb sunken, 
	//---------- AB BA bulging, Ab bA hooded, Ba aB rectangular, ab ba beady 
	//2char: Gg Eye glow?  Toggleable, always, never.
	//---------- compare to skingene biolum, psyche stat, and etc
	//1char: A pupilnum.  A=1, B=2, C=3, D=4, E=5, F=6, G=7 ... etc.
	//2char:  Pupil Shape (base on how tip gene works)
	//---------- RR round, R+(any) = Round,
	//---------- rr oval, rl diamond, lr star, ll slit
	//---------- ss octopus, sr goat, rs triangle, sl teardrop, ls weird symbol, 

	public String righteye = ""; // The right eye.
	// same format as above

	public String strayeye = "";  // Any other eyes.
	// same format.
	
	// this one is the general constructor
	public Eye(String blood) {
		// update it to have other arguments later
		Random rand = new Random();
		
		lefteye = eyegene(blood, false);
		righteye = eyegene(blood, false);
		strayeye = eyegene(blood, true);
				
		// TODO Auto-generated constructor stub
	}
	
// this one is JUST the eyegene for individual eyes
	public String eyegene(String blood, boolean stray) {
		Random rand = new Random();
		String var = new String("SSppXXAaggARR");
		
		if (blood=="truerand") {
			String[] Ss = {"S", "s"};
			String[] Pp = {"P", "p"};
			String[] Xr = {"X", "x", "R", "r", "G", "g", "B", "b", "C", "c"};
			String[] Ab = {"A", "a", "B", "b"};
			String[] Gg = {"G", "g"};
			String[] ABC = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
			String[] Rls = {"R", "r", "l", "s", "r"};
			var = Gene.randopt(Ss, 2) + Gene.randopt(Pp, 2);
			var = var + Gene.randopt(Xr, 2) + Gene.randopt(Ab, 2) + Gene.randopt(Gg, 2);			
			var = var + Gene.randopt(ABC, 1) + Gene.randopt(Rls, 2);
			return var;};
		
		if (!stray) {
			if (blood.startsWith("blank")) {return var;};
			var = Gene.mutiBlend(pickeye(blood), pickeye(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickeye("rand"));
			}
		if (stray) {
			if (blood.startsWith("blank")) {var="SSppXXAaggARR"; return var;};
			var = Gene.mutiBlend(pickeye("none"), pickeye(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickeye("rand"));
			}
		return var;
	}

	public String pickeye(String blood){
		Blood b = new Blood(blood);
 		Random rand = new Random();
 		String var = new String();
		var = "SSppXXAaggARR";
		//2char: Ss control: Symmetry.  Blend cap eyes together, lowercase together, cap overwrites lower.
		//2char: PP control: multipupil?  PP =Y, else = N
		//2char: XX Solid color eye?  RrGgBb color components, Cc = caste/blood colored.  Xx = Normal pupil.
		//2char: AB Shape : almond, narrow, big round, boxy, sunken, other
		//---------- AA round,      Aa aA almond, aa narrow,
		//---------- BB sharp,      Bb bB boxy,   bb sunken, 
		//---------- AB BA bulging, Ab bA hooded, Ba aB rectangular, ab ba beady 
		//2char: Gg Eye glow?  Toggleable, always, never.
		//---------- compare to skingene biolum, psyche stat, and etc
		//1char: A pupilnum.  A=1, B=2, C=3, D=4, E=5, F=6, G=7 ... etc.
		//2char:  Pupil Shape (base on how tip gene works)
		//---------- RR round, R+(any) = Round,
		//---------- rr oval, rl diamond, lr star, ll slit
		//---------- ss octopus, sr goat, rs triangle, sl teardrop, ls weird symbol, 

		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
					"none", "normal", "double", "double", "double", "psychC", "psychc",
					"psychR", "psychr", "psychG", "psychg", "psychB", "psychb"};
			blood = options[rand.nextInt(options.length)];
		} // end rand
		if (blood=="truerand") {
			String[] Ss = {"S", "s"};
			String[] Pp = {"P", "p"};
			String[] Xr = {"X", "x", "R", "r", "G", "g", "B", "b", "C", "c"};
			String[] Ab = {"A", "a", "B", "b"};
			String[] Gg = {"G", "g"};
			String[] ABC = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
			String[] Rls = {"R", "r", "l", "s", "r"};
			var = Gene.randopt(Ss, 2) + Gene.randopt(Pp, 2);
			var = var + Gene.randopt(Xr, 2) + Gene.randopt(Ab, 2) + Gene.randopt(Gg, 2);			
			var = var + Gene.randopt(ABC, 1) + Gene.randopt(Rls, 2);
			return var;};

		// caste presets
	if (blood.startsWith("RR"))     {var="SSppXXaAGgARR";}; //Maroon
	if (blood.startsWith("Rr"))     {var="SSpprbAaGgArR";};
	if (blood.startsWith("rr"))     {var="SSppXXABGgARR";}; // Bronze
	if (blood.startsWith("Rg"))     {var="sSpPBRaagGAlR";};
	if (blood.startsWith("RG"))     {var="SSppRGBAGgArA";}; // Gold
	if (blood.startsWith("Gr"))     {var="SsppGBAbgGAlA";};
	if (blood.startsWith("rg"))     {var="SSppgbbbGgAAr";}; // Lime
	if (blood.startsWith("GG"))     {var="SSppXXBBggARR";}; // Olive
	if (blood.startsWith("Gg"))     {var="SSppbgBaggARR";};
	if (blood.startsWith("gg"))     {var="SSppXXAbggARR";}; // Jade
	if (blood.startsWith("Gb"))     {var="SSpPXrBbggARR";};
	if (blood.startsWith("GB"))     {var="SSppXXBaggAlR";}; // Teal
	if (blood.startsWith("Bg"))     {var="sSPpbXbBggArR";};
	if (blood.startsWith("gb"))     {var="SSppxxaaggARl";}; // Ceru
	if (blood.startsWith("BB"))     {var="SSppXXaBggARR";}; // Bloo
	if (blood.startsWith("Bb"))     {var="SSppXXBaggAsR";};
	if (blood.startsWith("bb"))     {var="SSppxxbAGgARr";}; //Indigo
	if (blood.startsWith("Br"))     {var="sSppXXabggAsR";};
	if (blood.startsWith("RB"))     {var="SSppxxBBggARR";}; //Violet
	if (blood.startsWith("Rb"))     {var="SsppXXABggARs";};
	if (blood.startsWith("rb"))     {var="SSppxxaaggAsR";}; //Tyrian

	// other presets
	if (blood.startsWith("none"))   {var="ssPPxxaaggCls";};
	if (blood.startsWith("double")) {var="SSppXXAaggARR";};
	if (blood.startsWith("normal")) {var="SSppXXAaggARR";};
	if (blood.startsWith("psychR")) {var="ssppRRBBGgFrR";};
	if (blood.startsWith("psychr")) {var="sspprrABgGERr";};
	if (blood.startsWith("psychG")) {var="ssppGGBAGgDlR";};
	if (blood.startsWith("psychg")) {var="ssppggabgGGRl";};
	if (blood.startsWith("psychB")) {var="ssppBBbaGgHsR";};
	if (blood.startsWith("psychb")) {var="ssppbbAbgGIRs";};
	if (blood.startsWith("psychC")) {var="ssppCCbAGgJrr";};
	if (blood.startsWith("psychc")) {var="ssppccBagGBll";};
        // nontroll
        if (blood.startsWith("human"))  {var="SSppXXAaggARR";};
	if (blood.startsWith("fae"))    {var="SSppXXAaggARR";};

        
	return var;
	}

// descriptive zone
	
        // Out of date : first 2 characters removed from gene
        // control gene moved to feral area
	public String wholisticdescription(Eye i) {
 		Random rand = new Random();
		String var = new String("");
                
		// figure out which eyes are active
    		String   num    =  "NN"; // i.control.substring(0,2);  // NN, SS, MM
		String   place  =  "NN"; // i.control.substring(2,4);  // 2char = (LRGNnFBT) + (LRGNn)
		
		// set them based on the individual eyegenes
		boolean eye1 = false; String e1 = "EE"; // i.lefteye.substring(0,2);  if (e1!="ee") {eye1=true;}  
		boolean eye2 = false; String e2 = "EE"; // i.righteye.substring(0,2); if (e2!="ee") {eye2=true;}
		boolean eye3 = false; String e3 = "ee"; // i.strayeye.substring(0,2); if (e3!="ee") {eye3=true;}
		
		// correct with overrides
		if ((num.startsWith("N"))||(num.endsWith("N"))) {eye1 = true; eye2 = true; eye3 = false;};
		boolean weird=true;
		
		if (!eye3) {weird=false;};
		if ((place.startsWith("N"))||  (place.endsWith("N"))||(place.startsWith("n"))) {weird=false;};
		if ((place.startsWith("R"))||(place.startsWith("L")))  {weird=false;};
		if ((place.endsWith("R"))  ||  (place.endsWith("L")))  {weird=false;};
		if (place.endsWith("Gn")) {weird=false;}
		if (!weird) {eye3 = false;};

		// test doubling
		boolean Ldub = false, Rdub = false;
		if (eye3) {
			if (place=="LL") {Ldub=true;};
			if (place=="RR") {Rdub=true;};
			if (place=="LR") {Ldub=true;Rdub=true;};
			if (place=="RL") {Ldub=true;Rdub=true;};
			if (e1!="DD") {Ldub=false;};
			if (e2!="DD") {Rdub=false;};
			}
		// eyecount
		int num1 = 0; if (eye1==false) {num1=0;};
		int num2 = 0; if (eye2==false) {num2=0;};
		int num3 = 0; if (eye3==false) {num3=0;};

		// set to basic true/false for eye presence
		if ((num1==0)&&(num2==0)&&(num3==0)) {
			if (eye1==true) {num1=1;}; if (eye2==true) {num2=1;}; if (eye3==true) {num3=1;};};
		// if there's a specific number of weird eyes going on, correct that
		if (num.startsWith("SS")) {
			if (eye1==true) {num1=1;}; if (eye2==true) {num2=1;}; if (eye3==true) {num3=1;};};
		if (num.startsWith("SM")||num.startsWith("MS")) {
			if (eye1==true) {num1=2;}; if (eye2==true) {num2=2;}; if (eye3==true) {num3=2;};};
		if (num.startsWith("MM")) {
			if (eye1==true) {num1=3;}; if (eye2==true) {num2=3;}; if (eye3==true) {num3=3;};};
			
		// lastly, trim it back based on each eye's doubling gene
		if (num1>1) {					    // If there are more than 2 left eyes
			if (e1=="DD") {Ldub=false;};	// They can be multiple, 
			if (e1!="DD") {num1=1;};		// Or not.
		}
		if (num2>1) {					    // If there are more than 2 right eyes
			if (e2=="DD") {Rdub=false;};	// They can be multiple, 
			if (e2!="DD") {num2=1;};		// Or not.
		}
		if (num3>1) {					    // If there are more than 2 stray eyes
			if (e2=="DD") {};				// They can be many,
			if (e2!="DD") {num3--;};		// Or not.
		}			
			
		// text description zone
		// numeyes : integer, 0 = none, 1 = single, 2= varied size, 3 = many small.
		// Ldub / Rdub, boolean, doubling
		
		if (num1>0) {
			var = var + eyenum(num1) + " ";
			if (Ldub) {var = var + " doubled";};
			var = var + "left eye";
			if ((num1>1)||(Ldub)) {var = var + "s";};	
			};
		if ((var!="")&&((num2>0)||(num3>0))) {var = var + ", and ";}
		if (num2>0) {
			var = var + eyenum(num2) + " ";
			if (Rdub) {var = var + " doubled";};
			var = var + "right eye";
			if ((num2>1)||(Rdub)) {var = var + "s";};	
			};
		if ((var!="")&&(num3>0)&&(eye3==true)) {var = var + ", ";}
				
		if ((num3>0)&&(weird==true)) {
			String s = "and ";
			s = s + eyenum(num3) + " ";
			s = s + "stray eye";
			boolean plural = false; if (num3>1) {plural = true;};
			boolean sym = true; if (i.strayeye.substring(2,4)=="ss") {sym=false;};
			if (plural) {s = s + "s";};	
			
			s = s + " on ";
			if (place.startsWith("Fn")) {s = s + "the front of the body";};
			if (place.startsWith("Bn")) {s = s + "the back of the body";};
			if ((place.startsWith("Tn"))&&(plural))  {s = s + "the extremities";};
			if ((place.startsWith("Tn"))&&(!plural)) {s = s + "an extremity";};
			
			if (place.startsWith("FH")) {s = s + "the face";};
			if (place.startsWith("BH")) {s = s + "the back of the head";};
			if (place.startsWith("TH")) {s = s + "the forehead";};
			if (place.startsWith("GH")) {s = s + "the head in grub form";};

			if (place.startsWith("Fh")) {s = s + "the palm";             if (sym==true) {s = s + "s";};  };
			if (place.startsWith("Bh")) {s = s + "the back of the hand"; if (sym==true) {s = s + "s";};  };
			if (place.startsWith("Th")) {s = s + "the fingertip";        if (sym==true) {s = s + "s";};  };
			if (place.startsWith("Gh")) {s = s + "the grubleg tip";      if (sym==true) {s = s + "s";};  };

			if (place.startsWith("FC")) {s = s + "the chest/ribcage";};
			if (place.startsWith("BC")) {s = s + "the torso/back";};
			if (place.startsWith("TC")) {s = s + "the spine";};
			if (place.startsWith("GC")) {s = s + "the grub main body segment";};

			if (place.startsWith("FL")) {s = s + "the arm"; if (sym==true) {var = var + "s";};};
			if (place.startsWith("BL")) {s = s + "the leg"; if (sym==true) {var = var + "s";};};
			if (place.startsWith("TL")) {s = s + "the tail, if present";};
			if (place.startsWith("GL")) {s = s + "the back or side of grubleg"; if (sym==true) {s = s + "s";};};

			if (place.startsWith("FG")) {s = s + "the front of the grub form";};
			if (place.startsWith("BG")) {s = s + "the back of the grub form";};
			if (place.startsWith("TG")) {s = s + "the tail of the grub form";};
			if (place.startsWith("GG")) {s = "";};
			
			var = var + s;
		};
		
		if ((place.startsWith("GG"))&&(weird==true)) {var = var + "which may be lost during pupation";};
		
		return var;
	}
	
	public String colfromeye(String eye, String blood) {
		Color col = new Color(0, 0, 0);
		Blood b = new Blood(""); // lowercase b
		// do stuff to the color based on eyestring
		String colgene = eye.substring(6,8);
		
		// Normal
		if (colgene.startsWith("X")) {col=b.colorfromcode(blood); return Desc.colortostring(col);};
		if (colgene.endsWith("X"))   {col=b.colorfromcode(blood); return Desc.colortostring(col);};
		// Less normal
		if (colgene=="xx") {col=b.colorfromcode(blood);};
		if (colgene.startsWith("C")) {col=b.colorfromcode(blood);};
		if (colgene.endsWith("C"))   {col=b.colorfromcode(blood);};
		if (colgene=="cc") {col=b.colorfromcode(blood);};
			
		// Let's convert our base color into integers real quick.
		int R = col.getRed();
		int G = col.getGreen();
		int B = col.getBlue(); //uppercase B
		// Discoloring begins
		if (colgene.charAt(0)=='R') {R=R+255;};	if (colgene.charAt(0)=='r') {R=R+128;};
		if (colgene.charAt(0)=='G') {G=G+255;};	if (colgene.charAt(0)=='g') {G=G+128;};
		if (colgene.charAt(0)=='B') {B=B+255;};	if (colgene.charAt(0)=='b') {B=B+128;};
		if (colgene.charAt(1)=='R') {R=R+255;};	if (colgene.charAt(1)=='r') {R=R+128;};
		if (colgene.charAt(1)=='G') {G=G+255;};	if (colgene.charAt(1)=='g') {G=G+128;};
		if (colgene.charAt(1)=='B') {B=B+255;};	if (colgene.charAt(1)=='b') {B=B+128;};		
		// Make sure it's between 0 and 255 again
		while (R>255) {B--;G--;R--;R--;};
		while (G>255) {R--;B--;G--;G--;};
		while (B>255) {G--;R--;B--;B--;};
		// The goal is to create extreme neon colors, so minimizing muddiness is good.
		if (R<0) {R=0;};
		if (G<0) {G=0;};
		if (B<0) {B=0;};		
		// No black eyes, Red instead
		if ((R==0)&&(G==0)&(B==0)) {R=255;};
		// then convert back to a color
		col = new Color(R, G, B);
		// then convert it to a string and save it
		String strcol = Desc.colortostring(col);
		return strcol;
	}
		
	private String eyenum(int n) {
		String adj = new String("");
		if (n == 0) {adj = "no";};
		if (n == 1) {adj = "one";};
		if (n == 2) {adj = "several";};
		if (n == 3) {adj = "many";};		
		return adj;
	}
	
	
	
}
