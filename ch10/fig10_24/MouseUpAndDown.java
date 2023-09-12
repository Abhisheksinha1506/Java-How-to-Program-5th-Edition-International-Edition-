// Fig. 10.24: MouseUpAndDown.java
// Demonstrating methods mouseUp and mouseDown.
import java.applet.Applet;
import java.awt.*;

public class MouseUpAndDown extends Applet {    
   private int xUp, yUp;     
   private boolean first;
   private Font f;

   public void init()
   {
      // disable statements in paint initially
      first = true;

      f = new Font( "TimesRoman", Font.BOLD, 14 );
   }

   public void paint( Graphics g )
   {
      // these statements will not execute
      // on the first call to paint
      if ( first == false ) {
         String s = "MouseUp at ";
         g.setFont( f );
         s += "(" + xUp + ", " + yUp + ")!";
         g.drawString( s, xUp, yUp );
      }
   }

   public boolean mouseDown( Event e, int x, int y )
   {
      showStatus( "mouseDown at (" + x + ", " + y + ")" );
      return true;   // event has been handled
   }

   public boolean mouseUp( Event e, int x, int y )
   {
      first = false;  // enable statements in paint
      xUp = x;
      yUp = y;
      repaint();
      return true;   // event has been handled
   }
}
