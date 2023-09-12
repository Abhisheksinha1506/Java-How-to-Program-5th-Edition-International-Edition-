// Exercise 1.25 Solution
// Draw3.java
// Program draws an oval on the applet

import java.applet.Applet;
import java.awt.*;

public class Draw3 extends Applet {
   public void paint( Graphics g )
   {
      g.drawRect( 10, 10, 50, 50 );
      g.drawOval( 10, 10, 50, 50 );
   }
}
