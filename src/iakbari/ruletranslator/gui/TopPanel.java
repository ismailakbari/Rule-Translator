package iakbari.ruletranslator.gui;

import iakbari.ruletranslator.syntaxhighlight.xml.XmlTextPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * This class builds the top control panel of the main GUI. 
 * @author Ismail Akbari
 *
 */
public class TopPanel extends JPanel  implements ActionListener{
	
	//variables
	String rule, inMethod, fcpath;// jfilechooser path
	//boolean cst;

	//components
	JRadioButton rbN3 = new JRadioButton("Notation3");
	JRadioButton rbPOSL = new JRadioButton("POSL");
	JRadioButton rbRuleML = new JRadioButton("Datalog RuleML");
	JRadioButton rbSWRL = new JRadioButton("SWRL");
	JRadioButton rbRIF2XML = new JRadioButton("RIF2XML");
	JRadioButton rbXML2RIF = new JRadioButton("XML2RIF");
	JRadioButton rbRIFParser = new JRadioButton("RIF Parser");
	JRadioButton rbRIFQ = new JRadioButton("RIF Query");
	JRadioButton rbRIF = new JRadioButton("RIF Engine");
	
	JRadioButton rbFile = new JRadioButton("File");
	JRadioButton rbDirect = new JRadioButton("Direct");
	
	JTextField tf = new JTextField(25);
	JButton btBrowse = new JButton("Browse");	
	
	JCheckBox cb = new JCheckBox("CST Tree");


	/**
	 * components of the top control panel are added to it here. 
	 */
	public TopPanel() {
		
		//initialize the control panel variables
		rule ="n3";
		inMethod="file";
		fcpath="";
		//cst=false;
		
		// TODO Auto-generated constructor stub
		/*Dimension size = getPreferredSize();
		size.height = 250;
		setPreferredSize(size);
		*/
		setBorder(BorderFactory.createTitledBorder("Control Panel"));
		
		//set layout
		//setLayout(new GridLayout(0, 1));
		//add(firstRow());
		
		
		//set layout
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 0, 40);
		
		// cell(0,0)		
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.weightx=1;
		gbc.gridx =0;
		gbc.gridy = 0;		
		add(rbRuleSelect(), gbc);
		
		
		
				
		// cell(12,0)
		
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx=1;
		gbc.gridx =2;
		gbc.gridy = 0;		
		add(checkBox(), gbc);
		
		//---------------------------------------------------
		// cell(0,1)
		gbc.anchor = GridBagConstraints.LINE_START;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx=1;
		//gbc.gridwidth= GridBagConstraints.HORIZONTAL ; //there are two cells in previous row. so this will occupy the whole row
		gbc.gridx =0;
		gbc.gridy = 1;		
		add(fileChooser(), gbc);
		
