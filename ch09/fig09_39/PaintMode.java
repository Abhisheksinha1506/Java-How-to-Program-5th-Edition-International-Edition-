// Fig. 9.39: PaintMode.java
// Demonstrating the XOR paint mode
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

public class PaintMode extends Applet {

   public void paint( Graphics g )
   {
      // draw pink oval
      g.setColor( Color.pink );        
      g.fillOval( 20, 10, 100, 50 );

      // draw a yellow rectangle over part of the oval
      g.setColor( Color.yellow );
      g.fillRect( 100, 10, 100, 50 );

      // draw an orange rectangle
      g.setColor( Color.orange );
      g.fillRect( 190, 10, 80, 50 );

      // set XOR mode to yellow
      g.setXORMode( Color.yellow );
      g.fillOval( 180, 25, 60, 20 );

      // draw a blue arc
      g.setColor( Color.blue );
      g.fillArc( 150, 20, 20, 20, 0, 360 );

      // draw a red square
      g.setColor( Color.red );
      g.fillRect( 120, 25, 20, 20 );
   } 
}
