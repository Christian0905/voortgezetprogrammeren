
 class Tabel implements TabelInterface{

	Lijst<Paar> lijst;
	
	public Tabel(){
		lijst = new Lijst<Paar>();
		lijst.init();
	}
	
	public void voegToe(Identifier id, Verzameling<NatuurlijkGetal> v ){
		if (bevat(id)){
			lijst.current.data = new Paar(id,v);
		}
		else lijst.insert(new Paar(id,v));
	}
	
	public Verzameling<NatuurlijkGetal> geefVerzameling( Identifier id ){
		if (lijst.find(new Paar(id,null))){
			return lijst.retrieve().verzameling;
		}
		return null;
	}
	
	public void verwijder(Identifier id ){
		if (lijst.find(new Paar(id,null))){
			lijst.remove();
		}
	}
	
	public boolean bevat(Identifier id){
		return lijst.find(new Paar(id,null));
	}
	
	public Tabel clone(){
	    Tabel kopie;
		    try {
		        kopie = (Tabel)super.clone();
		    } catch (CloneNotSupportedException e) {
		        throw new Error("Onmogelijk! instantie Verzameling is niet Cloneable");
		    }

	        kopie.lijst = lijst == null ? null : lijst.clone();

		    return kopie;		
	}
	
	
	
}
