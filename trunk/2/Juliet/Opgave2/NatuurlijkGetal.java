      
class NatuurlijkGetal implements NatuurlijkGetalInterface{

		private StringBuffer ng = new StringBuffer();

		NatuurlijkGetal(){
			ng.append("1");
		}
        

        public void init(char c){
			ng.setLength(0);
			ng.append(c);
		}
			
        

        public void voegToe(char c){
			ng.append(c);
		}
        


        public char geefCijfer(int index){
			return ng.charAt(index);
		}
        
         

		public int lengte(){
			return ng.length();
		}
        
	

		public Object clone(){
			NatuurlijkGetal kopie;
			try{ 
				kopie = (NatuurlijkGetal)super.clone();
			}
			catch(CloneNotSupportedException e){
				throw new Error("Het NatuurlijkGetal object kan niet gekopieerd worden");
			}
			
			kopie.ng = new StringBuffer(ng.toString());		
			
			return kopie;
		}
		

		public int compareTo(Object comp2){
			NatuurlijkGetal id2 = (NatuurlijkGetal)comp2;
			String id2_getalstr = "";
			for(int i = 0 ; i < id2.lengte();i++){
				id2_getalstr += id2.geefCijfer(i);
			}
			
			long getal1 = Long.parseLong(ng.toString());
			long getal2 = Long.parseLong(id2_getalstr);
			
			if (getal1 < getal2 ){
				return -1;
			}
			
			if (getal1 > getal2 ){
				return 1;
			}
			
			return 0;
			
		}
}
