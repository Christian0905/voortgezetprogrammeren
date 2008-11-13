class MattyCollege5 {

	//tertiaire operator -> ?:

	int a, b;
	a = ...
	b = ...

int man;
if (a>b) {
	man = a;
	} else { //a <= b
		man = b;
}

==========================================

	Eerst shallow copy maken en die veranderen
	in een deep copy

public Object clone() {
	Object kopie;
	try {
		kopie = super.clone();	// shallow copy
	} catch (CloneNotSupportedException e) {
		throw new Error("Deze class is niet cloneable");
	}
	kopie.s = s == null?null:(String)s.clone();	// deep copy voor elke referentie s
	return kopie;
	}
}

 ===========================================
	 
 class VPException extends Exception {
	 
	VPException (String s) {
		super(s);
	}
}
 
  ===========================================

  interface Comparable {
	int compareTo(Object rhs); //rhs = righthandside   lhs -> 2+3 <- rhs
  }
  
  a.compareTo(b)
	  <0 als a voor b komt
	  =0 als a == b
	  >0 als a na b komt
	  
 =============================================
 
 interface Data extends Cloneable, Comparable {
 }
 
 ---------------------------------------
	 auto boxing + unboxing iets met wrappers
	 Integer x = new Intger(4);
	 int getal = x + 7;  // 11
	 Integer x2 = x + 8  // 12

 ==============================================
 
 TEMPLATES (geparameteriseerde classes)
 
 Stack<string> stapel = new Stack<String>();
 stapel.push("aap");
 String s = stapel.pop();
 //s.equals("aap");
 
 class Stack<E extends Cloneable> implements StackInterface<E> {
	 private E[] stackArray;
	 private int aantalElementen;
	 
	 Stack() {
		 stackArray = (E[])new Object[100];);
		 aantalElementen = 0;
	 }
	 
	 E pop() {
		 aantalElementen -= 1;
		 return stackArray[aantalElementen];
	 }
	 
	 void push(E x) {
		 aantalElementen += 1;
		 stackArray[aantalElementen] = x.clone();
	}
}
 
 interface StackInterface<E extends Cloneable> extends Cloneable {

	 void push (E x);
	 E pop();
 }
 
 
 ===================================================
	 
	 VERVOLG LIJSTEN
	 
	lijst -> 6 -> 5 -> 4 -> 3 -> 2 -> null
	 
	 voeg achteraan toe: 1
	 
	 Knoop k = lijst;
	 while(k.next != null) {
		 k = k.next;
	 }
	 k.next = new Knoop(1)
	 
verwijder de eerste knoop (6):
	 
	lijst = lijst.next;
	 
 
 