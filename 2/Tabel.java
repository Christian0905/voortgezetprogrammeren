class Tabel implements TabelInterface {

	Lijst<Entry> elementen;
	
	public Tabel() {
		elementen = new Lijst<Entry>();
		init();
	}

	public Tabel init() {
		elementen.init();
		return this;
	}

    public Verzameling<NatuurlijkGetal> retrieve(Identifier i) throws VPException {
		Entry e = new Entry(i, new Verzameling<NatuurlijkGetal>());
		if (elementen.find(e)) {
			return elementen.retrieve().inhoud;
		} else {
			throw new VPException("identifier niet gevonden");
		}
	}

	public Tabel insert(Identifier i, Verzameling<NatuurlijkGetal> v) {
		Entry e = new Entry(i, v);
		if (elementen.find(e)) {
			elementen.remove();
		}
		elementen.insert(e);
		return this;
	}

	public int size() {
		return elementen.size();
	}

	public Tabel clone() {
		Tabel kopie;
		try {
			kopie = (Tabel) super.clone();
			} catch (CloneNotSupportedException e) {
				throw new Error("Deze class is niet cloneable.");
			}
			kopie.elementen = elementen.clone();
			return kopie;
			
	}
}