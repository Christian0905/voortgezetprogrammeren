class Identifier implements IdentifierInterface, Cloneable {

	private StringBuffer tekenreeks;

	Identifier() {
		init('a');
	}

	Identifier(Identifier source) {
		tekenreeks = new StringBuffer(source.tekenreeks);
	}
	
	public void init(char c) {
		tekenreeks = new StringBuffer();
		tekenreeks.append(c);
	}

	public void append(char c) {
		tekenreeks.append(c);
	}
	
	public char charAt(int index) {
		return tekenreeks.charAt(index);
	}

	public int length() {
		return tekenreeks.length();
	}

	public String toString() {
		return tekenreeks.toString();
	}

	public boolean equals(Identifier obj) {
		return tekenreeks.toString().equals(obj.tekenreeks.toString());
	}

	public Identifier clone() {
		Identifier kopie;
		try {
			kopie = (Identifier)super.clone();
		} catch(CloneNotSupportedException e) {
			throw new Error("Clone not supported");
		}
		kopie.tekenreeks = new StringBuffer(tekenreeks);
		return kopie;
	}
}
