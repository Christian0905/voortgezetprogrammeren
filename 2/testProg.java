import java.io.PrintStream;
import java.util.Scanner;

class testProg {
	Scanner in;
	PrintStream out;
	//Lijst lijstje;
	

	testProg() {
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
		
		//lijstje = new Lijst();
	}

	public void start() {
	//lijstje.init();
	//lijstje.insert(1);
	//out.printf("Verzameling 1: %s\n", lijstje.toString());
	StringBuffer a = new StringBuffer();
	StringBuffer b = a.clone();
	}

	public static void main(String argv[]) {
		new testProg().start();
	}
}
