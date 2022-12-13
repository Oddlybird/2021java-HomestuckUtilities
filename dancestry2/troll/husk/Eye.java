package troll.husk;
import troll.fluff.Desc;
import troll.husk.Blood;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;
@SuppressWarnings("unused")

public class Eye {

	public String leftcolor = "";
	// set to bloodcol, or to color indicated in eye gene
	public String lefteye = "";  // The left eye.
	//2char: Ee control: EE Ee eE eye active, ee eye suppressed, DD doubled.
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

	public String rightcolor = "";
	public String righteye = ""; // The right eye.
	// same format as above

	public String straycolor = "";
	public String strayeye = "";  // Any other eyes.
	// same format.
	
	public String control = "";
	// 2char:    Do they express?
	// --- (NN) nothing weird, (SS) single, (MM) many tiny eyes, (SM/MS) various sized eyes
	// --- (NS/SN) nothing weird (NM/MN) nothing weird
	// 2char:    Where express -- containing N = normal, containing G = more eyes as grub than adult
	// --- (LL) left doubling, (RR) right doubling, (LR/RL) both doubling, GL/LG/RG/GR - doubling as grub
	// --- (N?, ?N, n?) nowhere weird. (anything not covered) nowhere weird.
	// --- (Fn) misc frontal  (Bn) misc back        (Tn) misc extremities (Gn) nothing weird
	// --- (FH) misc facial,  (BH) back of head,    (TH) forehead		  (GH) grub-only spare head eyes
	// --- (Fh) palm,         (Bh) back of hand,    (Th) fingertips		  (Gh) tip-of-grubleg
	// --- (FC) chest/ribcage,(BC) misc torso+back, (TC) spine			  (GC) grub-torso
	// --- (FL) arms,         (BL) legs,            (TL) tail-if-present  (GL) back-of-grubleg
	// --- (FG) Grub front    (BG) grub rear        (TG) grubtail         (GG) no normal eyes after pupation
	// --- options in summary: 2char = (LRGNnFBT) + (LRGNn)

	public String sight = "";
	// 2char: Dd  Daylight sight, vs. eye damage taken from daylight // Qq (magicsight)
	// 2char: Iix Can eyes move independently? // Qq (magicsight)
	// --- (II both independant, Ii/iI/Ix/xI normal, ii cross eyed, ix/xi one eye lazy, xx eyes nonmobile) 
	// 2char: Dd  How well see in the dark? (DD great, Dd/dD aight, dd badly) // Qq (magicsight)
	// 2char: XX  (Xx) normal (Nn) nearsight, (Ff)farsight, (Aa)astigmatism // Qq (magicsight)
	// ---------  1 capital or 2 lowercase = expressed.  2 capital = severe.  1 capital + same lowercase = strong.
	// 2char: Pp  Can you see polarization of light? PP yes, else no // Qq (sees magic)
	// 2char: Mm  How well the vision tracks movement Mm/mM normal   // Qq (sees magic)
	// 2char:     color vision, dichromat, trichromat, tetrachromat, infravision, ultraviolet, etc.
	// ---  R = 2, extending into infravision. C = 2, c = 1, normal range.  
	// ---  U = 2, extending into ultraviolet. C = 2, c = 1, normal range. 
	// --- cc: dichromat.  Cc / cC, trichromat.  Rc = trichro infra, cU=trichro ultra.  CC/RC/CU/RU tetrachromat.
	// 2char:     "xfoldvision": "",      # Fancy bullshit vision senses
	// --- A=1,  B=2,  C=3,  D=4, E=5, F=6, G=7, H=8, I=9, J=10, K=12, L=16, M=20,
	// --- N=32, O=50, P=99,
	// --- Q=psychic residue, R=life-sense, S=Sharingan, T=??,
	// --- U=Electromagnetism, V=gravitational fields, W=eldritch horrorterror shit,
	// --- X=dnd darkvision, Y=ShinySense, Z=Aspect Affiliation

