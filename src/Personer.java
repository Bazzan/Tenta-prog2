import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Personer {

	class Personnr {
		private int datum, nr; // f�delsedatum resp. l�pnr

		public Personnr(int datum, int nr) {
			this.datum = datum;
			this.nr = nr;
		}

		public int getDatum() {
			return datum;
		}

		public int getNr() {
			return nr;
		}

		public String toString() {
			return "" + datum + "-" + nr;
		}
		
		public int hashCode() {
			return datum*100001 + nr;
		}
		public boolean equals(Object other) {
			Personnr pnr = (Personnr)other;
			if(other instanceof Personnr) {
				return datum == pnr.datum && nr == pnr.nr;
			}else {
				return false;
			}
		}
		public int compareTo(Personnr other) {
			if(datum < other.datum) {
				return -1;
			}else if(datum > other.datum) {
				return 1;
			}else if(nr < other.nr) {
				return -1;
			}else {
				return 0;
			}
			
	}
		
	} // Personnr

	class Person {
		private Personnr pnr;
		private String namn;
		private double provV�rde;

		public Person(Personnr pnr, String namn, double provV�rde) {
			this.pnr = pnr;
			this.namn = namn;
			this.provV�rde = provV�rde;
		}

		public Personnr getPnr() {
			return pnr;
		}

		public String getNamn() {
			return namn;
		}

		public double getProvV�rde() {
			return provV�rde;
		}

		public String toString() {
			return pnr + " " + namn;
		}
	} // Person
	
	class Cmp�ldst implements Comparator<Person>{
		public int compare(Person p1, Person p2) {
			return p1.getPnr().compareTo(p2.getPnr());
		}
	}
	class CmpYngst implements Comparator<Person>{
		public int compare(Person p1, Person p2) {
			return p2.getPnr().compareTo(p1.getPnr());
		}
	}
	
	class CmpAlfa implements Comparator<Person>{
		public int compare(Person p1, Person p2) {
			return p1.getNamn().compareTo(p2.getNamn());
		}
	}
	class CmpProv implements Comparator<Person>{
		public int compare(Person p1, Person p2) {
			double pr1 = p1.getProvV�rde();
			double pr2 = p2.getProvV�rde();
			if(pr1 < pr2) {
				return -1;
			}else if(pr1 > pr2) {
				return 1;
			}else {
				return 0;
			}
			
		}
		
	}

	
	public static void skrivUt(Map<Personnr, Person> folk, int ordning) {
		ArrayList<Person> personer = new ArrayList<Person>();
		switch(ordning) {
		case 0: Collections.sort(personer, new Cmp�ldst()); break;
		case 1: Collections.sort(personer, new CmpYngst()); break;
		case 2: Collections.sort(personer, new CmpAlfa()); break;		
		case 3: Collections.sort(personer, new CmpProv()); break;
		}
		
		for(Person p : personer) {
			System.out.println(personer.toString() + p.getProvV�rde());
		}
	}
	
}
