class Verzameling implements VerzamelingInterface {
	
	private NatuurlijkGetal[] ngArray;  //????
	private int aantalElementen;

	Verzameling() {
		ngArray = new NatuurlijkGetal[MAX_AANTAL_ELEMENTEN];
		init();
	}
	
	public VerzamelingInterface<E> init() {
		aantalElementen = 0;
	}
	
	public E retreive() {
		return new E(ngArray[aantalElementen - 1]);
	}
	
	public VerzamelingInterface<E> insert(Data d) {
		
	}
	
	public VerzamelingInterface<E> remove(Data d) {
	}
	
	public int size() {
	}
	
	public boolean equals(NatuurlijkGetal obj) {
	}
	
	public Object clone() {
	}
}