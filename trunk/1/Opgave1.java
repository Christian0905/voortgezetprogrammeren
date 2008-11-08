import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

class Opgave1 {

	Scanner in;
	PrintStream out;

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
		leesIdentifierVerzameling(eersteVerzameling, "Geef de eerste verzameling: ") &&
		leesIdentifierVerzameling(tweedeVerzameling, "Geef de tweede verzameling: ");
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
		if (nextChar(in) != '{') {
			return invoerFout("De '{' ontbreekt");
		}
		
		skipSpaces(in);
		if (!nextCharIs(in, '}') && !nextCharIs(in, '\r')) {
			leesIdentifiers(verzameling);
		}
		skipSpaces(in);
		
		if (nextChar(in) == '}') {
			if (nextChar(in) == '\r') {
				in.nextLine();
				return true;
			} else {
				return invoerFout("Invoer gegeven na de '}'.");
			}
		} else {
			return invoerFout("De '}' ontbreekt.");
		}
	}

	void leesIdentifiers(IdentifierVerzameling verzameling) {
		Identifier identifier = new Identifier();
		
		while (!nextCharIs(in, '}') && !nextCharIs(in, '\r')) {
			if (nextCharIsLetter(in)) {
				identifier.init(nextChar(in));
				while (!nextCharIs(in, ' ') && !nextCharIs(in, '}') && !nextCharIs(in, '\r')) {
					if (nextCharIsLetter(in) || nextCharIsDigit(in)) {
						identifier.append(nextChar(in));
					} else {
						invoerFout("Ongeldig teken in identifier.");
						return;
					}
				}
				try {
					verzameling.voegToe(identifier);
				} catch (Exception e) {
				}
				skipSpaces(in);
			} else {
				invoerFout("Identifier begint niet met een letter.");
				return;
			}
		}
	}

	void verwerkEnPrintOperaties(IdentifierVerzameling eersteVerzameling, IdentifierVerzameling tweedeVerzameling) {
		try {
			out.printf("Verschil:    %s\n", eersteVerzameling.verschil(tweedeVerzameling));
			out.printf("Doorsnede:   %s\n", eersteVerzameling.doorsnede(tweedeVerzameling));
			out.printf("Vereniging:  %s\n", eersteVerzameling.vereniging(tweedeVerzameling));
			out.printf("Symmetrisch: %s\n", eersteVerzameling.symmetrischVerschil(tweedeVerzameling));
		} catch (Exception e) {
			out.printf("%s\n", e.getMessage());
		}
	}

	public static void main(String[] srgv) {
		new Opgave1().start();
	}

	// BEGIN toegestane hulpmethodes
	char nextChar (Scanner in) {
		return in.next().charAt(0);
	}

	boolean nextCharIs (Scanner in, char c) {
	    return in.hasNext(Pattern.quote(c+""));
	}

	boolean nextCharIsDigit (Scanner in) {
	    return in.hasNext("[0-9]");
	}

	boolean nextCharIsLetter (Scanner in) {
	    return in.hasNext("[a-zA-Z]");
	}
	// EIND toegestande hulpmethodes
	
	void skipSpaces(Scanner in) {
		in.skip("\\s*");
	}
}