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
		wortel = remove(wortel, element);
		return this;
	}
	
	private BoomKnoop remove(BoomKnoop w, E element) {
		if (w == null) {
			throw new Error("Da ga nie gaan, boom is leeg");
		}
		if (element.compareTo(w.data) < 0) {
			w.links = remove(w.links, element);
		} else
		if (element.compareTo(w.data) > 0) {
			w.rechts = remove(w.rechts, element);
		} else  // w.data == element
		if (w.links != null && w.rechts != null) {
			w.data = maximum(w.links); 
			w.links = remove(w.links, element);  // waarom kan dit niet met w.data?
		} else {
		w = w.links != null?w.links:w.rechts;
		}
		return w;
	}
	
	public Identifier maximum(BoomKnoop w) {
		// help :\
		return null;
	}

	public Iterator<E> ascendingIterator() {
		
		//nieuwe array list
		//traversel door boom
		//voor elk element referentie toevoegen aan arraylist
		//arraylist casten naar iterator
		return null;
	}

	public Iterator<E> descendingIterator() {
		// snap hier geen hol van
		return null;
	}

	public Boom<E> clone() {
		Boom kopie;
		try {
			kopie = (Boom) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error("Deze class is niet CLoneable");
		}
	kopie.wortel = wortel == null ? null : (BoomKnoop) wortel.clone();
	kopie.aantalKnopen = aantalKnopen;
	return kopie;
	}
}