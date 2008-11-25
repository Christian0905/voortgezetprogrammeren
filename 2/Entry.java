class Entry {
	
	public Identifier naam;
	public Verzameling inhoud;

	Entry(Identifier identifier) {
		init(identifier);
	}
	
	public void init(Identifier identifier) {
		naam = identifier;
		inhoud = new Verzameling();
	}
	
	public boolean equals(Entry obj) {
		return compareTo(obj) == 0;
	}
	
	public int compareTo(Object obj) {
		return naam.compareTo((Identifier)obj.naam);
	}
	
	public Object clone() {
	}
}