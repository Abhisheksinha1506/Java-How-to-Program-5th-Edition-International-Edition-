// Exercise 1.23 Solution
// Draw.java
// Program draws a square on the applet

import java.applet.Applet;
import java.awt.*;

public class Draw extends Applet {
   public void paint( Graphics g )
   {
      g.drawRect( 10, 10, 50, 50 );
   }
}
