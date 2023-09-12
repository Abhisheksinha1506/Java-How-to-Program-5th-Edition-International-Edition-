// Fig. 11.7: NewCanvas.java
// Capturing mouse events with a Canvas.
import java.applet.Applet;
import java.awt.*;

class NewCanvas extends Canvas {
   private int width, height;
   private int x1, y1;
                           
   public void paint( Graphics g )
   {
      g.drawOval( x1, y1, width, height );
   }

   public boolean mouseDown( Event e, int x, int y )
   {
      x1 = x;
      y1 = y;
      return true;
   }

   public boolean mouseUp( Event e, int x, int y )
   {
      width = Math.abs( x - x1 );
      height = Math.abs( y - y1 );

      // determine the upper left point of
      // the bounding rectangle
      x1 = Math.min( x1, x );
      y1 = Math.min( y1, y );

      repaint();
      return true;
   }
}

public class MyCanvas extends Applet {
   private NewCanvas c;

   public void init()
   {
      c = new NewCanvas();   
      c.resize( 185, 70 );  // resize canvas
      c.setBackground( Color.yellow );

      add( c );    // add canvas to applet
   }
}
