class Verzameling<E  extends Data> implements VerzamelingInterface<E>{

        public Lijst<E> lijst;

       Verzameling(){
            lijst = new Lijst<E>();
       }

       public void init(){
			lijst.init();
			lijst.setFirst();	
       }

       public void voegToe( E element ){
			lijst.insert(element);
       }

       public E geefElement(){
			lijst.setFirst();
            return lijst.retrieve();
       }

       public void verwijderElement(E element ){
			if (lijst.find(element))
			{
				lijst.remove();
			}
       }

       public  boolean bevatElement(E element){
               return lijst.find(element);
       }

       public Verzameling<E> verschil( Verzameling<E> tweedeVerzameling ){
				Verzameling<E> resultaat = this.clone();
				if (lijst.setFirst()){
					do{
						if (tweedeVerzameling.bevatElement(lijst.retrieve()) )
						{
							resultaat.verwijderElement(lijst.retrieve());
						}
					}
					while (lijst.getNext());
				}
				return resultaat;
       }

       public Verzameling<E> doorsnede( Verzameling<E> tweedeVerzameling ){
				Verzameling<E> resultaat = this.clone();
				if ( lijst.setFirst() ){
					do{
						if ( !tweedeVerzameling.bevatElement(lijst.retrieve()) ) 
						{
							resultaat.verwijderElement(lijst.retrieve());
						}
					}
					while (lijst.getNext());
				}
				return resultaat;
       }

       public Verzameling<E> vereniging( Verzameling<E> tweedeVerzameling ){
				Verzameling<E> resultaat = tweedeVerzameling.clone();
				if ( lijst.setFirst() ){
					do{
						if ( !resultaat.bevatElement(lijst.retrieve()) ) 
						{
							resultaat.voegToe(lijst.retrieve());
						}
					}
					while (lijst.getNext());
				}
				return resultaat;
       }

       public Verzameling<E> symVerschil( Verzameling<E> tweedeVerzameling ){
				Verzameling<E> resultaat = tweedeVerzameling.clone();
				if ( lijst.setFirst() ){
					do{
						if ( resultaat.bevatElement(lijst.retrieve()) ) 
						{
							resultaat.verwijderElement(lijst.retrieve());
						}
						else
						{
							resultaat.voegToe(lijst.retrieve());
						}
					}
					while (lijst.getNext());
				}
				return resultaat;
       }
	   
	   public int lengte(){
			return lijst.size();
	   }
	   
	   public Verzameling<E> clone(){
	    Verzameling<E> kopie;
		    try {
		        kopie = (Verzameling<E>) super.clone();
		    } catch (CloneNotSupportedException e) {
		        throw new Error("Onmogelijk! instantie Verzameling is niet Cloneable");
		    }

	        kopie.lijst = lijst == null ? null : lijst.clone();

		    return kopie;
	   }
}

