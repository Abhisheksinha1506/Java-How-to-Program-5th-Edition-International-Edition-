// Exercise 1.27 Solution
// Mystery.java
// What does this print?

import java.applet.Applet;
import java.awt.*;

public class Mystery extends Applet {
   public void paint( Graphics g )
   {
      g.drawString( "*", 25, 25 );
      g.drawString( "***", 25, 55 );
      g.drawString( "*****", 25, 85 );
      g.drawString( "****", 25, 70 );
      g.drawString( "**", 25, 40 );
   }
}
