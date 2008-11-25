import java.io.PrintStream;
import java.util.Scanner;

class testProg {
	Scanner in;
	PrintStream out;
	Lijst<Identifier> iLijstje;
	Lijst<NatuurlijkGetal> ngLijstje;
	Lijst<Identifier> kopieLijstje;

	testProg() {
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
		
		iLijstje = new Lijst<Identifier>();
		ngLijstje = new Lijst<NatuurlijkGetal>();
		kopieLijstje = new Lijst<Identifier>();
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
		/*
		NatuurlijkGetal ng = new NatuurlijkGetal();
		ngLijstje.insert(ng.init().append('7'));
		out.printf("ngLijstje: %s\n", ngLijstje.toString());
		ngLijstje.insert(ng.init().append('2'));
		out.printf("ngLijstje: %s\n", ngLijstje.toString());
		ngLijstje.insert(ng.init());
		out.printf("ngLijstje: %s\n", ngLijstje.toString());
	*/}

	public static void main(String argv[]) {
		new testProg().start();
	}
}
