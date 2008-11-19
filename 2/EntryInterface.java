/**
 * Entry ADT voor opdracht 2
 * @author	Twan v.d. Loo
 * @author	Jan van der Lugt
 */
 
/** @elementen	Een Identifier-object en een Verzameling-object
	@structuur	Geen
	@domein		Alle sets van een Identifier en een Verzameling.

	@constructor
	<h3>Entry(Identifier identifier)</h3>
	<b>PRE</b><br>
	-<br>
	<b>POST</b><br>
	Er is een nieuw Entry-object gemaakt. Dit Entry-object bevat de Identifier identifier en een lege verzameling.
	*/

public interface EntryInterface extends Data {

	/** @preconditie	-
		@postconditie	De inhoud van huidige object is de Identifier identifier en een lege verzameling.
		*/
	void init(Identifier identifier);

	/** @preconditie	-
		@postconditie	TRUE : De inhoud van het huidige Identifier-object is gelijk aan de inhoud van het Identifier-object in obj<br />
						FALSE: De inhoud van het huidige Identifier-object is ongelijk aan de inhoud van het Identifier-object in obj
		*/
	boolean equals(Entry obj);

	/** @preconditie	-
		@postconditie	Als het de inhoud van this lexicografisch voor de inhoud van obj wordt gesorteerd: een negatief getal is geretourneerd.<br />
						Als het de inhoud van this gelijk is aan de inhoud van obj: het getal 0 is geretourneerd.<br />
						Als het de inhoud van this lexicografisch na de inhoud van obj wordt gesorteerd: een positief getal is geretourneerd.
		*/
	int compareTo(Object obj);

	/** @preconditie	-
		@postconditie	Een deep-copy van het huidige object is geretourneerd.
		*/
	Object clone();
}