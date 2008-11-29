     
class Identifier  implements IdentifierInterface{

	
	private StringBuffer id;
	
	
		Identifier(){
			id = new StringBuffer();
			id.append("a");
		}
		
        
        public void init(char c){
			id.setLength(0);
			id.append(c);		
		}
        


       public  void voegToe(char c){
			id.append(c);
		}
        


        public char geefChar(int index){
			return id.charAt(index);
		}
         
   
		public int lengte(){
			return id.length();
		 }

		 
		public Object clone(){
			Identifier kopie;
			
		    try {
		        kopie = (Identifier) super.clone();
		    } catch (CloneNotSupportedException e) {
		        throw new Error("Onmogelijk! instantie Knoop is niet Cloneable");
		    }

	        kopie.id = new StringBuffer(id.toString());
			
			return kopie;
		}
		

		public int compareTo(Object comp2){
			int resultaat=0;
			Identifier id2 = (Identifier)comp2;
			int idlengte = this.lengte() < id2.lengte() ? this.lengte() : id2.lengte();
			for(int i = 0 ; i < idlengte;i++){
				if (geefChar(i)!=id2.geefChar(i)){
					resultaat = geefChar(i) < id2.geefChar(i) ? -1 : 1 ;
					return resultaat;
				}
			}
			if (this.lengte() == id2.lengte()){
				resultaat = 0;
			}else 
			if (this.lengte() < id2.lengte()){
				resultaat= -1 ;
			}else
			if (this.lengte() > id2.lengte()){
				resultaat = 1;
			}
			return resultaat;	
		}
}
