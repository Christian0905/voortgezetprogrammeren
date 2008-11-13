class Lijst<E extends Data> implements Cloneable {
	
	public Knoop first;
	public Knoop last;
	public Knoop current;
	
	public Lijst() {
		init();
	}
	
	public Lijst<E> init() {
		first = null;
		last = null;
		current = null;
		return this;
	}
	
	public boolean isEmpty() {
		return(current == null);
	}
	
	public int size() {
		return 0;
	}
	
	public int aantalKnopen(Knoop knoop) {
		if (knoop == null) {
			return 0;
		}
		return 1;// + aantalKnopen(knoop.next);
	}
	
	/*public Lijst<E> insert(E d) {	
		return
	}*/
}