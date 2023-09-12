// Fig. 7.7: Point.java
// Definition of class Point

public class Point {
   protected double x, y; // coordinates of the Point

   // constructor
   public Point( double a, double b ) { setPoint( a, b ); }

   // Set x and y coordinates of Point
   public void setPoint( double a, double b )
   {
      x = a;
      y = b;
   }

   // get x coordinate
   public double getX() { return x; }  

   // get y coordinate
   public double getY() { return y; }

   // conver the point into a String representation
   public String toString() 
      { return "[" + x + ", " + y + "]"; }
}

