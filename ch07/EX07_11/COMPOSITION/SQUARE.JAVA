// Square.java
// Definition of class Square

public class Square {  
   private double side;
   private Point p;       // composition 

   // no-argument constructor
   // calls the other constructor
   public Square()  {  this( 0.0, 0.0, 0.0 );  }

   // Constructor
   public Square( double s, double a, double b )
   {
      p = new Point( a, b );   // instantiate point object     
      setSide( s );  
   }

   public void setSide( double s )
      { side = ( s >= 0 ? s : 0 ); }

   public double getSide() { return side; }
   
   public double area() { return Math.pow( side, 2 ); }

   public String toString()
      { return "Corner = " + p.toString() + 
               "; Side = " + side; }
  
   public String getName() { return "Square"; }

   public String getPointName() { return p.getName(); }

   public String getPointString() { return p.toString(); }
}
