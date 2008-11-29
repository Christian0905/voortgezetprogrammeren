
class Programma{
	
	//naam	:	Juliet Dyer en Kelvin van der Staaij.
	//opgave	:	Datastructuren Opgave 2. Verzamelingen.
	//datum	:	1 november 2007
	
	Input in;
	Output out;
	Tabel tabel;
	
	static final char	COMMENTAAR_TEKEN 	= '/',
						PRINT_TEKEN 		= '?',
						VERZAMELING_OPEN 	= '{',
						VERZAMELING_SLUIT 	= '}',
						VERZAMELING_SCHEID 	= ',',
						COMPL_FACTOR_OPEN 	= '(',
						COMPL_FACTOR_SLUIT 	= ')',
						MULTI_OPERATOR 		= '*',
						ASSIGN_TEKEN 		= '=',
						ADD_OP_VERENIGING	= '+',
						ADD_OP_VERSCHIL		= '-',
						ADD_OP_SYM_VERSCHIL	= '|';


	Programma(){
		in = new Input();
		out = new Output();
		tabel = new Tabel();
	}
		
	void skipSpaties(){
		while (in.nextChar()==' '){
			in.readChar();
		}
	}
	
	void throwDSException(String message) throws DSException{
		in.readln();
		throw new DSException(message);
	}
	
	void volgendChar(char c) throws DSException{	
		if (in.eoln()){
			throwDSException(c+" verwacht op de invoer");
		}
			
		while(in.nextChar() != c){
            in.readChar();
			
			if (in.eoln()){
				throwDSException(c +" ontbreekt op invoer");
			}
			
			if ((in.nextChar() !=' ') && (in.nextChar() != c)){
				throwDSException(c+" verwacht maar " +in.nextChar()+" gevonden op invoer");
			}
		}
		in.readChar();
	}
	
	void checkOfEindInvoer() throws DSException{
		skipSpaties();
		char c = in.nextChar();
		if ((!in.eoln())){
			if (c != ADD_OP_VERENIGING && c != ADD_OP_VERSCHIL && c != ADD_OP_SYM_VERSCHIL ){
				throwDSException("Ongeldige invoer vanaf "+c);
			}
		}	
	}
	
	void printVerzameling(Verzameling<NatuurlijkGetal> v) throws DSException{
		NatuurlijkGetal natuurlijkgetal;
		if (v!=null){
			while(v.lengte()!=0){	
				natuurlijkgetal = v.geefElement();
				for (int i = 0 ; i < natuurlijkgetal.lengte() ; i++){
					out.print(natuurlijkgetal.geefCijfer(i));
				}
				if (v.lengte()!=1){
					out.print(" ");
				}
				v.verwijderElement(natuurlijkgetal);
			}
		}
	}
	
	char controleerNatuurlijkgetal() throws DSException{
		char c = in.readChar();
		
		if (!Character.isDigit(c)){
			throwDSException("Geen geldige natuurlijkgetal");
		}
		
		if ((c=='0') && (Character.isDigit(in.nextChar()))){
			throwDSException("Geen geldige natuurgetal");
		}
		
		return c;
	}
	
	
	void statement() throws DSException{
		skipSpaties();
		char c = in.nextChar();
		
		if ((c != COMMENTAAR_TEKEN) && (c != PRINT_TEKEN) && (!Character.isLetter(c)) ){
			throwDSException("Er moet een / , ? of letter op de invoer staan!");		
		}
		
		if(c == COMMENTAAR_TEKEN){
			commentaar();
		}
		else if(c == PRINT_TEKEN){
			printStatement();
		}
		else if(Character.isLetter(c)){
			assignment();
		}	
	}
	
	
	void assignment() throws DSException{
		Identifier id = identifier();
		volgendChar('=');
		skipSpaties();
		Verzameling<NatuurlijkGetal> v = expressie();
				
		checkOfEindInvoer();
		
		if ( v!=null ){
			tabel.voegToe(id,v);
		}
		else{
			throwDSException("Ongeldige assignment");
		}	
		
		in.readln();
	}	
	
	
	void printStatement() throws DSException{
		volgendChar(PRINT_TEKEN);		
		skipSpaties();
		
		Verzameling<NatuurlijkGetal> v = expressie();
		
		checkOfEindInvoer();
		
		printVerzameling(v);
		
		out.println("");		
		in.readln();
	}	
	
	
	void commentaar(){
		in.readln();
	}
	
	
	Identifier identifier(){
        //char c = in.nextChar();
        Identifier resultaat = new Identifier();
		resultaat.init(in.readChar());

        while (Character.isLetter(in.nextChar()) || Character.isDigit(in.nextChar()) ){
        	//c = in.readChar();
			resultaat.voegToe(in.readChar());
        }
        return resultaat;		
	}
	
	Verzameling<NatuurlijkGetal> expressie() throws DSException{
		// een term gevolgd door nul of meer termen (gescheiden door additieve op.)
		
		Verzameling<NatuurlijkGetal> v1 = term();
		
		skipSpaties();
		char c = in.nextChar();
		
		if ((!in.eoln()) && (c!=ADD_OP_VERENIGING) && (c!=ADD_OP_VERSCHIL) &&  (c!=ADD_OP_SYM_VERSCHIL) && (c!=COMPL_FACTOR_SLUIT)) {
			throwDSException("Ongeldige invoer vanaf: "+c);
		}
		
		while(c == ADD_OP_VERENIGING || c == ADD_OP_VERSCHIL || c == ADD_OP_SYM_VERSCHIL ){
			//volgendChar(c); waarom?
			in.readChar();
			Verzameling<NatuurlijkGetal> v2 = term();
			v1 = bereken(v1, v2, c);
			
			skipSpaties();
			c = in.nextChar();
		}	
		skipSpaties();
		
		return v1;
		
	}

