public interface Data extends Cloneable, Comparable {

    /*
       Deze interface maakt een type Data dat de eigenschappen Cloneable
       en Comparable samenvoegt.
       Na de declaratie

		Data d;

       kan de referentie Data daardoor alleen naar objecten wijzen die zowel 
       cloneable als comparable zijn, m.a.w. kan alleen wijzen naar instanties
       van classes die zowel de methode clone() als de methode compareTo()
       bevatten.
    */

    /* Om de protected methode clone() uit de class Object overal te kunnen 
       gebruiken moet deze public gemaakt worden.
    */

    public Object clone();
}
