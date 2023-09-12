// Fig. 7.4: Test.java
// Casting superclass references to subclass references
import java.awt.Graphics;
import java.applet.Applet;

public class Test extends Applet {
   private Point pointRef, p; 
   private Circle circleRef, c;

   public void init()
   {
      p = new Point( 3.5, 5.3 );
      c = new Circle( 2.7, 1.2, 8.9 );
   }

   public void paint( Graphics g )
   {
      g.drawString( "Point p: " + p.toString(), 25, 25 );
      g.drawString( "Circle c: " + c.toString(), 25, 40 );
   
      // Attempt to treat a Circle as a Point
      pointRef = c;   // assign Circle to pointRef
      g.drawString( "Circle c (via pointRef): " +
                    pointRef.toString(), 25, 70 );
   
      // Treat a Circle as a Circle (with some casting)
      pointRef = c;   // assign Circle to pointRef
      circleRef = (Circle) pointRef;  // cast super to sub
      g.drawString( "Circle c (via circleRef): " +
                     circleRef.toString(), 25, 100);
      g.drawString( "Area of c (via circleRef): " +
                    circleRef.area(), 25, 115 );

      // Attempt to refer to Point object
      // with Circle reference
      circleRef = (Circle) p;
   }
}
