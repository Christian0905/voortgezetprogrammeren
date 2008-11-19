class NatuurlijkGetal implements NatuurlijkGetalInterface {
	
	private StringBuffer elementen;
	
	NatuurlijkGetal() {
		elementen = new StringBuffer();
		init();
	}
	
	public void init() {
		elementen.delete(0, elementen.length());
		elementen.append('0');
	}
	
	public void append(char c) {
		if (bevatAlleenNul()) {
			elementen.deleteCharAt(0);
		}
		elementen.append(c);
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
	
	public boolean equals(NatuurlijkGetal obj) {
		return compareTo(obj) == 0;
	}
	
	public int compareTo(Object obj) throws ClassCastException {
		if (!(obj instanceof NatuurlijkGetal)) {
			throw new ClassCastException("Natuurlijk getal verwacht.");
		}
		NatuurlijkGetal second = (NatuurlijkGetal)obj;
		if(length() > second.length()) {
			return 1;
		}
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
	
	public Object clone() {
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