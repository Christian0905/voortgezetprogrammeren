  /**      @elementen        Paar objecten bestaande uit een koppeling tussen Identifier object identifier en Verzameling object verzamelingen
        *        @structuur        Geen
        *        @domein          een lijst van paren bestaande uit een unieke identifier en een verzameling
        *
        * 	@constructor
	*	Tabel();
        *        @preconditie         
        *        @postconditie         Er is een nieuw leeg Tabel object gemaakt
        *
        */
		
	interface TabelInterface extends Cloneable {
	
	/**
	*	@preconditie	Identifier en Verzameling mogen niet null zijn
	*	@postconditie	Pre-lijst bevat nu een 
	*/
		void voegToe(Identifier id, Verzameling<NatuurlijkGetal> v );
	
	/**
	*	@preconditie	Identifier id mag niet null zijn
	*	@postconditie 	Pre-lijst bevat nu geen paar meer met Identifier id
	*/
		void verwijder(Identifier id );
		
	/**
	*	@preconditie	Identifier id mag niet null zijn
	*	@postconditie	Gegeven een geldige Identifier  wordt zijn verzameling geretourneerd
	*/
		Verzameling<NatuurlijkGetal> geefVerzameling( Identifier id );
		
	/**
	*	@preconditie	Identifier id mag niet null zijn
	*	@postconditie	Retourneert true als er een paar bestaat met als Identifier id en anders false
	*/
		boolean bevat(Identifier id);
		
	/**
	*	@preconditie	
	*	@postconditie	Een kopie van het huidig Tabel object wordt geretourneerd
	*/
		Tabel clone();
	
	
	}
