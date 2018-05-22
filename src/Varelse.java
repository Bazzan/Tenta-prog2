
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

abstract public class Varelse {
	private String namn;

	List<SkogsFöremål> samling = new ArrayList<>();
	public Varelse(String namn) {
		this.namn = namn;
		
	}
	protected abstract boolean gillar(SkogsFöremål f);
	
	public void samla(List<SkogsFöremål> stuff) {
		Iterator<SkogsFöremål> it = stuff.iterator();
		while (it.hasNext()) {
			SkogsFöremål f = it.next();
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
	protected boolean gillar(SkogsFöremål f) {
		return f instanceof Kotte || f instanceof Bär && ((Bär)f).getFärg().equals("Röd");
		
	}
	
}

class Skata extends Varelse{
	
	public Skata(String namn, List<SkogsFöremål> samling) {
		super("Skata");
	}
	protected boolean gillar(SkogsFöremål f) {
		return f.getVikt() > 13;
	}
	
}
