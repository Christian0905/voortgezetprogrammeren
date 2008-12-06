import java.util.Iterator;
import java.util.ArrayList;

public class Boom<E extends Data> implements BoomInterface<E> {
	
	private BoomKnoop wortel;
	private int aantalKnopen;
	
	public Boom() {
		wortel = null;
		aantalKnopen = 0;
	}

	public int size() {
		return aantalKnopen;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean present(E element) {
		return present(wortel, element);
	}

	private boolean present(BoomKnoop w, E element) {
		if (w == null) {
			return false;
		} else if (element.compareTo(w.data) < 0) {
			return present(w.links, element);
		} else if (element.compareTo(w.data) == 0) {
			return true;
		} else {  // element.compareTo(w.data0 > 0
			return present(w.rechts, element);
		}
	}

	public Boom<E> add(E element) {
		wortel = add(wortel, element);
		return this;
	}

	private BoomKnoop add(BoomKnoop w, E element) {
		if (w == null) {
			aantalKnopen += 1;
			return new BoomKnoop(element);
		}
		if (element.compareTo(w.data) <= 0) {
			w.links = add(w.links, element);
		} else {
			w.rechts = add(w.rechts, element);
		}
		return w;
	}

	public Boom<E> remove(E element) {
		return this;
	}

	public Iterator<E> ascendingIterator() {
		return null;
	}

	public Iterator<E> descendingIterator() {
		return null;
	}

	public Boom<E> clone() {
		return null;
	}
}