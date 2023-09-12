// Fig. 3.11: BreakTest.java
// Using the break statement in a for structure
import java.awt.Graphics;
import java.applet.Applet;

public class BreakTest extends Applet {
   public void paint( Graphics g )
   {
      int count, xPos = 25;

      for ( count = 1; count <= 10; count++ ) {
         if ( count == 5 )
            break;  // break loop only if count == 5

         g.drawString( Integer.toString( count ), xPos, 25 );
         xPos += 10;
      }

      g.drawString( "Broke out of loop at count = " + count,
                    25, 40 );
   }
}


