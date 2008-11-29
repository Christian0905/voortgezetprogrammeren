  /**      @elementen        Identifiers van het type Identifier
        *        @structuur        Geen
        *        @domein           Verschillende Natuurlijke getallen  
        *        
        *        @constructor
        *        Verzameling(); 
        *        	@preconditie         
        *        	@postconditie                 Er is een leeg verzameling object aangemaakt.             
        */
        
interface VerzamelingInterface<E extends Data> extends Cloneable{
       
        
   /**
        *        @preconditie         
        *        @postconditie         De verzameling is leeggemaakt.        
        */        
        void init();

   /**
        *        @preconditie                
        *        @postconditie      Een kopie van element zit in de pre-verzameling.
        */        
        void voegToe(E element);

  /**
        *        @preconditie         
        *        @postconditie                 
        *                Er is een verzameling object geretourneerd met het verschil in elementen tussen 
        *                het huidige verzameling object en het tweedeVerzameling object.
        */        
        Verzameling<E> verschil( Verzameling<E> tweedeVerzameling );

        /**
        *        @preconditie         
        *        @postconditie                 
        *                Er is een verzameling object geretourneerd met de gemeenschappelijke elementen 
        *                van het huidige verzameling object en het tweedeVerzameling object.
        */        
        Verzameling<E> doorsnede( Verzameling<E> tweedeVerzameling );

        /**
        *        @preconditie         
        *        @postconditie                 
        *                Er is een verzameling object geretourneerd met de vereniging van elementen
        *                van het huidige verzameling object en het tweedeVerzameling object.
        */        
        Verzameling<E> vereniging( Verzameling<E> tweedeVerzameling );

        /**
        *        @preconditie         
        *        @postconditie                 
        *                Er is een verzameling object geretourneerd met het symmetrisch verschil van elementen
        *                van het huidige verzameling object en het tweedeVerzameling object.
        */        
        Verzameling<E> symVerschil( Verzameling<E> tweedeVerzameling );

        /**
        *        @ preconditie
        *        @postconditie        Er is een willekeurig element van de verzameling geretourneerd.                
        */                
        E geefElement();

        /**
        *        @ preconditie
        *        @postconditie        Het gegeven element zit niet in de verzameling                        
        */        
        void verwijderElement(E element );

        /**
        *        @ preconditie
        *        @postconditie        Retourneert true als de verzameling het element bevat en false als dat niet
        *                             zo is.                                
        */        
        boolean bevatElement(E element);
	
	/**
	*	@preconditie:
	*	@postconditie: Er wordt een kopie van het huidig Verzameling object geretourneerd
	**/
		Verzameling<E> clone();

}

