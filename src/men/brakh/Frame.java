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
	static String onlyRus(String s) {
		return s.replaceAll("[^А-Яа-я�]", "").toUpperCase();
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
		JTextField encodetf = new JTextField(1);
		encodetf.setBackground(new Color(204, 166, 166));
		encodetf.setText("Enter key");
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
		encode.setSelected(true);
		english.setSelected(true);
		Pleifer.setSelected(true);
		File Source = new File("C:\\Users\\MI\\Documents\\GitHub\\lol\\Lab1_TI\\src\\men\\brakh\\Source.txt");
		File Encoded = new File("C:\\Users\\MI\\Documents\\GitHub\\lol\\Lab1_TI\\src\\men\\brakh\\Encoded.txt");
		File decoded = new File("C:\\Users\\MI\\Documents\\GitHub\\lol\\Lab1_TI\\src\\men\\brakh\\Decoded.txt");
		String SourceString = Field.readFile2(Source);
		String EncodedString = Field.readFile2(Encoded);
		Frame app = new Frame();
		JPanel panel = new JPanel(new  GridLayout(6,3));
		app.add(panel);
		app.getContentPane().setBackground(Color.darkGray);
		 JButton encodeButton = new JButton();
		encodeButton.setText("Perfom Action");
		
		encodeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			String message = SourceString;
			String	key = encodetf.getText();

				String OutputString = "";
			if (russian.isSelected()){
				message=Frame.onlyRus(message);

			} else{
				message=Frame.onlyEng(message);
			}
			//String key = keyString;
			if (encode.isSelected()){
				if (Viginer.isSelected()){
					Viginer vg = new Viginer();
					 OutputString = vg.encode(message,key);
				}
				if (Pleifer.isSelected()){
					Pleifer pf = new Pleifer();
					 OutputString = pf.encode(message,key);
				}
				if (Railway.isSelected()){
					RailWay rw = new RailWay();
					 OutputString = rw.encode(message,key);
				}
			}	else{
				if (Viginer.isSelected()){
					Viginer vg = new Viginer();
					 OutputString = vg.decode(message,key);
				}
				if (Pleifer.isSelected()){
					Pleifer pf = new Pleifer();
					 OutputString = pf.decode(message,key);
				}
				if (Railway.isSelected()){
					RailWay rw = new RailWay();
					 OutputString = rw.decode(message,key);
				}
			}
				FileWriter fw = null;
				try {
					if( encode.isSelected()){
						fw = new FileWriter(Encoded);
					}
					if (decode.isSelected()){
						fw = new FileWriter(Decoded);
					}

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {

					assert fw != null;
					fw.write(OutputString);
					fw.flush();

					fw.close();}catch (IOException ignored){

				}


			}
		}
            );
		panel.add(encodetf);
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
