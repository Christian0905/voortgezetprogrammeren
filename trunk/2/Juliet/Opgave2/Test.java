class Test{

	Input in;
	Output out;
	
	Lijst<Identifier> lijst = new Lijst<Identifier>();
	
	Test(){
        in  = new Input();
        out = new Output();
		
	}
	
	void start(){		
		
		Identifier id= new Identifier();
		
		id.init('c');
		lijst.insert(id);
		
		id.init('z');
		lijst.insert(id);	
		
		id.init('d');
		lijst.insert(id);
		
		id.init('c');
		lijst.insert(id);
		
		id= new Identifier();
		lijst.insert(id);
		
		id.init('c');
		lijst.insert(id);	
		
		id= new Identifier();
		id.init('b');
		lijst.insert(id);
		
		id.init('g');
		lijst.insert(id);	

		id.init('c');
		lijst.insert(id);		
		
		Lijst<Identifier> lijst2 = lijst.clone();
		
		if (lijst2.setFirst()){
			do{
				out.println("------->"+((Identifier)lijst2.retrieve()).geefChar(0));
			}while (lijst2.getNext());
		}
		
		out.println("Size : "+lijst2.size());
	}
	
    public static void main(String[] argv){
        new Test().start();
    }
}