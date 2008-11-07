class Identifier {

	private StringBuffer identifier;

	Identifier() {
		identifier = new StringBuffer();
		init('a');
	}

	Identifier(Identifier src) {
			identifier = new StringBuffer(src.identifier);
	}

	public void init(char c) {
		identifier.delete(0, identifier.length());
		identifier.append(c);
	}

	public void append(char c) {
			identifier.append(c);
	}

	public char charAt(int i) {
			return identifier.charAt(i);
	}

	public int length() {
			return identifier.length();
	}

	public String toString() {
		return identifier.toString();
	}

	public boolean equals(Identifier obj) {
		if (length()!=obj.length()) {
			return false;
		}
		for(int i=0; i<length(); i++) {
			if(identifier.charAt(i) != obj.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}