        public String desc = "";

	// this one is the general constructor
	public Eye(String blood) {
		// update it to have other arguments later
		Random rand = new Random();
		
		lefteye = eyegene(blood, false);
		leftcolor = colfromeye(lefteye, blood);
		righteye = eyegene(blood, false);
		rightcolor = colfromeye(righteye, blood);
		strayeye = eyegene(blood, true);
		straycolor = colfromeye(strayeye, "none");
		
		// do the multi-eye control gene here
		control = controlgene(blood);
		sight = sightgene(blood);
		desc = wholisticdescription(this);
		
		// TODO Auto-generated constructor stub
	}
	
// this one is JUST the eyegene for individual eyes
	public String eyegene(String blood, boolean stray) {
		Random rand = new Random();
		String var = new String("EESSppXXAaggARR");
		
		if (blood=="truerand") {
			String[] Ed = {"E", "e", "D"};
			String[] Ss = {"S", "s"};
			String[] Pp = {"P", "p"};
			String[] Xr = {"X", "x", "R", "r", "G", "g", "B", "b", "C", "c"};
			String[] Ab = {"A", "a", "B", "b"};
			String[] Gg = {"G", "g"};
			String[] ABC = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
			String[] Rls = {"R", "r", "l", "s", "r"};
			var = Gene.randopt(Ed, 2) + Gene.randopt(Ss, 2) + Gene.randopt(Pp, 2);
			var = var + Gene.randopt(Xr, 2) + Gene.randopt(Ab, 2) + Gene.randopt(Gg, 2);			
			var = var + Gene.randopt(ABC, 1) + Gene.randopt(Rls, 2);
			return var;};
		
		if (!stray) {
			if (blood.startsWith("blank")) {return var;};
			var = Gene.mutiBlend(pickeye(blood), pickeye(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickeye("rand"));
			}
		if (stray) {
			if (blood.startsWith("blank")) {var="eeSSppXXAaggARR"; return var;};
			var = Gene.mutiBlend(pickeye("none"), pickeye(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickeye("rand"));
			}
		return var;
	}

	public String pickeye(String blood){
		Blood b = new Blood(blood);
 		Random rand = new Random();
 		String var = new String();
		var = "EESSppXXAaggARR";
		//2char: Ee control: EE Ee eE eye active, ee eye suppressed, DD doubled
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
			String[] Ed = {"E", "e", "D"};
			String[] Ss = {"S", "s"};
			String[] Pp = {"P", "p"};
			String[] Xr = {"X", "x", "R", "r", "G", "g", "B", "b", "C", "c"};
			String[] Ab = {"A", "a", "B", "b"};
			String[] Gg = {"G", "g"};
			String[] ABC = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
			String[] Rls = {"R", "r", "l", "s", "r"};
			var = Gene.randopt(Ed, 2) + Gene.randopt(Ss, 2) + Gene.randopt(Pp, 2);
			var = var + Gene.randopt(Xr, 2) + Gene.randopt(Ab, 2) + Gene.randopt(Gg, 2);			
			var = var + Gene.randopt(ABC, 1) + Gene.randopt(Rls, 2);
			return var;};

		// caste presets
	if (blood.startsWith("RR"))     {var="EESSppXXaAGgARR";}; //Maroon
	if (blood.startsWith("Rr"))     {var="EDSSpprbAaGgArR";};
	if (blood.startsWith("rr"))     {var="EESSppXXABGgARR";}; // Bronze
	if (blood.startsWith("Rg"))     {var="DDsSpPBRaagGAlR";};
	if (blood.startsWith("RG"))     {var="DDSSppRGBAGgArA";}; // Gold
	if (blood.startsWith("Gr"))     {var="DDSsppGBAbgGAlA";};
	if (blood.startsWith("rg"))     {var="DESSppgbbbGgAAr";}; // Lime
	if (blood.startsWith("GG"))     {var="EESSppXXBBggARR";}; // Olive
	if (blood.startsWith("Gg"))     {var="EESSppbgBaggARR";};
	if (blood.startsWith("gg"))     {var="EESSppXXAbggARR";}; // Jade
	if (blood.startsWith("Gb"))     {var="EESSpPXrBbggARR";};
	if (blood.startsWith("GB"))     {var="EDSSppXXBaggAlR";}; // Teal
	if (blood.startsWith("Bg"))     {var="DDsSPpbXbBggArR";};
	if (blood.startsWith("gb"))     {var="DESSppxxaaggARl";}; // Ceru
	if (blood.startsWith("BB"))     {var="EESSppXXaBggARR";}; // Bloo
	if (blood.startsWith("Bb"))     {var="EDSSppXXBaggAsR";};
	if (blood.startsWith("bb"))     {var="EESSppxxbAGgARr";}; //Indigo
	if (blood.startsWith("Br"))     {var="DEsSppXXabggAsR";};
	if (blood.startsWith("RB"))     {var="EESSppxxBBggARR";}; //Violet
	if (blood.startsWith("Rb"))     {var="DDSsppXXABggARs";};
	if (blood.startsWith("rb"))     {var="EESSppxxaaggAsR";}; //Tyrian

	// other presets
	if (blood.startsWith("none"))   {var="eessPPxxaaggCls";};
	if (blood.startsWith("double")) {var="DDSSppXXAaggARR";};
	if (blood.startsWith("normal")) {var="EESSppXXAaggARR";};
	if (blood.startsWith("psychR")) {var="EDssppRRBBGgFrR";};
	if (blood.startsWith("psychr")) {var="DEsspprrABgGERr";};
	if (blood.startsWith("psychG")) {var="DEssppGGBAGgDlR";};
	if (blood.startsWith("psychg")) {var="DEssppggabgGGRl";};
	if (blood.startsWith("psychB")) {var="EDssppBBbaGgHsR";};
	if (blood.startsWith("psychb")) {var="EDssppbbAbgGIRs";};
	if (blood.startsWith("psychC")) {var="DEssppCCbAGgJrr";};
	if (blood.startsWith("psychc")) {var="EDssppccBagGBll";};
        // nontroll
        if (blood.startsWith("human"))  {var="EESSppXXAaggARR";};
	if (blood.startsWith("fae"))    {var="EESSppXXAaggARR";};

        
	return var;
	}

	public String controlgene(String blood) {
		Random rand = new Random();
		String var = new String("NNNN");
		if (blood.startsWith("blank")) {return var;};
		if (blood.startsWith("truerand")) {
			String[] op0 = {"N", "S", "M"};
			String[] op1 = {"L", "R", "G", "N", "n", "F", "B", "T"};
			String[] op2 = {"L", "R", "G", "N", "n", "H", "h", "C", "L"};
			var = op0[rand.nextInt(op0.length)] + op0[rand.nextInt(op0.length)];
			var = var + op1[rand.nextInt(op1.length)] + op2[rand.nextInt(op2.length)];
			return var;}
		var = Gene.mutiBlend(pickcontrol(blood), pickcontrol(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickcontrol("rand"));	
		return var;
	}

	public String pickcontrol(String blood){
		Blood b = new Blood(blood);
 		Random rand = new Random();
 		String var = new String("NNNN");
		// 2char:    Do they express?
		// --- (NN) nothing weird, (SS) single, (MM) many tiny eyes, (SM/MS) various sized eyes
		// --- (NS/SN) nothing weird (NM/MN) nothing weird
		// 2char:    Where express -- containing N = normal, containing G = more eyes as grub than adult
		// --- (LL) left doubling, (RR) right doubling, (LR/RL) both doubling, GL/LG/RG/GR - doubling as grub
		// --- (N?, ?N, n?) nowhere weird. (anything not covered) nowhere weird.
		// --- (Fn) misc frontal  (Bn) misc back        (Tn) misc extremities (Gn) nothing weird
		// --- (FH) misc facial,  (BH) back of head,    (TH) forehead		  (GH) grub-only spare head eyes
		// --- (Fh) palm,         (Bh) back of hand,    (Th) fingertips		  (Gh) tip-of-grubleg
		// --- (FC) chest/ribcage,(BC) misc torso+back, (TC) spine			  (GC) grub-torso
		// --- (FL) arms,         (BL) legs,            (TL) tail-if-present  (GL) back-of-grubleg
		// --- (FG) Grub front    (BG) grub rear        (TG) grubtail         (GG) no normal eyes after pupation
		// --- options in summary: 2char = (LRGNn-FBT) + (LRGNn-HhCL)
		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
					"single", "multi", "left2", "right2", "dubtrub", "grub1", "grub2", "passive",
					"front", "back", "tip", "head", "hand", "chest", "limb", "truerand"};
			blood = options[rand.nextInt(options.length)];
		} // end rand
		if (blood.startsWith("truerand")) {
			String[] op0 = {"N", "S", "M"};
			String[] op1 = {"L", "R", "G", "N", "n", "F", "B", "T"};
			String[] op2 = {"L", "R", "G", "N", "n", "H", "h", "C", "L"};
			var = op0[rand.nextInt(op0.length)] + op0[rand.nextInt(op0.length)];
			var = var + op1[rand.nextInt(op1.length)] + op2[rand.nextInt(op2.length)];
			return var;}
		// caste presets
	if (blood.startsWith("RR")) {var="NMNN";}; //Maroon
	if (blood.startsWith("Rr")) {var="NNGN";};
	if (blood.startsWith("rr")) {var="NNNN";}; // Bronze
	if (blood.startsWith("Rg")) {var="SNLN";};
	if (blood.startsWith("RG")) {var="nnNR";}; // Gold
	if (blood.startsWith("Gr")) {var="SNRN";};
	if (blood.startsWith("rg")) {var="NNNN";}; // Lime
	if (blood.startsWith("GG")) {var="NNNN";}; // Olive
	if (blood.startsWith("Gg")) {var="MNNN";};
	if (blood.startsWith("gg")) {var="NNNN";}; // Jade
	if (blood.startsWith("Gb")) {var="NMNN";};
	if (blood.startsWith("GB")) {var="NNNN";}; // Teal
	if (blood.startsWith("Bg")) {var="SNRn";};
	if (blood.startsWith("gb")) {var="NnNL";}; // Ceru
	if (blood.startsWith("BB")) {var="NNLN";}; // Bloo
	if (blood.startsWith("Bb")) {var="NNFN";};
	if (blood.startsWith("bb")) {var="NNNN";}; //Indigo
	if (blood.startsWith("Br")) {var="NSBN";};
	if (blood.startsWith("RB")) {var="NNNN";}; //Violet
	if (blood.startsWith("Rb")) {var="MNTN";};
	if (blood.startsWith("rb")) {var="NNNN";}; //Tyrian
	// other presets 
	if (blood.startsWith("single"))  {var="SSRG";};
	if (blood.startsWith("multi"))   {var="MMLR";};
	if (blood.startsWith("left2"))   {var="SSLL";};
	if (blood.startsWith("right2"))  {var="SSRR";};
	if (blood.startsWith("dubtrub")) {var="SSLR";};
	if (blood.startsWith("grub1"))   {var="MMGn";};
	if (blood.startsWith("grub2"))   {var="MMnG";};
	if (blood.startsWith("passive")) {var="MSnn";};
	if (blood.startsWith("front"))   {var="SMFH";};
	if (blood.startsWith("back"))    {var="MSBG";};
	if (blood.startsWith("tip"))     {var="SMTR";};
	if (blood.startsWith("head"))    {var="MSRH";};
	if (blood.startsWith("hand"))    {var="SMLh";};
	if (blood.startsWith("chest"))   {var="MSRC";};
	if (blood.startsWith("limb"))    {var="SMGL";};
        // nontroll
	if (blood.startsWith("human"))   {var="NNNN";};
	if (blood.startsWith("fae"))     {var="NNNN";};
        

	// special fun
	if (blood.startsWith("truerand")) {
	String[] op0 = {"N", "S", "M"};
	String[] op1 = {"L", "R", "G", "N", "n", "F", "B", "T"};
	String[] op2 = {"L", "R", "G", "N", "n", "H", "h", "C", "L"};
	var = op0[rand.nextInt(op0.length)] + op0[rand.nextInt(op0.length)];
	var = var + op1[rand.nextInt(op1.length)] + op2[rand.nextInt(op2.length)];};
	
	return var;
	}

