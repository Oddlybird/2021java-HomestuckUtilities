package troll.husk;
import java.util.Random;
import java.util.Arrays;
import com.google.gson.Gson; // java obj <-> JSON string
// Contains a set of horns and how they interact
@SuppressWarnings("unused")

	// TODO: notches/holes description
	// TODO: full malformation gene + description

public class Horns {
	// the genetics that are doing all the heavy lifting
	public Horn rgene;
	public Horn lgene;

	public String form;	// Balances out fuckery.  Unless it doesn't.
	// 2char: Hh Hh : place 
	// 2char: Hh Hh : dir
	// 2char: Hh Hh : curlen
	// 2char: Hh Hh : radial
	// 2char: Hh Hh : tip
	// 2char: Hh Hh : Ang
	
	// 4char: Dd Nn Xx - horn doubling, normal horn, forcing a horn to be recessive / unexpressed
	//        to interpret: starts with DD Dd dD = double left, ends with DD Dd dD= double right.
	// end-of-alphabet letters are all fine except X
	// Aa: withered
	// Bb: stunted/nubs
        // Dd: doubled
	
	// 4char: Kk Ee Aa Pp Bb Tt - keratin, electrosensory, sheddable antler, power-regulating, balance, temperature regulating

	
	// ?char: CEJLNSU / XYZ.
	/* .......X..: Growing in unsafe directions that could impact skin or horn (if length/direction/curliness allows)
            C/E/J/L/N/S/U are safe.  XYZ is not.
            To be in danger, must have appropriate wrong gene, *and* horns shaped in a way that can impact.
     0      - spiraling: treat curl as 1 greater than it actually is.
            - All Curl > 5
            - Inward, with curl > 2 and length > 1.
            - Back direction, curl > 1, length > 1.
            - side + wide = ear deformity
            - front + wide = forehead deformity
            - Side + in = mild skull deformities.
	 */	
	
	// What the horns actually Look like, after formgene has epigenetic'd the shit out of them 
	// Use these as a middle stage, to convert to a text description.
	// Eventually move them inside the Horns method / non-public.
	public String DirPoint;   // direction/waggle

