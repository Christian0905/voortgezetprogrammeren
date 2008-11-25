class Verzameling<E extends Data> implements VerzamelingInterface {

	Lijst<E> elementen;
	
	public Verzameling() {
		elementen = new Lijst<E>();
		init();
	}
	
	public Verzameling<E> init() {
		elementen.init();
	}
	
	public E retreive() {
		return elementen.retrieve();
	}
	
	public Verzameling<E> insert(Data d) {
		return null;
	}
	
	public Verzameling<E> remove(Data d) {
		return null;
	}
	
	public int size() {
		return elementen.size();
	}
	
	public boolean equals(Verzameling<E> obj) {
		return true;
	}
	
	public Object clone() {
		return null;
	}
}