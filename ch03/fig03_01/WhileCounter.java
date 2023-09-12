// Fig. 3.1: WhileCounter.java
// Counter-controlled repetition
import java.awt.Graphics;
import java.applet.Applet;

public class WhileCounter extends Applet {
   public void paint( Graphics g )
   {
      int counter = 1;             // initialization
      int yPos = 25;

      while ( counter <= 10 ) {    // repetition condition
         g.drawString( Integer.toString( counter ),
                       25, yPos );
         ++counter;                // increment
         yPos += 15;
      }
   }
}

