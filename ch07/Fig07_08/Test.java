// Fig. 7.8: Test.java
// Applet to test class Cylinder
import java.awt.Graphics;
import java.applet.Applet;

public class Test extends Applet {
   private Cylinder c;

   public void init()
   {
      c = new Cylinder( 5.7, 2.5, 1.2, 2.3 );
   }

   public void paint( Graphics g )
   {
      g.drawString( "X coordinate is " + c.getX(), 25, 25 );
      g.drawString( "Y coordinate is " + c.getY(), 25, 40 );
      g.drawString( "Radius is " + c.getRadius(), 25, 55 );
      g.drawString( "Height is " + c.getHeight(), 25, 70 );

      c.setHeight( 10 );
      c.setRadius( 4.25 );
      c.setPoint( 2, 2 );

      g.drawString( "The new location, radius and height" +
                    " of c are ", 25, 100 );
      g.drawString( c.toString(), 40, 115 );
      g.drawString( "Area is " + c.area(), 25, 130 );
      g.drawString( "Volume is " + c.volume(), 25, 145 );
   }
}