        // this is the final step of horn creation, which changes both horn genes
        // it is not a descriptive function.
	public void horncalc(String blood, Horn rgene, Horn lgene, String form) {
 		Gson gson = new Gson();
		Random rand = new Random();
		boolean blank = false;
		if (blood=="blank") {blank=true;};		

		String gauge = "";
		Horn R = new Horn("blank");
		Horn L = new Horn("blank");
		
		if(!blank) {
		
			// lastly, time to see which genes express 
			// --------------------PLACEMENT------------------------ //
			// Placegene
			gauge = "";
			gauge = form.substring(0,2);
			if (gauge.startsWith("HH")) {
                            R.Placegene=Gene.mutiBlend(rgene.Placegene, lgene.Placegene, rgene.Placegene); L.Placegene=R.Placegene;
                            if (rand.nextBoolean()) {L.Placegene=Gene.mutiBlend(lgene.Placegene, rgene.Placegene, lgene.Placegene); R.Placegene=L.Placegene;};
                            };
			if (gauge.startsWith("Hh")) {L.Placegene = lgene.Placegene;R.Placegene = lgene.Placegene;};
			if (gauge.startsWith("hH")) {L.Placegene = rgene.Placegene;R.Placegene = rgene.Placegene;};
			if (gauge.startsWith("hh")) {L.Placegene = lgene.Placegene;R.Placegene = rgene.Placegene;};

			// -------------------DIRECTION------------------------- // 		
			// Dirgene
			gauge = "";
			gauge = form.substring(2,4);
			if (gauge.startsWith("HH")) {R.Dirgene=Gene.mutiBlend(rgene.Dirgene, lgene.Dirgene, rgene.Dirgene); L.Dirgene=R.Dirgene;
				if (rand.nextBoolean())   {L.Dirgene=Gene.mutiBlend(lgene.Dirgene, rgene.Dirgene, lgene.Dirgene); R.Dirgene=L.Dirgene;};};
			if (gauge.startsWith("Hh")) {L.Dirgene = lgene.Dirgene;R.Dirgene = lgene.Dirgene;};
			if (gauge.startsWith("hH")) {L.Dirgene = rgene.Dirgene;R.Dirgene = rgene.Dirgene;};
			if (gauge.startsWith("hh")) {L.Dirgene = lgene.Dirgene;R.Dirgene = rgene.Dirgene;};
                        // edit this so horns can point different directions and l.dirgene gets used at all
			DirPoint = R.dirpoint(R.Dirgene);

			// -------------------------------------------- // 		
			// Curlengene
			gauge = "";
			gauge = form.substring(4,6);
			if (gauge.startsWith("HH")) {R.Curlengene=Gene.mutiBlend(rgene.Curlengene, lgene.Curlengene, rgene.Curlengene); L.Curlengene=R.Curlengene;
				if (rand.nextBoolean())   {L.Curlengene=Gene.mutiBlend(lgene.Curlengene, rgene.Curlengene, lgene.Curlengene); R.Curlengene=L.Curlengene;};};
			if (gauge.startsWith("Hh")) {L.Curlengene = lgene.Curlengene;R.Curlengene = lgene.Curlengene;};
			if (gauge.startsWith("hH")) {L.Curlengene = rgene.Curlengene;R.Curlengene = rgene.Curlengene;};
			if (gauge.startsWith("hh")) {L.Curlengene = lgene.Curlengene;R.Curlengene = rgene.Curlengene;};
				// set them
				R.Curlengene = Gene.mutiBlend(rgene.Curlengene, lgene.Curlengene, rgene.Curlengene);
				L.Curlengene = Gene.mutiBlend(rgene.Curlengene, lgene.Curlengene, lgene.Curlengene);
				// average them again
				R.Curlengene = Gene.mutiBlend(R.Curlengene, L.Curlengene, R.Curlengene);
				L.Curlengene = Gene.mutiBlend(R.Curlengene, L.Curlengene, L.Curlengene);
			

			// -----------------RADIAL CROSSECTION---------------- // 		
			// Radgene
			gauge = "";
			gauge = form.substring(6,8);
			if (gauge.startsWith("HH")) {R.Radialgene=Gene.mutiBlend(rgene.Radialgene, lgene.Radialgene, rgene.Radialgene); L.Radialgene=R.Radialgene;
				if (rand.nextBoolean())   {L.Radialgene=Gene.mutiBlend(lgene.Radialgene, rgene.Radialgene, lgene.Radialgene); R.Radialgene=L.Radialgene;};};
			if (gauge.startsWith("Hh")) {L.Radialgene = lgene.Radialgene;R.Radialgene = lgene.Radialgene;};
			if (gauge.startsWith("hH")) {L.Radialgene = rgene.Radialgene;R.Radialgene = rgene.Radialgene;};
			if (gauge.startsWith("hh")) {L.Radialgene = lgene.Radialgene;R.Radialgene = rgene.Radialgene;};

			// -----------------------TIPS--------------------- // 		
			// Tipgene
			gauge = "";
			gauge = form.substring(8,10);
			// if both same dominance, unique tips
			if ((gauge.startsWith("HH"))||(gauge.startsWith("hh"))) {R.Tipgene=rgene.Tipgene; L.Tipgene=lgene.Tipgene;}
			// if different dominance, overwrite.
			if (gauge.startsWith("Hh")) {R.Tipgene=lgene.Tipgene; L.Tipgene=lgene.Tipgene;};
			if (gauge.startsWith("hH")) {R.Tipgene=rgene.Tipgene; L.Tipgene=rgene.Tipgene;};
 		
			// ---------------------ANGULARITY----------------------- // 		
			// Anggene
			gauge = "";
			gauge = form.substring(10,12);
			// if both same dominance, unique 
			if (gauge.startsWith("HH")) {R.Anggene=Gene.mutiBlend(rgene.Anggene, lgene.Anggene, rgene.Anggene); L.Anggene=R.Anggene;
				if (rand.nextBoolean()) {L.Anggene=Gene.mutiBlend(lgene.Anggene, rgene.Anggene, lgene.Anggene); R.Anggene=L.Anggene;};};
			if (gauge.startsWith("Hh")) {R.Anggene=lgene.Anggene; L.Anggene=lgene.Anggene;};
			if (gauge.startsWith("hH")) {R.Anggene=rgene.Anggene; L.Anggene=rgene.Anggene;};
			if (gauge.startsWith("hh")) {R.Anggene=rgene.Anggene; L.Anggene=lgene.Anggene;}
		}
 		// Here's the stuff that matters later.
 		// ------------------NUMERACY-------------------- // 		
		// horn (DD Dd dD) doubling, (AA Aa aA) withering, (BB Bb bB)stunting/nubs
 		gauge = "";
		gauge = form.substring(12,16);
		String numeracyRight = numeracy(form.substring(12,14));
		String numeracyLeft = numeracy(form.substring(14,16));
		
	}
	
