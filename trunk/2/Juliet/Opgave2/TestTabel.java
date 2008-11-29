class TestTabel{

	Input in;
	Output out;
	
	Verzameling<NatuurlijkGetal> verz1 = new Verzameling<NatuurlijkGetal>();
	Verzameling<NatuurlijkGetal> verz2 = new Verzameling<NatuurlijkGetal>();
	Tabel tabel = new Tabel();
	
	TestTabel(){
        in  = new Input();
        out = new Output();
		
	}
	
	void start(){		
		// vul paar1	
		Identifier id= new Identifier();
		
		NatuurlijkGetal nt = new NatuurlijkGetal();
		
		id.init('a');
		nt.init('1');
		verz1.voegToe(nt);
		
		nt.init('2');
		verz1.voegToe(nt);
		
		Paar paar = new Paar(id,verz1);
		tabel.voegToe(id,verz1);
		

		
		// vul paar2	
		id.init('b');
		
		nt.init('9');
		verz2.voegToe(nt);
		
		nt.init('6');
		verz2.voegToe(nt);
		
		nt.init('8');
		verz2.voegToe(nt);		
		
		tabel.voegToe(id,verz2);
		
		id.init('b');
		Verzameling<NatuurlijkGetal> verz3 = tabel.geefVerzameling(id);


		out.println("---------------------Verzameling3-----------------------");
		
		if (verz3==null)
			out.println("verzameling 3 is null");
			
			
		if (verz3.lijst.setFirst()){
			do{
				out.println("------->"+((NatuurlijkGetal)verz3.lijst.retrieve()).geefCijfer(0));
			}while (verz3.lijst.getNext());
		}
		
	}
	
    public static void main(String[] argv){
        new TestTabel().start();
    }
}