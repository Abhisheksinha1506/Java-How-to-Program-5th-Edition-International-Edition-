// Exercise 4.27 Solution
// Reverse.java
// Program takes a four digit number
// and prints out its digits reversed

import java.applet.Applet;
import java.awt.*;

public class Reverse extends Applet {
   TextField input;
   Label prompt;
   int number;

   public void init()
   {
      input = new TextField( 4 );
      prompt = new Label( "Enter a four digit number: " );
      add( prompt );
      add( input );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == input ) {
         number = Integer.parseInt( input.getText() );
         reverseDigits();
      }

      return true;
   }

   public void reverseDigits()
   {
      int digit1 = 0, digit2 = 0, digit3 = 0,
          digit4 = 0, factor = 1000, value = 0;

      while ( factor >= 1 ) {
         int temp = number / factor;

         switch ( factor ) {
            case 1000:
               digit4 = temp;
               break;
            case 100:
               digit3 = temp * 10;
               break;
            case 10:
               digit2 = temp * 100;
               break;
            case 1:
               digit1 = temp * 1000;
               break;
         }

         number %= factor;
         factor /= 10;         
      }

      if ( digit1 == 0 )  // special case when last digit initially is 0
         showStatus( String.valueOf( 0 ) + String.valueOf( digit2 / 100 )
                     + String.valueOf( digit3 / 10 ) +
                     String.valueOf( digit4 ) );
      else
         showStatus( String.valueOf(digit1 + digit2 + digit3 + digit4) );   
   }
}
