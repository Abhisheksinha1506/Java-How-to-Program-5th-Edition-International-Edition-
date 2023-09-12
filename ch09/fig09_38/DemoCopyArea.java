// Fig. 9.38: DemoCopyArea.java
// Demonstrate copying one area of the screen to another
// area of the screen
import java.applet.Applet;
import java.awt.Graphics;

public class DemoCopyArea extends Applet {

   // coordinates for first polygon
   int xValues[] = { 20, 40, 50, 30, 20, 15, 20 };
   int yValues[] = { 20, 20, 30, 50, 50, 30, 20 };

   // coordinates for second polygon
   int xValues2[] = { 70, 90, 100, 80, 70, 65, 60, 70 };
   int yValues2[] = { 70, 70, 80, 100, 100, 80, 60, 70 };

   public void paint( Graphics g )
   {
      // draw a polygon of 7 points
      g.drawPolygon( xValues, yValues, 7 );

      // draw a filled polygon of 8 points
      g.fillPolygon( xValues2, yValues2, 8 );

      // copy 100 x 100 area of applet to (140, 10)
      g.copyArea( 0, 0, 100, 100, 140, 10 );
   }
}
