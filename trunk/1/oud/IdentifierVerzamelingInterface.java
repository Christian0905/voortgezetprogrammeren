/**
 * IdentifierVerzameling-ADT voor opdracht 1 van het vak Datastructuren aan de VU.
 * @author	Vijay Koelfat
 * @author	Jan van der Lugt
 */

/**	@constructor
 *	<h3>IdentifierVerzameling()</h3>
 *	<b>preconditie</b><br>
 *	-<br>
 *	<b>postconditie</b><br>
 *	Er wordt een nieuw IdentifierVerzameling-object gemaakt zonder elementen erin.
 *
 *  <h3>IdentifierVerzameling(IdentifierVerzameling source)</h3>
 *	<b>preconditie</b><br>
 *	-<br>
 *	<b>postconditie</b><br>
 *	Er wordt een nieuw IdentifierVerzameling-object gemaakt met als inhoud kopieen van de elementen uit source.
 */

public interface IdentifierVerzamelingInterface {
	/**	@elementen	Objecten van het type Identifier.
	 *	@structuur	Geen structuur.
	 *	@domein		Alle verzamelingen van Identifiers met minimaal 0 en en maximaal 20 elementen.
	 */

	/**	@preconditie	-
	 *	@postconditie	De IdentifierVerzameling bevat geen elementen.
	 */
	void init();

	/**	@preconditie	-
	 *	@postconditie	SUCCESS: een kopie van het element is toegevoegd aan de IdentifierVerzameling indien nog niet aanwezig.<br>
	 *                  FAILURE: het aantal elementen in de verzameling is gelijk aan 20
	 */
	void voegToe(Identifier element) throws Exception;

	/**	@preconditie	-
	 *	@postconditie	element zit niet in de IdentifierVerzameling.
	 */
	void verwijder(Identifier element);

	/**	@preconditie	-
	 *	@postconditie	TRUE: element is reeds aanwezig in de IdentifierVerzameling.<br>
	 *					FALSE: element is nog niet aanwezig in de IdentifierVerzameling.
	 */
	boolean isAanwezig(Identifier element);

	/**	@preconditie	De Identifierverzameling is niet leeg.
	 *	@postconditie	Een kopie van een willekeurig element uit de IdentifierVerzameling is geretourneerd.
	 */
	Identifier geefIdentifier();

	/**	@preconditie	-
	 *	@postconditie	TRUE: het aantal elementen in de IdentifierVerzameling is gelijk aan 0.<br>
	 *					FALSE: het aantal elementen in de IdentifierVerzameling is groter dan 0.
	 */
	boolean isEmpty();

	/**	@preconditie	-
	 *	@postconditie	Een string-representatie van de IdentifierVerzameling is geretourneerd.
	 */
	String toString();

	/**	@preconditie	-
	 *	@postconditie	Het aantal elementen in de IdentifierVerzameling is geretourneerd.
	 */
	int size();

	/**	@preconditie	-
	 *	@postconditie	Een nieuwe IdentifierVerzameling is geretourneerd met als elementen de Identifiers die wel in de huidige IdentifierVerzameling zitten, maar niet in teVergelijken.
	 */
	IdentifierVerzameling verschil(IdentifierVerzameling teVergelijken);

	/**	@preconditie	-
	 *	@postconditie	Een nieuwe IdentifierVerzameling is geretourneerd met als elementen de Identifiers die in zowel de huidige IdentifierVerzameling zitten als in teVergelijken.
	 */
	IdentifierVerzameling doorsnede(IdentifierVerzameling teVergelijken);

	/**	@preconditie	-
	 *	@postconditie	Een nieuwe IdentifierVerzameling is geretourneerd met als elementen de Identifiers die in de huidige IdentifierVerzameling zitten, of in teVergelijken, of in beide.<br>
	 *					FAILURE: De aantal elementen van de vereniging van de verzamelingen werd te groot.
	 */
	IdentifierVerzameling vereniging(IdentifierVerzameling teVergelijken) throws Exception;

	/**	@preconditie	-
	 *	@postconditie	SUCCESS: Een nieuwe IdentifierVerzameling is geretourneerd met als elementen de Identifiers die in de huidige IdentifierVerzameling of in teVergelijken zitten, maar niet in beide.<br>
	 *					FAILURE: De aantal elementen van de vereniging van de verzamelingen werd te groot.
	 */
	IdentifierVerzameling symmetrischVerschil(IdentifierVerzameling teVergelijken) throws Exception;
}