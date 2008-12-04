import java.io.PrintStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SortUniq {

	static final String NIET_ALFANUMERIEK = "[^a-z0-9A-Z]+";
	static final String LETTER = "[a-zA-Z]";
	
	boolean caseInsensitive;
	boolean	sortDescending;

	PrintStream out;
	Boom<Identifier> opslag;

	SortUniq() {
		caseInsensitive = false;
		sortDescending = false;
		out = new PrintStream(System.out);
		opslag = new Boom<Identifier>();
	}

	public void start(String[] arguments) {
		try {
			int startIndex = leesArguments(arguments);
			leesFiles(arguments, startIndex);
			printOpslag();
		} catch (VPException e) {
			out.printf("%s\n", e.getMessage());
			System.exit(0);
		}
	}
	
	int leesArguments(String[] arguments) throws VPException {
		for (int i=0; i<arguments.length; i++) {
			if (arguments[i].equals("-i")) {
				caseInsensitive = true;
			} else
			if (arguments[i].equals("-d")) {
				sortDescending = true;
			} else {
				return i;
			}
		}
		throw new VPException("Geen file meegegeven.");
	}
	
	void leesFiles(String[] files, int startIndex) throws VPException {
		for (int i=startIndex; i<files.length; i++) {
			try {
				Scanner file = new Scanner(new File(files[i]));
				leesWoorden(file);
			} catch (FileNotFoundException e) {
				throw new VPException("Bestand '" + files[i] + "' niet gevonden.");
			}
		}
	}
	
	void leesWoorden(Scanner in) {
		in.useDelimiter(NIET_ALFANUMERIEK);
		while (in.hasNext()) {
			Scanner woordScanner = new Scanner(in.next());
			woordScanner.useDelimiter("");
			if (isIdentifier(woordScanner)) {
				verwerk(woordScanner);
			}
		}
	}
	
	boolean isIdentifier(Scanner woordScanner) {
		return woordScanner.hasNext(LETTER);
	}
	
	void verwerk(Scanner identifierScanner) {
		Identifier identifier = new Identifier();
		identifier.init(leesChar(identifierScanner));
		while (identifierScanner.hasNext()) {
			identifier.append(leesChar(identifierScanner));
		}
		if (!opslag.present(identifier)) {
			opslag.add(identifier);
		} else {
			opslag.remove(identifier);
		}
	}

	char leesChar(Scanner in) {
		if (caseInsensitive) {
			return Character.toLowerCase(in.next().charAt(0));
		} else {
			return in.next().charAt(0);
		}
	}
	
	void printOpslag() {
		Iterator identifierIterator = sortDescending ? identifierBoom.descendingIterator() : identifierBoom.ascendingIterator();
		while (identifierIterator.hasNext()) {
			printIdentifier(identifierIterator.next());
		}
	}
	
	void printIdentifier(Identifier identifier) {
		for (int i=0; i<identifier.length(); i++) {
			out.printf("%c", identifier.charAt(i));
		}
		out.printf("\n");
	}

	public static void main(String[] argv) {
		new SortUniq().start(argv);
	}
}
