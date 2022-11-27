package troll.husk;
import java.util.Random;
@SuppressWarnings("unused")


public class Horn {
	// this is for Just One Horn
	public String Placegene;
	// char1+2: Ff Tt Ss Bb u m j - Front-Temple-Side-Back-Unicorn-Mohawk-Jaw;
	// char3+4: Ll Mm Hh - Low-mid-high	
	public String Dirgene;
	// char1+2: Ff Bb Uu Dd - Forward-Back-up-down
        // char3+4: Oo Ss Ii w--  Outward-straight-Inward : w = waggles once.  ww = ampora.
	public String Curlengene;
	// 4 characters:
	// - sum the number of capitals to find how many handspans long it is
	// - add number of degrees to the curl for each letter :  Aa=0, Bb=45, Cc=90, 
	public String Radialgene;
	// char 1+2: Rr Pp - Rounded vs pointed edges
	// char 3+4: Rr Oo Tt Cc Ii -- 1 epicenter(circle), 2 epicenters(oval/tear), 3 corners(triangle), cup shape, irregular
	// char 5+6: Hh sS -- one big (H)ollow vs smaller (h)ollows vs porou(s) vs (S)olid interior
	// char 7-9: Vv Cc Uu Oo Ii Xx -- notches/holes by size and shape.  Xx = no notches.
	public String Tipgene;
	// char 1-2: Hh Pp Ss 
        // P? split, ?P point, S? cone, ?S pincher, H? bolt, ?H bump (? = lowercase p, s, or h)
        // PP point, PS split, PH L-hook, SP antler, SS spade, SH hook, HP, thorny, HS can-opener, HH hook
        // pp jagged, ps cone, ph hook, sp pincher, ss sphere, sh cone, hp bolt, hs flat, hh flat
	public String Anggene; //+width+spin
	// char 1+2: AaSsBb - whether horn curling is Angular, Smooth, or Both
	// char 3+4: Ww nN - wide/narrow
	// char 5+6: SsZzOo  -- spiral clockwise, counterclockwise, neither, + severity of spin
		
	
	public Horn(String blood) {
		if (blood=="blank") {
			Placegene = pickplace(blood);
			Dirgene = pickdir(blood);
			Curlengene = pickcurlen(blood);
			Radialgene = pickrad(blood);
			Tipgene = picktip(blood);
			Anggene = pickang(blood);
			return;
		}
		
		Random rand = new Random();
		Placegene = Gene.mutiBlend(pickplace(blood), pickplace(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickplace("rand"));
		Dirgene = Gene.mutiBlend(pickdir(blood), pickdir(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickdir("rand"));
		Curlengene = Gene.mutiBlend(pickcurlen(blood), pickcurlen(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickcurlen("rand"));
		Radialgene = Gene.mutiBlend(pickrad(blood), pickrad(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickrad("rand"));
		Tipgene = Gene.mutiBlend(picktip(blood), picktip(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), picktip("rand"));
		Anggene = Gene.mutiBlend(pickang(blood), pickang(Gene.hemospectrum(blood, (rand.nextInt(6)-4))), pickang("rand"));
	}

        
        
// data interpretation / description
	public String handspans(String curl) {
		int c = 0;
		if (Character.isUpperCase(curl.charAt(0))) {c++;};
		if (Character.isUpperCase(curl.charAt(1))) {c++;};
		if (Character.isUpperCase(curl.charAt(2))) {c++;};
		if (Character.isUpperCase(curl.charAt(3))) {c++;};
                
                String horn = "";
                if (c<2)  {horn="short ";};
                if (c==2) {horn="";};
                if (c==3) {horn="long ";};
                if (c==4) {horn="very long ";};
        
		return horn;		
	}

	public int curldegree(String curl) {
		int c = 0;
                c = c + (45 * Gene.counthas(curl, 'B')) + (45 * Gene.counthas(curl, 'b'));
                c = c + (90 * Gene.counthas(curl, 'C')) + (90 * Gene.counthas(curl, 'c'));
		return c;		
	}

	public String tipname(String tipgene) {
		String tip = "point";
		if (tipgene=="blank") {return tip;};
		
		// single-capitals
		if (tipgene.startsWith("P")) {tip="split";};
		if (tipgene.endsWith("P"))   {tip="point";};
		if (tipgene.startsWith("S")) {tip="cone";};
		if (tipgene.endsWith("S"))   {tip="pincher";};
		if (tipgene.startsWith("H")) {tip="bolt";};
		if (tipgene.endsWith("H"))   {tip="bump";};
				
		// double-cap combos that can overwrite that
		if (tipgene=="PP") {tip="point";};
		if (tipgene=="PS") {tip="split";};
		if (tipgene=="PH") {tip="L-hook";};
		if (tipgene=="SP") {tip="antler";};
		if (tipgene=="SS") {tip="spade";};
		if (tipgene=="SH") {tip="hook";};
		if (tipgene=="HP") {tip="thorny";};
		if (tipgene=="HS") {tip="can-opener";};
		if (tipgene=="HH") {tip="hook";};

		// lowercase combos
		if (tipgene=="pp") {tip="jagged";};
		if (tipgene=="ps") {tip="cone";};
		if (tipgene=="ph") {tip="hook";};
		if (tipgene=="sp") {tip="pincher";};
		if (tipgene=="ss") {tip="sphere";};
		if (tipgene=="sh") {tip="cone";};
		if (tipgene=="hp") {tip="bolt";};
		if (tipgene=="hs") {tip="flat";};
		if (tipgene=="hh") {tip="flat";};
		
		return tip;
	}

	public String wholistic(Horn h) {
	String horn = "";
	String hollow, notch = new String("");
	String sharp, width, spin = new String("");
	int curl = h.curldegree(h.Curlengene);
	String shape = "";
	
	// char 1+2: Rr Pp - Rounded vs pointed edges
	// char 3+4: Rr Oo Tt Cc Ii -- 1 epicenter(circle), 2 epicenters(oval/tear), 3 corners(triangle), cup shape, irregular
	shape = crossection(h.Radialgene);	
	// char 5+6: Hh sS -- one big (H)ollow vs smaller (h)ollows vs porou(s) vs (S)olid interior
	hollow=h.Radialgene.substring(4,6);
	// char 7-9: Vv Cc Uu Oo Ii Xx -- notches/holes by size and shape.  Xx = no notches.
	notch=h.Radialgene.substring(6,9);
	// char 1+2: AaSsBb - whether horn curling is Angular, Smooth, or Both		
	sharp=h.Anggene.substring(0,2);
	// char 3+4: Ww nN - wide/narrow
	width=h.Anggene.substring(2,4);
	// char 5+6: SsZzOo  -- spiral clockwise, counterclockwise, neither, + severity of spin		
	spin=h.Anggene.substring(4,6);
	
	
	
	// Begin assembling text string
	// LENGTH
        horn = handspans(Curlengene);
	
	// angularity
	if ((curl!=0)&&((sharp=="AA")||(sharp=="Aa")||(sharp=="aA")||(sharp=="sA")||(sharp=="As"))) {
		horn = horn + "sharply-";}; // angular
	if ((curl!=0)&&((sharp=="SS")||(sharp=="Ss")||(sharp=="sS")||(sharp=="aS")||(sharp=="Sa"))) {
		horn = horn + "smoothly-";}; // smooth

	// Curl
	if (curl==0) {horn = horn + "straight ";};
	if ((curl>0)&&(curl<=90)) {horn = horn + "curved ";};
	if ((curl>90)&&(curl<=180)) {horn = horn + "curled ";};
	if ((curl>180)&&(curl<=270)) {horn = horn + "curling ";};
	if ((curl>270)&&(curl<=9000)) {horn = horn + "coiled ";};

	// spiralling
	if (shape!="round") { // not pure round crossection
		int twist = 0;
		if (spin.startsWith("Z")) {twist=twist+3;};
		if (spin.startsWith("z")) {twist=twist+1;};
		if (spin.startsWith("s")) {twist=twist-1;};
		if (spin.startsWith("S")) {twist=twist-3;};
		if (spin.endsWith("Z")) {twist=twist+3;};
		if (spin.endsWith("z")) {twist=twist+1;};
		if (spin.endsWith("s")) {twist=twist-1;};
		if (spin.endsWith("S")) {twist=twist-3;};
		twist = Math.abs(twist);
		if (twist==6) {horn = horn + ", tightly-twisting ";};
		if (twist==4) {horn = horn + ", twisting ";};
		if (twist==2) {horn = horn + ", slightly-twisting ";};
		}
	// end of segment 1
	horn = horn + "horn, ";
	// lets talk tips and bases
	horn = horn + h.tipname(h.Tipgene) + "-tip, ";
	// Width
	if ((width=="WW")||(width=="Ww")||(width=="wW")||(width=="ww")) {horn = horn + "Wide ";}; // we don't care about normal
	// Hollowness
	String temp = "";
	if (hollow=="HH") {temp="Hollow";};
	if ((hollow.startsWith("S"))||(hollow.endsWith("S"))) {temp = "Solid";};
	if (temp=="") {temp="Porous";};
	horn = horn + temp + "-cored ";
	// add the cross-section we figured out above
	horn = horn + shape + "-shaped base";
	
	// notch
	// 3-digit, Vv Cc Uu Oo Ii Xx -- notches/holes by size and shape. 
	// Xx = no notches.  figure it out later
	

	return horn;
}	

        public String curly (String ang, String radial, String curlgene) {
            String horn = "";
            int curl = curldegree(curlgene);
            // char 1+2: Rr Pp - Rounded vs pointed edges
            // char 3+4: Rr Oo Tt Cc Ii -- 1 epicenter(circle), 2 epicenters(oval/tear), 3 corners(triangle), cup shape, irregular
            String shape = crossection(radial);	
            // char 1+2: AaSsBb - whether horn curling is Angular, Smooth, or Both		
            String sharp=ang.substring(0,2);
            // char 3+4: Ww nN - wide/narrow
            String width=ang.substring(2,4);
            // char 5+6: SsZzOo  -- spiral clockwise, counterclockwise, neither, + severity of spin		
            String spin=ang.substring(4,6);	
            // Begin assembling text string
        // angularity
            if ((curl!=0)&&((sharp=="AA")||(sharp=="Aa")||(sharp=="aA")||(sharp=="sA")||(sharp=="As"))) {
		horn = horn + "sharply-";}; // angular
            if ((curl!=0)&&((sharp=="SS")||(sharp=="Ss")||(sharp=="sS")||(sharp=="aS")||(sharp=="Sa"))) {
		horn = horn + "smoothly-";}; // smooth

            // Curl
            if (curl==0) {horn = horn + "straight";};
            if ((curl>0)&&(curl<=90)) {horn = horn + "curved";};
            if ((curl>90)&&(curl<=180)) {horn = horn + "curled";};
            if ((curl>180)&&(curl<=270)) {horn = horn + "curling";};
            if ((curl>270)&&(curl<=9000)) {horn = horn + "coiled";};

            // spiralling
            if (shape!="round") { // not pure round crossection
    		int twist = 0;
                    if (spin.startsWith("Z")) {twist=twist+3;};
                    if (spin.startsWith("z")) {twist=twist+1;};
                    if (spin.startsWith("s")) {twist=twist-1;};
                    if (spin.startsWith("S")) {twist=twist-3;};
                    if (spin.endsWith("Z")) {twist=twist+3;};
                    if (spin.endsWith("z")) {twist=twist+1;};
                    if (spin.endsWith("s")) {twist=twist-1;};
                    if (spin.endsWith("S")) {twist=twist-3;};
                    twist = Math.abs(twist);
                    if (twist==6) {horn = horn + ", tightly-twisting";};
                    if (twist==4) {horn = horn + ", twisting";};
                    if (twist==2) {horn = horn + ", slightly-twisting";};
                    }
       	if ((width=="WW")||(width=="Ww")||(width=="wW")||(width=="ww")) {horn = horn + " and wide";};
        return horn;
        }
        
	public String crossection(String radial) {
		String shape = "";
                String rad1 = radial.substring(0,2);
                String rad2 = radial.substring(2,4);
                
		boolean pointy = false;
		if ((rad1.equals("PP"))||(rad1.equals("Pp"))) {pointy=true;};
                if ((rad1.equals("pP"))||(rad1.equals("pp"))) {pointy=true;};
		if ((rad1.equals("Pr"))||(rad1.equals("rP"))) {pointy=true;};
		boolean rr = false; boolean oo = false; boolean tt = false;
		boolean cc = false; boolean ii = false;
		if ((rad2.startsWith("R")||rad2.endsWith("R"))) {rr=true;};
		if ((rad2.startsWith("O")||rad2.endsWith("O"))) {oo=true;};
		if ((rad2.startsWith("T")||rad2.endsWith("T"))) {tt=true;};
		if ((rad2.startsWith("C")||rad2.endsWith("C"))) {cc=true;};
		if ((rad2.startsWith("I")||rad2.endsWith("I"))) {ii=true;};
		if ((shape=="")&&(oo)) {shape="oval";  if (pointy) {shape="tear";};};
		if ((shape=="")&&(tt)) {shape="wedge"; if (pointy) {shape="star";};};
		if ((shape=="")&&(cc)) {shape="arch";  if (pointy) {shape="crescent";};};
		if ((shape=="")&&(ii)) {shape="blob";  if (pointy) {shape="sharp";};};
		if ((shape=="")||(rr)) {shape="round";};
		return shape;
	}
	
	public String mountpoint(String r) {
		// char3+4: Ll Mm Hh - Low-mid-high	
		String m = "";
		int[] num = {0, 0, 0};
		for (int i=0; i<r.length(); i++) {
			if (r.charAt(i) == 'L') {num[0]=num[0]+2;}
			if (r.charAt(i) == 'l') {num[0]=num[0]+1;}
			if (r.charAt(i) == 'M') {num[1]=num[1]+2;}
			if (r.charAt(i) == 'm') {num[1]=num[1]+1;}
			if (r.charAt(i) == 'H') {num[2]=num[2]+2;}
			if (r.charAt(i) == 'h') {num[2]=num[2]+1;}
			}
		// h is the relative height
		if ((num[2]>0)&&(num[0]>0)) {num[1]=20;}
		int h = num[2] - num[0];
		if (h>num[1]) {m = m + "high ";}  // if high, high
		if (h<num[1]) {m = m + "low ";}   // if low, low
		if (num[1]>2) {m = "";}           // if mid, say nothing.

		// 2char: Ff Tt Ss Bb  u  m  j - Front-Temple-Side-Back-Unicorn-Mohawk-Jaw;
		
		int f = 0;
		int t = 0;
		int s = 0;
		int b = 0;
		int u = 0;
		int mo = 0;
		int j = 0;

		for (int i=0; i<r.length()-2; i++) {
			if (r.charAt(i) == 'F') {f=f+2;}
			if (r.charAt(i) == 'f') {f=f+1;}
			if (r.charAt(i) == 'T') {t=t+2;}
			if (r.charAt(i) == 't') {t=t+1;}
			if (r.charAt(i) == 'S') {s=s+2;}
			if (r.charAt(i) == 's') {s=s+1;}
			if (r.charAt(i) == 'B') {b=b+2;}
			if (r.charAt(i) == 'b') {b=b+1;}
			if (r.charAt(i) == 'u') {u=u+1;}
			if (r.charAt(i) == 'm') {mo=mo+1;}
			if (r.charAt(i) == 'j') {j=j+1;}
			}
		// migration
		if ((t>0)&&(b>0)) {t=0; b=0; s=s+1;}; // if back+temple, move to side
		if ((f>0)&&(b>0)) {f=0; b=0; t=t+1;}; // if front AND back, move to temple.
		if ((f>0)&&(s>0)) {f=0; s=0; t=t+1;}; // if front+side, move to temple

		boolean flag = false;		
		if ((!flag)&&((u==2)||(mo==2)))   {m=m+"centered";        flag=true;};
		if ((!flag)&&(j==2))              {m=m+"jaw-mounted";     flag=true;};
		if ((!flag)&&(t>f)&&(t>s)&&(t>b)) {m=m+"temple-mounted";  flag=true;};
		if ((!flag)&&(f>t)&&(f>s)&&(f>b)) {m=m+"forehead-mounted";flag=true;};
		if ((!flag)&&(s>f)&&(s>t)&&(s>b)) {m=m+"side-mounted";    flag=true;};
		if ((!flag)&&(b>f)&&(b>s)&&(b>t)) {m=m+"back-mounted";    flag=true;};
		if (flag==false) 				  {m=m+"temple-mounted";};  // error-catcher
		return m;
	}

	public String dirpoint(String r) {
		// char1+2: Ff Bb Uu Dd - Forward-Back-up-down
	    // char3+4: Oo Ss Ii w--  Outward-straight-Inward : w = waggles once.  ww = ampora.
		String uno = "";
		String dos = "";
		String trs = "";

		boolean f=false;boolean b=false;boolean u=false;boolean d=false;
		boolean o=false;boolean s=false;boolean in=false;int w = 0;

		for (int i=0; i<r.length(); i++) {
			if ((r.charAt(i) == 'F')||(r.charAt(i) == 'f')) {f=true;} // front
			if ((r.charAt(i) == 'B')||(r.charAt(i) == 'b')) {b=true;} // back
			if ((r.charAt(i) == 'U')||(r.charAt(i) == 'u')) {u=true;} // up
			if ((r.charAt(i) == 'D')||(r.charAt(i) == 'd')) {d=true;} // down
			if ((r.charAt(i) == 'O')||(r.charAt(i) == 'o')) {o=true;} // out
			if ((r.charAt(i) == 'S')||(r.charAt(i) == 's')) {s=true;} // side
			if ((r.charAt(i) == 'I')||(r.charAt(i) == 'i')) {in=true;}// in
			if ((r.charAt(i) == 'W')||(r.charAt(i) == 'w')) {w=w+1;}  // wigglewaggle
			}
		// migration
		if (f&&b)  {f=false;  b=false; s=true;};  // front+back = side
		if (u&&d)  {u=false;  d=false; s=true;}; // up+down    = side
		if (in&&o) {in=false; o=false; s=true;}; // in+out     = side

		// outward -> outswept?   backswept?  downswept, upswept?
		
		if (f) {uno="forward";};
		if (b) {uno="backward";};
		if (u) {dos="upward";};
		if (d) {dos="downward";};
		
		if (s) {
			if (f||b)           {if (in) {trs="upward";};  if (o) {trs="downward";};};
			if (u||d)           {if (in) {trs="forward";}; if (o) {trs="backward";};};
			if (!f&&!b&&!u&&!d) {if (in) {trs="forward";}; if (o) {trs="backward";};};};
		if (!s) {
			if (f||b)           {if (in) {trs="inward";}; if (o) {trs="outward";};};
			if (u||d)           {if (in) {trs="inward";}; if (o) {trs="outward";};};
			if (!f&&!b&&!u&&!d) {if (in) {trs="upward";}; if (o) {trs="downward";};};};
		
		if ((uno=="forward")&&(trs=="forward"))   {trs="";};
		if ((uno=="backward")&&(trs=="backward")) {trs="";};
		if ((dos=="upward")&&(trs=="upward"))     {trs="";};
		if ((dos=="downward")&&(trs=="downward")) {trs="";};
		if ((uno=="forward")&&(trs=="backward"))  {trs=""; w=w+1;};
		if ((uno=="backward")&&(trs=="forward"))  {trs=""; w=w+1;};
		if ((dos=="upward")&&(trs=="downward"))   {trs=""; w=w+1;};
		if ((dos=="downward")&&(trs=="upward"))   {trs=""; w=w+1;};

		String waggle = "";
		if (w==0) {waggle="";};
		if (w==1) {waggle="wiggles once";};
		if (w==2) {waggle="wiggles twice";};
		if (w==3) {waggle="wiggles thrice";};
		if (w>3)  {waggle="wiggles a lot";};
		
		String dir = "";
                if (!uno.equals("")) {dir = uno;};
                if (!dos.equals("")) {
                    if (!dir.equals("")) {dir = dir + ", and ";}; dir = dir + dos;};
                if (!trs.equals("")) {
                    if (!dir.equals("")) {dir = dir + ", and ";}; dir = dir + trs;};
                if (!waggle.equals("")) {
                    if (!dir.equals("")) {dir = dir + ", and ";}; dir = dir + waggle;};
                
		return dir;
	}


        
        

// slurry
	public String pickplace(String blood){
		String var = new String();
		var = "tsmh";
		if (blood=="blank") {return var;};
		// char1+2: Ff Tt Ss Bb u m j - Front-Temple-Side-Back-Unicorn-Mohawk-Jaw;
		// char3+4: Ll Mm Hh - Low-mid-high
		Blood b = new Blood(blood);
 		Random rand = new Random();
		
	if (blood=="rand") {
		String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
				"front", "back", "side", "temple", "uni", "hawk", "jaw"};
		blood = options[rand.nextInt(options.length)];
	} // end rand
	if (blood=="truerand") {
		String[] Ft = {"F", "f", "T", "t", "S", "s", "B", "b", "u", "m", "j"};
		String[] LMH = {"M", "m"};
		var = Gene.randopt(Ft, 2) + Gene.randopt(LMH, 2);
		return var;};
	
	// 	apply caste modifiers
	if (blood.startsWith("RR")) {var="tTmh";}; //Maroon
	if (blood.startsWith("Rr")) {var="stlh";};
	if (blood.startsWith("rr")) {var="tsml";}; // Bronze
	if (blood.startsWith("Rg")) {var="stmh";};
	if (blood.startsWith("RG")) {var="TTHH";}; // Gold
	if (blood.startsWith("Gr")) {var="Tfhh";};
	if (blood.startsWith("rg")) {var="tthh";}; // Lime
	if (blood.startsWith("GG")) {var="tshh";}; // Olive
	if (blood.startsWith("Gg")) {var="tfhh";};
	if (blood.startsWith("gg")) {var="tsHh";}; // Jade
	if (blood.startsWith("Gb")) {var="tfhH";};
	if (blood.startsWith("GB")) {var="ffHh";}; // Teal
	if (blood.startsWith("Bg")) {var="tfHH";};
	if (blood.startsWith("gb")) {var="tsHH";}; // Ceru
	if (blood.startsWith("BB")) {var="tsHH";}; // Bloo
	if (blood.startsWith("Bb")) {var="tbHM";};
	if (blood.startsWith("bb")) {var="tsHH";}; //Indigo
	if (blood.startsWith("Br")) {var="tbHH";};
	if (blood.startsWith("RB")) {var="tTHH";}; //Violet
	if (blood.startsWith("Rb")) {var="BTHH";};
	if (blood.startsWith("rb")) {var="TtHm";}; //Tyrian
	
	// other presets
	
	if (blood.startsWith("back"))  {var="BBHM";};
	if (blood.startsWith("front")) {var="FFHH";};
	if (blood.startsWith("side")) {var="SSMM";};
	if (blood.startsWith("temple")) {var="TTHH";};
	if (blood.startsWith("uni")) {var="uuHH";};
	if (blood.startsWith("hawk")) {var="mmHH";};
	if (blood.startsWith("jaw")) {var="jjLL";};

	return var;
}

	public String pickdir(String blood){
		String var = new String();
		var = "ubIS";
		if (blood=="blank") {return var;};
		if (blood=="truerand") {
			String[] FBD = {"F", "f", "B", "b", "U", "u", "D", "d"};
			String[] OSI = {"O", "o", "S", "s", "I", "i", "w"};
			var = Gene.randopt(FBD, 2) + Gene.randopt(OSI, 2);
			return var;};
		// char1+2: Ff Bb Uu Dd - Forward-Back-up-down
	    // char3+4: Oo Ss Ii w-- Outward-straight-Inward : w = waggles once.  ww = ampora.
		Blood b = new Blood(blood);
 		Random rand = new Random();
		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
				"spear", "hat", "woogle", "bull", "side",};
			blood = options[rand.nextInt(options.length)];
		} // end rand
		// caste presets
		if (blood.startsWith("RR")) {var = "ubii";}; //Maroon
		if (blood.startsWith("Rr")) {var = "bfoi";};
		if (blood.startsWith("rr")) {var = "UFuu";}; // Bronze
		if (blood.startsWith("Rg")) {var = "bfio";};
		if (blood.startsWith("RG")) {var = "Ubii";}; // Gold
		if (blood.startsWith("Gr")) {var = "buis";};
		if (blood.startsWith("rg")) {var = "ubii";}; // Lime
		if (blood.startsWith("GG")) {var = "uUii";}; // Olive
		if (blood.startsWith("Gg")) {var = "bbso";};
		if (blood.startsWith("gg")) {var = "Ubii";}; // Jade
		if (blood.startsWith("Gb")) {var = "fuii";};
		if (blood.startsWith("GB")) {var = "ubSI";}; // Teal
		if (blood.startsWith("Bg")) {var = "fuio";};
		if (blood.startsWith("gb")) {var = "ubII";}; // Ceru
		if (blood.startsWith("BB")) {var = "ubSs";}; // Bloo
		if (blood.startsWith("Bb")) {var = "fbSS";};
		if (blood.startsWith("bb")) {var = "UbsS";}; //Indigo
		if (blood.startsWith("Br")) {var = "bdsw";};
		if (blood.startsWith("RB")) {var = "uBww";}; //Violet
		if (blood.startsWith("Rb")) {var = "dbwo";};
		if (blood.startsWith("rb")) {var = "UbOO";}; //Tyrian
		
		// 	other presets
		if (blood.startsWith("spear")) {var = "FFSS";};
		if (blood.startsWith("bull")) {var = "FUII";};
		if (blood.startsWith("woogle")) {var = "bBww";};
		if (blood.startsWith("hat")) {var = "BbII";};
		if (blood.startsWith("side")) {var = "DDII";};
		
		return var;
		}

	public String pickcurlen(String blood){
		String var = new String();
		var = "Aaaa";
		if (blood=="blank") {return var;};
		// - sum the number of capitals to find how many handspans long it is
		// - add number of degrees to the curl for each letter :  Aa=0, Bb=45, Cc=90, 
		Blood b = new Blood(blood);
 		Random rand = new Random();

	if (blood=="rand") {
		String[] options = {"RR", "GG", "BB", "1", "2", "3",
				     "4", "5", "6", "7", "8", "9", "0", "c"};
		blood = options[rand.nextInt(options.length)];
	} // end rand
	if (blood=="truerand") {
		String[] Abc = {"A", "a", "B", "b", "C", "c"};
		var = Gene.randopt(Abc, 4);
		return var;};
	
	// caste presets
	if (blood.startsWith("RR")) {var="CCcc";}; //Maroon
	if (blood.startsWith("Rr")) {var="bCaa";};
	if (blood.startsWith("rr")) {var="AAAc";}; // Bronze
	if (blood.startsWith("Rg")) {var="abbA";};
	if (blood.startsWith("RG")) {var="aAAa";}; // Gold
	if (blood.startsWith("Gr")) {var="Aaab";};
	if (blood.startsWith("rg")) {var="aAAa";}; // Lime
	if (blood.startsWith("GG")) {var="abaA";}; // Olive
	if (blood.startsWith("Gg")) {var="Aaca";};
	if (blood.startsWith("gg")) {var="AAaa";}; // Jade
	if (blood.startsWith("Gb")) {var="aaaA";};
	if (blood.startsWith("GB")) {var="aaAa";}; // Teal
	if (blood.startsWith("Bg")) {var="cAaa";};
	if (blood.startsWith("gb")) {var="AAaa";}; // Ceru
	if (blood.startsWith("BB")) {var="AAaa";}; // Bloo
	if (blood.startsWith("Bb")) {var="BaaA";};
	if (blood.startsWith("bb")) {var="AAAA";}; //Indigo
	if (blood.startsWith("Br")) {var="AaaA";};
	if (blood.startsWith("RB")) {var="AAaa";}; //Violet
	if (blood.startsWith("Rb")) {var="AAaa";};
	if (blood.startsWith("rb")) {var="ABaa";}; //Tyrian

	// 	other presets
	if (blood.startsWith("1")) {var="AAAA";};
	if (blood.startsWith("2")) {var="aaaa";};
	if (blood.startsWith("3")) {var="CCCC";};
	if (blood.startsWith("4")) {var="BCbB";};
	if (blood.startsWith("5")) {var="CCBa";};
	if (blood.startsWith("6")) {var="AAAC";};
	if (blood.startsWith("7")) {var="AAAB";};
	if (blood.startsWith("8")) {var="aCBA";};
	if (blood.startsWith("9")) {var="AbCC";};
	if (blood.startsWith("0")) {var="bbbb";};
	if (blood.startsWith("c")) {var="cccc";};

	return var;
	}

	public String pickrad(String blood) {
		String var = new String("RrRrSsXXX");
		if (blood=="blank") {return var;};
		if (blood=="truerand") {
			String[] Rp = {"R", "r", "P", "p"};
			String[] Tc = {"R", "r", "O", "o", "T", "t", "C", "c", "I", "i"};
			String[] Hs = {"H", "h", "S", "s"};
			String[] Vx = {"V", "v", "C", "c", "U", "u", "O", "o", "I", "i", "X", "x"};
			var = Gene.randopt(Rp, 2) + Gene.randopt(Tc, 2) + Gene.randopt(Hs, 2) + Gene.randopt(Vx, 3);
			return var;};
		
		// char 1+2: Rr Pp - Rounded vs pointed edges
		// char 3+4: Rr Oo Tt Cc Ii -- 1 epicenter(circle), 2 epicenters(oval/tear), 3 corners(triangle), cup shape, irregular
		// char 5+6: Hh sS -- one big (H)ollow vs smaller (h)ollows vs porou(s) vs (S)olid interior
		// char 7-9: Vv Cc Uu Oo Ii Xx -- notches/holes by size and shape.  Xx = no notches.
		Blood b = new Blood(blood);
 		Random rand = new Random();

	if (blood=="rand") {
		String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
				"round1", "round2", "round3", "round4", "oval1", "oval2", "oval3", "oval4",
				"tri1", "tri2", "cup1", "cup1", "irr1", "irr2", "irr3", "irr4", "irr5",
				"irr6", "irr7", "irr8"};
		blood = options[rand.nextInt(options.length)];
	} // end rand
	// 	caste presets
	if (blood.startsWith("RR")) {var="RRrRSSxxx";}; //Maroon
	if (blood.startsWith("Rr")) {var="rrrrshoux";};
	if (blood.startsWith("rr")) {var="RRRrhsxxx";}; // Bronze
	if (blood.startsWith("Rg")) {var="rriossoxu";};
	if (blood.startsWith("RG")) {var="Rrrrssxxx";}; // Gold
	if (blood.startsWith("Gr")) {var="rriossvxv";};
	if (blood.startsWith("rg")) {var="RrcRssxxx";}; // Lime
	if (blood.startsWith("GG")) {var="rRCTSSXXX";}; // Olive
	if (blood.startsWith("Gg")) {var="rrtcSSxxx";};
	if (blood.startsWith("gg")) {var="RrRRSSXXX";}; // Jade
	if (blood.startsWith("Gb")) {var="rrRrSsixx";};
	if (blood.startsWith("GB")) {var="rRrRSSXXX";}; // Teal
	if (blood.startsWith("Bg")) {var="rrRrsSivx";};
	if (blood.startsWith("gb")) {var="RrrRSSxxx";}; // Ceru
	if (blood.startsWith("BB")) {var="rRRrSSxxx";}; // Bloo
	if (blood.startsWith("Bb")) {var="rPrtSsxxu";};
	if (blood.startsWith("bb")) {var="ppTtSsxXx";}; //Indigo
	if (blood.startsWith("Br")) {var="PrtrsSxcx";};
	if (blood.startsWith("RB")) {var="rrrrSSXXX";}; //Violet
	if (blood.startsWith("Rb")) {var="RrrisSuxx";};
	if (blood.startsWith("rb")) {var="rrRrSSXXX";}; //Tyrian
	// 	other presets
	if (blood.startsWith("round1")) {var="RRRRSSXXX";};
	if (blood.startsWith("round2")) {var="RRRrSsxxx";};
	if (blood.startsWith("round3")) {var="RRrrsSVVV";};
	if (blood.startsWith("round4")) {var="RRrRssvvv";};
	if (blood.startsWith("oval1")) {var="rrOOSSXXX";};
	if (blood.startsWith("oval2")) {var="rroOSSxxx";};
	if (blood.startsWith("oval3")) {var="rrOoHHCCC";};
	if (blood.startsWith("oval4")) {var="rroossccc";};
	if (blood.startsWith("tri1")) {var="ppTTSSXXX";};
	if (blood.startsWith("tri2")) {var="ppttHHxxx";};
	if (blood.startsWith("cup1")) {var="ppCChhUUU";};
	if (blood.startsWith("cup2")) {var="ppccSSuuu";};
	if (blood.startsWith("irr1")) {var="PPIISSXXX";};
	if (blood.startsWith("irr2")) {var="PPIISSxxx";};
	if (blood.startsWith("irr3")) {var="PPiiHhOOO";};
	if (blood.startsWith("irr4")) {var="PPiihHooo";};
	if (blood.startsWith("irr5")) {var="RrIISsXXX";};
	if (blood.startsWith("irr6")) {var="rRIIsSxxx";};
	if (blood.startsWith("irr7")) {var="RriiHhIII";};
	if (blood.startsWith("irr8")) {var="rRiihHiii";};

	return var;
	}
	
