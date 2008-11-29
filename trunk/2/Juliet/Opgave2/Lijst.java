class Lijst<E extends Data> implements LijstInterface<E>{
	
	Knoop current;
	Knoop first;
	Knoop last;
	int aantalKnopen;
	
	Lijst(){
		init();
	}
	
	public boolean isEmpty(){
		return (first==null || size()==0);
	}

	public Lijst<E> init (){
		current=null;
		first = null;
		last = null;
		aantalKnopen=0;
		return this;
	}
	
	public int size(){
		return aantalKnopen;
	}
	
	public Lijst<E> insert (E d){
	
		E d2 = (E)d.clone();
	
		if (isEmpty()) {
			first = new Knoop(d2,null,null);
			last = first;
			current = last;			
		}
		else
		{
			if (((E)d2).compareTo(((E)first.data))<=0 ){
				current = new Knoop(d2,null,first);
				first.prior = current;
				first = current;
			}
			else
			if (((E)d2).compareTo(((E)last.data))>=0 ){
				current = new Knoop(d2,last,null);
				last.next = current;
				last = current;
			}
			else
			{
				if (setFirst()){
					do{			
						if ((((E)d2).compareTo(((E)current.data))>=0) && (((E)d2).compareTo(((E)current.next.data))<0) ){
							current = new Knoop(d2,current,current.next);
							current.prior.next = current;
							current.next.prior = current;		
							aantalKnopen++;
							return this;
						}
					}while(getNext());
				}
			}
		}
		aantalKnopen++;
		return this;
	 }
	 
	public E retrieve(){
		return ((E)current.data.clone());
	 }
	 
	public Lijst<E> remove(){
		if (isEmpty()){
			current = null;
		}
		else
		if (current == last ){
			current = current.prior;
			if (current!=null){
				current.next = null;
			}
			last = current;
			aantalKnopen--;
		}
		else
		if (current == first ){
			current = current.next;
			current.prior = null;
			first = current;
			aantalKnopen--;
		}
		else
		{
			current.next.prior = current.prior;
			current.prior.next = current.next;	
			aantalKnopen--;
		}	
		return this;
	 }
	 
	public boolean find(E d){
		if (isEmpty()){
			current=null;
			return false;
		}
		else
		{
			setFirst();
			do{
				if ((current.data).compareTo(d)==0 ) {
					return true;
				}
			}
			while(getNext());
		}
		return false;
	 }
	 
	public boolean setFirst(){
		if (isEmpty())
		{
			return false;
		}
		else
		{
			current = first;
			return true;
		}
	 }
	 
	public boolean setLast(){
		if (isEmpty())
		{
			return false;
		}
		else
		{
			current = last;
			return true;
		}	 
	 }
	 
	public boolean getNext(){
		if (isEmpty() || current==last)
		{
			return false;
		}
		else
		{
			current = current.next;
			return true;
		}
	 }
	 
	public boolean getPrior(){
		if (isEmpty() || current==first)
		{
			return false;
		}
		else
		{
			current = current.prior;
			return true;
		}		
	 }
	 
	public Lijst<E> clone(){
		Lijst<E> kopie;
		try {
		    kopie = (Lijst<E>) super.clone();
			kopie.init();
		} catch (CloneNotSupportedException e) {
		    throw new Error("Onmogelijk! instantie Verzameling is niet Cloneable");
		}
		
		if (setFirst()){
			do{
				kopie.insert(((E)current.data));
			}while(getNext());
		}
		
		return kopie;
		
	 }
	 
	 

}
