package men.brakh;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame extends JFrame {
    static String onlyEng(String s) {
        return s.replaceAll("[^A-Za-z�]", "").toUpperCase();
    }


	public Frame() {
		super("Enter Key and Text to shifr");

		
		
		setBounds(100,100,400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
public static class Field extends JTextField{
	public Field() {
		
	}
	private static String readFile2(File fin) throws IOException {

		Viginer pf = new Viginer();
		System.out.println(pf.encode("CRYPTOGRAPHY","MODE"));
		FileInputStream fis = new FileInputStream(fin);

		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String OUT = "";
		String line = "";
		while ((line = br.readLine()) != null) {
			OUT +=line;
		}

		br.close();
		return OUT;
	}

}
	public static void main(String[] args) throws IOException {
		Pleifer pf = new Pleifer();
		File input = new File("C:\\Users\\User\\Documents\\GitHub\\Lab1_TI\\src\\men\\brakh\\Input.txt");
		File output= new File("C:\\Users\\User\\Documents\\GitHub\\Lab1_TI\\src\\men\\brakh\\Output.txt");

		String inputString = Field.readFile2(input);
		FileWriter fw = new FileWriter(output);
		if (inputString!=null){
			try {
				fw.write(pf.encode(inputString,""));
				fw.flush();
			}catch (IOException e){

			}
		}
		fw.close();


		//System.out.println(pf.encode("inputString",1));
		//System.out.println(pf.decode(pf.encode("CIPHERTEXT",1),1));

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
			String encodedMessage = rw.encode(message, key);
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
				String decodedMessage = rw.decode(message,key);
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
		
		
		app.setVisible(true);
	}

}
