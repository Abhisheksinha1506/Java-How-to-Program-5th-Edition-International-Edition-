// Exercise 3.11 Solution
// Graphs.java
// Program prints histograms

import java.applet.Applet;
import java.awt.*;

public class Graphs extends Applet {
   TextField input;
   Label inputLabel;
   boolean enablePaint;
   int count, num1, num2, num3;
   int num4, num5, temp;

   public void init()
   {
      count = 0;
      input = new TextField( 4 );
      inputLabel = new Label( "Enter number:" );
      add( inputLabel );
      add( input );
   }

   public boolean action( Event e, Object o )
   {
      enablePaint = false;

      if ( e.target == input ) {
         temp = Integer.parseInt( input.getText() );

         if ( temp >= 1 && temp <= 30 ) {
            ++count;
            showStatus( "Entry number " + String.valueOf( count ) );

            switch ( count ) {
               case 1:
                  num1 = temp;
                  break;
               case 2:
                  num2 = temp;
                  break;
               case 3:
                  num3 = temp;
                  break;
               case 4:
                  num4 = temp;
                  break;
               case 5:
                  num5 = temp;
                  break;
            }

            if ( count == 5 ) 
               enablePaint = true;
         }
         else
            showStatus( "Number must be between 1 and 30!" );

         repaint();
      }

      return true;
   }

   public void paint( Graphics g )
   {
      if ( enablePaint == true ) {
         int z, x, y = 0, value = 0;

         for ( ; count > 0; count-- ) {
            x = 5;

            switch ( count ) {
               case 1:
                  y = 50;
                  value = num1;
                  break;
               case 2:
                  y = 60;
                  value = num2;
                  break;
               case 3:
                  y = 70;
                  value = num3;
                  break;
               case 4:
                  y = 80;
                  value = num4;
                  break;
               case 5:
                  y = 90;
                  value = num5;
                  break;
            }

            for ( z = 1; z <= value; z++ )
                g.drawString( "*", x += 5, y );
         }
      }
   }
}