	public String sightgene(String blood) {
		Random rand = new Random();
		String var = new String("ddIiDdXXPpMmCcAA");
		if (blood.startsWith("blank")) {return var;};
		if (blood=="truerand") {
			String[] Dd = {"D", "d"};
			String[] Iix = {"I", "i", "x"};
			String[] Xnfa = {"X", "n", "f", "a"};
			String[] Pp = {"P", "p"};
			String[] Mm = {"M", "m"};
			String[] RCU = {"C", "c", "R", "U"};
			String[] ABC = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
							"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
			var = Gene.randopt(Dd, 2) + Gene.randopt(Iix, 2) + Gene.randopt(Dd, 2);
			var = var + Gene.randopt(Xnfa, 2) + Gene.randopt(Pp, 2) + Gene.randopt(Mm, 2);			
			var = var + Gene.randopt(RCU, 2) + Gene.randopt(ABC, 2);			
			return var;};
		var = Gene.mutiBlend(picksight(blood), picksight(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), picksight("rand"));			
		return var;		
	}

	public String picksight(String blood){
			Blood b = new Blood(blood);
	 		Random rand = new Random();
			String var = new String();
			var = "ddIiDdXXPpMmCcAA";
			// 2char: Dd  Daylight sight, vs. eye damage taken from daylight // Qq (magicsight)
			// 2char: Iix Can eyes move independently? // Qq (magicsight)
			// --- (II both independant, Ii/iI/Ix/xI normal, ii cross eyed, ix/xi one eye lazy, xx eyes nonmobile) 
			// 2char: Dd  How well see in the dark? (DD great, Dd/dD aight, dd badly) // Qq (magicsight)
			// 2char: XX  (Xx) normal (Nn) nearsight, (Ff)farsight, (Aa)astigmatism // Qq (magicsight)
			// ---------  1 capital or 2 lowercase = expressed.  2 capital = severe.  1 capital + same lowercase = strong.
			// 2char: Pp  Can you see polarization of light? PP yes, else no // Qq (sees magic)
			// 2char: Mm  How well the vision tracks movement Mm/mM normal   // Qq (sees magic)
			// 2char:     color vision, dichromat, trichromat, tetrachromat, infravision, ultraviolet, etc.
			// ---  R = 2, extending into infravision. C = 2, c = 1, normal range.  
			// ---  U = 2, extending into ultraviolet. C = 2, c = 1, normal range. 
			// --- cc: dichromat.  Cc / cC, trichromat.  Rc = trichro infra, cU=trichro ultra.  CC/RC/CU/RU tetrachromat.
			// 2char:     "xfoldvision": "",      # Fancy bullshit vision senses
			// --- A=1,  B=2,  C=3,  D=4, E=5, F=6, G=7, H=8, I=9, J=10, K=12, L=16, M=20,
			// --- N=32, O=50, P=99,
			// --- Q=psychic residue, R=life-sense, S=Sharingan, T=??,
			// --- U=Electromagnetism, V=gravitational fields, W=eldritch horrorterror shit,
			// --- X=dnd darkvision, Y=ShinySense, Z=Aspect Affiliation

		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
					"normal1", "normal2", "day", "crosseye", "staring", "nearsight", "farsight", "astigmatism", "infra+ultra",
					"BBB", "CCC", "DDD", "EEE", "FFF", "GGG", "HHH", "III", "JJJ", "KKK", "LLL", "MMM", 
					"NNN", "OOO", "PPP", "QQQ", "RRR", "SSS", "TTT", "UUU", "VVV", "WWW", "XXX", "YYY", "ZZZ",
					};
			blood = options[rand.nextInt(options.length)];
		} // end rand
		if (blood=="truerand") {
			String[] Dd = {"D", "d"};
			String[] Iix = {"I", "i", "x"};
			String[] Xnfa = {"X", "x", "n", "f", "a", "N", "F", "A"};
			String[] Pp = {"P", "p"};
			String[] Mm = {"M", "m"};
			String[] RCU = {"C", "c", "R", "U"};
			String[] ABC = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
							"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
			var = Gene.randopt(Dd, 2) + Gene.randopt(Iix, 2) + Gene.randopt(Dd, 2);
			var = var + Gene.randopt(Xnfa, 2) + Gene.randopt(Pp, 2) + Gene.randopt(Mm, 2);			
			var = var + Gene.randopt(RCU, 2) + Gene.randopt(ABC, 2);			
			return var;};
		// caste presets
	if (blood.startsWith("RR")) {var="ddIiDdxXpPMmCcAA";}; //Maroon
	if (blood.startsWith("Rr")) {var="ddIiDdxfpPmMCcQA";};
	if (blood.startsWith("rr")) {var="ddIiDdaXpPMmCcAA";}; // Bronze
	if (blood.startsWith("Rg")) {var="ddIidDnXpPMmCcAA";};
	if (blood.startsWith("RG")) {var="ddIiDdXxPpMmCcAU";}; // Gold
	if (blood.startsWith("Gr")) {var="ddIiDdfXpPMmCcAA";};
	if (blood.startsWith("rg")) {var="ddIiDdxXpPMmCcAA";}; // Lime
	if (blood.startsWith("GG")) {var="ddIiDdfXpPMmCcAA";}; // Olive
	if (blood.startsWith("Gg")) {var="dDIidDXnpPMmCcAA";};
	if (blood.startsWith("gg")) {var="DDIiDDxXPpMmCcAA";}; // Jade
	if (blood.startsWith("Gb")) {var="DdIidDfXpPMmCcAA";};
	if (blood.startsWith("GB")) {var="ddIiDdnXPpMmCcAA";}; // Teal
	if (blood.startsWith("Bg")) {var="ddIiDdxnpPmMCcAA";};
	if (blood.startsWith("gb")) {var="ddIiDdnXpPMmCcAA";}; // Ceru
	if (blood.startsWith("BB")) {var="ddIiDdxXpPMmCcAA";}; // Bloo
	if (blood.startsWith("Bb")) {var="ddiIDdnxpPmMcCAA";};
	if (blood.startsWith("bb")) {var="ddIiDdXxpPMMCcAA";}; //Indigo
	if (blood.startsWith("Br")) {var="ddiIDdxfpPmMCcAA";};
	if (blood.startsWith("RB")) {var="ddIiDdXxpPMmCcAA";}; //Violet
	if (blood.startsWith("Rb")) {var="ddxxDdxapPmMCcAA";};
	if (blood.startsWith("rb")) {var="ddIiDdnxpPMmCcAR";}; //Tyrian
	// other presets
	if (blood.startsWith("normal1"))     {var="ddIiDdXXpPMmCcAA";};
	if (blood.startsWith("normal2"))     {var="ddiIdDxxPpmMcCAA";};
	if (blood.startsWith("day"))         {var="DDIiDdxXPpMmCcAA";};
	if (blood.startsWith("crosseye"))    {var="ddiiDdXxPpMmCcAA";};
	if (blood.startsWith("staring"))     {var="ddxxDdxXPpMmCcAA";};
	if (blood.startsWith("nearsight"))   {var="ddIiDdNNPpMmCcAA";};
	if (blood.startsWith("farsight"))    {var="ddIiDdFFPpMmCcAA";};
	if (blood.startsWith("astigmatism")) {var="ddIiDdAAPpMmCcAA";};
	if (blood.startsWith("infra+ultra")) {var="ddIiDdxXPpMmRUAA";};
	if (blood.startsWith("BBB")) {var="ddiIdDxNPpmMCcBB";};
	if (blood.startsWith("CCC")) {var="ddIiDdaxPpMmCcCC";};
	if (blood.startsWith("DDD")) {var="ddiIdDxAPpmMccDD";};
	if (blood.startsWith("EEE")) {var="ddIiDdFxPpMmCcEE";};
	if (blood.startsWith("FFF")) {var="ddiIdDXxPpmMccFF";};
	if (blood.startsWith("GGG")) {var="ddIiDdxnPpMmCcGG";};
	if (blood.startsWith("HHH")) {var="ddiIdDxFPpmMRcHH";};
	if (blood.startsWith("III")) {var="ddiIdDxxPpmMCcII";};
	if (blood.startsWith("JJJ")) {var="ddIiDdfXPpMmCcJJ";};
	if (blood.startsWith("KKK")) {var="ddiIdDxXPpmMcCKK";};
	if (blood.startsWith("LLL")) {var="ddIiDdaXPpMmCcLL";};
	if (blood.startsWith("MMM")) {var="ddiIdDxXPpmMCcMM";};
	if (blood.startsWith("NNN")) {var="ddIiDdxnPpMmCcNN";};
	if (blood.startsWith("OOO")) {var="ddiIdDAXPpmMcUOO";};
	if (blood.startsWith("PPP")) {var="ddiIdDxfPpmMCcPP";};
	if (blood.startsWith("QQQ")) {var="ddIiDdNXPpMmCcQQ";};
	if (blood.startsWith("RRR")) {var="ddiIdDxaPpmMCcRR";};
	if (blood.startsWith("SSS")) {var="ddIiDdnXPpMmCcSS";};
	if (blood.startsWith("TTT")) {var="ddiIdDxxPpmMCcTT";};
	if (blood.startsWith("UUU")) {var="ddIiDdXfPpMmCcUU";};
	if (blood.startsWith("VVV")) {var="ddiIdDxXPpmMCcVV";};
	if (blood.startsWith("WWW")) {var="ddiIdDxaPpmMCcWW";};
	if (blood.startsWith("XXX")) {var="ddIiDdnXPpMmCcXX";};
	if (blood.startsWith("YYY")) {var="ddiIdDXaPpmMCcYY";};
	if (blood.startsWith("ZZZ")) {var="ddIiDdxfPpMmCcZZ";};
        // nontroll 
	if (blood.startsWith("human")) {var="DDIiddxxPpMmCcAA";};
	if (blood.startsWith("fae"))   {var="DDIqddQQPpMmCcAA";};
        
	return var;
	}

// descriptive zone
	
	public String wholisticdescription(Eye i) {
 		Random rand = new Random();
		String var = new String("");

		// figure out which eyes are active
		String   num    =  i.control.substring(0,2);  // NN, SS, MM
		String   place  =  i.control.substring(2,4);  // 2char = (LRGNnFBT) + (LRGNn)
		
		// set them based on the individual eyegenes
		boolean eye1 = false; String e1 = i.lefteye.substring(0,2);  if (e1!="ee") {eye1=true;}  
		boolean eye2 = false; String e2 = i.righteye.substring(0,2); if (e2!="ee") {eye2=true;}
		boolean eye3 = false; String e3 = i.strayeye.substring(0,2); if (e3!="ee") {eye3=true;}
		
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
