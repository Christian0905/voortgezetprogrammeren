interface Lijst<E extends Data> extends Cloneable {
	
	private E lijstElement;
	
	public Lijst() {
		lijstElement = new Lijst<E>();
		init();
	}
	
	public Lijst<E> init () {
		lijstElement = null;
		return lijstElement;
	}
	
	public boolean isEmpty() {
		return(lijstElement == null);
	}
	
	public int size() {
	}
	
	public int aantalKnopen(Knoop knoop) {
		if (knoop == null) {
			return 0;
		}
		return 1 + aantalKnopen(knoop.next);
	}
	
	public Lijst<E> insert(E d) {
		
		return 

}