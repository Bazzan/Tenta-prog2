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
		if(himlakropp instanceof Stjärna) {
			ArrayList<Planet> pLista = ((Stjärna) himlakropp).getPLista();
			for(Planet p : pLista) {
				if(p.getLiv() == true) {
					System.out.println(p.getNamn());
				}
			}
		}
	}
	
}

class Måne extends Himlakropp{
	private int vikt;
	private int kratrar;
	public Måne (String namn, int diaM, int kratrar) {
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
	private Måne måne;
	private int vikt;
	public Planet(String namn, int diaM, Måne måne ,boolean liv){
		super(namn, diaM);
		this.måne = måne;
		this.liv = liv;
	}
	
	public boolean getLiv() {
		return liv;
	}
	public Måne getMåne() {
		return måne;
	}
	public Måne setMåne(Måne nyMåne) {
		return måne = nyMåne;
	}
	
	public int getVikt() {
		if(måne != null) {
			return vikt = (10 * getDiaM()) + måne.getVikt(); 
		}else {
			return vikt = 10 * getDiaM();
		}
	}
	
	public void månKrash(Måne nyMåne) {
		if (nyMåne.getVikt() > måne.getVikt()) {
			setMåne(nyMåne);
		}else {
			return;
		}
	}
	
}


class Stjärna extends Himlakropp{
	private ArrayList<Planet> pLista = new ArrayList<>();
	private int ljus;
	private int vikt;
	
	public Stjärna (String namn, int diaM, int ljus , ArrayList<Planet> pLista) {
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










