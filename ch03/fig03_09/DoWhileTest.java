// Fig. 3.9: DoWhileTest.java
// Using the do/while repetition structure
import java.awt.Graphics;
import java.applet.Applet;

public class DoWhileTest extends Applet {
   public void paint( Graphics g )
   {
      int counter = 1;
      int xPos = 25;

      do {
         g.drawString( Integer.toString( counter ), xPos, 25 );
         xPos += 15;
      } while ( ++counter <= 10 );
   }
}