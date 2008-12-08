/*imports*/

public class SortUniq {

	static final String NIET_ALFANUMERIEK = "[^a-zA-Z0-9]+";
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
			Scanner file = new Scanner(new File(files[i]));
			leesWoorden(file);
		}
	}
	
	void leesWoorden(Scanner in) {
		in.useDelimiter(NIET_ALFANUMERIEK);
		while (in.hasNext()) {
			/*check of scanner een identifier leest, zo ja: verwerk de identifier*/
		}
	}
	
	boolean isIdentifier(Scanner woordScanner) {
		/*geeft aan of de scanner een identifier leest*/
	}
	
	void verwerk(Scanner identifierScanner) {
		/*lees identifier in*/
		/*als een kopie van de identifier aanwezig is in opslag: verwijder deze*/
		/*als er nog geen kopie van identifier aanwezig is in opslag: voeg identifier toe*/
	}

	char leesChar(Scanner in) {
		/*lees de eerste char van de scanner in en retourneer deze char*/
		/*als caseInsensitive true is, maak dan een lowercase-char van de ingelezen char*/
	}
	
	void printOpslag() {
		/*print de opslag in oplopende volgorde m.b.v. een iterator*/
		/*als sortdescending true is, print dan in aflopende volgorde*/
	}
	
	void printIdentifier(Identifier identifier) {
		/*print een regel met daarop alleen identifier*/
	}

	public static void main(String[] argv) {
		new SortUniq().start(argv);
	}
}
