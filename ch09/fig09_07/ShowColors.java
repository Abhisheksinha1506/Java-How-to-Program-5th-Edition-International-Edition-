// Fig. 9.7: ShowColors.java
// Demonstrating setting and getting a Color.
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

public class ShowColors extends Applet {
   private int red, green, blue;

   public void init()
   {
      // set some values
      red = 100;
      blue = 255;
      green = 125;
   }

   public void paint ( Graphics g )
   {
      g.setColor( new Color( red, green, blue ) );
      g.drawString( "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 50, 33 );
      showStatus( "Current RGB: " + g.getColor().toString() );
   } 
}