	public String picktip(String blood){
		String var = new String("PP");
		if (blood=="blank") {return var;};
		if (blood=="truerand") {
			String[] Rp = {"P", "p", "H", "h", "S", "s"};
			var = Gene.randopt(Rp, 2);
			return var;};
		// consider adding new letters for new chunks of tip types
		// char 2: 
		//	PP(point), 		Px,PS(split), 		xP(branching),  	pp(jagged), 	// "point"
		//	HH,ph,SH(hook),	Hx,hp(bolt),  		xH(bump),       	hh,hs(flat),	// "hook"
		//	SS(spade), 		Sx,ps,sh(cone),  	xS,sp(Pincher),     ss(sphere), 	// "shape"
		//  PH(Lhook)  		HP(thorny)			SP(antler) 			HS(canopener)
		//	---
		Blood b = new Blood(blood);
 		Random rand = new Random();

	if (blood=="rand") {
		String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
				"point", "split", "branching", "jagged", "hook", "bolt", "bump", "flat", "spade",
				"cone", "pincher", "sphere", "hook2", "bolt2", "cone2", "pincher2", "flat2", "cone2",
				"Lhook", "thorny", "split2", "antler", "canopener", "hook3"};
		blood = options[rand.nextInt(options.length)];
	} // end rand

	// caste presets
	if (blood.startsWith("RR")) {var="PP";}; //Maroon
	if (blood.startsWith("Rr")) {var="pP";};
	if (blood.startsWith("rr")) {var="PH";}; // Bronze
	if (blood.startsWith("Rg")) {var="pP";};
	if (blood.startsWith("RG")) {var="PP";}; // Gold
	if (blood.startsWith("Gr")) {var="Pp";};
	if (blood.startsWith("rg")) {var="pP";}; // Lime
	if (blood.startsWith("GG")) {var="PP";}; // Olive
	if (blood.startsWith("Gg")) {var="sP";};
	if (blood.startsWith("gg")) {var="HS";}; // Jade
	if (blood.startsWith("Gb")) {var="sP";};
	if (blood.startsWith("GB")) {var="PP";}; // Teal
	if (blood.startsWith("Bg")) {var="Ps";};
	if (blood.startsWith("gb")) {var="HS";}; // Ceru
	if (blood.startsWith("BB")) {var="Sh";}; // Bloo
	if (blood.startsWith("Bb")) {var="hs";};
	if (blood.startsWith("bb")) {var="PP";}; //Indigo
	if (blood.startsWith("Br")) {var="Ph";};
	if (blood.startsWith("RB")) {var="Hp";}; //Violet
	if (blood.startsWith("Rb")) {var="Ph";};
	if (blood.startsWith("rb")) {var="PP";}; //Tyrian
	// 	other presets
	if (blood.startsWith("point"))     {var="PP";};
	if (blood.startsWith("split"))     {var="Pp";};
	if (blood.startsWith("branching")) {var="pP";};
	if (blood.startsWith("jagged"))    {var="pp";};
	if (blood.startsWith("hook"))      {var="HH";};
	if (blood.startsWith("bolt"))      {var="Hh";};
	if (blood.startsWith("bump"))      {var="hH";};
	if (blood.startsWith("flat"))      {var="hh";};
	if (blood.startsWith("spade"))     {var="SS";};
	if (blood.startsWith("cone"))      {var="Ss";};
	if (blood.startsWith("pincher"))   {var="sS";};
	if (blood.startsWith("sphere"))    {var="ss";};	
	if (blood.startsWith("hook2"))     {var="ph";};
	if (blood.startsWith("bolt2"))     {var="hp";};
	if (blood.startsWith("cone2"))     {var="ps";};
	if (blood.startsWith("pincher2"))  {var="sp";};
	if (blood.startsWith("flat2"))     {var="hs";};
	if (blood.startsWith("cone2"))     {var="sh";};
	if (blood.startsWith("Lhook"))     {var="PH";};
	if (blood.startsWith("thorny"))    {var="HP";};
	if (blood.startsWith("split2"))    {var="PS";};
	if (blood.startsWith("antler"))    {var="SP";};
	if (blood.startsWith("canopener")) {var="HS";};
	if (blood.startsWith("hook3"))     {var="SH";};

