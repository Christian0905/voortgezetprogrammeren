import java.util.Iterator;

public class Boom<E extends Data> implements BoomInterface<E> {
	
	private BoomKnoop boom;
	
	public Boom() {
		boom = new BoomKnoop();
	}

	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return false;
	}

	public boolean present(E element) {
		return false;
	}

	public Boom<E> add(E element) {  // dit kan niet zonder een wortel variabele
		if (boom.data == null) {
			return new BoomKnoop(element);
		}
		if (element.compareTo(boom.data) <= 0) {
			boom.links = add(element);
		} else {
			boom.rechts = add(element);
		}
		return boom;
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