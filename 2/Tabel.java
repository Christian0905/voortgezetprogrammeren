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
		if (elementen.find(i)) {
			return elementen.retrieve().inhoud;
		} else {
			throw new VPException("identifier niet gevonden");
		}
	}

	public Tabel insert(Identifier i, Verzameling<NatuurlijkGetal> v) {
		Entry e = new Entry(i, v);
		elementen.insert(e);
		return this;
	}

	public int size() {
		return elementen.size();
	}

	public Tabel clone() {
		return null;
	}
}