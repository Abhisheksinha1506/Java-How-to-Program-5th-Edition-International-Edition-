// Fig. 9.36: DrawPoly.java
// Drawing polygons
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Polygon;

public class DrawPoly extends Applet {
   // coordinates for first polygon
   private int xValues[] = { 20, 40, 50, 30, 20, 15, 20 };
   private int yValues[] = { 20, 20, 30, 50, 50, 30, 20 };

   // coordinates for second polygon
   private int xValues2[] = { 70, 90, 100, 80, 70, 65,
                              60, 70 };

   private int yValues2[] = { 70, 70, 80, 100, 100, 80,
                              60, 70 };

   // coordinates for third polygon
   private int xValues3[] = { 120, 140, 150, 190 };
   private int yValues3[] = { 10, 40, 50, 30 };

   // create references to polygons
   private Polygon p4, p5, p6;

   public void init()
   {
      // instantiate polygon objects
      p4 = new Polygon( xValues, yValues, 7 );  
      p5 = new Polygon();
      p6 = new Polygon();

      // add points to p5
      p5.addPoint( 165, 105 );
      p5.addPoint( 175, 120 );
      p5.addPoint( 270, 170 );
      p5.addPoint( 200, 190 );
      p5.addPoint( 130, 150 );
      p5.addPoint( 165, 105 );

      // add points to p6
      p6.addPoint( 240, 50 );
      p6.addPoint( 260, 70 );
      p6.addPoint( 250, 90 );
   }

   public void paint( Graphics g )
   {
      // draw a polygon of 8 points
      g.drawPolygon( xValues2, yValues2, 8 );

      // draw a polygon object
      g.drawPolygon( p4 );

      // draw a filled polygon object
      g.fillPolygon( p5 );

      // draw a filled polygon object
      g.fillPolygon( p6 );

      // draw a filled polygon of 4 points
      g.fillPolygon( xValues3, yValues3, 4 );
   }
}
