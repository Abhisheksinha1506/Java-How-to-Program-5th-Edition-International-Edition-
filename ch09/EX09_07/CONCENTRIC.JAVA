// Exercise 9.7 Solution
// Concentric.java
// This program draws concentric circles

import java.applet.Applet;
import java.awt.*;

public class Concentric extends Applet {

   public void paint( Graphics g )
   {
      for ( int x = 0; x <= 160; x += 10 ) {
         int y = 160 - ( x * 2 );

         g.drawRoundRect( x + 10, x + 10, y, y, y, y );
      }
   }
}
