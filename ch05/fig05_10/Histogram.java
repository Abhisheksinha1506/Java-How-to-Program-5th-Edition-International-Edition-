// Fig. 5.10: Histogram.java
// Histogram printing program
import java.awt.Graphics;
import java.applet.Applet;

public class Histogram extends Applet {
   int n[] = { 19, 3, 15, 7, 11, 9, 13, 5, 17, 1 };
   
   // paint the applet
   public void paint( Graphics g )
   {
      int xPosition;       // position of * in histogram
      int yPosition = 25;  // vertical position in applet

      g.drawString( "Element", 25, yPosition );
      g.drawString( "Value", 100, yPosition );
      g.drawString( "Histogram", 175, yPosition );
   
      for ( int i = 0; i < n.length; i++ ) {
         yPosition += 15;
         g.drawString( String.valueOf( i ), 25, yPosition );
         g.drawString( String.valueOf( n[ i ] ),
                       100, yPosition );
         xPosition = 175;

         for ( int j = 1; j <= n[i]; j++ ) { // print one bar
            g.drawString( "*", xPosition, yPosition );
            xPosition += 7;
         }
      }
   }
}
