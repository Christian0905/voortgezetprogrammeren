/**
 * NatuurlijkGetal ADT voor opdracht 2
 * @author	Twan v.d. Loo
 * @author	Jan van der Lugt
 */
 
/** @elementen	Cijfers van het type int
	@structuur	Lineair
	@domein		Alle natuurlijke getallen

	@constructor
	<h3>Identifier()</h3>
	<b>PRE</b><br>
	-<br>
	<b>POST</b><br>
	Er is een nieuw Identifier object gemaakt. De inhoud van het nieuwe Identifier-object is "0".
	*/

public interface NatuurlijkGetalInterface extends Comparable, Clonable {

	/** @preconditie	c is een cijfer.
		@postconditie	De inhoud van het NatuurlijkGetal-object is precies het cijfer c.
		*/
	void init(char c);

	/** @preconditie	-
		@postconditie	Het cijfer c is achteraan toegevoegd aan de Identifier.
		*/
	void append(char c);

	/** @preconditie	i is groter dan of gelijk aan 0 en kleiner dan het aantal cijfers van het NatuurlijkGetal.
		@postconditie	Het karakter op indexpositie i is geretourneerd.
		*/
	char charAt(int i);

	/** @preconditie	-
		@postconditie	Het aantal characters van de Identifier is geretourneerd.
		*/
	int length();

	/** @preconditie	-
		@postconditie	TRUE : obj bevat hetzelfde getal als het huidige NatuurlijkGetal<br />
						FALSE: obj bevat niet hetzelfde getal als het huidige NatuurlijkGetal
		*/
	boolean equals(NatuurlijkGetal obj);

	/** @preconditie	-
		@postconditie	Als de inhoud van this < de inhoud van obj: een negatief getal is geretourneerd.<br />
						Als de inhoud van this = de inhoud van obj: het getal 0 is geretourneerd.<br />
						Als de inhoud van this > de inhoud van obj: een positief getal is geretourneerd.
		*/
	int compareTo(NatuurlijkGetal obj);

	/** @preconditie	-
		@postconditie	Een deep-copy van het huidige object is geretourneerd.
		*/
	Identifier clone();
}