
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Dag implements Comparable<Dag> {
	private int veckoNr, veckoDag;
	private static final String[] VDAGAR = { "Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag" };

	public Dag(int veckoNr, int veckoDag) {
		if (veckoNr < 1 || veckoNr > 53 || veckoDag < 0 || veckoDag > 6)
			throw new IllegalArgumentException();
		this.veckoNr = veckoNr;
		this.veckoDag = veckoDag;
	}
	
	@Override
	public int hashCode() {
		return veckoNr * 7 +veckoDag;
	}
	

	public boolean equals(Object other) {
		if(other instanceof Dag) {
			Dag d = (Dag) other;
			return veckoNr == d.veckoNr && veckoDag == d.veckoDag;
		}else {
			return false;
		}
	}
	
	public int compareTo(Dag other) {
		int cmp = veckoNr - other.veckoNr;
		if(cmp != 0) {
			return cmp;
		}else {
			return cmp = veckoDag - other.veckoDag;
		}
		
	}
	
	public String toString() {
		return "vecka " + veckoNr + " " + VDAGAR[veckoDag];
	}
	
	static Map<String, List<Dag>> vändMap(Map<Dag, String> vaktSchema){
		Map<String, List<Dag>> nyMap = new TreeMap<>();
		for(Map.Entry<Dag, String> entry : vaktSchema.entrySet()) {
			Dag dag = entry.getKey();
			String namn = entry.getValue();
			List<Dag> dagList = nyMap.get(namn);
			if(dagList == null) {
				dagList = new ArrayList<Dag>();
				nyMap.put(namn, dagList);
				
			}
			dagList.add(dag);
			
		}
		return nyMap;
	}
} // Dag