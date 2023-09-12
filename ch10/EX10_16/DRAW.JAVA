// Exercise 10.16 Solution
// Draw.java
// Program draws a rectangle with the mouse
import java.applet.Applet;
import java.awt.*;

public class Draw extends Applet {
   private int topX;
   private int topY;
   private int width;
   private int height;
   private int bottomX;
   private int bottomY;

   public void init()   {  topX = topY = 0;  }

   public boolean mouseDown( Event e, int x, int y )
   {
      topX = x;
      topY = y;
      return true;
   }

   public boolean mouseUp( Event e, int x, int y )
   {
      bottomX = x;
      bottomY = y;
      width = Math.abs( topX - bottomX );
      height = Math.abs( topY - bottomY );
      showStatus( "Area is " + ( width * height ) );
      repaint();
      return true;
   }

   public void paint( Graphics g )
   {  g.drawRect( topX, topY, width, height );  }
}
