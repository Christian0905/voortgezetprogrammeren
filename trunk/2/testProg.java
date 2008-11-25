import java.io.PrintStream;
import java.util.Scanner;

class testProg {
	Scanner in;
	PrintStream out;
	Lijst<Identifier> lijstje;

	testProg() {
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
		
		lijstje = new Lijst<Identifier>();
	}

	public void start() {
		Identifier ng = new Identifier();
		lijstje.insert(ng.init('a').append('c'));
		out.printf("lijstje: %s\n", lijstje.toString());
		lijstje.insert(ng.init('a').append('a'));
		out.printf("lijstje: %s\n", lijstje.toString());
		lijstje.insert(ng.init('a'));
		out.printf("lijstje: %s\n", lijstje.toString());
	}

	public static void main(String argv[]) {
		new testProg().start();
	}
}
