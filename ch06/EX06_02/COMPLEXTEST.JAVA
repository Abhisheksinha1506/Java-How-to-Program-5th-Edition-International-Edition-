// Exercise 6.2: ComplexTest.java
// Test the Complex number class
import java.awt.*;
import java.applet.Applet;

public class ComplexTest extends Applet {
   private Complex a, b;

   public void init()
   {
      a = new Complex( 9.9, 7.7 );
      b = new Complex( 1.2, 3.1 );
   }

   public void paint( Graphics g )
   {
      g.drawString( "a = " + a, 25, 25 );
      g.drawString( "b = " + b, 25, 40 );

      g.drawString( "a + b = " + a.add( b ), 25, 70 );
      g.drawString( "a - b = " + a.subtract( b ), 25, 85 );
   }
}