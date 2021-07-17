package troll;
import java.util.Arrays;

import troll.fluff.*;
import troll.husk.*;

@SuppressWarnings("unused")

public class Troll {
	// Husk
	public Blood blood;
	public Gene gene;  // This is only here so we can use methods from it.	
	public Body body;
	public Horns horns;
	public Eye eye;
	// fluff
	public Name name;	
	public Stats stats;
	public String[] interests;
	public String specibus; 
	public String weapon;
	public String element; 
	
	// Keep a list of what each caste is Expected to look like, and describe differences from standard
	
	public Troll(String incode) {
		// these two are down here so we can use methods, but it won't be included in the save.
		Strife speccy = new Strife();
		Interests hobby = new Interests();
		Element ella = new Element();

		
		name = new Name(incode);
		blood = new Blood(incode); 		// set incode to "rand" to randomize bloodcode.
										// "blank" to make blank troll
		String[] secretpasswords = {"blank", "truerand"};
		
		if (Arrays.asList(secretpasswords).contains(incode)) {
			stats = new Stats(incode);	// stats based on bloodcode
			body  = new Body(incode);   // bodyshape...
			horns = new Horns(incode);  // rack of horns
			eye = new Eye(incode);
			} else {
			stats = new Stats(blood.code);	// stats based on bloodcode
			body  = new Body(blood.code);   // bodyshape...
			horns = new Horns(blood.code);  // rack of horns
			eye = new Eye(blood.code);	
			}
		
		element =    ella.getelement("any");
		interests = hobby.getinterests(stats);
		//specibus = speccy.getstrife("");
		specibus = speccy.getstrifespecial(interests, stats);
		weapon = speccy.getweapon(specibus);
	}

	
}

// things to add: 


// TODO Change horn direction to be along 3 axes
// TODO put descriptions in desc
// - - - - - TODO - and make them Work.

// TODO: bloodlines. Make sign name respect bloodlines.

// -: additional calcinous or bioluminescent or finlike formations

// organsystems, internal headcanon differences (reproductive, other), genetic diseases/syndromes/mutations

//face structure, eye hollowness/bug-eyed, chin, nose, eyebrows, eyelashes
//-: muzzles? thickness / length, mouth wideness?
//"hair": {"back": "", "mid": "", "line": "", "front": ""},
//mouth
/*
        "jawline": "",
        "cheek": "",
        "chin": "",
        "eyebrow": "",  # Move all eye bits to a subgene?
        "eyeshape": "",
        "eyelash": ""
 */

// discolorations: hairstreaks, birthmarks, vitiligo, melanism, albinism, karkat
//      - Vantas color mutation, 3 letters long.  "X" sets that 1 color to 0, another sets a color to 255.
// -: horn color variations; lighter, darker, less redtone
// -: hair color variations; light/dark/blood/other
// -: blood color mutations
// -: skin color mutations
// albinism in trolls -> blood hue
// -: melanistic(blackhorn), leucistic(whitehorn), albinism

// psychic powers, voodoo, eldritch, etc
// psychic eyes glow, rainbow drinker skin glows after death, seadwerllers glow various times

// title.

// gender





