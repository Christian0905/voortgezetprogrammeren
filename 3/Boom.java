import java.util.Iterator;

public class Boom<E extends Data> implements BoomInterface<E> {

	public Boom() {
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

	public Boom<E> add(E element) {
		return this;
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