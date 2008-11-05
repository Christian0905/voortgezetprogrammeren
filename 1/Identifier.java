class Identifier {

	private StringBuffer identifier;
	
	Identifier() {
		init('a');
	}
	
	Identifier(Identifier src) {
		identifier = new StringBuffer(src.identifier);
	}
	
	public void init(char c) {//throws Exception {
		identifier = new StringBuffer();
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
	
	public boolean equals(Identifier obj) {
		return identifier.equals(obj.identifier);
	}
}