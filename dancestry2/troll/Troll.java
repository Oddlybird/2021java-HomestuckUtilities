package troll;
import java.util.Arrays;

import troll.fluff.*;
import troll.husk.*;

@SuppressWarnings("unused")

// things to add: 

// TODO Change horn direction to be along 3 axes
// TODO move all descriptions to desc
// - - - - - TODO - and make them Work.

// TODO: bloodlines. Make sign name respect bloodlines.

// -: additional calcinous or bioluminescent or finlike formations, in new skin section of body feature
// -: organsystems, 
// -: internal headcanon differences (reproductive, other),
// -: genetic diseases/syndromes/mutations

//face structure, eye hollowness/bug-eyed, chin, nose, eyebrows, eyelashes
//-: muzzles? thickness / length, mouth wideness?
//"hair": {"back": "", "mid": "", "line": "", "front": ""},
//mouth
/*
        "jawline": "",
        "cheek": "",
        "chin": "",
        "eyebrow": "", 
        "eyeshape": "",
        "eyelash": ""
 */

// psychic powers, voodoo, eldritch, clowns voodoo, seadwellers eldritch
// -- strength of power based on stats.psyche (0-6)
// -- power specifics can be influenced by interests, element, and physical/mental stats
// -- element : describe abilities with a Spell School, Domain, or Pokemon Type?

// biolum: psychic eyes glow, rainbow drinker skin glows after death, seadwellers glow various times

// title.
// fae and human names

// gender


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
	
	// Keep a list of what each trait is Expected to look like, and describe differences from standards
	
	public Troll(String incode) {
		// these two are down here so we can use methods in just this constructor specifically
		Strife speccy = new Strife();
		Interests hobby = new Interests();
		Element ella = new Element();

		
		name = new Name(incode);
		blood = new Blood(incode); 		
                // set incode to "rand" to randomize bloodcode, "blank" to make blank troll
		String[] secretpasswords = {"blank", "truerand", "human", "fae"};
		
		if (Arrays.asList(secretpasswords).contains(incode)||Gene.ishum(incode)||Gene.isfae(incode)) {
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
                desc = new Desc(body, horns, eyes, stats);
                
	}
        
}
