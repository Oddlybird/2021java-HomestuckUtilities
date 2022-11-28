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
		if (intxt == "rand")  {intxt = premadeBlood();};
		if (intxt.length()>3) {intxt = casteBlood(intxt);};
		code = intxt;
		caste = castefromcode(code);
		
		Color chroma = new Color(0,0,0);
		chroma = colorfromcode(intxt);
		color = "(" + chroma.getRed() + ", " + chroma.getGreen() + ", " + chroma.getBlue() + ")";
		
		hue = (int) huefromCode(intxt);	
		
		// TODO Auto-generated constructor stub
	}
	
	public String Getoneblood() {
		Random rand = new Random();
		int x = rand.nextInt(16); // numbers between 0 and 15
		String blood = "";
		if (x<5)             {blood="R";};
		if ((x>=5)&&(x<9))   {blood="r";};
		if ((x>=9)&&(x<12))  {blood="G";};
		if ((x>=12)&&(x<14)) {blood="g";};
		if ((x>=14)&&(x<15)) {blood="B";};
		if (x==15)           {blood="b";};		
		return blood;
	}
	
	public String premadeBlood() {
		Random rand = new Random();
		int x = rand.nextInt(16); // numbers between 0 and 15
		String blood = Getoneblood() + Getoneblood();

		blood = bloodsort(blood);
		
		if (x>12) {blood = blood + Getoneblood();};  // purposefully do not sort the last letter
		return blood;
	}

	public String casteBlood(String intxt) {
		// initialize
		Random rand = new Random();
		String blood = "";
		// if you don't understand, assign randomly.
		String[] options = {"RR","rr","RG","rg","GG","gg","GB","gb","BB","bb","RB","rb"};
		blood = options[rand.nextInt(options.length)];		
		// if you DO understand, ...
		if (intxt.toLowerCase()=="blank")    {blood="xx";};
		if (intxt.toLowerCase()=="maroon")   {blood="RR";};
		if (intxt.toLowerCase()=="burgundy") {blood="RR";};
		if (intxt.toLowerCase()=="bronze")   {blood="rr";};
		if (intxt.toLowerCase()=="brown")    {blood="rr";};
		if (intxt.toLowerCase()=="copper")   {blood="rr";};
		if (intxt.toLowerCase()=="gold")     {blood="RG";};
		if (intxt.toLowerCase()=="yellow")   {blood="RG";};
		if (intxt.toLowerCase()=="helm")     {blood="RG";};
		if (intxt.toLowerCase()=="lime")     {blood="rg";};
		if (intxt.toLowerCase()=="cull")     {blood="rg";};
		if (intxt.toLowerCase()=="olive")    {blood="GG";};
		if (intxt.toLowerCase()=="green")    {blood="GG";};
		if (intxt.toLowerCase()=="jade")     {blood="gg";};
		if (intxt.toLowerCase()=="matron")   {blood="gg";};
		if (intxt.toLowerCase()=="teal")     {blood="GB";};
		if (intxt.toLowerCase()=="cyan")     {blood="GB";};
		if (intxt.toLowerCase()=="cerulean") {blood="gb";};
		if (intxt.toLowerCase()=="skyblue")  {blood="gb";};
		if (intxt.toLowerCase()=="bloo")     {blood="BB";};
		if (intxt.toLowerCase()=="blue")     {blood="BB";};
		if (intxt.toLowerCase()=="navy")     {blood="BB";};
		if (intxt.toLowerCase()=="noble")    {blood="BB";};
		if (intxt.toLowerCase()=="indigo")   {blood="bb";};
		if (intxt.toLowerCase()=="clown")    {blood="bb";};
		if (intxt.toLowerCase()=="purple")   {blood="bb";};
		if (intxt.toLowerCase()=="violet")   {blood="RB";};
		if (intxt.toLowerCase()=="royal")    {blood="RB";};
		if (intxt.toLowerCase()=="fish")     {blood="RB";};
		if (intxt.toLowerCase()=="tyrian")   {blood="rb";};
		if (intxt.toLowerCase()=="imperial") {blood="rb";};
		if (intxt.toLowerCase()=="fuschia")  {blood="rb";};
		return blood;
	}
	
	public String bloodsort(String inblood) {
		char[] blood = inblood.toCharArray();
		String sortedBlood = ""; 		// output 
		
		for (char b : blood) {if (b=='R') {sortedBlood=sortedBlood + "R";};}
		for (char b : blood) {if (b=='G') {sortedBlood=sortedBlood + "G";};}
		for (char b : blood) {if (b=='B') {sortedBlood=sortedBlood + "B";};}
		for (char b : blood) {if (b=='r') {sortedBlood=sortedBlood + "r";};}
		for (char b : blood) {if (b=='g') {sortedBlood=sortedBlood + "g";};}
		for (char b : blood) {if (b=='b') {sortedBlood=sortedBlood + "b";};}
		
		return sortedBlood;
	}

	public Color colorfromcode(String incode) {
		
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
		
		// pure hues are brighter, between are duller.
		if (incode.length() == 2) {modifier="pure";};
		if (incode.length() > 2) {
			
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

	public double huefromCode(String inblood) {
		Color col = new Color(0,0,0);
		col = colorfromcode(inblood);
		float[] hsb = new float[3];
		hsb = Color.RGBtoHSB(col.getRed(),col.getGreen(), col.getBlue(), null);
		double hue = (double) hsb[0] * 360;
		return hue;		
	}
	
	public String castefromhue(double hue) {
		String caste = new String();
		caste = "CULL";
		if ((  0<=hue)&&(hue< 14)) {caste="Maroon";};
		if (( 14<=hue)&&(hue< 25)) {caste="Maroon/Bronze";};
		if (( 25<=hue)&&(hue< 37)) {caste="Bronze";};
		if (( 37<=hue)&&(hue< 48)) {caste="Bronze/Gold";};
		if (( 48<=hue)&&(hue< 75)) {caste="Gold";};
		if (( 75<=hue)&&(hue< 88)) {caste="Gold/Lime";};
		if (( 88<=hue)&&(hue<105)) {caste="Lime";};
		if ((105<=hue)&&(hue<118)) {caste="Lime/Olive";};
		if ((118<=hue)&&(hue<135)) {caste="Olive";};
		if ((135<=hue)&&(hue<148)) {caste="Olive/Jade";};
		if ((148<=hue)&&(hue<165)) {caste="Jade";};
		if ((165<=hue)&&(hue<178)) {caste="Jade/Teal";};
		if ((178<=hue)&&(hue<195)) {caste="Teal";};
		if ((195<=hue)&&(hue<208)) {caste="Teal/Cerulean";};
		if ((208<=hue)&&(hue<225)) {caste="Cerulean";};
		if ((225<=hue)&&(hue<238)) {caste="Cerulean/Blue";};
		if ((238<=hue)&&(hue<255)) {caste="Blue";};
		if ((255<=hue)&&(hue<268)) {caste="Blue/Indigo";};
		if ((268<=hue)&&(hue<285)) {caste="Indigo";};
		if ((285<=hue)&&(hue<298)) {caste="Indigo/Violet";};
		if ((298<=hue)&&(hue<315)) {caste="Violet";};
		if ((315<=hue)&&(hue<328)) {caste="Violet/Tyrian";};
		if ((328<=hue)&&(hue<345)) {caste="Tyrian";};
		if ((345<=hue)&&(hue<361)) {caste="Tyrian/Maroon";};
		// check if it's a vantas and return "CULL" if so
		// that would involve importing the pigment gene from husk.body : don't worry about it
		return caste;
	}
	
	public String castefromcode(String inblood) {
		double hue = huefromCode(inblood);
		String caste = "";
		caste = castefromhue(hue);
		return caste;
	}
	
}
