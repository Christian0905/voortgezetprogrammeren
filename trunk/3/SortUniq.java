import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

public class SortUniq {

	static final String NIET_ALFANUMERIEK = "[^a-zA-Z0-9]";
	static final String ALFANUMERIEK = "[a-zA-Z0-9]";
	static final String LETTER = "[a-zA-Z]";
	static final String CIJFER = "[0-9]";
	
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
			out.printf("Fout: %s.\n", e.getMessage());
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
		throw new VPException("geen file meegegeven");
	}
	
	void leesFiles(String[] files, int startIndex) throws VPException {
		for (int i=startIndex; i<files.length; i++) {
			try {
				Scanner file = new Scanner(new File(files[i]));
				file.useDelimiter("");
				tekst(file);
			} catch (FileNotFoundException e) {
				throw new VPException("bestand '" + files[i] + "' niet gevonden");
			}
		}
	}
	
	void tekst(Scanner in) throws VPException {
		while (in.hasNext()) {
			if(nextCharInRange(in, ALFANUMERIEK)) {
				woord(in);
			} else {
				scheider(in);
			}
		}
	}
	
	void woord(Scanner in) throws VPException {
		if(nextCharInRange(in, LETTER)) {
			identifier(in);
		} else
		if(nextCharInRange(in, CIJFER)) {
			non_identifier(in);
		} else {
			throw new VPException("woord verwacht");
		}
	}
	
	void identifier(Scanner in) throws VPException {
		if(nextCharInRange(in, LETTER)) {
			Identifier i = new Identifier();
			i.init(letter(in));
			while(nextCharInRange(in, ALFANUMERIEK)) {
				if(nextCharInRange(in, LETTER)) {
					i.append(letter(in));
				} else
				if(nextCharInRange(in, CIJFER)) {
					i.append(cijfer(in));
				}
			}
			verwerk(i);
		} else {
			throw new VPException("identifier verwacht");
		}
	}
	
	void non_identifier(Scanner in) throws VPException {
		if(nextCharInRange(in, CIJFER)) {
			cijfer(in);
			while(nextCharInRange(in, ALFANUMERIEK)) {
				if(nextCharInRange(in, LETTER)) {
					letter(in);
				} else
				if(nextCharInRange(in, CIJFER)) {
					cijfer(in);
				}
			}
		} else {
			throw new VPException("non-identifier verwacht");
		}
	}
	
	void scheider(Scanner in) throws VPException {
		while(nextCharInRange(in, NIET_ALFANUMERIEK)) {
			scheidingsteken(in);
		}
	}
	
	char scheidingsteken(Scanner in) throws VPException {
		if(!nextCharInRange(in, ALFANUMERIEK)) {
			return leesChar(in);
		} else {
			throw new VPException("scheidingsteken verwacht");
		}
	}
	
	char letter(Scanner in) throws VPException {
		if(nextCharInRange(in, LETTER)) {
			return leesChar(in);
		} else {
			throw new VPException("letter verwacht");
		}
	}
	
	char cijfer(Scanner in) throws VPException {
		if(nextCharInRange(in, CIJFER)) {
			return leesChar(in);
		} else {
			throw new VPException("cijfer verwacht");
		}
	}
	
	void verwerk(Identifier i) {
		if (!opslag.present(i)) {
			opslag.add(i);
		} else {
			opslag.remove(i);
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
		Iterator identifierIterator = sortDescending ? opslag.descendingIterator() : opslag.ascendingIterator();
		while (identifierIterator.hasNext()) {
			printIdentifier((Identifier) identifierIterator.next());
		}
	}
	
	void printIdentifier(Identifier identifier) {
		for (int i=0; i<identifier.length(); i++) {
			out.printf("%c", identifier.charAt(i));
		}
		out.printf("\n");
	}
	
	boolean nextCharInRange(Scanner in, String range) {
	    return in.hasNext("[" + range + "]");
	}

	public static void main(String[] argv) {
		new SortUniq().start(argv);
	}
}
