import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

class Opgave1 {

	Scanner in;
	PrintStream out;

	static final char NEW_LINE = '\n'; // '\r' voor Windows, '\n' voor Unix

	Opgave1() {
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
	}

	public void start() {
		in.useDelimiter("");

		IdentifierVerzameling eersteVerzameling = new IdentifierVerzameling();
		IdentifierVerzameling tweedeVerzameling = new IdentifierVerzameling();
		while(leesVerzamelingen(eersteVerzameling, tweedeVerzameling)) {
			verwerkEnPrintOperaties(eersteVerzameling, tweedeVerzameling);
		}
		out.printf("\n");
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
		if (!leesAccoladeOpenen()) {
			return false;
		}
		if (!eindeVerzameling()) {
			if (!leesAlleIdentifiers(verzameling)) {
				return false;
			}
		}
		if (!leesAccoladeSluiten()) {
			return false;
		}
		return true;
	}
	
	boolean leesAccoladeOpenen() {
		if (nextCharIs(NEW_LINE)) {
			in.nextLine();
			return false;
		}
		if (nextChar() != '{') {
			return invoerFout("De '{' ontbreekt");
		}
		skipSpaces();
		return true;
	}

	boolean leesAccoladeSluiten() {
		skipSpaces();
		if (nextCharIs('}')) {
			nextChar();
			if (nextChar() == NEW_LINE) {
				return true;
			} else {
				return invoerFout("Invoer gegeven na de '}'.");
			}
		} else {
			return invoerFout("De '}' ontbreekt.");
		}
	}

	boolean leesAlleIdentifiers(IdentifierVerzameling verzameling) {
		Identifier identifier = new Identifier();

		while (!eindeVerzameling()) {
			if (nextCharIsLetter()) {
				if(!leesIdentifier(identifier)) {
					return false;
				}
				if(!voegToeAanVerzameling(verzameling, identifier)) {
					return false;
				}
				skipSpaces();
			} else {
				return invoerFout("Identifier begint niet met een letter.");
			}
		}
		return true;
	}

	boolean leesIdentifier(Identifier identifier) {
		identifier.init(nextChar());
		while (!nextCharIs(' ') && !eindeVerzameling()) {
			if (nextCharIsLetter() || nextCharIsDigit()) {
				identifier.append(nextChar());
			} else {
				return invoerFout("Ongeldig teken in identifier.");
			}
		}
		return true;
	}

	boolean voegToeAanVerzameling(IdentifierVerzameling verzameling, Identifier identifier) {
		try {
			if (verzameling.aantalIdentifiers() < 10 || verzameling.isAanwezig(identifier)) {
				verzameling.voegToe(identifier);
			} else {
				return invoerFout("Meer dan tien identifiers op de invoer.");
			}
		} catch (Exception e) {
			return invoerFout(e.getMessage());
		}
		return true;
	}

	boolean eindeVerzameling() {
		return nextCharIs('}') || nextCharIs(NEW_LINE);
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
		new Opgave1().start();
	}
}
