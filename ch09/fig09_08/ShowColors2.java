// Fig. 9.8: ShowColors2.java
// Demonstrating the Color constructor with float arguments
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

public class ShowColors2 extends Applet {
   private float red, green, blue;

   public void init()
   {
      red = 0.1f;
      green = 0.21f;
      blue = 0.33f;
   }

   public void paint( Graphics g )
   {           
       g.setColor( new Color( red, green, blue ) );
       g.drawString( "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 60, 33 );
       showStatus( "Current RGB: " + g.getColor().toString() );
   }
}
