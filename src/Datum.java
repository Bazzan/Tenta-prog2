import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Datum implements Comparator<Datum>{
	private int år, månad, dag;
	Map<Datum, String> tentaSchema; 
	public Datum(int år, int månad, int dag) {
		this.år = år;
		this.månad = månad;
		this.dag = dag;
	}

	public String toString() {
		return "20" + år + "-" + månad + "-" + dag;
	}

	public int hashCode() {
		return år* 1001 + månad * 101 + dag * 101;
	}
	
	public boolean equals(Object other) {
		Datum d = (Datum)other;
		if(other instanceof Datum) {
			return år == d.år && månad == d.månad && dag == d.dag;
		}else {
			return false;
		}
	}
	
	public int compareTo(Datum other) {
		int cmp = år - other.år;
		if(cmp != 0) {
			return cmp;
		}
		cmp = månad - other.månad;
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
			Set<Datum> tillfällen = nyMap.get(namna);
			if(datum == null) {
				tillfällen = new TreeSet<Datum>();
				nyMap.put(namna, tillfällen);
			}
			tillfällen.add(datum);
		}
		for(Map.Entry<String,Set<Datum>> me : nyMap.entrySet() ) {
			String namna = me.getKey();
			System.out.println(namna);
			Set<Datum> tillfällen = me.getValue();
			for(Datum d : tillfällen) {
				System.out.println(d);
			}
			System.out.println();
		}
	}




} // Dag