/**
 * Binaire zoekboom ADT voor opdracht 3
 * @author	Twan v.d. Loo
 * @author	Jan van der Lugt
 */

/** @elementen	Objecten van het type E
 @structuur	Binaire boom
 @domein	Alle binaire zoekbomen
 
 @constructor
 <h3>Boom()</h3>
 <b>PRE</b><br>
 -<br>
 <b>POST</b><br>
 Er is een nieuw Boom-object gemaakt. De boom bevat geen objecten.
 */

public interface Boom<E extends Data> extends Cloneable {
	
	/** @preconditie	-
	 @postconditie	Het aantal elementen in de boom is geretourneerd.
	 */
	int size();
	
	/** @preconditie	-
	 @postconditie	TRUE:	De boom is leeg.<br />
					FALSE:	De boom is niet leeg.
	 */
	boolean isEmpty();
	
	/** @preconditie	-
	 @postconditie	TRUE:	Een kopie van element is aanwezig in de boom.<br />
					FALSE:	Een kopie van element is niet aanwezig in de boom.
	 */
	boolean present(E element);
	
	/** @preconditie	-
	 @postconditie	Een kopie van element is toegevoegd aan de boom en het huidige object is geretourneerd.
	 */
	Boom<E> add(E element);
	
	/** @preconditie	Een kopie van element is aanwezig in de boom.
	 @postconditie	Een enkele kopie van element is verwijderd uit de boom.
	 */
	Boom<E> remove(E element);
	
	/**	@preconditie	-
	 @postconditie	De in de binaire zoekboom opgeslagen data zijn in monotoon niet-dalende volgorde doorlopen en in deze volgorde in een object van het type Iterator gezet. Dit object van het type Iterator is daarna geretourneerd.
	 */
	Iterator ascendingIterator()
	
	/**	@preconditie	-
	 @postconditie	De in de binaire zoekboom opgeslagen data zijn in monotoon niet-stijgende volgorde doorlopen en in deze volgorde in een object van het type Iterator gezet. Dit object van het type Iterator is daarna geretourneerd.
	 */
	Iterator descendingIterator()
	
	/** @preconditie	-
	 @postconditie	Een deep-copy van het huidige object is geretourneerd.
	 */
	Boom<E> clone()
}