/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dancestry;

/**
 *
 * @author wirri
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import troll.Troll;
import troll.husk.Blood;
@SuppressWarnings("unused")


public class DisplayTroll extends JPanel {
	private static final long serialVersionUID = -9172896193774508764L;
	Troll troll = new Troll("blank");
	Boolean describe = false;  // whether to show Just Code or descriptive text

	public DisplayTroll() {
	};
	
	// implement troll(blank)
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawText(g);

    }

    private void drawText(Graphics g) {
    	Color bloodcol = Blood.colorfromcode(troll.body.blood);
    	
        g.setColor(bloodcol);
        
        String namestr = troll.name.hatchname + " " + troll.name.signname + ", " + troll.name.trolltag;
        String castestr = troll.body.caste + " " + String.valueOf(troll.body.hue) + troll.body.blood;
        castestr = castestr + " (" + bloodcol.getRed() + ", " + bloodcol.getGreen() + ", " + bloodcol.getBlue() + ")";
        // statblock goes ... later.  Its own object maybe?
        // String cloutstr = "Clout " + String.valueOf(troll.stats.clout);
        String classpectstr = troll.stats.role + " of " + troll.stats.aspect + ", " + troll.specibus;
        String intereststr = troll.interests[0] + ", " + troll.interests[1] + ", " + troll.interests[2];
        String bodystr = "build: " + troll.body.buildgene + ", " + troll.body.sex;
        String pupastr = "pupa: " + troll.body.pupation;
        String limbstr = "limbs: " + troll.body.feralgene + "-" + troll.body.tailgene;
        String skinstr = "skin: " + troll.body.skingene;
        String seastr = "sea: " + troll.body.respiratorygene;
        String finstr = "fin: " + troll.body.fingene;
        String hr = troll.horns.rgene.shortform();
        String hl = troll.horns.lgene.shortform();
        String er = troll.eyes.righteye;
        String el = troll.eyes.lefteye;
        String es = troll.eyes.strayeye;
        
        int column1 = 10;
        int rowstart = 15;
        int rowheight = 15;
        g.drawString(namestr,      column1,  rowstart + 0*rowheight);
        g.drawString(castestr,     column1,  rowstart + 1*rowheight);
        g.drawString(classpectstr, column1,  rowstart + 2*rowheight);
        g.drawString(intereststr,  column1,  rowstart + 3*rowheight);
        g.drawString(bodystr,      column1,  rowstart + 4*rowheight);
        g.drawString(pupastr,      column1,  rowstart + 5*rowheight);
        g.drawString(limbstr,      column1,  rowstart + 6*rowheight);
        g.drawString(skinstr,      column1,  rowstart + 7*rowheight);
        g.drawString(seastr,       column1,  rowstart + 8*rowheight);
        g.drawString(finstr,       column1,  rowstart + 9*rowheight);
        g.drawString(hr,           column1,  rowstart + 10*rowheight);
        g.drawString(hl,           column1,  rowstart + 11*rowheight);

        g.drawString(er,           column1,  rowstart + 13*rowheight);
        g.drawString(el,           column1,  rowstart + 14*rowheight);
        g.drawString(es,           column1,  rowstart + 15*rowheight);

        
        
    }

}