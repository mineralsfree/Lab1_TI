package men.brakh;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;

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
		Viginer vg = new Viginer();
		RailWay rw = new RailWay();

		JRadioButton english = new JRadioButton("english");
		JRadioButton russian = new JRadioButton("russian");
		JRadioButton encode = new JRadioButton("encode");
		JRadioButton decode = new JRadioButton("decode");
		JRadioButton Pleifer = new JRadioButton("Pleifer");
		JRadioButton Railway = new JRadioButton("Railway");
		JRadioButton Viginer = new JRadioButton("Viginer");
		ButtonGroup lang = new ButtonGroup();
		ButtonGroup operation = new ButtonGroup();
		ButtonGroup Type = new ButtonGroup();
		Type.add(Pleifer);
		Type.add(Railway);
		Type.add(Viginer);
		operation.add(encode);
		operation.add(decode);
		lang.add(english);
		lang.add(russian);
		File input = new File("C:\\Users\\User\\Documents\\GitHub\\Lab1_TI\\src\\men\\brakh\\Input.txt");
		File output= new File("C:\\Users\\User\\Documents\\GitHub\\Lab1_TI\\src\\men\\brakh\\Output.txt");
		File key = new File("C:\\Users\\User\\Documents\\GitHub\\Lab1_TI\\src\\men\\brakh\\key.txt");
		String inputString = Field.readFile2(input);
		String keyString = Field.readFile2(key);
		FileWriter fw = new FileWriter(output);
		if (inputString!=null){
			try {
				fw.write(pf.encode(inputString,""));
				fw.flush();
			}catch (IOException e){

			}
		}
		fw.close();
		Frame app = new Frame();
		JPanel panel = new JPanel(new  GridLayout(6,3));
		app.add(panel);
		//app
		app.getContentPane().setBackground(Color.darkGray);

		 JButton encodeButton = new JButton();
		 JTextArea ta2 = new JTextArea();
		encodeButton.setText("Perfom Action");
		
		encodeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			String message = inputString;
			message = onlyEng(message);
			String key = keyString;
			message.toUpperCase();
			
			String encodedMessage = rw.encode(message, key);

			}
		}
            );


		panel.add(decode);
		panel.add(encode);
		panel.add(russian);
		panel.add(english);
		panel.add(Pleifer);
		panel.add(Railway);
		panel.add(Viginer);
		panel.add(encodeButton);

		
		
		app.setVisible(true);
	}

}
