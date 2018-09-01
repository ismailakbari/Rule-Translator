package iakbari.ruletranslator.translator;


import iakbari.ruletranslator.gui.MainFrame;


/**
 * This class shows the main GUI.
 * @author Ismail Akbari
 *
 */
public class Main {
	
	//static String input = "gui";
	/**
	 * Main method of the App. It shows the app gui.
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) throws Exception {
        
    	//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	MainFrame frame = new MainFrame();
            	frame.createAndShowGUI();
                //createAndShowGUI();
            }
        });
    }
  
}