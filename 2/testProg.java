import java.io.PrintStream;
import java.util.Scanner;

class testProg {
	Scanner in;
	PrintStream out;
	Lijst<Identifier> iLijstje;
	Lijst<NatuurlijkGetal> ngLijstje;
	Lijst<Identifier> kopieLijstje;
	Lijst<NatuurlijkGetal> kopieLijstje2;
	Verzameling testVerzameling;
	Verzameling testVerzameling2;
	Verzameling kopieVerzameling;
	
	testProg() {
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
		
		iLijstje = new Lijst<Identifier>();
		ngLijstje = new Lijst<NatuurlijkGetal>();
		kopieLijstje = new Lijst<Identifier>();
		kopieLijstje2 = new Lijst<NatuurlijkGetal>();
		testVerzameling = new Verzameling();
		testVerzameling2 = new Verzameling();
		kopieVerzameling = new Verzameling();
	}

	public void start() {
		// 3 keer toevoegen
		Identifier i = new Identifier();
		iLijstje.insert(i.init('a').append('c'));
		out.printf("iLijstje: %s\n", iLijstje.toString());
		iLijstje.insert(i.init('a').append('a'));
		out.printf("iLijstje: %s\n", iLijstje.toString());
		iLijstje.insert(i.init('a').append('b'));
		out.printf("iLijstje: %s\n", iLijstje.toString());
		iLijstje.insert(i.init('a'));
		out.printf("iLijstje: %s\n", iLijstje.toString());
		out.printf("current: %s\n", iLijstje.retrieve().toString());
		// lijst clonen
		kopieLijstje = iLijstje.clone();
		out.printf("kopie lijstje %s\n", kopieLijstje.toString());
		// zoeken
		out.printf("zoek 1: %s\n",iLijstje.find(i.init('1')));
		out.printf("current: %s\n", iLijstje.retrieve().toString());
		out.printf("zoek aa: %s\n",iLijstje.find(i.init('a').append('a')));
		out.printf("current: %s\n", iLijstje.retrieve().toString());
		out.printf("zoek ab: %s\n",iLijstje.find(i.init('a').append('b')));
		out.printf("current: %s\n", iLijstje.retrieve().toString());
		out.printf("zoek ad: %s\n",iLijstje.find(i.init('a').append('d')));
		out.printf("current: %s\n", iLijstje.retrieve().toString());
		// 3 keer verwijderen
		out.printf("current word nu verwijdert 1\n");
		iLijstje.remove();
		out.printf("current: %s\n", iLijstje.retrieve().toString());
		out.printf("iLijstje: %s\n", iLijstje.toString());
		out.printf("current word nu verwijdert 2\n");
		iLijstje.remove();
		out.printf("current: %s\n", iLijstje.retrieve().toString());
		out.printf("iLijstje: %s\n", iLijstje.toString());
		out.printf("current word nu verwijdert 3\n");
		iLijstje.remove();
		out.printf("iLijstje: %s\n", iLijstje.toString());
		out.printf("kopie lijstje %s\n", kopieLijstje.toString());
		out.print("\n");
		
		NatuurlijkGetal ng = new NatuurlijkGetal();
		ngLijstje.insert(ng.init().append('7'));
		out.printf("ngLijstje: %s\n", ngLijstje.toString());
		ngLijstje.insert(ng.init().append('2'));
		out.printf("ngLijstje: %s\n", ngLijstje.toString());
		ngLijstje.insert(ng.init());
		out.printf("ngLijstje: %s\n", ngLijstje.toString());
		ngLijstje.insert(ng.init().append('9').append('8').append('5'));
		out.printf("ngLijstje: %s\n", ngLijstje.toString());
		ngLijstje.insert(ng.init().append('0').append('0').append('5'));  // 005 word 5
		out.printf("ngLijstje: %s\n", ngLijstje.toString());
		// lijst clonen
		kopieLijstje2 = ngLijstje.clone();
		out.printf("kopie ng lijstje %s\n", kopieLijstje2.toString());
		// zoeken
		out.printf("Zoek 7: %s\n", ngLijstje.find(ng.init().append('7')));
		out.printf("Zoek 5: %s\n", ngLijstje.find(ng.init().append('5')));
		out.printf("Zoek 005: %s\n", ngLijstje.find(ng.init().append('0').append('0').append('5')));
		out.printf("Zoek 3: %s\n", ngLijstje.find(ng.init().append('3')));
		// current zoeken
		out.printf("current: %s\n", ngLijstje.retrieve().toString());
		// verwijderen
		out.printf("current word nu verwijdert 1\n");
		ngLijstje.remove();
		out.printf("current: %s\n", ngLijstje.retrieve().toString());
		out.printf("ngLijstje: %s\n", ngLijstje.toString());
		out.printf("current word nu verwijdert 2\n");
		ngLijstje.remove();
		out.printf("current: %s\n", ngLijstje.retrieve().toString());
		out.printf("ngLijstje: %s\n", ngLijstje.toString());
		out.printf("current word nu verwijdert 3\n");
		ngLijstje.remove();
		out.printf("ngLijstje: %s\n", ngLijstje.toString());
		out.printf("kopie lijstje ng %s\n", kopieLijstje2.toString());
		// size
		out.printf("aantal elementen kopielijstje ng %d\n", kopieLijstje2.size());
		out.printf("aantal elementen lijstje ng %d\n", ngLijstje.size());
		// set current first
		out.printf("current ngLijst: %s\n", ngLijstje.retrieve().toString());
		out.printf("setFirst\n");
		ngLijstje.setFirst();
		out.printf("current ngLijst: %s\n", ngLijstje.retrieve().toString());
		out.print("\n");
		
		//Verzameling test
		testVerzameling.insert(ng.init().append('a').append('a').append('p'));
		testVerzameling.insert(ng.init().append('n').append('o').append('o').append('t'));
		testVerzameling.insert(ng.init().append('m').append('i').append('e').append('s'));
		testVerzameling.insert(ng.init().append('m').append('i').append('e').append('s').append('2'));
		testVerzameling2.insert(ng.init().append('a').append('a').append('l'));
		testVerzameling2.insert(ng.init().append('w'));
		testVerzameling2.insert(ng.init().append('x').append('y').append('z'));
		testVerzameling2.insert(ng.init().append('n').append('o').append('o').append('t'));
		out.printf("Current testverzameling : %s\n", testVerzameling.retrieve().toString());
		out.printf("Testverzameling 1 = %s\n", testVerzameling.elementen.toString());
		out.printf("Testverzameling 2 = %s\n", testVerzameling2.elementen.toString());
		//out.printf("Verschil = %s\n", testVerzameling.verschil(testVerzameling2)); < hoe kan dat zo?
		Verzameling tv = new Verzameling();
		tv = testVerzameling.verschil(testVerzameling2);
		out.printf("Verschil = %s\n", tv.elementen.toString());
		
		Verzameling tv2 = new Verzameling();
		tv2 = testVerzameling.doorsnede(testVerzameling2);
		out.printf("Doorsnede = %s\n", tv2.elementen.toString());
		
		Verzameling tv3 = new Verzameling();
		tv3 = testVerzameling.vereniging(testVerzameling2);
		out.printf("Vereniging = %s\n", tv3.elementen.toString());
		
		Verzameling tv4 = new Verzameling();
		tv4 = testVerzameling.symmetrischVerschil(testVerzameling2);
		out.printf("Symm. Versch. = %s\n", tv4.elementen.toString());
		out.print("\n");
		// clone test
		kopieVerzameling = testVerzameling.clone();
		out.printf("Kopie van testverzameling = %s\n", kopieVerzameling.elementen.toString());
		
		// verwijderen
		out.printf("aap en noot verwijderen uit origineel\n");
		testVerzameling.remove(ng.init().append('a').append('a').append('p'));
		testVerzameling.remove(ng.init().append('n').append('o').append('o').append('t'));
		out.printf("testVerzameling na verwijderen = %s\n", testVerzameling.elementen.toString());
		out.printf("kopie van testVerzameling na verwijderen = %s\n", kopieVerzameling.elementen.toString());
		
	}

	public static void main(String argv[]) {
		new testProg().start();
	}
}
