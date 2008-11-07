import java.io.PrintStream;
import java.util.Scanner;

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
		// leest de eerste en tweede verzameling in 

		return
		leesIdentifierVerzameling(eersteVerzameling, "Geef de eerste verzameling: ") &&
		leesIdentifierVerzameling(tweedeVerzameling, "Geef de tweede verzameling: ");

		// tweedeVerzameling wordt pas gevraagd als de eerste identifierVerzameling correct ingelezen is (McCarthy-evaluatie)
	}

	boolean leesIdentifierVerzameling(IdentifierVerzameling verzameling, String vraag) {
		do {
			stelVraag(vraag);
			verzameling.init();
			if (!in.hasNext()) {
				return false;
			}
			} while (!invoerCorrect(verzameling));
			return true;
	}
	
	void stelVraag(String vraag) {
		//stelt 'vraag'
	}
	
	boolean invoerCorrect(IdentifierVerzameling verzameling) {
		while(in.hasNext()) {
			// leest de IdentifierVerzameling 'verzameling' in
			// en controleert op de volgende fouten:
			/* 	1. "{" accolade openen ontbreekt
				2. "}" accolade sluiten ontbreekt
				3. de invoer bevat meer dan 10 identifiers
				4. na de "}" staat nog invoer
				5. niet-alfanumerieke karakters gegeven
				6. identifier op de invoer die niet begint met een letter
			*/
			// in geval van fout: return false
		}
		return true;
	}

	void verwerkEnPrintOperaties(IdentifierVerzameling eersteVerzameling, IdentifierVerzameling tweedeVerzameling) {
		// rekent met de gegeven verzamelingen het volgende uit: verschil, doorsnede, vereniging, symm. verschil
		// en print vervolgens in die volgorde de resultaten hiervan uit
	}
	
	void printVerzameling(IdentifierVerzameling verzameling) {
		// print een gegeven verzameling naar 'out'
	}

	public static void main(String[] srgv) {
		new Opgave1().start();
	}
}