/**
 * IdentifierVerzamling-ADT voor opdracht 1
 * @author	  Twan v.d. Loo
 * @author	  Jan van der Lugt
 */

/** @elementen	Identifiers van het type Identifier
	@structuur	Geen
	@domein		Alle mogelijke verzamelingen van minimaal 0 en maximaal 20 Identifiers

	@constructor
	<h3>IdentifierVerzameling();</h3>
	<b>PRE</b><br>
	-<br>
	<b>POST</b><br>
	Er is een leeg IdentifierVerzameling object gemaakt.

	<h3>IdentifierVerzameling(IdentifierVerzameling src);</h3>
	<b>PRE</b><br>
	-<br>
	<b>POST</b><br>
	Er is een nieuw IdentifierVerzameling-object gemaakt.<br>
	De inhoud van dit nieuwe object is een kopie van de inhoud van src.
	*/

public interface IdentifierVerzamelingInterface {

	/** @preconditie -
		@postconditie De IdentifierVerzameling is leeg
		*/
	void init();

	/** @preconditie  -
		@postconditie Een kopie van element zit in de verzameling
									  FAILURE er zijn meer dan 20 elementen
		*/
	void voegToe(Identifier element) throws Exception;

	/** @preconditie  -
		@postconditie Element zit niet in IdentifierVerzameling
		*/
	void verwijder(Identifier element);

	/** @preconditie  De IdentifierVerzameling is niet leeg
		@postconditie Een kopie van een willekeurig element uit IdentifierVerzameling is geretourneerd
		*/
	Identifier geefIdentifier();

	/** @preconditie  -
		@postconditie TRUE : Een kopie van element is reeds aanwezig in de IdentifierVerzameling
					 FALSE: Een kopie van element is niet aanwezig in de IdentifierVerzameling
		*/
	boolean isAanwezig(Identifier element);

	/** @preconditie  -
		@postconditie TRUE : Het aantal elementen in de IdentifierVerzameling is 0
					 FALSE: Het aantal elementen in de IdentifierVerzameling is groter dan 0
		*/
	boolean isLeeg();

	/** @preconditie  -
		@postconditie Het aantal elementen van IdentifierVerzameling is geretourneerd
		*/
	int aantalIdentifiers();

	/** @preconditie  -
		@postconditie Een nieuwe IdentifierVerzameling is geretourneerd met als inhoud een kopie van de Identifier elementen die
		wel in de huidige IdentifierVerzameling zitten maar niet in input
		*/
	IdentifierVerzameling verschil(IdentifierVerzameling input);

	/** @preconditie  -
		@postconditie Een nieuwe IdentifierVerzameling is geretourneerd met als inhoud een kopie van de Identifier elementen die
		zowel in de huidige IdentifierVerzameling zitten als in input
		*/
	IdentifierVerzameling doorsnede(IdentifierVerzameling input);

	/** @preconditie  -
		@postconditie SUCCES: Een nieuwe IdentifierVerzameling is geretourneerd met als inhoud kopieen van alle Identifier elementen die
		in de huidige IdentifierVerzameling zitten en in input (dubbele worden slechts een maal in de verzameling toegevoegd)
					 FAILURE: De nieuwe IdentifierVerzameling heeft meer dan 20 elementen
		*/
	IdentifierVerzameling vereniging(IdentifierVerzameling input) throws Exception;

	/** @preconditie  -
		@postconditie SUCCES: Een nieuwe IdentifierVerzameling is geretourneerd met als inhoud kopieen van alle Identifier elementen die
		in de huidige IdentifierVerzameling zitten en in input maar niet in de doorsnede
					 FAILURE: De nieuwe IdentifierVerzameling heeft meer dan 20 elementen
		*/
	IdentifierVerzameling symmetrischVerschil(IdentifierVerzameling input) throws Exception;
}
