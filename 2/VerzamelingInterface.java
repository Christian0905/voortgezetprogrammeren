/**
 * Verzameling ADT voor opdracht 2
 * @author	Twan v.d. Loo
 * @author	Jan van der Lugt
 */

/** @elementen	Objecten van het type E
	@structuur	Geen
	@domein		Alle verzamelingen van E-objecten.

	@constructor
	<h3>Verzameling()</h3>
	<b>PRE</b><br>
	-<br>
	<b>POST</b><br>
	Er is een nieuw Verzameling-object gemaakt. Dit object bevat nog geen elementen.
	*/

public interface VerzamelingInterface<E extends Data> extends Cloneable {

	/** @preconditie	-
		@postconditie	Het huidige object bevat geen elementen.
		*/
	Verzameling<E> init();

    /**	@preconditie	De verzameling is niet leeg.
		@postconditie	Een kopie van een willekeurig element uit de verzameling is geretourneerd.
    */
    E retrieve();

	/** @preconditie	-
		@postconditie	Het een kopie van element is aanwezig in de verzameling.
		*/
	Verzameling<E> insert(E element);

	/**	@preconditie	-
		@postconditie	element is niet aanwezig in de verzameling.
		*/
	Verzameling<E> remove(E element);

	/**	@preconditie	-
		@postconditie	Een nieuwe Verzameling is geretourneerd met als inhoud kopieën van de E-elementen die zowel in de huidige Verzameling zitten als in obj.
		*/
	Verzameling<E> doorsnede(Verzameling<E> obj);

	/**	@preconditie	-
		@postconditie	Een nieuwe Verzameling is geretourneerd met als inhoud kopieën van de E-elementen die wel in de huidige Verzameling zitten, maar niet in obj.
		*/
	Verzameling<E> verschil(Verzameling<E> obj);

	/**	@preconditie	-
		@postconditie	Een nieuwe Verzameling is geretourneerd met als inhoud kopieën van de E-elementen die in de huidige Verzameling zitten, of in obj, of in beide.
		*/
	Verzameling<E> vereniging(Verzameling<E> obj);

	/**	@preconditie	-
		@postconditie	Een nieuwe Verzameling is geretourneerd met als inhoud kopieën van de E-elementen die of in de huidige Verzameling zitten, of in obj, maar niet in beide.
		*/
	Verzameling<E> symmetrischVerschil(Verzameling<E> obj);

	/** @preconditie	-
		@postconditie	Het aantal elementen in de Verzameling is geretourneerd.
		*/
	int size();

	/** @preconditie	-
		@postconditie	TRUE : obj bevat elementen met dezelfde inhoud als de elementen in het huidige object.<br />
						FALSE: obj bevat niet elementen met dezelfde inhoud als de elementen in het huidige object.
		*/
	boolean equals(Verzameling<E> obj);

	/** @preconditie	-
		@postconditie	Een deep-copy van het huidige object is geretourneerd.
		*/
	Object clone();
}