import java.io.PrintStream;
import java.util.Scanner;

class testProg {
	Scanner in;
	PrintStream out;
	
	Lijst<String> lijstje;

	testProg() {
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
		
		Lijst<String> lijstje = new Lijst<String>();
	}

	public void start() {

	}

	public static void main(String argv[]) {
		new testProg().start();
	}
}
