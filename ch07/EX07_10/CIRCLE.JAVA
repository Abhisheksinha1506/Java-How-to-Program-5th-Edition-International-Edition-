// Circle.java
// Definition of class Circle

public class Circle {  
   private double radius;
   private Point p;       // composition 

   // no-argument constructor
   // calls the other constructor
   public Circle()  {  this( 0.0, 0.0, 0.0 );  }

   // Constructor
   public Circle( double r, double a, double b )
   {
      p = new Point( a, b );   // instantiate point object     
      setRadius( r );  
   }

   // Set radius of Circle
   public void setRadius( double r )
      { radius = ( r >= 0 ? r : 0 ); }

   // Get radius of Circle
   public double getRadius() { return radius; }

   // Calculate area of Circle
   public double area() { return Math.PI * Math.pow( radius, 2 ); }

   // convert the Circle to a String
   public String toString()
      { return "Center = " + p.toString() + 
               "; Radius = " + radius; }

   // return the class name
   public String getName() { return "Circle"; }

   // return the point object's name
   public String getPointName() { return p.getName(); }

   // return the point object's string
   public String getPointString() { return p.toString(); }
}
