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
	public Eye eyes;
	// fluff
	public Name name;	
	public Stats stats;
	public String[] interests;
	public String specibus; 
	public String weapon;
	public String element; 
        public Desc desc;
	
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
			eyes = new Eye(incode);
			} else {
			stats = new Stats(blood.code);	// stats based on bloodcode
			body  = new Body(blood.code);   // bodyshape...
			horns = new Horns(blood.code);  // rack of horns
			eyes = new Eye(blood.code);	
			}
		
		element =    ella.getelement("any");
		interests = hobby.getinterests(stats);
		specibus = speccy.getstrifespecial(interests, stats);
		weapon = speccy.getweapon(specibus);
                // fill out the description...
                desc = describe(body, horns, eyes, stats);
                
	}

        // the place to update when you want to redescribe things
        public troll.fluff.Desc describe(troll.husk.Body body, troll.husk.Horns horns, troll.husk.Eye eyes, troll.fluff.Stats stats) {
            Desc description = new Desc(body, horns, eyes, stats);
            return description;
        }

        // can I move horn and eye descriptions into Desc?
        
}

// things to add: 


// TODO Change horn direction to be along 3 axes
// TODO put descriptions in desc
// - - - - - TODO - and make them Work.

// TODO: bloodlines. Make sign name respect bloodlines.

// -: additional calcinous or bioluminescent or finlike formations, in new skin section of body feature

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
// psychic eyes glow, rainbow drinker skin glows after death, seadwellers glow various times
// clowns voodoo, seadwellers eldritch
// trolls with red genes are inclined to all powers, including physical
// trolls with blue and green genes are inclined to mental / emotive / sensory

// title.

// gender





