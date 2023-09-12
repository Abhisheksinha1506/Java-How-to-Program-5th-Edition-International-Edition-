// Exercise 1.19 Solution
// Larger.java
// Program determines the larger of two numbers

import java.applet.Applet;
import java.awt.*;

public class Larger extends Applet {
   TextField first, second;
   Label firstLabel, secondLabel;
   int number1, number2;

   public void init()
   {
      first = new TextField( 5 );
      second = new TextField( 5 );     
      firstLabel = new Label( "Enter first number: " );
      secondLabel = new Label( "Enter second number: " );
      add( firstLabel );
      add( first );
      add( secondLabel );
      add( second );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == second ) {
         number1 = Integer.parseInt( first.getText() );
         number2 = Integer.parseInt( second.getText() );         

         if ( number1 > number2 ) 
            showStatus( number1 + " is larger." );
         else if ( number1 < number2 )
            showStatus( number2 + " is larger." );
         else
            showStatus( "These numbers are equal." );         
      }

      return true;
   }
}
