// Exercise 4.18 Solution
// Square.java
// Program draws a square of asterisks

import java.applet.Applet;
import java.awt.*;

public class Square extends Applet {
   TextField input;
   Label inputLabel;
   boolean enabled;
   int size;

   public void init()
   {
      input = new TextField( 4 );
      inputLabel = new Label( "Enter square size:" );
      add( inputLabel );
      add( input );
   }

   public boolean action( Event e, Object o )
   {
      enabled = false;

      if ( e.target == input ) {
         size = Integer.parseInt( input.getText() );
         enabled = true;
      }

      repaint();
      return true;
   }

   public void squareOfAsterisks( Graphics g )
   {
      int y = 50, x = 5;

      for ( int a = 1; a <= size * size; a++ ) {
         g.drawString( "*", x += 5, y );

         if ( a % size == 0 ) {
            y += 10;
            x = 5;
         }         
      }
   }

   public void paint( Graphics g )
   {
      squareOfAsterisks( g );
   }
}
