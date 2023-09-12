// Fig. 3.2: ForCounter.java
// Counter-controlled repetition with the for structure
import java.awt.Graphics;
import java.applet.Applet;

public class ForCounter extends Applet {
   public void paint( Graphics g )
   {
      int yPos = 25;

      // Initialization, repetition condition, and incrementing 
      // are all included in the for structure header. 
      for ( int counter = 1; counter <= 10; counter++ ) {
         g.drawString( Integer.toString( counter ), 25, yPos );
         yPos += 15;
      }
   }
}

