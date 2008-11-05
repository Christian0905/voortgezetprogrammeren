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

	void start() {
		in.useDelimiter("");

		IdentifierVerzameling eersteVerzameling = new IdentifierVerzameling();
		IdentifierVerzameling tweedeVerzameling = new IdentifierVerzameling();

		while(leesVerzamelingen(eersteVerzameling, tweedeVerzameling)) {
			verwerkEnPrintOperaties(eersteVerzameling, tweedeVerzameling);
		}
	}

	boolean leesVerzamelingen(IdentifierVerzameling eersteVerzameling, IdentifierVerzameling tweedeVerzameling) {
		return
		leesIdentifierVerzameling(eersteVerzameling, "Geef eerste verzameling: ") &&
		leesIdentifierVerzameling(tweedeVerzameling, "Geef tweede verzameling: ");
	}

	boolean leesIdentifierVerzameling(IdentifierVerzameling identifierVerzameling, String s) {
		do {
			identifierVerzameling.init();
			out.printf("%s", s);

			if(!in.hasNext()) {
				out.printf("\n");
				return false;
			}
		}
		while(!controleerIdentifierVerzameling(identifierVerzameling));
		return true;
	}

	boolean foutmelding(String melding) {
		out.printf("%s\n", melding);
		in.nextLine();
		return false;
	}
	
	boolean controleerIdentifierVerzameling(IdentifierVerzameling identifierVerzameling) {
		Identifier identifier;

		if (!nextCharIs(in, '{')) {
			return foutmelding("De '{' ontbreekt");
		}
		nextChar(in);
		in.skip("\\s*");

		while (!nextCharIs(in, '}') && !nextCharIs(in, '\n')) {
			identifier = leesEnVerwerkIdentifier();
			if (identifier != null) {
				try {
					identifierVerzameling.voegToe(identifier);
				} catch (Exception e) { return foutmelding(e.getMessage()); }
			} else {
				return foutmelding("nog geen foutmelding 1.");
			}
			in.skip("\\s*");
		}

		if (nextChar(in) == '}' && nextChar(in) == '\n') {
			in.nextLine();
			return true;
		} else {
			return foutmelding("De '}' ontbreekt.");
		}
	}

	Identifier leesEnVerwerkIdentifier() {
		Identifier resultaat = new Identifier();

		if (!nextCharIsLetter(in)) {
			out.printf("Identifiers moeten beginnen met een letter.\n");
			return null;
		}
		resultaat.init(nextChar(in));

		while (!nextCharIs(in, ' ') && !nextCharIs(in, '}') && !nextCharIs(in, '\n')) {
			if (nextCharIsLetter(in) || nextCharIsDigit(in)) {
				resultaat.append(nextChar(in));
			} else {
				out.printf("Identifiers mogen alleen letters en cijfers bevatten.\n");
				return null;
			}
		}
		return resultaat;
	}

	void verwerkEnPrintOperaties(IdentifierVerzameling eersteVerzameling, IdentifierVerzameling tweedeVerzameling) {
		out.printf("verschil   = %s\n", eersteVerzameling.verschil(tweedeVerzameling));
		out.printf("doorsnede  = %s\n", eersteVerzameling.doorsnede(tweedeVerzameling));
		try {
			out.printf("vereniging = %s\n", eersteVerzameling.vereniging(tweedeVerzameling));
		} catch (Exception e) { out.printf("%s\n", e.getMessage()); };
		try {
			out.printf("sym. vers. = %s\n\n", eersteVerzameling.symmetrischVerschil(tweedeVerzameling));
		} catch (Exception e) { out.printf("%s\n", e.getMessage()); };
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

	public static void main(String[] srgv) {
		new Opgave1().start();
	}
}