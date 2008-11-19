class Identifier implements IdentifierInterface {

	private StringBuffer elementen;

	Identifier() {
		elementen = new StringBuffer();
		init('a');
	}

	public void init(char c) {
		elementen.delete(0, elementen.length());
		elementen.append(c);
	}

	public void append(char c) {
			elementen.append(c);
	}

	public char charAt(int i) {
			return elementen.charAt(i);
	}

	public int length() {
			return elementen.length();
	}

	public String toString() {
		return elementen.toString();
	}

	public boolean equals(Identifier obj) {
		return compareTo(obj) == 0;
	}
	
	public int compareTo(Identifier obj) {
		// hoe ging dat nou bij abc > abcd ?
		for(int i = 0; i<length(); i++) {
			if(charAt(i) > obj.charAt(i)) {
				return 1;
			}
			if(charAt(i) < obj.charAt(i)) {
				return -1;
			}
		}
		return 0;
	}
	
	public Identifier clone() {
		Identifier kopie;
		try {
			kopie = super.clone(); // shallow copy
			} catch { (CloneNotSupportedException e) {
				throw new Error("Onmogelijk! Deze class is niet cloneable");
			}
			kopie.elementen = new StringBuffer(elementen);
			return kopie;
			}
	}
}
