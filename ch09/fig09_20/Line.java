// Fig. 9.20: Line.java
// Demonstrating drawLine
import java.applet.Applet;
import java.awt.Graphics;

public class Line extends Applet {

   public void paint( Graphics g )
   {
      // draw a line from (10, 10) to (230, 95)
      g.drawLine( 10, 10, 230, 95 );
   }
}
