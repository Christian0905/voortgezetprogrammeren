public class BoomKnoop {

	Identifier data;
	BoomKnoop links, rechts;
		
	BoomKnoop() {
		data = null;
		links = null;
		rechts = null;
	}
	
	BoomKnoop(Identifier i, BoomKnoop l, BoomKnoop r) {
		data = i;
		links = l;
		rechts = r;
	}
		
	BoomKnoop(Identifier i) {
		this(i, null, null);
	}
}	
