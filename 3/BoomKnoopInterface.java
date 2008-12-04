/**
 * Binaire zoekboom ADT  voor opdracht 3
 * @author	Twan v.d. Loo
 * @author	Jan van der Lugt
 */
  
/** @elementen	
	@structuur
	@domein
	
	@constructor
	<h3>BoomKnoop(int i, BoomKnoop l, BoomKnoop r)</h3>
	<b>PRE</b><br>
	-<br>
	<b>POST</b><br>
	Er is een nieuw BoomKnoop object gemaakt. De inhoud van het BoomKnoop object is i,l,r.
	
	
	<h3>BoomKnoop(int i)</h3>
	<b>PRE</b><br>
	-<br>
	<b>POST</b><br>
	Er is een nieuw BoomKnoop object gemaakt. De inhoud van het BoomKnoop object is i
	*/
	
public interface BoomKnoop {
	
	/** @preconditie
		@postconditie
		*/
		int aantalKnopen(BoomKnoop w, int x);
	
	/** @preconditie
		@postconditie
		*/
		int diepte(BoomKnoop w);
	
	/** @preconditie
		@postconditie
		*/
		boolean aanwezig(BoomKnoop w, int x);
	
	/** @preconditie
		@postconditie
		*/
		Identifier geefIdentifier();
	
	/** @preconditie
		@postconditie
		*/
		BoomKnoop voegToe(BoomKnoop w, int x);
	
	/** @preconditie
		@postconditie
		*/
		BoomKnoop kopie(BoomKnoop w);
	
	/** @preconditie
		@postconditie
		*/
		BoomKnoop verwijder(BoomKnoop w, int x);
		
	/** @preconditie
		@postconditie
		*/
		BoomKnoop compareTo(BoomKnoop w, int x);
	
	

	
 }