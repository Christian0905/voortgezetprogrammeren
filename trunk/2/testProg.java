import java.io.PrintStream;
import java.util.Scanner;

class testProg {
	Scanner in;
	PrintStream out;
	Lijst<Identifier> iLijstje;
	Lijst<NatuurlijkGetal> ngLijstje;
	Lijst<Identifier> kopieLijstje;
	Lijst<NatuurlijkGetal> kopieLijstje2;

	testProg() {
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
		
		iLijstje = new Lijst<Identifier>();
		ngLijstje = new Lijst<NatuurlijkGetal>();
		kopieLijstje = new Lijst<Identifier>();
		kopieLijstje2 = new Lijst<NatuurlijkGetal>();
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
		
		
		
	}

	public static void main(String argv[]) {
		new testProg().start();
	}
}
