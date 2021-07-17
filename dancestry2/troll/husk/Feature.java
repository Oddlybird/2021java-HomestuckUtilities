package troll.husk;
import troll.fluff.Desc;
import java.util.Random;
@SuppressWarnings("unused")

// feral overrides: 
// -- weird pupils/eyes


public class Feature {
	public int heightinches = 0;
	public String thegene = "";

	
	public Feature(String blood) {
		// update it to have other arguments later
		Random rand = new Random();
		
		thegene = gene(blood);
			
		// TODO Auto-generated constructor stub
	}


	public String gene(String blood) {
		Random rand = new Random();
		String text = new String("");
		if (blood.startsWith("blank")) {text = "";return text;};
		text = Gene.mutiBlend(pickgene(blood), pickgene(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickgene("rand"));			
		return text;		
	}

	public String pickgene(String blood){
		Blood b = new Blood(blood);
 		Random rand = new Random();
 		String var = new String();
		var = "";
		// 2char: Ff - Feral override, 
		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
					"", "", "", "", "", "", "", "", "", ""};
			blood = options[rand.nextInt(options.length)];
		} // end rand
		// caste presets
	if (blood.startsWith("RR")) {var="";}; //Maroon
	if (blood.startsWith("Rr")) {var="";};
	if (blood.startsWith("rr")) {var="";}; // Bronze
	if (blood.startsWith("Rg")) {var="";};
	if (blood.startsWith("RG")) {var="";}; // Gold
	if (blood.startsWith("Gr")) {var="";};
	if (blood.startsWith("rg")) {var="";}; // Lime
	if (blood.startsWith("GG")) {var="";}; // Olive
	if (blood.startsWith("Gg")) {var="";};
	if (blood.startsWith("gg")) {var="";}; // Jade
	if (blood.startsWith("Gb")) {var="";};
	if (blood.startsWith("GB")) {var="";}; // Teal
	if (blood.startsWith("Bg")) {var="";};
	if (blood.startsWith("gb")) {var="";}; // Ceru
	if (blood.startsWith("BB")) {var="";}; // Bloo
	if (blood.startsWith("Bb")) {var="";};
	if (blood.startsWith("bb")) {var="";}; //Indigo
	if (blood.startsWith("Br")) {var="";};
	if (blood.startsWith("RB")) {var="";}; //Violet
	if (blood.startsWith("Rb")) {var="";};
	if (blood.startsWith("rb")) {var="";}; //Tyrian

	// other presets
	if (blood.startsWith("")) {var="";};
	if (blood.startsWith("")) {var="";};
	if (blood.startsWith("")) {var="";};
	if (blood.startsWith("")) {var="";};
	if (blood.startsWith("")) {var="";};

	return var;
	}


}
