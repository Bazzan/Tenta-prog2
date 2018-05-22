
abstract public class SkogsFöremål {

	private String föremål;
	private int vikt;
	private int näringsV;
	
	public SkogsFöremål(String föremål, int vikt) {
		this.föremål = föremål;
		this.vikt = vikt;

	}
	public String getFöremål() {
		return föremål;
	}
	
	public int getVikt() {
		return vikt;
	}
	abstract public int getNäringsV();
}

class Kotte extends SkogsFöremål{
	boolean mogen;
	
	public Kotte(String föremål, int vikt, boolean mogen) {
	super("Kotte", vikt );
	this.mogen = mogen;
	}
	
	public boolean getMogen() {
		return mogen;
	}
	
	@Override
	public int getNäringsV() {
		int näring;
		if(mogen == true) {
			return näring = (3* getVikt());
		}else {
			return näring = getVikt();
		}
	}
}

class Bär extends SkogsFöremål{
	private String färg;
	
	public Bär(String föremål, int vikt, String färg) {
		super("Bär", vikt);
		this.färg = färg;
	}

	public String getFärg() {
		return färg;
	}
	
	
	
	@Override
	public int getNäringsV() {
		int näring;
		if(färg.equals("Röd") || färg.equals("Blå")) {
			return näring =23;
		}else {
			return näring = getVikt();
		}
	}
	
}
