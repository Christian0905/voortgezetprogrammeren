/**
 * Tabel ADT voor opdracht 2
 * @author	Twan v.d. Loo
 * @author	Jan van der Lugt
 */

/** @elementen	Entry-objecten
	@structuur	Lineair
	@domein		Alle tabellen met Entry-objecten.

	@constructor
	<h3>Tabel()</h3>
	<b>PRE</b><br>
	-<br>
	<b>POST</b><br>
	Er is een nieuw Tabel-object gemaakt. Dit object bevat nog geen elementen.
	*/

public interface TabelInterface extends Cloneable {

	/** De huidige entry.
		*/
	Entry current = null;

	/** De eerste entry.
		*/
	Entry first = null;

	/** De laatste entry.
		*/
	Entry last = null;
	
	/** @preconditie	-
		@postconditie	Het huidige object bevat geen elementen.
		*/
	Tabel init();

    /**	@preconditie	De Tabel is niet leeg.
		@postconditie	De huidige entry is geretourneerd.
    */
    Entry retrieve();

	/** @preconditie	-
		@postconditie	De element e is aanwezig in de Tabel. Als er al een gelijke Entry aanwezig was, is deze overschreven.
		*/
	Tabel insert(Entry e);

	/**	@preconditie	De tabel is niet leeg.
		@postconditie	Het current-element is verwijderd uit de tabel.
			De referentie current-POST wijst
			- als Tabel-POST leeg is: 
				null aan.
			- anders, als current-PRE het laatste Entry van Tabel-PRE aanwees:
				het laatste Entry van Tabel-POST aan.
			- anders: 
				de Entry aan, die in Tabel-PRE na de current-PRE kwam.
			Tabel-POST is geretourneerd.
		*/
	Tabel remove();

	/** @preconditie	-
		@postconditie	Het aantal elementen in de Tabel is geretourneerd.
		*/
	int size();

	/** @preconditie	-
		@postconditie
			TRUE:	Lijst bevat een kopie van e.
					current wijst naar het eerste Entry in lijst waarvoor geldt dat dit een kopie van e is.
			FALSE: Lijst bevat geen kopie van e.
				current wijst naar
					- lijst is leeg:
						null
					- de eerste Entry in lijst > e:
						de eerste knoop
					- anders:
						het laatste Entry in lijst waarvoor geldt < e
    */
	boolean find(Entry e);

	/** @preconditie	-
		@postconditie	Een deep-copy van de huidige Tabel is geretourneerd.
		*/
	Object clone();
}