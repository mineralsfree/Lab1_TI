package men.brakh;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import men.brakh.*;
public class Frame extends JFrame {
    static String onlyEng(String s) {
        return s.replaceAll("[^A-Za-z¿]", "").toUpperCase();
    }


	public Frame() {
		super("Enter Key and Text to shifr");

		
		
		setBounds(100,100,400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
public class Field extends JTextField{
	public Field() {
		
	}
}
	public static void main(String[] args) {
		Frame app = new Frame();
		JRadioButton jbEncode = new JRadioButton("encode");
		JRadioButton jbDecode = new JRadioButton("decode");
		
		JPanel panel = new JPanel(new  GridLayout(6,3));
		app.add(panel);
		//app
		app.getContentPane().setBackground(Color.darkGray);
		 JTextField encodetf = new JTextField(1);
		 JTextArea encodeta= new JTextArea();
		 JTextField decodetf = new JTextField(1);
		 JTextArea decodeta = new JTextArea();
		 JButton encodeButton = new JButton();
		 JButton decodeButton = new JButton();
		 JTextArea ta2 = new JTextArea();
		 
		 decodetf.setText("Enter Decode key");
		 decodeta.setText("Enter String to Decode");
		 
		 encodetf.setBackground(new Color(204, 166, 166));		 
		 encodetf.setText("Enter key");
		 encodeta.setText("Enter text to encode");
		encodeButton.setText("encode");
		decodeButton.setText("decode");
		
		encodeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			String	key = encodetf.getText();
			String	message = encodeta.getText();
			message = onlyEng(message);
			
			message.toUpperCase();
			RailWay rw = new RailWay();	
			String encodedMessage = rw.encode(message, Integer.parseInt(key));
			ta2.setText("");
			ta2.setText(encodedMessage);
			encodetf.setText(encodedMessage);
			}
		}
            );
		decodeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String	key = decodetf.getText();
				String	message = decodeta.getText();
				message = onlyEng(message);
				
				message.toUpperCase();
				RailWay rw = new RailWay();	
				String decodedMessage = rw.decode(message, Integer.parseInt(key));
				ta2.setText("");
				ta2.setText(decodedMessage);
				decodetf.setText(decodedMessage);
				
			}
		});
		panel.add(encodetf);
		panel.add(encodeta);
		
		panel.add(encodeButton);
		panel.add(decodetf);
		panel.add(decodeta);
		panel.add(decodeButton);

//		panel.add(jbEncode);
	//	panel.add(jbDecode);
		
		
		app.setVisible(true);
	}

}
