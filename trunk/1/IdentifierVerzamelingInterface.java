/**
 * IdentifierVerzamling-ADT voor opdracht 1
 * @author	Jan van der Lugt
 * @author	Twan v.d. Loo
 */
 
/**	@constructor
 *	<h3>IdentifierVerzameling();</h3>
 *	<b>PRE</b><br>
 *	-<br>
 *	<b>POST</b><br>
 *	Er wordt een leeg IdentifierVerzameling object gemaakt.
 *
 *	<h3>IdentifierVerzameling(IdentifierVerzameling src);</h3>
 *	<b>PRE</b><br>
 *	-<br>
 *	<b>POST</b><br>
 *	Er wordt een nieuw IdentifierVerzameling-object gemaakt.<br>
 *	De inhoud van dit nieuwe object is een kopie van de inhoud van src.
 */

public interface IdentifierVerzamelingInterface {

	/** @elementen Verzamelingen met Identifiers van het type IdentifierVerzameling
	    @Structuur Geen
	    @Domein    Verzamelingen van minimaal 0 en maximaal 20 Identifiers
	    */

	/** @preconditie -
	    @postconditie De IdentifierVerzameling is leeg
	    */
	void init();
	
	/** @preconditie  -
	    @postconditie Een kopie van Identifier element is toegevoegd aan de verzameling, indien deze nog niet aanwezig was.
	    */
	void voegToe(Identifier element) throws Exception;
	
	/** @preconditie  -
	    @postconditie Identifier element is verwijdert uit de verzameling
	    */
	void verwijder(Identifier element);
	
	/** @preconditie  - De IdentifierVerzameling is niet leeg
	    @postconditie Een kopie van een element uit IdentifierVerzameling wordt geretourneerd
	    */
	Identifier geefIdentifier();
	
	/** @preconditie  - 
	    @postconditie TRUE : element is reeds aanwezig in de IdentifierVerzameling
	   	  	 FALSE: element is nog niet aanwezig in de IdentifierVerzameling
	    */
	boolean isAanwezig(Identifier element);
	
	/** @preconditie  -
	    @postconditie TRUE : Het aantal elementen in de IdentifierVerzameling is 0
	          	 FALSE: Het aantal elementen in de IdentifierVerzameling is groter dan 0
	    */
	boolean isLeeg();
	
	/** @preconditie  -
	    @postconditie Een string representatie van IdentifierVerzameling wordt geretourneerd
	    */
	String toString();
	
	/** @preconditie  -
	    @postconditie Het aantal elementen van IdentifierVerzameling wordt geretourneerd
	    */
	int aantalElementen();
	
	/** @preconditie  -
	    @postconditie Een nieuwe IdentifierVerzameling is geretourneerd met als inhoud de Identifier elementen die
	    wel in de huidige IdentifierVerzameling zitten maar niet in input
	    */
	IdentifierVerzameling verschil(IdentifierVerzameling input);
	
	/** @preconditie  -
	    @postconditie Een nieuwe IdentifierVerzameling is geretourneerd met als inhoud de Identifier elementen die
	    zowel in de huidige IdentifierVerzameling zitten als in input
	    */
	IdentifierVerzameling doorsnede(IdentifierVerzameling input);
	
	/** @preconditie  -
	    @postconditie SUCCES : Een nieuwe IdentifierVerzameling is geretourneerd met als inhoud alle Identifier elementen die
	    in de huidige IdentifierVerzameling zitten en in input (dubbele worden slechts een maal in de verzameling toegevoegd?)
	   	  	 FAILURE: De nieuwe IdentifierVerzameling heeft meer dan 20 elementen
	    */
	IdentifierVerzameling vereniging(IdentifierVerzameling input) throws Exception;
	
	/** @preconditie  -
	    @postconditie SUCCES : Een nieuwe IdentifierVerzameling is geretourneerd met als inhoud alle Identifier elementen die
	    in de huidige IdentifierVerzameling zitten en in input maar niet in de doorsnede
			 FAILURE: De nieuwe IdentifierVerzameling heeft meer dan 20 elementen
	    */
	IdentifierVerzameling symmetrischVerschil(IdentifierVerzameling input) throws Exception;
	
}