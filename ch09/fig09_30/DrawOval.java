// Fig. 9.30: DrawOval.java
// Drawing ovals
import java.applet.Applet;
import java.awt.Graphics;

public class DrawOval extends Applet {

   public void paint( Graphics g )
   {
      // draw an oval at location (10, 15) 
      g.drawOval( 10, 15, 100, 70 );

      // draw an oval at location (160, 15)
      g.fillOval( 160, 15, 70, 130 );
   }
}
