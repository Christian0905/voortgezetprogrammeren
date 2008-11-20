class MattyCollege8 {
	
	// OVERRIDE
	
	Een methode uit een subclass doet een override
	op een methode uit de superclass indien de SIGNATURE
	van beide methoden hetzelfde is.
	
	SIGNATURE: - naam
			   - het aantal parameters
			   - het type van de parameters
	
	extra eisen: - bij een functie (het type van het functie
				   resultaat moet hetzelfde zijn OF een subclass
				   van het type van het functieresultaat van de
				   methode in de superclass)
				 - De methode in de subclass mag niet minder
				   toegankelijk zijn. ->(melding, less 
				   restrictive is not allowed)
				   
	// BOMEN
				   
	Binaire bomen:	iedere knoop heeft maximaal 2 kinderen
					knopen moeten altijd duidelijk naar links
					of rechts wijzen.
					
	// IMPLEMENTATIE
	
	class BoomKnoop {
		
		int data;
		BoomKnoop links, rechts;
		
		BoomKnoop(int i, BoomKnoop l, BoomKnoop r) {
			data = i;
			links = l;
			rechts = r;
		}
		
		BoomKnoop(int i) {
			this(i, null, null);
		}
	}
	
	BoomKnoop boom;
	// vraag: maak lege boom
	boom = null;
	
	=============================================================
	
	// recursieve benadering boom
	een boom is: - leeg.
				 - bevat een wortel, waar twee subbomen aan hangen.
	
	int aantalKnopen(BoomKnoop w) {
		if (w == null) {
			return 0;
		}
		return 1 + aantalKnopen(w.links) + aantalKnopen(w.rechts);
	}
	
	boolean aanwezig(BoomKnoop w, int x) {
		if (w == null) { 
			return false;
		}
		return w.data == x || aanwezig(w.links, x) || aanwezig(w.rechts, x);
	}
	
	int diepte(BoomKnoop w) {
		if (w == null) {
			return -1;
		}
		return 1 + Math.max(diepte(w.links),diepte(w.rechts));
	}
	
	BoomKnoop kopie(BoomKnoop w) {
		if (w == null) {
			return null;
		}
		return new BoomKnoop(w.data, kopie(w.links), kopie(w.rechts));
	}
	
	// BINAIRE ZOEKBOMEN
	
	Extra eigenschap: Linker elementen =< element in de wortel
					  Rechter elementen => element in de wortel
	
	boom = null;
	boom = voegToe(boom, 13);
	
	BoomKnoop voegToe(BoomKnoop w, int x) {
		if (w == null) {
			return new BoomKnoop(x);
		}
		if (x <= w.data) {
			w.links = voegToe(w.links, x);
		} else {
			w.rechts = voegToe(w.rechts, x);
		}
		return w;
	}
	
	boolean aanwezig(BoomKnoop w, int x) {
		if (w == null) {
			return false;
		} if (x < w.data) {
			return aanwezig(w.links, x);
		} else if {
			(x == w.data) {
			return true;
			}
		} else {  // x>w.data
			return aanwezig(w.rechts, x);
		}
	}
	
	