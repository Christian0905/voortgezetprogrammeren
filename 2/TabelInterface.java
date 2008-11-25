/**
 * Tabel ADT voor opdracht 2
 * @author	Twan v.d. Loo
 * @author	Jan van der Lugt
 */

/** @elementen	Paren van Identifier- en Verzameling<NatuurlijkGetal>-objecten
	@structuur	Geen
	@domein		Alle mogelijke combinaties van Identifiers en NatuurlijkGetal-verzamelingen met unieke Identifiers.

	@constructor
	<h3>Tabel()</h3>
	<b>PRE</b><br>
	-<br>
	<b>POST</b><br>
	Er is een nieuw Tabel-object gemaakt. Dit object bevat geen elementen.
	*/

public interface TabelInterface extends Cloneable {
	
	/** @preconditie	-
		@postconditie	Het huidige object bevat geen elementen.
		*/
	Tabel init();

    /**	@preconditie	-
		@postconditie	SUCCES: een kopie van de Verzameling die hoort bij Identifier i is geretourneerd.
						FAILURE: i is niet aanwezig.
    */
    Verzameling<NatuurlijkGetal> retrieve(Identifier i) throws VPException;

	/** @preconditie	-
		@postconditie	Een paar van i en v is toegevoeggd. Als i al bestond in Tabel-PRE, is de verzameling overschreven met v.
		*/
	Tabel insert(Identifer i, Verzameling<NatuurlijkGetal> v);

	/** @preconditie	-
		@postconditie	Het aantal elementen in de Tabel is geretourneerd.
		*/
	int size();

	/** @preconditie	-
		@postconditie	Een deep-copy van de huidige Tabel is geretourneerd.
		*/
	Object clone();
}