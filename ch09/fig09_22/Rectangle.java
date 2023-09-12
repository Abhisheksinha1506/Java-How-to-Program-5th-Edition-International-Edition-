// Fig. 9.22: Rectangle.java
// Demonstrating drawRect and fillRect
import java.applet.Applet;
import java.awt.Graphics;

public class Rectangle extends Applet {

   public void paint( Graphics g )
   {
      // draw a rectangle at location ( 10, 15 )
      g.drawRect( 10, 15, 100, 100 );

      // draw a filled rectangle at location ( 150, 15 )
      g.fillRect( 150, 15, 100, 100 );
   }
}
