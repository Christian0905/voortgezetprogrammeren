import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

class Opgave2 {

	Scanner in;
	PrintStream out;

	Opgave2() {
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
	}

	public void start() {
		in.useDelimiter("");

		Tabel variabelen = new Tabel();
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
		skipSpaces();
		if (!nextCharIs('=')) {
			throw new VPException("ongeldig opgebouwde assignment");
		} else {
			nextChar();
		}
		skipSpaces();
		Verzameling e = expressie();
		skipSpaces();
		if (!nextCharIsEOL()) {
			throw new VPException("ongeldig opgebouwde assignment");
		} else {
			readEOL();
		}
	}

	void print_statement() throws VPException {
		nextChar();
		skipSpaces();
		Verzameling e = expressie();
		skipSpaces();
		if (!nextCharIsEOL()) {
			throw new VPException("ongeldig opgebouwd print_statement");
		} else {
			readEOL();
		}
	}

	void commentaar() throws VPException {
		while(!nextCharIsEOL()) {
			nextChar();
		}
		readEOL();
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

	boolean nextCharIsEOL() {
		return in.hasNext("\n") || in.hasNext("\r\n");
	}

	void readEOL() {
		if (nextChar() == '\r') {
			nextChar();
		}
	}

	void skipSpaces() {
		in.skip("[ ]*");
	}

	public static void main(String[] srgv) {
		new Opgave2().start();
	}
}
