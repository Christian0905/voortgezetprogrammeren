class MattyCollege6 {
	
	// LIJSTEN VERVOLG
	
	lijst -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null
		
		q wijst naar 6 en 4 moet worden verwijdert
		oplossing:
		de knoop 5 moe naar de knoop 3 gaan wijzen
		we hebben een tweede referentie p nodig
		Werkt niet bij bv lege lijst of lijst waar 4 niet in zit
		
	Knoop p, q;
	p = null;
	q = lijst;
	
	while (q.data != 4) {
		p = q;
		q = q.next();
	}
	p.next() = q.next();
	
	// VERWIJDER DE LAATSTE
	
	while (q.next() != null) {
		p = q;
		q = q.next();
	}
	p.next() = null;
	
	// VERWIJDER DE ENIGE
	
	lijst = null;
	
	// LIJSTEN RECURSIEF MAKEN
	// Een lijst is leeg of bevat een knoop waar een lijst aan hangt
	
	lijst -> null           lijst -> knoop -> (Lijst) <- dus ook weer leeg of lijst
		
	int aantalKnopen(Knoop lijst) {
		if (lijst == null) {
			return 0;
		}
		return 1 + aantalKnopen(lijst.next());
	}
	
	boolean aanwezig(Knoop lijst, int x) {
		if (lijst == null) {
			return false;
		}
		return lijst.data == x || aanwezig(lijst.next(), x);  //links wordt eerst gecheckt, mccarthy evaluatie
	}
	
	// VOORGANGER VINDEN IN EEN LIJST (DUBBEL GELINKTE LIJST MOET BIJ OPGAVE 2)
	
	prior<- Knoop(data) ->next
	
	// 3 TOEVOEGEN
	
	null <- 1 -> <- 2 -> <- 4 -> <-5-> null
	
	Knoop k // staat op 2
	Knoop(data)
	Knoop(data, next, prior)
	
	//Simpele uitleg
	Knoop hulp = new Knoop(3);
	hulp.prior = k;
	hulp.next = k.next;
	k.next = k.next.prior = hulp;
	
	// Mooier
	Knoop hulp = new Knoop(3, k.next, k);
	k.next = k.next.prior = hulp;
	
	// nog mooier
	k.next = k.next.prior = new Knoop(3, k.next, k);
	
	// VERWIJDEREN UIT DUBBEL GELINKTE LIJST
	
	null <- 1 -> <- 2 -> <- 3 -> <-4-> null
	
	// VERWIJDER 2
	
	Knoop k // staat op 2
	
	k.next.prior = k.prior;
	k.prior.next = k.next;
	
	// CONCREET OPGGAVE 2
	
	Lijst object heeft:
	variabele first, last, current
	
	verwijder, insert etc werkt allemaal met current
	
	// INSERT -> 4 RANDGEVALLEN
		- toevoegen aan de lege lijst
		- toevoegen voor de eerste
		- toevoegen na de laatste
		- toevoegen in het "midden"
		
	// VERWIJDEREN -> 4 GEVALLEN
		- verwijderen van de enige knoop die er nog is
		- verwijderen van de eerste
		- verwijderen van de laatste
		- verwijderen uit het "midden"
	
	// MAAK EEN TESTPROGRAMMA VOOR LIJST
	
	// EBNF NOTATIE (Extended Backus Nauer Format)
	// specificeren van invoer en uitvoer van methodes
	// non-terminal = iets wat nog niet bekend is
	
	letter = 'a'| 'b'| 'c'|...|'z'|'A'|'B'|'C'|...|'Z'.  //puntjes wel uitschrijven
	digits = '0'| '1'|...|'9'.
	
	a|b = a of b
	a b = a gevolgd door b
	{a} = 0 of meer dan a
	[a] = 0 of 1 keer a (wel of niet a)
	
	identifier = letter{letter|digit}
	
	// VOORBEELD VAN IETS
	
	l.init().insert(...).insert(...).size()==2;
	
	Lijst init() {
		.....
		.....
		return this;
	}
	
	// TEMPLATES
	
	public class Lijst<E extends Data> implements LijstInterface<E> {
		
		public Lijst() {
		}
		
		public Lijst<E> init() {
		}
		
		public Lijst<E> concat(Lijst<E> rhs) {
			Lijst<E> resultaat = new Lijst<E>();
		}
	}	
	
	class Getal implements Data {
	}
	
	Lijst<Getal> = new Lijst<Getal>();