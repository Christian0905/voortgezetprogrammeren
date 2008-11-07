import java.io.PrintStream;
import java.util.Scanner;

class testProg {
	Scanner in;
	PrintStream out;
	
	IdentifierVerzameling v1;
	IdentifierVerzameling v2;
	Identifier i;
	
	testProg() {
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
		
		v1 = new IdentifierVerzameling();
		v2 = new IdentifierVerzameling();
		i = new Identifier();
	}

	public void start() {
		i.init('a');
		v(v1,i);
		v(v2,i);
		i.init('b');
		v(v1,i);
		v(v2,i);
		i.init('c');
		v(v1,i);
		i.init('d');
		v(v1,i);
		i.init('e');
		i.append('a');
		i.append('b');
		i.append('c');
		v(v2,i);
		try {
			out.printf("Verzameling 1: %s\n", v1);
			out.printf("Verzameling 2: %s\n", v2);
			out.printf("Verschil     : %s\n", v1.verschil(v2));
			out.printf("Doorsnede    : %s\n", v1.doorsnede(v2));
			out.printf("Vereniging   : %s\n", v1.vereniging(v2));
			out.printf("Symmetrisch  : %s\n", v1.symmetrischVerschil(v2));
		} catch (Exception e) {
			throw new Error();
		}
	}
	
	public void v(IdentifierVerzameling v, Identifier i) {
		try {
			v.voegToe(i);
		} catch (Exception e) {
			throw new Error();
		}
	}

	public static void main(String argv[]) {
		new testProg().start();
	}
}