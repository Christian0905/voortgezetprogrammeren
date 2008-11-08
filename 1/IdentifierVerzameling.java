class IdentifierVerzameling {

	private static final int MAX_AANTAL_ELEMENTEN = 20;

	private Identifier[] identifierArray;
	private int aantalElementen;

	IdentifierVerzameling() {
		identifierArray = new Identifier[MAX_AANTAL_ELEMENTEN];
		init();
	}

	IdentifierVerzameling(IdentifierVerzameling src) {
		aantalElementen = src.aantalElementen;
		identifierArray = new Identifier[src.identifierArray.length];
		for (int i = 0; i<aantalElementen; i++) {
			identifierArray[i] = new Identifier(src.identifierArray[i]);
		}
	}

	public void init() {
		aantalElementen = 0;
	}

	public void voegToe(Identifier element) throws Exception {
		if (!isAanwezig(element)) {
			if (aantalElementen < MAX_AANTAL_ELEMENTEN) {
				identifierArray[aantalElementen] = new Identifier(element);
				aantalElementen += 1;
			} else {
				throw new Exception("IdentifierVerzameling is vol");
			}
		}
	}

	public void verwijder(Identifier element) {
		for (int i = 0; i < aantalElementen; i++) {
			if (identifierArray[i].equals(element)) {
				for (int j = i; j < (aantalElementen - 1); j++) {
					identifierArray[j] = identifierArray[j + 1];
				}
				aantalElementen -= 1;
			}
		}
	}

	public Identifier geefIdentifier() {
		return new Identifier(identifierArray[aantalElementen - 1]);
	}

	public boolean isAanwezig(Identifier element) {
		for (int i = 0; i < aantalElementen; i++) {
			if (identifierArray[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	public boolean isLeeg() {
		return aantalElementen == 0;
	}

	public String toString() {
		String identifierRegel = new String();
		for (int i = 0; i < aantalElementen; i++) {
			identifierRegel += identifierArray[i].toString();
			identifierRegel += " ";
		}
		return identifierRegel.trim();
	}

	public int aantalIdentifiers() {
		return aantalElementen;
	}

	public IdentifierVerzameling verschil(IdentifierVerzameling input) throws Exception {
		IdentifierVerzameling resultaat = new IdentifierVerzameling();
		for (int i = 0; i<aantalElementen; i++) {
			if (!input.isAanwezig(identifierArray[i])) {
				resultaat.voegToe(identifierArray[i]);
			}
		}
		return resultaat;
	}

	public IdentifierVerzameling doorsnede(IdentifierVerzameling input) throws Exception {
		IdentifierVerzameling resultaat = new IdentifierVerzameling();
		for (int i = 0; i<aantalElementen; i++) {
			if (input.isAanwezig(identifierArray[i])) {
				resultaat.voegToe(identifierArray[i]);
			}
		}
		return resultaat;
	}

	public IdentifierVerzameling vereniging(IdentifierVerzameling input) throws Exception {
		IdentifierVerzameling resultaat = new IdentifierVerzameling(this);
		for (int i = 0; i<input.aantalElementen; i++) {
			resultaat.voegToe(input.identifierArray[i]);
		}
		return resultaat;
	}

	IdentifierVerzameling symmetrischVerschil(IdentifierVerzameling input) throws Exception {
		return vereniging(input).verschil(doorsnede(input));
	}
}
