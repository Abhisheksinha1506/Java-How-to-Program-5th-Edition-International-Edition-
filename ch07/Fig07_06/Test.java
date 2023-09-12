// Fig. 7.6: Test.java
// Applet to test class Point
import java.awt.Graphics;
import java.applet.Applet;

public class Test extends Applet {
   private Point p;

   public void init()
   {
      p = new Point( 7.2, 11.5 );
   }

   public void paint( Graphics g )
   {
      g.drawString( "X coordinate is " + p.getX(), 25, 25 );
      g.drawString( "Y coordinate is " + p.getY(), 25, 40 );

      p.setPoint( 10, 10 );
      g.drawString( "The new location of p is " + 
                    p.toString(), 25, 70 );
   }
}
