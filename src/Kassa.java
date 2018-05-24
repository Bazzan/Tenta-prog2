import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

class Kassa extends JFrame {
	private static final String[] VAROR = { "Gurka", "Paprika", "Tomat", "Mjölk", "Yoghurt", "Grädde", "Bröd", "Müsli", "Kakor" };
	private static final double[] PRISER = {11.7,46.3,27.3,7.5,15.0,13.7,23.2,27.3,13.0};
	private HashMap<String, Double> pLista = new HashMap<>();
	
	private double tott = 0.0;
	JLabel tottB = new JLabel();
	JButton b = new JButton();
	JButton nyKundKnapp = new JButton();
	JTextField antalText = new JTextField(5);
	JTextArea display = new JTextArea();
	public Kassa() {
		super("Kassa");
		for(int i = 0 ; i < VAROR.length; i++) {
			pLista.put(VAROR[i],PRISER[i]);
		}
		
		JPanel north = new JPanel();
		add(north, BorderLayout.NORTH);

		nyKundKnapp = new JButton("Ny kund");
		north.add(nyKundKnapp);
		nyKundKnapp.addActionListener(new KundLiss());
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2, 1));
		add(center, BorderLayout.CENTER);
		JPanel knappar = new JPanel();
		center.add(knappar);
		
		BLiss bLiss = new BLiss();
		knappar.setLayout(new GridLayout(3, 3, 10, 10));
		for (int i = 0; i < VAROR.length; i++) {
			b = new JButton(VAROR[i]);
			knappar.add(b);
			b.addActionListener(bLiss);

		}

		center.add(new JScrollPane(display));

		JPanel south = new JPanel();
		add(south, BorderLayout.SOUTH);
		south.add(new JLabel("Antal: "));
		south.add(antalText);
		south.add(new JLabel("Totalbelopp = "));
		tottB = new JLabel(""+tott);
		south.add(tottB);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}
	
	class KundLiss implements ActionListener{
		public void actionPerformed (ActionEvent ave) {
			tott = 0.0;
			tottB.setText("" + tott);
			display.setText("");
			antalText.setText("");
		}
	}
	
	
	class BLiss implements ActionListener{
		public void actionPerformed(ActionEvent ave) {
			try {
					
				JButton b = (JButton)ave.getSource();
				String vara = b.getText();
				int antal = Integer.parseInt(antalText.getText());
				double pris = pLista.get(vara);
				String str = antal + " " +vara  + ": " + (pris * antal)+ "\n";
				tott += pris * antal;
				System.out.println(tott);
				display.append(str);
			
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "wrong format");
			}
			
		}
	}

	public static void main(String[] args) {
		new Kassa();
	}
}