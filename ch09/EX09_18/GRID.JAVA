// Exercise 9.18 Solution
// Grid.java
// This program draws an 8 x 8 grid

import java.applet.Applet;
import java.awt.*;

public class Grid extends Applet {

   public void paint( Graphics g )
   {
      int y = 8, x1 = 0;

      for ( int r = 1; r <= 8; r++, y += 12 ) 
         g.drawLine( 0, y, 344, y );

      for ( int c = 1; c <= 8; c++, x1 += 42 )
         g.drawLine( x1, 0, x1, 100 );
   }
}
