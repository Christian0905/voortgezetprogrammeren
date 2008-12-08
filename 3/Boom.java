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
		} else
		if (element.compareTo(w.data) < 0) {
			return present(w.links, element);
		} else
		if (element.compareTo(w.data) == 0) {
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
		} else
		if (element.compareTo(w.data) <= 0) {
			w.links = add(w.links, element);
		} else {
			w.rechts = add(w.rechts, element);
		}
		return w;
	}

	public Boom<E> remove(E element) {
		wortel = remove(wortel, element);
		return this;
	}
	
	private BoomKnoop remove(BoomKnoop w, E element) {
		if (w == null) {
			throw new Error("Verwijderen onmogelijk, de boom is leeg.");
		} else
		if (element.compareTo(w.data) < 0) {
			w.links = remove(w.links, element);
		} else
		if (element.compareTo(w.data) > 0) {
			w.rechts = remove(w.rechts, element);
		} else  // w.data == element
		if (w.links != null && w.rechts != null) {
			w.data = maximum(w.links);
			w.links = remove(w.links, (E) w.data);
		} else {
			w = w.links != null ? w.links : w.rechts;
		}
		return w;
	}
	
	private E maximum(BoomKnoop w) {
		if(w.rechts == null) {
			return (E) w.data;
		} else {
			return maximum(w.rechts);
		}
	}

	public Iterator<E> ascendingIterator() {
		ArrayList<E> list = new ArrayList<E>();
		inOrderTraversal(wortel, list);
		return list.iterator();
	}
	
	private void inOrderTraversal(BoomKnoop w, ArrayList list) {
		if (w != null) {
			inOrderTraversal(w.links, list);
			list.add(w.data);
			inOrderTraversal(w.rechts, list);
		}
	}

	public Iterator<E> descendingIterator() {
		ArrayList<E> list = new ArrayList<E>();
		reverseInOrderTraversal(wortel, list);
		return list.iterator();
	}
	
	private void reverseInOrderTraversal(BoomKnoop w, ArrayList list) {
		if (w != null) {
			reverseInOrderTraversal(w.rechts, list);
			list.add(w.data);
			reverseInOrderTraversal(w.links, list);
		}
	}

	public Boom<E> clone() {
		Boom kopie;
		try {
			kopie = (Boom<E>) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error("Deze class is niet Cloneable");
		}
		kopie.wortel = wortel == null ? null : wortel.clone();
		return kopie;
	}
}
