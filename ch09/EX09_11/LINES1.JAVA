// Exercise 9.11 Solution
// Lines1.java
// This program draws lines of random sizes

import java.applet.Applet;
import java.awt.*;

public class Lines1 extends Applet {

   public void paint( Graphics g )
   {
      for ( int y = 10; y < 200; y += 10 ) {
         int x1 = ( int ) ( 1 + Math.random() * 199 );

         g.drawLine( 1, y, x1, y );  
      }
   }
}
