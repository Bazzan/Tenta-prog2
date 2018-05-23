import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

class Kassa extends JFrame {
	final String[] VAROR = { "Gurka", "Paprika", "Tomat", "Mjölk", "Yoghurt", "Grädde", "Bröd", "Müsli", "Kakor" };
	private static final double[] PRISER = {11.7,46.3,27.3,7.5,15.0,13.7,23.2,27.3,13.0};
	private HashMap<String, Double> pLista = new HashMap<>();
	
	private int tott;
	JButton b = new JButton();
	JButton nyKundKnapp = new JButton();
	JTextField antalButton = new JTextField(5);
	
	public Kassa() {
		super("Kassa");
		for(int i = 0 ; i < VAROR.length; i++) {
			pLista.put(VAROR[i],PRISER[i]);
		}
		
		JPanel north = new JPanel();
		add(north, BorderLayout.NORTH);

		nyKundKnapp = new JButton("Ny kund");
		north.add(nyKundKnapp);

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2, 1));
		add(center, BorderLayout.CENTER);
		JPanel knappar = new JPanel();
		center.add(knappar);
		knappar.setLayout(new GridLayout(3, 3, 10, 10));
		for (int i = 0; i < VAROR.length; i++) {
			b = new JButton(VAROR[i]);
			knappar.add(b);
		}
		b.addActionListener(new BLiss());
		JTextArea display = new JTextArea();
		center.add(new JScrollPane(display));

		JPanel south = new JPanel();
		add(south, BorderLayout.SOUTH);
		south.add(new JLabel("Antal: "));
		south.add(antalButton);
		south.add(new JLabel("Totalbelopp = "));
		south.add(new JLabel(String.valueOf(tott)));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}
	
	
	
	
	class BLiss implements ActionListener{
		public void actionPerformed(ActionEvent ave) {
			JButton b = (JButton)ave.getSource();
			String vara = b.getText();
			for()
		}
	}
	

	public static void main(String[] args) {
		new Kassa();
	}
}