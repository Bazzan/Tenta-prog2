
public class Train {
	
	class Personnr {
		private int datum, nr; // födelsedatum resp. löpnr

		public Personnr(int datum, int nr) {
			this.datum = datum;
			this.nr = nr;
		}

		public int getDatum() {
			return datum;
		}

		public int getNr() {
			return nr;
		}

		public String toString() {
			return "" + datum + "-" + nr;
		}
		
		public boolean equals(Object other) {
			Personnr pnr = (Personnr)other;
			if (other instanceof Personnr) {
				return datum == pnr.datum && nr == pnr.nr;
			}else
				return false;
		}
		
		public boolean equals(Object other) {
			Personnr pnr = (Personnr)other;
			if(other instanceof Personnr) {
				return datum == pnr.datum && nr == pnr.nr;
			}else {
				return false;
			}
		}
		public boolean equals(Object other) {
			Personnr pnr = (Personnr)other;
			if(other instanceof Personnr) {
				return datum == pnr.datum&& nr == pnr.nr;
			}else
				return false;
		}
		
		public boolean equals(Object other) {
			Personnr pnr = (Personnr)other;
			if(other instanceof Personnr) {
				return datum == pnr.datum && nr == pnr.nr;
			}else
				return false;
		}
		public boolean equals(Object other) {
		Personnr pnr = (Personnr)other;
		if(other instanceof Personnr) {
			return datum == pnr.datum && nr == pnr.nr;
		}else
			return;
		
		}
		public boolean equals(Object other) {
			Personnr pnr = (Personnr)other;
			if(other instanceof Personnr){
				return datum == pnr.datum && nr == pnr.nr;
			}else 
				return false;
		}
		
		
		
		
		public int compare(Personnr other) {
			int cmp = datum - other.datum;
			if(cmp != 0) {
				return cmp;
			}
			cmp = nr - other.nr;
			return cmp;
			
		}
		
		public int compare(Personnr other) {
			int cmp = datum - other.datum;
			if(cmp != 0) {
				return cmp;
			}
			return cmp = nr - other.nr;
		}
		
		public int compare(Personnr other) {
			int cmp = datum - other.datum;
			if(cmp != 0){
				return cmp;
			}
			return cmp = nr - other.nr;
			
		}
		public int compare(Personnr other) {
			int cmp = datum - other.datum;
			if(cmp != 0) {
				return cmp;
			}
			return cmp = nr = other.nr;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}