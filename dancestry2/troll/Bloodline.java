package troll;
import troll.fluff.*;
import troll.husk.*;
import java.util.Random;
@SuppressWarnings("unused")

    // This is going to be complicated and need a lot of rethinking.

public class Bloodline {
	public String sign = new String("");	
	public String aspect = new String("");	
	public String blood = new String("");	
	public String color = new String("");	
	public Body body;
	public Horns horns;
	public Stats stats;	
	
	// horndesc must match but the rest of the gene details are meh
	// expressed bodytype must match (normal seadweller, normal land dweller, nonferal, etc) but details are fine
	// 
	
	public Bloodline(Troll t) {
		sign = t.name.signname;
		aspect = t.stats.aspect;
		blood = t.blood.code;
			color = t.blood.color;
		horns = t.horns;  // yes, the entire horns.
		body = t.body;    // yup, entire body
		stats = pickstats(t.stats, t.stats.aspect);
                // interests and strife have 50% of matching ancestor, 25% swap for same category, 25% all new
	}

	
	public Stats pickstats(Stats in, String asp) {
		Random rand = new Random();
		// make a copy of the stats
		Stats out = new Stats("");
		out = in;
		// randomly reassign classpect stats
		out.faith = rand.nextInt(20) - 10;		// +rage  -hope
		out.order = rand.nextInt(20) - 10;		// +life  -doom
		out.entropy = rand.nextInt(20) - 10;	// +time  -space
		out.connection = rand.nextInt(20) - 10;	// +blood -breath
		out.self = rand.nextInt(20) - 10;		// +mind  -heart
		out.opportunity = rand.nextInt(20) - 10;// +light -void
		// find how high is highest
		int max = Math.abs(out.faith);
		if (Math.abs(out.order)>max)       {max=Math.abs(out.order);};
		if (Math.abs(out.entropy)>max)     {max=Math.abs(out.entropy);};
		if (Math.abs(out.connection)>max)  {max=Math.abs(out.connection);};
		if (Math.abs(out.self)>max)        {max=Math.abs(out.self);};
		if (Math.abs(out.opportunity)>max) {max=Math.abs(out.opportunity);};
		// set the right thing to one more than that
		max = max + 1;
		if (aspect=="Rage")  {out.faith=max;};
		if (aspect=="Life")  {out.order=max;};
		if (aspect=="Blood") {out.connection=max;};
		if (aspect=="Mind")  {out.self=max;};
		if (aspect=="Light") {out.opportunity=max;};
		if (aspect=="Time")  {out.entropy=max;};
		// ...or, you know.  The negative versions.
		max = 0 - max;
		if (aspect=="Hope")   {out.faith=max;};
		if (aspect=="Doom")   {out.order=max;};
		if (aspect=="Breath") {out.connection=max;};
		if (aspect=="Heart")  {out.self=max;};
		if (aspect=="Void")   {out.opportunity=max;};
		if (aspect=="Space")  {out.entropy=max;};

		out.clout    = out.clout    + rand.nextInt(3)-1; // -1, 0, 1
		out.grit     = out.grit     + rand.nextInt(3)-1; // -1, 0, 1
		out.alacrity = out.alacrity + rand.nextInt(3)-1; // -1, 0, 1
		out.resolve  = out.resolve  + rand.nextInt(3)-1; // -1, 0, 1
		out.acumen   = out.acumen   + rand.nextInt(3)-1; // -1, 0, 1
		out.hunch    = out.hunch    + rand.nextInt(3)-1; // -1, 0, 1
		out.moxie    = out.moxie    + rand.nextInt(3)-1; // -1, 0, 1
		
		if (out.clout<1) {out.clout=1;};
		if (out.grit<1) {out.grit=1;};
		if (out.alacrity<1) {out.alacrity=1;};
		if (out.resolve<1) {out.resolve=1;};
		if (out.acumen<1) {out.acumen=1;};
		if (out.hunch<1) {out.hunch=1;};
		if (out.moxie<1) {out.moxie=1;};
		
		return out;
	}
}
