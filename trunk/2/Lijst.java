class Lijst<E extends Data> implements Cloneable {
	
	public Knoop first, last, current;
	public int aantalKnopen;
	
	public Lijst() {
		init();
	}
	
	public Lijst<E> init() {
		first = null;
		last = null;
		current = null;
		aantalKnopen = 0;
		return this;
	}
	
	public boolean isEmpty() {
		return (current == null);
	}
	
	public int size() {
		return aantalKnopen;
	}
	
	public Lijst<E> insert(E d) {
		if (isEmpty()) {
			first = current = last = new Knoop(d);  // toevoegen als leeg
			aantalKnopen += 1;
			return this;
		}
		Knoop k = first;
		while(d.compareTo(k.data) > 0) {
			if (k.next != null) {   // laatste knoop
				k = k.next;
			} else {
				last = k.next = new Knoop(d, k, null); //toevoegen als laatste
				aantalKnopen += 1;
				return this;
			}
		}
		if (k.prior == null) { //eerste knoop
			first = k.prior = new Knoop(d, null, k);  // toevoegen voor de eerste
			aantalKnopen += 1;
			return this;
		} else {
			k.prior = k.prior.next = new Knoop(d, k.prior, k);   // toevoegen in het midden
			aantalKnopen += 1;
			return this;
		}
	}

	public E retreive() {
		Knoop tijdelijk = new Knoop(null);
		tijdelijk = current;
		return (E)tijdelijk.data;  // hier cast maar hoe
	}
	
	public Lijst<E> remove() {
		if (current.prior == null) { // current is eerste object
			current.next = current.next.prior = null;
			first = current = current.next;
			aantalKnopen -= 1;
			return this;
		} else if (aantalKnopen == 1) { // laatste knoop verwijderen
			first = last = current = null;
			aantalKnopen = 0;
			return this;
		} else if (current.next == null) { // current is het laatset object
			current.prior.next = null;
			last = current = current.prior;
			aantalKnopen -= 1;
			return this;
		} else {
			current.prior.next = current.next; // current verwijderen en next wordt current
			current.next.prior = current.prior;
			current = current.next;
			aantalKnopen -= 1;
			return this;
		}
	}
	
	public boolean find(E d) {
		Knoop k = first;
		for (int i = 0; i<aantalKnopen; i++) {
			k = k.next;
			if(d.compareTo(k.data) == 0) {
				current = k;
				return true;
			}
		}
		//hier moet nog veel zooi
		return false;
	}

	public boolean setFirst() {
		if (isEmpty()) {
			return false;
		} else {
			current = first;
			return true;
		}
	}
		
	public boolean setLast() {
		if (isEmpty()) {
			return false;
		} else {
			current = last;
			return true;
		}
	}
	
	public boolean getNext() {
		if (isEmpty() || current.data.compareTo(last.data) == 0) {
			return false;
		} else {
			current = current.next;
			return true;
		}
	}
	
	public boolean getPrior() {
		if (isEmpty() || current.data.compareTo(first.data) == 0) {
			return false;
			} else {
				current = current.prior;
				return true;
		}
	}
	
	public Lijst<E> clone() {
		Lijst<E> kopie;
		try {
			kopie = (Lijst<E>) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error("Onmogelijk! instantie Lijst is niet Cloneable");
		}
		
		kopie.first = first == null?null:(Knoop)first.clone();
		kopie.last = last == null?null:(Knoop)last.clone();
		kopie.current = current == null?null:(Knoop)current.clone();
		kopie.aantalKnopen = aantalKnopen; //???
		return kopie;
	}
}		