// Fig. 9.34: DrawArcs.java
// Drawing arcs
import java.applet.Applet;
import java.awt.Graphics;

public class DrawArcs extends Applet {

   public void paint( Graphics g )
   {
      // draw an arc 
      g.drawArc( 15, 15, 80, 80, 0, 180 );

      // draw an arc 
      g.drawArc( 100, 100, 80, 80, 0, 110 );

      // draw a solid arc
      g.fillArc( 100, 15, 70, 80, 0, 270 );

      // draw a solid arc
      g.fillArc( 15, 70, 70, 80, 0, -110 );
                 
      // draw a solid arc
      g.fillArc( 190, 15, 80, 140, 0, -360 );
   }
}
