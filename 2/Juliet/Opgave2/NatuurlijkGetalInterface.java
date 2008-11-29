  /**      @elementen        Characters van  het type char
        *        @structuur        Lineair
        *        @domein           Een reeks van cijfers  waarvan de lengte minimaal 1 is.
        *
	*	@constructor
        * 	NatuurlijkGetal ();
        *        @preconditie         
        *        @postconditie         Er is een nieuw NatuurlijkGetal object gemaakt met 1  willekeurig natuurlijk getal.
        *
        */
        
interface NatuurlijkGetalInterface extends Data{

        
        int MIN_AANTAL_CHARS = 1 ;
        
        
        /**
        *        @preconditie        char c  moet een natuurlijk getal zijn.
        *        @postconditie        de lijst met characters bevat nu alleen char c.
         */
        void init(char c);
        

   /**
        *        @preconditie        char c moet een natuurlijk getal zijn.
        *        @postconditie        Pre-Lijst met Characters bevat nu een kopie van char c.
         */
        void voegToe(char c);
        

   /**
        *        @preconditie         Index moet groter of gelijk zijn aan nul  en kleiner of gelijk zijn aan de lengte van het getal
        *        @postconditie        Retourneert de char  dat zich bevindt op de gegeven indexpositie.
         */
        char geefCijfer(int index);
        
         
   /**
        *        @preconditie        
        *        @postconditie        Geeft het aantal chracters terug.
         */
		int lengte();
        
	
	/**
	*	@preconditie	
	*	@postconditie	Er is een kopie van het huidig NatuurlijkGetal object geretourneerd
	*/
		Object clone(); 
		
	/**
	*	@preconditie	
	*	@postconditie	Er wordt een getal van type Integer geretourneerd met als waarde:
	*				-	1 als het huidig object groter is dan het NatuurlijkGetal object comp2
	*				-	0 als het huidig object gelijk  is aan het NatuurlijkGetal object comp2
	*				-	-1 als het huidig object kleiner is dan het NatuurlijkGetal object comp2
	*/
		int compareTo(Object comp2); 
}
