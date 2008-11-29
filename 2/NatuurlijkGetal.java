class NatuurlijkGetal implements NatuurlijkGetalInterface {

	private StringBuffer elementen;

	NatuurlijkGetal() {
		elementen = new StringBuffer();
		init();
	}

	public NatuurlijkGetal init() {
		elementen.delete(0, elementen.length());
		elementen.append('0');
		return this;
	}

	public NatuurlijkGetal append(char c) {
		if (bevatAlleenNul()) {
			elementen.deleteCharAt(0);
		}
		elementen.append(c);
		return this;
	}

	public boolean bevatAlleenNul() {
		return elementen.charAt(0) == '0' && elementen.length() == 1;
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

	public boolean equals(NatuurlijkGetal rhs) {
		return compareTo(rhs) == 0;
	}

	public int compareTo(Data rhs) {
		NatuurlijkGetal second = (NatuurlijkGetal)rhs;
		if(length() > second.length()) {
			return 1;
		} else
		if(length() < second.length()) {
			return -1;
		}
		for(int i = 0; i<length(); i++) {
			if(charAt(i) > second.charAt(i)) {
				return 1;
			}
			if(charAt(i) < second.charAt(i)) {
				return -1;
			}
		}
		return 0;
	}

	public NatuurlijkGetal clone() {
		NatuurlijkGetal kopie;
		try {
			kopie = (NatuurlijkGetal) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error("Deze class is niet cloneable.");
		}
		kopie.elementen = new StringBuffer(elementen);
		return kopie;
	}
}
