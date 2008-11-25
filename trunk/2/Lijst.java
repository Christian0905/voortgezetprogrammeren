class Lijst<E extends Data> implements LijstInterface {
	
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
	
	public Lijst<E> insert(Data d) {
		Data kopie = (Data)d.clone();
		if (isEmpty()) {
			first = current = last = new Knoop(kopie);
			aantalKnopen += 1;
			return this;
		}
		Knoop k = first;
		while(k != null && d.compareTo(k.data) > 0) {
			k = k.next;
		}
		if (k == null) { //laatste knoop
			last.next = new Knoop(kopie, last, null);
			last = last.next;
			aantalKnopen += 1;
			return this;
		}
		k.prior = new Knoop(kopie, k.prior, k);
		if (k == first) {
			first = k.prior;
		} else {
			k.prior.prior.next = k.prior;
		}
		aantalKnopen += 1;
		return this;
	}

	public E retrieve() {
		return (E)current.data;
	}
	
	public Lijst<E> remove() {
		if (aantalKnopen == 1) { // laatste knoop verwijderen
			first = last = current = null;
			aantalKnopen = 0;
			return this;
		} else if (current == first) {
			first = current = current.next;
			current.prior = null;
			aantalKnopen -= 1;
			return this;
		} else if (current == last) {
			last = current = current.prior;
			current.next = null;
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
	
	public boolean find(Data d) {
		for (Knoop k = first; k != null; k = k.next) {
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
		}
		current = first;
		return true;
	}
		
	public boolean setLast() {
		if (isEmpty()) {
			return false;
		}
		current = last;
		return true;
	}
	
	public boolean getNext() {
		if (isEmpty() || current == last) {
			return false;
		}
		current = current.next;
		return true;
	}
	
	public boolean getPrior() {
		if (isEmpty() || current == first) {
			return false;
		}
		current = current.prior;
		return true;
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
	
	public String toString() {
		String lijstRegel = new String();
		for (Knoop k = first; k != null; k = k.next) {
			lijstRegel += k.toString();
			lijstRegel += " ";
		}
		return lijstRegel;
	}
}