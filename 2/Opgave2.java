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
			}
		}
	}

	void statement() throws VPException {
		if (nextCharIsLetter()) {
			assignment();
		} else
		if (nextCharIs('?')) {
			print_statement();
		} else
		if (nextCharIs('/')) {
			commentaar();
		} else {
			throw new VPException("statement verwacht");
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
		Identifier resultaat = new Identifier();
		resultaat.init(letter());
		while(nextCharIsLetter() || nextCharIsDigit()) {
			if(nextCharIsLetter()) {
				resultaat.append(letter());
			}
			if(nextCharIsDigit()) {
				resultaat.append(cijfer());
			}
		}
		return resultaat;
	}

	Verzameling<NatuurlijkGetal> expressie() throws VPException {
		Verzameling<NatuurlijkGetal> resultaat = new Verzameling<NatuurlijkGetal>();
		return resultaat;
	}

	Verzameling<NatuurlijkGetal> term() throws VPException {
		Verzameling<NatuurlijkGetal> resultaat = new Verzameling<NatuurlijkGetal>();
		return resultaat;
	}

	Verzameling<NatuurlijkGetal> factor() throws VPException {
		Verzameling<NatuurlijkGetal> resultaat = new Verzameling<NatuurlijkGetal>();
		return resultaat;
	}

	Verzameling<NatuurlijkGetal> complexe_factor() throws VPException {
		Verzameling<NatuurlijkGetal> resultaat = new Verzameling<NatuurlijkGetal>();
		return resultaat;
	}

	Verzameling<NatuurlijkGetal> verzameling() throws VPException {
		Verzameling<NatuurlijkGetal> resultaat = new Verzameling<NatuurlijkGetal>();
		return resultaat;
	}

	Verzameling<NatuurlijkGetal> rij_natuurlijke_getallen() throws VPException {
		Verzameling<NatuurlijkGetal> resultaat = new Verzameling<NatuurlijkGetal>();
		return resultaat;
	}

	char additieve_operator() throws VPException {
		if (nextCharIs('+') || nextCharIs('|') || nextCharIs('-')) {
			return nextChar();
		} else {
			throw new VPException("additieve operator verwacht");
		}
	}

	char multiplicatieve_operator() throws VPException {
		if (nextCharIs('*')) {
			return nextChar();
		} else {
			throw new VPException("multiplicatieve operator verwacht");
		}
	}

	NatuurlijkGetal natuurlijk_getal() throws VPException {
		NatuurlijkGetal resultaat = new NatuurlijkGetal();
		if (nextCharIsDigit() && !nextCharIs('0')) {
			resultaat = positief_getal();
			return resultaat;
		} else
		if (nextCharIs('0')) {
			return resultaat;
		} else {
			throw new VPException("natuurlijk getal verwacht");
		}
	}

	NatuurlijkGetal positief_getal() throws VPException {
		NatuurlijkGetal resultaat = new NatuurlijkGetal();
		resultaat.append(niet_nul());
		while (nextCharIsDigit()) {
			resultaat.append(cijfer());
		}
		return resultaat;
	}

	boolean lees
	
	char cijfer() throws VPException {
		if (nextCharIs('0')) {
			return nul();
		} else
		if (nextCharIsDigit() && !nextCharIs('0')) {
			return niet_nul();
		} else {
			throw new VPException("cijfer verwacht");
		}
	}

	char nul() throws VPException {
		if (nextCharIs('0')) {
			return nextChar();
		} else {
			throw new VPException("nul verwacht");
		}
	}

	char niet_nul() throws VPException {
		if (nextCharIsDigit() && !nextCharIs('0')) {
			return nextChar();
		} else {
			throw new VPException("niet-nul verwacht");
		}
	}

	char letter() throws VPException {
		if (nextCharIsLetter()) {
			return nextChar();
		} else {
			throw new VPException("letter verwacht");
		}
	}

	//Hulpmethodes
	
	void lees(char c) throws VPException {
		skipSpaces();
		if (nextCharIs(c)) {
			nextChar();
		} else {
			throw new VPException(c + " verwacht");
		}
	}
	
	void leesEOL() throws VPException {
		skipSpaces();
		if (nextCharIsEOL()) {
			if (nextChar() == '\r' && nextCharIs('\n')) {
				nextChar();
			}
		} else {
			throw new VPException("end-of-line verwacht");
		}
	}
	
	boolean nextCharIsEOL() {
		skipSpaces();
		return in.hasNext("\n") || in.hasNext("\r");
	}

	char nextChar() {
		skipSpaces();
		return in.next().charAt(0);
	}

	boolean nextCharIs(char c) {
		skipSpaces();
	    return in.hasNext(Pattern.quote(c+""));
	}

	boolean nextCharIsDigit() {
		skipSpaces();
	    return in.hasNext("[0-9]");
	}

	boolean nextCharIsLetter() {
		skipSpaces();
	    return in.hasNext("[a-zA-Z]");
	}

	void skipSpaces() {
		in.skip("[ ]*");
	}

	public static void main(String[] srgv) {
		new Opgave2().start();
	}
}