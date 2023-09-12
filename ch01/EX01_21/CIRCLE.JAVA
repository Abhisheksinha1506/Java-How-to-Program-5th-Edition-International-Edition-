// Exercise 1.21 Solution
// Circle.java
// Program calculate the area, circumference,
// and diameter for a circle

import java.applet.Applet;
import java.awt.*;

public class Circle extends Applet {
   TextField input;
   Label inputLabel;
   int radius;

   public void init()
   {
      input = new TextField( 5 );
      inputLabel = new Label( "Enter radius: " );
      add( inputLabel );
      add( input );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == input ) {
         radius = Integer.parseInt( input.getText() );
         repaint();
      }

      return true;
   }

   public void paint( Graphics g )
   {
      // Math.PI is a Math class constant with a value of 3.14159
      g.drawString( "Diameter is " + ( 2 * radius ), 5, 50 );
      g.drawString( "Area is " +
                    ( Math.PI * radius * radius ), 5, 60 );
      g.drawString( "Circumference is " +
                    ( 2 * Math.PI * radius ), 5, 70 );
   }
}
