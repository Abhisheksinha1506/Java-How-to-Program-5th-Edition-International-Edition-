// Exercise 10.18 Solution
// Shapes.java
// Program draws various shapes
import java.applet.Applet;
import java.awt.*;

public class Shapes extends Applet {
   private int topX;
   private int topY;
   private int width;
   private int height;
   private int bottomX;
   private int bottomY;
   private int shape;

   private final int CIRCLE = 1;
   private final int OVAL = 2;
   private final int LINE = 3;
   private final int RECT = 4;

   public void init()
   {
      topX = topY = 0;
      shape = CIRCLE;
   }

   public boolean mouseDown( Event e, int x, int y )
   {
      topX = x;
      topY = y;
      return true;
   }

   public boolean mouseDrag( Event e, int x, int y )
   {
      bottomX = x;
      bottomY = y;

      width = Math.abs( topX - bottomX );
      height = Math.abs( topY - bottomY );
      repaint();
      return true;
   }

   public void paint( Graphics g )
   {
      switch ( shape ) {
         case CIRCLE:
            showStatus( "Circle" );  
            g.drawOval( topX, topY,  width, width );            
            break;
         case OVAL:
            g.drawOval( topX, topY,  width, height );            
            break;
         case LINE:
            g.drawLine( topX, topY, bottomX, bottomY );
            break;
         case RECT:
            g.drawRect( topX, topY, width, height );           
            break;
      }
   }

   public boolean keyDown( Event e, int key )
   {      
      if ( key == 'c' ) {
         shape = CIRCLE;
         showStatus( "Circle" );
      }
      else if ( key == 'o' ) {
         shape = OVAL;
         showStatus( "Oval" );
      }
      else if ( key == 'l' ) {
         shape = LINE;
         showStatus( "Line" );
      }
      else if ( key == 'r' ) {
         shape = RECT;
         showStatus( "Rectangle" );
      }

      return true;
   }
}
