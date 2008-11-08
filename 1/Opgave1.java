import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

class Opgave1 {

	Scanner in;
	PrintStream out;

	static final char NEW_LINE = '\r'; // '\r' voor Windows, '\n' voor Unix

	Opgave1() {
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
	}

	public void start() {
		IdentifierVerzameling eersteVerzameling = new IdentifierVerzameling();
		IdentifierVerzameling tweedeVerzameling = new IdentifierVerzameling();
		while(leesVerzamelingen(eersteVerzameling, tweedeVerzameling)) {
			verwerkEnPrintOperaties(eersteVerzameling, tweedeVerzameling);
		}
	}

	boolean leesVerzamelingen(IdentifierVerzameling eersteVerzameling, IdentifierVerzameling tweedeVerzameling) {
		return
		leesIdentifierVerzameling(eersteVerzameling, "Geef eerste verzameling : ") &&
		leesIdentifierVerzameling(tweedeVerzameling, "Geef tweede verzameling : ");
	}

	boolean leesIdentifierVerzameling(IdentifierVerzameling verzameling, String vraag) {
		do {
			out.printf("%s", vraag);
			verzameling.init();
			if (!in.hasNext()) {
				return false;
			}
		} while (!invoerCorrect(verzameling));
		return true;
	}

	boolean invoerFout(String foutTekst) {
		out.printf("%s\n", foutTekst);
		in.nextLine();
		return false;
	}

	boolean invoerCorrect(IdentifierVerzameling verzameling) {
		in.useDelimiter("");
		if (nextCharIs(NEW_LINE)) {
			in.nextLine();
			return false;
		}
		if (nextChar() != '{') {
			return invoerFout("De '{' ontbreekt");
		}

		skipSpaces();
		if (!nextCharIs('}') && !nextCharIs(NEW_LINE)) {
			if (!leesIdentifiers(verzameling)) {
				return false;
			}
		}
		skipSpaces();

		if (nextChar() == '}') {
			if (nextChar() == NEW_LINE) {
				in.nextLine();
				return true;
			} else {
				return invoerFout("Invoer gegeven na de '}'.");
			}
		} else {
			return invoerFout("De '}' ontbreekt.");
		}
	}

	boolean leesIdentifiers(IdentifierVerzameling verzameling) {
		Identifier identifier = new Identifier();

		while (!nextCharIs('}') && !nextCharIs(NEW_LINE)) {
			if (nextCharIsLetter()) {
				identifier.init(nextChar());
				while (!nextCharIs(' ') && !nextCharIs('}') && !nextCharIs(NEW_LINE)) {
					if (nextCharIsLetter() || nextCharIsDigit()) {
						identifier.append(nextChar());
					} else {
						return invoerFout("Ongeldig teken in identifier.");
					}
				}
				try {
					if (verzameling.aantalIdentifiers() < 10 || verzameling.isAanwezig(identifier)) {
						verzameling.voegToe(identifier);
					} else {
						return invoerFout("Meer dan tien identifiers op de invoer.");
					}
				} catch (Exception e) {
					return invoerFout(e.getMessage());
				}
				skipSpaces();
			} else {
				return invoerFout("Identifier begint niet met een letter.");
			}
		}
		return true;
	}

	void verwerkEnPrintOperaties(IdentifierVerzameling eersteVerzameling, IdentifierVerzameling tweedeVerzameling) {
		try {
			out.printf("verschil   = %s\n", eersteVerzameling.verschil(tweedeVerzameling));
			out.printf("doorsnede  = %s\n", eersteVerzameling.doorsnede(tweedeVerzameling));
			out.printf("vereniging = %s\n", eersteVerzameling.vereniging(tweedeVerzameling));
			out.printf("sym. vers. = %s\n", eersteVerzameling.symmetrischVerschil(tweedeVerzameling));
		} catch (Exception e) {
			out.printf("%s\n", e.getMessage());
		}
	}

	public static void main(String[] srgv) {
		new Opgave1().start();
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
}