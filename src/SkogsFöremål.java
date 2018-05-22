
abstract public class SkogsF�rem�l {

	private String f�rem�l;
	private int vikt;
	private int n�ringsV;
	
	public SkogsF�rem�l(String f�rem�l, int vikt) {
		this.f�rem�l = f�rem�l;
		this.vikt = vikt;

	}
	public String getF�rem�l() {
		return f�rem�l;
	}
	
	public int getVikt() {
		return vikt;
	}
	abstract public int getN�ringsV();
}

class Kotte extends SkogsF�rem�l{
	boolean mogen;
	
	public Kotte(String f�rem�l, int vikt, boolean mogen) {
	super("Kotte", vikt );
	this.mogen = mogen;
	}
	
	public boolean getMogen() {
		return mogen;
	}
	
	@Override
	public int getN�ringsV() {
		int n�ring;
		if(mogen == true) {
			return n�ring = (3* getVikt());
		}else {
			return n�ring = getVikt();
		}
	}
}

class B�r extends SkogsF�rem�l{
	private String f�rg;
	
	public B�r(String f�rem�l, int vikt, String f�rg) {
		super("B�r", vikt);
		this.f�rg = f�rg;
	}

	public String getF�rg() {
		return f�rg;
	}
	
	
	
	@Override
	public int getN�ringsV() {
		int n�ring;
		if(f�rg.equals("R�d") || f�rg.equals("Bl�")) {
			return n�ring =23;
		}else {
			return n�ring = getVikt();
		}
	}
	
}
