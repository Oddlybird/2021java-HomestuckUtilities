import javax.swing.*;        // For the GUI
import java.awt.event.*;     // To click things
import java.util.Arrays;
import com.google.gson.Gson; // java obj <-> JSON string
@SuppressWarnings("unused")


public class core {	
	
	private static void createAndShowGUI() {
		// make window
		JFrame frame = new JFrame("Names Tags & Titles");
		frame.setSize(475, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// define window
		JPanel panel = new JPanel();
		frame.add(panel);
		placeMenu(panel);
		
		// display window
		frame.setVisible(true);
	}
	
	private static void placeMenu(JPanel panel) {
		panel.setLayout(null);
        // note: setBounds(x, y, width, height), from top left
		JTextArea name = new JTextArea("Click to generate some troll names and trolltags");
		name.setBounds(10,15,450,100);
		panel.add(name);
		
		// Button		
		JButton button1 = new JButton("Generate");
		button1.setBounds(10,130,455,25);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button1.setText("Another");
				
				String display = "";
				
				for (int i=0;i<6;i++)
				{
					String txt = "";
					txt = Names.getname() + " " + Names.getname() + ", " + Tags.gethandle('?', '?');
					display = display + txt + "\n";
				}
				
				name.setText(display);
				}
			});
		panel.add(button1);
		panel.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				createAndShowGUI();
				
			}
		});
	}
	
	
}
