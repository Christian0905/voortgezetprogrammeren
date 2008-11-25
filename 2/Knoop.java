class Knoop implements Cloneable {

    Data data;
    Knoop prior,
          next;
    

    public Knoop (Data d) {
	    this(d, null, null);
    }


    public Knoop (Data d, Knoop p, Knoop n) {
	    data = d == null ? null : (Data) d.clone();
	    prior = p;
	    next = n;
    }


    public Knoop clone () {
	    Knoop kopie;
	    try {
	        kopie = (Knoop) super.clone();
	    } catch (CloneNotSupportedException e) {
	        throw new Error("Onmogelijk! instantie Knoop is niet Cloneable");
	    }
        kopie.data = data == null ? null : (Data) data.clone();
	    return kopie;
    }
    
    public String toString() {
    	return data.toString();
    } 

}
