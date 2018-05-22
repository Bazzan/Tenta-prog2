
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

abstract public class Varelse {
	private String namn;

	List<SkogsF�rem�l> samling = new ArrayList<>();
	public Varelse(String namn) {
		this.namn = namn;
		
	}
	protected abstract boolean gillar(SkogsF�rem�l f);
	
	public void samla(List<SkogsF�rem�l> stuff) {
		Iterator<SkogsF�rem�l> it = stuff.iterator();
		while (it.hasNext()) {
			SkogsF�rem�l f = it.next();
			if(gillar(f)) {
				it.remove();
				samling.add(f);
			}
		}
	}
}

class Ekorre extends Varelse{
	Map<String, Integer> sf = new HashMap<>();
	
	public Ekorre (String namn, int samling) {
		super("Ekorre");
		
	}
	protected boolean gillar(SkogsF�rem�l f) {
		return f instanceof Kotte || f instanceof B�r && ((B�r)f).getF�rg().equals("R�d");
		
	}
	
}

class Skata extends Varelse{
	
	public Skata(String namn, List<SkogsF�rem�l> samling) {
		super("Skata");
	}
	protected boolean gillar(SkogsF�rem�l f) {
		return f.getVikt() > 13;
	}
	
}
