// Fig. 7.7: Test.java
// Applet to test class Circle
import java.awt.Graphics;
import java.applet.Applet;

public class Test extends Applet {
   private Circle c;

   public void init()
   {
      c = new Circle( 2.5, 3.7, 4.3 );
   }

   public void paint( Graphics g )
   {
      g.drawString( "X coordinate is " + c.getX(), 25, 25 );
      g.drawString( "Y coordinate is " + c.getY(), 25, 40 );
      g.drawString( "Radius is " + c.getRadius(), 25, 55 );

      c.setRadius( 4.25 );
      c.setPoint( 2, 2 );
      g.drawString( "The new location and radius of c are ",
                    25, 85 );
      g.drawString( c.toString(), 40, 100 );
      g.drawString( "Area is " + c.area(), 25, 115 );
   }
}
