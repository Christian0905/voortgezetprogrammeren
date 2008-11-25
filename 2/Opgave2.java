import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

class Opgave2 {

	Scanner in;
	PrintStream out;
	
	Tabel variabelen;

	Opgave2() {
		in = new Scanner(System.in);
		in.useDelimiter("");
		out = new PrintStream(System.out);
		variabelen = new Tabel();
	}

	public void start() {
		while(in.hasNext()) {
			try {
				statement();
			} catch (VPException e) {
				out.printf("Fout: %s\n", e.getMessage());
			}
		}
	}

	void statement() throws VPException {
		skipSpaces();
		if (nextCharIsLetter()) {
			assignment();
		} else
		if (nextCharIs('?')) {
			print_statement();
		} else
		if (nextCharIs('/')) {
			commentaar();
		} else {
			throw new VPException("geen geldig statement gegeven");
		}
	}

	void assignment() throws VPException {
		Identifier i = identifier();
		lees('=');
		Verzameling e = expressie();
		leesEOL();
	}

	void print_statement() throws VPException {
		lees('?');
		Verzameling e = expressie();
		leesEOL();
	}

	void commentaar() throws VPException {
		while(!nextCharIsEOL()) {
			nextChar();
		}
		leesEOL();
	}

	Identifier identifier() throws VPException {
		return null;
	}

	Verzameling<NatuurlijkGetal> expressie() throws VPException {
		return null;
	}

	Verzameling<NatuurlijkGetal> term() throws VPException {
		return null;
	}

	Verzameling<NatuurlijkGetal> factor() throws VPException {
		return null;
	}

	Verzameling<NatuurlijkGetal> complexe_factor() throws VPException {
		return null;
	}

	Verzameling<NatuurlijkGetal> verzameling() throws VPException {
		return null;
	}

	Verzameling<NatuurlijkGetal> rij_natuurlijke_getallen() throws VPException {
		return null;
	}

	char additieve_operator() throws VPException {
		return '0';
	}

	char multiplicatieve_operator() throws VPException {
		return '0';
	}

	NatuurlijkGetal natuurlijk_getal() throws VPException {
		return null;
	}

	NatuurlijkGetal positief_getal() throws VPException {
		return null;
	}

	char cijfer() throws VPException {
		return '0';
	}

	char nul() throws VPException {
		return '0';
	}

	char niet_nul() throws VPException {
		return '0';
	}

	char letter() throws VPException {
		return '0';
	}

	//Hulpmethodes
	
	void lees(char c) throws VPException {
		skipSpaces();
		if (nextCharIs(c)) {
			nextChar();
		} else {
			throw new VPException(c + " verwacht.");
		}
	}
	
	void leesEOL() throws VPException {
		skipSpaces();
		if (nextCharIsEOL()) {
			if (nextChar() == '\r' && nextCharIs('\n')) {
				nextChar();
			}
		} else {
			throw new VPException("End-of-line verwacht.");
		}
	}
	
	boolean nextCharIsEOL() {
		return in.hasNext("\n") || in.hasNext("\r");
	}

	char nextChar() {
		return in.next().charAt(0);
	}

	boolean nextCharIs(char c) {
	    return in.hasNext(Pattern.quote(c+""));
	}

	boolean nextCharIsDigit() {
	    return in.hasNext("[0-9]");
	}

	boolean nextCharIsLetter() {
	    return in.hasNext("[a-zA-Z]");
	}

	void skipSpaces() {
		in.skip("[ ]*");
	}

	public static void main(String[] srgv) {
		new Opgave2().start();
	}
}
