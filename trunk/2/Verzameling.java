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
		if (!elementen.find(d)) {
			elementen.insert(d);
		}
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
	
	public Verzameling<E> doorsnede(Verzameling rhs) {
		Verzameling<E> resultaat = new Verzameling<E>();
		for (Knoop k = elementen.first; k != null; k = k.next) {
			if (rhs.elementen.find(k.data)) {
				resultaat.insert(k.data);
			}
		}
		return resultaat;
	}
	
	public Verzameling<E> verschil(Verzameling rhs) {
		Verzameling<E> resultaat = new Verzameling<E>();
		for (Knoop k = elementen.first; k != null; k = k.next) {
			if (!rhs.elementen.find(k.data)) {
				resultaat.insert(k.data);
			}
		}
		return resultaat;
	}
	
	public Verzameling<E> vereniging(Verzameling rhs) {
		Verzameling<E> resultaat = clone();
		for (Knoop k = rhs.elementen.first; k != null; k = k.next) {
			resultaat.insert(k.data);
		}
		return resultaat;
	}
	
	public Verzameling<E> symmetrischVerschil(Verzameling rhs) {
		return vereniging(rhs).verschil(doorsnede(rhs));
	}
	
	public Verzameling<E> clone() {
		Verzameling<E> kopie;
		try {
			kopie = (Verzameling<E>) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error("Onmogelijk! instantie Verzameling is niet Cloneable");
		}
		kopie.elementen = elementen.clone();
		return kopie;
	}
}