	public Horns(String blood) {
		Horn R = new Horn("blank");
		Horn L = new Horn("blank");
		rgene = new Horn(blood);
		lgene = new Horn(blood);
		form = pickform(blood);
		horncalc(blood, rgene, lgene, form);
	}


	public String pickform(String blood){
		// 2char: Hh Hh : place 
		// 2char: Hh Hh : dir
		// 2char: Hh Hh : curlen
		// 2char: Hh Hh : radial
		// 2char: Hh Hh : tip
		// 2char: Hh Hh : Ang		
		// 4char: Dd Nn Xx - horn doubling, normal horn, forcing a horn to be recessive / unexpressed
		//        to interpret: starts with DD Dd dD = double left, ends with DD Dd dD= double right.
		// 			end-of-alphabet letters are all fine
		// 			Aa: withered
		// 			Bb: stunted/nubs
		// 4char: KEA - keratin, electrosensory, (sheddable) antler,
		//        PBT - power-regulating, balance-regulating, temperature regulating
 		Random rand = new Random();
		String var = new String("HHHHHHHHHHHHNNNNKEPB");
	if (blood=="truerand") {
		String[] Hh  = {"H", "h"};
		String[] Dnx = {"D", "d", "N", "n", "X", "x", "A", "a", "B", "b"};
		String[] KEA = {"K", "E", "A", "P", "B", "T"};
		var = Gene.randopt(Hh, 12) + Gene.randopt(Dnx, 4) + Gene.randopt(KEA, 4);
		return var;};
	if (blood=="blank") {return var;};
	if (blood=="rand") {
		String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
				"mut1", "mut2", "mut3", "mut4", "mut5", "mut6", "mut7", "mut8", "mut9",
				"perf"};
		blood = options[rand.nextInt(options.length)];
	} // end rand

