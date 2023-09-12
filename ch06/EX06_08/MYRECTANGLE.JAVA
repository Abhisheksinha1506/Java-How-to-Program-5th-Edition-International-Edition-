// Exercise 6.8: MyRectangle.java
// Definition of class MyRectangle

public class MyRectangle {
   private double length, width;

   public MyRectangle()
   {
      this( 1.0, 1.0 );
   }

   public MyRectangle( double l, double w)
   {
      setLength( l );
      setWidth( w );
   }

   public void setLength( double len )
   {
      length = ( len >= 0.0 && len <= 20.0 ? len : 1.0 );
   }

   public void setWidth( double w )
   {
      width = ( w >= 0 && w <= 20.0 ? w : 1.0 );
   }

   public double getLength() { return length; }

   public double getWidth() { return width; }

   public double perimeter()
   {
      return 2 * length + 2 * width;
   }

   public double area()
   {
      return length * width;
   }
}
