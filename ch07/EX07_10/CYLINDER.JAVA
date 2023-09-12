// Cylinder.java
// Definition of class Cylinder

public class Cylinder {
   private double height;  // height of Cylinder
   private Circle c;       // composition
    
   public Cylinder( double h, double r, double a, double b )      
   {
      c = new Circle( r, a, b ); 
      setHeight( h );
   }

   // Set height of Cylinder
   public void setHeight( double h )
      { height = ( h >= 0 ? h : 0 ); }
   
   // Get height of Cylinder
   public double getHeight() { return height; }

   // Calculate area of Cylinder (i.e., surface area)
   public double area()
   {
      return 2 * c.area() + 2 * Math.PI * c.getRadius() * height;
   }
   
   // Calculate volume of Cylinder
   public double volume() { return c.area() * height; }

   // Convert a Cylinder to a String
   public String toString()
      { return c.toString() + "; Height = " + height; }

   // Return the class name
   public String getName() { return "Cylinder"; }

   // Return the area of the circle object
   public double getCircleArea() { return c.area(); }

   // Return the name of the circle object
   public String getCircleName() { return c.getName(); }

   // Return the String of the circle object
   public String getCircleString() { return c.toString(); }

   // Return the String of the point contained in the circle object
   public String getCPointString() { return c.getPointString(); }

   // Return the String of the name contained in the circle object
   public String getCPointName() { return c.getPointName(); }
}
