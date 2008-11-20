class MattyCollege7 {
	
interface I1 {
	public final int I = 7;

	void m(int j);
}

interface I2 {
	public final int I = 13;

	void m(int j);
}

class X implements I1, I2 {
	
	out.printf("%d\n", I);  < conflict I1/I2
	
	void m(int j){
		// doe iets
	}
}

// VOORBEELD INTERFACE

interface Rood extends EetbaarOfRood {
	
interface Eetbaar extends EetbaarOfRood {
	
interface EetbaarEnRood extends Eetbaar, Rood {
	
interface EetbaarOfRood {
	
class Aardbei implements EetbaarEnRood {
}

class paspoort implements Rood {
}

EetbaarOfRood x = new Paspoort();
Aardbei a = new Aardbei();
EetbaarOfRood x2 = a;
EetbaarEnRood y = a;


// override equals met Object
class X {
	
	int i;
	double x;
	String s;
	Y y;

	boolean equals (Object rhs) {
		if(this == rhs) {
			return true;
		}

		if(rhs == null) {
			return false;
		}
		
		if(getClass() != rhs.getClass()){
			return false;
		}
		
		X x = (X)rhs;
		return i == rhs.i && x ==x.x && s.equals(x.s) && y.equals(x.y);
	}