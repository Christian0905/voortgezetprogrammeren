class Entry implements Data {
	
	public Identifier naam;
	public Verzameling<NatuurlijkGetal> inhoud;

	Entry(Identifier naam, Verzameling<NatuurlijkGetal> inhoud) {
		init(naam, inhoud);
	}
	
	public void init(Identifier naam, Verzameling<NatuurlijkGetal> inhoud) {
		this.naam = naam;
		this.inhoud = inhoud;
	}
	
	public boolean equals(Entry obj) {
		return compareTo(obj) == 0;
	}
	
	public int compareTo(Data obj) {
		Entry second = (Entry) obj;
		return naam.compareTo(second.naam);
	}
	
	public Entry clone() {
		return null;
	}
}