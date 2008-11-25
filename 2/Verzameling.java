class Verzameling<E extends Data> implements VerzamelingInterface {

	Lijst<E> elementen;
	
	public Verzameling() {
		elementen = new Lijst<E>();
		init();
	}
	
	public Verzameling<E> init() {
		elementen.init();
		return this;
	}
	
	public E retrieve() {
		return elementen.retrieve();
	}
	
	public Verzameling<E> insert(Data d) {
		elementen.insert(d);
		return this;
	}
	
	public Verzameling<E> remove(Data d) {
		if (elementen.find(d)) {
			elementen.remove();
		}
		return this;
	}
	
	public int size() {
		return elementen.size();
	}
	
	public Verzameling<E> doorsnede(Verzameling obj) {
		return null;
	}
	
	public Verzameling<E> verschil(Verzameling obj) {
		return null;
	}
	
	public Verzameling<E> vereniging(Verzameling obj) {
		return null;
	}
	
	public Verzameling<E> symmetrischVerschil(Verzameling obj) {
		return null;
	}
	
	public boolean equals(Verzameling obj) {
		return elementen.equals(obj.elementen);
	}
	
	public Verzameling<E> clone() {
		return null;
	}
}