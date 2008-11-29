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
	
	public boolean equals(Entry rhs) {
		return compareTo(rhs) == 0;
	}
	
	public int compareTo(Data rhs) {
		Entry second = (Entry) rhs;
		return naam.compareTo(second.naam);
	}
	
	public Entry clone() {
		Entry kopie;
		try {
			kopie = (Entry) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error("Deze class is niet cloneable.");
		}
		kopie.naam = naam.clone();
		kopie.inhoud = inhoud.clone();
		return kopie;
	}
}