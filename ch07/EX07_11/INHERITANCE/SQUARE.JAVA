// Square.java
// Definition of class Square

public class Square extends Point {  
   protected double side;

   public Square()
      { this( 0.0, 0.0, 0.0 ); }
  
   public Square( double s, double a, double b )
   {
      super( a, b );  
      setSide( s );  
   }

   public void setSide( double s )
      { side = ( s >= 0 ? s : 0 ); }

   public double getSide() { return side; }
  
   public double area() { return Math.pow( side, 2 ); }

   public String toString()
      { return "Corner = " + super.toString() + 
               "; side = " + side; }

   public String getName() { return "Square"; }
}
