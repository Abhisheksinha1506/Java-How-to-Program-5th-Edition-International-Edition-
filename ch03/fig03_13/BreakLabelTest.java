// Fig. 3.13: BreakLabelTest.java
// Using the break statement with a label
import java.awt.Graphics;
import java.applet.Applet;

public class BreakLabelTest extends Applet {
   public void paint( Graphics g )
   {
      int xPos, yPos = 0;
      
      stop: {   // labeled compound statement
         for ( int row = 1; row <= 10; row++ ) {
            xPos = 25;
            yPos += 15;         

            for ( int column = 1; column <= 5 ; column++ ) {

               if ( row == 5 )
                  break stop; // jump to stop label

               g.drawString( "#", xPos, yPos );
               xPos += 7;
            }
         }

         yPos += 15;
         g.drawString( "Loops terminated normally", 25, yPos );
      }

      yPos += 15;
      g.drawString( "End of paint method", 25, yPos );
   }
}