	Verzameling<NatuurlijkGetal> bereken(Verzameling<NatuurlijkGetal> v1, Verzameling<NatuurlijkGetal> v2, char c){
		Verzameling<NatuurlijkGetal> resultaat = new Verzameling<NatuurlijkGetal>();
		
		if(c == ADD_OP_VERENIGING){
			resultaat = v1.vereniging(v2);				
		}
		if(c == ADD_OP_VERSCHIL){
			resultaat = v1.verschil(v2);
		}
		if(c == ADD_OP_SYM_VERSCHIL){
			resultaat = v1.symVerschil(v2);
		}
		if(c == MULTI_OPERATOR){
			resultaat = v1.doorsnede(v2);
		}
		return resultaat;
	}
	
	
	Verzameling<NatuurlijkGetal> term() throws DSException{
		//een factor gevolgd door nul of meer factoren (gescheiden door * )
		
		Verzameling<NatuurlijkGetal> v1 = factor();
		
		char c = in.nextChar();
		
		while(c == MULTI_OPERATOR){	
			in.readChar();
			Verzameling<NatuurlijkGetal> v2 = factor();
			v1 = bereken(v1, v2, c);
			c = in.nextChar();
		}
		
		return v1;
	}
	
	
	Verzameling<NatuurlijkGetal> factor() throws DSException{
		Verzameling<NatuurlijkGetal> resultaat = new Verzameling<NatuurlijkGetal>();
		
		skipSpaties();
		
		char c = in.nextChar();
		if(c == VERZAMELING_OPEN){
			resultaat = verzameling();
		}
		else if(c == COMPL_FACTOR_OPEN){
			resultaat = complexeFactor();
		}
		else if(Character.isLetter(c)){
			Identifier id = identifier();
			if (tabel.bevat(id)){
				resultaat = tabel.geefVerzameling(id);	
			}else
			{
				throwDSException("Onbekende Identifier");
			}
		}
		else throwDSException("Er moet een { , ( of letter op de invoer staan!");
		
		skipSpaties();
		
		return resultaat; 
	}
	
	
	Verzameling<NatuurlijkGetal> complexeFactor() throws DSException{
		
		volgendChar(COMPL_FACTOR_OPEN); // leest '(' weg
		skipSpaties();
		
		char c = in.nextChar();
		
		if ((c != COMPL_FACTOR_OPEN ) && (c != VERZAMELING_OPEN ) && (!Character.isLetter(c)))
		{
			throwDSException("Ongeldige1 invoer vanaf " + c);
		}
		
		Verzameling<NatuurlijkGetal> resultaat = expressie();
		volgendChar(COMPL_FACTOR_SLUIT);
		return resultaat;
	}
	
	
	Verzameling<NatuurlijkGetal> verzameling() throws DSException{		
		volgendChar(VERZAMELING_OPEN); //leest '{' weg
		Verzameling<NatuurlijkGetal> resultaat = rijNatuurlijkeGetallen();
		volgendChar(VERZAMELING_SLUIT);
		
		return resultaat;
	}
	
	
	Verzameling<NatuurlijkGetal> rijNatuurlijkeGetallen() throws DSException{
		Verzameling<NatuurlijkGetal> resultaat = new Verzameling<NatuurlijkGetal>();
		if (in.nextChar()!=VERZAMELING_SLUIT)
		{
			skipSpaties();
			
			NatuurlijkGetal nt = natuurlijkGetal();
				
			if (nt != null){
				if (!resultaat.bevatElement(nt)){
					resultaat.voegToe(nt);
				}
			}
			
			while(in.nextChar() == VERZAMELING_SCHEID){
				in.readChar();
				skipSpaties();				
				
				if (!Character.isDigit(in.nextChar())){
					throwDSException("Geen geldige natuurlijkgetal");
				}
				
				nt = natuurlijkGetal();
				
				if (nt != null){
					if (!resultaat.bevatElement(nt)){
						resultaat.voegToe(nt);
					}
				}
			}	
		}	
		return resultaat;
	}
	
	
	NatuurlijkGetal natuurlijkGetal() throws DSException{
		NatuurlijkGetal resultaat = new NatuurlijkGetal();
		//leesgetallen in, if niet een positief getal of nul throw new exception
		
		
		if(in.nextChar()==VERZAMELING_SLUIT || in.eoln()){	
			return null;
		}
		
		resultaat.init(controleerNatuurlijkgetal());
		
		while ( (in.nextChar() != VERZAMELING_SCHEID) && (in.nextChar() != VERZAMELING_SLUIT) && (!in.eoln()) && (in.nextChar() !=' ')){
			if(Character.isDigit(in.nextChar())){
				char c = in.readChar();	
				resultaat.voegToe(c);
			}
			else{
				throwDSException("Geen geldige natuurlijkgetal");
			}			
		}
		skipSpaties();
		
		if ((in.nextChar() != VERZAMELING_SCHEID) && (in.nextChar() != VERZAMELING_SLUIT)){
			throwDSException("Geen geldige natuurlijkgetal");
		}
		
		return resultaat;
	}
	
	
    void start(){
        while(!in.eof()){
			try{
				statement();
			}
			catch ( DSException e ){
				out.println(e.getMessage());
			}
		}
    }
	
	
    public static void main(String[] argv){
        new Programma().start();
    }
}
