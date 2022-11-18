package troll.fluff;
import java.util.Arrays;
import java.util.Random;
import troll.fluff.Tags
;
@SuppressWarnings("unused")


public class Name {
	public String hatchname = "";
	public String signname = "";
	public String trolltag = "";
	//String title = "";
	
	public Name(String intxt) {
		
		if (intxt.startsWith("blank")) {
			hatchname = "firnam";
			signname = "surnam";
			trolltag = "trollTag";
			return;};

		// Otherwise ... 
		hatchname = gen();
		signname = gen();
		trolltag = Tags.gethandle('?', '?');
		
	}	
	
	static public String gen() {
		Random rand = new Random();
		String[] structure = {
	    		"POFLOF", "POONON", "FOFFOL", "NOLFPO", "PONNOP", "FPOLLO", "FOPOLO", "PFOPOO", "FOPOPO", "FOLOPL",
	            "POPLON", "POLOFO", "OFPOPO", "OLOPOO", "POFLOF", "FOLLOP", "POLPOP", "PONOLO", "LOFOOF", "NOPONO",
	            "PONPLO", "POLPON", "PLONOP", "PLOPOF", "POPOLO", "FOLOOF", "FOOPOP", "PONNOP", "POLOPO", "LOPOPO",
	            "LOOPNL", "PONPFO", "POLONO", "NOPLOL", "FOLNOP", "PFOLOP", "NOPOPO", "NOPLON", "POPPOL", "FONPOF",
	            "NOPOPO", "NOPLON", "POPPOL", "FONPOF", "NOPFOF", "POPPOL", "PFOLON", "POLOPO", "POLPOL", "PONOOL",
	            "POLOOO", "LONOLO", "LONFFO", "PLONOO", "LONPOO", "POFOOF", "POPOLO", "POLONO", "POPOLO", "FPOLFO",
	            "NOLLOP", "OLLOLP", "OLPOPO", "LONOLO", "NOOLON", "POLLON", "LOPOLO", "OLONOO", "NOPOPO", "PONOOO",
	            "POLOFO", "FLOFPO", "NOOLFO", "PLOPOP", "POOFOO", "LONOPO", "OPONOL", "PONPOP", "FPOLPO", "OPOOPO",
	            "OLFONO", "PONPPO", "ONPOPP", "POLPOL", "POFONP", "POLPOP", "FOFOOP", "OPOLOF", "OLLOLP", "POLNOO",
	            "NONOOP", "LOOPON", "NOLOON", "POLOPO", "FOLPOP", "LOOPON", "NOLOON", "POLOPO", "FOLPOP", "POLPOF",
	            "NOFPOO", "ONOFOO", "POLOPF", "FOPLOF", "POLFON", "POOFLO", "PFOFOP", "NOLFOF", "POLOPO", "PLOFFO",
	            "OPOOOF", "FOLOFF", "POLLOF", "PONFOO", "PLONOF", "OLOPON", "OONOFO", "FOFOLO", "NOPPON", "PLOPOO",
	            "NOOLOF", "OLPOFN", "POPOFO", "POPOPP", "FOLOOL", "FOLOOL", "NOONOP", "POLOPO", "POOLOP", "POPFOF",
	            "FOFFOP", "NOPOLO", "ONPOLO", "POOPOF", "FOFFOP", "NOPOLO", "ONPOLO", "POOPOF", "LFOLON", "POOFOP"};
	    String struc = structure[rand.nextInt(structure.length)];
		char[] work = new char[6];
		work = struc.toCharArray();
		// work is now loaded with the structure we want, and is unique.
		// for each letter, replace it with an appropriate one.
		for (int i=0; i<6; i++) {
			if (work[i]=='P') {work[i]=getStop();};
			if (work[i]=='F') {work[i]=getAffricate();};
			if (work[i]=='L') {work[i]=getLiquid();};
			if (work[i]=='N') {work[i]=getNasal();};
			if (work[i]=='O') {work[i]=getVowel();};
		}
		// quality control
		work = qc(work);
		// capitalize
	    work[0] = Character.toUpperCase(work[0]);
	    // convert
		String name = new String("");
		name = String.valueOf(work);
		// bye!
		return name;
	}

	static char getStop() {
		Random rand = new Random();
		char[] options = {'p', 't', 'k', 'b', 'd', 'g', 'c', 'j'};
		char letter = options[rand.nextInt(options.length)];
		return letter;
	}

	static char getAffricate() {
		Random rand = new Random();
		char[] options = {'f', 's', 'z', 'v', 'h', 's', 'h', 'x'};
		char letter = options[rand.nextInt(options.length)];
		return letter;
	}

	static char getLiquid() {
		Random rand = new Random();
		char[] options = {'l', 'r', 'w', 'y'};
		char letter = options[rand.nextInt(options.length)];
		return letter;
	}

	static char getNasal() {
		Random rand = new Random();
		char[] options = {'n', 'n', 'm'};
		char letter = options[rand.nextInt(options.length)];
		return letter;
	}

	static char getVowel() {
		Random rand = new Random();
		char[] options = {'a', 'e', 'i', 'o', 'u'};
		char letter = options[rand.nextInt(options.length)];
		return letter;
	}

	static boolean isVowel(char suspect) {
		boolean answer = false;
		if(suspect=='a') {answer=true;};
		if(suspect=='e') {answer=true;};
		if(suspect=='i') {answer=true;};
		if(suspect=='o') {answer=true;};
		if(suspect=='u') {answer=true;};
		return answer;
	}
	
	static char[] qc(char[] in) {
		// For each letter in in;
		for(int i=0;i<6;i++) {
			// initial clusters
			if (i==0) {
				// jl -> ch
				if ((in[i]=='j')&&(in[i+1]=='l')) {in[i]='c';in[i+1]='h';};
				// (stop)f -> (stop)h
				if (((in[i]=='c')||(in[i]=='k')||(in[i]=='x')||(in[i]=='j')||(in[i]=='p')||(in[i]=='b')||(in[i]=='t')||(in[i]=='d')||(in[i]=='g'))&&(in[i+1]=='f')) {in[i+1]='h';};
				}
			// three letter strings
			if (i<3) {
				// vowel+vowel+vowel -> vowel+r+vowel
				if ((isVowel(in[i]))&&(isVowel(in[i+1]))&&(isVowel(in[i+2]))) {in[i+1] = getVowel();};
				// (c,k,x) + u + vowel -> qu + vowel
				if (((in[i]=='c')||(in[i]=='k')||(in[i]=='x'))&&(in[i+1]=='u')&&(isVowel(in[i+2]))) {in[i]='q';};
				}
			// two letter
			if (i<4) {
	            // fh -> ph
				if ((in[i]=='f')&&(in[i+1]=='h')) {in[i]='p';};
	            // sf -> ss
				if ((in[i]=='s')&&(in[i+1]=='f')) {in[i+1]='s';};
	            // (yh, ih) -> oh
				if (((in[i]=='y')||(in[i]=='i'))&&(in[i+1]=='h')) {in[i]='o';};
	            // (yw, iw) -> yl, il
				if (((in[i]=='y')||(in[i]=='i'))&&(in[i+1]=='w')) {in[i+1]='l';};
				}	
		} // end for loop		
		// rate names by scrabble score?
		
		return in;
	}
			
	
}
