// Fig. 4.7: RandomInt.java
// Shifted, scaled random integers
import java.awt.Graphics;
import java.applet.Applet;

public class RandomInt extends Applet {
   public void paint( Graphics g )
   {
      int xPosition = 25;
      int yPosition = 25;
      int value;

      for ( int i = 1; i <= 20; i++ ) {
         value = 1 + (int) ( Math.random() * 6 );
         g.drawString( Integer.toString( value ), 
                       xPosition, yPosition );
         
         if ( i % 5 != 0 )
            xPosition += 40;
         else {
            xPosition = 25;
            yPosition += 15;
         }
      }
   }
}
