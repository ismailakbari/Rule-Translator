package iakbari.ruletranslator.logger;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 * This class extends from OutputStream to redirect output to a JTextArrea
 * @author www.codejava.net
 *
 */
public class CustomOutputStream extends OutputStream {
	private JTextPane textPane;

	public CustomOutputStream(JTextPane textPane) {
		this.textPane = textPane;
	}

	@Override
	public void write(int b) throws IOException {
		// redirects data to the text area
        //textArea.append(String.valueOf((char)b));
		Document doc = textPane.getStyledDocument();
	    try {
			doc.insertString(doc.getLength(), String.valueOf((char)b), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // scrolls the text area to the end of data
        //textArea.setCaretPosition(textArea.getDocument().getLength());
	}
}