	// caste presets
	if (blood.startsWith("RR"))   {var="HHhHHHHHHhHHIIIIKEPB";}; //Maroon
	if (blood.startsWith("Rr"))   {var="HHHhHhHHhHHHJjjJPBPE";};
	if (blood.startsWith("rr"))   {var="HHhHHHHHHhHHKKKKKEPB";}; // Bronze
	if (blood.startsWith("Rg"))   {var="HHHhHhHHhHHHddddPBPE";};
	if (blood.startsWith("RG"))   {var="HHhHHHHHHhHHDDDDKEPB";}; // Gold
	if (blood.startsWith("Gr"))   {var="HHHhHhHHhHHHddddPEPB";};
	if (blood.startsWith("rg"))   {var="HHhHhHHHHhHHlLLlKEPB";}; // Lime
	if (blood.startsWith("GG"))   {var="HHHHHHHHhHHHMMMMKEPB";}; // Olive
	if (blood.startsWith("Gg"))   {var="HHHhHHHHHhHHNnnNKEPB";};
	if (blood.startsWith("gg"))   {var="HHHHHHHHhHHHOOOOKEPB";}; // Jade
	if (blood.startsWith("Gb"))   {var="HHhHHhHHHhHHPppPBEPK";};
	if (blood.startsWith("GB"))   {var="HHHHHHHHhHHHQQQQKEPB";}; // Teal
	if (blood.startsWith("Bg"))   {var="HHhHHHHHHhHHRrrRBEPK";};
	if (blood.startsWith("gb"))   {var="HHHHHHHHhHHHSSSSKEPB";}; // Ceru
	if (blood.startsWith("BB"))   {var="HHHHhHHHHhHHTTTTKEPB";}; // Bloo
	if (blood.startsWith("Bb"))   {var="HHhHHHHHhHHHUuuUPEKB";};
	if (blood.startsWith("bb"))   {var="HHHHHHHHHhHHVVVVPEKB";}; //Indigo
	if (blood.startsWith("Br"))   {var="HHHhHHHHhHHHWwwWPEKB";};
	if (blood.startsWith("RB"))   {var="HHHHHHHHHhHHXXXXEEKB";}; //Violet
	if (blood.startsWith("Rb"))   {var="HHHHHHHHhHHHYyyYKEKB";};
	if (blood.startsWith("rb"))   {var="HHHHHHHHHhHHZZZZEEKB";}; //Tyrian
	
// 	other presets
	if (blood.startsWith("mut1")) {var="hHhhhhhhhHHHDDDDPPPP";};
	if (blood.startsWith("mut2")) {var="HhhhhHhhHhHHDDhhEEEE";};
	if (blood.startsWith("mut3")) {var="hHhhHhhhhHHHhhDDPPPP";};
	if (blood.startsWith("mut4")) {var="HhHhHhhhHhHHABABKKKK";};
	if (blood.startsWith("mut5")) {var="hHhHhHhhhHHHBbBbBBBB";};
	if (blood.startsWith("mut6")) {var="HhHhHhhhHhHHDdddTTTT";};
	if (blood.startsWith("mut7")) {var="HhhhhHhhhHHHdddDKAKA";};
	if (blood.startsWith("mut8")) {var="hHhhhHhhHhHHbdbdAKAK";};
	if (blood.startsWith("mut9")) {var="hHhHHhhhhHHHdadaTBTB";};
	if (blood.startsWith("perf")) {var="HHHHHHHHHHHHHHHHBTBT";};

	return var;
	}

	public String numeracy(String h) {
		// horn (DD Dd dD) doubling, (AA Aa aA) withering, (BB Bb bB)stunting/nubs 
		String a = "";
		if ((h.equals("DD"))||(h.equals("Dd"))||(h.equals("dD"))) {a="doubled";}; // doubled
		if ((h.equals("AA"))||(h.equals("Aa"))||(h.equals("aA"))) {a="odd";};     // clipping errors
		if ((h.equals("BB"))||(h.equals("Bb"))||(h.equals("bB"))) {a="stunted";}; // nubs
		if ((h.equals("XX"))||(h.equals("Xx"))||(h.equals("xX"))) {a="absent";};  // gone
		if (a.equals(""))     {a="normal";};
		return a;
	}

	public String htype(String form) {
		// 4char: KEA - keratin, electrosensory, (sheddable) antler,
		//        PBT - power-regulating, balance-regulating, temperature regulating
		String ht = "";
		boolean k=false;boolean e=false;boolean a=false;boolean p=false;boolean b=false;boolean t=false;
		int antlercounter = 0;

		for (int i=0; i<form.length(); i++) {
			if (form.charAt(i) == 'K') {k=true;} // blank, effectively
			if (form.charAt(i) == 'E') {e=true;}
			if (form.charAt(i) == 'A') {antlercounter++;}  // you need two to make it antleriffic.
			if (form.charAt(i) == 'P') {p=true;}
			if (form.charAt(i) == 'B') {b=true;}
			if (form.charAt(i) == 'T') {t=true;}
			}
		if (antlercounter>1) {a=true;};
		// adjective
		if (k&&!e&&!a&&!p&&!b&&!t) {ht = "plain ";}; // just k
		if (e) {ht = ht + "electrosensory ";};  // e
		// noun
		if (a) {ht = ht + "sheddable antlers ";};
		if (!a) {ht = ht + "keratin horns "
                        + "";};
		// regulatory
		if (p||b||t)   {ht=ht + "that regulate ";};
		if (p) 		   {ht=ht+ "powers";}
		if (p&&b) 	   {ht = ht + "/";};
		if (b) 	 	   {ht=ht+ "balance";}
		if (t&&(b||p)) {ht = ht + "/";};
		if (t) 		   {ht=ht+ "temperature";}

		return ht;
	}

	
	
}
