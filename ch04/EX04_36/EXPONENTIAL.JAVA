// Exercise 4.36 Solution
// Exponential.java
// Program calculates exponents

import java.applet.Applet;
import java.awt.*;

public class Exponential extends Applet {
   TextField baseInput, expInput;
   Label basePrompt, expPrompt;

   public void init()
   {
      baseInput = new TextField( 4 );
      expInput = new TextField( 4 );
      basePrompt = new Label( "Enter base: " );
      expPrompt = new Label( "Enter exponent: " );
      add( basePrompt );
      add( baseInput );
      add( expPrompt );
      add( expInput );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == expInput ) {
         int base, exponent;

         base = Integer.parseInt( baseInput.getText() );
         exponent = Integer.parseInt( expInput.getText() );

         if ( exponent > 0 ) {
            int result = power( base, exponent );
            showStatus( "Value is " + String.valueOf( result ) );
         }
         else
            showStatus( "Invalid Exponent." );
      }

      return true;
   }

   public int power( int b, int exp )
   {
      if ( exp == 1 )
         return b;
      else
         return b * power( b, exp - 1 );
   }
}
