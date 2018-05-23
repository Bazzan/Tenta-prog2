import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Plats {
	private int rad;
	private String stol;

	public Plats(int rad, String stol) {
		if (rad < 1 || rad > 30
				|| !(stol.equals("A") || stol.equals("B") || stol.equals("C") || stol.equals("D") || stol.equals("E")))
			throw new IllegalArgumentException();
		this.rad = rad;
		this.stol = stol;
	}

	public int getRad() {
		return rad;
	}

	public String getStol() {
		return stol;
	}

	public String toString() {
		return "" + rad + stol;
	}

	public int compareTo(Plats other) {
		if (rad > other.rad) {
			return 1;
		} else if (other.rad > rad) {
			return -1;
		} else {
			return stol.compareTo(other.stol);
		}
	}

	// public boolean equals(Object other) {
	// Plats p = (Plats) other;
	// if(other instanceof Plats) {
	// return rad == p.rad && stol == p.stol;
	// }else {
	// return false;
	// }
	// }
	//
	// public int hashCode() {
	// return rad * 31;
	// }
	//}

				
	static void sortPlats(TreeMap<Plats, String> pLista) {
		for (Map.Entry<Plats, String> plats : pLista.entrySet()) {
			System.out.println(plats.getKey() + plats.getValue());
		}
	}
	//korta varianten
	static void listByName(TreeMap<Plats,String> pLista) {
		ArrayList<String> lista = new ArrayList<String>();
		for(Map.Entry<Plats,String> me : pLista.entrySet()) {
			lista.add("" +me.getValue() + me.getKey());
		}
		
		Collections.sort(lista);
			for(String rad : lista) {
				System.out.println(rad);
			}
	}
	
	
		// det svåra och mer utvecklade sättet
//	class PlatsONamn {
//		private Plats plats;
//		private String namn;
//
//		PlatsONamn(Plats plats, String namn) {
//			this.plats = plats;
//			this.namn = namn;
//
//		}
//
//		public String getNamn() {
//			return namn;
//		}
//
//		public String toString() {
//			return plats + ": " + namn;
//		}
//	}
//
//	class NamnCmp implements Comparator<PlatsONamn> {
//		public int compare(PlatsONamn pon1, PlatsONamn pon2) {
//			return pon1.getNamn().compareTo(pon2.getNamn());
//		}
//	}
//
//	static void sortByName(TreeMap<Plats, String> pLista) {
//		ArrayList<PlatsONamn> ponLista = new ArrayList<PlatsONamn>(); 
//		for(Map.Entry<Plats,String> me : pLista.entrySet()) {
//			ponLista.add(new PlatsONamn(me.getKey() , me.getValue()));
//		}
//		
//		Collections.sort(ponLista, NamnCmp());
//			for(PlatsONamn pon : ponLista) {
//				System.out.println(pon);
//			}
//		
//	}
	
}
