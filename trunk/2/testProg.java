import java.io.PrintStream;
import java.util.Scanner;

class testProg {
	Scanner in;
	PrintStream out;
	Lijst<NatuurlijkGetal> lijstje;

	testProg() {
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
		
		lijstje = new Lijst<NatuurlijkGetal>();
	}

	public void start() {
		NatuurlijkGetal ng = new NatuurlijkGetal();
		lijstje.insert(ng.init().append('4'));
		out.printf("lijstje: %s\n", lijstje.toString());
		lijstje.insert(ng.init().append('2'));
		out.printf("lijstje: %s\n", lijstje.toString());
		lijstje.insert(ng.init().append('3'));
		out.printf("lijstje: %s\n", lijstje.toString());
	}

	public static void main(String argv[]) {
		new testProg().start();
	}
}
