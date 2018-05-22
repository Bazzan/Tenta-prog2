import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Rovdjur extends JFrame {
	static final String[] DJUREN = { "Varg", "Lodjur", "Björn", "Järv", "Kungsörn" };
	Map<String, Integer> djurLista = new HashMap();
	
	JList<String> listan = new JList<>(DJUREN);
	
	JTextField djurText = new JTextField(10);
	JTextField antalText = new JTextField(5);
	JButton visaButton = new JButton("Visa");
	JButton addButton = new JButton("Addera");
	public Rovdjur() {
		
		JPanel västra = new JPanel();
		add(västra, BorderLayout.WEST);
		västra.setLayout(new BoxLayout(västra, BoxLayout.Y_AXIS));
		listan.setVisibleRowCount(5);
		listan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		västra.add(new JScrollPane(listan));
		västra.add(new JLabel("Annan art:"));
		västra.add(djurText);
		//
		
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		add(center, BorderLayout.CENTER);
		JPanel rad1 = new JPanel();
		center.add(rad1);
		rad1.add(new JLabel("Antal:"));
		rad1.add(antalText);
		JPanel rad2 = new JPanel();
		center.add(rad2);
		rad2.add(visaButton);
		visaButton.addActionListener(new VisaButtonLiss());
		rad2.add(addButton);
		addButton.addActionListener(new AddButtonLiss());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 170);
		setVisible(true);
	}

	
	
	class VisaButtonLiss implements ActionListener{
		public void actionPerformed(ActionEvent ave) {
			String str = "Djur beskådade. \n";
			for(Map.Entry<String, Integer> entry : djurLista.entrySet()) {
				str += entry.getKey()+ ": " + entry.getValue() + "\n";
			}
			JOptionPane.showMessageDialog(null, str);

		}

	}

	
	
	class AddButtonLiss implements ActionListener{
		public void actionPerformed(ActionEvent ave) {
			try {
			System.out.println(listan.getSelectedValue());
			String namn = listan.getSelectedValue();


			if(namn == null) {
				namn = djurText.getText();
			}if(namn.equals("")) {
				JOptionPane.showConfirmDialog(null, "du måste välja ett djur","ERROR", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			int antal = Integer.parseInt(antalText.getText());
			Integer gamla = djurLista.get(namn);
			System.out.println(gamla);
			if(gamla != null) {
				antal += gamla;
			}
			djurLista.put(namn, antal);
			System.out.println(djurLista);
			listan.clearSelection();
			}catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "you need to put in numbers in antal");
			}
			}
	}
	

	
//	class Djur {
//	private String namn;
//	private int antal;
//	
//	public Djur(String namn, int antal) {
//		this.namn = namn;
//		this.antal = antal;			
//	}
//	
//	public String getNamn() {
//		return namn;
//	}
//	public int getAntal() {
//		return antal;
//	}
//	@Override
//	public String toString() {
//		return getNamn() + ": " + getAntal() + " \n";
//	}
//}
	
	
	
	
	public static void main(String[] args) {
		new Rovdjur();
	}
}