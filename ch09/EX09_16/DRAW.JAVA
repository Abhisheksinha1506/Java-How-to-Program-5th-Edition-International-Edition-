// Exercise 9.16 Solution
// Draw.java
// This program randomly draws characters

import java.applet.Applet;
import java.awt.*;

public class Draw extends Applet {

   // Note: cover or resize the applet repeatedly
   // to see multiple characters drawn

   public void paint( Graphics g )
   {
      int fontSize = ( int ) ( 10 + Math.random() * 63 );
      int x = ( int ) ( 5 + Math.random() * 341 );
      int y = ( int ) ( 5 + Math.random() * 95 );
      char letters[] = { 'D', 'A', 'L', 'L', 'A', 'S' };

      Font f = new Font( "Courier", Font.BOLD, fontSize );
      g.setFont( f );

      g.drawChars( letters, ( int ) ( Math.random() * 6 ), 1, x, y ); 
   }
}
