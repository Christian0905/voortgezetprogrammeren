
   /**    	 @elementen        Characters van  het type char
        *        	@structuur        Lineair
        *        	@domein           Een reeks van alfanumerieke characters van onbepaalde lengte die met een letter moeten beginnen en
        *                          minimaal 1 in lengte moet zijn.
        *
        * 	@constructor
	*	Identifier ();
        *        	@preconditie         
        *        	@postconditie         Er is een nieuw Identifier object gemaakt met 1  willekeurige letter.
        *
        * 
        */
        
interface IdentifierInterface extends Data{

        
        int MIN_AANTAL_CHARS = 1 ;
        
        
        /**
        *        @preconditie        char c  moet een letter zijn.
        *        @postconditie        de lijst met characters bevat nu alleen char c.
         */
        void init(char c);
        

        /**
        *        @preconditie        char c moet alfanumeriek zijn.
        *        @postconditie        Pre-Lijst met Characters bevat nu een kopie van char c.
         */
        void voegToe(char c);
        

        /**
        *        @preconditie         Index moet groter of gelijk zijn aan nul  en kleiner of gelijk zijn aan de lengte van de Identifier.
        *        @postconditie        Retourneert het char  dat zich bevindt op de gegeven index.
         */
        char geefChar(int index);
         
   /**
        *        @preconditie        
        *        @postconditie        Geeft het aantal chracters terug.
         */
         int lengte();
		 
	/**
	*	@preconditie	
	*	@postconditie	Er wordt een getal van type Integer geretourneerd met als waarde:
	*				-	1 als het huidig object groter is dan het Identifier object comp2
	*				-	0 als het huidig object gelijk  is aan het Identifier object comp2
	*				-	-1 als het huidig object kleiner is dan het Identifier object comp2
	*/
		int compareTo(Object comp2);

	/**
	*	@preconditie	
	*	@postconditie	Er is een kopie van het huidig Identifier object geretourneerd
	*/
		Object clone(); 
		

		
}
