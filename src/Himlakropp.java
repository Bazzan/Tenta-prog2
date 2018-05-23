import java.util.ArrayList;

public abstract class Himlakropp {
	
	private String namn;
	private int diaM;
	
	public Himlakropp(String namn, int diaM) {
		this.namn = namn;
		this.diaM = diaM;
	}
	public String getNamn() {
		return namn;
	}
	
	public int getDiaM() {
		return diaM;
	}
	
	
	abstract public int getVikt();

	
	public void letaLiv(Himlakropp himlakropp) {
		if(himlakropp instanceof Stj�rna) {
			ArrayList<Planet> pLista = ((Stj�rna) himlakropp).getPLista();
			for(Planet p : pLista) {
				if(p.getLiv() == true) {
					System.out.println(p.getNamn());
				}
			}
		}
	}
	
}

class M�ne extends Himlakropp{
	private int vikt;
	private int kratrar;
	public M�ne (String namn, int diaM, int kratrar) {
		super(namn, diaM);
		this.kratrar = kratrar;
	}
	
	public int getKratrar() {
		return kratrar;
	}
	
	public int getVikt() {
		return vikt = (10* getDiaM()) - kratrar;
	}
}

class Planet extends Himlakropp{
	
	private boolean liv;
	private M�ne m�ne;
	private int vikt;
	public Planet(String namn, int diaM, M�ne m�ne ,boolean liv){
		super(namn, diaM);
		this.m�ne = m�ne;
		this.liv = liv;
	}
	
	public boolean getLiv() {
		return liv;
	}
	public M�ne getM�ne() {
		return m�ne;
	}
	public M�ne setM�ne(M�ne nyM�ne) {
		return m�ne = nyM�ne;
	}
	
	public int getVikt() {
		if(m�ne != null) {
			return vikt = (10 * getDiaM()) + m�ne.getVikt(); 
		}else {
			return vikt = 10 * getDiaM();
		}
	}
	
	public void m�nKrash(M�ne nyM�ne) {
		if (nyM�ne.getVikt() > m�ne.getVikt()) {
			setM�ne(nyM�ne);
		}else {
			return;
		}
	}
	
}


class Stj�rna extends Himlakropp{
	private ArrayList<Planet> pLista = new ArrayList<>();
	private int ljus;
	private int vikt;
	
	public Stj�rna (String namn, int diaM, int ljus , ArrayList<Planet> pLista) {
		super(namn, diaM);
		this.ljus = ljus;
		this.pLista = pLista;
	}
	public int getLjus() {
		return ljus;
	}
	public ArrayList<Planet> getPLista(){
		return pLista;
	}
	
	public int getVikt() {
		for(Planet p : pLista){
			vikt += p.getVikt();
		}
		return vikt += ljus * getDiaM();
		
	}
	
	public void addPlanet(Planet planet) {
		pLista.add(planet);
	}
	
}










