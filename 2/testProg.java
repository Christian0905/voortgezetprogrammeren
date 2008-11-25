import java.io.PrintStream;
import java.util.Scanner;

class testProg {
	Scanner in;
	PrintStream out;
	Lijst<Identifier> iLijstje;
	Lijst<NatuurlijkGetal> ngLijstje;

	testProg() {
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
		
		iLijstje = new Lijst<Identifier>();
		ngLijstje = new Lijst<NatuurlijkGetal>();
	}

	public void start() {
		Identifier i = new Identifier();
		iLijstje.insert(i.init('a').append('c'));
		out.printf("iLijstje: %s\n", iLijstje.toString());
		iLijstje.insert(i.init('a').append('a'));
		out.printf("iLijstje: %s\n", iLijstje.toString());
		iLijstje.insert(i.init('a'));
		out.printf("iLijstje: %s\n", iLijstje.toString());
		out.print("\n");
		NatuurlijkGetal ng = new NatuurlijkGetal();
		ngLijstje.insert(ng.init().append('7'));
		out.printf("ngLijstje: %s\n", ngLijstje.toString());
		ngLijstje.insert(ng.init().append('2'));
		out.printf("ngLijstje: %s\n", ngLijstje.toString());
		ngLijstje.insert(ng.init());
		out.printf("ngLijstje: %s\n", ngLijstje.toString());
	}

	public static void main(String argv[]) {
		new testProg().start();
	}
}
