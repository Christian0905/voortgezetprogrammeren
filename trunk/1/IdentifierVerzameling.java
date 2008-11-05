class IdentifierVerzameling {
	
	private static final int MAX_AANTAL_ELEMENTEN = 20;
	
	private Identifier[] identifierArray;
	private int aantalElementen;
	
	IdentifierVerzameling() {
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
		identifierArray = new Identifier[MAX_AANTAL_ELEMENTEN];
		aantalElementen = 0;
	}
	
	public void voegToe(Identifier element) { //throws exception
		identifierArray[aantalElementen] = new Identifier(element);
		aantalElementen += 1;
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
		String identifierRegel = new String("{");
		for (int i = 0; i < aantalElementen; i++) {
			identifierRegel += identifierArray[i].toString();
			identifierRegel += " ";
		}
		identifierRegel += "}";
		return identifierRegel;
	}
	
	
	public int aantalIdentifiers() {
		return aantalElementen;
	}
	
	/*hier komen de logica dingen*/

}