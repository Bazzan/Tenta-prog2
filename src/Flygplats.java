import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class Klocka implements Comparable<Klocka>{
	private int timme, minuter;

	public Klocka(int timme, int minuter) {
		this.timme = timme;
		this.minuter = minuter;
	}

	public String toString() {
		return timme + ":" + minuter;
	}
	
	public int compareTo(Klocka other) {
		int cmp = timme - other.timme;
		if(timme != 0) {
			return cmp;
		}else {
			return cmp = minuter - other.minuter;
		}
	}
	
	HashMap<String, List<Klocka>> lista1 = new HashMap<>();
	static Map<Klocka,List<String>> vändMap(Map<String,List<Klocka>> orgMap){
		Map<Klocka,List<String>> ding = new TreeMap<>();
		for(Entry<String, List<Klocka>> me : orgMap.entrySet()){
			String dest = me.getKey();
			List<Klocka> tider = me.getValue();
			for(Klocka kl : tider) {
				List<String> destis = ding.get(kl);
				if(destis == null) {
					destis = new ArrayList();
					ding.put(kl, destis);
				}
				destis.add(dest);
			}
			
		}
		return ding;
	}
	
}
