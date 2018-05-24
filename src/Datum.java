import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Datum implements Comparator<Datum>{
	private int �r, m�nad, dag;
	Map<Datum, String> tentaSchema; 
	public Datum(int �r, int m�nad, int dag) {
		this.�r = �r;
		this.m�nad = m�nad;
		this.dag = dag;
	}

	public String toString() {
		return "20" + �r + "-" + m�nad + "-" + dag;
	}

	public int hashCode() {
		return �r* 1001 + m�nad * 101 + dag * 101;
	}
	
	public boolean equals(Object other) {
		Datum d = (Datum)other;
		if(other instanceof Datum) {
			return �r == d.�r && m�nad == d.m�nad && dag == d.dag;
		}else {
			return false;
		}
	}
	
	public int compareTo(Datum other) {
		int cmp = �r - other.�r;
		if(cmp != 0) {
			return cmp;
		}
		cmp = m�nad - other.m�nad;
		if(cmp != 0) {
			return cmp;
		}
		return cmp = dag - other.dag;
	}

	static void listaTentorPerKurs(Map<Datum, String> schema) {
		Map<String, Set<Datum>> nyMap = new TreeMap<>();
		for(Map.Entry<Datum, String> me : schema.entrySet()) {
			String namna = me.getValue();
			Datum datum = me.getKey();
			Set<Datum> tillf�llen = nyMap.get(namna);
			if(datum == null) {
				tillf�llen = new TreeSet<Datum>();
				nyMap.put(namna, tillf�llen);
			}
			tillf�llen.add(datum);
		}
		for(Map.Entry<String,Set<Datum>> me : nyMap.entrySet() ) {
			String namna = me.getKey();
			System.out.println(namna);
			Set<Datum> tillf�llen = me.getValue();
			for(Datum d : tillf�llen) {
				System.out.println(d);
			}
			System.out.println();
		}
	}




} // Dag