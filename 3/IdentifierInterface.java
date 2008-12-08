/**
 * Identifier ADT voor opdracht 3
 * @author	Twan v.d. Loo
 * @author	Jan van der Lugt
 */

 /** @elementen	Karakters van het type char
	 @structuur	Lineair
	 @domein	Alle rijen van karakters bestaande uit letters en cijfers, beginnend met een letter.

	 @constructor
	 <h3>Identifier()</h3>
	 <b>PRE</b><br>
	 -<br>
	 <b>POST</b><br>
	Er is een nieuw Identifier object gemaakt. De inhoud van het nieuwe Identifier-object is "a".
	*/

public interface IdentifierInterface extends Data {

	/** @preconditie	c is een letter.
		@postconditie	De inhoud van het Identifier-object is precies de letter c en het huidige object is geretourneerd.
		*/
	Identifier init(char c);

	/** @preconditie	-
		@postconditie	c is achteraan toegevoegd aan de Identifier en het huidige object is geretourneerd.
		*/
	Identifier append(char c);

	/** @preconditie	i is groter dan of gelijk aan 0 en kleiner dan het aantal karakters van de Identifier
		@postconditie	Het karakter op indexpositie i is geretourneerd
		*/
	char charAt(int i);

	/** @preconditie	-
		@postconditie	Het aantal characters van de Identifier is geretourneerd
		*/
	int length();

	/** @preconditie	-
		@postconditie	TRUE : obj bevat dezelfde karakters als de huidige Identifier<br />
						FALSE: obj bevat niet dezelfde karakters als de huidige Identifier
		*/
	boolean equals(Identifier rhs);

	/** @preconditie	obj heeft het type Identifier
		@postconditie	Als het de inhoud van this lexicografisch voor de inhoud van obj wordt gesorteerd: een negatief getal is geretourneerd.<br />
						Als het de inhoud van this gelijk is aan de inhoud van obj: het getal 0 is geretourneerd.<br />
						Als het de inhoud van this lexicografisch na de inhoud van obj wordt gesorteerd: een positief getal is geretourneerd.
		*/
	int compareTo(Data rhs);

	/** @preconditie	-
		@postconditie	Een deep-copy van het huidige object is geretourneerd.
		*/
	Identifier clone();
}
