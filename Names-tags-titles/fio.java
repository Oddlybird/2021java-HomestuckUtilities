import java.io.*;
import java.util.Scanner;
@SuppressWarnings("unused")

public class fio {

	public void save(String mypath, String text) {
		// text = the string you want to save to file
		String fileSeparator = File.pathSeparator;
		String saveloc = "";
		if (text=="") {text="empty";};
		if (mypath=="") {mypath="example.txt";};
		
		try {
			FileWriter fw = new FileWriter(mypath);
			fw.write(text);
			fw.write("");
			fw.close();	
	    } catch (IOException e) {
		      System.out.println("Error saving " + text + " to " + mypath);
		    }
				
	}

	
	public static String load(String filenam) {
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
