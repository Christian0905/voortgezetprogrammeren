class TestVerzameling{

	Input in;
	Output out;
	
	Verzameling<Identifier> verz1 = new Verzameling<Identifier>();
	Verzameling<Identifier> verz2 = new Verzameling<Identifier>();
	
	TestVerzameling(){
        in  = new Input();
        out = new Output();
		
	}
	
	void start(){		
		out.println("--1");
		Identifier id= new Identifier();
	// vul verzameling1	
		id.init('a');
		verz1.voegToe(id);
		id.init('b');
		verz1.voegToe(id);
		id.init('c');
		verz1.voegToe(id);
		id.init('d');
		verz1.voegToe(id);		

		id.init('f');
		verz1.voegToe(id);		
	// vul verzameling2	
		id.init('a');
		verz2.voegToe(id);
		id.init('f');
		verz2.voegToe(id);
		id.init('g');
		verz2.voegToe(id);
		
		out.println("--2");
		Verzameling<Identifier> verz3 = verz2.symVerschil(verz1);
		
		out.println("--3");
		
		out.println("---------------------Verzameling 1-----------------------");
		if (verz1.lijst.setFirst()){
			do{
				out.println("------->"+((Identifier)verz1.lijst.retrieve()).geefChar(0));
			}while (verz1.lijst.getNext());
		}

		out.println("---------------------Verzameling 2-----------------------");
		if (verz2.lijst.setFirst()){
			do{
				out.println("------->"+((Identifier)verz2.lijst.retrieve()).geefChar(0));
			}while (verz2.lijst.getNext());
		}		
		
		out.println("---------------------Operatie symVerschil 2(1)-----------------------");
		if (verz3.lijst.setFirst()){
			do{
				out.println("------->"+((Identifier)verz3.lijst.retrieve()).geefChar(0));
			}while (verz3.lijst.getNext());
		}
		
		 verz3 = verz2.vereniging(verz1);

		out.println("---------------------Operatie vereniging 2(1)-----------------------");
		if (verz3.lijst.setFirst()){
			do{
				out.println("------->"+((Identifier)verz3.lijst.retrieve()).geefChar(0));
			}while (verz3.lijst.getNext());
		}
		
		verz3 = verz2.doorsnede(verz1);

		out.println("---------------------Operatie doorsnede 2(1)-----------------------");
		if (verz3.lijst.setFirst()){
			do{
				out.println("------->"+((Identifier)verz3.lijst.retrieve()).geefChar(0));
			}while (verz3.lijst.getNext());
		}
		
		 verz3 = verz2.verschil(verz1);

		out.println("---------------------Operatie verschil 2(1)-----------------------");
		if (verz3.lijst.setFirst()){
			do{
				out.println("------->"+((Identifier)verz3.lijst.retrieve()).geefChar(0));
			}while (verz3.lijst.getNext());
		}
		
	}
	
    public static void main(String[] argv){
        new TestVerzameling().start();
    }
}