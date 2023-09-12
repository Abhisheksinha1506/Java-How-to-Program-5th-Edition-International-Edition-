// Fig. 9.9: ShowColors3.java
// Using a predefined static Color object to set the color 
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

public class ShowColors3 extends Applet {
   private Color c;

   public void init()
   {
      c = Color.blue;
   }

   public void paint( Graphics g )
   {
      g.setColor( c );
      g.drawString( "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 50, 33 );
      showStatus( "Current RGB: " +
                  String.valueOf( c.getRed() ) +
                  "  " + String.valueOf( c.getGreen() ) + 
                  "  " + String.valueOf( c.getBlue() ) );
   } 
}