	return var;
	}

	public String pickang(String blood) {
		String var = new String("ASNNsz");
		if (blood=="blank") {return var;};
		if (blood=="truerand") {
			String[] Asb = {"A", "a", "S", "s", "B", "b"};
			String[] Wn = {"W", "w", "n", "N"};
			String[] Soz = {"S", "s", "O", "o", "Z", "z"};
			var = Gene.randopt(Asb, 2) + Gene.randopt(Wn, 2) + Gene.randopt(Soz, 2);
			return var;};
		// char 1+2: AaSs - whether horn curling is Angular, Smooth, or Both
		// char 3+4: Ww nN - wide/narrow
		// char 5+6: SsZz  -- spiral clockwise, counterclockwise, neither, + severity of spin
		Blood b = new Blood(blood);
 		Random rand = new Random();

		if (blood=="rand") {
			String[] options = {"RR", "rr", "RG", "GG", "gg", "GB", "gb", "BB", "bb", "RB", "rb",
					"ANGLE", "angle", "SMOOTH", "smooth", "screw1", "screw2", "screw3", "screw4"};
			blood = options[rand.nextInt(options.length)];
		} // end rand
		// caste presets
		if (blood.startsWith("RR")) {var="SSNNsz";}; //Maroon
		if (blood.startsWith("Rr")) {var="SSNNsz";};
		if (blood.startsWith("rr")) {var="aSNNsz";}; // Bronze
		if (blood.startsWith("Rg")) {var="sANNsz";};
		if (blood.startsWith("RG")) {var="ASNNsz";}; // Gold
		if (blood.startsWith("Gr")) {var="sANNsz";};
		if (blood.startsWith("rg")) {var="SAwNsz";}; // Lime
		if (blood.startsWith("GG")) {var="ASWWsz";}; // Olive
		if (blood.startsWith("Gg")) {var="ASNwsz";};
		if (blood.startsWith("gg")) {var="SANNsz";}; // Jade
		if (blood.startsWith("Gb")) {var="ASNNsz";};
		if (blood.startsWith("GB")) {var="SANNsz";}; // Teal
		if (blood.startsWith("Bg")) {var="ASNNsz";};
		if (blood.startsWith("gb")) {var="SANNsz";}; // Ceru
		if (blood.startsWith("BB")) {var="AANNsz";}; // Bloo
		if (blood.startsWith("Bb")) {var="ASwNsz";};
		if (blood.startsWith("bb")) {var="SANNZS";}; //Indigo
		if (blood.startsWith("Br")) {var="ASNwsz";};
		if (blood.startsWith("RB")) {var="AANNsz";}; //Violet
		if (blood.startsWith("Rb")) {var="SANNsz";};
		if (blood.startsWith("rb")) {var="SSNNsz";}; //Tyrian
		// 	other presets
		if (blood.startsWith("ANGLE"))  {var="AANNsz";};
		if (blood.startsWith("angle"))  {var="aaNwsz";};
		if (blood.startsWith("smooth")) {var="sswNsz";};
		if (blood.startsWith("SMOOTH")) {var="SSNNsz";};
		if (blood.startsWith("screw1")) {var="SANNSS";};
		if (blood.startsWith("screw1")) {var="saNNss";};
		if (blood.startsWith("screw2")) {var="asWWzz";}; // for clowns specifically
		if (blood.startsWith("screw3")) {var="ASWWZZ";};
		
	return var;
	}
	
	public String shortform() {
		String text = new String("");		
		text = Placegene + "-" + Dirgene + "-" + Curlengene + "-" + Radialgene + "-" + Tipgene + "-" + Anggene;
		return text;
	}
	
	
}
