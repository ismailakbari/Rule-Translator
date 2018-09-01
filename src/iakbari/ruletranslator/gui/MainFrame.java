package iakbari.ruletranslator.gui;

import iakbari.ruletranslator.logger.CustomOutputStream;
import iakbari.ruletranslator.translator.inputHandler;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class MainFrame implements ActionListener{
	
	//components
	//Create and set up the window.
    static JFrame frame = new JFrame("Rule Translator");
	static TopPanel tpanel = new TopPanel(); 
	static JScrollPane pane1, pane2, pane3;
	//components
	static JLabel lb1 = new JLabel("Notation3 (N3)");
	static JLabel lb2 = new JLabel("RIF");
	//static JTextArea ta1 = new JTextArea(25,25);
	//static JTextArea ta2 = new JTextArea(25,25);
	static JTabbedPane tabPane = new JTabbedPane(JTabbedPane.SCROLL_TAB_LAYOUT, JTabbedPane.SCROLL_TAB_LAYOUT);	
	static JTextPane txtpanes = new JTextPane();
	static JTextPane txtpanet = new JTextPane();	
	static JTextPane txtpanet2 = new JTextPane();
	static JButton btTranslate = new JButton("Translate"); 
	static JTextPane txtpane_console = new JTextPane();
	private PrintStream standardOut, standardErr;
	
	public MainFrame(){
		//ta1.setLineWrap(true);
		//ta2.setLineWrap(true);
		//txtpanes.setSize(25, 25);
		//txtpanet.setSize(25, 25);
		btTranslate.addActionListener(this);	
		//setup console text pane
		setupConsoleTextPane();
	}
	
	/**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public void createAndShowGUI() {
        
        //frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set the layout manager
        frame.setLayout(new GridBagLayout());
        //create components and add them to the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

	private static void addComponentsToPane(Container contentPane) {
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		// cell(0,0) = top panel		
		//gbc.anchor = GridBagConstraints.NORTH;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		//gbc.weighty=1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx =0;
		gbc.gridy = 0;		
		
		contentPane.add(tpanel, gbc);
		
		// cell(0,1) = bottom panel		
		gbc.weighty=1;
		gbc.gridx =0;
		gbc.gridy = 1;		
		contentPane.add(bottomPane(), gbc);
	}

	/**
	 * This method creates the bottom panel of the main frame.
	 * @return
	 */
	/*
	private static Component bottomPane2() {
		
		JPanel panel = new JPanel();
		
		//set layout
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20,0,0,0);
		//gbc.fill = GridBagConstraints.BOTH;
		
		
		
		
		gbc.anchor = GridBagConstraints.CENTER ;
		//gbc.fill = GridBagConstraints.BOTH;
		//gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.weightx = 5;
		//gbc.weighty=5;
		gbc.gridx =0;
		gbc.gridy = 0;		
		//panel.add(ta1, BorderLayout.WEST);
		panel.add(lb1, gbc);
		// cell(1,0)
		
		
		
		// cell(2,0)	
		
		gbc.anchor = GridBagConstraints.CENTER ;
		//gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx=5;
		//gbc.weighty=5;
		gbc.gridx =2;
		gbc.gridy = 0;		
		//panel.add(ta2, BorderLayout.EAST);
		panel.add(lb2, gbc);
		
		//gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.fill = GridBagConstraints.BOTH;
		//gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(2,20,20,2);
		gbc.weightx = 5;
		gbc.weighty=5;
		gbc.gridx =0;
		gbc.gridy = 1;		
		
		//panel.add(ta1, BorderLayout.WEST);
		//make text area scrollable 
		//JScrollPane jsp1 = new JScrollPane(ta1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);		
		JScrollPane jsp1 = new JScrollPane(txtpanes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp1.setPreferredSize(new Dimension(200, 400));
		panel.add(jsp1, gbc);
		// cell(1,0)
		
		//bc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx=1;
		gbc.gridx =1;
		gbc.gridy = 1;		
		//panel.add(bt, BorderLayout.CENTER);
		panel.add(btTranslate, gbc);
		
		// cell(2,0)	
		
		//gbc.anchor = GridBagConstraints.LINE_END ;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(2,2,20,20);
		gbc.weightx=5;
		gbc.weighty=5;
		gbc.gridx =2;
		gbc.gridy = 1;		
		//panel.add(ta2, BorderLayout.EAST);
		//make text area scrollable 
		//JScrollPane jsp2 = new JScrollPane(ta2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);		
		JScrollPane jsp2 = new JScrollPane(txtpanet, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp2.setPreferredSize(new Dimension(200, 400));
		panel.add(jsp2, gbc);
		//panel.add(ta2, gbc);
		
		
		return panel;
	}

	*/
	/**
	 * This method creates the bottom panel of the main frame.
	 * @return
	 */
	private static Component bottomPane() {
		
		pane1 = new JScrollPane(txtpanes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);		
    	pane2 = new JScrollPane(txtpanet, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	pane3 = new JScrollPane(txtpanet2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	
    	
    	tabPane.setPreferredSize(new Dimension(1000, 400));

    	    	
    	tabPane.addTab("Notation3 (N3)", pane1);
    	tabPane.addTab("RIF", pane2); 
    	//tabPane.addTab("RIF (Presentation Syntax)", pane3);
    	
    	
    	
		
		JPanel panel = new JPanel();
		
		//set layout
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20,0,0,0);
		//gbc.fill = GridBagConstraints.BOTH;
		
		
		
		
		//gbc.anchor = GridBagConstraints.BOTH ;
		gbc.fill = GridBagConstraints.BOTH;
		//gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.weightx = 5;
		//gbc.weighty=5;
		gbc.gridx =0;
		gbc.gridy = 0;		
		//panel.add(ta1, BorderLayout.WEST);
		panel.add(tabPane, gbc);
		// cell(1,0)
		
		
		//btTranslate.setPreferredSize(new DimensionUIResource(50, 30));
		//gbc.anchor = GridBagConstraints.LINE_START;
		//gbc.anchor = GridBagConstraints.CENTER;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		
		// cell(2,0)	
		//gbc.anchor = GridBagConstraints.LINE_START;
		//bc.anchor = GridBagConstraints.CENTER;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		//add a fake label to fill the space
		
		JPanel row_translate = new JPanel();
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0,0,0,0);		
		gbc.gridx =0;
		gbc.gridy = 0;			
		row_translate.add(btTranslate, gbc);
		
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx=1;
		gbc.gridx =0;
		gbc.gridy = 1;		
		panel.add(row_translate, gbc);
		
		//add console text pane		
		/*txtpane_console.setPreferredSize(new Dimension(1000, 100));
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0,0,0,0);		
		gbc.gridx =0;
		gbc.gridy = 0;			
		*/
		JScrollPane  jsPaneConsole = new JScrollPane(txtpane_console, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//jsPaneConsole.setPreferredSize(new Dimension(1000, 100));
		//jsPaneConsole.add(txtpane_console, gbc);
		//console tab
		JTabbedPane tabPaneConsole = new JTabbedPane(JTabbedPane.SCROLL_TAB_LAYOUT, JTabbedPane.SCROLL_TAB_LAYOUT);
		//add console messages row to a tabbed pane
		tabPaneConsole.setPreferredSize(new Dimension(1000, 200));
		tabPaneConsole.addTab("Console", jsPaneConsole);
		//add console tabbed pane to the main frame
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx=1;
		gbc.gridx =0;
		gbc.gridy = 2;		
		panel.add(tabPaneConsole, gbc);
		
		return panel;
	}	

	@Override
	/**
	 * This method calls the translation handler class.
	 */
	public void actionPerformed(ActionEvent e) {
		
		inputHandler handler = new inputHandler();
		String target, target2;
		Document docConsole;
		
		try {
			if(e.getSource() == btTranslate){
				//reset the console output
				txtpane_console.setText("Warnings/Errors: \r\n");
				
				switch(tpanel.rule){    
		    	
				//input with one tab
				case "rifParser":
					
				//inputs with two tabs
				case "n3":  
				case "posl":				
				case "rif2xml":
				case "xml2rif":
				case "rif":
					
				//input with three tabs
				case "ruleml":
				case "swrl":
					
					//String target = handler.translate(tpanel.rule, ta1.getText(), tpanel.cst);
					target = handler.translate(tpanel.rule, txtpanes.getText(), null, tpanel.cb.isSelected());
					//ta2.setText(target);
					txtpanet.setText(target);
					docConsole = txtpane_console.getDocument();
					//if the source input is empty
					if(txtpanes.getText().trim().isEmpty())
						docConsole.insertString(docConsole.getLength(), "\nYour input is empty.\r\n", null);
					
					docConsole.insertString(docConsole.getLength(), "\r\nDONE!", null);
					
					/**
					 * check if the source language is SWRL or RuleML, translate the result in RIF XML to
					 * RIF in presentation (human-readable) syntax). 
					*/ 
					if(tpanel.rule.equalsIgnoreCase("SWRL") || tpanel.rule.equalsIgnoreCase("RuleML")) {
						/*File file = new File("xslt/swrl2.rif.xml");					 
						BufferedReader br = new BufferedReader(new FileReader(file));					 
						String st;
						String text="";
						while ((st = br.readLine()) != null) {
						  System.out.println(st);
						  text += st;
						}  
						*/  
						target2 = handler.translate("xml2rif", target, null, tpanel.cb.isSelected());
						txtpanet2.setText(target2);
						//System.out.println("target2 >>\n" + target2);					
					}
					
				    break;
				    
				case "rifq":
					
					//String target = handler.translate(tpanel.rule, ta1.getText(), tpanel.cst);
					/**
					 * //read the RIF KB (tab 1) and the query (tab 2) and put the query result in target2 (tab 3)
					 */
					target2 = handler.translate(tpanel.rule, txtpanes.getText(), txtpanet.getText(), tpanel.cb.isSelected());
					//ta2.setText(target);
					txtpanet2.setText(target2);
					docConsole = txtpane_console.getDocument();
					//if the source input is empty
					if(txtpanes.getText().trim().isEmpty() || txtpanet.getText().trim().isEmpty())
						docConsole.insertString(docConsole.getLength(), "\nRIF KB or Query is empty.\r\n", null);					
					docConsole.insertString(docConsole.getLength(), "\r\nDONE!", null);
					
					break;	
				
					
		    	} //switch 
				
			}//if
			
			/*
			 * if(e.getSource() == btTranslate){
				//check the input method
				if(tpanel.inMethod.equalsIgnoreCase("file"))
						handler.translate(tpanel.rule, tpanel.inMethod, tpanel.path, tpanel.cst);
					
				else
					handler.translate(tpanel.rule, tpanel.inMethod, ta1.getText(), tpanel.cst); //direct input
			}//if
			*/
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//catch
 catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}//method
	
	private void setupConsoleTextPane(){
		//setup console text pane
		//txtpane_console = new JTextPane();
		txtpane_console.setText("Warnings/Errors: \r\n");		
		txtpane_console.setEditable(false);
		PrintStream printStream = new PrintStream(new CustomOutputStream(txtpane_console));		
		// keeps reference of standard output stream
		standardOut = System.out;
		standardErr = System.err;
		// re-assigns standard output stream and error output stream
		//System.setOut(printStream);
		System.setErr(printStream);
	}

}
