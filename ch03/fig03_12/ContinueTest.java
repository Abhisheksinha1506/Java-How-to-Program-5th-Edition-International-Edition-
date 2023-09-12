// Fig. 3.12: ContinueTest.java
// Using the continue statement in a for structure
import java.awt.Graphics;
import java.applet.Applet;

public class ContinueTest extends Applet {
   public void paint( Graphics g )
   {
      int xPos = 25;

      for ( int count = 1; count <= 10; count++ ) {
         if ( count == 5 )
            continue;  // skip remaining code in loop
                       // only if count == 5

         g.drawString( Integer.toString( count ), xPos, 25 );
         xPos += 10;
      }

      g.drawString( "Used continue to skip printing 5",
                    25, 40 ); 
   }
}


