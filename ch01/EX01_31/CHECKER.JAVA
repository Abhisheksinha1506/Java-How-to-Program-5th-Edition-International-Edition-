// Exercise 1.31 Solution
// Checker.java
// Program draws a checkerboard

import java.applet.Applet;
import java.awt.*;

public class Checker extends Applet {

   public void paint( Graphics g )
   {
      g.drawString( "* * * * * * * *", 5, 10 );
      g.drawString( " * * * * * * * *", 5, 20 );
      g.drawString( "* * * * * * * *", 5, 30 );
      g.drawString( " * * * * * * * *", 5, 40 );
      g.drawString( "* * * * * * * *", 5, 50 );
      g.drawString( " * * * * * * * *", 5, 60 );
      g.drawString( "* * * * * * * *", 5, 70 );
      g.drawString( " * * * * * * * *", 5, 80 );
   }
}
