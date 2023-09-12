// Fig. 9.27: Draw3D.java
// Drawing 3-D rectangles
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

public class Draw3D extends Applet {

   public void paint( Graphics g )
   {
      g.setColor( Color.yellow );

      // draw a raised 3D rectangle at location (10, 10)
      g.draw3DRect( 10, 10, 100, 100, true );

      // draw a sunk 3D at location (130, 10)
      g.draw3DRect( 130, 10, 100, 100, false );

      // draw a filled raised 3D rectangle at (10, 120)
      g.fill3DRect( 10, 120, 100, 100, true );

      // draw a filled sunk 3D rectangle at (130, 120)
      g.fill3DRect( 130, 120, 100, 100, false );
   }
}
