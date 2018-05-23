import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

class KartPanel extends JPanel {
	private ImageIcon bild = new ImageIcon("plan6.png");
	private int x, y;
	private boolean visas = false;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bild.getImage(), 0, 0, this);
		if (visas) {
			g.setColor(Color.BLACK);
			g.fillOval(x - 10, y - 10, 15, 15);
		}
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setVisas(boolean b) {
		visas = b;
		repaint();
	}
}

class Karta extends JFrame {
	String[] namn = { "Andrea", "Bea", "Birger", "Björn", "Dan", "David", "Elin", "Gustaf", "Henrik", "Ilja", "Jozef",
			"Lena", "Leon", "Louise", "Maria", "Martin", "Matts", "Patrik", "Paul", "Stefan", "Stewart", "Tessi" };
	public JList<String> folkList = new JList<>(namn);
	KartPanel kp;
	JButton visaButton = new JButton("Visa");
	JButton angeButton = new JButton("Ange");
	
	Map<String , Point> posLista = new HashMap<>();
	Karta() {
		JPanel höger = new JPanel();
		add(höger, BorderLayout.WEST);
		
		
		folkList.setVisibleRowCount(20);
		höger.add(new JScrollPane(folkList));
		
		KartPanel kp = new KartPanel();
		add(kp, BorderLayout.CENTER);
		
		JPanel knappPanel = new JPanel();
		add(knappPanel, BorderLayout.SOUTH);
		
		knappPanel.add(visaButton);
//		visaButton.addActionListener(new VisaButtonLiss);
		knappPanel.add(angeButton);
//		angeButton.addActionListener(new AngeButtonLiss);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(630, 450);
		setVisible(true);
	}
	
	class AngeButtonLiss implements ActionListener{
		public void actionPerformed(ActionEvent ave) {
			kp.setVisas(false);
			kp.addMouseListener(new MusLiss());
		}
		class MusLiss extends MouseAdapter{
			@Override
			public void mouseClicked(MouseEvent mev) {
				int x = getX();
				int y = getY();
				if(folkList.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "you need to select a person");
				}
				String namn;
				namn = folkList.getSelectedValue();
				posLista.put(namn, new Point(x,y));
				kp.setXY(x, y);
				kp.setVisas(true);
				kp.removeMouseListener(this);
				
			}
			
		}
		
	}
	
	class VisaLiss implements ActionListener{
		public void actionPerformed(ActionEvent ave) {
			String namn = folkList.getSelectedValue();
			Point point = posLista.get(namn);
			kp.setXY(point.x,point.y);
			kp.setVisas(true);
		}
	}

	public static void main(String[] args) {
		new Karta();
	}
}