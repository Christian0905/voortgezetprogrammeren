class MattyCollege9 {
	
	// VERVOLG BOMEN
	
	int aantal(BoomKnoop w, int x) {
		if(w == null) {
			return 0;
		}
		return w.data == x?1:0 +
		aantal(w.links, x) +
		aantal(w.rechts, x);
	}
	
	// BINAIRE ZOEKBOMEN VERVOLG
	
	TREE TRAVERSAL
		
	3 manieren:
		- pre order  = depth first
		- in order   = bezoekt steeds knoop van onder
		- post order = bezoekt steeds knoop rechts
		
	void printInorder(BoomKnoop w) {
		if (w == null) {
			return;
		}
		printInorder(w.links);
		printf("%s\n", w.data);
		printInorder(w.rechts);
	}
	
	// 7 verwijderen uit binaire zoekboom
	boom = verwijder(boom, 7);
	
	// meerdere gevallen
	// een blad (knoop met 0 kinderen)
	// een knoop met 1 kind
	// een knoop met 2 kinderen
	
	 verwijder(BoomKnoop w, int x) {
		if (w == null) {
			throw new Error("Da ga nie gaan");
		}
		if (x < w.data) {
			w.links = verwijder(w.links,x);
		} else
		if (x > w.data) {
			w.rechts = verwijder(w.rechts,x);
		} else // x == w.data
		if (w.links != null && w.rechts != null) { // 2 kinderen
			w.data = maximum(w.links);
			w.links = verwijder(w.links, w.data);
		} else { // 0 of 1 kind
			w = w.links != null?w.links:w.rechts;
		}
		return w;
	}
	
	 class Boom {
		 
		 BoomKnoop wortel => wortel van boom;
		 aantalKnopen etc
	 }
	
	 // COMMAND LINE ARGUMENTS
	 
	 ipi Prog a b c <eoln>
	command   command line arguments
	=======   ======================
	     command line
	================================
	
	public static void main (string[]argv) {
		new Prog().start();
	}
	
	argv.length == 3;  //(a b en c)
	argv[0].equals("a");
	argv[1].equals("b");
	argv[2].equals("c");
	
	
}