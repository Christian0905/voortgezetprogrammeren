/**
 * NatuurlijkGetal ADT voor opdracht 2
 * @author	Twan v.d. Loo
 * @author	Jan van der Lugt
 */
 
/** @elementen	Cijfers van het type char
	@structuur	Lineair
	@domein		Alle rijen van cijfers waarbij de rijen niet met 0 beginnen, tenzij 0 het enige cijfer in de rij is.

	@constructor
	<h3>NatuurlijkGetal()</h3>
	<b>PRE</b><br>
	-<br>
	<b>POST</b><br>
	Er is een nieuw NatuurlijkGetal object gemaakt. De inhoud van het nieuwe NatuurlijkGetal-object is "0".
	*/

public interface NatuurlijkGetalInterface extends Data {

	/** @preconditie	-
		@postconditie	De inhoud van het huidige object is 0.
		*/
	void init();

	/** @preconditie	-
		@postconditie	Als de inhoud-PRE 0 is, is de inhoud-POST het cijfer c, tenzij c 0 is, dan is inhoud-POST 0. In andere gevallen is cijfer c achteraan inhoud-PRE toegevoegd.
		*/
	void append(char c);

	/** @preconditie	i is groter dan of gelijk aan 0 en kleiner dan het aantal cijfers van het NatuurlijkGetal.
		@postconditie	Het karakter op indexpositie i is geretourneerd.
		*/
	char charAt(int i);

	/** @preconditie	-
		@postconditie	Het aantal characters van de NatuurlijkGetal is geretourneerd.
		*/
	int length();

	/** @preconditie	-
		@postconditie	TRUE : obj bevat hetzelfde getal als het huidige NatuurlijkGetal<br />
						FALSE: obj bevat niet hetzelfde getal als het huidige NatuurlijkGetal
		*/
	boolean equals(NatuurlijkGetal obj);

	/** @preconditie	-
		@postconditie	Als de inhoud van this numeriek voor de inhoud van obj wordt gesorteerd: een negatief getal is geretourneerd.<br />
						Als de inhoud van this gelijk is aan de inhoud van obj: het getal 0 is geretourneerd.<br />
						Als de inhoud van this numeriek na de inhoud van obj wordt gesorteerd: een positief getal is geretourneerd.
		*/
	int compareTo(Object obj);

	/** @preconditie	-
		@postconditie	Een deep-copy van het huidige object is geretourneerd.
		*/
	Object clone();
}