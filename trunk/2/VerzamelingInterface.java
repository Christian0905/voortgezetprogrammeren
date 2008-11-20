/**
 * Verzameling ADT voor opdracht 2
 * @author	Twan v.d. Loo
 * @author	Jan van der Lugt
 */
 
/** @elementen	Elementen van het type Data.
	@structuur	Geen
	@domein		Alle verzamelingen van Data-elementen.

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
	VerzamelingInterface<E> init();

    /**	@preconditie	De verzameling is niet leeg.
		@postconditie	Een willekeurig element uit de verzameling is geretourneerd.
    */
    E retrieve();

	/** @preconditie	-
		@postconditie	Het Data-element d is aanwezig in de verzameling.
		*/
	VerzamelingInterface<E> insert(Data d);

	/**	@preconditie	-
		@postconditie	Het Data-element d is niet aanwezig in de verzameling.
		*/
	VerzamelingInterface<E> remove(Data d);

	/** @preconditie	-
		@postconditie	Het aantal Data-elementen in de Verzameling is geretourneerd.
		*/
	int size();

	/** @preconditie	-
		@postconditie	TRUE : obj bevat Data-elementen met dezelfde inhoud als het huidige object.<br />
						FALSE: obj bevat niet Data-elementen met dezelfde inhoud als het huidige object.
		*/
	boolean equals(NatuurlijkGetal obj);

	/** @preconditie	-
		@postconditie	Een deep-copy van het huidige object is geretourneerd.
		*/
	Object clone();
}