class MattyCollege10 {
	
	l.add(1);
	l.add(1).add(2);
	l.add(1).add(2).add(3);
	//alternatief
	l.add(1);
	l.add(1,2);
	l.add(1,2,3);
	
	// hoe simpeler?
	// methode maken waar je net zo veel parameters
	// aan mag meegeven als je wil =>
	// variable arid methods
	
	Lijst add(int... element) {
		// alle parameters moeten hetzelfde type hebben
		// het moet de laatste parameter zijn
	}
	
	void m(String s, double d, int... element) {
	}
	
	void print(int... element) {
		// in deze void is element een array van int's
		for (int i = 0; i<elementen.length; i++) {
			out.printf("%d\n",element[i]);
		}
	}
	
// van een object dat het type Iterable<E> heeft geldt:
// - het foreach statement kan gebruikt worden.
// - dat ze een methode "Iterator<E> iterator()" bevat.
	
	// foreach statement
	for(<type element> <naam element> : object) {
	}
	//vb = alle elementen uit rij worden 0 gemaakt
	int[] rij = new int[1000];
	for(int e : rij) {
		e = 0;
	}
	
	ArrayList<String> al = new ArrayList<String>();
	// Er worden een aantal Strings in "al" gestopt
	for(String e : al) {
		out.printf("%s\n",e);
	}
	
	Interface Iterable<E> {
		Iterator<E> iterator();
	}
	
	interface Iterator<E> {
		boolean hasNext();
		E next();
		void remove();
	}
	
	//vb
	Verzameling<String> v = new Verzameling<String>() {
		// stop wat Strings in "v"
		Iterator it = v.iterator();
		while(it.hasNext()) {
			out.printf("%s\n", next());
		}
		
	// Iterator in opgave 3
	// Zet alle elementen van de boom in een ArrayList
	// en maak vervolgens van de ArrayList een iterator
	// maar nog wel in de goede volgorde
	}
}