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
		program();
	}

	public void program() {
		while(in.hasNext()) {
			try {
				statement();
			} catch (VPException e) {
				out.printf("Fout: %s.\n", e.getMessage());
				if (in.hasNext()) in.nextLine();
			}
		}
	}

	void statement() throws VPException {
		if (nextCharInRange("a-zA-Z")) {
			assignment();
		} else
		if (nextCharInRange("?")) {
			print_statement();
		} else
		if (nextCharInRange("/")) {
			commentaar();
		} else {
			throw new VPException("statement verwacht");
		}
	}

	void assignment() throws VPException {
		Identifier i = identifier();
		lees('=');
		Verzameling<NatuurlijkGetal> e = expressie();
		leesEOL();
		variabelen.insert(i, e);
	}

	void print_statement() throws VPException {
		lees('?');
		Verzameling<NatuurlijkGetal> e = expressie();
		leesEOL();
		printVerzameling(e);
	}

	void commentaar() throws VPException {
		lees('/');
		in.nextLine();
	}

	Identifier identifier() throws VPException {
		Identifier resultaat = new Identifier();
		resultaat.init(letter());
		while(nextCharInRange("a-zA-Z0-9", false)) {
			if(nextCharInRange("a-zA-Z", false)) {
				resultaat.append(letter());
			}
			if(nextCharInRange("0-9", false)) {
				resultaat.append(cijfer());
			}
		}
		return resultaat;
	}

	Verzameling<NatuurlijkGetal> expressie() throws VPException {
		Verzameling<NatuurlijkGetal> resultaat;
		char op;
		resultaat = term();
		while(nextCharInRange("+|-")) {
			op = additieve_operator();
			switch(op) {
				case '+': resultaat = resultaat.vereniging(term()); break;
				case '|': resultaat = resultaat.symmetrischVerschil(term()); break;
				case '-': resultaat = resultaat.verschil(term()); break;
			}
		}
		return resultaat;
	}

	Verzameling<NatuurlijkGetal> term() throws VPException {
		Verzameling<NatuurlijkGetal> resultaat;
		char op;
		resultaat = factor();
		while(nextCharInRange("*")) {
			op = multiplicatieve_operator();
			resultaat = resultaat.doorsnede(factor());
		}
		return resultaat;
	}

	Verzameling<NatuurlijkGetal> factor() throws VPException {
		Verzameling<NatuurlijkGetal> resultaat;
		Identifier i;
		if (nextCharInRange("a-zA-Z")) {
			i = identifier();
			resultaat = variabelen.retrieve(i);
		} else
		if (nextCharInRange("(")) {
			resultaat = complexe_factor();
		} else
		if (nextCharInRange("{")) {
			resultaat = verzameling();
		} else {
			throw new VPException("factor verwacht");
		}
		return resultaat;
	}

	Verzameling<NatuurlijkGetal> complexe_factor() throws VPException {
		Verzameling<NatuurlijkGetal> resultaat;
		lees('(');
		resultaat = expressie();
		lees(')');
		return resultaat;
	}

	Verzameling<NatuurlijkGetal> verzameling() throws VPException {
		Verzameling<NatuurlijkGetal> resultaat;
		lees('{');
		resultaat = rij_natuurlijke_getallen();
		lees('}');
		return resultaat;
	}

	Verzameling<NatuurlijkGetal> rij_natuurlijke_getallen() throws VPException {
		Verzameling<NatuurlijkGetal> resultaat = new Verzameling<NatuurlijkGetal>();
		if (nextCharInRange("0-9")) {
			resultaat.insert(natuurlijk_getal());
		}
		while (nextCharInRange(",")) {
			lees(',');
			resultaat.insert(natuurlijk_getal());
		}
		return resultaat;
	}

	char additieve_operator() throws VPException {
		if (nextCharInRange("+|-")) {
			return nextChar();
		} else {
			throw new VPException("additieve operator verwacht");
		}
	}

	char multiplicatieve_operator() throws VPException {
		if (nextCharInRange("*")) {
			return nextChar();
		} else {
			throw new VPException("multiplicatieve operator verwacht");
		}
	}

	NatuurlijkGetal natuurlijk_getal() throws VPException {
		NatuurlijkGetal resultaat = new NatuurlijkGetal();
		if (nextCharInRange("1-9")) {
			resultaat = positief_getal();
			return resultaat;
		} else
		if (nextCharInRange("0")) {
			return resultaat;
		} else {
			throw new VPException("natuurlijk getal verwacht");
		}
	}

	NatuurlijkGetal positief_getal() throws VPException {
		NatuurlijkGetal resultaat = new NatuurlijkGetal();
		resultaat.append(niet_nul());
		while (nextCharInRange("0-9", false)) {
			resultaat.append(cijfer());
		}
		return resultaat;
	}

	char cijfer() throws VPException {
		if (nextCharInRange("0")) {
			return nul();
		} else
		if (nextCharInRange("1-9")) {
			return niet_nul();
		} else {
			throw new VPException("cijfer verwacht");
		}
	}

	char nul() throws VPException {
		if (nextCharInRange("0")) {
			return nextChar();
		} else {
			throw new VPException("nul verwacht");
		}
	}

	char niet_nul() throws VPException {
		if (nextCharInRange("1-9")) {
			return nextChar();
		} else {
			throw new VPException("niet-nul verwacht");
		}
	}

	char letter() throws VPException {
		if (nextCharInRange("a-zA-Z")) {
			return nextChar();
		} else {
			throw new VPException("letter verwacht");
		}
	}

	// Hulpmethodes

	void printVerzameling(Verzameling<NatuurlijkGetal> v) {
		Verzameling kopie = v.clone();
		NatuurlijkGetal ng;
		while (!kopie.isEmpty()) {
			ng = (NatuurlijkGetal)kopie.retrieve();
			printNatuurlijkGetal(ng);
			out.printf(" ");
			kopie.remove(ng);
		}
		out.printf("\n");
	}

	void printNatuurlijkGetal(NatuurlijkGetal ng) {
		for (int i = 0; i<ng.length(); i++) {
			out.printf("%c", ng.charAt(i));
		}
	}

	char nextChar() {
		return in.next().charAt(0);
	}

	void lees(char c) throws VPException {
		skipSpaces();
		if (nextCharInRange(c)) {
			nextChar();
		} else {
			throw new VPException(c + " verwacht");
		}
	}

	void leesEOL() throws VPException {
		skipSpaces();
		if (nextCharIsEOL()) {
			if (nextChar() == '\r' && nextCharInRange("\n")) {
				nextChar();
				in.nextLine();
			}
		} else {
			throw new VPException("end-of-line verwacht");
		}
	}

	boolean nextCharIsEOL() {
		skipSpaces();
		return in.hasNext("\n") || in.hasNext("\r");
	}

	boolean nextCharInRange(String range, boolean skipSpaces) {
		if (skipSpaces) {
			skipSpaces();
		}
	    return in.hasNext("[" + range + "]");
	}

	boolean nextCharInRange(String range) {
		return nextCharInRange(range, true);
	}

	boolean nextCharInRange(char range) {
		return nextCharInRange(Character.toString(range));
	}

	void skipSpaces() {
		in.skip("[ ]*");
	}

	public static void main(String[] srgv) {
		new Opgave2().start();
	}
}
