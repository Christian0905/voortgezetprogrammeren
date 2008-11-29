class Paar implements Data{

	Identifier identifier;
	Verzameling<NatuurlijkGetal> verzameling;
	
	public Paar(Identifier id, Verzameling<NatuurlijkGetal> verz){
		identifier = ((Identifier)id.clone());
		if ((verz) != null)
		{
			verzameling = verz.clone();
		}
	}
	
	public Object clone(){
		Paar kopie;
		try{ 
			kopie = (Paar)super.clone();
		}
		catch(CloneNotSupportedException e){
			throw new Error("Het NatuurlijkGetal object kan niet gekopieerd worden");
		}
			
		kopie.identifier = ((Identifier)identifier.clone());
		kopie.verzameling = verzameling.clone();
			
		return kopie;
	}
		

	public int compareTo(Object comp2){
			return identifier.compareTo(((Paar)comp2).identifier);	
	}
}
