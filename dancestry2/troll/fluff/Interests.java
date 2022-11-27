package troll.fluff;
import java.util.Random;
@SuppressWarnings("unused")

public class Interests {
	
	String[] interest = {"games", "videogames", "sports", "gambling", "science", "biology", "geology",
			"botany", "archaeology", "paleontology", "history", "psychology", "crafting", "programming",
			"cooking", "writing", "engineering", "robotics", "art", "literature", "knickknacks",
			"collectibles", "the esoteric", "grimdark arts", "psychic", "cryptids", "conspiracies",
			"meta", "nature", "animals", "plants", "geography", "life", "physicality", "exercise",
			"war", "frivolity", "death", "computers", "machines", "chaos", "apocalypses", "math", 
			"physics", "chemistry", "photography", "treasure", "fungi", "bugs", "fish", "birds",
			"miniatures", "dolls", "weaponry", "armor", "stage magic", "slight of hand", "costuming",
			"sewing", "needlecraft", "glassworking", "strategy", "card games", "board games",
                        "mythology", "puppets", "robots", 
                        };

	String[] manipulation = {"games", "videogames", "sports", "gambling", "frivolity", "exercise",
			"stage magic", "strategy", "war", "card games", "board games", "puppets"};
	
	String[] knowledge = {"science", "biology", "geology", "botany", "archaeology", "paleontology", 
			"history", "psychology", "math", "physics", "chemistry", "geography", "the esoteric", 
			"grimdark arts", "psychic", "cryptids", "conspiracies", "meta", "statistics", 
                        "mythology", };
	
	String[] creation = {"crafting", "programming", "cooking", "writing", "engineering", "robotics", 
			"art", "literature", "photography", "costuming", "sewing", "needlecraft", "glassworking",
                        "puppets", "robots", };
	
	String[] reallocation = {"knickknacks", "collectibles", "treasure", "miniatures", "dolls",
			"weaponry", "armor", "stage magic", "slight of hand"};
	
	String[] exploitation = {"photography", "art", "film", "literature", "meta", "mythology", "physicality",
                        "dolls", "puppets", "robots", "stage magic", "the esoteric"};
	
	String[] nature = {"nature", "animals", "plants", "fungi", "life", "bugs", "fish", "birds"};
	
	String[] destruction = {"war", "death", "chaos", "apocalypses", "physicality", "videogames", 
                        "sports", "frivolity", "weaponry", };

	public Interests() {
		// stats contains: 
		//---- clout, grit, alacrity, hunch, acumen, resolve, moxie, psyche
		//---- faith, order, entropy, connection, self, opportunity
		//---- activity, exploit, move, know, manip, create, destroy
		// - - aspect, role
	}

	public String[] getinterests(Stats stats) {
		boolean cont = true;
		int ind = 0;
 		Random rand = new Random();
		String var = new String("");
		String[] product = {"","",""};
		String[] type = {"", "", ""};

		if ((stats.activity>25)&&(ind<3)&&(rand.nextBoolean()))   {type[ind]="destruction"; ind++;}
		if ((stats.activity<-25)&&(ind<3)&&(rand.nextBoolean()))  {type[ind]="nature";      ind++;}

		if ((stats.create>25)&&(ind<3)&&(rand.nextBoolean()))     {type[ind]="creation";     ind++;}
		if ((stats.know>25)&&(ind<3)&&(rand.nextBoolean()))       {type[ind]="knowledge";    ind++;}
		if ((stats.move>25)&&(ind<3)&&(rand.nextBoolean()))       {type[ind]="reallocation"; ind++;}
		if ((stats.manip>25)&&(ind<3)&&(rand.nextBoolean()))      {type[ind]="manipulation"; ind++;}
		if ((stats.exploit>25)&&(ind<3)&&(rand.nextBoolean()))    {type[ind]="exploitation"; ind++;}

		if ((stats.create>17)&&(ind<3)&&(rand.nextBoolean()))     {type[ind]="creation";     ind++;}
		if ((stats.destroy>17)&&(ind<3)&&(rand.nextBoolean()))    {type[ind]="destruction";  ind++;}
		if ((stats.know>17)&&(ind<3)&&(rand.nextBoolean()))       {type[ind]="knowledge";    ind++;}
		if ((stats.move>17)&&(ind<3)&&(rand.nextBoolean()))       {type[ind]="reallocation"; ind++;}
		if ((stats.manip>17)&&(ind<3)&&(rand.nextBoolean()))      {type[ind]="manipulation"; ind++;}
		if ((stats.exploit>17)&&(ind<3)&&(rand.nextBoolean()))    {type[ind]="exploitation"; ind++;}
		
		
		// Pick the first one
		product[0] = fromkey(type[0]);
		
		// If empty, pick a Unique second one
		if (product[1]=="") {
			while (cont) {
				product[1] = fromkey(type[1]);
				if (product[1]!=product[0]) {cont=false;};
			};
		};

		// if empty, pick a Unique third one
		cont = true;
		if (product[2]=="") {
			while (cont) {
				product[2] = fromkey(type[2]);
				if ((product[2]!=product[0])&&(product[2]!=product[1])&&(product[2]!="")) {cont=false;};
			};
		};
		
		// return em
		return product;
	}
	
	public String fromkey(String key) {
		Random rand = new Random();
		String var = new String("");
		if (key=="") {var = interest[rand.nextInt(interest.length)];};
		if (key=="manipulation")  {var = manipulation[rand.nextInt(manipulation.length)];};
		if (key=="knowledge")     {var = knowledge[rand.nextInt(knowledge.length)];};
		if (key=="creation")      {var = creation[rand.nextInt(creation.length)];};
		if (key=="reallocation")  {var = reallocation[rand.nextInt(reallocation.length)];};
		if (key=="exploitation")  {var = exploitation[rand.nextInt(exploitation.length)];};
		if (key=="nature")        {var = nature[rand.nextInt(nature.length)];};
		if (key=="destruction")   {var = destruction[rand.nextInt(destruction.length)];};
		return var;
	}
	
}
