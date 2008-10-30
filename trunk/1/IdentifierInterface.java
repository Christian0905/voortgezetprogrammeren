/**
 * Identifier-ADT voor opdracht 1 van het vak Datastructuren aan de VU.
 * @author	Vijay Koelfat
 * @author	Jan van der Lugt
 */

/**	@constructor
 *	<h3>Identifier()</h3>
 *	<b>preconditie</b><br>
 *	-<br>
 *	<b>postconditie</b><br>
 *	Er is een nieuw Identifier-object gemaakt met een ongedefinieerde waarde.
 *
 *	<h3>Identifier(Identifier source)</h3>
 *	<b>preconditie</b><br>
 *	-<br>
 *	<b>postconditie</b><br>
 *	Er wordt een nieuw Identifier-object gemaakt met als waarde een kopie van source.
 */

public interface IdentifierInterface {
	/**	@elementen	Karakters van het type char.
	 *	@structuur	Lineair.
	 *	@domein		Alle rijtjes alfanumerieke karakters beginnend met een letter.
	 */

	/**	@preconditie	c is een letter.
	 *	@postconditie	De Identifier heeft lengte 1 met als eerste en enige character c.
	 */
	void init(char c);

	/**	@preconditie	c is alfanumeriek.
	 *	@postconditie	c is achteraan toegevoegd aan Identifier-PRE.
	 */
	void append(char c);

	/**	@preconditie	index is groter of gelijk aan 0 en kleiner dan het aantal karakters in de Identifier.
	 *	@postconditie	Het karakter op positie index is geretourneerd.
	 */
	char charAt(int index);

	/**	@preconditie	-
	 *	@postconditie	Het aantal karakters in de Identifier is geretourneerd.
	 */
	int length();

	/**	@preconditie	-
	 *	@postconditie	Een string-representatie van de Identifier is geretourneerd.
	 */
	String toString();

	/**	@preconditie	-
	 *	@postconditie	TRUE: obj bevat dezelfde karakters als de huidige Identifier.<br>
	 *					FALSE: obj bevat niet dezelfde karakters als de huidige Identifier.
	 */
	boolean equals(Identifier obj);
}