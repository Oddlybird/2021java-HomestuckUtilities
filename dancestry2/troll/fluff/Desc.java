package troll.fluff;
import troll.husk.*;
import java.awt.Color;
@SuppressWarnings("unused")

public class Desc {

	public Desc() {
		// TODO Auto-generated constructor stub
	}
	
	// Not working.
	public static String build(String code) {
		while (code.length()<6) {code=code+"5";};
		
		char[] a = code.toCharArray();
		
		int shoulder = a[0];   // numbers between 0 and 9, averaging 3-5
		int chest    = a[1];
		int waist    = a[2];
		int hip      = a[3];
		int butt     = a[4];
		int bulk     = a[5];
		
		String txt = new String("");
		// bulk
		if ((bulk>7)||(bulk<3)) {txt=txt+"very ";};
		if (bulk>6) {txt=txt+"big ";};
		if (bulk<4) {txt=txt+"small ";};
		// chest
		if (chest<4) {txt = txt+"flat-chested, ";};
		if ((chest>6)&&(butt<6)) {txt = txt+"large-chested, ";};
		if ((chest>6)&&(butt>5)) {txt = txt+"curvaceous, ";};
		// bodyshape (apple, dorito, rectangle, hourglass, pear)
		boolean sw = false; if (shoulder>waist) {sw=true;};
		boolean hs = false; if (hip>shoulder)   {hs=true;};
		boolean hw = false; if (hip>waist)      {hw=true;};
		boolean cont = true;
		if ((!sw)&&(!hw)&&(cont)) {txt = txt + "apple-shaped build";     cont=false;};
		if ((!hs)&&(!hw)&&(cont)) {txt = txt + "dorito-shaped build";    cont=false;};
		if ((sw)&&(hw)&&(cont))   {txt = txt + "hourglass-shaped build"; cont=false;};
		if ((hs)&&(hw)&&(cont))   {txt = txt + "pear-shaped build";      cont=false;};
		if (cont)                 {txt = txt + "rectangular build";      cont=false;};
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
	
	
	// not working.
	public static String respirate(String code) {
		String txt = new String("");
		String control  = code.substring(0,4);
		String bladders = code.substring(4,6);
		String gilleyes = code.substring(6,10);
		String gillneck = code.substring(10,14);
		String gillribs = code.substring(10,14);
		String water = code.substring(14,20);
		String air = code.substring(20);
		boolean cont = true;
		boolean skiptodone = false;
		
		// new segment.  Bladders.
			cont = true;
			while ((!skiptodone)&&(cont)) {
			txt = txt + Gene.permute(bladders, "B", "b", "many", "several", "one", "no");
			txt = txt + " air bladders, ";
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
				txt = txt + "no gills, "; cont=false;}
			
			if (!gill1.startsWith("no")) {txt = txt + gill1 + "eye gills, ";};
			if (!gill2.startsWith("no")) {txt = txt + gill2 + "neck gills, ";};
			if (!gill3.startsWith("no")) {txt = txt + gill3 + "rib gills, ";};
			cont=false;
			};	
			
		// new segment.
		cont = true;
		while ((!skiptodone)&&(cont)) {
			txt = txt + "breathes ";
			txt = txt + Gene.permute(water.substring(0,2), "S", "s", "salt, ", "salt, ", "salt, ", "");
			txt = txt + Gene.permute(water.substring(2,4), "B", "b", "brack, ", "brack, ", "brack, ", "");
			txt = txt + Gene.permute(water.substring(4,6), "F", "f", "fresh, ", "fresh, ", "fresh, ", "");
			
			String temp = Gene.permute(air.substring(0,2), "A", "a", "2", "1", "1", "0");
			temp = temp + Gene.permute(air.substring(2,4), "A", "a", "2", "1", "1", "0");
			if ((temp=="21")||(temp=="12")||(temp=="22")) {txt = txt + "air";}; //AAAa
			if ((temp=="11")||(temp=="20")||(temp=="02")) {txt = txt + "air";}; //AAaa
			if ((temp=="01")||(temp=="10")) {txt = txt + "some air";}; //Aaaa
			if ((temp=="00")||(temp=="00")) {txt = txt + "no air";}; //aaaa
			cont=false;
			};			
			
			// Control + Severe Asthma zone.
			cont = true;
			while ((!skiptodone)&&(cont)) {
				if (control=="SSSS") {txt="normal sea respiration";  skiptodone=true;};
				if ((control=="SSSs")||(control=="SSsS")||(control=="SsSS")||(control=="sSSS")) {txt="normal sead respiration"; skiptodone=true;};
				if (control=="ssss") {txt="normal land respiration"; skiptodone=true;};
				if ((control=="Ssss")||(control=="sSss")||(control=="ssSs")||(control=="sssS")) {
					if (air=="aaaa") {txt="nonviable land, can't breathe"; skiptodone=true;};
					if ((air=="Aaaa")||(air=="aAaa")||(air=="aaAa")||(air=="aaaA")) {txt="asthmatic landdweller, " + txt; cont=false;};
					if (cont==true) {txt="normal landdweller, " + txt;};
					};
				cont=false;
				};

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
