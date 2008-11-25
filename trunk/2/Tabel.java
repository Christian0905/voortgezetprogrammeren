class Tabel implements TabelInterface {

	public Tabel() {
		init();
	}

	public Tabel init() {
		return this;
	}

    public Verzameling<NatuurlijkGetal> retrieve(Identifier i) throws VPException {
		return null;
	}

	public Tabel insert(Identifier i, Verzameling<NatuurlijkGetal> v) {
		return this;
	}

	public int size() {
		return 0;
	}

	public Tabel clone() {
		return null;
	}
}