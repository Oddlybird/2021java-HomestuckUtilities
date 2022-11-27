/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dancestry;

/**
 *
 * @author wirri
 */
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
@SuppressWarnings("unused")

// graphics go here?


// do conversion between json strings and java objects separately, as needed, not here.

// given a java object named myobj of type myClass
// Gson gson = new Gson();
// String outtxt = gson.toJson(myobj);
// outtxt = the json version

// given a json txt string jtxt
// Gson gson = new Gson();
// myClass myobj = gson.fromJson(jtxt);
// myobj is object of type myclass containing jtxt

public class fio {


// load an img from file. filename = "test.jpg" or etc.  PNG, JPG, GIF, BMP.
	public static BufferedImage loadimg(String filename) {
		BufferedImage img = null;
		try {img = ImageIO.read(new File(filename));} catch (IOException e) {}		
		return img;		
	}

/* simple version
boolean Graphics.drawImage(Image img,
                   int x, int y,
                   ImageObserver observer);
*/	
/*  overloaded version
boolean Graphics.drawImage(Image img,
    int destx1, int desty1, int destx2, int desty2, // area of destination to cover with source
    int srcx1,  int srcy1,  int srcx2,  int srcy2,  // area of source to cover destination
    ImageObserver observer);					    // it will auto-scale them if different sizes
*/  
/* 	BufferedImage img = new BufferedImage(width,height,type); */
	
// save image
	public static void saveimg (BufferedImage img, String name) {
		String filename = name;
		try {
		    File outputfile = new File(filename);
		    ImageIO.write(img, "png", outputfile);
		} catch (IOException e) {}}
	
	
// txt file loading
	// Save string as text file
	public void save(String mypath, String text) {
		// text = the string you want to save to file
		if (text=="") {text="empty";};
		if (mypath=="") {mypath="example.txt";};
		
		try {
			FileWriter fw = new FileWriter(mypath, true);
			fw.write(text);
			//fw.write("\n\n");
			fw.close();	
	    } catch (IOException e) {
		      System.out.println("Error saving " + text + " to " + mypath);
		    }
				
	}

	
// load and return string from text file
	public String load(String filenam) {
		String text = "";		
        try {
			text = new String(Files.readAllBytes(Paths.get(filenam)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;		
	}

//
	// load and return string from text file
	public String load1(String filenam) {
			String text = "";
			
			try {
		        File myObj = new File(filenam);
		        Scanner myReader = new Scanner(myObj);
		        while (myReader.hasNextLine()) {
		          text = text + myReader.nextLine();
		        }
		        myReader.close();
		      } catch (FileNotFoundException e) {
		        System.out.println("Error loading file " + filenam);
		      }
			return text;		
		}

}