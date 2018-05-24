import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ISSN implements Comparable<ISSN> {
	private int part1, part2;
	private String checkDig;

	public ISSN(int part1, int part2, String checkDig) {
		this.part1 = part1;
		this.part2 = part2;
		this.checkDig = checkDig;
	}

	public String toString() {
		return "ISSN " + part1 + "-" + part2 + checkDig;
	}
	
	public boolean equals(Object other) {
		if(other instanceof ISSN) {
			ISSN issn = (ISSN)other;
			return part1 == issn.part1 && part2 == issn.part2 && checkDig.equals(issn.checkDig);
		}else {
			return false;
		}
	}
	
	public int HashCode() {
		return part1 *1001 + part2*100 + checkDig.hashCode();
	}
	
	public int compareTo(ISSN other) {
		int cmp = part1 - other.part1;
		if(cmp != 0) {
			return cmp;
		}
		cmp = part2 - other.part2;
		if(cmp != 0) {
			return cmp;
		}
		return checkDig.compareTo(other.checkDig);
	}
	
	public class Tidning {
		private ISSN issn;
		private String namn;
		private int upplaga;

		Tidning(ISSN issn, String namn, int upplaga) {
			this.issn = issn;
			this.namn = namn;
			this.upplaga = upplaga;
		}

		public ISSN getISSN() {
			return issn;
		}

		public String getNamn() {
			return namn;
		}

		public int getUpplaga() {
			return upplaga;
		}

		public String toString() {
			return issn.toString() + " " + namn + " " + upplaga;
		}
	}
	class CmpIssn implements Comparator<Tidning> {
		public int compare(Tidning t1, Tidning t2) {
			return t1.getISSN().compareTo(t2.getISSN());
		}
	}
	class CmpNamn implements Comparator<Tidning>{
		public int compare(Tidning t1, Tidning t2) {
			return t1.getNamn().compareTo(t2.getNamn());
		}
	}
	class CmpUpplaga implements Comparator<Tidning>{
		public int compare(Tidning t1, Tidning t2) {
			return t2.getUpplaga() - t1.getUpplaga();
		}
	}
	
	
	static void lista(Map<ISSN, Tidning> tidningar, int sortOrdning) {
		List<Tidning> tList = new ArrayList<Tidning>(tidningar.values());
		Comparator<Tidning>cmp = null;
		switch(sortOrdning) {
			case 0: cmp = new CmpIssn(); break;
			case 1: cmp = new CmpNamn(); break;
			case 2: cmp = new CmpUpplaga(); break;
		
		}
		
		Collections.sort(tList, cmp);
		for(Tidning t :tList) {
			System.out.println(t);
		}
	}

}
