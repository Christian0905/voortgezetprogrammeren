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
	
	public int compareTo(Object obj) {
		Identifier second = (Identifier) obj;
		for(int i = 0; i < Math.min(length(), second.length()); i++) {
			if(charAt(i) > second.charAt(i)) {
				return 1;
			}
			if(charAt(i) < second.charAt(i)) {
				return -1;
			}
		}
		if (length() < second.length()) {
			return -1;
		} else
		if (length() > second.length()) {
			return 1;
		}
		return 0;
	}
	
	public Object clone() {
		Identifier kopie;
		try {
			kopie = (Identifier) super.clone(); // shallow copy
		} catch (CloneNotSupportedException e) {
			throw new Error("Onmogelijk! Deze class is niet cloneable");
		}
		kopie.elementen = new StringBuffer(elementen);
		return kopie;
	}
}