		/*
		//cell(2,1)
		gbc.anchor = GridBagConstraints.LINE_END;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx=1;
		//gbc.gridwidth= GridBagConstraints.HORIZONTAL ; //there are two cells in previous row. so this will occupy the whole row
		gbc.gridx =2;
		gbc.gridy = 1;		
		//add(checkBox(), gbc);

		*/
	}

	public TopPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public TopPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public TopPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * This method adds rule selection radio buttons to the top panel
	 * @return
	 */
	private JPanel rbRuleSelect(){
		//rb containers
		JPanel panel = new JPanel();
		//JPanel rbInputMethod = new JPanel();
		
		// rb for rule selection
		
		rbN3.setMnemonic(KeyEvent.VK_N);
		rbN3.setSelected(true);
		rbN3.addActionListener(this);
		
		rbPOSL.setMnemonic(KeyEvent.VK_P);
		rbPOSL.addActionListener(this);		
		
		rbRuleML.setMnemonic(KeyEvent.VK_M);
		rbRuleML.addActionListener(this);
		
		rbSWRL.setMnemonic(KeyEvent.VK_S);
		rbSWRL.addActionListener(this);
		
		rbRIF2XML.setMnemonic(KeyEvent.VK_R);
		//rbRIF2XML.setSelected(true);
		rbRIF2XML.addActionListener(this);
		
		rbXML2RIF.setMnemonic(KeyEvent.VK_X);		
		rbXML2RIF.addActionListener(this);
		
		rbRIFParser.setMnemonic(KeyEvent.VK_P);		
		rbRIFParser.addActionListener(this);
		
		rbRIFQ.setMnemonic(KeyEvent.VK_Q);		
		rbRIFQ.addActionListener(this);
		
		rbRIF.setMnemonic(KeyEvent.VK_E);		
		rbRIF.addActionListener(this);
		
		// group the radio buttons
		ButtonGroup bg1 = new ButtonGroup();		
		bg1.add(rbN3);
		bg1.add(rbPOSL);
		bg1.add(rbRuleML);
		bg1.add(rbSWRL);
		bg1.add(rbRIF2XML);
		bg1.add(rbXML2RIF);
		bg1.add(rbRIFParser);
		bg1.add(rbRIFQ);
		bg1.add(rbRIF);
		
		
		JLabel lbRule = new JLabel("Input Rule:");	
		lbRule.setForeground(Color.BLUE);
		panel.add(lbRule);
		panel.add(rbN3);
		panel.add(rbPOSL);
		panel.add(rbRuleML);
		panel.add(rbSWRL);
		panel.add(rbRIF2XML);
		panel.add(rbXML2RIF);
		panel.add(rbRIFParser);
		panel.add(rbRIFQ);
		/**
		 * hide inference engine for now. 
		 */
		//panel.add(rbRIF);
		
		return panel;
		
	}
	/**
	 * This method adds input method radio buttons to the top panel
	 * @return
	 */
	private JPanel rbInputMethod(){
		//rb containers
		JPanel panel = new JPanel();
		//JPanel rbInputMethod = new JPanel();
		
		// rb for input method
		rbFile.setSelected(true);
		rbFile.setMnemonic(KeyEvent.VK_F);
		rbFile.addActionListener(this);
		
		rbDirect.setMnemonic(KeyEvent.VK_D);
		rbDirect.addActionListener(this);
		
		// group the radio buttons
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(rbFile);
		bg1.add(rbDirect); 
		
		JLabel lbInput = new JLabel("Input Method:");
		lbInput.setForeground(Color.BLUE);
		panel.add(lbInput);
		panel.add(rbFile);
		panel.add(rbDirect);
		return panel;
		
	}
	/**
	 * This method adds input method radio buttons to the top panel
	 * @return
	 */
	private JPanel fileChooser(){
		//container
		JPanel panel = new JPanel();
		//panel.setLayout(new GridBagLayout());
		//GridBagConstraints gbc = new GridBagConstraints();
		
		// components
		JLabel lb = new JLabel("Path:");
		
		btBrowse.addActionListener(this);
		
		panel.add(lb);
		panel.add(tf);
		panel.add(btBrowse);
		return panel;
		
	}
	
	/**
	 * This method adds the checkbox to the top panel.
	 * @return
	 */
	private JCheckBox checkBox(){
		//container
		//JPanel panel = new JPanel();
		//panel.setLayout(new GridBagLayout());
		//GridBagConstraints gbc = new GridBagConstraints();
		
		// components
		//JLabel lb = new JLabel("CST Tree");
		
		cb.setSelected(false);
		cb.addActionListener(this);
		return cb;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e.getSource().getClass().getName());
		// TODO Auto-generated method stub
		if(e.getSource()==rbN3 && rbN3.isSelected()){
			rule = "n3";
			
			//change the label of translate button to "Translate"
			MainFrame.btTranslate.setText("Translate");
			
			//check number of tabs
			//remove the third tab (RIF XML to RIF Presentation) in main frame
			if(MainFrame.tabPane.getTabCount()==3)
				MainFrame.tabPane.removeTabAt(2);
			//add second tab in main frame
			if(MainFrame.tabPane.getTabCount()==1)
				MainFrame.tabPane.insertTab("", null, MainFrame.pane2, "", 1);
			
			MainFrame.txtpanes = new XmlTextPane(); 
			MainFrame.pane1.setViewportView(MainFrame.txtpanes);
			MainFrame.txtpanet = new XmlTextPane(); 
			MainFrame.pane2.setViewportView(MainFrame.txtpanet);
			//SwingUtilities.updateComponentTreeUI(MainFrame.pane1);
			
			//MainFrame.frame.invalidate();			
			//MainFrame.frame.validate();
			//MainFrame.frame.repaint();
			//System.out.println(MainFrame.txtpanes.getClass().getName());
		
			MainFrame.tabPane.setTitleAt(0,"Notation3 (N3)");
			MainFrame.tabPane.setTitleAt(1,"RIF");
			if(!cb.isEnabled())
				cb.setEnabled(true);		
			cb.setSelected(false);
			
			//remove the third tab (RIF XML to RIF Presentation) in main frame
			//if(MainFrame.tabPane.getTabCount()==3)
				//MainFrame.tabPane.removeTabAt(2);
			
		}	
		if(e.getSource()==rbPOSL && rbPOSL.isSelected()){
			rule = "posl";
			
			//change the label of translate button to "Translate"
			MainFrame.btTranslate.setText("Translate");
			
			//check number of tabs
			//remove the third tab (RIF XML to RIF Presentation) in main frame
			if(MainFrame.tabPane.getTabCount()==3)
				MainFrame.tabPane.removeTabAt(2);
			//add second tab in main frame
			if(MainFrame.tabPane.getTabCount()==1)
				MainFrame.tabPane.insertTab("", null, MainFrame.pane2, "", 1);
			
			MainFrame.txtpanes = new XmlTextPane(); 
			MainFrame.pane1.setViewportView(MainFrame.txtpanes);
			MainFrame.txtpanet = new XmlTextPane(); 
			MainFrame.pane2.setViewportView(MainFrame.txtpanet);
			//SwingUtilities.updateComponentTreeUI(MainFrame.pane1);
			
			//MainFrame.frame.invalidate();			
			//MainFrame.frame.validate();
			//MainFrame.frame.repaint();
			//System.out.println(MainFrame.txtpanes.getClass().getName());
			MainFrame.tabPane.setTitleAt(0,"POSL");
			MainFrame.tabPane.setTitleAt(1,"RIF");
			if(!cb.isEnabled())
				cb.setEnabled(true);
			cb.setSelected(false);
			
			//remove the third tab (RIF XML to RIF Presentation) in main frame
			//if(MainFrame.tabPane.getTabCount()==3)
				//MainFrame.tabPane.removeTabAt(2);
		}	
		if(e.getSource()==rbSWRL && rbSWRL.isSelected()){
			rule = "swrl";
			
			//change the label of translate button to "Translate"
			MainFrame.btTranslate.setText("Translate");
			
			//check number of tabs
			//add second and third tabs to main frame
			if(MainFrame.tabPane.getTabCount()==1) {
				MainFrame.tabPane.insertTab("", null, MainFrame.pane2, "", 1);
				MainFrame.tabPane.insertTab("", null, MainFrame.pane3, "", 2);
			}	
			//add third tab to main frame
			if(MainFrame.tabPane.getTabCount()==2)
				MainFrame.tabPane.insertTab("", null, MainFrame.pane3, "", 2);
			
			MainFrame.txtpanes = new XmlTextPane(); 
			MainFrame.pane1.setViewportView(MainFrame.txtpanes);
			MainFrame.txtpanet = new XmlTextPane(); 
			MainFrame.pane2.setViewportView(MainFrame.txtpanet);
			MainFrame.tabPane.addTab("RIF (Presentation Syntax)", MainFrame.pane3);
			//SwingUtilities.updateComponentTreeUI(MainFrame.pane1);
			
			
			//MainFrame.frame.invalidate();			
			//MainFrame.frame.validate();
			//MainFrame.frame.repaint();
			//System.out.println(MainFrame.txtpanes.getClass().getName());
			MainFrame.tabPane.setTitleAt(0,"SWRL XML");
			MainFrame.tabPane.setTitleAt(1,"RIF XML");
			cb.setEnabled(false);
			cb.setSelected(false);
			//cst = false;
		}	
		if(e.getSource()==rbRuleML && rbRuleML.isSelected()){
			rule = "ruleml";
			
			//change the label of translate button to "Translate"
			MainFrame.btTranslate.setText("Translate");
			
			//check number of tabs
			//add second and third tabs to main frame
			if(MainFrame.tabPane.getTabCount()==1) {
				MainFrame.tabPane.insertTab("", null, MainFrame.pane2, "", 1);
				MainFrame.tabPane.insertTab("", null, MainFrame.pane3, "", 2);
			}	
			//add third tab to main frame
			if(MainFrame.tabPane.getTabCount()==2)
				MainFrame.tabPane.insertTab("", null, MainFrame.pane3, "", 2);
			
			MainFrame.txtpanes = new XmlTextPane(); 
			MainFrame.pane1.setViewportView(MainFrame.txtpanes);
			MainFrame.txtpanet = new XmlTextPane(); 
			MainFrame.pane2.setViewportView(MainFrame.txtpanet);
			MainFrame.tabPane.addTab("RIF (Presentation Syntax)", MainFrame.pane3);
			
			MainFrame.tabPane.setTitleAt(0,"Datalog RuleML");
			MainFrame.tabPane.setTitleAt(1,"RIF XML");
			cb.setEnabled(false);
			cb.setSelected(false);
			//cst = false;
		}	
		if(e.getSource()==rbRIF2XML && rbRIF2XML.isSelected()){
			rule = "rif2xml";
			
			//change the label of translate button to "Translate"
			MainFrame.btTranslate.setText("Translate");
			
			//check number of tabs
			//add second tab to main frame
			if(MainFrame.tabPane.getTabCount()==1) {
				MainFrame.tabPane.insertTab("", null, MainFrame.pane2, "", 1);
			}	
			//remove third tab to main frame
			if(MainFrame.tabPane.getTabCount()==3)
				MainFrame.tabPane.removeTabAt(2);
			
			MainFrame.txtpanet = new XmlTextPane(); 
			MainFrame.pane2.setViewportView(MainFrame.txtpanet);
			MainFrame.tabPane.setTitleAt(0,"RIF");
			MainFrame.tabPane.setTitleAt(1,"RIF XML");
			if(!cb.isEnabled())
				cb.setEnabled(true);
			cb.setSelected(false);
			//remove the third tab (RIF XML to RIF Presentation) in main frame
			//if(MainFrame.tabPane.getTabCount()==3)
				//MainFrame.tabPane.removeTabAt(2);
		}	
		
		if(e.getSource()==rbXML2RIF && rbXML2RIF.isSelected()){
			rule = "xml2rif";
			
			//change the label of translate button to "Translate"
			MainFrame.btTranslate.setText("Translate");
			
			//check number of tabs
			//add second and third tabs to main frame
			if(MainFrame.tabPane.getTabCount()==1)
				MainFrame.tabPane.insertTab("", null, MainFrame.pane2, "", 1);
			//remove third tab to main frame
			if(MainFrame.tabPane.getTabCount()==3)
				MainFrame.tabPane.removeTabAt(2);
			
			MainFrame.txtpanet = new XmlTextPane(); 
			MainFrame.pane2.setViewportView(MainFrame.txtpanet);
			MainFrame.tabPane.setTitleAt(0,"RIF XML");
			MainFrame.tabPane.setTitleAt(1,"RIF");
			//if(!cb.isEnabled())
				//cb.setEnabled(true);			
			cb.setEnabled(false);
			cb.setSelected(false);
			//cst = false;
			//remove the third tab (RIF XML to RIF Presentation) in main frame
			//if(MainFrame.tabPane.getTabCount()==3)
				//MainFrame.tabPane.removeTabAt(2);
		}
		
		if(e.getSource()==rbRIFParser && rbRIFParser.isSelected()){
			rule = "rifParser";
			
			//change the label of translate button to "parse"
			MainFrame.btTranslate.setText("Parse");
			
			//remove the second and third tabs in main frame
			if(MainFrame.tabPane.getTabCount()>1)
				MainFrame.tabPane.removeTabAt(1); //second
			if(MainFrame.tabPane.getTabCount()>1)
				MainFrame.tabPane.removeTabAt(1); //third which is second now after removing the second.
			
			//MainFrame.txtpanet = new XmlTextPane(); 
			//MainFrame.pane2.setViewportView(MainFrame.txtpanet);
			MainFrame.tabPane.setTitleAt(0,"RIF");
			if(!cb.isEnabled())
				cb.setEnabled(true);
			cb.setSelected(true);			
		}	
		
		if(e.getSource()==rbRIFQ && rbRIFQ.isSelected()){
			rule = "rifq";
			
			//change the label of translate button to "Run Query"
			MainFrame.btTranslate.setText("Run Query");
			
			//check number of tabs
			//add second and third tabs to main frame
			if(MainFrame.tabPane.getTabCount()==1) {
				MainFrame.tabPane.insertTab("", null, MainFrame.pane2, "", 1);
				MainFrame.tabPane.insertTab("", null, MainFrame.pane3, "", 2);
			}	
			//add third tab to main frame
			if(MainFrame.tabPane.getTabCount()==2)
				MainFrame.tabPane.insertTab("", null, MainFrame.pane3, "", 2);
			
			MainFrame.txtpanes = new XmlTextPane(); 
			MainFrame.pane1.setViewportView(MainFrame.txtpanes);
			MainFrame.txtpanet = new XmlTextPane(); 
			MainFrame.pane2.setViewportView(MainFrame.txtpanet);
			MainFrame.tabPane.addTab("Answer", MainFrame.pane3);
			//SwingUtilities.updateComponentTreeUI(MainFrame.pane1);
			
			
			//MainFrame.frame.invalidate();			
			//MainFrame.frame.validate();
			//MainFrame.frame.repaint();
			//System.out.println(MainFrame.txtpanes.getClass().getName());
			MainFrame.tabPane.setTitleAt(0,"RIF");
			MainFrame.tabPane.setTitleAt(1,"Query");
			if(!cb.isEnabled())
				cb.setEnabled(true);
			cb.setSelected(false);	
		}		
		
		if(e.getSource()==rbRIF && rbRIF.isSelected()){
			rule = "rif";
			
			//change the label of translate button to "Reason"
			MainFrame.btTranslate.setText("Reason");
			
			if(MainFrame.tabPane.getTabCount()==1)
				MainFrame.tabPane.insertTab("", null, MainFrame.pane2, "", 1);
			//remove third tab to main frame
			if(MainFrame.tabPane.getTabCount()==3)
				MainFrame.tabPane.removeTabAt(2);
			
			MainFrame.tabPane.setTitleAt(0,"RIF - Original");
			MainFrame.tabPane.setTitleAt(1,"RIF - Inferred");
			if(!cb.isEnabled())
				cb.setEnabled(true);
			cb.setSelected(false);
			
			//if 3nd tab or 2rd has text, we use that as a start for inferencing and put that text in the first tab.
			if(MainFrame.tabPane.getTabCount()==3 && MainFrame.txtpanet2.getText().length()>0)
				MainFrame.txtpanes.setText(MainFrame.txtpanet2.getText());
			if(MainFrame.tabPane.getTabCount()==2 && MainFrame.txtpanet.getText().length()>0)
				MainFrame.txtpanes.setText(MainFrame.txtpanet.getText());
			
			//remove the third tab (RIF XML to RIF Presentation) in main frame
			//if(MainFrame.tabPane.getTabCount()==3)
				//MainFrame.tabPane.removeTabAt(2);
		}	
		
		if(e.getSource()==rbFile && rbFile.isSelected())
			inMethod = "file";
		if(e.getSource()==rbDirect && rbDirect.isSelected())
			inMethod = "direct";
		
		if(e.getSource()==btBrowse){
			JFileChooser fc = new JFileChooser();			
			//set path to the recently use directory			
			if(!fcpath.isEmpty())
				fc.setCurrentDirectory((new File(fcpath)));
			int result = fc.showOpenDialog(null);
			//System.out.println("in browse");
			 if (result == JFileChooser.APPROVE_OPTION) {
				 File file = fc.getSelectedFile();
				 //System.out.println("Selected file: " + file.getAbsolutePath());
				 fcpath = file.getAbsolutePath();
				 tf.setText(fcpath);
				 try {
					//MainFrame.ta1.setText(readFile(path, Charset.defaultCharset()));
					//MainFrame.ta1.setText(readFile(path, StandardCharsets.UTF_8));
					 MainFrame.txtpanes.setText(readFile(fcpath, StandardCharsets.UTF_8));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }

			
		}
		
		/*
		if(e.getSource()==cb)
			if(cb.isSelected())
				cst = true;
			else
				cst = false;
		*/
		
		//reset the console output
		MainFrame.txtpane_console.setText("Warnings/Errors: \r\n");
		//reset the target (RIF) tab's output
		MainFrame.txtpanet.setText("");
		
	}

	/**
	 * Reads the source language file and puts it in the source text area.
	 * @param path
	 * absolute path to the input file.
	 * @param encoding
	 * file encoding. default is UTF-8
	 * @return
	 * returns the file content as a String;
	 */
	static String readFile(String path, Charset encoding) throws IOException {
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}

}
