public class IdentifierVerzameling implements IdentifierVerzamelingInterface, Cloneable {

	private static final int MAXIMUM_AANTAL_ELEMENTEN = 20;
	
	private Identifier[] identifierArray;
	private int aantalElementen;

	IdentifierVerzameling() {
		init();
	}
	
	IdentifierVerzameling(IdentifierVerzameling source) {
		identifierArray = source.clone().identifierArray;
		aantalElementen = source.aantalElementen;
	}

	public void init() {
		identifierArray = new Identifier[MAXIMUM_AANTAL_ELEMENTEN];
		aantalElementen = 0;
	}

	public void voegToe(Identifier element) throws Exception {
		if (!isAanwezig(element)) {
			if (aantalElementen < MAXIMUM_AANTAL_ELEMENTEN) {
				identifierArray[aantalElementen] = element.clone();
				aantalElementen += 1;
			} else {
				throw new Exception("IdentifierVerzameling is vol");
			}
		}
	}

	public void verwijder(Identifier element) {
		for (int i = 0; i < aantalElementen; i++) {
			if (identifierArray[i].equals(element)) {
				verwijderEnSchuifOp(i);
			}
		}
	}
	
	private void verwijderEnSchuifOp(int index) {
		for (int i = index; i < (aantalElementen - 1); i++) {
			identifierArray[i] = identifierArray[i + 1];
		}
		aantalElementen -= 1;
	}

	public boolean isAanwezig(Identifier element) {
		for (int i = 0; i < aantalElementen; i++) {
			if (identifierArray[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	public Identifier geefIdentifier() {
		return identifierArray[aantalElementen].clone();
	}

	public boolean isEmpty() {
		return aantalElementen == 0;
	}

	public String toString() {
		String resultaat = new String("{");
		for (int i = 0; i < aantalElementen; i++) {
			resultaat += identifierArray[i].toString();
			resultaat += " ";
		}
		resultaat = resultaat.trim() + "}";
		return resultaat;
	}

	public int size() {
		return aantalElementen;
	}

	public IdentifierVerzameling verschil(IdentifierVerzameling teVergelijken) {
		IdentifierVerzameling resultaat = new IdentifierVerzameling();
		for (int i = 0; i < aantalElementen; i++) {
			if (!teVergelijken.isAanwezig(identifierArray[i])) {
				try {
					resultaat.voegToe(identifierArray[i].clone());
				} catch (Exception e) {
					throw new Error("IdentifierVerzameling zit vol.");
				}
			}
		}
		return resultaat;
	}

	public IdentifierVerzameling doorsnede(IdentifierVerzameling teVergelijken) {
		IdentifierVerzameling resultaat = new IdentifierVerzameling();
		for (int i = 0; i < aantalElementen; i++) {
			if (teVergelijken.isAanwezig(identifierArray[i])) {
				try {
					resultaat.voegToe(identifierArray[i].clone());
				} catch (Exception e) {
					throw new Error("IdentifierVerzameling zit vol.");
				}
			}
		}
		return resultaat;
	}

	public IdentifierVerzameling vereniging(IdentifierVerzameling teVergelijken) throws Exception {
		IdentifierVerzameling resultaat = clone();
		for (int i = 0; i < teVergelijken.aantalElementen; i++) {
			resultaat.voegToe(teVergelijken.identifierArray[i].clone());
		}
		return resultaat;
	}
	
	public IdentifierVerzameling symmetrischVerschil(IdentifierVerzameling teVergelijken) throws Exception {
		return verschil(teVergelijken).vereniging(teVergelijken.verschil(this));
	}
	
	public IdentifierVerzameling clone() {
		IdentifierVerzameling kopie;
		try {
			kopie = (IdentifierVerzameling)super.clone();
		} catch(CloneNotSupportedException e) {
			throw new Error("Clone not supported");
		}
		for (int i = 0; i < aantalElementen; i++) {
			kopie.identifierArray[i] = identifierArray[i].clone();
		}
		return kopie;
	}
}