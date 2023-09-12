// Cube.java
// Definition of class Cylinder

public class Cube extends Square {
   private double depth;

   public Cube( double s, double a, double b )      
   {
      super( s, a, b );
      depth = s;
   }
   
   public double area() { return super.area() * 6; }
   
   public double volume() { return super.area() * depth; }
  
   public String toString()
      { return super.toString() + "; depth = " + depth; }

   public String getName() { return "Cube"; }
}
