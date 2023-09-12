// Fig. 7.10: Circle.java
// Definition of class Circle

public class Circle extends Point {  // inherits from Point
   protected double radius;

   // no-argument constructor
   public Circle()
   {
      super( 0, 0 );  // call the base class constructor
      setRadius( 0 );  
   }

   // Constructor
   public Circle( double r, double a, double b )
   {
      super( a, b );  // call the base class constructor
      setRadius( r );  
   }

   // Set radius of Circle
   public void setRadius( double r )
      { radius = ( r >= 0 ? r : 0 ); }

   // Get radius of Circle
   public double getRadius() { return radius; }

   // Calculate area of Circle
   public double area() { return 3.14159 * radius * radius; }

   // convert the Circle to a String
   public String toString()
      { return "Center = " + super.toString() + 
               "; Radius = " + radius; }

   // return the class name
   public String getName() { return "Circle"; }
}
