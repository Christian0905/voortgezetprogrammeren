public class BoomKnoop {

	Data data;
	BoomKnoop links, rechts;

	BoomKnoop(Data d) {
		this(d, null, null);
	}
	
	BoomKnoop(Data d, BoomKnoop l, BoomKnoop r) {
		data = d == null ? null : (Data) d.clone();
		links = l;
		rechts = r;
	}

	public BoomKnoop clone () {
	    BoomKnoop kopie;
	    try {
	        kopie = (BoomKnoop) super.clone();
	    } catch (CloneNotSupportedException e) {
	        throw new Error("Deze class is niet Cloneable");
	    }
        kopie.data = data == null ? null : (Data) data.clone();
	    return kopie;
    }
		
	public String toString() {
		return data.toString();
	}
}	
