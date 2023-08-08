/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Dancestry;
/**
 *
 * @author wirrit
 */


import javax.swing.*;     // For the GUI
import java.awt.event.*;  // more GUI
import java.awt.image.*;  // more gui
import java.awt.*;        // more GUI
import java.util.Arrays;
import com.google.gson.Gson; // java obj <-> JSON string
import troll.*;
import troll.fluff.*;
import troll.husk.*;
@SuppressWarnings("unused")


public class Dancestry {

	private static void createAndShowGUI() {
		// make window
		JFrame frame = new JFrame("Genome");
		frame.setSize(900, 500);
		Dimension boxsize = new Dimension(300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// define window
		JPanel panel = new JPanel();
		DisplayTroll readout1 = new DisplayTroll();
		readout1.setPreferredSize(boxsize);
		DisplayTroll readout2 = new DisplayTroll();
		readout2.setPreferredSize(boxsize);
		DisplayTroll readoutresult = new DisplayTroll();
		readoutresult.setPreferredSize(boxsize);
		frame.add(panel);
		frame.add(readout1);
		frame.add(readout2);
		frame.add(readoutresult);

		// menu
		var menuBar = new JMenuBar();
		var generalMenu = new JMenu("General");
		generalMenu.setMnemonic(KeyEvent.VK_F);
		var miscMenu = new JMenu("Misc");
		generalMenu.setMnemonic(KeyEvent.VK_M);
		var trollMenu = new JMenu("Trolls");
		trollMenu.setMnemonic(KeyEvent.VK_T);
		var faeMenu = new JMenu("Nontrolls");
		faeMenu.setMnemonic(KeyEvent.VK_N);
		var leftMenu = new JMenu("Load Left");
		leftMenu.setMnemonic(KeyEvent.VK_L);
		var fuckMenu = new JMenu("Offspring");
		fuckMenu.setMnemonic(KeyEvent.VK_O);
		var rightMenu = new JMenu("Load Right");
		rightMenu.setMnemonic(KeyEvent.VK_R);
		
		//general menu		
		var gennamesMenuItem = new JMenuItem(" 150 names to file");
		gennamesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenNames();}
			});
		var gentagsMenuItem = new JMenuItem(" 150 trollTags to file");
		gentagsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTags();}
			});
		gentagsMenuItem.setMnemonic(KeyEvent.VK_T);
		var genstatsMenuItem = new JMenuItem("  50 Stats to file");
		genstatsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenStats();}
			});
		genstatsMenuItem.setMnemonic(KeyEvent.VK_S);
		var genelementMenuItem = new JMenuItem("  50 Elements to file");
		genelementMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenElements("any");}
			});
                genelementMenuItem.setMnemonic(KeyEvent.VK_E);
		var genpeeperMenuItem = new JMenuItem("1000 Peepers to file");
		genpeeperMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenPeepers();}
			});
		genpeeperMenuItem.setMnemonic(KeyEvent.VK_P);
		var genstaticMenuItem = new JMenuItem("100 characters of static to file");
		genstaticMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenstatic();}
			});
		var genintereststrifeMenuItem = new JMenuItem("50 Interests / Strife");
		genintereststrifeMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonInterestStrife(50);}
			});
		var genlandsMenuItem = new JMenuItem("10 Lands");
		genlandsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonlands(10);}
			});
		var genlittersMenuItem = new JMenuItem("Generate Litter Numbers");
		genlittersMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenLitters(readout1, readout2);}
			});
                
                // Misc Menu
                // Activate this later.
                /*
      		var gen1MenuItem = new JMenuItem("  50 things from elements file");
		gen1MenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenElements("codegoeshere");}
			});
                gen1MenuItem.setMnemonic(KeyEvent.VK_E);
                */
                
                
                // fuckmenu
                
		var fuckMenuItem = new JMenuItem("create 1 Offspring of left / right trolls");
		fuckMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonOffspring(readout1, readout2, readoutresult, 1);readoutresult.repaint();}
			});
		fuckMenuItem.setMnemonic(KeyEvent.VK_O);
		var fuckmoreMenuItem = new JMenuItem("create 10 such offspring");
		fuckmoreMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonOffspring(readout1, readout2, readoutresult, 10);readoutresult.repaint();}
			});
		var fuckmoremoreMenuItem = new JMenuItem("create 100 such offspring");
		fuckmoremoreMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonOffspring(readout1, readout2, readoutresult, 100);readoutresult.repaint();}
			});
		var fucklitterMenuItem = new JMenuItem("create a litter of offspring");
		fucklitterMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonOffspring(readout1, readout2, readoutresult, Gene.littersize(readout1.troll.body.fertgene, readout2.troll.body.fertgene));readoutresult.repaint();}
			});
                // nontroll menu
		var genfaeMenuItem = new JMenuItem("Generate 1 fae");
		genfaeMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "fae");readoutresult.repaint();}
			});
		var gen5faeMenuItem = new JMenuItem("Generate 5 fae");
		genfaeMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 5, "fae");readoutresult.repaint();}
			});
		var genhumanMenuItem = new JMenuItem("Generate 1 human");
		genhumanMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "human");readoutresult.repaint();}
			});                               
		var gen5humanMenuItem = new JMenuItem("Generate 5 human");
		genhumanMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 5, "human");readoutresult.repaint();}
			});                               
               
                
                
		//troll menu		
		var gen1MenuItem = new JMenuItem("Generate 1 normal troll");
		gen1MenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "caste");readoutresult.repaint();}
			});
		var gen5MenuItem = new JMenuItem("Generate 5 normal trolls");
		gen5MenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 5, "caste");readoutresult.repaint();}
			});
		var gentruerandMenuItem = new JMenuItem("Generate 1 random mutant");
		gentruerandMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "truerand");readoutresult.repaint();}
			});
		var gen5truerandMenuItem = new JMenuItem("Generate 5 random mutants");
		gen5truerandMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 5, "truerand");readoutresult.repaint();}
			});
		var genRGbMenuItem = new JMenuItem("Generate 1 RGb Off-gold Troll");
		genRGbMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "RGb");readoutresult.repaint();}
			});
		var genBrgMenuItem = new JMenuItem("Generate 1 Brg Clownfish Troll");
		genBrgMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "Brg");readoutresult.repaint();}
			});
		var genRRMenuItem = new JMenuItem("Generate 1 RR Maroon");
		genRRMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "RR");readoutresult.repaint();}
			});
		var genrrMenuItem = new JMenuItem("Generate 1 rr Bronze");
		genrrMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "rr");readoutresult.repaint();}
			});
		var genRGMenuItem = new JMenuItem("Generate 1 RG Gold");
		genRGMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "RG");readoutresult.repaint();}
			});
		var genrgMenuItem = new JMenuItem("Generate 1 rg Lime");
		genrgMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "rg");readoutresult.repaint();}
			});
		var genGGMenuItem = new JMenuItem("Generate 1 GG Olive");
		genGGMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "GG");readoutresult.repaint();}
			});
		var genggMenuItem = new JMenuItem("Generate 1 gg Jade");
		genggMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "gg");readoutresult.repaint();}
			});
		var genGBMenuItem = new JMenuItem("Generate 1 GB Teal");
		genGBMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "GB");readoutresult.repaint();}
			});
		var gengbMenuItem = new JMenuItem("Generate 1 gb Cerulean");
		gengbMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "gb");readoutresult.repaint();}
			});
		var genBBMenuItem = new JMenuItem("Generate 1 BB Blue");
		genBBMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "BB");readoutresult.repaint();}
			});
		var genbbMenuItem = new JMenuItem("Generate 1 bb Indigo");
		genbbMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "bb");readoutresult.repaint();}
			});
		var genRBMenuItem = new JMenuItem("Generate 1 RB Violet");
		genRBMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "RB");readoutresult.repaint();}
			});
		var genrbMenuItem = new JMenuItem("Generate 1 rb Tyrian");
		genrbMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonGenTroll(readoutresult, 1, "rb");readoutresult.repaint();}
			});
                
                
		var exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setMnemonic(KeyEvent.VK_E);
		exitMenuItem.setToolTipText("Exit");
		exitMenuItem.addActionListener((event) -> System.exit(0));
		
		// Load Left From File
		var loadleftfileMenuItem = new JMenuItem("From troll1.txt");
		loadleftfileMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonLoadTroll(readout1, "troll1.txt");readout1.repaint();}
			});
		// Load Right From File
		var loadrightfileMenuItem = new JMenuItem("From troll2.txt");
		loadrightfileMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonLoadTroll(readout2, "troll2.txt");readout2.repaint();}
			});
		// Load Left From Center
		var loadleftcenMenuItem = new JMenuItem("From center");
		loadleftcenMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {readout1.troll = readoutresult.troll; readout1.repaint();}
			});
		// Load Right From Center
		var loadrightcenMenuItem = new JMenuItem("From center");
		loadrightcenMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {readout2.troll = readoutresult.troll; readout2.repaint();}
			});
		// Load Left From Opposite
		var loadleftoppMenuItem = new JMenuItem("From right");
		loadleftoppMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {readout1.troll = readout2.troll; readout1.repaint();}
			});
		// Load Right From Opposite
		var loadrightoppMenuItem = new JMenuItem("From left");
		loadrightoppMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {readout2.troll = readout1.troll; readout2.repaint();}
			});
                // Redescribe Left
		var redescLeftMenuItem = new JMenuItem("Redescribe Left");
		redescLeftMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonRedescTroll(readout1);}
			});
                // Redescribe Right
		var redescRightMenuItem = new JMenuItem("Redescribe Right");
		redescRightMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buttonRedescTroll(readout2);}
			});
		
		// assemble menubar
		trollMenu.add(gen1MenuItem);
		trollMenu.add(gen5MenuItem);
		trollMenu.add(gentruerandMenuItem);
		trollMenu.add(gen5truerandMenuItem);
		trollMenu.add(genRGbMenuItem);
		trollMenu.add(genBrgMenuItem);
		trollMenu.add(genRRMenuItem);
		trollMenu.add(genrrMenuItem);
		trollMenu.add(genRGMenuItem);
		trollMenu.add(genrgMenuItem);
		trollMenu.add(genGGMenuItem);
		trollMenu.add(genggMenuItem);
		trollMenu.add(genGBMenuItem);
		trollMenu.add(gengbMenuItem);
		trollMenu.add(genBBMenuItem);
		trollMenu.add(genbbMenuItem);
		trollMenu.add(genRBMenuItem);
		trollMenu.add(genrbMenuItem);
       		faeMenu.add(genfaeMenuItem);
       		faeMenu.add(gen5faeMenuItem);
		faeMenu.add(genhumanMenuItem);
		faeMenu.add(gen5humanMenuItem);
		fuckMenu.add(fuckMenuItem);
		fuckMenu.add(fuckmoreMenuItem);
		fuckMenu.add(fuckmoremoreMenuItem);
		fuckMenu.add(fucklitterMenuItem);
		generalMenu.add(gentagsMenuItem);
		generalMenu.add(gennamesMenuItem);
		generalMenu.add(genstatsMenuItem);
		generalMenu.add(genelementMenuItem);
		generalMenu.add(genpeeperMenuItem);
		generalMenu.add(genstaticMenuItem);
		generalMenu.add(genintereststrifeMenuItem);
		generalMenu.add(genlandsMenuItem);
		generalMenu.add(genlittersMenuItem);
		generalMenu.add(exitMenuItem);
		leftMenu.add(loadleftfileMenuItem);
		rightMenu.add(loadrightfileMenuItem);
		leftMenu.add(loadleftcenMenuItem);
		rightMenu.add(loadrightcenMenuItem);
		leftMenu.add(loadleftoppMenuItem);
		rightMenu.add(loadrightoppMenuItem);
		leftMenu.add(redescLeftMenuItem);
		rightMenu.add(redescRightMenuItem);
		// add menus to main bar
		menuBar.add(generalMenu);
		menuBar.add(trollMenu);
		menuBar.add(faeMenu);
		menuBar.add(leftMenu);
		menuBar.add(fuckMenu);
		menuBar.add(rightMenu);		
		// add menubar to frame
		frame.setJMenuBar(menuBar);
		
		// Place toolbar and components
		Container contentPane = frame.getContentPane();
		contentPane.add(readout1, BorderLayout.WEST);
		contentPane.add(readoutresult, BorderLayout.CENTER);
		contentPane.add(readout2, BorderLayout.EAST);
		
		// display window
		frame.setVisible(true);
	}
		
	private static JPanel displayTroll() {
	DisplayTroll displaypanel = new DisplayTroll();
	displaypanel.setLayout(null);
	displaypanel.setBackground(Color.lightGray);
	String t = "";
	return displaypanel;
	}
	
	private static void buttonGenTroll(DisplayTroll readout, int numbertogenerate, String key) {
		Gson gson = new Gson();
		String filename = new String("");
		String txt = new String("");
		fio fileinterface = new fio();
				
		int x = 0;
		while (x<numbertogenerate) {
			readout.troll = new Troll(key);
                        buttonRedescTroll(readout);
                        // redesc saves a copy of your troll
			x++;
			}
		readout.repaint();
	}
        
	private static void buttonRedescTroll(DisplayTroll readout) {
                readout.troll.desc = new troll.fluff.Desc(readout.troll.body, readout.troll.horns, readout.troll.eyes, readout.troll.stats);
                readout.troll.body.caste=Blood.condensecaste(readout.troll.body.blood + readout.troll.body.caste);
                readout.troll.stats.recalc(readout.troll.body.caste);
                saveTroll(readout.troll);
                readout.repaint();
	}
         
        private static void buttonGenLitters(DisplayTroll readout1, DisplayTroll readout2) {
		Gson gson = new Gson();
		String txt = new String("");
		fio fileinterface = new fio();
		Name name = new Name("");
		int x = 0;
		int numbertogenerate = 150;
		while (x<numbertogenerate) {
			txt = txt + Integer.toString(Gene.littersize(readout1.troll.body.fertgene, readout2.troll.body.fertgene));
			txt = txt + ", ";
			x++;
			}
		fileinterface.save("littersizes.txt",txt);
	}
        
	private static void buttonGenTags() {
		Gson gson = new Gson();
		String txt = new String("");
		fio fileinterface = new fio();
		Name name = new Name("");
				
		int x = 0;
		int numbertogenerate = 150;
		while (x<numbertogenerate) {
			txt = txt + Tags.gethandle('?','?');
			txt = txt + ", ";
			x++;
			}
		fileinterface.save("handles.txt",txt);
	}
	        
	private static void buttonGenNames() {
		Gson gson = new Gson();
		String txt = new String("");
		fio fileinterface = new fio();
		Name name = new Name("");
				
		int x = 0;
		int numbertogenerate = 150;
		while (x<numbertogenerate) {
			txt = txt + Name.gen();
			txt = txt + ", ";
			x++;
			}
		fileinterface.save("names.txt",txt);
	}
	        
	private static void buttonGenStats() {
		Gson gson = new Gson();
		String txt = new String("");
		fio fileinterface = new fio();
				
		Stats stats = new Stats("rand");
		int x = 0;
		int numbertogenerate = 50;
		while (x<numbertogenerate) {
			stats = new Stats("rand");
			txt = txt + gson.toJson(stats);
			txt = txt + "\n\n";  // new line x 2
			x++;
			}
		fileinterface.save("stats.txt",txt);
	}
	
	private static void buttonGenElements(String incode) {
		Gson gson = new Gson();
		String txt = new String(incode);
		Element ella = new Element();
		fio fileinterface = new fio();
		int x = 0;
		int numbertogenerate = 50;
		while (x<numbertogenerate) {txt = txt + ella.getelement(incode) + ", ";x++;}
		txt = txt + "\n\n";  // new line x 2
		fileinterface.save("elements.txt",txt);
	}

	private static void buttonlands(int numbertogenerate) {
		Gson gson = new Gson();
		String txt = new String("");
		fio fileinterface = new fio();				
		Land land = new Land();
		int x = 0;
		while (x<numbertogenerate) {
			land = new Land();
			txt = txt + gson.toJson(land);
			txt = txt + "\n\n";  // new line
			x++;
			}
		fileinterface.save("lands.txt",txt);
	}	
	
	private static void buttonGenPeepers() {
		Gson gson = new Gson();
		String txt = new String("");
		fio fileinterface = new fio();				
		Eye eye = new Eye("rand");
		int x = 0;
		int numbertogenerate = 1000;
		while (x<numbertogenerate) {
			eye = new Eye("rand");
			txt = txt + gson.toJson(eye);
			txt = txt + "\n";  // new line
			x++;
			}
		fileinterface.save("peepers.txt",txt);
	}
	
	private static void buttonGenstatic() {
		String txt = new String("");
		Gene gene = new Gene();
		fio fileinterface = new fio();
		int x = 0;
		int numbertogenerate = 100;
		String[] A1 = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
				"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", 
				"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		txt = Gene.randopt(A1, numbertogenerate) + "\n\n";
		fileinterface.save("static.txt",txt);
	}
	
	private static void buttonLoadTroll(DisplayTroll readout, String filenam) {
		Gson gson = new Gson();
		fio fileinterface = new fio();
		readout.troll = gson.fromJson(fileinterface.load(filenam), Troll.class);
		readout.repaint();
	}

	private static void buttonOffspring(DisplayTroll a, DisplayTroll b, DisplayTroll c, int num) {
		if (num>50) {num=50;};
		while (num>0) {
			
			c.troll = Gene.fuck(a.troll, b.troll);
                        c.troll.desc = new troll.fluff.Desc(c.troll.body, c.troll.horns, c.troll.eyes, c.troll.stats);
			saveTroll(c.troll);
			c.repaint();
			num--;
		}
	}
		
	private static void buttonInterestStrife(int num) {		
		if (num>50) {num=50;};

		Stats stats = new Stats("");
		Strife s = new Strife();
		Interests h = new Interests();
		Element e = new Element();
		
		String[] interests;
		String element = new String("");
		String specibus = new String("");
		String weapon = new String("");
		String tag = new String("");

		String output = new String("");
		
		while (num>0) {
			tag = Tags.gethandle("?", "?");
			stats = new Stats("");
			element =   e.getelement("any");
			interests = h.getinterests(stats);
			specibus =  s.getstrifespecial(interests, stats);
			weapon =    s.getweapon(specibus);

			output = output + tag + ", " + element + "-type " + stats.role + " of " + stats.aspect + ".  ";
			output = output + "Likes " + interests[0] + ", " + interests[1] + ", and " + interests[2];
			output = output + ", and wields " + weapon + " in " + specibus + "\n";
			num--;
		}
		fio fileinterface = new fio();
		fileinterface.save("interestingstrife.txt",output);		
	}
	
	private static void saveTroll(Troll troll) {
		Gson gson = new Gson();
		String filename = new String("");
		String txt = new String("");
		fio fileinterface = new fio();
	
                        String huestr = "";
			if (troll.body.hue>99)  {huestr = Integer.toString(troll.body.hue);};
			if (troll.body.hue<100) {huestr = "0"  + Integer.toString(troll.body.hue);};
			if (troll.body.hue<10)  {huestr = "00" + Integer.toString(troll.body.hue);};
                        
			filename = filename + troll.body.blood + "-" + troll.body.fertgene.substring(0,2);
                        filename = filename + troll.body.sex + troll.body.gender + "-" + huestr + "-";
			filename = filename + troll.name.trolltag + "-";
			filename = filename + troll.stats.role + troll.stats.aspect + "-";
                        filename = filename + ".txt";
			txt = gson.toJson(troll);
			fileinterface.save(filename,txt);
		}
	

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
				
			}
		});
        
        
    }
}
