/**
 * Identifier ADT voor opdracht 1
 * @author	Twan v.d. Loo
 * @author	Jan van der Lugt
 */
 
/**	@constructor
 *	<h3>IdentifierInterface()</h3>
 *	<b>PRE</b><br>
 *	-<br>
 *	<b>POST</b><br>
 *	Er is een nieuw Identifier object gemaakt. De inhoud van het nieuwe Identifier-object is "a".
 *
 *	<h3>Identifier(Identifier src)</h3>
 *	<b>PRE</b><br>
 *	-<br>
 *	<b>POST</b><br>
 *	Er is een nieuw Identifier object gemaakt. De inhoud van het nieuwe Identifier-object is een kopie van Identifier src.
 */

public interface IdentifierInterface {

	/** @elementen Karakters van het type char
	    @structuur Lineair
	    @domein    Alle rijen van alfanumerieke tekens die beginnen met een letter en minimaal 1 character lang zijn.
	*/

	/** @preconditie  c is een letter.
	    @postconditie De inhoud van het Identifier-object is precies de letter c
	   */
	void init(char c) throws Exception;

	/** @preconditie  is alfanumeriek
	    @postconditie c is achteraan toegevoegd aan de Identifier
	   */
	void append(char c);

	/** @preconditie i >= 0 en i is niet groter dan (het aantal karakters van de Identifier - 1)
	    @postconditie Het karakter op indexpositie i is geretourneerd
	   */
	char charAt(int i);

	/** @preconditie  -
	    @postconditie Het aantal characters van de Identifier is geretourneerd
	    @postconditie Het aantal characters van de Identifier is geretourneerd
	   */
	int length();

	/** @preconditie  -
	    @postconditie TRUE : obj bevat dezelfde karakters als de huidige Identifier
	   	  	 FALSE: obj bevat niet dezelfde karakters als de huidige Identifier
	   */
	boolean equals(Identifier obj);

}